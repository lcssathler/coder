select * from cities c inner join mayors m on c.id = m.city_id;

select * from cities c left join mayors m on c.id = m.city_id;

select * from cities c right join mayors m on c.id = m.city_id;

select * from cities c left join mayors m on c.id = m.city_id
union
select * from cities c right join mayors m on c.id = m.city_id;
