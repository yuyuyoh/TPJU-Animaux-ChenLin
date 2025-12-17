# 🐱 Projet Écosystème Animalier

**Équipe :** CHEN Yuxuan & LIN Hongxiang  
**Contexte académique :** Module Agilité - Travaux pratiques sur les tests unitaires

Cette application Java simule un écosystème où des animaux interagissent avec leur environnement. Elle met en pratique les concepts de **Programmation Orientée Objet (POO)** et prépare le terrain pour des **tests unitaires automatisés**.

---

## 🎯 Objectif du Projet

Le système gère l'état vital des animaux et leur localisation. Contrairement à une simple base de données, il intègre des **règles métier** basées sur les fichiers `Animal.java` et `Habitat.java`, comme le coût énergétique des actions et les besoins de survie selon le milieu.

### Capacités offertes :
* **Cycle de vie :** Gestion du vieillissement (`age`) et de la dépense énergétique associée.
* **Dynamique environnementale :** Déplacement entre différents habitats avec un coût de 10 unités d'énergie.
* **Calcul de survie :** Évaluation des besoins quotidiens basés spécifiquement sur le type d'habitat.
* **Robustesse :** Protection contre les données invalides via des exceptions (ex: `IllegalArgumentException` pour les quantités alimentaires négatives).

---

## 🏗 Structure des Classes

### 1. Classe `Animal`
C'est le moteur de la simulation. Elle contient l'état de santé et la logique comportementale.
* **Attributs :**
    * `name` (String) : Identifiant de l'animal.
    * `energy` (int) : Niveau vital nécessaire pour agir.
    * `age` (int) : Initialisé à 0, il augmente avec le temps.
    * `habitat` (Habitat) : Référence vers l'environnement actuel.
* **Méthodes clés :**
    * `eat(int amount)` : Augmente l'énergie.
    * `growOld()` : Augmente l'âge et consomme **5 unités d'énergie**.
    * `moveTo(Habitat h)` : Change d'habitat au prix de **10 unités d'énergie** si `energy >= 10`.
    * `calculateDailyNeeds()` : Détermine l'énergie requise selon le type (`Desert`, `Forest`, `Savanna`).

### 2. Classe `Habitat`
Modélise le contexte environnemental.
* **Attributs :**
    * `type` (String) : Catégorie de l'habitat.
* **Méthodes :**
    * `getType()` : Utilisé par l'animal pour ajuster sa consommation d'énergie.
    * `toString()` : Retourne le type pour l'affichage textuel.

---

## 🔄 Logique de Simulation & Règles Métier

Le comportement des objets suit des règles précises pour simuler la survie :

#### **Gestion de l'Énergie**
| Action | Impact Énergétique | Condition de réussite |
| :--- | :--- | :--- |
| **Manger (`eat`)** | `+ amount` | `amount >= 0` |
| **Vieillir (`growOld`)** | `- 5` | Toujours possible (minimum 0) |
| **Se déplacer (`moveTo`)** | `- 10` | `energy >= 10` |

#### **Calcul des besoins quotidiens (`calculateDailyNeeds`)**
La survie est plus ou moins difficile selon le milieu :
* **Sans habitat** : 20 unités.
* **En Forêt (`Forest`)** : 25 unités.
* **En Savane (`Savanna`)** : 30 unités.
* **En Désert (`Desert`)** : 40 unités.

---

## 🧪 Plan de Validation (JUnit)

La robustesse du code peut être vérifiée par les scénarios suivants basés sur les méthodes implémentées :

| Cas de Test | Objectif | Résultat attendu |
| :--- | :--- | :--- |
| **Initialisation** | Vérifier l'état post-construction. | `age` = 0, `habitat` = `null`. |
| **Alimentation** | Vérifier l'ajout d'énergie. | L'énergie augmente du montant spécifié. |
| **Nutrition invalide** | Tester une entrée négative. | Lancement d'une `IllegalArgumentException`. |
| **Déplacement** | Valider le coût du mouvement. | Habitat mis à jour et énergie réduite de 10. |
| **Description** | Tester la méthode `describe()`. | Chaîne incluant le nom, l'énergie et l'habitat. |

---

## 🖥 Guide d'Utilisation BlueJ

1. **Génération visuelle** : Faites un clic droit sur les classes pour créer des instances (ex: `new Animal("Simba", 50)`).
2. **Liaison d'objets** : Pour la méthode `moveTo(Habitat h)`, cliquez sur l'instance de l'habitat présente sur l'établi d'objets.
3. **Inspection** : Utilisez l'inspecteur pour voir l'évolution de l'attribut `energy` après avoir appelé `growOld()` ou `eat()`.

> **Rappel technique :** Les types `String` dans BlueJ doivent être saisis entre guillemets (ex: `"Forest"`).
