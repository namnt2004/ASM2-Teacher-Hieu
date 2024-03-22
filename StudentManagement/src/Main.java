//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters for attributes
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class StudentManagement {
    private ArrayList<Student> studentList;
    private Scanner scanner;

    public StudentManagement() {
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void enterStudentList() {
        System.out.println("Enter student list:");
        while (true) {
            System.out.print("Enter student's first name : ");
            String firstName = scanner.nextLine();
            if (firstName.equalsIgnoreCase("end")) break;

            System.out.print("Enter student's last name: ");
            String lastName = scanner.nextLine();
            studentList.add(new Student(firstName, lastName));
        }
    }

    public void findStudentsByLastName(String lastName) {
        System.out.println("Students with last name '" + lastName + "':");
        boolean found = false;
        for (Student student : studentList) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with last name '" + lastName + "'.");
        }
    }

    public void findAndEditStudentsByFullName(String fullName) {
        System.out.println("Searching for student with full name '" + fullName + "':");
        for (Student student : studentList) {
            if ((student.getFirstName() + " " + student.getLastName()).equalsIgnoreCase(fullName)) {
                System.out.println("Student found: " + student.getFirstName() + " " + student.getLastName());
                System.out.print("Enter new first name: ");
                String newFirstName = scanner.nextLine();
                System.out.print("Enter new last name: ");
                String newLastName = scanner.nextLine();
                student.setFirstName(newFirstName);
                student.setLastName(newLastName);
                System.out.println("Student information updated successfully.");
                return;
            }
        }
        System.out.println("No student found with full name '" + fullName + "'.");
    }

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentManagement.enterStudentList();
                    break;
                case 2:
                    System.out.print("Enter last name to search: ");
                    String lastName = scanner.nextLine();
                    studentManagement.findStudentsByLastName(lastName);
                    break;
                case 3:
                    System.out.print("Enter full name to search: ");
                    String fullName = scanner.nextLine();
                    studentManagement.findAndEditStudentsByFullName(fullName);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

