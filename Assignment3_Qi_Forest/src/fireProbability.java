
public class fireProbability
{
	public static double probabilityOfFireSpreadDFS(double d)
	{
		int fireSpreadCount = 0;
		
		
		// Creating 10000 forests objects and if fire does spread (equivalent to DPS returns true), fireSpreadCount increments.
		for (int i = 0; i < 10000; i++)
		{
			Forest f = new Forest(20, 20, d);
			if (f.depthFirstSearch())
			{
				fireSpreadCount++;
			}
		}
	
		return fireSpreadCount / 10000.0;
	}
	
	public static double probabilityOfFireSpreadBFS(double d)
	{
		int fireSpreadCount = 0;
		
		// Creating 10000 forests objects and if fire does spread (equivalent to BFS returns true), fireSpreadCount increments.
		for (int i = 0; i < 10001; i++)
		{
			Forest f = new Forest(20, 20, d);
			if (f.breadthFirstSearch())
			{
				fireSpreadCount++;
			}
		}
		
		return fireSpreadCount / 10000.0;
	}
	
	public static double highestDensityDFS()
	{
		double lowDensity = 0.0;
		double highDensity = 1.0;
		double density = 0;
		double probability;

		for (int i = 0; i < 20; i++)
		{
			// check mid point
			density = (lowDensity + highDensity) / 2.0;
			
			// get probability of fire spreading in forests of 'density'
			probability = probabilityOfFireSpreadDFS(density);
			
			// check probability of fire spreading
			
			if (probability < 0.5)
			// low probability: density can be increased
			{
				lowDensity = density;
			}
			
			else
			{
				// high probability: density should be decreased
				highDensity = density;
			}
		}
		
		// the last value of "density" is the value we seek
		return density;
	}
	
	public static double highestDensityBFS()
	{
		double lowDensity = 0.0;
		double highDensity = 1.0;
		double density = 0;
		double probability;

		for (int i = 0; i < 20; i++)
		{
			// check mid point
			density = (lowDensity + highDensity) / 2.0;
			
			// get probability of fire spreading in forests of 'density'
			probability = probabilityOfFireSpreadBFS(density);
			
			// check probability of fire spreading
			
			if (probability < 0.5)
			// low probability: density can be increased
			{
				lowDensity = density;
			}
			
			else
			{
				// high probability: density should be decreased
				highDensity = density;
			}
		}
		
		// the last value of "density" is the value we seek
		return density;
	}
}
