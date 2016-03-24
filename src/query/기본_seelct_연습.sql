-- 기본 select 연습

  SELECT * 
   FROM departments;
  
 SELECT first_name AS 이름, gender AS 성별, hire_date AS '입사한 날'
  FROM employees;  

 SELECT CONCAT( first_name, ' ', last_name) AS '이름', gender AS '성별', hire_date AS '입사한 날'
  FROM employees;
  
SELECT DISTINCT title
 FROM titles;  

     SELECT CONCAT( first_name, ' ', last_name) AS '이름', gender AS '성별', hire_date AS '입사한 날'
      FROM employees
ORDER BY hire_date ASC;

     SELECT CONCAT( first_name, ' ', last_name) AS '이름', gender AS '성별', hire_date AS '입사한 날'
      FROM employees
ORDER BY hire_date DESC;


     SELECT CONCAT( first_name, ' ', last_name) AS '이름', gender AS '성별', hire_date AS '입사한 날'
      FROM employees
ORDER BY hire_date ASC, CONCAT( first_name, ' ', last_name) ASC;

     SELECT CONCAT( first_name, ' ', last_name) AS '이름', gender AS '성별', hire_date AS '입사한 날'
      FROM employees
	WHERE hire_date < '1991-1-1'  
ORDER BY hire_date ASC, CONCAT( first_name, ' ', last_name) ASC;

    SELECT CONCAT( first_name, ' ', last_name) AS '이름', gender AS '성별', hire_date AS '입사한 날'
      FROM employees
	WHERE hire_date < '1989-1-1'
	    AND gender = 'f'  
ORDER BY hire_date ASC, CONCAT( first_name, ' ', last_name) ASC;
 
 
     SELECT CONCAT( first_name, ' ', last_name) AS '이름', gender AS '성별', hire_date AS '입사한 날'
      FROM employees
	WHERE hire_date BETWEEN '2000-1-1' AND '2016-12-31'
	    AND gender = 'f'  
ORDER BY hire_date ASC, CONCAT( first_name, ' ', last_name) ASC;  

    SELECT CONCAT( first_name, ' ', last_name) AS '이름', gender AS '성별', hire_date AS '입사한 날'
      FROM employees
	WHERE ( '2000-1-1' <= hire_date AND hire_date <= '2016-12-31' )
	    AND gender = 'f'  
ORDER BY hire_date ASC, CONCAT( first_name, ' ', last_name) ASC;

  SELECT emp_no, dept_no
   FROM dept_emp
  WHERE dept_no in ( 'd005', 'd009' );

-- LIKE  
     SELECT CONCAT( first_name, ' ', last_name) AS '이름', gender AS '성별', hire_date AS '입사한 날'
      FROM employees
	WHERE ('1991-1-1' <= hire_date AND hire_date <= '1991-12-31' )  
ORDER BY hire_date ASC;

     SELECT CONCAT( first_name, ' ', last_name) AS '이름', gender AS '성별', hire_date AS '입사한 날'
      FROM employees
	WHERE hire_date LIKE '%1991%'  
ORDER BY hire_date ASC;
    
	
select * from salaries where emp_no = 10001 and to_date='9999-1-1';	

select count(*) from salaries where to_date='9999-1-1' AND salary > 120000;
