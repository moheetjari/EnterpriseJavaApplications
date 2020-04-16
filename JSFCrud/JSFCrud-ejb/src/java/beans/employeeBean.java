/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Department;
import entity.Employee;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class employeeBean implements employeeBeanLocal {

    @PersistenceContext(unitName = "empPU")
    private EntityManager em;

    @Override
    public Collection<Employee> getAllEmployees() {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }

    @Override
    public void addEmployee(String employeeName, int salary, int departmentId, String gender, String city) {
        Department department = em.find(Department.class, departmentId);
        Collection<Employee> employees = department.getEmployeeCollection();

        Employee employee = new Employee();
        employee.setEmployeeName(employeeName);
        employee.setSalary(salary);
        employee.setDepartmentId(department);
        employee.setGender(gender);
        employee.setCity(city);

        employees.add(employee);
        department.setEmployeeCollection(employees);

        em.persist(employee);
        em.merge(department);
    }

    @Override
    public void updateEmployee(int Id, String employeeName, int salary, int departmentId, String gender, String city) {
        Department department = em.find(Department.class, departmentId);
        Collection<Employee> employees = department.getEmployeeCollection();

        Employee employee = em.find(Employee.class, Id);

        employee.setId(Id);
        employee.setEmployeeName(employeeName);
        employee.setSalary(salary);
        employee.setDepartmentId(department);
        employee.setGender(gender);
        employee.setCity(city);

        employees.add(employee);
        department.setEmployeeCollection(employees);

        em.merge(employee);
        em.merge(department);
    }

    @Override
    public void deleteEmployee(int Id) {
        Employee employee = em.find(Employee.class, Id);
        em.remove(employee);
    }

    @Override
    public Employee getEmployee(int Id) {
        return em.find(Employee.class, Id);
    }

}
