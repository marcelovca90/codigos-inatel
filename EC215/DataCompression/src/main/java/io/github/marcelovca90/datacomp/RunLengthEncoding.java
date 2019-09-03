package io.github.marcelovca90.datacomp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class RunLengthEncoding implements CompressionAlgorithm
{
    @Override
    public byte[] compress(byte[] data) throws IOException
    {
        if (data.length == 0)
        {
            throw new IllegalArgumentException("There must be at least one byte of data.");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        long currentAmount = 1L;
        byte currentData = data[0];

        for (int i = 1; i < data.length; i++)
        {
            if (data[i] == currentData)
            {
                currentAmount++;
            }
            else
            {
                baos.write(ByteUtils.longToBytes(currentAmount));
                baos.write(currentData);
                currentData = data[i];
                currentAmount = 1;
            }
        }
        baos.write(ByteUtils.longToBytes(currentAmount));
        baos.write(currentData);

        return baos.toByteArray();
    }

    @Override
    public byte[] decompress(byte[] data) throws IOException
    {
        if (data.length == 0)
        {
            throw new IllegalArgumentException("There must be at least one byte of data.");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        for (int i = 0; i < data.length;)
        {
            // reads the current count (8 bytes)
            ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
            for (int j = 0; j < Long.BYTES; i++, j++)
                buffer.put(data[i]);
            // parses the current count
            long currentAmount = ByteUtils.bytesToLong(buffer.array());
            // retrieves the current data
            byte currentData = data[i++];
            // writes the current data to output stream
            for (int j = 0; j < currentAmount; j++)
                baos.write(currentData);
        }

        return baos.toByteArray();
    }
}
