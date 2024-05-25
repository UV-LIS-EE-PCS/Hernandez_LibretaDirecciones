package Test.data;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;

import Main.data.AddressBook;
import Main.data.AddressEntry;

public class AddressBookTest {
    AddressBook addressBook = new AddressBook();
    AddressEntry entry = new AddressEntry();

    @Test
    public void add(){
        AddressEntry newEntry = new AddressEntry("John", "Doe", "123 Main St", "City", "State", "12345", "123-456-7890", "john@example.com");
        addressBook.add(newEntry);
        assertTrue(addressBook.Search("Doe").contains(newEntry));
    }



    @Test
    public void testDelete() {
        addressBook.add(entry);
        assertTrue(addressBook.Search("Doe").contains(entry));
        addressBook.delete(entry);
        assertFalse(addressBook.Search("Doe").contains(entry));
    }

     @Test
    public void testAddFromFile() {
        File file = new File("src\\Test\\data\\data.txt"); // Create a test file with some entries
        // Assuming you have some test data in the file
        addressBook.addFromFile(file);
        assertEquals(1, addressBook.Search("hernandez").size()); // Assuming there is one entry with last name "Smith" in the test file
    }

    @Test
    public void testSearch() {
        AddressEntry entry2 = new AddressEntry("Noah", "Doe", "456 Oak St", "Vancouver", "Columbia", "54321", "987-654-3210", "noah@gmail.com");
        addressBook.add(entry);
        addressBook.add(entry2);
        ArrayList<AddressEntry> searchResults = addressBook.Search("Doe");
        assertEquals(2, searchResults.size());
        assertTrue(searchResults.contains(entry));
        assertTrue(searchResults.contains(entry2));
    }


}
