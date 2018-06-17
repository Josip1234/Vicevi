package com.jokes.vicevi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Object;

public class ObjectComparator
{
	 // create simple class
	 public static class Employee
	 {
		 String id;
		 String name;
		 int salary;

		 public Employee(String id, String name, int salary)
		 {
			 this.id = id;
			 this.name = name;
			 this.salary = salary;
		 }

		 public String getID()
		 {
			 return id;
		 }

		 public String getName()
		 {
			 return name;
		 }

		 public int getSalary()
		 {
			 return salary;
		 }

		 // Make anonymous inner class to sort by member variable 'id'
		 public static Comparator<Employee> SortByEmployeeID = new Comparator<Employee>()
		 {
			 @Override
			 public int compare(Employee employee1, Employee employee2)
			 {
				 return employee1.getID().compareTo(employee2.getID());
			 }
		 };

		// Make anonymous inner class to sort by member variable 'Name'
		public static Comparator<Employee> SortByEmployeeName = new Comparator<Employee>()
		{
			public int compare(Employee employee1, Employee employee2)
			{
			 return employee1.getName().compareTo(employee2.getName());
			}
		};

		// Make anonymous inner class to sort by member variable 'salary' - integer instead of string
		public static Comparator<Employee> SortBySalary = new Comparator<Employee>()
		{
			public int compare(Employee employee1, Employee employee2)
			{
				return employee1.getSalary() - employee2.getSalary();
			}
		};

		// Make anonymous inner class to sort by member variable 'salary' - Descending
		public static Comparator<Employee> SortBySalaryDescending = new Comparator<Employee>()
		{
			public int compare(Employee employee1, Employee employee2)
			{
				// simply reverse for descending
				return employee2.getSalary() - employee1.getSalary();
			}
		};

		public String toString()
		{
		 return "Employee ID:" + id + "\n" + "Name:" + name + "\n"
		 		+ "Salary: " + salary + "\n";
		}
	 }

	public static void main (String args[])
	{

		// Make list and add some Employees
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("7123r","Dole, Bob", 42000));
		employeeList.add(new Employee("1234d","Johnson, John", 150000));
		employeeList.add(new Employee("2345x","Billson, Bill", 35000));
		employeeList.add(new Employee("0019b","Dickerson, Dick", 10000));

		// Display unsorted list
		System.out.println("Unsorted ==========================");
		for (Employee current : employeeList)
		{
			System.out.println(current);
		}

		// sort by id
		Collections.sort(employeeList, Employee.SortByEmployeeID);

		System.out.println("Sorted by ID =========================");

		for (Employee current : employeeList)
		{
			System.out.println(current);
		}

		// sort by name
		Collections.sort(employeeList, Employee.SortByEmployeeName);

		System.out.println("Sorted by NAME =========================");

		for (Employee current : employeeList)
		{
			System.out.println(current);
		}

		// sort by salary
		Collections.sort(employeeList, Employee.SortBySalary);

		System.out.println("Sorted by SALARY =========================");

		for (Employee current : employeeList)
		{
			System.out.println(current);
		}

		// sort by salary - descending
		Collections.sort(employeeList, Employee.SortBySalaryDescending);

		System.out.println("Sorted by SALARY DESCENDING=========================");

		for (Employee current : employeeList)
		{
			System.out.println(current);
		}


	}
}