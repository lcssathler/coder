SELECT * FROM cities c, states s order by c.name;

SELECT c.name, s.name FROM cities c, states s
WHERE c.state_id = s.id;

SELECT c.name, s.name
FROM cities c
INNER JOIN states s on c.state_id = s.id;