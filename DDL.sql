DROP DATABASE IF EXISTS sgpzf;

CREATE DATABASE sgpzf;

USE sgpzf;
-- stacks
CREATE TABLE stack(
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_stack PRIMARY KEY(id)
)ENGINE=InnoDB;
-- countries
CREATE TABLE country(
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_country PRIMARY KEY(id)
)ENGINE=InnoDB;

-- regions
CREATE TABLE region(
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    idcountry INT NOT NUll,
    CONSTRAINT pk_region PRIMARY KEY(id),
    CONSTRAINT fk_region_country FOREIGN KEY (idcountry) REFERENCES country(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;

-- cities
CREATE TABLE city(
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    idregion INT NOT NUll,
    CONSTRAINT pk_city PRIMARY KEY(id),
    CONSTRAINT fk_city_region FOREIGN KEY (idregion) REFERENCES region(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;

-- genders
CREATE TABLE gender(
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_gender PRIMARY KEY(id)
)ENGINE=InnoDB;

-- persons

CREATE TABLE persons(
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    idcity INT NOT NUll,
    address VARCHAR(50) NOT NULL,
    age INT NOT NUll,
    email VARCHAR(100) NOT NULL,
    idgender INT NOT NUll,
    CONSTRAINT pk_persons PRIMARY KEY(id),
    CONSTRAINT fk_persons_city FOREIGN KEY (idcity) REFERENCES city(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_persons_gender FOREIGN KEY (idgender) REFERENCES gender(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;

-- skills
CREATE TABLE skill(
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_skill PRIMARY KEY(id)
)ENGINE=InnoDB;

-- stack_skills
CREATE TABLE stack_skill(
    idskill INT NOT NULL,
    idstack INT NOT NULL,
    idstatus INT NOT NULL,
    CONSTRAINT pk_stack_skill PRIMARY KEY(idskill,idstack),
    CONSTRAINT fk_stack_skill_skill FOREIGN KEY (idskill) REFERENCES skill(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_stack_skill_stack FOREIGN KEY (idstack) REFERENCES stack(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;

-- person_skills
CREATE TABLE person_skill(
    id INT NOT NULL,
    registration_date DATE NOT NULL,
    iperson INT NOT NULL,
    idskill INT NOT NULL,
    CONSTRAINT pk_person_skill PRIMARY KEY(id),
    CONSTRAINT fk_person_skill_person FOREIGN KEY (iperson) REFERENCES persons(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_person_skill_skill FOREIGN KEY (idskill) REFERENCES skill(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;
