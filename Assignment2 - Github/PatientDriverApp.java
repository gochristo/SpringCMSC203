/*
 * Class: CMSC203
 * Instructor: Prof. Monshi
 * Description: Intializes patient and procedure objects and prints information
 * Due: 02/26/2025
 * Platform/compiler: ItelliJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Christopher Andrews
*/

import java.util.Scanner;

public class PatientDriverApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Ask for Patient Information
        System.out.println("Enter patient first name: ");
        String firstName = sc.nextLine();

        System.out.println("Enter patient middle name: ");
        String middleName = sc.nextLine();

        System.out.println("Enter patient last name: ");
        String lastName = sc.nextLine();

        System.out.println("Enter patient street address: ");
        String streetAddress = sc.nextLine();

        System.out.println("Enter patient city: ");
        String city = sc.nextLine();

        System.out.println("Enter patient state (eg., MD): ");
        String state = sc.nextLine();

        System.out.println("Enter patient zip code: ");
        String zipCode = sc.nextLine();

        System.out.println("Enter patient phone number(XXX-XXX-XXXX): ");
        String phoneNumber = sc.nextLine();

        System.out.println("Enter patient emergency contact name: ");
        String emergencyName = sc.nextLine();

        System.out.println("Enter patient emergency contact number: ");
        String emergencyPhone = sc.nextLine();

        //Call to constructor with all attributes for patient
        Patient patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zipCode, phoneNumber,
                emergencyName, emergencyPhone);

        //Create array to store all procedures
        Procedure[] procedures = new Procedure[3];

        //Call to each procedure constructor once and store in array
        procedures[0] = new Procedure("Prostate Exam","9/10/2022","Dr.Jordan",2000);

        procedures[1] = new Procedure("Ear Cleaning","1/27/2024");
        procedures[1].setPractitionerName("Dr.Vo");
        procedures[1].setProcedureCharges(102.11);

        procedures[2] = new Procedure();
        procedures[2].setProcedureName("Open Heart Surgery");
        procedures[2].setProcedureDate("5/02/2018");
        procedures[2].setPractitionerName("Dr.James");
        procedures[2].setProcedureCharges(12457.18);

        displayPatient(patient);
        for(int i = 0; i < procedures.length; i++){
            displayProcedure(procedures[i]);
        }

        //calls to calculation method and prints total
        double totalCharges = calculateTotalCharges(procedures[0].getProcedureCharges(), procedures[1].getProcedureCharges(), procedures[2].getProcedureCharges());
        System.out.printf("\n Total Charges: $" + String.format("%.2f", totalCharges));

        displayStudentInfo();
    }

    public static void displayPatient(Patient patient){
        System.out.println(patient.toString());
    }

    public static void displayProcedure(Procedure procedure){
        System.out.println(procedure.toString());
    }

    public static double calculateTotalCharges(double total1, double total2, double total3){
        return total1 + total2 + total3;
    }

    public static void displayStudentInfo(){
        System.out.println("\n\nStudent Name: Christopher Andrews");
        System.out.println("MC#: M21166373");
        System.out.println("Due Date: 02/26/2025");
    }

}


