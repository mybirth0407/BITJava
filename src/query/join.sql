-- 1
select s.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름', s.salary as '연봉'
from employees e, salaries s
where e.emp_no = s.emp_no
and to_date <> '9999-01-01'
order by s.salary desc;

-- 2
select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름', t.title as '현재 직책'
from employees e, titles t
where e.emp_no = t.emp_no
order by concat(e.first_name, ' ', e.last_name) asc;

-- 3
select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름', d.dept_name as '현재 부서'
from employees e, dept_emp de, departments d, dept_manager dm
where e.emp_no = de.emp_no
and e.emp_no = dm.emp_no
order by concat(e.first_name, ' ', e.last_name) asc;

-- 4
select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름',
	s.salary as '연봉', t.title as '직책',	d.dept_name as '부서'
from employees e, dept_emp de, departments d, salaries s, titles t, dept_manager dm
where e.emp_no = de.emp_no
and e.emp_no = t.emp_no
and e.emp_no = dm.emp_no
order by concat(e.first_name, ' ', e.last_name) asc;

-- 5
select e.emp_no as '사번', concat(e.first_name, ' ', e.last_name) as '이름'
from employees e, titles t
where e.emp_no = t.emp_no
and t.title = 'Technique Leader'
and t.to_date <> '9999-01-01';

-- 6
select concat(e.first_name, ' ', e.last_name) as '이름', d.dept_name as '부서',
	t.title as '직책'
from employees e, titles t, dept_emp de, dept_manager dm, departments d
where e.emp_no = t.emp_no
and e.emp_no = de.emp_no
and e.emp_no = dm.emp_no
and de.dept_no = d.dept_no
and dm.dept_no = d.dept_no
and e.last_name like 'S%';

-- 7
select concat(e.first_name, ' ', e.last_name) as '이름'
from employees e, salaries s, titles t
where e.emp_no = t.emp_no
and e.emp_no = s.emp_no
and s.to_date = '9999-01-01'
and t.title = 'Engineer'
and s.salary >= 40000
order by s.salary desc;

-- 8
select t.title as '직책', s.salary as '급여'
from titles t, salaries s
where t.emp_no = s.emp_no
and t.to_date = '9999-01-01'
and s.salary > 50000
order by s.salary desc;

-- 9
select d.dept_name, avg(s.salary) as '부서별 평균 연봉'
from salaries s, departments d, dept_emp de
where d.dept_no = de.dept_no
and de.emp_no = s.emp_no
group by de.dept_no
order by avg(s.salary) desc;

-- 10
select t.title, avg(s.salary) as '직책별 평균 연봉'
from titles t, salaries s
where t.emp_no = s.emp_no
group by t.title
order by avg(s.salary) desc;

