/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import beans.employeeBeanLocal;
import entity.Department;
import entity.Employee;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author admin
 */
@Named(value = "employeeCDIBean")
@RequestScoped
public class employeeCDIBean {

    @EJB
    employeeBeanLocal empBean;

    int Id, Salary, departmentId;
    String EmployeeName, Gender, City;
    Collection<Department> departments;

    public employeeCDIBean() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }

    public Collection<Employee> getAllEmployees() {
        return empBean.getAllEmployees();
    }

    public String addEmployee() {
        System.out.println(this.Id + " " + this.EmployeeName + " " + this.Salary + " " + this.departmentId + " " + this.Gender + " " + this.City);
        if (this.Id != 0) {
            empBean.updateEmployee(this.Id, this.EmployeeName, this.Salary, this.departmentId, this.Gender, this.City);
        } else {
            empBean.addEmployee(this.EmployeeName, this.Salary, this.departmentId, this.Gender, this.City);
        }
        return "index.xhtml";
    }

    public String getEmployee(String employeeId) {
        Employee e = empBean.getEmployee(Integer.parseInt(employeeId));
        this.Id = e.getId();
        this.EmployeeName = e.getEmployeeName();
        this.City = e.getCity();
        this.departmentId = e.getDepartmentId().getId();
        this.Gender = e.getGender();
        this.Salary = e.getSalary();

        return "addemp.xhtml";
    }

    public String deleteEmployee(String employeeId) {
        empBean.deleteEmployee(Integer.parseInt(employeeId));
        return "index.xhtml";
    }

}
