drop table memberlist;
drop table loan;
drop table account;

create table memberlist(
    id          varchar(20)   primary key
    ,name       varchar(20)   not null
    ,password   varchar(20)   not null
    ,rest       number(10)    not null
);

create table loan(
    id          varchar(20)   primary key
    ,loan_money number(10)    default 0
);

create table account(
    id               varchar(20)   
    ,account         varchar(20)   primary key
    ,account_money   varchar(20)   default 0
);

insert INTO memberlist (id, name , password, rest) values('qrtz7950', '±èÁ¦Èñ', '1111', 0);
insert INTO memberlist (id, name , password, rest) values('Ddock2', '°ûº´¹®', '2222', 0);
insert INTO memberlist (id, name , password, rest) values('asrbtjd', 'ÃÖ±Ô¼º', '3333', 0);

insert INTO loan (id, loan_money) values('qrtz7950', 1000);
insert INTO loan (id, loan_money) values('Dock2', 0);

insert INTO account (id, account, account_money) values('qrtz7950', '2018-1234', 0);
insert INTO account (id, account, account_money) values('qrtz7950', '2018-5678', 0);
insert INTO account (id, account, account_money) values('Ddock2', '2018-8484', 0);
insert INTO account (id, account, account_money) values('Ddock2', '2018-4848', 0);
insert INTO account (id, account, account_money) values('asrbtjd', '2018-5656', 0);
insert INTO account (id, account, account_money) values('asrbtjd', '2018-6565', 0);

select * from memberlist;
select * from loan;
select * from account;