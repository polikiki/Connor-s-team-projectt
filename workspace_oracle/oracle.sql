-- ���� �ּ�
/* ���� �ּ� */
select 
    * -- ��� �÷�
from 
    emp;
-- sql developer �ڵ� ���� ����Ű: ctrl + F7

select 
    empno, ename, deptno
from 
    emp;
    
select * from dept;
select * from salgrade;

select deptno from emp;
-- ���� ���� ����Ű : ctrl + shift + d

-- distinct : select���� �ߺ��Ǵ� �ڷḦ �������ش�
select distinct deptno from emp;
select distinct job from emp;

select deptno, job from emp;
-- �÷��� �������� ��� �÷����� ������ �ߺ��Ǵ°� �����Ѵ�
select  distinct deptno, job from emp;

-- null�� �����ϸ� ������ null�̴�
select ename, sal, sal*12+comm,comm from emp;

-- �÷����� ��Ī ���
-- " ��������
-- ��Ī�ȿ� ���Ⱑ �ִ� ��� "���� �Ұ�
-- �����ϸ� ���⺸�� _�� ����
-- as ��������
select ename, sal, sal*12+comm as "new_sal",comm from emp;

-- order by = �ش� �÷����� ����
-- �������� : asc ��������
-- �������� : desc 
select * from emp
order by sal asc;

select * from emp
order by comm;

select * from emp
order by sal desc;

-- order by ù��°�ŷ� �����ϰ�(1����)
-- �� �߿� ������ �ִٸ� �����ŷ� �����ϰ� (2����)
-- �� �߿� ������ �ִٸ� �����ŷ� �����ϰ� (3����)
select * from emp
order by deptno asc, sal desc; 

select distinct job from emp
order by job;

select * from emp
where deptno = 30;

select * from emp
where sal >= 2000
order by sal desc;

select * from emp
-- ���ڸ� ���� "�� �ƴ� '�� ��� �Ѵ�
where ename = 'king';

select * from emp
where deptno = 30
and job = 'SALESMAN';

select * from emp
where job = 'CLERK'
AND deptno = 30;

select * from emp
where job = 'CLERK'
AND (deptno = 30 or deptno = 20); -- and�� or ���� �켱������ �� ������ �ִ�

select * from emp
where sal >= 2000 and sal < 3000;

select * from emp
--where sal != 3000;
where sal <> 3000; -- ���� �����̶� �����ϴ�

/*
    !(a != b)
*/

select * from emp
where not (sal >= 2000 and sal < 3000);

select * from emp
where job in ('MANAGER','SALESMAN', 'CLERK'); 

select * from emp
where job not in ('MANAGER','SALESMAN', 'CLERK'); 

select * from emp
where sal between 2000 and 3000;

-- %�� ��ŵ� �������
select * from emp
where ename like 'S%';

select * from emp
where ename like 'A%';

-- _�� �� �ѱ����ε� � ���ڴ� ���� ����
select * from emp
where ename like '_L%';

select * from emp
where ename like '____';

select * from emp
where ename like '%AM%';

select * from emp
where comm <= 400;

select * from emp
where comm <= null;

select * from emp
where comm is null;

select * from emp
where comm is not null;

-- emp���� deptno�� 10 �Ǵ� 20�� �����
-- empno, ename,sal, deptno�� ����ϼ���
select empno, ename, sal, deptno from emp
--where deptno = 10 or deptno = 20;
where deptno in (10,20);

-- ���� �ٸ� ��ȸ ������� �����ݴϴ�.
-- ��, ��ȸ�� Į���� ����, Ÿ���� ���ƾ� �Ѵ�.
select empno, ename, sal, deptno from emp
where deptno =10 
union
select empno, ename, sal, deptno from emp
where deptno =20;

-- union : �ߺ��� �ڷḦ ��������
select empno, ename, sal, deptno from emp
where deptno =10 
union
select empno, ename, sal, deptno from emp
where deptno =10;

-- union all : �ߺ��� ������� �����ش�
select empno, ename, sal, deptno from emp
where deptno =10 
union all
select empno, ename, sal, deptno from emp
where deptno =10;

-- 125p.
-- Q1
select * from emp
where ename like '%S';
-- Q2
select empno, ename, job, sal, deptno from emp
where deptno = 30 and job = 'SALESMAN';
-- Q3
select empno, ename, job, sal, deptno from emp
--where (deptno = 20 or deptno = 30) and sal >2000;
where deptno in (20,30) and sal >2000;

