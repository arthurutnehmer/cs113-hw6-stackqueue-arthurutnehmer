package edu.miracosta.cs113;


import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayListStack<E> implements StackInterface<E>
{
    ArrayList<E> stack;

    /***************************************************************
     * Default constructor.
     ***************************************************************/
    ArrayListStack()
    {
        stack = new ArrayList<E>();
    }
    /***************************************************************
     * Int constructor.
     ***************************************************************/
    ArrayListStack(int initialCapacity)
    {
        stack = new ArrayList<>(initialCapacity);
    }

    /**
     * Returns true if the stack is empty; otherwise, returns false
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean empty()
    {
        return stack.isEmpty();
    }

    /**
     * Returns the object at the top of the stack without removing it
     *
     * @return reference (shallow copy) of object at top of stack
     */
    @Override
    public E peek()
    {
        if(stack.size() != 0)
        {
            return stack.get(0);
        }
        else
        {
            throw new EmptyStackException();
        }
    }

    /**
     * Returns the object at the top of the stack and removes it
     *
     * @return reference of removed object from top of stack
     */
    @Override
    public E pop()
    {
        if(stack.size() == 0)
        {
            throw new EmptyStackException();
        }
        else
        {
            E e = stack.get(0);
            stack.remove(0);
            return e;
        }
    }

    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj object to push onto top of stack
     * @return item that was pushed
     */
    @Override
    public E push(E obj)
    {
        stack.add(0,obj);
        return stack.get(0);
    }
}
