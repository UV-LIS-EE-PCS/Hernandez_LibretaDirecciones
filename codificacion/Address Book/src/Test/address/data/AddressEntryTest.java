package Test.address.data;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Main.address.data.AddressEntry;

public class AddressEntryTest {
    private AddressEntry entry = new AddressEntry();

    @Test
    public void setNameTest(){
        String name = "Sebastian";
        entry.setName(name);
        Assertions.assertEquals(name, entry.getName());
    }

    @Test
    public void setLastnameTest() {
        String lastname = "Hernandez";
        entry.setLastname(lastname);
        Assertions.assertEquals(lastname, entry.getLastname());
    }

    @Test
    public void setStreetTest() {
        String street = "Costa Rica";
        entry.setStreet(street);
        Assertions.assertEquals(street, entry.getStreet());
    }

    @Test
    public void setCityTest() {
        String city = "Vancouver";
        entry.setCity(city);
        Assertions.assertEquals(city, entry.getCity());
    }

    @Test
    public void setStateTest() {
        String state = "New York";
        entry.setState(state);
        Assertions.assertEquals(state, entry.getState());
    }

    @Test
    public void setPostalCodeTest() {
        String postalCode = "777777";
        entry.setPostalCode(postalCode);
        Assertions.assertEquals(postalCode, entry.getPostalCode());
    }

    @Test
    public void setPhoneTest() {
        String phone = "55 666 8888";
        entry.setPhone(phone);
        Assertions.assertEquals(phone, entry.getPhone());
    }

    @Test
    public void setEmailTest() {
        String email = "sebas@uv.mx";
        entry.setEmail(email);
        Assertions.assertEquals(email, entry.getEmail());
    }


    @Test
    public void getNameTest(){
        String name = "Sebastian";
        Assertions.assertNotEquals(name, entry.getName());
        entry.setName(name);
        Assertions.assertEquals(name, entry.getName());
    }

    @Test
    public void getLastnameTest() {
        String lastname = "Hernandez";
        Assertions.assertNotEquals(lastname, entry.getLastname());
        entry.setLastname(lastname);
        Assertions.assertEquals(lastname, entry.getLastname());
    }

    @Test
    public void getStreetTest() {
        String street = "Costa Rica";
        Assertions.assertNotEquals(street, entry.getStreet());
        entry.setStreet(street);
        Assertions.assertEquals(street, entry.getStreet());
    }

    @Test
    public void getCityTest() {
        String city = "Vancouver";
        Assertions.assertNotEquals(city, entry.getCity());
        entry.setCity(city);
        Assertions.assertEquals(city, entry.getCity());
    }

    @Test
    public void getStateTest() {
        String state = "New York";
        Assertions.assertNotEquals(state, entry.getState());
        entry.setState(state);
        Assertions.assertEquals(state, entry.getState());
    }

    @Test
    public void getPostalCodeTest() {
        String postalCode = "777777";
        Assertions.assertNotEquals(postalCode, entry.getPostalCode());
        entry.setPostalCode(postalCode);
        Assertions.assertEquals(postalCode, entry.getPostalCode());
    }

    @Test
    public void getPhoneTest() {
        String phone = "55 666 8888";
        Assertions.assertNotEquals(phone, entry.getPostalCode());
        entry.setPhone(phone);
        Assertions.assertEquals(phone, entry.getPhone());
    }

    @Test
    public void getEmailTest() {
        String email = "sebas@uv.mx";
        Assertions.assertNotEquals(email, entry.getEmail());
        entry.setEmail(email);
        Assertions.assertEquals(email, entry.getEmail());
    }

}