select empno, ename, job, sal, deptno from emp
where deptno = 30 and sal>2000
union
select empno, ename, job, sal, deptno from emp
where deptno = 20 and sal>2000;
-- Q4
select * from emp
where not (sal >= 2000 and sal <=3000);
-- Q5
select ename, empno, sal, deptno from emp
where(ename like '%E%' and deptno = 30) and not (sal > 1000 and sal <2000);
-- Q6
select * from emp
where (comm is null and (mgr is not null)and(job = 'MANAGER' or job='CLERK'))
and ename not like '_L%';

select ename, upper(ename), lower(ename), initcap(ename)
from emp;

-- upper, lower�� ��ҹ��� ���� ���� like �Ҷ� �� ���� 
select * from emp
where lower (ename) like lower ('%Mi%');

select ename, length(ename)
from emp;

-- length: ���ڰ���
select * from emp
where length(ename) >= 5;

-- dual : �ӽ� ���̺� (�ܼ� ó�� �׽�Ʈ �ϰų� �ӽø� Ȯ���� �Ҷ� �ַ� ���δ�) 
select length('��'), lengthb('��') from dual;

-- substr : ����̵Ǵ� ����, ������ġ, ������ ����
-- ������ ������ �Ⱦ��ų� �ʹ� ũ�� ������
select job,
substr(job,1,2), substr(job,0,2), 
substr(job,3,3), 
substr(job,5),
ename,
substr(job,-3,2),
length(lower(substr(job,5,100)))
from emp;

select job, replace(job,'A','*') from emp;

select
job,
length(job),
(length(job)+1)/2,
substr(job,(length(job)+1)/2,1),
replace(
    job,
    substr(job,(length(job)+1)/2,1),
    '*'
    )
from emp;

-- lpad : ����� �Ǵ� ���� : ��ü �ڸ���, ä�� ���� 
-- ä�� ���� ���� �� ���鹮��
select
job,
lpad(job, 10, '#'),
lpad(job, 4, '#')
from emp;

select
    job, length(job), 15-length(job)
from emp;

-- ���ڿ� ���ϱ�
select empno || ename || '��'
from emp;

-- trim : �� �� ���� ����
-- �۾� ������ ������ �������� ����
select
    '    a b c    ',
    trim('    a b c    ')
from dual;

-- �ǽ����� 1
select
    '210621-3123456',
    '210621-3******'
from dual;

select
'210621-3' || '******',
substr('210621-3123456',1,8) || '******',
rpad('210621-3',14,'*'),
rpad(
    substr('210621-3123456',1,8),
    length('210621-3123456'),
    '*'
    )
from dual;

-- �ǽ�����2
-- ����� �̸��� �տ� ���ڸ��� ���̰� �ϰ� �������� *�� ǥ��
-- ������ �� : WARD -> WA**, MARTIN -> ma****


select ename, 
rpad(substr(ename,1,2), length(ename),'*')
from emp;

-- �ǽ�����3
-- �ձ��� �ϳ���
-- WARD -> *ARD, MARTIN ->*ARTIN

select ename, 
lpad(substr(ename,2,length(ename)),length(ename),'*')
from emp;

-- �ǽ�����4
-- �ι�° �۾��� *
-- WARD -> W*RD, M*RTIN
select ename, 
rpad(substr(ename,1,1),2,'*')
|| substr(ename,3,length(ename)-2)
from emp;

-- �ǽ�����5
-- ��� �۾��� *
-- MARTIN -> MA*TIN, SCOTT -> SC*TT

select ename, 
substr(ename,1,length(ename)/2-0.5) ||
lpad(substr(ename,length(ename)/2+1.5,length(ename)/2),length(ename)/2 +1,'*') as center
from emp;

