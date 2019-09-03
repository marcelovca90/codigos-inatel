package io.github.marcelovca90.datacomp;

public interface CompressionAlgorithm
{
    public Byte[] compress(Byte[] data);

    public Byte[] decompress(Byte[] data);
}
