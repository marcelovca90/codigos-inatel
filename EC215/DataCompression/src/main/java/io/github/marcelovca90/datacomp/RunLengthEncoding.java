package io.github.marcelovca90.datacomp;

public class RunLengthEncoding extends CompressionAlgorithm
{
    protected static final char SEPARATOR = '\0';

    @Override
    public String compress(String data)
    {
        if (data.isEmpty())
        {
            throw new IllegalArgumentException("There must be at least one byte of data.");
        }

        StringBuilder buffer = new StringBuilder();
        long currentAmount = 1L;
        char currentData = data.charAt(0);

        for (int i = 1; i < data.length(); i++)
        {
            if (data.charAt(i) == currentData)
            {
                currentAmount++;
            }
            else
            {
                buffer.append(currentAmount);
                buffer.append(SEPARATOR);
                buffer.append(currentData);
                currentAmount = 1L;
                currentData = data.charAt(i);
            }
        }
        buffer.append(currentAmount);
        buffer.append(SEPARATOR);
        buffer.append(currentData);

        return buffer.toString();
    }

    @Override
    public String decompress(String data)
    {
        if (data.isEmpty())
        {
            throw new IllegalArgumentException("There must be at least one byte of data.");
        }

        StringBuilder amountBuffer = new StringBuilder();
        StringBuilder outputBuffer = new StringBuilder();

        int pos = 0;
        while (pos < data.length())
        {
            long currentAmount = 1L;
            char currentData = data.charAt(pos);
            if (currentData != SEPARATOR)
            {
                amountBuffer.append(currentData);
            }
            else
            {
                currentAmount = Long.valueOf(amountBuffer.toString());
                currentData = data.charAt(++pos);
                for (int i = 0; i < currentAmount; i++)
                {
                    outputBuffer.append(currentData);
                }
                amountBuffer = new StringBuilder();
            }
            pos++;
        }

        return outputBuffer.toString();
    }
}