select
    length(ename)/2 +1,
    substr(ename,1,length(ename)/2-0.5) || '*' || substr(ename,length(ename)/2 + 1.5)
    from emp;
    
    select 
    trunc(1234.5678),
    trunc(1234.5678,2),
    trunc(1234.5678,-2),
    trunc(-12.34)
    from dual;
    
    select
        ceil(3.14),
        floor(3.14),
        ceil(-3.14),
        floor(-3.14)
    from dual;
    
    -- sysydate : ���� ����Ŭ pc�� �ð��� ���ɴϴ�
    -- ���� pc�� 9�ð� ���� ����(���� 0�� ���� �ѱ� +9��)
    -- ��¥ ���� �� �Ϻθ� select�� ǥ�� ��
    select sysdate, sysdate+1, sysdate-1 from dual;
    
    
    -- �÷��� +�� ������ ��� ���ڷ� �����ؼ� ������
    -- || ���ڵ� ���ڷ� ����
    -- 9�ð��� �߰��ϴ� ��� (���� ����Ŭ �ð��� �����ð����� ���߾��� ����)
    select 
    -- ��� ���ڸ� ���� ���ϴ� ������ ��κ� ���� mm ���� mi�� ���� 
    -- ��� ���ڸ� �����ϴ� ���(ex �ڹ�)������ ��κ� M�� �� m�� ���� �ǹ��Ѵ�
        to_char(sysdate+(9/24), 'yyyy"��" mm"��" dd"��" hh24"��" mi"��" ss"��"')
    from dual;
    
    select
        sysdate - to_date('2024-05-07', 'yyyy-mm-dd')
        from dual;
        
    -- Ư����¥�� ����Ҷ� �ð��� ���������� 0�� 0�� 0�ʷ� ǥ�õȴ�
        select 
        to_char(to_date('2024-05-07', 'yyyy-mm-dd'), 'yyyy"��" mm"��" dd"��" hh24"��" mi"��" ss"��"')
    from dual;
    
select 
    comm,
    nvl(comm,-1),
    sal,
    sal + comm,
    sal + nvl(comm, 0)
from emp;

select * from emp
where comm =0 or comm is null;

select * from emp
where nvl(comm, 0) = 0;

-- case���� switchó�� ���� �ִ� ����� inputó�� ����� �� �ִ� ����� �ִ�
-- case���� decode���� �� ���� �������� ���� �� �����Ƿ� case�� �ַ� ����


-- ���� �׻� ������ ������ ������ �־�� �ϹǷ�(���ڸ� ���� ,���ڸ� ����) 
-- else �κ��� comm(����)�� to_char �Լ��� ���ڿ��� ���ڷ� ����� �־���
select 
    case
        when comm is null
    then
        'N/A'
        else 
            to_char(comm)
--            '' || comm
    end new_comm
    from emp;
    
    select 
    case
        when comm is null
    then
      0
        else 
            (comm)
--            '' || comm
    end new_comm
    from emp;
-- Q2
    select
    empno, ename, sal,
    trunc(sal/21.5,2)as DAY_PAY,
    round(sal/21.5/8,1) as TIME_PAY
    from emp;
-- Q3  
    select 
    empno, ename, hiredate,
    to_char(add_months(hiredate,3),'yyyy-mm-dd')r_job_0,
   next_day(add_months(hiredate,3),2)as R_JOB, -- �Ͽ�1, ����2,...,���7
--    comm,
--    nvl(to_char(comm),'N/A'),
--    to_char(null)
--    from emp;
    case when comm is null then'N/A'
    else to_char(comm)
    end as COMM,
    decode(comm, null, 'N/A',comm) -- decode�� to_char �Ƚᵵ �˾Ƽ� ����
    from emp;
-- Q4
    select empno, ename, mgr,
    case  
        when mgr is null then '0000'
--        else 
--            case
--                when substr(mgr,1,2) = 75 then '5555'
--                when substr(mgr,1,2) = 76 then '6666'
--                else to_char(mgr)
--                end
        when substr(mgr,1,2) = 75 then '5555'
        when substr(mgr,1,2) = 76 then '6666'
        when substr(mgr,1,2) = 77 then '7777'
        when substr(mgr,1,2) = 78 then '8888'
        else to_char(mgr)
        end as CHG_MGR,
        case
            when mgr is null then '0000'
            else
                case substr(mgr,1,2)
                    when 75 then '5555'
                    when 76 then '6666'
                    else to_char(mgr)
                end
                end chg_mgr_2
            case
                when mgr is null then '0000'
                when mgr like '75%' then '5555'
                when mgr like '76%' then '5555'
                else to_char(mgr)
            end chg_mgr_3.
            case
               when mgr like '75%' then '5555'
               when mgr like '76%' then '6666'
               else nvl(to_char(mgr), '0000')
            end chg_mgr_4,
            case
                when substr(mgr,2,1) in ('5','6','7','8')
                then lpad(substr(mgr,2,1),4,substr(mgr,2,1))
                else nvl(to_char(mgr),'0000')
            end chg_mgr_5
        from emp;
    
