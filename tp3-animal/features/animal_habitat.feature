Feature: Animal et Habitat
  En tant que système
  Je veux décrire et tester les comportements Animal/Habitat
  Afin de valider les user stories via des scénarios exécutables

  Scenario: Associer un animal à un habitat coûte de l'énergie
    Given un animal "Lion" avec 100 d'énergie
    And un habitat "Savanna"
    When l'animal se déplace vers son habitat
    Then l'animal vit dans "Savanna"
    And l'énergie de l'animal est 90

  Scenario: Besoin quotidien en énergie dépend de l'habitat
    Given un animal "Lion" avec 100 d'énergie
    And l'animal vit dans "Desert"
    When l'animal calcule ses besoins journaliers
    Then le besoin journalier est 40

  Scenario: Un animal sans habitat a un besoin par défaut
    Given un animal "Panda" avec 80 d'énergie
    When l'animal calcule ses besoins journaliers
    Then le besoin journalier est 20
