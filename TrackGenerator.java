/*
 * Name: Michael Rdultowski
 * Date:3/22/23
 * Description: automated rat maze maker
This code was created by Clinton Rogers for the specific intent of being used by his students.
 * Derivative works based on this code may only be submitted to myCourses, and a copy local to the students
 * own computer. At no time should this code, derivative or otherwise, be shared with other students,
 * people, or posted online.
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class TrackGenerator {
	private static final char[][] theMaze = null;
	//Fill the 2D array 'wood' with non-space characters


	private static Random rand = new Random();

	private static void fill2DArray(char [][]wood) {
		
		for(int i = 0; i < wood.length; i++){
		    for(int j = 0; j < wood[i].length; j++){
		    	char a = (char)(rand.nextInt(26) + '*');
		        wood[i][j] = '*';
		    }
		}
	}		
		
		/*********************************************
		 * TODO FILL IN CODE HERE
		 * @return 
		 * @return 
		 *********************************************/
	
	
	
	private static void carveTrack(char [][] wood, int x, int y)
	{
		while(!hasNoNeighbors(wood, x, y)) {
			Random rand = new Random();
			int direction = rand.nextInt(4);
			switch (direction) {
			
			case 0: 
				if(hasNorthNeighbor(wood,x,y)) {
					wood[x][y-1] = ' ';
					wood[x][y-2] = ' ';
					carveTrack(wood, x, y-2);
				}
				break;
				//checks to move north
			case 1: 
				if(hasSouthNeighbor(wood, x, y)) {
				wood[x][y+1] = ' ';
				wood[x][y+2] = ' ';
				carveTrack(wood, x, y+2);
			}
				break;
				// checks to move south
			case 2:
				if(hasWestNeighbor(wood, x, y)) {
					wood[x-1][y] = ' ';
					wood[x-2][y] = ' ';
					carveTrack(wood, x-2, y);
				}
				break;
				//checks to move west
			case 3: 
				if(hasEastNeighbor(wood, x, y)) {
					wood[x+1][y] = ' ';
					wood[x+2][y] = ' ';
					carveTrack(wood, x+2, y);
				}
				break;
				//checks to move east
			}		
			
		}
	}
	
	


	
		
		
		
		/*********************************************
		 * TODO FILL IN CODE HERE
		 *********************************************/
	
	
	private static boolean hasWestNeighbor(char[][] wood, int x, int y)
	{
		return (x-2)>=1 && wood[x-2][y] != ' ';
	}
	
	private static boolean hasEastNeighbor(char[][] wood, int x, int y)
	{
		return (x+2)<wood.length && wood[x+2][y] != ' ';
	}
	
	private static boolean hasNorthNeighbor(char[][] wood, int x, int y)
	{
		return (y-2)>=1 && wood[x][y-2] != ' ';
	}
	private static boolean hasSouthNeighbor(char[][] wood, int x, int y)
	{
		return (y+2)<wood[x].length && wood[x][y+2] != ' ';
	}
	
	private static boolean hasNoNeighbors(char[][] wood, int x, int y)
	{
		return !hasWestNeighbor(wood,x,y) && !hasEastNeighbor(wood,x,y) && !hasNorthNeighbor(wood,x,y) && !hasSouthNeighbor(wood,x,y);
	}
	
	public static void generateMaze(char [][] wood, int x, int y)
	{
		fill2DArray(wood);
		carveTrack(wood,x,y);
	}

	public static void printMatrix(char [][]matrix, String toFile)
	{
		//if a file name is provided, print to the file
		if(toFile!= "")
		{		
			try{
				
				int count=1;
				String newFileName = toFile+".txt";
				File f = new File(newFileName);
				while(f.exists())
				{
					newFileName = toFile+count+".txt";
					count++;
					f=new File(newFileName);
				}
				
				PrintWriter writer = new PrintWriter(newFileName);
				//Fill matrix with non-space characters
				for(int y=0;y<matrix[0].length;y++)
				{
					for(int x=0;x<matrix.length;x++)
						writer.print(matrix[x][y]);
					writer.println();
				}
				writer.close();
			}catch(Exception e)
			{
				System.out.println("Exception e caught:" + e.getMessage());
			}
		}else //otherwise, print to the screen
		{
			//Fill matrix with non-space characters
			for(int y=0;y<matrix[0].length;y++)
			{
				for(int x=0;x<matrix.length;x++)
					System.out.print(matrix[x][y]);
				System.out.println();
			}
		}
	}
}