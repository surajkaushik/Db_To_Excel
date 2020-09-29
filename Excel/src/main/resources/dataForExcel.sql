
DROP TABLE Datasheet;

CREATE TABLE Datasheet(
	srl Number,
	Datee VARCHAR(50),
	v_count NUMBER,
	v_sum NUMBER,
	db_cnt NUMBER,
	db_sum NUMBER,
	dp_count NUMBER,
	dp_sum NUMBER,
	load_trk NUMBER,
	load_trk_off NUMBER,
	constraint Excel_PK primary key ( srl )
);

INSERT INTO Datasheet VALUES ('1','9/13/2020','100','100','100','1000','100','100','100','100');
INSERT INTO Datasheet VALUES ('2','7/26/2000','100','100','100','100','100','100','100','100'); 
INSERT INTO Datasheet VALUES ('3','11/08/2010','100','100','100','100','100','100','100','100'); 
INSERT INTO Datasheet VALUES ('4','1/03/2019','100','100','100','190','100','100','100','100'); 
INSERT INTO Datasheet VALUES ('5','12/01/2017','100','190','100','100','100','100','100','100'); 
INSERT INTO Datasheet VALUES ('6','2/10/2021','100','100','100','100','100','100','100','100'); 
INSERT INTO Datasheet VALUES ('7','5/23/2020','100','100','100','100','100','100','100','190'); 

SELECT * FROM Datasheet;
