package edu.miracosta.cs113;

public class Test
{
    public static void main(String[]args)
    {
        CircularArrayQueue<String> test = new CircularArrayQueue<String>(8);
        test.offer("Hello");
        test.offer("1");
        test.offer("2");
        test.remove();
       






        System.out.println(test.peek());
    }

}
