/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Department;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface departmentBeanLocal {

    Collection<Department> getAllDepartments();

    void addDepartment(String departmentName);

    Department getDepartment(int Id);

    void updateDepartment(int Id, String departmentName);

    void deleteDepartment(int Id);
}
