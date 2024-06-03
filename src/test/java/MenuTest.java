import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import address.Menu;
import address.data.AddressBook;
import address.data.AddressEntry;

import java.util.List;
import java.util.Scanner;

public class MenuTest {

    private AddressBook addressBook;
    private Menu menu;

    @Before
    public void setUp() {
        addressBook = new AddressBook();
        menu = new Menu(addressBook);
    }

    @Test
    public void addNewRegisterTest() {
        Scanner scanner = new Scanner("Juan\nMartinez\nRio Coatzacoalcos\nCoatzacoalcos\nVER\n96535\ncualquiera@gmail.com\n9211492939\n");

        menu.addNewRegister(scanner);

        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(1, allEntries.size());
        AddressEntry entrada = allEntries.get(0);
        assertEquals("Juan", entrada.getFirstName());
        assertEquals("Martinez", entrada.getLastName());
    }

    @Test
    public void removeRegisterTest() {
        AddressEntry entrada = new AddressEntry("Maria", "Luisa", "Rio Bravo", "Mina", "VER", 98763, "922345667", "maria@gmail");
        addressBook.addNewRegister(entrada);


        Scanner scanner = new Scanner("Martinez\n1\n");


        menu.removeRegister(scanner);

        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(1, allEntries.size());
    }

    @Test
    public void searchRegisterTest() {

        AddressEntry entrada1 = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", 12345, "92114920239", "cualquiera@gmail.com");
        AddressEntry entrada2 = new AddressEntry("Maria", "Luisa", "Rio Bravo", "Mina", "VER", 98763, "922345667", "maria@gmail");
        addressBook.addNewRegister(entrada1);
        addressBook.addNewRegister(entrada2);


        Scanner scanner = new Scanner("Doe\n");


        menu.searchRegister(scanner);

        List<AddressEntry> searchResult = addressBook.searchRegister("Martinez");
        assertEquals(1, searchResult.size());
    }

    @Test
    public void showAllRegistersTest() {

        AddressEntry entrada1 = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", 12345, "92114920239", "cualquiera@gmail.com");
        AddressEntry entrada2 = new AddressEntry("Maria", "Luisa", "Rio Bravo", "Mina", "VER", 98763, "922345667", "maria@gmail");
        addressBook.addNewRegister(entrada1);
        addressBook.addNewRegister(entrada2);


        menu.showAllRegisters();

        List<AddressEntry> allEntries = addressBook.getAllRegisters();
        assertEquals(2, allEntries.size());
    }
} 