-- MySQL Script generated by MySQL Workbench
-- Mon Sep 12 12:20:25 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema mistumori
-- -----------------------------------------------------

DROP TABLE IF EXISTS person CASCADE;
DROP TABLE IF EXISTS client CASCADE;
DROP TABLE IF EXISTS expert CASCADE;
DROP TABLE IF EXISTS conversation CASCADE;
DROP TABLE IF EXISTS estimation CASCADE;
DROP TABLE IF EXISTS tchat CASCADE;
DROP TABLE IF EXISTS client_has_tchat CASCADE;
DROP TABLE IF EXISTS expert_has_tchat CASCADE;

-- -----------------------------------------------------
-- Schema mistumori
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table Person
-- -----------------------------------------------------
CREATE TABLE person (
  id SERIAL PRIMARY KEY,
  Name VARCHAR(45),
  Surname VARCHAR(45),
  Mdp VARCHAR(45)
  );


-- -----------------------------------------------------
-- Table Client
-- -----------------------------------------------------
CREATE TABLE client (
  idclient SERIAL PRIMARY KEY,
  person_id INT,
  FOREIGN KEY (person_id) REFERENCES person (id) ON DELETE NO ACTION ON UPDATE NO ACTION
  );


-- -----------------------------------------------------
-- Table Expert
-- -----------------------------------------------------
CREATE TABLE expert (
  idexpert SERIAL PRIMARY KEY,
  person_id INT,
  FOREIGN KEY (person_id) REFERENCES person (id) ON DELETE NO ACTION ON UPDATE NO ACTION
  );


-- -----------------------------------------------------
-- Table Conversation
-- -----------------------------------------------------
CREATE TABLE conversation (
  idConversation SERIAL PRIMARY KEY
  );


-- -----------------------------------------------------
-- Table Estimation
-- -----------------------------------------------------
CREATE TABLE estimation (
  idEstimation SERIAL PRIMARY KEY,
  Name VARCHAR(45) NULL,
  Image bytea NULL,
  Estimationcol VARCHAR(45) NULL,
  Categories VARCHAR(45) NULL,
  Date_de_production DATE NULL,
  Brand VARCHAR(45) NULL,
  Description VARCHAR(45) NULL,
  Client_idclient INT NOT NULL,
  Expert_idexpert INT NOT NULL,
  Conversation_idConversation INT NOT NULL,
    FOREIGN KEY (Client_idclient)
    REFERENCES Client (idclient)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (Expert_idexpert)
    REFERENCES Expert (idexpert)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (Conversation_idConversation)
    REFERENCES Conversation (idConversation)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
	);


-- -----------------------------------------------------
-- Table tchat
-- -----------------------------------------------------
CREATE TABLE  tchat (
  idtchat SERIAL NOT NULL,
  message VARCHAR(45) NULL,
  PRIMARY KEY (idtchat)
  );

-- -----------------------------------------------------
-- Table Client_has_tchat
-- -----------------------------------------------------
CREATE TABLE client_has_tchat (
  client_idclient INTEGER NOT NULL,
  tchat_idtchat INTEGER NOT NULL,
  PRIMARY KEY (client_idclient, tchat_idtchat),
    FOREIGN KEY (client_idclient) REFERENCES client (idclient) ON DELETE NO action ON UPDATE NO ACTION,
    FOREIGN KEY (tchat_idtchat) REFERENCES tchat (idtchat) ON DELETE NO action ON UPDATE NO ACTION
	);

-- -----------------------------------------------------
-- Table Expert_has_tchat
-- -----------------------------------------------------
CREATE TABLE expert_has_tchat (
  expert_idexpert INTEGER NOT NULL,
  tchat_idtchat INTEGER NOT NULL,
  PRIMARY KEY (expert_idexpert, tchat_idtchat),
    FOREIGN KEY (expert_idexpert) REFERENCES expert (idexpert) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (tchat_idtchat) REFERENCES tchat (idtchat) ON DELETE NO ACTION ON UPDATE NO ACTION
	);