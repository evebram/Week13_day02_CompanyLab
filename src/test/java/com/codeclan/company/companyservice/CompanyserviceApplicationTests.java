package com.codeclan.company.companyservice;

import com.codeclan.company.companyservice.models.Department;
import com.codeclan.company.companyservice.models.Employee;
import com.codeclan.company.companyservice.models.Project;
import com.codeclan.company.companyservice.repositories.DepartmentRepository;
import com.codeclan.company.companyservice.repositories.EmployeeRepository;
import com.codeclan.company.companyservice.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyserviceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void addEmployeeAndDepartment(){
		Department department1 = new Department("HR");
		departmentRepository.save(department1);
		Employee employee1 = new Employee("Harry", "Hood", 12345, department1);
		employeeRepository.save(employee1);
	}

	@Test
	public void addEmployeesAndProjects(){
		Department department2 = new Department("Finance");
		departmentRepository.save(department2);

		Employee employee2 = new Employee("Josiah", "Bartlett", 5673, department2);
		employeeRepository.save(employee2);

		Project project1 = new Project("Get Trump Out", 21);
		projectRepository.save(project1);

		project1.addEmployee(employee2);
		projectRepository.save(project1);

	}

}
