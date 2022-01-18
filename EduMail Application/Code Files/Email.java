package emailapp;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
public class Email {

    public Scanner sc = new Scanner(System.in);

    // Setting up the variables
    // "private" so that it cannot access directly
    private String firstname;
    private String lastname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    // A constructor to receive the first name and the last name
    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        System.out.println("New Addition: " + this.firstname + " " + this.lastname);

        // Call a method asking for the department
        this.dept = this.setDept();

        // create a random password method
        this.password = this.generate_password(8);

        // Combine elements to generate an email
        this.email = this.generate_email();
    }

    // Generating the email according to the given syntax
    private String generate_email() {
        return this.firstname.toLowerCase() + "." + this.lastname.toLowerCase() + "@" + this.dept.toLowerCase()
                + ".cub.edu";
    }

    // Ask for the department
    private String setDept() {
        System.out.println("Department Catagory \n1 for Student \n2 for Teacher \n3 for Accountant \n4 for Administrator \n0 for None");
        boolean flag = false;
        do {
            System.out.print("Enter the department Code: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    return "Student";
                case 2:
                    return "Teacher";
                case 3:
                    return "Accountant";
		case 4:
		    return "Administrator";
                case 0:
                    return "None";
                default:
                    System.out.println("***Invalid choice. Please try again***");
            }
        } 
	while (!flag);
        return null;
    }

    // create random password method
    private String generate_password(int length) {
        Random r = new Random();

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "9876543210";
        String symbols = "@#$%&?!";
        String values = Capital_chars + small_chars + numbers + symbols;

        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    // Change password method
    public void set_password() {
        boolean flag = false;
        do {
            System.out.print("Do you want to change your password? (Y/N) : ");
            char choice = sc.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.print("Enter current password: ");
                String temp = sc.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password: ");
                    this.password = sc.next();
                    System.out.println("Password Successfully Changed");
                } else {
                    System.out.println("Incorrect Password!");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password Change Cancelled");
            } else {
                System.out.println("***Enter a valid choice***");
            }
        } while (!flag);
    }

    // set mailbox capacity
    public void set_mailCap() {
        System.out.println("Current capacity = " + this.mailCapacity + " mb");
        System.out.print("Enter new capacity: ");
        this.mailCapacity = sc.nextInt();
        System.out.println("Mailbox capacity changed successfully!");

    }

    // set alter email
    public void alternate_email() {
        System.out.print("Enter a new alternate email: ");
        this.alter_email = sc.next();
        System.out.println("Alternate Email Set Successfully!");
    }

    // Showing the employee's information
    public void getInfo() {
        System.out.println("Name: " + this.firstname + " " + this.lastname);
        System.out.println("Department: " + this.dept);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox Capacity: " + this.mailCapacity + " mb");
        System.out.println("Alternate Email: " + this.alter_email);
    }

    public void storefile() {
        try {
            FileWriter in = new FileWriter("C:\\Users\\pc\\Desktop\\Info.txt");
            in.write("First Name: "+this.firstname);
            in.append("Last Name: "+this.lastname);
            in.append("Email: "+this.email);
            in.append("Password: "+this.password);
            in.append("Capacity: "+this.mailCapacity);
            in.append("Alternate mail: "+this.alter_email);
            in.close();
            System.out.println("Stored..");
        }catch (Exception e){System.out.println(e);}
    }

    public void read_file() {
        try {
            FileReader f1 = new
                    FileReader("C:\\Users\\pc\\Desktop\\Info.txt");
            int i;
            while ((i = f1.read()) != -1) {
                System.out.print((char) i);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();

    }
}