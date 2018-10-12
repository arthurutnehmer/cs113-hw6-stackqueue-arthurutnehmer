package edu.miracosta.cs113;


import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayListStack<E> implements StackInterface<E>
{
    private ArrayList<E> stackArray;

    /***************************************************************
     * A copy constructor that reverses order.
     ***************************************************************/
    ArrayListStack(ArrayListStack<E> stackToCopy)
    {
        stackArray = new ArrayList<E>();
        int c = 0;
        for(int i = stackToCopy.stackArray.size()-1; i>= 0; i--)
        {
            stackArray.add(stackToCopy.stackArray.get(i) );
        }

    }
    /***************************************************************
     * Default constructor.
     ***************************************************************/
    ArrayListStack()
    {
        stackArray = new ArrayList<E>();
    }
    /***************************************************************
     * Int constructor.
     ***************************************************************/
    ArrayListStack(int initialCapacity)
    {
        stackArray = new ArrayList<E>(initialCapacity);
    }

    /**
     * Returns true if the stack is empty; otherwise, returns false
     *
     * @return true if empty, false otherwise
     */
    @Override
    public boolean empty()
    {
        return stackArray.isEmpty();
    }

    /**
     * Returns the object at the top of the stack without removing it
     *
     * @return reference (shallow copy) of object at top of stack
     */
    @Override
    public E peek()
    {
        if(!stackArray.isEmpty())
        {
            return stackArray.get(0);
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
        if(this.stackArray.size() == 0)
        {
            throw new EmptyStackException();
        }
        else
        {
            E e = stackArray.get(0);
            stackArray.remove(0);
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
        stackArray.add(0,obj);
        return obj;
    }

    @Override
    public String toString()
    {
        String toReturn = "[ ";
        for(int i = stackArray.size()-1; i >= 0; i--)
        {
            toReturn += stackArray.get(i) + " ";
        }
        toReturn += "]";
        return toReturn;
    }
    /***************************************************************
     * Test arrays for equality.
     * @return True if the same or false if different.
     ***************************************************************/
    @Override
    public boolean equals(Object o)
    {
        if (o == this) {
            return true;
        }

        if (!(o instanceof ArrayListStack))
        {
            return false;
        }
        ArrayListStack c = (ArrayListStack) o;

        if(stackArray.size() != (((ArrayListStack) o).stackArray.size()))
        {
            return false;
        }
        boolean isEqual = true;
        for(int i = 0; i < stackArray.size(); i++)
        {
            if(!stackArray.get(0).equals(((ArrayListStack) o).stackArray.get(0)))
            {
                isEqual = false;
            }
        }

        return isEqual;
    }
}
