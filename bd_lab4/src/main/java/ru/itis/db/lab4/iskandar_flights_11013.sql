

--select * from flights
--where departure_airport = (select airport_code from airports_data where airport_name::json ->>'ru' = 'Казань')
--and arrival_airport = (select airport_code from airports_data where airport_name::json ->>'ru' = 'Магнитогорск')

select * from flights
where departure_airport in (select airport_code from airports_data where city::json ->>'ru' = 'Москва')
and scheduled_departure = 
 
--select * from airports_data where city::json ->> 'ru' = 'Москва';
