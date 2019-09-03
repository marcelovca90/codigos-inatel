package io.github.marcelovca90.datacomp;

import java.util.ArrayList;
import java.util.List;

public class RunLengthEncoding implements CompressionAlgorithm
{
    @Override
    public Byte[] compress(Byte[] data)
    {
        if (data.length == 0)
            throw new IllegalArgumentException("There must be at least one byte of data");

        List<Byte> buffer = new ArrayList<>();
        byte current = data[0];
        int count = 1;

        for (int i = 1; i < data.length; i++)
        {
            if (data[i] == current)
                count++;
            else
            {
                buffer.add((byte) count);
                buffer.add(current);
                current = data[i];
                count = 1;
            }
        }
        buffer.add((byte) count);
        buffer.add(current);

        return buffer.toArray(new Byte[buffer.size()]);
    }

    @Override
    public Byte[] decompress(Byte[] data)
    {
        return null;
    }
}
