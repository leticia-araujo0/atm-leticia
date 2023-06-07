create database atm9;

use atm9;

CREATE TABLE Processo (
	id INT NOT NULL AUTO_INCREMENT,	
  	nome VARCHAR(255) NULL,
	pid CHAR(5) NULL,
	uso_cpu FLOAT NULL,
	uso_memoria INT NULL,
	byte_utilizado INT NULL,
	memoria_virtual_utilizada BIGINT NULL,
	dt_processo DATETIME NULL,
	PRIMARY KEY (id)
);


select * from processo;

select * from Processo order by id desc;

select * from Processo order by id;


-- -----------------------------------------------------
drop table Processo;
truncate table Processo;