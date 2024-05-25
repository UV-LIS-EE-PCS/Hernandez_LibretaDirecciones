package Test.address.data;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Main.address.data.AddressEntry;

/**
 * La clase AddressEntryTest contiene los casos de prueba para probar la funcionalidad de la clase AddressEntry.
 */
public class AddressEntryTest {
    private AddressEntry entry = new AddressEntry();

    /**
     * Prueba el método setName de la clase AddressEntry.
     */
    @Test
    public void setNameTest(){
        String name = "Sebastian";
        entry.setName(name);
        Assertions.assertEquals(name, entry.getName());
    }

    /**
     * Prueba el método setLastname de la clase AddressEntry.
     */
    @Test
    public void setLastnameTest() {
        String lastname = "Hernandez";
        entry.setLastname(lastname);
        Assertions.assertEquals(lastname, entry.getLastname());
    }

    /**
     * Prueba el método setStreet de la clase AddressEntry.
     */
    @Test
    public void setStreetTest() {
        String street = "Costa Rica";
        entry.setStreet(street);
        Assertions.assertEquals(street, entry.getStreet());
    }

    /**
     * Prueba el método setCity de la clase AddressEntry.
     */
    @Test
    public void setCityTest() {
        String city = "Vancouver";
        entry.setCity(city);
        Assertions.assertEquals(city, entry.getCity());
    }

    /**
     * Prueba el método setState de la clase AddressEntry.
     */
    @Test
    public void setStateTest() {
        String state = "New York";
        entry.setState(state);
        Assertions.assertEquals(state, entry.getState());
    }

    /**
     * Prueba el método setPostalCode de la clase AddressEntry.
     */
    @Test
    public void setPostalCodeTest() {
        String postalCode = "777777";
        entry.setPostalCode(postalCode);
        Assertions.assertEquals(postalCode, entry.getPostalCode());
    }

    /**
     * Prueba el método setPhone de la clase AddressEntry.
     */
    @Test
    public void setPhoneTest() {
        String phone = "55 666 8888";
        entry.setPhone(phone);
        Assertions.assertEquals(phone, entry.getPhone());
    }

    /**
     * Prueba el método setEmail de la clase AddressEntry.
     */
    @Test
    public void setEmailTest() {
        String email = "sebas@uv.mx";
        entry.setEmail(email);
        Assertions.assertEquals(email, entry.getEmail());
    }

    /**
     * Prueba el método getName de la clase AddressEntry.
     */
    @Test
    public void getNameTest(){
        String name = "Sebastian";
        Assertions.assertNotEquals(name, entry.getName());
        entry.setName(name);
        Assertions.assertEquals(name, entry.getName());
    }

    /**
     * Prueba el método getLastname de la clase AddressEntry.
     */
    @Test
    public void getLastnameTest() {
        String lastname = "Hernandez";
        Assertions.assertNotEquals(lastname, entry.getLastname());
        entry.setLastname(lastname);
        Assertions.assertEquals(lastname, entry.getLastname());
    }

    /**
     * Prueba el método getStreet de la clase AddressEntry.
     */
    @Test
    public void getStreetTest() {
        String street = "Costa Rica";
        Assertions.assertNotEquals(street, entry.getStreet());
        entry.setStreet(street);
        Assertions.assertEquals(street, entry.getStreet());
    }

    /**
     * Prueba el método getCity de la clase AddressEntry.
     */
    @Test
    public void getCityTest() {
        String city = "Vancouver";
        Assertions.assertNotEquals(city, entry.getCity());
        entry.setCity(city);
        Assertions.assertEquals(city, entry.getCity());
    }

    /**
     * Prueba el método getState de la clase AddressEntry.
     */
    @Test
    public void getStateTest() {
        String state = "New York";
        Assertions.assertNotEquals(state, entry.getState());
        entry.setState(state);
        Assertions.assertEquals(state, entry.getState());
    }

    /**
     * Prueba el método getPostalCode de la clase AddressEntry.
     */
    @Test
    public void getPostalCodeTest() {
        String postalCode = "777777";
        Assertions.assertNotEquals(postalCode, entry.getPostalCode());
        entry.setPostalCode(postalCode);
        Assertions.assertEquals(postalCode, entry.getPostalCode());
    }

    /**
     * Prueba el método getPhone de la clase AddressEntry.
     */
    @Test
    public void getPhoneTest() {
        String phone = "55 666 8888";
        Assertions.assertNotEquals(phone, entry.getPostalCode());
        entry.setPhone(phone);
        Assertions.assertEquals(phone, entry.getPhone());
    }

    /**
     * Prueba el método getEmail de la clase AddressEntry.
     */
    @Test
    public void getEmailTest() {
        String email = "sebas@uv.mx";
        Assertions.assertNotEquals(email, entry.getEmail());
        entry.setEmail(email);
        Assertions.assertEquals(email, entry.getEmail());
    }
}
