import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        student student = new student();
        while (true) {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
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

                        student.insertStudent(id, name, age, course);
                        break;

                    case 2:
                        student.showAllStudents();
                        break;

                    case 3:
                        System.out.print("Enter ID to Update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String uname = sc.nextLine();

                        System.out.print("Enter New Age: ");
                        int uage = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Course: ");
                        String ucourse = sc.nextLine();

                        student.updateStudent(uid, uname, uage, ucourse);
                        break;

                    case 4:
                        System.out.print("Enter ID to Delete: ");
                        int did = sc.nextInt();

                        student.deleteStudent(did);
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        student.closeConnection();
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Enter 1–5 only.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}
