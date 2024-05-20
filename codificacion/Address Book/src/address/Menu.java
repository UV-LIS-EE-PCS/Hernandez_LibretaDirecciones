package address;
import data.AddressBook;
import data.AddressEntry;
import java.util.Scanner;

import javax.swing.JFileChooser;

import java.io.File;
import java.util.ArrayList;

public class Menu {
    private AddressBook addressBook = new AddressBook();

    public AddressBook getAddressBook() {
        return addressBook;
    }
    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }
    
    public Menu(AddressBook addressBook){
        this.addressBook = addressBook;
    }

    Scanner scan = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);

    public void add(){

        System.out.println("Enter the name: ");
        String name = scan.nextLine();

        System.out.println("Enter the lastname: ");
        String lastname = scan.nextLine();
        
        System.out.println("Enter the street: ");
        String street = scan.nextLine();
        
        System.out.println("Enter the city: ");
        String city = scan.nextLine();
        
        System.out.println("Enter the state: ");
        String state = scan.nextLine();
        
        System.out.println("Enter the postalCode: ");
        String postalCode = scan.nextLine();
        
        System.out.println("Enter the phone: ");
        String phone = scan.nextLine();
        
        System.out.println("Enter the email: ");
        String email = scan.nextLine();

        System.out.println("Adding to the Address Book ...");

        try {
            AddressEntry contact = new AddressEntry(name, lastname, street, city, state, postalCode, phone, email);
            addressBook.add(contact);
        } catch (Exception e) {
            System.out.println("Something has gone wrong Try Later");
        }
    }
    
    public void remove(){
        System.out.println("Enter the lastname of the contact that will be eliminated: ");
        String lastname = scan.nextLine();
        ArrayList<AddressEntry> searchResults = addressBook.Search(lastname);

        for(AddressEntry contact : searchResults){
            System.out.println(contact.toString());
        }



        int choosenContact = 0;
        do{
            System.out.println("Select what contact do you wanna delete (Input an Integer Number): ");
            choosenContact = scan.nextInt();

            if(choosenContact > searchResults.size()){
                System.out.println("Enter a valid option!\n");
            }

        }while(choosenContact == 0 || choosenContact > searchResults.size());


        choosenContact--;
        AddressEntry contact = searchResults.get(choosenContact);
        System.out.println("Deleting contact.....");
        addressBook.delete(contact);
        System.out.println("Contact deleted succesfully!");
    }

    public void readFile(){
        JFileChooser filepath = new JFileChooser();
        filepath.showOpenDialog(filepath);
        String path;

        try {
            path = filepath.getSelectedFile().getAbsolutePath();
            if (path.endsWith(".txt")){
                File textFile = new File(path);
                addressBook.addFromFile(textFile);

            }else {
                System.out.println("That not a .txt file");

            }
        }catch(Exception e){
            System.out.println("Something has gone wrong!!");
            
        }
    }

    public void find(){
        System.out.println("Enter the lastname of the contact you wanna search: ");
        String lastname = scan.nextLine();
        ArrayList<AddressEntry> results = addressBook.Search(lastname);

        System.out.println(results.size() == 1 ? "Contact Found" : "There were various contacts with the same lastname Showing them all");
        for(AddressEntry contact : results){
            System.out.println(contact.toString());
        }
    }

    public void show(){
        System.out.println("Showing all the contacts in this list");
        addressBook.show();
    }

    public void displayMenu(){
        boolean active = true;
        while(active){
            System.out.println("Choose an option from the menu: ");
            System.out.println("a) Load from file");
            System.out.println("b) Add Entry");
            System.out.println("c) Delete Entry");
            System.out.println("d) Search Entry");
            System.out.println("e) Show all Entries");
            System.out.println("f) Exit the program");
            char option = scanner.nextLine().charAt(0);

            switch (option) {
                case 'a':
                    readFile();
                    break;
                case 'b':
                    add();
                    break;
                case 'c':
                    remove();
                    break;
                case 'd':
                    find();
                    break;
                case 'e':
                    show();
                    break;
                case 'f':
                    active = false;
                    break;
                default:
                    System.out.println("You enter a invalid option!");
                    break;
            }
        } 
    }
    


}
