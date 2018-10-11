package edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class CircularArrayQueue<E> implements Queue<E>
{
    /***************************************************************
     * Default constructor.
     ***************************************************************/
    CircularArrayQueue(int initialCapacityToSet)
    {

    }

    /***************************************************************
     * Inserts the specified element into this queue if it is
     * possible to do so immediately without violating capacity
     * restrictions, returning true upon success and throwing an
     * IllegalStateException if no space is currently available.
     ***************************************************************/
    @Override
    public boolean add(E e)
    {
        return false;
    }

    /***************************************************************
     * Retrieves, but does not remove, the head of this queue.
     ***************************************************************/
    @Override
    public E element()
    {
        return null;
    }
    /***************************************************************
     * Inserts the specified element into this queue if it is
     * possible to do so immediately without violating capacity
     * restrictions.
     ***************************************************************/
    @Override
    public boolean offer(E e)
    {
        return false;
    }

    /***************************************************************
     * Retrieves, but does not remove, the head of this queue,
     * or returns null if this queue is empty.
     ***************************************************************/
    @Override
    public E peek()
    {
        return null;
    }
    /***************************************************************
     * Retrieves and removes the head of this queue, or returns
     * null if this queue is empty.
     ***************************************************************/
    @Override
    public E poll()
    {
        return null;
    }
    /***************************************************************
     * Retrieves and removes the head of this queue.
     ***************************************************************/
    @Override
    public E remove()
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
    public boolean equals(Object obj) {
        return super.equals(obj);
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
