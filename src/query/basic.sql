-- 1
select concat(first_name, ' ', last_name)
from employees
where emp_no = 10944;

-- 2
select first_name, last_name, gender, hire_date
from employees
order by hire_date desc;

-- 3-1
select count(*)
from employees
where gender='f';

-- 3-2
select count(*)
from employees
where gender='m';

-- 4
select count(*)
from salaries;

-- 5
select distinct count(dept_name)
from departments

-- 6
select count(*)
from dept_manager;

-- 7
select distinct dept_name
from departments
order by length(dept_name);

-- 8
select count(*)
from salaries
where (salary >= 12000);

-- 9
select distinct title
from titles
order by length(title) desc;

-- 10
select count(*)
from titles
where title = 'Engineer';

-- 11
select from_date, to_date, title
from titles
where emp_no = 13250
order by from_date asc;
