package benjohnmid;

import java.util.Scanner;

public class DepartmentApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resp;
        DepartmentApp app = new DepartmentApp(); // Corrected instance creation
        
        do {
            System.out.println("1. ADD DEPARTMENT");
            System.out.println("2. VIEW DEPARTMENTS");
            System.out.println("3. UPDATE DEPARTMENT");
            System.out.println("4. DELETE DEPARTMENT");
            System.out.println("5. EXIT");
        
            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            switch(action) {
                case 1:
                    app.addRecord();
                    break;
                case 2:
                    app.viewRecord();
                    break;                
                case 3:
                    app.viewRecord();
                    app.updateRecord();
                    break;           
                case 4:
                    app.viewRecord();
                    app.deleteRecord();
                    break;
                case 5:
                    System.out.println("Thank You!");
                    sc.close(); // Close the scanner before exiting
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            
            System.out.print("Do you want to continue? (yes/no): ");
            resp = sc.nextLine();

        } while (resp.equalsIgnoreCase("yes"));
       
        System.out.println("Thank You!");
        sc.close(); // Close the scanner at the end
    }
    
    public void addRecord() {
        Scanner sc = new Scanner(System.in);
        Config conf = new Config();
        
        System.out.print("Enter Department Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department Location: ");
        String location = sc.nextLine();

        String sql = "INSERT INTO Department (Name, Location) VALUES (?, ?)";
        conf.addRecord(sql, name, location);
    }
    
    public void viewRecord() {
        String qry = "SELECT * FROM Department";
        String[] hdrs = {"Department ID", "Department Name", "Location"};
        String[] clmns = {"Dept_ID", "Name", "Location"};
        
        Config conf = new Config();
        conf.viewRecords(qry, hdrs, clmns);
    }
    
    public void updateRecord() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Department ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter New Department Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Department Location: ");
        String location = sc.nextLine();

        String qry = "UPDATE Department SET Name = ?, Location = ? WHERE Dept_ID = ?";
        Config conf = new Config();
        conf.updateRecord(qry, name, location, id);
    }
     
    public void deleteRecord() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Department ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM Department WHERE Dept_ID = ?";
        Config conf = new Config();
        conf.deleteRecord(qry, id);
    }
}
