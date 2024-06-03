import org.junit.Test;

import address.data.AddressEntry;

import static org.junit.Assert.*;

public class AddressEntryTest {
    
    @Test
    public void GettersTest() {
        AddressEntry entrada = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", 12345, "92114920239", "cualquiera@gmail.com");
        
        assertEquals("Pepe", entrada.getFirstName());
        assertEquals("Martinez", entrada.getLastName());
        assertEquals("Rio Coatzacoalcos", entrada.getStreet());
        assertEquals("Coatzacoalcos", entrada.getCity());
        assertEquals("Veracruz", entrada.getState());
        assertEquals(12345, entrada.getZIP());
        assertEquals("92114920239", entrada.getPhoneNumber());
        assertEquals("cualquiera@gmail.com", entrada.getEmailAddress());
    }
    
    @Test
    public void settersTest() {
        AddressEntry entrada = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", 12345, "92114920239", "cualquiera@gmail.com");
        
        entrada.setFirstName("Jane");
        entrada.setLastName("Smith");
        entrada.setStreet("456 Elm St");
        entrada.setCity("Othertown");
        entrada.setState("TX");
        entrada.setZIP(67890);
        entrada.setPhoneNumber("555-6789");
        entrada.setEmailAddress("jane.smith@gmail.com");
    }
    
    @Test
    public void toStringTest() {
        AddressEntry entrada = new AddressEntry("Pepe", "Martinez", "Rio Coatzacoalcos", "Coatzacoalcos", "Veracruz", 12345, "92114920239", "cualquiera@gmail.com");
        String expected = "Pepe Martinez\nRio Coatzacoalcos, Coatzacoalcos, Veracruz 12345\n92114920239\ncualquiera@gmail.com";
        
        assertEquals(expected, entrada.toString());
    }
}