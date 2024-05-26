package Main.address.data;
import java.util.ArrayList;
import java.io.*;
    /**
     * La clase AddressBook representa un libro de direcciones que contiene una lista de contactos.
     * Permite agregar, eliminar, buscar y mostrar contactos.
     * @author Sebati HM
     */

public class AddressBook {
    private ArrayList<AddressEntry>  contacts= new ArrayList<>();
    /**
     * Agrega un nuevo contacto al libro de direcciones si no existe un contacto con la misma información.
     * @param contact El contacto que se va a agregar.
     */

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


        /**
         * Elimina un contacto del libro de direcciones.
         * @param contactEntry El contacto que se va a eliminar.
         */

        public void delete(AddressEntry contactEntry){
            contacts.remove(contactEntry);
        }


        /**
         * Agrega contactos desde un archivo de texto al libro de direcciones.
         * 
         * Mediante el uso del buffered reader lee cada linea como un atributo de AddressEntry por lo cual
         * al ser estos 8 argumentos, el codigo usa un arreglo para almacenar la informacion y una vez llega a los 8 parametros
         * se inserta la informacion en una instancia de AddressEntry para que se pueda añadir al AddressBook
         * @param filename El archivo desde el cual se van a agregar los contactos.
         */

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


        /**
         * Busca contactos por apellido en el libro de direcciones.
         * @param lastname El apellido por el cual se va a realizar la búsqueda.
         * @return Una lista de contactos que coinciden con el apellido especificado.
         */

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

        /**
         * Muestra todos los contactos en el libro de direcciones.
         */
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

