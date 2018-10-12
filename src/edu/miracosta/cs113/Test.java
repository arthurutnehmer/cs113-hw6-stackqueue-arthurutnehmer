package edu.miracosta.cs113;

public class Test
{
    public static void main(String[]args)
    {
        CircularArrayQueue<String> QueOfLetters = new CircularArrayQueue<String>(0);


        CircularArrayQueue<String> QueOfLetters2 = new CircularArrayQueue<String>();


        System.out.println(QueOfLetters.equals(QueOfLetters2));


    }

}
