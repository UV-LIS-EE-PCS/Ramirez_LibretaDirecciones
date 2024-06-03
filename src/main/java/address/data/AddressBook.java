package address.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an address book which holds a list of address entries.
 */
public class AddressBook {
    
    private List<AddressEntry> listOfRegisters;

    /**
     * Constructs an empty AddressBook.
     */
    public AddressBook() {
        this.listOfRegisters = new ArrayList<>();
    }

    /**
     * Adds a new address entry to the address book.
     *
     * @param userInput the address entry to be added
     */
    public void addNewRegister(AddressEntry userInput) {
        listOfRegisters.add(userInput);
    }

    /**
     * Removes an address entry from the address book.
     *
     * @param userInput the address entry to be removed
     */
    public void removeRegister(AddressEntry userInput) {
        listOfRegisters.remove(userInput);
    }

    /**
     * Searches for address entries by last name.
     *
     * @param lastName the last name to search for
     * @return a list of address entries with the matching last name
     */
    public List<AddressEntry> searchRegister(String lastName) {
        List<AddressEntry> searchResults = new ArrayList<>();
        for (int i = 0; i < listOfRegisters.size(); i++) {
            AddressEntry userInput = listOfRegisters.get(i);
            if (userInput.getLastName().equals(lastName)) {
                searchResults.add(userInput);
            }
        }
        return searchResults;
    }

    /**
     * Gets all address entries in the address book.
     *
     * @return a list of all address entries
     */
    public List<AddressEntry> getAllRegisters() {
        return listOfRegisters;
    }

    /**
     * Loads address entries from a file.
     *
     * @param filename the name of the file to load from
     */
    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    AddressEntry userInput = new AddressEntry(
                        data[0].trim(),  // firstName
                        data[1].trim(),  // lastName
                        data[2].trim(),  // street
                        data[3].trim(),  // city
                        data[4].trim(),  // state
                        Integer.parseInt(data[5].trim()),  // ZIP
                        data[6].trim(),  // phoneNumber
                        data[7].trim()   // emailAddress
                    );
                    addNewRegister(userInput);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Returns a string representation of the address book.
     *
     * @return a string representation of all address entries in the address book
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < listOfRegisters.size(); i++) {
            AddressEntry userInput = listOfRegisters.get(i);
            result = result + userInput.toString() + "\n";
        }
        return result;
    }

    /**
     * Opens a text file. This method is not implemented yet.
     *
     * @param filename the name of the file to open
     */
    public void openTXT(String filename) {
        throw new UnsupportedOperationException("Unimplemented method 'openTXT'");
    }
}
