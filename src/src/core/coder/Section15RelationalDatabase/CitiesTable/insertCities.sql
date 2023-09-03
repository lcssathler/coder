SELECT * FROM cities;

INSERT INTO cities (name, area, state_id)
VALUES ('Campinas', 795, 34);

INSERT INTO cities (name, area, state_id)
VALUES ('Campinas', 795, 28);

INSERT INTO cities (name, area, state_id)
VALUES ('Caruaru',
        920,
       (select id from states where abbreviation = 'PE')
);

INSERT INTO cities (name, area, state_id)
VALUES ('Juazeiro do Norte',
        248.2,
       (select id from states where abbreviation = 'CE')
);