SELECT co.name Company, ci.name City
FROM  companies co, companies_unit cu, cities ci
WHERE co.id = cu.company_id
AND ci.id = cu.city_id
AND sede = 1;