-- countó�� null�� ���ܵ�
-- count�� *�� ���� ��
select sum(sal), count(sal), count(*), count(comm) from emp; -- sum�� �ϳ��� ���������� �� �� �ִ� ������ �� ���� ���� �� ����

select count(*) from emp where ename like '%A%';

select max(sal), max(ename), min(hiredate), min(comm), avg(sal) from emp;

select sum(sal), avg(sal) from emp
where deptno = 10
union all
select sum(sal), avg(sal) from emp
where deptno = 20
union all
select sum(sal), avg(sal) from emp
where deptno = 30;

-- distinct ó�� �ߺ��� ��������, �з�����
-- slect���� group by�� ���̳� ������ �Լ�(���� �Լ�)
select deptno, avg(sal), sum(sal), count(*) from emp
group by deptno;

select deptno, empno, sum(sal), count(*) from emp
group by deptno, empno; -- ��ġ�� �ֵ��� ���� �ǹ̰� ����

select deptno, job, count(*)
from emp
--where count(*) >= 2
group by deptno, job
order by deptno, job;

-- having : group by������ ���ȴ�/
-- �����Լ� �������� �ɰ� ���� ��쿡 ���
 select deptno, job, avg(sal)
 from emp
 group by deptno, job
--    having avg(sal) >= 2000;
--    having count(*) >= 2;
      having deptno =20;

-- q1
select deptno, trunc(avg(sal)), max(sal), min(sal), count(*)
from emp
group by deptno;

-- q2
select job, count(*)
from emp
--where count(*) > 3
group by job
having count(*) >= 3;

select * from dept;

/* 5 */select job, count(*) cnt
/* 1 */from emp
/* 2 */where sal >1000
/* 3 */group by job
/* 4 */having count(*) >= 3
/* 6 */order by cnt desc;

select *
from emp, dept
order by empno;

select 14*4 from dual;

select /*emp.ename*/ ename, /*emp.loc*/ dept.loc, /*deptno,*/
from emp, dept
where emp.deptno = dept.deptno
order by empno;
-- ���̺� �ΰ� �̻� ��ȸ�Ҷ� ���踦 �� �˷���� ���ϴ� ������ ��µȴ�
-- ��ü ���̺� �� -1���� ������ �����ϴ�

-- ��Ī�� �ѹ� ������ ������ ������ �̸��� ����ص� �� �� ����
select *
from emp e, dept d
 where e.deptno = d.deptno;
-- where emp.deptno = d.deptno;

-- *�� �÷��� ���� ���� ��� *�� ���̺��� ��������� �Ѵ�.
select ename, d.*
from emp e, dept d
 where e.deptno = d.deptno;
-- where emp.deptno = d.deptno;

select ename, emp.* from emp;

select * from salgrade;

select *
from emp e, salgrade s
where e.sal >= s.losal and e.sal <= s.hisal

select * from emp;

select *
from emp el, emp e2
where el.mgr = e2.empno;

select e1.empno, e1.ename, e1.mgr, e2.empno, e2.ename
from emp e1, emp e2
where e1.mgr = e2.empno;

select *
from emp join dept using (deptno);

select *
from emp join dept on (emp,deptno = dept.deptno);

select *
from emp e1 join emp e2 on(e1.mgr = e2.empno);

-- left outer join�̶�? ���� ���̺��� ��� ����ϴ°� �������ش�(null���� ����� �����ϴ�)
select *
from emp e1 left outer join emp e2 on(e1.mgr = e2.empno);

-- join using �ȿ� ���°� ��Ī�� ���� �� ����

-- quiz 1
--empno, ename, dname, loc ��� : ��� 14��

select empno, ename, dname, loc
from emp, dept
where emp.deptno = dept.deptno;

select e.empno, e.ename, d.dname, d.loc
from emp e join dept d using(deptno);

select empno, ename, dname, loc
from emp left outer join dept on(emp.deptno = dept.deptno);

-- quiz 2
-- ���, �̸�, �μ���, �޿������ ��� : ��� 14��

select e.empno, e.ename, d.dname, s.grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno
and e.sal >= s.losal and e.sal <= s.hisal;

select e.empno, e.ename, d.dname, s.grade
from salgrade s , emp e join dept d using (deptno)
where (e.sal >= s.losal and e.sal <= s.hisal);

