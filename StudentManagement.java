import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void displayStudent() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
    }
}

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    
    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        students.add(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }
    
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                student.displayStudent();
            }
        }
    }
    
    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.id == id) {
                student.displayStudent();
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
