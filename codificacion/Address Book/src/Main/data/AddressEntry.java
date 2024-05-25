package Main.data;

public class AddressEntry{
    private String name;
    private String lastname;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String phone;
    private String email;

    public AddressEntry(String name, String lastname, String street, String city, String state, String postalCode, String phone, String email){
        this.name = name;
        this.lastname = lastname;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;

    }

    public AddressEntry(){
        this.name = "Jane Doe";
        this.lastname = "Doe";
        this.street = "street";
        this.city = "Uranium City";
        this.state = "Saskatchewan";
        this.postalCode = "44555";
        this.phone = "555-555-555-555";
        this.email = "ride@theciclonet.com";
    }

    public String getName(){
        return this.name;
    }
    
    public String getLastname(){
        return this.lastname;
    }

    public String getStreet(){
        return this.street;
    }

    public String getCity(){
        return this.city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public boolean isSame(AddressEntry addressEntry){
        boolean isNameSame =(this.name).equals(addressEntry.getName());
        boolean isLastnameSame =(this.lastname).equals(addressEntry.getLastname());
        boolean isStreetSame =(this.street).equals(addressEntry.getStreet());
        boolean isCitySame =(this.city).equals(addressEntry.getCity());
        boolean isStateSame =(this.state).equals(addressEntry.getState());
        boolean isPostalCodeSame =(this.postalCode).equals(addressEntry.getPostalCode());
        boolean isPhoneSame =(this.phone).equals(addressEntry.getPhone());
        boolean isEmailSame =(this.email).equals(addressEntry.getEmail());

        if(isNameSame && isLastnameSame && isStreetSame && isCitySame && isStateSame && isPostalCodeSame && isPhoneSame && isEmailSame){
            return true;
        } else{
            return false;
        } 
    }

    

    @Override
    public String toString(){
        return "=====================================================================" 
        + "\nName: " + getName()
        + "\nLastname: " + getLastname()
        + "\nStreet: " + getStreet()
        + "\nCity: " + getCity()
        + "\nState: " + getState()
        + "\nPostal Code: " + getPostalCode()
        + "\nPhone: " + getPhone()
        + "\nEmail: " + getEmail()
        + "\n=====================================================================\n";
    }
}