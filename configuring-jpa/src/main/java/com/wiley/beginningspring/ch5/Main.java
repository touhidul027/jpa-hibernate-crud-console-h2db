package com.wiley.beginningspring.ch5;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    
    public static void main(String[] args) {
    	
    	System.out.println("Start : ");
        EntityManagerFactory entityManagerFactory = 
        			Persistence.createEntityManagerFactory("test-jpa");

	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    // First part 
	 //   EntityTransaction transaction = entityManager.getTransaction();
	    
	   // transaction.begin();
	    
	    // create the entity object
//	    Student student = new Student() ; 
//	    student.setFirstName("touhidul");
//	    student.setLastName("islam");
//	    
//	    Book book1 = new Book() ; 
//	    book1.setName("b1");
//	    
//	    Book book2 = new Book() ; 
//	    book2.setName("b2");
//	    
//	    student.getBooks().add(book1) ; 
//	    student.getBooks().add(book2) ; 
//	     
//	    // save it to the h2 database 
//	    entityManager.persist(student);
//	    transaction.commit();	    
	   
	    
	    // second part
	    
	    // just for interupting 
	   // new Scanner(System.in).nextInt() ; 
	    
	    EntityTransaction transactionForUpdateDelete = entityManager.getTransaction();	    
	    transactionForUpdateDelete.begin(); 
	    
	    // update a student information 
	    Student studentForUpdate = entityManager.find(Student.class, 1L); // student id is 1
	    studentForUpdate.setFirstName("Mohaiminul");
	    studentForUpdate.setLastName("Islam");
	    
	    // for deleting the book whose id is 2
	    Book book2ForDelete = entityManager.getReference(Book.class, 2L) ; 
	    entityManager.remove(book2ForDelete);
	    
	    transactionForUpdateDelete.commit();
	    entityManager.close();
	    
	    
	    System.out.println("Done ");       
    }
}
