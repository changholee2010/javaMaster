select *
from tab;

-- ������̺�(�����ȣ, �����, ����ó, �̸���, �Ի�����, �޿�)
drop table emp purge;
create table emp (
  emp_no number primary key -- emp_seq.nextval
 ,emp_name varchar2(40) not null
 ,emp_phone varchar2(12) not null -- 02-1234-1234
 ,email varchar2(30) not null
 ,hire_date date default sysdate
 ,salary number
);
alter table emp add dept varchar2(10);

-- C(reate)R(ead)U(pdate)D(elete)
create sequence emp_seq;
insert into emp (emp_no, emp_name, emp_phone, email, salary)
values(emp_seq.nextval, 'kildongHong', '01-1234-5678', 'kildong@email', 2000);
insert into emp (emp_no, emp_name, emp_phone, email, salary)
values(emp_seq.nextval, 'kildongPark', '01-3333-5678', 'pkildong@email', 2300);

select *
from emp
--where emp_name like '%�浿%'
order by emp_no;

update emp
set salary = salary + 500
   ,emp_phone = '01-1111-1111'
where emp_name = 'kildongHong';

delete from emp
where emp_no = 2;

--------------------------------------------------------
select * from tab
where tname like 'TBL%';

select *
from tbl_member;

create table tbl_member (
 member_id varchar2(10) primary key,
 member_pw varchar2(10) not null,
 member_name varchar2(50) not null
);
insert into tbl_member values('user01','1111','ȫ�浿');
insert into tbl_member values('user02','1111','�輺��');
insert into tbl_member values('user03','1111','�ֱټ�');

create sequence board_seq;
create table tbl_board (
 board_no number primary key,
 title varchar2(100) not null,
 content varchar2(300) not null,
 writer varchar2(10) not null,
 write_date date default sysdate,
 view_cnt number default 0
);
insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, 'test1', 'content1', 'user01');
insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, 'good2', 'good content1', 'user02');
insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, 'nice3', 'nice content1', 'user03');

insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, 'veryverygoodverynice3', 'nice content1', 'user03');

insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, '���̻�����ĥ�ȱ������̻�����ĥ�ȱ������̻�����ĥ�ȱ���', 'nice content1', 'user03');
insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, '���̻���', 'nice content1', 'user03');
insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, '���̻���testing', 'nice content1', 'user03');

insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, '�ڹ�testing', 'nice content1', 'user02');

insert into tbl_board(board_no, title, content, writer)
values (board_seq.nextval, '�����α׷�', '�����α׷���... content1', 'user02');

insert into tbl_board(board_no, title, content, writer)
select board_seq.nextval, title, content, writer
from tbl_board;

select o.*
from (select rownum rn, a.*
        from (select b.*
                 from tbl_board b
                 order by board_no) a
        where rownum <= 15) o
where rn > 0;
select count(*) from tbl_board;
delete
from tbl_board
where board_no > 80;

create sequence reply_seq;
drop table tbl_reply purge;
create table tbl_reply (
 reply_no number primary key,
 board_no number not null,
 reply varchar2(300) not null,
 replyer varchar2(10) not null,
 reply_date date default sysdate
);
insert into tbl_reply (reply_no, reply, replyer, board_no)
values(reply_seq.nextval, '���1', 'user03', 1);
insert into tbl_reply (reply_no, reply, replyer, board_no)
values(reply_seq.nextval, '���2', 'user02', 1);

insert into tbl_reply (reply_no, reply, replyer, board_no)
values(reply_seq.nextval, '���11', 'user03', 2);
insert into tbl_reply (reply_no, reply, replyer, board_no)
values(reply_seq.nextval, '���22', 'user02', 3);

--��ȭ����
drop table tbl_movie purge;
create table tbl_movie (
 movie_code varchar2(10) primary key,
 movie_name varchar2(100) not null,
 director_name varchar2(100) not null,
 movie_type varchar2(30) ,
 genre varchar2(30)
);
insert into tbl_movie (movie_code, movie_name, director_name, movie_type, genre)
values('M001', '���˵���', '����1', '18���̻�', '�׼�');
insert into tbl_movie (movie_code, movie_name, director_name, movie_type, genre)
values('M002', '��Ǫ�Ҵ�', '����Ǫ', '12���̻�', '�ִϸ��̼�');
insert into tbl_movie (movie_code, movie_name, director_name, movie_type, genre)
values('M003', 'ç������', 'ç����', '15���̻�', '�θǽ�');
insert into tbl_movie (movie_code, movie_name, director_name, movie_type, genre)
values('M004', '�Ĺ�', '����ǥ', '18���̻�', '����');
insert into tbl_movie (movie_code, movie_name, director_name, movie_type, genre)
values('M005', '����Ʈ��', '��׼�', '18���̻�', '�׼�');

--������
create table tbl_runtime (
 movie_code varchar2(10) not null,
 running_type char(1) default 'N',
 running_room char(1) --�󿵰�(1,2,3,4)
);
insert into tbl_runtime values('M001', 'Y', '1');
insert into tbl_runtime values('M002', 'Y', '2');
insert into tbl_runtime values('M003', 'Y', '3');
insert into tbl_runtime values('M004', 'Y', '4');
insert into tbl_runtime values('M005', 'Y', '4');
update tbl_runtime
set running_type='N'
where movie_code = 'M004';

select r.movie_code, v.movie_name, r.running_room
from tbl_runtime r
join tbl_movie v
on r.movie_code = v.movie_code
where running_type='Y'
order by r.running_room;


--��������
create table tbl_reservation (
 reservation_no number primary key,
 movie_code varchar2(10) not null,
 seat_line char(1) not null, --A,B,C,D
 seat_no number not null, --1,2,3,4,
 member_id varchar2(10) not null,
 reserve_date date default sysdate
);
create sequence reservation_seq;
insert into tbl_reservation values(reservation_seq.nextval, 'M001','A',1,'user01',sysdate);
insert into tbl_reservation values(reservation_seq.nextval, 'M001','A',2,'user01',sysdate);
insert into tbl_reservation values(reservation_seq.nextval, 'M001','A',3,'user01',sysdate);

select * from tbl_movie;
select * from tbl_runtime;
select * from tbl_reservation;

select r.*
from tbl_reservation r
join tbl_runtime t
on r.movie_code = t.movie_code
where t.running_type = 'Y'
and t.running_room = '4'
order by 1;

select m.*
from tbl_movie  m
join tbl_runtime r
on m.movie_code = r.movie_code
where r.running_type='Y';