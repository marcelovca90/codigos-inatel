package io.github.marcelovca90.datacomp;

import java.io.IOException;

public interface CompressionAlgorithm
{
    public byte[] compress(byte[] data) throws IOException;

    public byte[] decompress(byte[] data) throws IOException;
}
