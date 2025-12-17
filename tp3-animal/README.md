# TP3 — Scénario agile intégré (Animal / Habitat)

Ce dépôt illustre un scénario agile **intégré** (User Stories → tests exécutables → code → exécution automatique → archivage Git).

- Langage : Python
- Tests : pytest
- Domaine : Animal / Habitat (exemple évolutif)

---

## 1) Pré-requis

- Python **3.11+**
- VSCode (recommandé)

---

## 2) Structure du projet

```text
.
├── src/
│   ├── animal.py
│   └── habitat.py
├── tests/
│   ├── test_us01_basic_animal.py
│   ├── test_us02_habitat_daily_needs.py
│   └── test_us03_survival_and_move.py
├── USER_STORIES.md
└── README.md
```

---

## 3) Installation (environnement virtuel)

### macOS / Linux

```bash
python -m venv .venv
source .venv/bin/activate
pip install -U pip
pip install pytest
```

### Windows (PowerShell)

```powershell
python -m venv .venv
.\.venv\Scripts\Activate.ps1
python -m pip install -U pip
pip install pytest
```

---

## 4) Exécuter les tests automatiquement

Depuis la racine du projet :

```bash
pytest -q
```

Optionnel (sortie plus détaillée) :

```bash
pytest -vv
```

---

## 5) User Stories → Tests (traçabilité)

Les **User Stories** et leurs **critères d’acceptation** sont décrits dans :

- `USER_STORIES.md`

Chaque critère d’acceptation est couvert par des tests exécutables dans :

- `tests/test_us01_basic_animal.py`
- `tests/test_us02_habitat_daily_needs.py`
- `tests/test_us03_survival_and_move.py`

---

## 6) Règles de contribution (mode agile)

- Implémenter une User Story par petites étapes.
- Écrire/mettre à jour les tests avant ou pendant l’implémentation.
- Garder la suite de tests **verte** (aucune régression).

---

## 7) Archivage Git (recommandé)

Exemple de cycle minimal :

```bash
git init
git add .
git commit -m "init: structure + US + tests"

# Après US01
pytest -q
git add .
git commit -m "US01: animal basic actions + tests"

git tag v0.1-us01

# Après US02
pytest -q
git add .
git commit -m "US02: daily needs by habitat + tests"

git tag v0.2-us02

# Après US03
pytest -q
git add .
git commit -m "US03: move + survival + tests"

git tag v0.3-us03
```

---

## 8) Dépannage

- **`pytest: command not found`**
  - Vérifier que l’environnement virtuel est activé (`source .venv/bin/activate` ou `Activate.ps1`).

- **ImportError sur `src.*`**
  - Lancer `pytest` depuis la **racine** du projet.

