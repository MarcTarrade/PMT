CREATE DATABASE IF NOT EXISTS pmt;
USE pmt;

CREATE TABLE utilisateur (
  id BIGINT,
  nom VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255)
);

CREATE TABLE projet (
    id BIGINT,
    nom VARCHAR(255),
    description VARCHAR(1000),
    dateDebut DATE,
    id_administrateur BIGINT
);

CREATE TABLE projet_utilisateur (
    id BIGINT,
    id_utilisateur BIGINT,
    id_projet BIGINT,
    role VARCHAR(20)
);

CREATE TABLE tache (
    id BIGINT,
    nom VARCHAR(255),
    description VARCHAR(1000),
    dateEcheance DATE,
    priorite VARCHAR(20),
    id_utilisateur BIGINT,
    id_projet BIGINT,
    status VARCHAR(255)
);

CREATE TABLE historique (
    id BIGINT,
    nom VARCHAR(255),
    description VARCHAR(1000),
    dateEcheance DATE,
    priorite VARCHAR(20),
    id_utilisateur_modificateur BIGINT,
    id_tache BIGINT,
    status VARCHAR(255)
);

INSERT INTO utilisateur (id, nom, email, password) VALUES (1, "Pierre", "pierre@pmt.com", "1234"), (2, "Paul", "paul@pmt.com", "1234"), (3, "Jacques", "jacques@pmt.com", "1234");

INSERT INTO projet (id, nom, description, dateDebut, id_administrateur) VALUES (1, "PMT", "Projet PMT pour l'etude de cas", '2024/08/21', 1), (2, "Ikea", "Projet pour le site d'Ikea", '2024/08/21', 2);

INSERT INTO projet_utilisateur (id, id_utilisateur, id_projet, role) VALUES (1, 1, 1, "Administrateur"), (2, 2, 1, "Membre"), (3, 3, 1, "Observateur"), (4, 2, 2, "Administrateur"), (5, 1, 2, "Observateur"), (6, 3, 2, "Membre");

INSERT INTO tache (id, nom, description, dateEcheance, priorite, id_utilisateur, id_projet, status) VALUES 
(1, "Connexion/Inscription Front", "Faire la page de connexion et d'inscription en angular", '2024/08/30', "HAUTE", 2, 1, "Crée"), 
(2, "Connexion/Inscription Back", "Faire la page de connexion et d'inscription en java", '2024/08/30', "HAUTE", 2, 1, "Crée"), 
(3, "Creer projet Front", "Faire la page pour creer un nouveau projet en angular", '2024/08/28', "BASSE", 3, 1, "En cours"), 
(4, "Creer projet Back", "Faire la page pour creer un nouveau projet en java", '2024/08/28', "BASSE", 3, 1, "En cours"), 
(5, "Connexion/Inscription Front", "Faire la page de connexion et d'inscription en angular", '2024/09/30', "HAUTE", 1, 2, "Crée"), 
(6, "Connexion/Inscription Back", "Faire la page de connexion et d'inscription en java", '2024/09/30', "HAUTE", 3, 2, "Crée");

INSERT INTO historique (id, nom, description, dateEcheance, priorite, id_utilisateur_modificateur, id_tache, status) VALUES 
(1, "Connexion Front", "Faire la page de connexion en angular", '2024/08/30', "HAUTE", 2, 1, "Crée"), 
(2, "Creer projet Back", "Faire la page pour creer un nouveau projet en java", '2024/10/28', "BASSE", 3, 4, "En cours"), 
(3, "Inscription Back", "Faire la page d'inscription en java", '2024/09/30', "HAUTE", 3, 6, "Crée");