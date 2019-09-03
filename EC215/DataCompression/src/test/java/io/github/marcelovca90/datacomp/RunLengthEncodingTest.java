package io.github.marcelovca90.datacomp;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class RunLengthEncodingTest
{
    private RunLengthEncoding rle = new RunLengthEncoding();

    @Test(expected = IllegalArgumentException.class)
    public void compress_withInvalidData_shouldThrowException() throws IOException
    {
        // given
        String input = new String(new char[0]);

        // when
        rle.compress(input);
    }

    @Test
    public void compress_withValidData_shouldCompress() throws IOException
    {
        // given
        String input = "MMaaaaarrrcceeeelooo";
        String expecteds = "2\0M5\0a3\0r2\0c4\0e1\0l3\0o";

        // when
        String output = rle.compress(input);

        // then
        assertEquals(expecteds, output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decompress_withInvalidData_shouldThrowException() throws IOException
    {
        // given
        String input = new String(new char[0]);

        // when
        rle.decompress(input);
    }

    @Test
    public void decompress_withValidData_shouldDecompress() throws IOException
    {
        // given
        String input = "2\0M5\0a3\0r2\0c4\0e1\0l3\0o";
        String expecteds = "MMaaaaarrrcceeeelooo";

        // when
        String output = rle.decompress(input);

        // then
        assertEquals(expecteds, output);
    }
}
