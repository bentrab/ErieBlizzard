import org.junit.Test;
import static org.junit.Assert.*;


public class SameGameTesting {

    @Test
    public void testFillBoard() {
        SameGameBoard s1 = new SameGameBoard(3, 3, 1);
        assertEquals(s1.getBoard()[0][0], 1);
        assertEquals(s1.getBoard()[0][1], 1);
        assertEquals(s1.getBoard()[0][2], 1);
        assertEquals(s1.getBoard()[1][0], 1);
        assertEquals(s1.getBoard()[1][1], 1);
        assertEquals(s1.getBoard()[1][2], 1);
        assertEquals(s1.getBoard()[2][0], 1);
        assertEquals(s1.getBoard()[2][1], 1);
        assertEquals(s1.getBoard()[2][2], 1);
        SameGameBoard s2 = new SameGameBoard(3, 3, 2);
        assertTrue(s1.getBoard()[0][0] == 1 || s1.getBoard()[0][0] == 2);
        assertTrue(s1.getBoard()[0][1] == 1 || s1.getBoard()[0][1] == 2);
        assertTrue(s1.getBoard()[0][2] == 1 || s1.getBoard()[0][2] == 2);
        assertTrue(s1.getBoard()[1][0] == 1 || s1.getBoard()[1][0] == 2);
        assertTrue(s1.getBoard()[1][1] == 1 || s1.getBoard()[1][1] == 2);
        assertTrue(s1.getBoard()[1][2] == 1 || s1.getBoard()[1][2] == 2);
        assertTrue(s1.getBoard()[2][0] == 1 || s1.getBoard()[2][0] == 2);
        assertTrue(s1.getBoard()[2][1] == 1 || s1.getBoard()[2][1] == 2);
        assertTrue(s1.getBoard()[2][2] == 1 || s1.getBoard()[2][2] == 2);
    }

    @Test
    public void testShiftCells() {
        SameGameBoard s1 = new SameGameBoard(3, 3, 1);
        s1.deleteCells(1,1);
        assertEquals(s1.getBoard()[0][0], 1);
        assertEquals(s1.getBoard()[0][1], 0);
        assertEquals(s1.getBoard()[0][2], 1);
        assertEquals(s1.getBoard()[1][0], 0);
        assertEquals(s1.getBoard()[1][1], 0);
        assertEquals(s1.getBoard()[1][2], 0);
        assertEquals(s1.getBoard()[2][0], 1);
        assertEquals(s1.getBoard()[2][1], 0);
        assertEquals(s1.getBoard()[2][2], 1);
        s1.shiftCells();  //Deleted middle cell, so it has to shift down AND to the left
        assertEquals(s1.getBoard()[0][0], 1);
        assertEquals(s1.getBoard()[0][1], 1);
        assertEquals(s1.getBoard()[0][2], 0);
        assertEquals(s1.getBoard()[1][0], 1);
        assertEquals(s1.getBoard()[1][1], 1);
        assertEquals(s1.getBoard()[1][2], 0);
        assertEquals(s1.getBoard()[2][0], 0);
        assertEquals(s1.getBoard()[2][1], 0);
        assertEquals(s1.getBoard()[2][2], 0);
    }

    @Test
    public void testDeleteCells() {
        SameGameBoard s1 = new SameGameBoard(3, 3, 1);
        s1.deleteCells(1,1); //Middle Cell
        assertEquals(s1.getBoard()[0][0], 1);
        assertEquals(s1.getBoard()[0][1], 0);
        assertEquals(s1.getBoard()[0][2], 1);
        assertEquals(s1.getBoard()[1][0], 0);
        assertEquals(s1.getBoard()[1][1], 0);
        assertEquals(s1.getBoard()[1][2], 0);
        assertEquals(s1.getBoard()[2][0], 1);
        assertEquals(s1.getBoard()[2][1], 0);
        assertEquals(s1.getBoard()[2][2], 1);
        SameGameBoard s2 = new SameGameBoard(3, 3, 1);
        s2.deleteCells(0,0); //Bottom Left Corner
        assertEquals(s2.getBoard()[0][0], 0);
        assertEquals(s2.getBoard()[0][1], 0);
        assertEquals(s2.getBoard()[0][2], 0);
        assertEquals(s2.getBoard()[1][0], 0);
        assertEquals(s2.getBoard()[1][1], 1);
        assertEquals(s2.getBoard()[1][2], 1);
        assertEquals(s2.getBoard()[2][0], 0);
        assertEquals(s2.getBoard()[2][1], 1);
        assertEquals(s2.getBoard()[2][2], 1);
        SameGameBoard s3 = new SameGameBoard(3, 3, 1);
        s3.deleteCells(2,0); //Bottom Right Corner
        assertEquals(s3.getBoard()[0][0], 0);
        assertEquals(s3.getBoard()[0][1], 1);
        assertEquals(s3.getBoard()[0][2], 1);
        assertEquals(s3.getBoard()[1][0], 0);
        assertEquals(s3.getBoard()[1][1], 1);
        assertEquals(s3.getBoard()[1][2], 1);
        assertEquals(s3.getBoard()[2][0], 0);
        assertEquals(s3.getBoard()[2][1], 0);
        assertEquals(s3.getBoard()[2][2], 0);
        SameGameBoard s4 = new SameGameBoard(3, 3, 1);
        s4.deleteCells(2,2); //Top Right Corner
        assertEquals(s4.getBoard()[0][0], 1);
        assertEquals(s4.getBoard()[0][1], 1);
        assertEquals(s4.getBoard()[0][2], 0);
        assertEquals(s4.getBoard()[1][0], 1);
        assertEquals(s4.getBoard()[1][1], 1);
        assertEquals(s4.getBoard()[1][2], 0);
        assertEquals(s4.getBoard()[2][0], 0);
        assertEquals(s4.getBoard()[2][1], 0);
        assertEquals(s4.getBoard()[2][2], 0);
        SameGameBoard s5 = new SameGameBoard(3, 3, 1);
        s5.deleteCells(0,2); //Top Left Corner
        assertEquals(s5.getBoard()[0][0], 0);
        assertEquals(s5.getBoard()[0][1], 0);
        assertEquals(s5.getBoard()[0][2], 0);
        assertEquals(s5.getBoard()[1][0], 1);
        assertEquals(s5.getBoard()[1][1], 1);
        assertEquals(s5.getBoard()[1][2], 0);
        assertEquals(s5.getBoard()[2][0], 1);
        assertEquals(s5.getBoard()[2][1], 1);
        assertEquals(s5.getBoard()[2][2], 0);
    }
}
