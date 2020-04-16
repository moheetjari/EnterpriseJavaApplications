/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Department;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class departmentBean implements departmentBeanLocal {
    
    @PersistenceContext(unitName = "empPU")
    private EntityManager em;
    
    @Override
    public Collection<Department> getAllDepartments() {
        return em.createNamedQuery("Department.findAll").getResultList();
    }
    
    @Override
    public void addDepartment(String departmentName) {
        Department department = new Department();
        department.setDepartmentName(departmentName);
        em.persist(department);
    }
    
    @Override
    public Department getDepartment(int Id) {
        return em.find(Department.class, Id);
    }
    
    @Override
    public void updateDepartment(int Id, String departmentName) {
        Department department = em.find(Department.class, Id);
        department.setId(Id);
        department.setDepartmentName(departmentName);
        
        em.merge(department);
    }
    
    @Override
    public void deleteDepartment(int Id) {
        Department department = em.find(Department.class, Id);
        em.remove(department);
    }
}
