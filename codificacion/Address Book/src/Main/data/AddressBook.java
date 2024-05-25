package Main.data;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<AddressEntry>  contacts= new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void add(AddressEntry contact){
        boolean isEntrySame = false;
        for(AddressEntry entry : contacts){
            if(entry.isSame(contact)){
                isEntrySame = true;
            }
        }
        if (!isEntrySame){
            contacts.add(contact);
            contacts.sort((o1, o2) -> {
                int cmp = o1.getLastname().compareTo(o2.getLastname());
                if (cmp != 0) {
                    return cmp;
                }
                return o1.getName().compareTo(o2.getName());
            });
        }
    }

    public void delete(AddressEntry contactEntry){
        contacts.remove(contactEntry);
    }

    public void addFromFile(File filename){
        try {
            FileReader fileLines = new FileReader(filename);
            BufferedReader readerLines = new BufferedReader(fileLines);
          
            String entryAtribute = readerLines.readLine();
          
            System.out.println();

            String entryAtributes[] = new String[8];
          
            int counter = 0;
            while(entryAtribute != null) {

                entryAtributes[counter] = entryAtribute;

                if(counter == 7){
                    AddressEntry contact = new AddressEntry();
                    contact.setName(entryAtributes[0]);
                    contact.setLastname(entryAtributes[1]);
                    contact.setStreet(entryAtributes[2]);
                    contact.setCity(entryAtributes[3]);
                    contact.setState(entryAtributes[4]);
                    contact.setPostalCode(entryAtributes[5]);
                    contact.setPhone(entryAtributes[6]);
                    contact.setEmail(entryAtributes[7]);

                    add(contact);
                }

                entryAtribute = readerLines.readLine();
                counter++;

            }

            readerLines.close();

          } catch(IOException e) {
                System.out.println("Unable to read the file");
          }

    }

    public ArrayList<AddressEntry> Search(String lastname){
        ArrayList<AddressEntry> searchResults = new ArrayList<>();
        for(int i = 0; i < contacts.size();i++){
            AddressEntry contact = contacts.get(i);
            if((contact.getLastname()).startsWith(lastname)){
                add(contact);
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

