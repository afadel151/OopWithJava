# TP03 COO en Java : Interfaces et Principes SOLID

## 1. Introduction
Dans ce TP, vous apprendrez à utiliser les interfaces en Java et à appliquer les principes SOLID pour concevoir un système modulaire, évolutif et maintenable.

## 2. Objectifs pédagogiques
- Maîtriser la création et l’utilisation des interfaces en Java.
- Comprendre et appliquer chaque principe SOLID.
- Concevoir des composants découplés et testables.

## 3. Rappel des principes SOLID
1. **SRP** : Responsabilité unique.
2. **OCP** : Ouvert à l’extension, fermé à la modification.
3. **LSP** : Substitutionalité.
4. **ISP** : Ségrégation d’interfaces.
5. **DIP** : Inversion de dépendance.

## 4. Les interfaces en Java
Une interface déclare un contrat :

```java
public interface MonInterface {
    void action();
}
```

Implémentation :

```java
public class MaClasse implements MonInterface {
    @Override
    public void action() {
        // implémentation
    }
}
```

---

## 5. Exercice 1 : Système de Paiement en Ligne
Modéliser un gestionnaire de paiement acceptant plusieurs moyens sans modification du gestionnaire.

### Étape 1 – Interface de base
**Question 1.1** : Définissez l’interface `PaymentProcessor` avec la méthode `void pay(double amount);`

```java
public interface PaymentProcessor {
    void pay(double amount);
}
```

**Question 1.2** : Expliquez en quoi cette interface respecte le principe DIP.

### Étape 2 – Implémentations
Créez les classes suivantes implémentant `PaymentProcessor` :
- `CreditCardProcessor`
- `PayPalProcessor`
- `CryptoProcessor`

**Question 2.1** : Écrivez le squelette de chaque classe et complétez la méthode `pay`.  
**Question 2.2** : Justifiez comment LSP est respecté.

### Étape 3 – Gestionnaire de paiement (DIP)
Implémentez `PaymentManager` :

```java
public class PaymentManager {
    private final PaymentProcessor processor;
    public PaymentManager(PaymentProcessor processor) {
        this.processor = processor;
    }
    public void processPayment(double amount) {
        processor.pay(amount);
    }
}
```

**Question 3.1** : Pourquoi l’injection par constructeur améliore-t-elle la testabilité ?

### Étape 4 – Extension (OCP)
Ajoutez `MobilePayProcessor` sans modifier `PaymentManager`.

**Question 4.1** : Montrez le code de `MobilePayProcessor` et expliquez comment OCP est respecté.

### Étape 5 – Ségrégation d’interface (ISP)
Certains moyens nécessitent une authentification :

```java
public interface SecurePayment extends PaymentProcessor {
    void authenticate();
}
```

**Question 5.1** : Créez également `QuickPayment` pour les paiements sans authentification.  
**Question 5.2** : Expliquez l’intérêt de la ségrégation d’interface.

### Étape 6 – Substitution de Liskov (LSP)
**Question 6.1** : Proposez un cas de test pour vérifier que `CreditCardProcessor` peut remplacer `PaymentProcessor` sans erreur.  
**Question 6.2** : Pourquoi LSP est-il critique dans ce contexte ?

---

## 6. Situations de test
Effectuez les tests suivants (JUnit ou assertions simples) :
- Paiement CB : `new PaymentManager(new CreditCardProcessor()).processPayment(99.99);`
- Paiement PayPal : `new PaymentManager(new PayPalProcessor()).processPayment(49.50);`
- Paiement Crypto : `new PaymentManager(new CryptoProcessor()).processPayment(0.005);`
- Paiement Mobile : `new PaymentManager(new MobilePayProcessor()).processPayment(20.00);`
- Exception pour appel de `authenticate()` sur `QuickPayment`.
- Fabrication via une classe `PaymentFactory` et test de type inconnu.

---

## 7. Exercice 2 : Gestion d’Inventaire
Modéliser un inventaire gérant produits physiques, numériques et services.

### Étape 1 – Interface de base
Définissez `InventoryItem` :

```java
public interface InventoryItem {
    String getId();
    String getDescription();
}
```

**Question 1.1** : Expliquez le rôle de cette abstraction.

### Étape 2 – Implémentations
Créez :
- `PhysicalItem` (quantité en stock)
- `DigitalItem` (licences)
- `ServiceItem` (réservations)

**Question 2.1** : Écrivez le squelette de chaque classe.  
**Question 2.2** : Décrivez comment SRP et LSP s’appliquent.

### Étape 3 – Gestionnaire d’inventaire (DIP)
Implémentez `InventoryManager` prenant `List<InventoryItem>` :

```java
public class InventoryManager {
    private final List<InventoryItem> items;
    public InventoryManager(List<InventoryItem> items) {
        this.items = items;
    }
    public void addItem(InventoryItem item) { items.add(item); }
    public void listItems() { 
        items.forEach(i -> System.out.println(i.getId() + ": " + i.getDescription())); 
    }
}
```

**Question 3.1** : Comment DIP facilite-t-il l’extension ?

### Étape 4 – Extension (OCP)
Ajoutez `BundleItem` regroupant plusieurs `InventoryItem` sans modifier `InventoryManager`.

**Question 4.1** : Présentez le code de `BundleItem` et justifiez OCP.

### Étape 5 – Ségrégation d’interface (ISP)
Créez `Stockable` :

```java
public interface Stockable extends InventoryItem {
    int getQuantity();
    void deduct(int amount);
}
```

**Question 5.1** : Quels items implémentent `Stockable` ?

### Étape 6 – Substitution de Liskov (LSP)
**Question 6.1** : Proposez un test pour vérifier la substituabilité d’un `PhysicalItem`.  
**Question 6.2** : Pourquoi LSP garantit-il la fiabilité du gestionnaire ?

---

### Situations de test
- Ajout et listing de `PhysicalItem`, `DigitalItem`, `ServiceItem`.
- Test de téléchargement/licence pour `DigitalItem`.
- Réservation pour `ServiceItem`.
- Usage de `BundleItem` pour grouper et lister plusieurs items.
- Déduction de stock via `Stockable` et gestion des exceptions.
- Injection de différentes listes d’items dans `InventoryManager`.