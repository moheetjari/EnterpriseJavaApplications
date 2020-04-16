/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import beans.departmentBeanLocal;
import entity.Department;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author admin
 */
@Named(value = "departmentCDIBean")
@RequestScoped
public class departmentCDIBean {

    @EJB
    departmentBeanLocal deptBean;

    int Id;
    String DepartmentName;

    public departmentCDIBean() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public Collection<Department> getAllDepartments() {
        System.out.println(deptBean.getAllDepartments());
        return deptBean.getAllDepartments();
    }

    public String addDepartment() {
        System.out.println(this.Id);
        if (this.Id != 0) {
            deptBean.updateDepartment(this.Id, this.DepartmentName);
        } else {
            deptBean.addDepartment(this.DepartmentName);
        }
        return "index.xhtml";
    }

    public String deleteDepartment(String departmentId) {
        deptBean.deleteDepartment(Integer.parseInt(departmentId));
        return "index.xhtml";
    }

    public String getDepartment(String departmentId) {
        Department d = deptBean.getDepartment(Integer.parseInt(departmentId));
        this.Id = d.getId();
        this.DepartmentName = d.getDepartmentName();
        return "adddept.xhtml";
    }

}
