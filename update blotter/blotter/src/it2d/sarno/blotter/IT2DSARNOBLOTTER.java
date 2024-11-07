package it2d.sarno.blotter;

import java.util.Scanner;

public class IT2DSARNOBLOTTER {

    public static void main(String[] args) {
        IT2DSARNOBLOTTER blotter = new IT2DSARNOBLOTTER();
        blotter.showEntryMenu();
    }

    public void showEntryMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Blotter System");
        System.out.println("1. Proceed to BLOTTER Menu");
        System.out.println("2. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                showBlotterMenu();
                break;
            
            case 2:
                System.out.println("Exiting the system. Thank you!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showEntryMenu();
        }
    }

    public void showBlotterMenu() {
        Scanner sc = new Scanner(System.in);
        String response;
        do {
            System.out.println("1. ADD CASE");
            System.out.println("2. VIEW CASES");
            System.out.println("3. UPDATE CASE");
            System.out.println("4. DELETE CASE");
            System.out.println("5. BACK TO MAIN MENU");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            IT2DSARNOBLOTTER blotter = new IT2DSARNOBLOTTER();

            switch (action) {
                case 1:
                    blotter.addCase();
                    break;
                case 2:
                    blotter.viewCases();
                    break;
                case 3:
                    blotter.viewCases();
                    blotter.updateCase();
                    blotter.viewCases();
                    break;
                case 4:
                    blotter.viewCases();
                    blotter.deleteCase();
                    blotter.viewCases();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    showEntryMenu();
                    return;
                default:
                    System.out.println("Invalid action. Please try again.");
            }

            System.out.println("Continue in BLOTTER menu? (yes/no): ");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));
        System.out.println("Thank you!");
    }

    public void addCase() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Case ID: ");
        String caseId = sc.next();
        System.out.print("Case Description: ");
        String description = sc.next();
        System.out.print("Case Date (YYYY-MM-DD): ");
        String date = sc.next();
        System.out.print("Case Status: ");
        String status = sc.next();

        String sql = "INSERT INTO tbl_blotter (c_description, c_date, c_status) VALUES (?, ?, ?)";
    conf.addRecord(sql, description, date, status);

    }

    private void viewCases() {
        String qry = "SELECT * FROM tbl_blotter";
        String[] hdrs = {"c_id", "Description", "Date", "Status"};
        String[] clms = {"c_id", "case_description", "case_date", "case_status"};
              
        config conf = new config();
        conf.viewRecords(qry, hdrs, clms);
    }

    private void updateCase() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Case ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Description: ");
        String newDescription = sc.nextLine();
        System.out.print("Enter new Date (YYYY-MM-DD): ");
        String newDate = sc.nextLine();
        System.out.print("Enter new Status: ");
        String newStatus = sc.nextLine();

        String qry = "UPDATE tbl_blotter SET case_description = ?, case_date = ?, case_status = ? WHERE c_id = ?";

        config conf = new config();
        conf.updateRecord(qry, newDescription, newDate, newStatus, id);
    }

    private void deleteCase() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Case ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_blotter WHERE c_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
    }


}