DROP TABLE vtable;
DROP TABLE db;
DROP TABLE dp;
DROP TABLE load;
DROP TABLE Datasheet;

CREATE TABLE vtable(
--	v_id NUMBER,
	datee DATE NOT NULL,
	v_count NUMBER,
	v_sum NUMBER,
	PRIMARY KEY (datee) 
);

CREATE TABLE db(
--	db_id NUMBER,
	datee DATE,
	db_cnt NUMBER,
	db_sum NUMBER,
	PRIMARY KEY (datee ) 

);

CREATE TABLE dp(
--	dp_id NUMBER,
	datee DATE,
	dp_count NUMBER,
	dp_sum NUMBER,
	PRIMARY KEY (datee ) 
);

CREATE TABLE load(
--	load_id NUMBER,
	datee DATE,
	load_trk NUMBER,
	load_trk_off NUMBER,
	PRIMARY KEY (datee ) 
);

INSERT INTO vtable VALUES(TO_DATE('10-01-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO vtable VALUES(TO_DATE('09-21-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO vtable VALUES(TO_DATE('09-25-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO vtable VALUES(TO_DATE('09-26-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO vtable VALUES(TO_DATE('09-10-2020', 'MM-DD-YYYY'),'100','190');
INSERT INTO vtable VALUES(TO_DATE('09-28-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO vtable VALUES(TO_DATE('09-29-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO vtable VALUES(TO_DATE('10-02-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO vtable VALUES(TO_DATE('10-06-2020', 'MM-DD-YYYY'),'100','100');

INSERT INTO db VALUES(TO_DATE('10-01-2020', 'MM-DD-YYYY'),'100','1000');
INSERT INTO db VALUES(TO_DATE('09-21-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO db VALUES(TO_DATE('09-25-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO db VALUES(TO_DATE('09-26-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO db VALUES(TO_DATE('09-10-2020', 'MM-DD-YYYY'),'100','190');
INSERT INTO db VALUES(TO_DATE('09-28-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO db VALUES(TO_DATE('09-29-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO db VALUES(TO_DATE('10-02-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO db VALUES(TO_DATE('10-06-2020', 'MM-DD-YYYY'),'100','100');

INSERT INTO dp VALUES(TO_DATE('10-01-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO dp VALUES(TO_DATE('09-21-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO dp VALUES(TO_DATE('09-25-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO dp VALUES(TO_DATE('09-26-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO dp VALUES(TO_DATE('09-10-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO dp VALUES(TO_DATE('09-28-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO dp VALUES(TO_DATE('09-29-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO dp VALUES(TO_DATE('10-02-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO dp VALUES(TO_DATE('10-06-2020', 'MM-DD-YYYY'),'100','100');

INSERT INTO load VALUES(TO_DATE('10-01-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO load VALUES(TO_DATE('09-21-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO load VALUES(TO_DATE('09-25-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO load VALUES(TO_DATE('09-26-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO load VALUES(TO_DATE('09-10-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO load VALUES(TO_DATE('09-28-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO load VALUES(TO_DATE('09-29-2020', 'MM-DD-YYYY'),'100','100');
INSERT INTO load VALUES(TO_DATE('10-02-2020', 'MM-DD-YYYY'),'100','190');
INSERT INTO load VALUES(TO_DATE('10-06-2020', 'MM-DD-YYYY'),'100','190');

SELECT t1.datee,t1.v_count,t1.v_sum,t2.db_cnt,t2.db_sum,t3.dp_count,t3.dp_sum,t4.load_trk,t4.load_trk_off FROM vtable t1 
inner join db t2 on t1.datee=t2.datee INNER JOIN dp t3 ON t2.datee=t3.datee INNER JOIN load t4 ON t3.datee=t4.datee 
where t1.datee BETWEEN trunc(sysdate-7) AND trunc(sysdate);

select * from vtable;
select * from db;
select * from dp;
select * from load;

select * from vtable where datee BETWEEN trunc(sysdate-7) AND trunc(sysdate);

CREATE TABLE Datasheet(
	datee DATE,
	v_count NUMBER,
	v_sum NUMBER,
	db_cnt NUMBER,
	db_sum NUMBER,
	dp_count NUMBER,
	dp_sum NUMBER,
	load_trk NUMBER,
	load_trk_off NUMBER,
	PRIMARY KEY (datee ) 

);

--INSERT INTO Datasheet VALUES ('1',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','1000','100','100','100','100');
--INSERT INTO Datasheet VALUES ('2',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','100','100','100','100','100'); 
--INSERT INTO Datasheet VALUES ('3',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','100','100','100','100','100'); 
--INSERT INTO Datasheet VALUES ('4',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','190','100','100','100','100'); 
--INSERT INTO Datasheet VALUES ('5',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','190','100','100','100','100','100','100'); 
--INSERT INTO Datasheet VALUES ('6',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','100','100','100','100','100'); 
--INSERT INTO Datasheet VALUES ('7',TO_DATE('12/01/2016', 'DD/MM/YYYY'),'100','100','100','100','100','100','100','190'); 

SELECT * FROM Datasheet;
