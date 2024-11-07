package it2d.sarno.blotter ;

import java.util.Scanner;


public class IT2DSARNOBLOTTER {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        String response;
        do{
             System.out.println("1. ADD INCIDENT");
            System.out.println("2. VIEW INCIDENTS");
            System.out.println("3. UPDATE INCIDENT");
            System.out.println("4. DELETE INCIDENT");
            System.out.println("5. BACK TO MAIN MENU");
        
        System.out.print("Enter Action: ");
        int action =  sc.nextInt();
       IT2DSARNOBLOTTER Incident = new IT2DSARNOBLOTTER (); 
        switch(action){
            case 1:
               
            Incident.addIncident();
            break;
            
            case 2:
            Incident.viewIncidents();
            break;
            
            case 3:
            Incident.viewIncidents();
            Incident.updateincidents();
            Incident.viewIncidents();
            break;
             case 4:
            Incident.viewIncidents();
            Incident.deleteIncidents();
            Incident.viewIncidents();
            break;
           
            case 5:
            System.out.println("Exiting...");
            break;
            default:
                System.out.println("invalid action. Please try again.");
        }
            System.out.println("Continue in BLOTTER menu? (yes/no): ");
            response = sc.next();  
        }while(response.equalsIgnoreCase("yes"));
        System.out.println("Thank you!"); 
    }
    public void addIncident(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Incident ID : ");
        String incidentId= sc.next();
        System.out.print("Incident Description: ");
        String description = sc.next();
        System.out.print("Incident Date (YYYY-MM-DD): ");
        String date = sc.next();
        System.out.print("Incident Status: ");
        String status = sc.next();

     
         String sql = "INSERT INTO tbl_blotter (incident_description, incident_date, incident_status) VALUES (?, ?, ?)";
    conf.addRecord(sql, description, date, status);


    }
    
    private void viewIncidents() {
         String qry = "SELECT * FROM tbl_blotter";
        String[] hdrs = {"i_id", "Description", "Date", "Status"};
        String[] clms = {"i_id", "incident_description", "incident_date", "incident_status"};
              
        config conf = new config();
        conf.viewRecords(qry, hdrs, clms);
    }

     private void updateincidents() {
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Enter the Incident ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter new Description: ");
        String newDescription = sc.nextLine();
        System.out.print("Enter new Date (YYYY-MM-DD): ");
        String newDate = sc.nextLine();
        System.out.print("Enter new Status: ");
        String newStatus = sc.nextLine();

        String qry = "UPDATE tbl_blotter SET  incident_description = ?, incident_date = ?, incident_status = ? WHERE i_id = ?";
        
       config conf = new config();
        conf.updateRecord(qry, newDescription, newDate, newStatus, id);
    }

 
   private void deleteIncidents(){
         Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Incident ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_blotter WHERE i_id = ?";
      
       config conf = new config();
           conf.deleteRecord (qry, id);
    
           
         
        
    }
     
}