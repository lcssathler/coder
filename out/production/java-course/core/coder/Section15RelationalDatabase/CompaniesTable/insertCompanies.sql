ALTER TABLE companies MODIFY cnpj VARCHAR(14);

INSERT INTO companies (name, cnpj)
VALUES
    ('Bradesco', 35824385000196),
    ('Vale', 58523190000101),
    ('Cielo', 91963614000124);

SELECT * FROM companies;