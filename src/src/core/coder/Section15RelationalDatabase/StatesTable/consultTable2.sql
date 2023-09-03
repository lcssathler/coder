SELECT region as 'Região' from states group by region;

SELECT region as 'Região',
        sum(population) as 'Total'
FROM states
group by region
order by Total desc;
