package Main.address;
import Main.address.data.AddressBook;
/**
 * Clase principal del metodo
 * @author Sebati HM
 */

public class AddressBookApplication {

    /**
    * Metodo principal
    */
    public static void main(String[] args) {
        AddressBook address = new AddressBook();
        Menu menu = new Menu(address);
        menu.displayMenu();
    }
   
}
