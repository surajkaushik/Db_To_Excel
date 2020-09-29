
DROP TABLE Datasheet;

CREATE TABLE Datasheet(
	srl Number,
	Datee DATE,
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

INSERT INTO Datasheet VALUES ('1',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','1000','100','100','100','100');
INSERT INTO Datasheet VALUES ('2',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','100','100','100','100','100'); 
INSERT INTO Datasheet VALUES ('3',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','100','100','100','100','100'); 
INSERT INTO Datasheet VALUES ('4',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','190','100','100','100','100'); 
INSERT INTO Datasheet VALUES ('5',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','190','100','100','100','100','100','100'); 
INSERT INTO Datasheet VALUES ('6',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','100','100','100','100','100'); 
INSERT INTO Datasheet VALUES ('7',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','100','100','100','100','190'); 

SELECT * FROM Datasheet;
