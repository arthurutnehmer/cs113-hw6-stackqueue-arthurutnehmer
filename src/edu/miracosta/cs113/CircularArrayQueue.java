package edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularArrayQueue<E> implements Queue<E>
{
    private int initialCapacity;
    private ArrayListStack<E> stackToAddTo;
    private int currentSize;

    /***************************************************************
     * Default constructor.
     ***************************************************************/
    CircularArrayQueue()
    {
        initialCapacity = 0;
        stackToAddTo = new ArrayListStack<E>(initialCapacity);
        currentSize = 0;
    }

    /***************************************************************
     * Int constructor
     * @param initialCapacityToSet Number of objects the list can hold.
     ***************************************************************/
    CircularArrayQueue(int initialCapacityToSet)
    {
        initialCapacity = initialCapacityToSet;
        stackToAddTo = new ArrayListStack<E>(initialCapacity);
        currentSize = 0;
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
        if(initialCapacity == currentSize)
        {
            throw new IllegalStateException();
        }
        else
        {
            stackToAddTo.push(e);
            currentSize++;
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
        if(!stackToAddTo.empty())
        {
            ArrayListStack<E> tmpArraylist = new ArrayListStack<E>(stackToAddTo);
            return tmpArraylist.peek();
        }
        else
        {
            throw new NoSuchElementException();
        }
    }
    /***************************************************************
     * Inserts the specified element into this queue if it is
     * possible to do so immediately without violating capacity
     * restrictions.
     ***************************************************************/
    @Override
    public boolean offer(E e)
    {
        if(initialCapacity >= currentSize)
        {
            stackToAddTo.push(e);
            currentSize++;
            return true;
        }
        else
        {
            return false;
        }
    }
    /***************************************************************
     * Retrieves, but does not remove, the head of this queue,
     * or returns null if this queue is empty.
     ***************************************************************/
    @Override
    public E peek()
    {
        if(!stackToAddTo.empty())
        {
            ArrayListStack<E> tmpArraylist = new ArrayListStack<E>(stackToAddTo);
            return tmpArraylist.peek();
        }
        else if(stackToAddTo.empty())
        {
            return null;
        }
        return null;
    }
    /***************************************************************
     * Retrieves and removes the head of this queue, or returns
     * null if this queue is empty.
     ***************************************************************/
    @Override
    public E poll()
    {
        if(!stackToAddTo.empty())
        {
            ArrayListStack<E> tmpArraylist = new ArrayListStack<E>(stackToAddTo);
            E obj = tmpArraylist.peek();
            tmpArraylist.pop();
            ArrayListStack<E> tmpArraylist2 = new ArrayListStack<E>(tmpArraylist);
            stackToAddTo = tmpArraylist2;
            return obj;
        }
        else if(stackToAddTo.empty())
        {
            return null;
        }
        return null;
    }

    /***************************************************************
     * Retrieves and removes the head of this queue.
     ***************************************************************/
    @Override
    public E remove()
    {
        if(!stackToAddTo.empty())
        {
            ArrayListStack<E> tmpArraylist = new ArrayListStack<E>(stackToAddTo);
            E obj = tmpArraylist.peek();
            tmpArraylist.pop();
            ArrayListStack<E> tmpArraylist2 = new ArrayListStack<E>(tmpArraylist);
            stackToAddTo = tmpArraylist2;
            return obj;
        }
        else
        {
            throw new NoSuchElementException();
        }
    }

    @Override
    public String toString()
    {
        ArrayListStack<E> tmpArraylist = new ArrayListStack<E>(stackToAddTo);
        return tmpArraylist.toString();
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
        if (o == this) {
            return true;
        }

        if (!(o instanceof CircularArrayQueue))
        {
            return false;
        }

        CircularArrayQueue c = (CircularArrayQueue) o;

        return c.stackToAddTo.equals(this.stackToAddTo) && (this.initialCapacity == c.initialCapacity);
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
