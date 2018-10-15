package edu.miracosta.cs113;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.*;

public class CircularArrayQueue<E> implements Queue<E>
{
    private int initialCapacity;
    private int front;
    private int rear;
    private int size;
    private ArrayList<E> queToAddTo;

    /***************************************************************
     * Default constructor.
     ***************************************************************/
    CircularArrayQueue()
    {
        initialCapacity = 20;
        queToAddTo = new ArrayList<E>(initialCapacity);
    }

    /***************************************************************
     * Int constructor
     * @param initialCapacityToSet Number of objects the list can hold.
     ***************************************************************/
    CircularArrayQueue(int initialCapacityToSet)
    {
        initialCapacity = initialCapacityToSet;
        front = 0;
        rear = initialCapacityToSet-1;
        queToAddTo = new ArrayList<E>(initialCapacityToSet);
        size = 0;
    }

    /***************************************************************
     * Inserts the specified element into this queue if it is
     * possible to do so immediately without violating capacity
     * restrictions, returning true upon success and throwing an
     * IllegalStateException if no space is currently available.
     * @param e The object you wish to add to the head of the list.
     * @exception IllegalStateException if no space is currently available.
     ***************************************************************/
    @Override
    public boolean add(E e)
    {
        if(initialCapacity == size)
        {
            throw new IllegalStateException();
        }
        else
        {
            size++;
            rear = (rear+1) % initialCapacity;
            queToAddTo.add(rear, e);
            return true;
        }
    }

    /***************************************************************
     * Retrieves, but does not remove, the head of this queue.
     * @return The first item in the que.
     ***************************************************************/
    @Override
    public E element()
    {
        if(size == 0)
        {
             throw new NoSuchElementException();
        }
        return queToAddTo.get(front);
    }
    /***************************************************************
     * Inserts the specified element into this queue if it is
     * possible to do so immediately without violating capacity
     * restrictions.
     ***************************************************************/
    @Override
    public boolean offer(E e)
    {
        if(initialCapacity == size)
        {
            reallocate();
        }
            size++;
            rear = (rear+1) % initialCapacity;
            queToAddTo.add(rear, e);
            return true;
    }
    /***************************************************************
     * Retrieves, but does not remove, the head of this queue,
     * or returns null if this queue is empty.
     ***************************************************************/
    @Override
    public E peek()
    {
        if(size == 0)
        {
            return null;
        }
        return queToAddTo.get(front);
    }
    /***************************************************************
     * Retrieves and removes the head of this queue, or returns
     * null if this queue is empty.
     ***************************************************************/
    @Override
    public E poll()
    {
       if(size == 0)
       {
           return null;
       }
       E item = queToAddTo.get(front);
       front = (front+1) % initialCapacity;
       size--;
       return item;
    }

    /***************************************************************
     * Retrieves and removes the head of this queue.
     ***************************************************************/
    @Override
    public E remove()
    {
        if (size == 0)
        {
            throw new NoSuchElementException();
        }

         E item = queToAddTo.get(front);
         front = (front+1) % initialCapacity;
         size--;
         return item;
    }

    private void reallocate()
    {
        int newCapacity = initialCapacity*2;
        ArrayList<E> newArraylist = new ArrayList<E>(newCapacity);
        int f = front;
        for(int i = 0; i < size; i++)
        {
            newArraylist.add(i, queToAddTo.get(f));
            f = (f+1) % initialCapacity;
        }
        front = 0;
        rear = size - 1;
        initialCapacity = newCapacity;
        queToAddTo = newArraylist;
    }

    @Override
    public String toString()
    {
        return null;
    }

    /***************************************************************
     * Methods inherited from interface java.util.Collection:
     ***************************************************************/
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean equals(Object o)
    {
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

}
