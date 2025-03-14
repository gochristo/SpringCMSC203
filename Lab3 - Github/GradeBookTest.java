import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;



class GradeBookTest {

    private GradeBook gb1;
    private GradeBook gb2;

    @BeforeEach
    void setUp() {
        gb1 = new GradeBook(5);
        gb2 = new GradeBook(5);

        gb1.addScore(21.5);
        gb1.addScore(98.2);
        gb1.addScore(99.9);

        gb2.addScore(37.0);
        gb2.addScore(77.7);
    }

    @AfterEach
    void tearDown() {
        gb1 = null;
        gb2 = null;
    }

    @Test
    void addScore() {
        String expectedScores = "21.5 98.2 99.9 ";
        assertTrue(gb1.toString().equals(expectedScores));
        String expectedScores2 = "37.0 77.7 ";
        assertTrue(gb2.toString().equals(expectedScores2));

        assertEquals(3,gb1.getScoresSize());
        assertEquals(2,gb2.getScoresSize());
    }

    @Test
    void sum() {
        assertEquals(219.6, gb1.sum(),0.0001);
        assertEquals(114.7, gb2.sum(), 0.0001);
    }

    @Test
    void minimum() {
        assertEquals(21.5, gb1.minimum());
        assertEquals(37.0, gb2.minimum());
    }

    @Test
    void finalScore() {
        assertEquals(198.1, gb1.finalScore(),0.0001);
        assertEquals(77.7, gb2.finalScore(),0.0001);
    }


}