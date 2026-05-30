# Gestion des Étudiants

Application console en Java permettant de gérer une liste d'étudiants via une base de données MySQL, en utilisant JDBC.

## Fonctionnalités

- Ajouter un étudiant
- Lister tous les étudiants
- Rechercher un étudiant par matricule ou par nom
- Modifier le téléphone ou l'email d'un étudiant
- Supprimer un étudiant
- Afficher le nombre total d'étudiants

## Prérequis

- Java 21+
- Maven 3.6+
- MySQL 8+

## Installation

### 1. Cloner le dépôt

```bash
git clone https://github.com/maevatchounou/gestion_etudiants.git
cd gestion_etudiants
```

### 2. Créer la base de données

Exécutez le script SQL fourni dans votre client MySQL :

```bash
mysql -u root -p < database/gestion_etudiants.sql
```

### 3. Configurer la connexion

Editez `src/main/java/com/dess/app/gestion_etudiants/config/DBConnection.java` :

```
USER=votre_utilisateur
PASSWORD=votre_mot_de_passe
```

### 4. Compiler et lancer

```bash
mvn compile
mvn exec:java
```

## Structure du projet

```
gestion_etudiants/
├── database/
│   └── schema.sql                  # Script de création de la base
├── src/
│   └── main/
│        └──java/com/dess/app/gestion_etudiants/
│           ├── config/
│           │   └── DBConnection.java
│           ├── model/
│           │   └── Etudiant.java
│           ├── dao/
│           │   └── EtudiantDAO.java
│           └── Main.java
├── pom.xml
└── README.md
```

## Technologies utilisées

- Java 21
- JDBC (MySQL Connector/J 9.6.0)
- Maven
