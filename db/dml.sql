show tables;
desc emaillist;

-- create
insert into emaillist values(null,'둘','리','dooly@gmail.com');
insert into emaillist values(null,'루','피','loofy@gmail.com');

-- read
select no, first_name, last_name, email from emaillist order by no desc;
