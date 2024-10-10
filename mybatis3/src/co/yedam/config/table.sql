--drop table tbl_product purge;
create table tbl_product (
 prod_code varchar2(10) primary key,
 prod_name varchar2(100) not null,
 prod_desc varchar2(100) not null,
 selling_price number,
 creation_date date default sysdate
);

insert into tbl_product values('P001', '모나미볼펜1.0', '아주 좋은 모나미볼펜 1.0입니다', 1000, sysdate);
insert into tbl_product values('P002', '모나미샤프0.5', '아주 좋은 모나미샤프 0.5입니다', 2000, sysdate);
insert into tbl_product values('P003', '모나미지우개 100', '아주 좋은 모나미지우개 100입니다', 500, sysdate);

create sequence transactions_seq;
create table tbl_transactions (
 txn_id    number,
 prod_code varchar2(10) not null,
 txn_qty   number not null,
 txn_date  date default sysdate,
 creation_date date default sysdate
);
