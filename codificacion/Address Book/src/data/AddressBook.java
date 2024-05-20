package data;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<AddressEntry>  contacts= new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void add(AddressEntry contact){
        contacts.add(contact);
        contacts.sort((o1, o2) -> {
            int cmp = o1.getLastname().compareTo(o2.getLastname());
            if (cmp != 0) {
                return cmp;
            }
            return o1.getName().compareTo(o2.getName());
        });
    }

    public void delete(AddressEntry contactEntry){
        contacts.remove(contactEntry);
    }

    public void addFromFile(File filename){

    }

    public ArrayList<AddressEntry> Search(String lastname){
        ArrayList<AddressEntry> searchResults = new ArrayList<>();
        for(int i = 0; i < contacts.size();i++){
            AddressEntry contact = contacts.get(i);
            if((contact.getLastname()).startsWith(lastname)){
                searchResults.add(contact);
            }
        }

        return searchResults;
    }

    public void show(){
        if(contacts.size() == 0 ){
            System.out.println("The address book is empty");
        }else{
            for(AddressEntry contact : contacts){
                System.out.println(contact.toString());;
            }
        }
    }
}

