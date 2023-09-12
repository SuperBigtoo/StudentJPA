/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Jason
 */
public class StudentJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Example
        //Get All Students
        System.out.println("Get All Students");
        List<Student> stdListAll = StudentControllerTable.findAllStudent();
        printList(stdListAll);
        
        //Get Student by id
        System.out.println("Get Student by id");
        List<Student> stdListByID = StudentControllerTable.findStudentById(1);
        printList(stdListByID);
        
        //Get Student by name
        System.out.println("Get Student by name");
        List<Student> stdListByName = StudentControllerTable.findStudentByName("James");
        printList(stdListByName);
    }
    
    public static void printList(List<Student> stdList) {
        for (Student std : stdList) {
           System.out.print(std.getId()+" ");
           System.out.print(std.getName()+" ");
           System.out.println(std.getGpa()+" ");
        }
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
