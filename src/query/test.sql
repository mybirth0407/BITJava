select ;

select de.dept_no, e.emp_no, d.dept_name
from dept_emp de, employees e, departments d
where de.emp_no = e.emp_no
    and de.dept_no = d.dept_no;