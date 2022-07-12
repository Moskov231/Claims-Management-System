CREATE TABLE Bills(mid varchar(20), lastPaidDate date, dueAmount int, lateCharge int, dueDate date, pid varchar(20));
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) VALUES ('M101','2021-08-21',100000,7000,'2021-10-01','P101');
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) values('M102','2022-02-10',5000,500,'2022-05-10','P102');
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) values('M103','2021-10-20',19000,0,'2022-05-30','P103');
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) values('M104','2022-04-05',21000, 0,'2022-08-10','P102');
