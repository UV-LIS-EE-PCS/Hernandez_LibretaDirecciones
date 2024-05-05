package address.data;
import java.util.ArrayList;

public class AddressBook {
    private ArrayList<AddressEntry>  contacts= new ArrayList<>();

    public void Add(AddressEntry contact){
        if(contacts.size() == 0){
            contacts.add(contact);
        } else{
            for(AddressEntry entries : contacts){
                
            }
        }
    }
}

