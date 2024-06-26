-- 한줄 주석
/* 범위 주석 */
select 
    * -- 모든 컬럼
from 
    emp;
-- sql developer 자동 정렬 단축키: ctrl + F7

select 
    empno, ename, deptno
from 
    emp;
    
select * from dept;
select * from salgrade;

select deptno from emp;
-- 한줄 복사 단축키 : ctrl + shift + d

-- distinct : select에서 중복되는 자료를 제거해준다
select distinct deptno from emp;
select distinct job from emp;

select deptno, job from emp;
-- 컬럼이 여러개인 경우 컬럼들의 조합이 중복되는걸 제거한다
select  distinct deptno, job from emp;

-- null과 연산하면 무조건 null이다
select ename, sal, sal*12+comm,comm from emp;

-- 컬럼명에 별칭 사용
-- " 생략가능
-- 별칭안에 띄어쓰기가 있는 경우 "생략 불가
-- 가능하면 띄어쓰기보다 _를 넣자
-- as 생략가능
select ename, sal, sal*12+comm as "new_sal",comm from emp;

-- order by = 해당 컬럼으로 정렬
-- 오름차순 : asc 생략가능
-- 내림차순 : desc 
select * from emp
order by sal asc;

select * from emp
order by comm;

select * from emp
order by sal desc;

-- order by 첫번째거로 정렬하고(1순위)
-- 그 중에 같은게 있다면 다음거로 정렬하고 (2순위)
-- 그 중에 같은게 있다면 다음거로 정렬하고 (3순위)
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
-- 문자를 쓸때 "가 아닌 '을 써야 한다
where ename = 'king';

select * from emp
where deptno = 30
and job = 'SALESMAN';

select * from emp
where job = 'CLERK'
AND deptno = 30;

select * from emp
where job = 'CLERK'
AND (deptno = 30 or deptno = 20); -- and는 or 보다 우선순위가 더 우위에 있다

select * from emp
where sal >= 2000 and sal < 3000;

select * from emp
--where sal != 3000;
where sal <> 3000; -- 위의 문장이랑 동일하다

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

-- %는 어떤거든 관계없음
select * from emp
where ename like 'S%';

select * from emp
where ename like 'A%';

-- _는 딱 한글자인데 어떤 글자던 관계 없음
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

-- emp에서 deptno가 10 또는 20인 사원의
-- empno, ename,sal, deptno를 출력하세요
select empno, ename, sal, deptno from emp
--where deptno = 10 or deptno = 20;
where deptno in (10,20);

-- 서로 다른 조회 결과물을 합쳐줍니다.
-- 단, 조회한 칼럼의 개수, 타입이 같아야 한다.
select empno, ename, sal, deptno from emp
where deptno =10 
union
select empno, ename, sal, deptno from emp
where deptno =20;

-- union : 중복된 자료를 제거해줌
select empno, ename, sal, deptno from emp
where deptno =10 
union
select empno, ename, sal, deptno from emp
where deptno =10;

-- union all : 중복에 관계없이 합쳐준다
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

-- upper, lower는 대소문자 구분 없이 like 할때 딱 좋다 
select * from emp
where lower (ename) like lower ('%Mi%');

select ename, length(ename)
from emp;

-- length: 문자개수
select * from emp
where length(ename) >= 5;

-- dual : 임시 테이블 (콘솔 처럼 테스트 하거나 임시를 확인을 할때 주로 쓰인다) 
select length('한'), lengthb('한') from dual;

-- substr : 대상이되는 문자, 시작위치, 가져올 개수
-- 가져올 개수를 안쓰거나 너무 크면 끝까지
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

-- lpad : 대상이 되는 문자 : 전체 자리수, 채울 문자 
-- 채울 문자 생략 시 공백문자
select
job,
lpad(job, 10, '#'),
lpad(job, 4, '#')
from emp;

select
    job, length(job), 15-length(job)
from emp;

-- 문자열 더하기
select empno || ename || '님'
from emp;

-- trim : 앞 뒤 공백 제거
-- 글씨 사이의 공백은 제거하지 않음
select
    '    a b c    ',
    trim('    a b c    ')
from dual;

-- 실습문제 1
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

-- 실습문제2
-- 사원의 이름을 앞에 두자리만 보이게 하고 나머지는 *로 표시
-- 정답의 예 : WARD -> WA**, MARTIN -> ma****


select ename, 
rpad(substr(ename,1,2), length(ename),'*')
from emp;

-- 실습문제3
-- 앞글자 하나만
-- WARD -> *ARD, MARTIN ->*ARTIN

select ename, 
lpad(substr(ename,2,length(ename)),length(ename),'*')
from emp;

-- 실습문제4
-- 두번째 글씨만 *
-- WARD -> W*RD, M*RTIN
select ename, 
rpad(substr(ename,1,1),2,'*')
|| substr(ename,3,length(ename)-2)
from emp;

