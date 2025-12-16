# 🐱 Projet Écosystème Animalier

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


