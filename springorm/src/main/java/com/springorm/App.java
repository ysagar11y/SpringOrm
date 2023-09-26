package com.springorm;

import java.io.BufferedReader;
import java.util.List;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.Entities.Student;
import com.springorm.dao.StudentDao;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("com/springorm/config.xml");

		StudentDao studentDao = (StudentDao) con.getBean("studentDao");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean f = true;
		while (f) {
			System.out.println("1 to add");
			System.out.println("2 to select");
			System.out.println("3 to select all");
			System.out.println("4 to delete");
			System.out.println("5 to update");
			System.out.println("6 to exit");

			try {
				int i = Integer.parseInt(br.readLine());
				if (i == 1) {
					System.out.println("**************************************************************************");
					Student student = new Student();
					Integer uId = Integer.parseInt(br.readLine());
					String uName = br.readLine();
					Integer uMark = Integer.parseInt(br.readLine());

					student.setRoll(uId);
					student.setName(uName);
					student.setMarks(uMark);

					int j = (int) studentDao.insert(student);
					System.out.println(j);

					System.out.println("**************************************************************************");

				} else if (i == 2) {
					System.out.println("**************************************************************************");
					Integer uId = Integer.parseInt(br.readLine());
					Student s = studentDao.get(uId);

					System.out.println("Roll:" + s.getRoll());
					System.out.println("Name:" + s.getName());
					System.out.println("Marks:" + s.getMarks());
					System.out.println("--------------------------------------");

					System.out.println("**************************************************************************");

				} else if (i == 3) {

					System.out.println("**************************************************************************");
					List<Student> student = studentDao.getAll();

					for (Student s : student) {
						System.out.println("--------------------------------------");
						System.out.println("Roll:" + s.getRoll());
						System.out.println("Name:" + s.getName());
						System.out.println("Marks:" + s.getMarks());
						System.out.println("--------------------------------------");
					}

					System.out.println("**************************************************************************");

				} else if (i == 4) {
					System.out.println("**************************************************************************");

					Integer uId = Integer.parseInt(br.readLine());
					studentDao.delete(uId);
					System.out.println("Deleted:" + uId);

				} else if (i == 5) {

					System.out.println("**************************************************************************");
					Student student = new Student();
					Integer uId = Integer.parseInt(br.readLine());
					String uName = br.readLine();
					Integer uMark = Integer.parseInt(br.readLine());

					student.setRoll(uId);
					student.setName(uName);
					student.setMarks(uMark);

					studentDao.update(student);

					System.out.println("**************************************************************************");

				} else if (i == 6) {
					f = false;
					System.out.println("Thanks you for using the app... exiting");
				}
			} catch (Exception e) {
				System.out.println("Invalid...try again");
				System.out.println(e.getMessage());
			}

		}

	}
}
