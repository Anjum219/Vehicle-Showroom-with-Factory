package showroom.of.vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class vehicleShowroom {
    private ArrayList<vehicle> vehicles = new ArrayList<vehicle>();
    private boolean newSUV;
    private final int normalVisitorCount = 30;
    private final int additionalVisitorCount = 20;

    public boolean isNewSUV() {
        return newSUV;
    }

    public void setNewSUV(boolean newSUV) {
        this.newSUV = newSUV;
    }

    public ArrayList<vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    
    public void addVehicles(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nPlease insert the VehicleType (normal/sports/heavy): ");
        String vehicleType = input.nextLine();
        
        if( vehicleType.equalsIgnoreCase("Normal") ){
            normalVehicle nv = new normalVehicle();
            nv.insert();
            vehicles.add(nv);
            System.out.println("Added " + vehicleType + " vehicle " + nv.getModelNumber());
            setNewSUV(false);
        }
        else if( vehicleType.equalsIgnoreCase("Sports") ){
            sportsVehicle sv = new sportsVehicle();
            sv.insert();
            vehicles.add(sv);
            System.out.println("Added " + vehicleType + " vehicle " + sv.getModelNumber());
            setNewSUV(true);
        }
        else if( vehicleType.equalsIgnoreCase("Heavy") ){
            heavyVehicle hv = new heavyVehicle();
            hv.insert();
            vehicles.add(hv);
            System.out.println("Added " + vehicleType + " vehicle " + hv.getModelNumber());
            setNewSUV(false);
        }
        else{
            System.out.println("Sorry. We don't add " + vehicleType + " vehicle :(");
        }
    }
    
    public int searchVehicle(String modelNumber){ //gives the index of the list where the vehicle is found
        int pos = -1;
        
        for( int i = 0; i < vehicles.size(); i++ ){
            if( vehicles.get(i).getModelNumber().equalsIgnoreCase(modelNumber) ){
                pos = i;
                break;
            }
        }
        
        return pos;
    }
    
    public void removeVehicle(){ //remove a vehicle by its model number
        System.out.print("Insert Model Number: ");
        Scanner input = new Scanner(System.in);
        String modelNumber = input.nextLine();
        int pos = searchVehicle(modelNumber);
        
        if( pos != -1 ){
            String vehicleType = vehicles.get(pos).getVehicleType();
            vehicles.remove(pos);
            System.out.println("\n" + vehicleType + " vehicle Model " + modelNumber + " removed\n");
        }
        else{
            System.out.println("\nSorry... the vehicle doesn't exist :(\n");
        }
    }
    
    public void showVehicles(){
        System.out.println("\nALL VEHICLES------------------");
        for( int i = 0; i < vehicles.size(); i++ ){
            vehicles.get(i).showProperty();
            System.out.println("");
        }
    }
    
    public void showVisitorCount(){
        System.out.print("\nCurrent Expected Visitor count: ");
        int vc = normalVisitorCount;
        
        if( isNewSUV() ){
            vc += additionalVisitorCount;
        }
        
        System.out.println(vc);
        showVehicles();
    }
}