-- 실습문제5
-- 가운데 글씨만 *
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
    
    -- sysydate : 지금 오라클 pc의 시간이 나옵니다
    -- 강사 pc는 9시간 차이 난다(영국 0시 기준 한국 +9시)
    -- 날짜 정보 중 일부만 select로 표시 됨
    select sysdate, sysdate+1, sysdate-1 from dual;
    
    
    -- 컬럼에 +를 적으면 모두 숫자로 변경해서 적용함
    -- || 숫자도 문자로 적용
    -- 9시간을 추가하는 방법 (현재 오라클 시간은 영국시간으로 맞추어져 있음)
    select 
    -- 대소 문자를 구분 안하는 언어에서는 대부분 달은 mm 분은 mi를 쓰고 
    -- 대소 문자를 구분하는 언어(ex 자바)에서는 대부분 M은 월 m은 분을 의미한다
        to_char(sysdate+(9/24), 'yyyy"년" mm"월" dd"일" hh24"시" mi"분" ss"초"')
    from dual;
    
    select
        sysdate - to_date('2024-05-07', 'yyyy-mm-dd')
        from dual;
        
    -- 특정날짜를 기록할때 시간을 넣지않으면 0시 0분 0초로 표시된다
        select 
        to_char(to_date('2024-05-07', 'yyyy-mm-dd'), 'yyyy"년" mm"월" dd"일" hh24"시" mi"분" ss"초"')
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

-- case문은 switch처럼 쓸수 있는 방법과 input처럼 사용할 수 있는 방법이 있다
-- case문이 decode보다 더 넒은 범위에서 쓰일 수 있으므로 case를 주로 쓴다


-- 열은 항상 동일한 기준을 가지고 있어야 하므로(숫자면 숫자 ,문자면 문자) 
-- else 부분의 comm(숫자)을 to_char 함수로 숫자에서 문자로 만들어 주었다
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
   next_day(add_months(hiredate,3),2)as R_JOB, -- 일욜1, 월욜2,...,토욜7
--    comm,
--    nvl(to_char(comm),'N/A'),
--    to_char(null)
--    from emp;
    case when comm is null then'N/A'
    else to_char(comm)
    end as COMM,
    decode(comm, null, 'N/A',comm) -- decode는 to_char 안써도 알아서 해줌
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
    
-- count처럼 null은 제외됨
-- count는 *를 많이 씀
select sum(sal), count(sal), count(*), count(comm) from emp; -- sum은 하나로 합쳐질때만 쓸 수 있다 여러줄 과 같이 나올 수 없다

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

-- distinct 처럼 중복을 제거해줌, 분류해줌
-- slect에는 group by한 것이나 다중행 함수(집계 함수)
select deptno, avg(sal), sum(sal), count(*) from emp
group by deptno;

select deptno, empno, sum(sal), count(*) from emp
group by deptno, empno; -- 겹치는 애들이 없어 의미가 없음

select deptno, job, count(*)
from emp
--where count(*) >= 2
group by deptno, job
order by deptno, job;

-- having : group by에서만 사용된다/
-- 집계함수 조건으로 걸고 싶은 경우에 사용
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
-- 테이블 두개 이상 조회할때 관계를 꼭 알려줘야 원하는 정보만 출력된다
-- 전체 테이블 수 -1개의 조건이 적당하다

-- 별칭을 한번 지정해 줬으면 원래의 이름을 사용해도 쓸 수 없다
select *
from emp e, dept d
 where e.deptno = d.deptno;
-- where emp.deptno = d.deptno;

-- *와 컬럼을 같이 쓰는 경우 *에 테이블을 지정해줘야 한다.
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

-- left outer join이란? 왼쪽 테이블을 모두 출력하는걸 보장해준다(null값도 출력이 가능하다)
select *
from emp e1 left outer join emp e2 on(e1.mgr = e2.empno);

-- join using 안에 들어가는건 별칭을 정할 수 없다

-- quiz 1
--empno, ename, dname, loc 출력 : 결과 14줄

select empno, ename, dname, loc
from emp, dept
where emp.deptno = dept.deptno;

select e.empno, e.ename, d.dname, d.loc
from emp e join dept d using(deptno);

select empno, ename, dname, loc
from emp left outer join dept on(emp.deptno = dept.deptno);

-- quiz 2
-- 사번, 이름, 부서명, 급여등급을 출력 : 결과 14줄

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
-- 매니저 보다 월급이 높은 사원의 이름, 급여, 매니저 이름, 매니저 급여

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

// count(*)는 where에서 글자가 아닌 별도의 행동으로 인식하기 때문에 where를 쓰려면
//  별칭을 붙여주어야 한다
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

-- 12장
select * from emp;
desc emp;

creat table emp_ddl (
    empno number(4), -- 숫자 네자리
    ename varchar2(10), -- 10 바이트
    job varchar2(9),    -- 제한보다 적은 글씨가 적히면 글씨 만큼의 공간만 차지
    mgr number(4),      -- mgr 이 number (4)인 이유는 empno에 대응되어야 하므로 같은 형식을 가져야 하기 때문이다
    hiredate date,
    sal number(7, 2),   -- 2는 소수점 둘째자리까지 기록할 수 있다
    comm number(7,2),
    deptno number(2)
);