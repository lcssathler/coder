create table if not exists companies (
    id int unsigned not null auto_increment,
    name varchar(255) not null,
    cnpj int not null,
    primary key (id),
    unique key (cnpj)
);

--cities_companies
-- tinyint = like a boolean value
create table if not exists companies_unit(
    company_id int unsigned not null,
    city_id int unsigned not null,
    sede TINYINT(1) not null,
    primary key (company_id, city_id)
);