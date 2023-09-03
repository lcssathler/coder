CREATE TABLE IF NOT EXISTS mayors (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    city_id INT UNSIGNED,
    PRIMARY KEY (id),
    UNIQUE KEY (city_id),
    FOREIGN KEY (city_id) REFERENCES cities (id)
);
