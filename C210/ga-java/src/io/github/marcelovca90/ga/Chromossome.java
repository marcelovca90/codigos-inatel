package io.github.marcelovca90.ga;

import java.util.Arrays;
import java.util.BitSet;

public class Chromossome
{
    private BitSet genes;

    public Chromossome(int x, int y)
    {
        this.genes = encode(x, y);
    }

    public BitSet getGenes()
    {
        return genes;
    }

    public static Chromossome[] fromParents(int point, Chromossome parent1, Chromossome parent2)
    {
        BitSet child1 = new BitSet(8);
        BitSet child2 = new BitSet(8);

        for (int i = 0; i < point; i++)
        {
            child1.set(i, parent1.getGeneAt(i));
            child2.set(i, parent2.getGeneAt(i));
        }

        for (int i = point; i < 8; i++)
        {
            child1.set(i, parent2.getGeneAt(i));
            child2.set(i, parent1.getGeneAt(i));
        }

        Integer[] child1_xy = decode(child1);
        Integer[] child2_xy = decode(child2);

        return new Chromossome[] {
                new Chromossome(child1_xy[0], child1_xy[1]),
                new Chromossome(child2_xy[0], child2_xy[1]) };
    }

    public static BitSet encode(int x, int y)
    {
        BitSet bits = new BitSet(8);
        String xyBinary = toBinaryString(x) + toBinaryString(y);
        for (int i = 0; i < 8; i++)
            bits.set(i, xyBinary.charAt(i) == '1');
        return bits;
    }

    public static Integer[] decode(BitSet bits)
    {
        // XXXX YYYY
        // 0123 4567
        // 8421 8421

        Integer x = 8 * (bits.get(0) ? 1 : 0) +
                4 * (bits.get(1) ? 1 : 0) +
                2 * (bits.get(2) ? 1 : 0) +
                1 * (bits.get(3) ? 1 : 0);

        Integer y = 8 * (bits.get(4) ? 1 : 0) +
                4 * (bits.get(5) ? 1 : 0) +
                2 * (bits.get(6) ? 1 : 0) +
                1 * (bits.get(7) ? 1 : 0);

        return new Integer[] { x, y };
    }

    public Chromossome flipGeneAt(int i)
    {
        this.genes.flip(i);
        return this;
    }

    public boolean getGeneAt(int i)
    {
        return this.genes.get(i);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++)
        {
            if (i == 4)
                sb.append(' ');
            sb.append(genes.get(i) ? '1' : '0');
        }

        sb.append(' ' + Arrays.toString(decode(this.genes)));

        return sb.toString();
    }

    private static String toBinaryString(int x)
    {
        return String.format("%4s", Integer.toBinaryString(x & 0xFF)).replace(' ', '0');
    }
}
