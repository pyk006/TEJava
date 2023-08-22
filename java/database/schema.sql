BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS applications;
DROP TABLE IF EXISTS adopter;
DROP TABLE IF EXISTS animals;


CREATE TABLE applications (
	application_id SERIAL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	date_of_birth varchar(25) NOT NULL,
	home_address varchar(50) NOT NULL,
	availability varchar(50) NOT NULL,
	school_mascot varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	phone_number varchar(25) NOT NULL,
	opt_in_text boolean,
	experience boolean,
	transportation boolean,
	bkgrnd_check_approved varchar(25),
    admin_approval varchar(25) NOT NULL,
    photo varchar(250),
	
	CONSTRAINT PK_application PRIMARY KEY (application_id)
);

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	security_ans varchar(50),
	application_id int,
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT FK_application_id FOREIGN KEY (application_id) REFERENCES applications(application_id)
);

CREATE TABLE animals(
	animal_id serial,
	animal_name varchar(50) NOT NULL,
	animal_type varchar(50) NOT NULL,
	breed varchar(25),
	gender varchar(20) NOT NULL,
	age int NOT NULL,
	is_adoptable boolean NOT NULL,
	description varchar(250),
    photo varchar(250),
	CONSTRAINT PK_animal PRIMARY KEY (animal_id)
);

CREATE TABLE adopter(
adopter_id serial,
animal_id int NOT NULL,
adopter_first_name varchar(50) NOT NULL,
adopter_last_name varchar(50) NOT NULL,
email varchar(50) NOT NULL,
phone_number varchar(50) NOT NULL,

CONSTRAINT PK_adopter PRIMARY KEY (adopter_id),
CONSTRAINT FK_animal_id FOREIGN KEY (animal_id) REFERENCES animals(animal_id)
);


COMMIT TRANSACTION;
