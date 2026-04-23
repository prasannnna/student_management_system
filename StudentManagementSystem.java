import java.util.*;

class Student {
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void display() {
        System.out.println("--------------------------------");
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Course  : " + course);
    }
}

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    // Add Student
    static void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            students.add(new Student(id, name, age, course));
            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            System.out.println("Invalid Input!");
            sc.nextLine();
        }
    }

    // View Students
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No Records Found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // Search Student
    static void searchStudent() {
        System.out.print("Enter Student ID to Search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                s.display();
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Update Student
    static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.id == id) {

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Delete Student
    static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();

        while (it.hasNext()) {
            Student s = it.next();

            if (s.id == id) {
                it.remove();
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}