package com.spring.orm2;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm2.dao.PersonDao;
import com.spring.orm2.entities.Person;

public class App {
	public static void main(String[] args) {

		System.out.println("Using ORM with Spring to perform CRUD operations.");

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm2/orm2config.xml");
		PersonDao pd = (PersonDao) context.getBean("personDao");

		Person person = new Person();


		Scanner sc = new Scanner(System.in);
		boolean condition = true;
		while (condition) {
			System.out.println("Press 1 for insert a data");
			System.out.println("Press 2 for select a single data");
			System.out.println("Press 3 for select all data");
			System.out.println("Press 4 for delete a single data");
			System.out.println("Press 5 for update a data");
			System.out.println("Press 6 for EXIT");

			try {
				int input = sc.nextInt();
				switch (input) {
				case 1:
					System.out.println("****************************************");
					System.out.println("You are at Insertion");
					System.out.println("Enter Id : ");
					int personId = sc.nextInt();
					sc.nextLine();
					person.setPersonId(personId);
					System.out.println("Enter Name : ");
					String personName = sc.nextLine();
					person.setPersonName(personName);
					System.out.println("Enter Ciry : ");
					String personCity = sc.nextLine();
					person.setPersonCity(personCity);
					int id = pd.insert(person);
					System.out.println("1 row inserted with id = " + id);	
					System.out.println("****************************************");
					break;

				case 2:
					System.out.println("****************************************");
					System.out.println("You are at Selection of single Person detail");
					System.out.println("Enter Id : ");
					int pId = sc.nextInt();
					Person p1 = pd.getPerson(pId);
					System.out.println("-----------------------------------------------");
					System.out.println("Id : "+p1.getPersonId());
					System.out.println("Name : "+p1.getPersonName());
					System.out.println("City : "+p1.getPersonCity());
					System.out.println("-----------------------------------------------");
					break;

				case 3:
					System.out.println("****************************************");
					System.out.println("You are at Selection of all Person detail");
					List<Person> personList = pd.getTable();
					for(Person p : personList) {
						System.out.println("-----------------------------------------------");
						System.out.println("Id : "+p.getPersonId());
						System.out.println("Name : "+p.getPersonName());
						System.out.println("City : "+p.getPersonCity());
						System.out.println("-----------------------------------------------");
					}
					break;

				case 4:
					System.out.println("****************************************");
					System.out.println("You are at Deleting of single Person detail");
					System.out.println("Enter Id : ");
					int perId = sc.nextInt();
					pd.delete(perId);
					System.out.println("Deleted successfully!");
					break;

				case 5:
					System.out.println("****************************************");
					System.out.println("You are at Updating");
					System.out.println("Enter Id : ");
					int persnId = sc.nextInt();
					sc.nextLine();
					person.setPersonId(persnId);
					System.out.println("Enter Name : ");
					String persnName = sc.nextLine();
					person.setPersonName(persnName);
					System.out.println("Enter Ciry : ");
					String persnCity = sc.nextLine();
					person.setPersonCity(persnCity);
					pd.update(person);
					System.out.println("1 row Updated successfully ");	
					System.out.println("****************************************");
					break;

				case 6:
					condition = false;
					break;

				default: System.out.println("read the prompt carefully and try with correct input value");
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid input try with correct one");
				System.out.println(e.getMessage());
			}

		}
		
		System.out.println("You are out now");

	}
}
