package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * 
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.08.10
 *
 */
public class ArrayQueue<T> implements QueueInterface<T> 
{
    private T[] queue;
    private static final int DEFAULT_CAPACITY = 10;
    
    /** 
     * @constant MAX_CAPACITY
     * holding the maximum capacity 
     * possible
     */
    public static final int MAX_CAPACITY = 100;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;
    
 // ~ Constructor ...........................................................
    /**
     * new ArrayQueue Object
     */
    public ArrayQueue()
    {
        clear(); 
    }

    /**
     * Clears the arrayQueue
     */
    @Override
    public void clear() 
    {
        enqueueIndex = DEFAULT_CAPACITY;
        dequeueIndex = 0;
        size = 0;
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];

    }


    /**
     * Returns the length of the
     * ArrayQueue
     * @return int length of
     * arrayqueue
     */
    public int getLength()
    {
        return queue.length;
    }
    
    /**
     * Returns the size of
     * the ArrayQueue currently
     * @return int size of
     * arrayqueue
     */
    public int getSize()
    {
        return size;
    }
    /**
     * Returns whether or not 
     * the ArrayQueue is full
     * @return boolean of if it 
     * is full
     */
    private boolean isFull()
    {
        return dequeueIndex == ((enqueueIndex + 2) % queue.length);
    }
    
    /**
     * Increases capacity of ArrayQueue
     * if need be
     */
    private void ensureCapacity()
    {
        if (isFull())
        {
            T[] oldQueue = queue;
            int oldSize = size ;
            int newSize;
            newSize = 2 * oldSize + 1;
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for (int i = 0; i < oldSize; i++)   
            {
                
                queue[i] = oldQueue[dequeueIndex];
                dequeueIndex = (dequeueIndex + 1) % oldSize;
            }
            dequeueIndex = 0;
            enqueueIndex = oldSize - 1;
            
        }
    }
    
    /**
     * Removes object at the 
     * front of the ArrayQueue
     * @return T object removed
     */
    @Override 
    public T dequeue() 
    {
        T ret = getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = (dequeueIndex + 1) % queue.length;
        size--;
        return ret;
        
    }


    /**
     * Adds item to back
     * of the ArrayQueue
     * @param newEntry T
     * to be added
     */
    @Override
    public void enqueue(T newEntry) 
    {
        if (size + 1 > MAX_CAPACITY)
        {
            throw new IllegalStateException();
        }
        ensureCapacity();
        

        enqueueIndex = (enqueueIndex + 1) % queue.length;  
        queue[enqueueIndex] = newEntry;
        size++;
        
    }


    /**
     * Returns object at the 
     * front of the ArrayQueue
     * @return T object at
     * front
     */
    @Override
    public T getFront() 
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            return queue[dequeueIndex];
        }
    }
    
    /**
     * Increases the index value 
     * by 1
     * @param index value to increase
     * @return new index value
     */
    private int incrementIndex(int index)
    {
        return ((index + 1) % queue.length);
    }


    /**
     * Checks if the 
     * ArrayQueue is empty
     * @return boolean of 
     * whether it is empty or not
     */
    @Override
    public boolean isEmpty() 
    {
        return dequeueIndex == incrementIndex(enqueueIndex);
    }

    /**
     * Returns the ArrayQueue 
     * in the form of an array with a 
     * starting index at 0
     * @return Object[] array
     */
    public Object[] toArray()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        
        T[] ret = (T[]) new Object[size];
        int r = dequeueIndex;
        for (int i = 0; i < size; i++)
        {
            
            ret[i] = queue[r];
            r = incrementIndex(r);
        }
        return ret;
        
    }
    
    /**
     * Returns String form of the
     * ArrayQueue
     * @return String form 
     * of the ArrayQueue
     */
    public String toString()
    {
        if (isEmpty())
        {
            return "[]";
        }
        Object[] temp = (Object[]) toArray();
        String ret = "";
        for (int i = 0; i < size; i++)
        {
            if (i == size - 1)
            {
                ret = ret + temp[i].toString();
            }
            else
            {
                ret = ret + temp[i].toString() + ", ";
            }
        }
        ret = "[" + ret + "]";
        return ret;
    }
    
    /**
     * Compares 2 objects to see if 
     * they are equals
     * @param obj Object being compared
     * to
     * @return boolean of whether 
     * or not the 2 objects 
     * are equals
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        else if (obj == null) 
        {
            return false;
        }
        
        else if (getClass() == obj.getClass())
        {
            
            ArrayQueue<T> temp = (ArrayQueue<T>) (obj);
            if (size == temp.getSize()) 
            {
                if (size == 0)
                {
                    return true;
                }
                T[] og = (T[])toArray();
                T[] newG = (T[])temp.toArray();
                for (int i = 0; i < size; i++)
                {

                    if (!og[i].equals(newG[i]))
                    {
                        return false;
                        
                    }
                }
                return true;
            }
        }
        return false;
       
    }
}
