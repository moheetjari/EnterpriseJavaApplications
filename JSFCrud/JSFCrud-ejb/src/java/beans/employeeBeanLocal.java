/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Employee;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface employeeBeanLocal {

    Collection<Employee> getAllEmployees();

    void addEmployee(String employeeName, int salary, int departmentId, String gender, String city);

    Employee getEmployee(int Id);

    void updateEmployee(int Id, String employeeName, int salary, int departmentId, String gender, String city);

    void deleteEmployee(int Id);
}
