package io.github.marcelovca90.datacomp;

import static io.github.marcelovca90.datacomp.ByteUtils.longToBytes;
import static org.junit.Assert.assertArrayEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;

public class RunLengthEncodingTest
{
    private RunLengthEncoding runLengthEncoding;

    @Test(expected = IllegalArgumentException.class)
    public void compress_withInvalidData_shouldThrowException() throws IOException
    {
        // given
        byte[] input = new byte[0];

        // when
        runLengthEncoding.compress(input);
    }

    @Test
    public void compress_withValidData_shouldCompress() throws IOException
    {
        // given
        byte[] input = "Maaaaarrrceelooo".getBytes();
        byte[] expecteds = buildCompressedByteArray();

        // when
        byte[] output = runLengthEncoding.compress(input);

        // then
        assertArrayEquals(expecteds, output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decompress_withInvalidData_shouldThrowException() throws IOException
    {
        // given
        byte[] input = new byte[0];

        // when
        runLengthEncoding.decompress(input);
    }

    @Test
    public void decompress_withValidData_shouldDecompress() throws IOException
    {
        // given
        byte[] input = buildCompressedByteArray();
        byte[] expecteds = "Maaaaarrrceelooo".getBytes();

        // when
        byte[] output = runLengthEncoding.decompress(input);

        // then
        assertArrayEquals(expecteds, output);
    }

    private byte[] buildCompressedByteArray() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(longToBytes(1L));
        baos.write('M');
        baos.write(longToBytes(5L));
        baos.write('a');
        baos.write(longToBytes(3L));
        baos.write('r');
        baos.write(longToBytes(1L));
        baos.write('c');
        baos.write(longToBytes(2L));
        baos.write('e');
        baos.write(longToBytes(1L));
        baos.write('l');
        baos.write(longToBytes(3L));
        baos.write('o');
        return baos.toByteArray();
    }
}
