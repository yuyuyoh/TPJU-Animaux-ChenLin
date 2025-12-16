# 🐱 Projet Écosystème Animalier


**Équipe :** CHEN Yuxuan & LIN Hongxiang  
**Contexte académique :**  - Module Agilité - Travaux pratiques sur les tests unitaires

Cette application Java a été développée pour enseigner les principes de base de la **Programmation Orientée Objet (POO)** et des **tests unitaires automatisés**. Elle représente un écosystème virtuel où des animaux interagissent avec leur environnement.

Conçu spécifiquement pour **BlueJ**, ce projet favorise l'apprentissage expérientiel grâce à la manipulation directe d'objets et à la visualisation immédiate des effets des opérations.

---

## 🎯 Objectif du Projet

Le système repose sur l'interaction entre deux entités principales : les animaux et leurs habitats. Il permet d'explorer divers mécanismes orientés objet à travers des simulations biologiques réalistes.

### Capacités offertes :
* **Représentation d'entités :** Génération dynamique d'animaux et de leurs milieux de vie.
* **Simulation comportementale :** Gestion des besoins énergétiques via l'alimentation.
* **Contrôle d'intégrité :** Validation des données d'entrée (valeurs négatives interdites).
* **Connexion inter-classes :** Établissement de relations entre un animal et son habitat.
* **Fonctionnalités collaboratives :** Méthodes exploitant simultanément les propriétés des deux types d'objets.

---

## 🏗 Structure des Classes

### 1. Classe `Animal` (Classe fétiche)
Cette classe constitue le cœur de l'application.
* **Caractéristiques :**
    * `nom` (String) : Désignation de l'animal.
    * `energie` (int) : Niveau vital, défini à l'initialisation.
    * `habitat` (Habitat) : Référence optionnelle vers l'environnement (relation 0..1).
* **Fonctions principales :**
    * `seNourrir(int quantite)` : Augmente le niveau d'énergie. Génère une exception si `quantite < 0`.
    * `definirHabitat(Habitat h)` : Établit la connexion avec un habitat.
    * `obtenirDescription()` : Produit un résumé textuel incluant l'état et le milieu.

### 2. Classe `Habitat`
Modélise le contexte environnemental.
* **Caractéristiques :**
    * `type` (String) : Catégorie d'habitat (ex: "Savane", "Forêt tropicale").
* **Fonction essentielle :**
    * `obtenirType()` : Renvoie la classification de l'habitat.
### 🔄 Logique de Simulation

Le comportement des objets suit des règles métier précises :

#### **Gestion de l'énergie :**
- **Alimentation** : `eat(int amount)` → `énergie = énergie + quantité`
  - Contrainte : `quantité ≥ 0` (sinon `IllegalArgumentException`)
- **Modification directe** : `setEnergy(int value)` permet un ajustement manuel

#### **Gestion des habitats :**
- **Association** : `moveTo(Habitat h)` ou `setHabitat(Habitat h)` → `habitat = h`
- **Désassociation** : `leaveHabitat()` → `habitat = null`
- **Vérification** : `hasHabitat()` retourne `true` si `habitat ≠ null`

#### **Génération de descriptions :**

La méthode `describe()` implémente une logique conditionnelle qui produit une description textuelle différenciée selon l'état de l'animal, en particulier sa relation avec un habitat.


---

## 🔄 Relations Inter-classes

L'implémentation établit une **connexion unidirectionnelle** respectant une cardinalité **0..1 à 0..1**.
* L'`Animal` maintient une référence vers son `Habitat` via l'attribut `habitat`.
* L'`Habitat` n'enregistre pas d'information sur l'animal, préservant le caractère unidirectionnel.
* La cardinalité est strictement appliquée : un animal possède **zéro ou un** habitat ; un habitat héberge **zéro ou un** animal dans ce modèle simplifié.

---

## 🧪 Validation par Tests Unitaires (JUnit) - À implémenter

La robustesse du code sera vérifiée via la classe `TestsAnimal`. Une méthode `preparer()` (@Before) initialisera un contexte de test reproductible (un animal "Lion" et un habitat "Savane").

| Cas de Test | Objectif | Comportement attendu |
| :--- | :--- | :--- |
| **Initialisation** | Contrôler l'état post-construction. | Énergie conforme, Habitat à `null`. |
| **Nutrition** | Vérifier l'effet de l'alimentation. | 50 + 20 = 70 unités d'énergie. |
| **Nutrition invalide** | Tester une entrée négative (-5). | Exception `IllegalArgumentException`. |
| **Liaison Habitat** | Valider l'association via `definirHabitat()`. | Description mentionne l'habitat. |
| **Description isolée** | Décrire un animal sans habitat. | Message "est sans habitat attitré". |

---

## 🖥 Guide d'Utilisation BlueJ

Le projet tire parti des spécificités de BlueJ pour :
1.  **Génération visuelle** : Menu contextuel → `nouvel Animal("Lion", 100)`.
2.  **Inspection en direct** : Visualisation des attributs et références.
3.  **Exécution pas à pas** : Appel graphique de méthodes comme `seNourrir(30)`.
4.  **Validation continue** : Les classes sans motif hachuré indiquent une compilation réussie.

> **Remarque pédagogique :** Dans BlueJ, les paramètres de type `String` doivent impérativement être **saisis entre guillemets** (ex: `"Savane"`). L'omission des guillemets provoque une erreur d'interprétation.

---

## 🚧 Perspectives d'Évolution

1.  **Relation bidirectionnelle** : Étendre le modèle pour que l'Habitat référence ses habitants (0..1 à *).
2.  **Restructuration** : Appliquer des techniques de refactoring (`Renommer`, `ExtraireMethode`).
3.  **Tests avancés** : Automatisation en ligne de commande et exploration des bonnes pratiques JUnit.



