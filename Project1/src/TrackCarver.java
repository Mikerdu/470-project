import java.util.InputMismatchException;
import java.util.Scanner;

public class TrackCarver {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int y, x;
        do {
            try {
                System.out.println("How high would you like the track to be? (Even numbers will be converted to odd)");
                y = kb.nextInt();
                System.out.println("How much width would you like the track to be? (Even numbers will be converted to odd)");
                x = kb.nextInt();

                // Make sure the sizes are not negative
                y = Math.abs(y);
                x = Math.abs(x);

                // and make sure they are odd values
                if (y % 2 == 0)
                    y++;

                if (x % 2 == 0)
                    x++;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Type a valid integer");
                kb.nextLine();
                y = 0;
                x = 0;
            }
        } while (x <= 0 || y <= 0);

        System.out.println("Enter the starting coordinates for your x");
        int startX = kb.nextInt();
        System.out.println("Enter the starting coordinates for your y");
        int startY = kb.nextInt();

        System.out.println("Enter the ending coordinates for your x");
        int endX = kb.nextInt();
        System.out.println("Enter the ending coordinates for your y");
        int endY = kb.nextInt();

        // Create the grid
        char[][] grid = new char[x][y];
        TrackGenerator.generateMaze(grid, startX, startY);

        // Print the grid to a textfile or "" to print to screen
        TrackGenerator.printMatrix(grid, "");

        System.out.println("Done!");
    }
}

