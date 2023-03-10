package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Department department;

        System.out.println("==== TEST 1: Department insert ====");
        Department newDepartment = new Department(null, "Music");

        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n==== TEST 2: Department update ====");
        department = departmentDao.findById(6);
        department.setName("Box");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println("\n==== TEST 3: department findById ====");
        department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n==== TEST 4: department delete ====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        System.out.println("\n==== TEST 5: department findAll ====");
        List<Department> list = departmentDao.findAll();
        for(Department obj : list) {
            System.out.println(obj);
        }
    }
}
