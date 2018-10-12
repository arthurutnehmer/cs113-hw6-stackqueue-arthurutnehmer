package edu.miracosta.cs113;

public class Test
{
    public static void main(String[]args)
    {
        ArrayListStack<String> QueOfLetters = new ArrayListStack<>(0);
        ArrayListStack<String> QueOfLetters2 = new ArrayListStack<>(0);
        ArrayListStack<String> QueOfLetters3;
        QueOfLetters.push("m");
        QueOfLetters.push("a");
        QueOfLetters.push("d");
        QueOfLetters.push("a");
        QueOfLetters.push("m");

        QueOfLetters3 = new ArrayListStack<>();

        QueOfLetters2.push(QueOfLetters.pop());
        QueOfLetters2.push(QueOfLetters.pop());
        QueOfLetters2.push(QueOfLetters.pop());


        System.out.println(QueOfLetters);

        System.out.println(QueOfLetters2);



    }

}
