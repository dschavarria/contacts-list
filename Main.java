import com.idano.MyContacts;
import com.idano.model.ContactList;

public class Main {

    public static void main(String[] args){
        ContactList contacts = new ContactList();
        MyContacts program = new MyContacts(contacts);
        program.run();
    }
}
