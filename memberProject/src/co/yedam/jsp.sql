-- 사원테이블(사원번호, 사원명, 연락처, 이메일, 입사일자, 급여)
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
order by emp_no;

update emp
set salary = salary + 500
   ,emp_phone = '01-1111-1111'
where emp_name = 'kildongHong';

delete from emp
where emp_no = 2;
