-- Creating 'states' table
create table states (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    abbreviation VARCHAR(2) NOT NULL,
    region ENUM ('Norte', 'Nordeste', 'Centro-Oeste', 'Sudeste', 'Sul') NOT NULL,
    population  DECIMAL (5,2) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (name),
    UNIQUE KEY (abbreviation)
);