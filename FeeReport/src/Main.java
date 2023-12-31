import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private double feesPaid;
    private double totalFees;

    public Student(String name, int id, double totalFees) {
        this.name = name;
        this.id = id;
        this.totalFees = totalFees;
        this.feesPaid = 0;
    }

    public void payFees(double amount) {
        feesPaid += amount;
    }

    public double getRemainingFees() {
        return totalFees - feesPaid;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Total Fees: $" + totalFees);
        System.out.println("Fees Paid: $" + feesPaid);
        System.out.println("Remaining Fees: $" + getRemainingFees());
        System.out.println("----------------------");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFeesPaid() {
        return feesPaid;
    }
}

class FeeReport {
    private ArrayList<Student> students;

    public FeeReport() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            student.displayInfo();
        }
    }

    public void generatePaymentReport(Student student, double amountPaid) {
        System.out.println("Payment Report");
        System.out.println("---------------");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Amount Paid: $" + amountPaid);
        System.out.println("Remaining Fees: $" + student.getRemainingFees());
        System.out.println("----------------------");
    }
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		    
		        FeeReport feeReport = new FeeReport();

		        // Adding some sample students
		        feeReport.addStudent(new Student("Siri", 101, 1000));
		        feeReport.addStudent(new Student("pranay", 102, 1200));

		        Scanner scanner = new Scanner(System.in);

		        int choice;
		        do {
		            System.out.println("1. Display All Students");
		            System.out.println("2. Pay Fees");
		            System.out.println("3. Exit");
		            System.out.print("Enter your choice: ");
		            choice = scanner.nextInt();

		            switch (choice) {
		                case 1:
		                    feeReport.displayAllStudents();
		                    break;
		                case 2:
		                    System.out.print("Enter student ID: ");
		                    int studentId = scanner.nextInt();
		                    System.out.print("Enter amount to pay: $");
		                    double amount = scanner.nextDouble();

		                    for (Student student : feeReport.getStudents()) {
		                        if (student.getId() == studentId) {
		                            double remainingFeesBeforePayment = student.getRemainingFees();
		                            student.payFees(amount);
		                            double amountPaid = remainingFeesBeforePayment - student.getRemainingFees();
		                            feeReport.generatePaymentReport(student, amountPaid);
		                            System.out.println("Fees paid successfully!");
		                            break;
		                        }
		                    }
		                    break;
		                case 3:
		                    System.out.println("Exiting the program. Goodbye!");
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please enter a valid option.");
		            }
		        } while (choice != 3);
		    
	}

}
