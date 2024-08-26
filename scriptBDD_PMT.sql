CREATE DATABASE IF NOT EXISTS pmt;
USE pmt;

CREATE TABLE utilisateur (
  id BIGINT UNIQUE,
  nom VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE projet (
    id BIGINT UNIQUE,
    nom VARCHAR(255),
    description VARCHAR(1000),
    date_debut DATE,
    id_administrateur BIGINT
);

CREATE TABLE projet_utilisateur_role (
    id BIGINT,
    projet_id BIGINT,
    role_id BIGINT,
    utilisateur_id BIGINT
);

CREATE TABLE role (
    id BIGINT UNIQUE,
    nom VARCHAR(255)
);

CREATE TABLE tache (
    id BIGINT UNIQUE,
    nom VARCHAR(255),
    description VARCHAR(1000),
    date_echeance DATE,
    priorite VARCHAR(20),
    utilisateur_id BIGINT,
    status VARCHAR(255)
);

CREATE TABLE projet_taches (
    projet_id BIGINT,
    taches_id BIGINT
);

CREATE TABLE historique (
    id BIGINT UNIQUE,
    nom VARCHAR(255),
    description VARCHAR(1000),
    date_echeance DATE,
    priorite VARCHAR(20),
    id_utilisateur_modificateur BIGINT,
    id_tache BIGINT,
    status VARCHAR(255)
);

INSERT INTO utilisateur (id, nom, email, password) VALUES (1000, "Pierre", "pierre@pmt.com", "1234"), (2000, "Paul", "paul@pmt.com", "1234"), (3000, "Jacques", "jacques@pmt.com", "1234");

INSERT INTO projet (id, nom, description, date_debut, id_administrateur) VALUES (1000, "PMT", "Projet PMT pour l'etude de cas", '2024/08/21', 1000), (2000, "Ikea", "Projet pour le site d'Ikea", '2024/08/21', 2000);

INSERT INTO projet_utilisateur_role (id, projet_id, role_id, utilisateur_id) VALUES (1000, 1000, 1000, 2000), (2000, 1000, 2000, 3000), (3000, 2000, 1000, 1000), (4000, 2000, 2000, 3000);

INSERT INTO role (id, nom) VALUES (1000, "Membre"), (2000, "Observateur");

INSERT INTO tache (id, nom, description, date_echeance, priorite, utilisateur_id, status) VALUES 
(1000, "Connexion/Inscription Front", "Faire la page de connexion et d'inscription en angular", '2024/08/30', "HAUTE", 2000, "Crée"), 
(2000, "Connexion/Inscription Back", "Faire la page de connexion et d'inscription en java", '2024/08/30', "HAUTE", 2000, "Crée"), 
(3000, "Creer projet Front", "Faire la page pour creer un nouveau projet en angular", '2024/08/28', "BASSE", 3000, "En cours"), 
(4000, "Creer projet Back", "Faire la page pour creer un nouveau projet en java", '2024/08/28', "BASSE", 3000, "En cours"), 
(5000, "Connexion/Inscription Front", "Faire la page de connexion et d'inscription en angular", '2024/09/30', "HAUTE", 1000, "Crée"), 
(6000, "Connexion/Inscription Back", "Faire la page de connexion et d'inscription en java", '2024/09/30', "HAUTE", 3000, "Crée");

INSERT INTO projet_taches (projet_id, taches_id) VALUES (1000, 1000), (1000, 2000), (1000, 3000), (2000, 4000), (2000, 5000), (2000, 6000);

INSERT INTO historique (id, nom, description, date_echeance, priorite, id_utilisateur_modificateur, id_tache, status) VALUES 
(1000, "Connexion Front", "Faire la page de connexion en angular", '2024/08/30', "HAUTE", 2000, 1000, "Crée"), 
(2000, "Creer projet Back", "Faire la page pour creer un nouveau projet en java", '2024/10/28', "BASSE", 3000, 4000, "En cours"), 
(3000, "Inscription Back", "Faire la page d'inscription en java", '2024/09/30', "HAUTE", 3000, 6000, "Crée");