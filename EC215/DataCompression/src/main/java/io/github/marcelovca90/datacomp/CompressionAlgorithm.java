package io.github.marcelovca90.datacomp;

public interface CompressionAlgorithm
{
    public String compress(String data);

    public String decompress(String data);
}
