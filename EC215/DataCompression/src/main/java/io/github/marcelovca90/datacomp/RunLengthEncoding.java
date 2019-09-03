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
            // if the data repeats, increment the counter
            if (data[i] == currentData)
            {
                currentAmount++;
            }
            // otherwise, write the data count (8 bytes) and the data itself
            // to the output stream then resets the current data and counter
            else
            {
                baos.write(ByteUtils.longToBytes(currentAmount));
                baos.write(currentData);
                currentAmount = 1L;
                currentData = data[i];
            }
        }
        // write the last data (and its count) to the output stream
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
