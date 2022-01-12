show tables;
desc emaillist;

-- create
insert into emaillist values(null,'둘','리','dooly@gmail.com');


-- read
select no, first_name, last_name, email from emaillist order by no desc;
