package br.inatel.c210.ga.runnable;

import java.util.BitSet;

import br.inatel.c210.ga.entity.Chromossome;
import br.inatel.c210.ga.entity.Problem;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(Problem.g(4, 3));
        System.out.println(Problem.g(2, 9));
        System.out.println(Problem.g(9, 11));
        System.out.println(Problem.g(0, 15));
        System.out.println(Problem.g(5, 5));
        System.out.println(Problem.g(14, 3));

        BitSet bits = new BitSet(8);

        System.out.println(bits.get(0));
        bits.set(0);
        System.out.println(bits.get(0));
        bits.flip(0);
        System.out.println(bits.get(0));
        bits.flip(0);
        System.out.println(bits.get(0));
        bits.clear(0);
        System.out.println(bits.get(0));

        System.out.println(toBinaryString(14));

        Chromossome c = new Chromossome(5, 11);
        System.out.println(c);
    }

    private static String toBinaryString(int x)
    {
        return String.format("%4s", Integer.toBinaryString(x & 0xFF)).replace(' ', '0');
    }

}