select e.empno, e.ename, d.dname, s.grade
from emp e
left outer join dept d on(e.deptno = d.deptno)
left outer join salgrade s on (e.sal >= s.losal and e.sal <= s.hisal);

select e.empno, e.ename, d.dname, s.grade
from emp e
inner join dept d
on e.deptno = d.deptno
inner join salgrade s 
on e.sal >= s.losal and e.sal <= s.hisal;

-- quiz 3 
-- �Ŵ��� ���� ������ ���� ����� �̸�, �޿�, �Ŵ��� �̸�, �Ŵ��� �޿�

select e1.ename, e1.sal, e2.ename, e2.sal
from emp e1, emp e2
where e1.mgr = e2.empno and e1.sal > e2.sal;

-- q1
select d.deptno, d.dname, e.empno, e.ename, e.sal
from emp e, dept d
where e.deptno = d.deptno and sal > 2000
order by deptno;

-- q2
select d.deptno, d.dname, trunc(avg(sal),0) as AVG_SAL, max(sal) as MAX_SAL, min(sal) as MIN_SAL, count(*)as CNT
from emp e, dept d
where e.deptno = d.deptno
group by d.deptno, d.dname ;

select d.deptno, d.dname, trunc(avg(sal),0) as AVG_SAL, max(sal) as MAX_SAL, min(sal) as MIN_SAL, count(*)as CNT
from emp e left outer join dept d on (e.deptno = d.deptno)
group by d.deptno, d.dname;
-- q3

select d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
from dept d left outer join emp e on(e.deptno = d.deptno)
order by deptno, ename;

select sal from emp where ename ='JONES';

select * from emp
where sal >(select avg(sal) from emp);

select * from emp
where sal >(select sal from emp where ename ='JONES');

select * from emp
where sal>(select sal from emp where ename ='BLAKE');

select * from emp
where job = (select job from emp where ename ='JONES');

select * from emp
where sal in (
select max(sal) from emp group by deptno
);

select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e1.sal, e1.deptno, s.losal, s.hisal, s.grade, e2.empno, e2.ename
from dept d
left outer join emp e1  on(e1.deptno = d.deptno)
left outer join emp e2 on(e1.mgr = e2.empno)
left outer join salgrade s on(e1.sal >= s.losal and e1.sal <= s.hisal)
order by d.deptno, e1.empno;

select * from (select * from emp where deptno =10);
select * from emp where deptno =10;

select rownum, emp.*
from emp
-- where rownum = 2;
order by ename
;

select rownum, e.*
from (
    select * from emp order by ename
) e;

select count(*) from emp
group by job
having count(*) > =3;

// count(*)�� where���� ���ڰ� �ƴ� ������ �ൿ���� �ν��ϱ� ������ where�� ������
//  ��Ī�� �ٿ��־�� �Ѵ�
select *
from (select job, count(*) cnt from emp
        group by job)
where cnt >= 3;

with e10 as (
        select * from emp where deptno = 10
)
select * from e10;

-- q1
select e.job, e.empno, e.ename, e.sal, d.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno and job = (select job from emp where ename = 'ALLEN')
order by sal desc, ename;

-- q2
select avg(sal) from emp ;

select e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal, s.grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno
   and (e.sal >= s.losal and e.sal <= s.hisal)
   and e.sal > (select avg(sal) from emp)
   order by e.sal desc, e.empno;
-- q3
select e.empno, e.ename , e.job, d.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
    and d.deptno = 10 and job not in (select job from emp where deptno =30
group by job);

-- q4
select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where (e.sal >= s.losal and e.sal <= s.hisal)
and e.sal > (select max(sal)from emp where job = 'SALESMAN')
order by empno;

select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where (e.sal >= s.losal and e.sal <= s.hisal)
and sal > all(select sal from emp where job = 'SALESMAN'
group by sal)
order by e.empno;

-- 12��
select * from emp;
desc emp;

creat table emp_ddl (
    empno number(4), -- ���� ���ڸ�
    ename varchar2(10), -- 10 ����Ʈ
    job varchar2(9),    -- ���Ѻ��� ���� �۾��� ������ �۾� ��ŭ�� ������ ����
    mgr number(4),      -- mgr �� number (4)�� ������ empno�� �����Ǿ�� �ϹǷ� ���� ������ ������ �ϱ� �����̴�
    hiredate date,
    sal number(7, 2),   -- 2�� �Ҽ��� ��°�ڸ����� ����� �� �ִ�
    comm number(7,2),
    deptno number(2)
);