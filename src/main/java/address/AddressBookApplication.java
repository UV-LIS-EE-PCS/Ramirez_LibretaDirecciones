package address;

import address.data.AddressBook;

/**
 * The AddressBookApplication class contains the main method 
 * to run the Address Book application. It initializes the 
 * AddressBook and Menu, and starts the menu.
 */
public class AddressBookApplication {

    /**
     * The main method is the entry point of the application. 
     * It creates an instance of AddressBook and Menu, and 
     * then starts the menu.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Menu menu = new Menu(addressBook);
        menu.menu();
    }
}
