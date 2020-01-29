
public class ArrayQueue<E> implements Queue<E> 
{
	private int size;
	private int front;
	private E[] theQueue;
	
	public ArrayQueue(int capacity)
	{
		size = 0;
		front = 0;
		theQueue = (E[]) new Object[capacity];
	}
	
	public void enqueue(E v)
	{
		if (size >= theQueue.length)
		{
			throw new IllegalStateException("Queue is full!");
		}
		
		theQueue[(front + size) % theQueue.length] = v;
		size++;
	}
	
	public E dequeue()
	{
		if (size == 0)
		{
			throw new IllegalStateException("Queue is empty!");
		}
		
		E value = theQueue[front];
		theQueue[front] = null;
		front = (front + 1) % theQueue.length;
		size--;
		
		return value;
	}
	
	public E front()
	{
		if (size == 0)
		{
			throw new IllegalStateException("Queue is empty!");
		}
		E value = theQueue[front];
		
		return value;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Queue: " + " ");
		
		for (int i = 0; i < size; i++)
		{
			sb.append(theQueue[(front + i) % theQueue.length] + " ");
		}
		
		return sb.toString();
	}
	
	public int size()
	{
		return size;
	}
}
