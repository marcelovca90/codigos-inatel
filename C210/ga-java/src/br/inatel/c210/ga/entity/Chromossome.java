package br.inatel.c210.ga.entity;

import static br.inatel.c210.ga.algorithm.GeneticUtils.RANDOM;

import java.util.Arrays;
import java.util.BitSet;

public class Chromossome
{
    private BitSet genes;

    public Chromossome()
    {
        int x = RANDOM.nextInt(16);
        int y = RANDOM.nextInt(16);
        this.genes = getGenotype(x, y);
    }

    public Chromossome(int x, int y)
    {
        this.genes = getGenotype(x, y);
    }

    public BitSet getGenes()
    {
        return this.genes;
    }

    public void setGenes(BitSet genes)
    {
        this.genes = genes;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("G = [");
        for (int i = 0; i < 8; i++)
        {
            if (i == 4)
                sb.append(' ');
            sb.append(genes.get(i) ? '1' : '0');
        }

        sb.append("], F = " + Arrays.toString(getFenotype(this.genes)));

        return sb.toString();
    }

    public static BitSet getGenotype(int x, int y)
    {
        BitSet bits = new BitSet(8);
        String xyBinary = toBinaryString(x) + toBinaryString(y);
        for (int i = 0; i < 8; i++)
            bits.set(i, xyBinary.charAt(i) == '1');
        return bits;
    }

    public static Integer[] getFenotype(BitSet genes)
    {
        // XXXX YYYY (4 bits to each variable)
        // 0123 4567 (bits are indexed from left to right)
        // 8421 8421 (adopting a little-endian representation)

        Integer x = 8 * (genes.get(0) ? 1 : 0) +
                4 * (genes.get(1) ? 1 : 0) +
                2 * (genes.get(2) ? 1 : 0) +
                1 * (genes.get(3) ? 1 : 0);

        Integer y = 8 * (genes.get(4) ? 1 : 0) +
                4 * (genes.get(5) ? 1 : 0) +
                2 * (genes.get(6) ? 1 : 0) +
                1 * (genes.get(7) ? 1 : 0);

        return new Integer[] { x, y };
    }

    private static String toBinaryString(int x)
    {
        return String.format("%4s", Integer.toBinaryString(x & 0xFF)).replace(' ', '0');
    }
}
