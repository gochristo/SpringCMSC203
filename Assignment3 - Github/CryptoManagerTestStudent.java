/*
 * Class: CMSC203
 * Instructor: Prof. Monshi
 * Description: This class contains tests for the methods in CryptoManager.java
 * Due: 10/13/24
 * Platform/compiler: IntelliJ IDEA
 * I pledge that I have completed the programming  assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Christopher Andrews
 */
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.util.Preconditions;

public class CryptoManagerTestStudent {
    CryptoManager cryptoManager;


    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("I LIKE CHIPOTLE"));
        assertTrue(CryptoManager.isStringInBounds("I AM AWWESOME"));
        assertFalse(CryptoManager.isStringInBounds("fart"));
        assertFalse(CryptoManager.isStringInBounds("this should not work {"));
        assertFalse(CryptoManager.isStringInBounds("\"uhhhhhhhhhh\""));
    }
    @Test
    public void testEncryptCaesar() {
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("hello world", 8));
        assertEquals("5566", CryptoManager.caesarEncryption("^^__", 23));
        assertEquals("FCJJM", CryptoManager.caesarEncryption("HELLO", -2));
        assertEquals("#", CryptoManager.caesarEncryption(" ", 67));
    }
    @Test
    public void testDecryptCaesar() {
        assertEquals("JK", CryptoManager.caesarDecryption("NO", 4));
        assertEquals("THE BURGER IS DOWNSTAIRS", CryptoManager.caesarDecryption(" TQ,N!^SQ^,U_,P[#Z_ MU^_", 12));
        assertEquals(" U!Y", CryptoManager.caesarDecryption("LAME", 300));
    }
    @Test
    public void testEncryptBellaso() {
        assertEquals("\\MU_#", CryptoManager.bellasoEncryption("HELLO", "THIS"));
        assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("SPR}NG BREAK", "CHERRY"));
        assertEquals("[('", CryptoManager.bellasoEncryption("XYZ", "COMM"));

    }
    @Test
    public void testDecryptBellaso() {
        assertEquals("5N9/G3", CryptoManager.bellasoDecryption("GOBBLE", "RAISE"));
        assertEquals("THE BUBBLES HAVE LANDED", CryptoManager.bellasoDecryption("$WU0Q%RQ\\U\"0XP&U/\\Q]TUS", "POPPOP"));
        assertEquals("ABCDEFG", CryptoManager.bellasoDecryption("DOVGHSZ", "CMSC"));

    }

}

