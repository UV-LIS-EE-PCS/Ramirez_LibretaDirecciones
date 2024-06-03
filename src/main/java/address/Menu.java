package address;

import java.util.List;
import java.util.Scanner;

import address.data.AddressBook;
import address.data.AddressEntry;

/**
 * The Menu class provides a user interface for interacting with 
 * the AddressBook. It allows the user to load entries from a file, 
 * add new entries, remove entries, search entries by last name, 
 * and display all entries.
 */
public class Menu {
    
    private AddressBook addressBook;

    /**
     * Constructs a Menu with the specified AddressBook.
     *
     * @param addressBook the AddressBook to interact with
     */
    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Displays the menu and processes user input.
     */
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (exit == false) {
            System.out.println("------------------------------------");
            System.out.println("Elige una opción del menú:");
            System.out.println("a) Cargar de archivo");
            System.out.println("b) Agregar");
            System.out.println("c) Eliminar");
            System.out.println("d) Buscar");
            System.out.println("e) Mostrar");
            System.out.println("f) Salir");
            System.out.println("-------------------------------------");

            String choice = scanner.nextLine();

            switch (choice) {
                case "a":
                    openTXT(scanner);
                    break;
                case "b":
                    addNewRegister(scanner);
                    break;
                case "c":
                    removeRegister(scanner);
                    break;
                case "d":
                    searchRegister(scanner);
                    break;
                case "e":
                    showAllRegisters();
                    break;
                case "f":
                    exit = true;
                    break;
                default:
                    System.out.println("Elige una opción entre a y f");
            }
        }
    }

    /**
     * Prompts the user to enter details for a new address entry and adds it to the address book.
     *
     * @param scanner the Scanner object to read user input
     */
    public void addNewRegister(Scanner scanner) {
        System.out.println("Nombre:");
        String firstName = scanner.nextLine();
        System.out.println("Apellido:");
        String lastName = scanner.nextLine();
        System.out.println("Calle:");
        String street = scanner.nextLine();
        System.out.println("Ciudad:");
        String city = scanner.nextLine();
        System.out.println("Estado:");
        String state = scanner.nextLine();
        System.out.println("CP:");
        int zip = Integer.parseInt(scanner.nextLine());
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Teléfono:");
        String phone = scanner.nextLine();

        AddressEntry newRegister = new AddressEntry(firstName, lastName, street, city, state, zip, phone, email);
        addressBook.addNewRegister(newRegister);
    }

    /**
     * Prompts the user to enter the last name of the entry to remove and removes it from the address book.
     *
     * @param scanner the Scanner object to read user input
     */
    public void removeRegister(Scanner scanner) {
        System.out.println("Ingrese el apellido del registro a eliminar");
        String lastName = scanner.nextLine();

        List<AddressEntry> searchResult = addressBook.searchRegister(lastName);

        if (searchResult.isEmpty()) {
            System.out.println("Registro no encontrado");
        } else {
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println((i + 1) + ") " + searchResult.get(i));
            }
            System.out.println("Posición del registro que desea eliminar");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < searchResult.size()) {
                addressBook.removeRegister(searchResult.get(index));
            } else {
                System.out.println("Ingresa una opción válida");
            }
        }
    }

    /**
     * Prompts the user to enter a last name and searches for matching entries in the address book.
     *
     * @param scanner the Scanner object to read user input
     */
    public void searchRegister(Scanner scanner) {
        System.out.println("Buscar por apellido");
        String lastName = scanner.nextLine();
    
        List<AddressEntry> searchResult = addressBook.searchRegister(lastName);
    
        if (searchResult.isEmpty()) {
            System.out.println("Registro no encontrado");
        } else {
            for (int i = 0; i < searchResult.size(); i++) {
                AddressEntry register = searchResult.get(i);
                System.out.println(register);
            }
        }
    }
    
    /**
     * Displays all entries in the address book.
     */
    public void showAllRegisters() {
        List<AddressEntry> allRegisters = addressBook.getAllRegisters();
        if (allRegisters.isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            for (int i = 0; i < allRegisters.size(); i++) {
                AddressEntry register = allRegisters.get(i);
                System.out.println(register);
            }
        }
    }

    /**
     * Prompts the user to enter a filename and loads address entries from the specified file.
     *
     * @param scanner the Scanner object to read user input
     */
    public void openTXT(Scanner scanner) {
        System.out.println("Introduce el nombre del archivo:");
        String filename = scanner.nextLine();
        addressBook.loadFromFile(filename);
        System.out.println("Registros cargados desde el archivo.");
    }
    
}