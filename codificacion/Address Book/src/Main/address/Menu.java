package Main.address;
import java.util.Scanner;

import javax.swing.JFileChooser;

import Main.address.data.AddressBook;
import Main.address.data.AddressEntry;

import java.io.File;
import java.util.ArrayList;


/**
 * La clase Menu proporciona un menú de opciones para interactuar con el AddressBook esto con el fin de validar las
 * entradas antes de que lleguen al addressBook ocasionando algun error.
 * @author Sebati HM
 */

public class Menu {
    private AddressBook addressBook = new AddressBook();


    /**
     * Obtiene el libro de direcciones asociado con este menú.
     * @return El libro de direcciones asociado con este menú.
     */

    public AddressBook getAddressBook() {
        return addressBook;
    }



    /**
     * Establece el libro de direcciones asociado con este menú.
     * @param addressBook El libro de direcciones a establecer.
     */

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }
    

    /**
     * Constructor que inicializa un menú con un libro de direcciones dado.
     * @param addressBook El libro de direcciones para asociar con el menú.
     */

    public Menu(AddressBook addressBook){
        this.addressBook = addressBook;
    }

    Scanner scan = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);

    /**
     * Agrega una nueva entrada de dirección al libro de direcciones.
     * Solicita al usuario los siguiente datos del contacto:
     * * Nombre
     * * apellido
     * * la calle donde vive
     * * ciudad
     * * estado
     * * codigo Postal
     * * telefono
     * * email
     */
    public void add(){

        System.out.print("Enter the name: ");
        String name = scan.nextLine();

        System.out.print("Enter the lastname: ");
        String lastname = scan.nextLine();
        
        System.out.print("Enter the street: ");
        String street = scan.nextLine();
        
        System.out.print("Enter the city: ");
        String city = scan.nextLine();
        
        System.out.print("Enter the state: ");
        String state = scan.nextLine();
        
        System.out.print("Enter the postalCode: ");
        String postalCode = scan.nextLine();
        
        System.out.print("Enter the phone: ");
        String phone = scan.nextLine();
        
        System.out.print("Enter the email: ");
        String email = scan.nextLine();

        System.out.println("Adding to the Address Book ...");

        try {
            AddressEntry contact = new AddressEntry(name, lastname, street, city, state, postalCode, phone, email);
            addressBook.add(contact);
        } catch (Exception e) {
            System.out.println("Something has gone wrong Try Later");
        }
    }

    /**
     * Elimina una entrada de dirección del AddressBook mediante el apellido de este
     */
    
    public void remove(){
        System.out.println("Enter the lastname of the contact that will be eliminated: ");
        String lastname = scan.nextLine();
        ArrayList<AddressEntry> searchResults = addressBook.Search(lastname);
        int i = 1;

        for(AddressEntry contact : searchResults){
            System.out.println("=====================================================================");
            System.out.println(i);
            System.out.println(contact.toString());
            i++;
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
        System.out.println("Contact deleted succesfully!\n");
    }


    /**
     * Lee las entradas de dirección desde un archivo y las agrega al AddresBook
     * Se usa la libreria JFileChooser para abrir una pestaña donde el usuario puede seleccionar de manera grafica
     * el archivo que requiere usar (posee validacion para que solo admita el formato .txt)
     */
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


    /**
     * Busca una entrada de dirección por apellido en el AddressBook
     * En caso de no encontrar imprime que no existe un contacto con ese apellido
     */

    public void find(){
        System.out.print("Enter the lastname of the contact you wanna search: ");
        String lastname = scan.nextLine();
        ArrayList<AddressEntry> results = addressBook.Search(lastname);

        if(results.isEmpty()){
            System.out.println("There is no contact with this lastname");
        } else {
            System.out.println(results.size() == 1 ? "Contact Found" : "There were various contacts with the same lastname Showing them all");
            for(AddressEntry contact : results){
                System.out.println(contact.toString());
            }
        }
    }


    /**
     * Muestra todas las entradas de dirección en el libro de direcciones.
     */

    public void show(){
        System.out.println("Showing all the contacts in this list");
        addressBook.show();
    }

    /**
     * Muestra el menú de opciones y permite al usuario interactuar con el libro de direcciones.
     */
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
            System.out.print("Ingrese su opcion: ");
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
