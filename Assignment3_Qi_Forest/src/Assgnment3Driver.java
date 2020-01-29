/*
 * Yu Qi
 * Assignment3_Forest
 * 
 * Comment for time difference between DFS and BFS:
 * 	  From the demos of BFS and DFS: BFS goes through each level first before moving onto the next level (e.g. moves from left right until
 * 	  all the possible elements on this row has all gone through), while DFS goes through different levels first until it reaches the end
 * 	  (e.g. goes through column/vertically first). In this case, DFS was a bit faster because as it goes through each path from top to
 * 	  bottom, there's chance this specific path can successfully spread the fire while BFS has to go through every single row first.
 */

import java.awt.Point;

public class Assgnment3Driver
{

	public static void main(String[] args)
	{
//		Forest f = new Forest(3, 5, 0.79);
//		
//		// The following code tests the DFS and BFS methods do indeed work
//		System.out.println(f.toString());
//		
//		System.out.println(f.depthFirstSearch());
//		
//		System.out.println(f.toString());
//		
//		System.out.println(f.toString());
//		
//		System.out.println(f.breadthFirstSearch());
//		
//		System.out.println(f.toString());
		
		long start = System.currentTimeMillis();
		System.out.println("Optimal density from DFS: " + fireProbability.highestDensityDFS());
		long end = System.currentTimeMillis();
		
		System.out.println("Time for DFS: " + (end - start));
		
		long start1 = System.currentTimeMillis();
		System.out.println("Optimal density from BFS: " + fireProbability.highestDensityBFS());
		long end1 = System.currentTimeMillis();
		
		System.out.println("Time for BFS: " + (end1 - start1));
	}

}
