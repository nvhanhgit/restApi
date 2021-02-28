package com.dhtbank.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhtbank.Model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Query("select e from Employee e where e.userName=?1 AND e.passWord=?2 ")
	Employee findEmployeeByUserNameAndPassword(String userName, String passWord);


}
