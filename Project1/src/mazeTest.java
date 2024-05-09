import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

public class mazeTest {

    @Test
    //test to make sure once an * is cut it ensures there is no * there 
    public void testFill2DArray() {      
        char[][] wood = new char[5][5]; 
        TrackGenerator.fill2DArray(wood); 
        for (int i = 0; i < wood.length; i++) {
            for (int j = 0; j < wood[i].length; j++) {
                assertNotEquals(' ', wood[i][j]);
            }
        }
    }

    @Test
    public void testCarveTrack() {
        char[][] wood = new char[5][5]; 
        TrackGenerator.fill2DArray(wood); 
        TrackGenerator.carveTrack(wood, 2, 2, 0, 0);  
    }
    private boolean hasSurroundingStars(char[][] array, int x, int y) {
        return array[x][y] == ' ' ||
               array[x-1][y] == '*' || array[x+1][y] == '*' ||
               array[x][y-1] == '*' || array[x][y+1] == '*';
        //checks if neighbors are being detected around the point
    }
    @Test
    public void testInvalidInput() {
        // Simulate user input that 
        String invalidInput = "invalid\n";
     
        InputStream originalSystemIn = System.in;

        try {
           
            ByteArrayInputStream in = new ByteArrayInputStream(invalidInput.getBytes());
            System.setIn(in);

        } catch (InputMismatchException e) {
         
            assertEquals("Invalid input. Type a valid integer", e.getMessage());
        } finally {
            
            System.setIn(originalSystemIn);
        }
    }
    @Test
    public void testStartingCoordinatesInput() {
        // starting x and y
        int Xstart = 3;
        int Ystart = 5;

       
        assertEquals(3, Xstart);
        assertEquals(5, Ystart);
    }
    @Test
    public void testStartingCoordinatesInput2() {
    	// starting x and y
        int Xstart = 1;
        int Ystart = 1;

        
        assertEquals(2, Xstart);
        assertEquals(2, Ystart);
    }
}




