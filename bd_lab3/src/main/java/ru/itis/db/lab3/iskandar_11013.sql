DROP DATABASE IF EXISTS yandex_taxi;
DROP TABLE IF EXISTS clients,drivers,cars,trips;

CREATE DATABASE yandex_taxi;
\connect yandex_taxi;

CREATE TABLE clients
(
    id    INT NOT NULL PRIMARY KEY,
    name  VARCHAR(20),
    phone VARCHAR(15)
);

CREATE TABLE cars
(
    id     INT NOT NULL PRIMARY KEY,
    model  VARCHAR(20),
    number VARCHAR(15)
);
CREATE TABLE drivers
(
    id     INT NOT NULL PRIMARY KEY,
    name   VARCHAR(20),
    phone  VARCHAR(15),
    rating VARCHAR(2),
    car    INT NOT NULL REFERENCES cars (id)

);

CREATE TABLE trips
(
    date   TIMESTAMP WITH TIME ZONE,
    client INT NOT NULL REFERENCES clients (id),
    driver INT NOT NULL REFERENCES drivers (id)
);

INSERT INTO clients(id, name, phone)
VALUES (1, 'Bob', '12345'),
       (2, 'John', '54321'),
       (3, 'Max', '12234');

INSERT INTO cars(id, model, number)
VALUES (1, 'Sedan', 'CAR148418'),
       (2, 'Coupe', 'CAR151419'),
       (3, 'Sports Car', 'CAR201110');

INSERT INTO drivers(id, name, phone, rating, car)
VALUES (1, 'Mary', '9999', '5', 1),
       (2, 'Ivan', '2222', '6', 2),
       (3, 'Tony', '4444', '7', 3);

INSERT INTO trips(date, client, driver)
VALUES (TIMESTAMP '2020-09-01 21:10:00+03', 1, 2),
       (TIMESTAMP '2020-10-01 07:05:50+03', 3, 1),
       (TIMESTAMP '2020-04-01 20:00:00+03', 2, 3);

SELECT * FROM trips;
