import java.awt.Point;
import java.util.Stack;

public class Forest 
{
	private int[][] arr;
	private int height;
	private int width;
	
	public Forest(int h, int w, double d)
	{
		height = h;
		width = w;
		arr = new int[h][w];
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[0].length; j++)
			{
				double random = Math.random();
				if (random < d)
				{
					arr[i][j] = 1;
				}
				else
				{
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < arr.length; i++)
		{
			for (int j=0; j < arr[0].length; j++)
			{
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public boolean depthFirstSearch()
	{
		Stack<Point> cellsToExplore = new Stack<Point>();
		
		// iterate over top row, if tree is found, set on fire
		for (int i = 0; i < arr[0].length; i++)
		{
			if (arr[0][i] == 1)
			{
				// Here, x-coordinate of the point is row/height; y-coordinate is column/width
				cellsToExplore.push(new Point(0,i));
				
				// set that tree on "fire"
				arr[0][i] = 2; 
			}
		}
		
		Point currentPosition;
		while (!cellsToExplore.isEmpty())
		{
			currentPosition = new Point(cellsToExplore.pop());
			arr[currentPosition.x][currentPosition.y] = 2;
			
			// height - 1 because grid starts at 0
			if (currentPosition.x == arr.length - 1)
			{
				return true;
			}
			
			
			// Finding the neighboring points 
			Point up    = new Point((currentPosition.x - 1), currentPosition.y);
			Point down  = new Point((currentPosition.x + 1), currentPosition.y);
			Point left  = new Point(currentPosition.x, (currentPosition.y - 1));
			Point right = new Point(currentPosition.x, (currentPosition.y + 1));
			
			
			
			// This checks if the top side of the cell has tree and guarantees it's not out of the grid from the top side
			if (up.x >= 0)
			{
				if(arr[up.x][up.y] == 1)
				{
					cellsToExplore.push(up);
					arr[up.x][up.y] = 2;
				}
			}
				
			// This checks if the right side of the cell has tree and guarantees it's not out of the grid from the right side
			if (right.y < width)
			{
				if(arr[right.x][right.y] == 1)
				{
					cellsToExplore.push(right);
					arr[right.x][right.y] = 2;
				}
			}
			
			// This checks if the left side of the cell has tree and guarantees it's not out of the grid from the left side
			if (left.y >= 0)
			{
				if(arr[left.x][left.y] == 1)
				{
					cellsToExplore.push(left);
					arr[left.x][left.y] = 2;
				}
			}
			
			// This checks if the cell below has tree and guarantees it's not out of the grid from the right side
			if (down.x < height)
			{
				if(arr[down.x][down.y] == 1)
				{
					cellsToExplore.push(down);
					arr[down.x][down.y] = 2;
				}
			}
			
		}
		return false;
	}
	
	public boolean breadthFirstSearch()
	{
		ArrayQueue<Point> cellsToExplore = new ArrayQueue<Point>(60);
		
		// iterate over top row, if tree is found, set on fire
		for (int i = 0; i < arr[0].length; i++)
		{
			if (arr[0][i] == 1)
			{
				// Here, x-coordinate of the point is row/height; y-coordinate is column/width
				cellsToExplore.enqueue(new Point(0,i));
				
				// set that tree on "fire"
				arr[0][i] = 2; 
			}
		}
		
		Point currentPosition;
		while (!cellsToExplore.isEmpty())
		{
			currentPosition = new Point(cellsToExplore.dequeue());
			arr[currentPosition.x][currentPosition.y] = 2;
			
			// height - 1 because grid starts at 0
			if (currentPosition.x == arr.length - 1)
			{
				return true;
			}
			
			
			// Finding the neighboring points 
			Point up    = new Point((currentPosition.x - 1), currentPosition.y);
			Point down  = new Point((currentPosition.x + 1), currentPosition.y);
			Point left  = new Point(currentPosition.x, (currentPosition.y - 1));
			Point right = new Point(currentPosition.x, (currentPosition.y + 1));
			
			
			
			// This checks if the top side of the cell has tree and guarantees it's not out of the grid from the top side
			if (up.x >= 0)
			{
				if(arr[up.x][up.y] == 1)
				{
					cellsToExplore.enqueue(up);
					arr[up.x][up.y] = 2;
				}
			}
				
			// This checks if the right side of the cell has tree and guarantees it's not out of the grid from the right side
			if (right.y < width)
			{
				if(arr[right.x][right.y] == 1)
				{
					cellsToExplore.enqueue(right);
					arr[right.x][right.y] = 2;
				}
			}
			
			// This checks if the left side of the cell has tree and guarantees it's not out of the grid from the left side
			if (left.y >= 0)
			{
				if(arr[left.x][left.y] == 1)
				{
					cellsToExplore.enqueue(left);
					arr[left.x][left.y] = 2;
				}
			}
			
			// This checks if the cell below has tree and guarantees it's not out of the grid from the right side
			if (down.x < height)
			{
				if(arr[down.x][down.y] == 1)
				{
					cellsToExplore.enqueue(down);
					arr[down.x][down.y] = 2;
				}
			}
			
		}
		return false;
	}
}
