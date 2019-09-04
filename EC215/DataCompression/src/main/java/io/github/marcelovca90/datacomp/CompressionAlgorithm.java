package io.github.marcelovca90.datacomp;

public abstract class CompressionAlgorithm
{
    public abstract String compress(String data);

    public byte[] compress(byte[] data)
    {
        return compress(new String(data)).getBytes();
    }

    public abstract String decompress(String data);

    public byte[] decompress(byte[] data)
    {
        return decompress(new String(data)).getBytes();
    }
}
