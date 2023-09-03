SELECT * FROM states;

SELECT name, abbreviation, region FROM states WHERE region = 'sul' ;

SELECT name, region, population FROM states
WHERE population >= 10
order by population desc;