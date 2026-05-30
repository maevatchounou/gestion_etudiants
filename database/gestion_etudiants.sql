CREATE DATABASE gestion_etudiants;
USE gestion_etudiants;
CREATE TABLE etudiant(
id_etudiant INT PRIMARY KEY AUTO_INCREMENT,
matricule VARCHAR(30) UNIQUE NOT NULL,
nom VARCHAR(100) NOT NULL,
prenom VARCHAR(100) NOT NULL,
telephone VARCHAR(20),
email VARCHAR(100));

SHOW TABLES;