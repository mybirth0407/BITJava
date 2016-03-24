-- 1
select max(salary) as "최고임금",
min(salary) as "최저임금",
(max(salary) - min(salary)) as "최고임금 - 최저임금"
from salaries;

-- 2
select date_format(max(hire_date), "%Y년 %m월 %d일") as "마지막으로 신입사원이 들어온 날" from employees

-- 3
select date_format(from_date, "%Y년 %m월 %d일") as "가장 오래 근속한 직원의 입사일",
max(if(to_date = "9999-01-01", to_days(current_time), to_days(to_date))) - min(to_days(from_date)) year_of_service
from title group by emp_no
order by year_of_service desc limit 1;

select date_format(from_date, "%Y년 %m월 %d일") as "가장 오래 근속한 직원의 입사일"
from titles group by emp_no
order by (max(if(to_date = "9999-01-01", to_days(current_time), to_days(to_date))) - min(to_days(from_date))) desc limit 1;

-- 4
select avg(salary) as "현재 이 회사의 평균 연봉"
from salaries where to_date = "9999-01-01";

-- 5
select min(salary) as "현재 이 회사의 최고 연봉", max(salary) as "현재 이 회사의 최저 연봉"
from salaries where to_date = "9999-01-01";

-- 6
select (max((year(current_time) - year(birth_date))) + 1) as "최연장자 나이",
(min((year(current_time) - year(birth_date))) + 1) as "최고 어린 사원의 나이"
from employees;