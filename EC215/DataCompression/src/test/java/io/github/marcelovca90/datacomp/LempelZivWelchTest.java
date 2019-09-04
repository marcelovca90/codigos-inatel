package io.github.marcelovca90.datacomp;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.Test;

public class LempelZivWelchTest
{
    private static final String RAW_DATA = "MMaaaaarrrcceeeelooo";
    private static final String ENCODED_DATA = "256!258!257!259!260!261!262!263!264!111!";

    private final LempelZivWelch lzw = new LempelZivWelch();

    @Test(expected = IllegalArgumentException.class)
    public void compressString_withInvalidData_shouldThrowException()
    {
        // given
        String input = new String(new char[0]);

        // when
        lzw.compress(input);
    }

    @Test
    public void compressString_withValidData_shouldCompress()
    {
        // given
        String input = RAW_DATA;
        String expected = ENCODED_DATA;

        // when
        String output = lzw.compress(input);

        // then
        assertEquals(expected, output);
    }

    @Test
    public void compressByteArray_withValidData_shouldCompress()
    {
        // given
        byte[] input = RAW_DATA.getBytes();
        byte[] expected = ENCODED_DATA.getBytes();

        // when
        byte[] output = lzw.compress(input);

        // then
        assertArrayEquals(expected, output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decompressString_withInvalidData_shouldThrowException()
    {
        // given
        String input = new String(new char[0]);

        // when
        lzw.decompress(input);
    }

    @Test(expected = NotImplementedException.class)
    public void decompressString_withValidData_shouldDecompress()
    {
        // given
        String input = ENCODED_DATA;
        String expected = RAW_DATA;

        // when
        String output = lzw.decompress(input);

        // then
        // assertEquals(expected, output);
    }

    @Test(expected = NotImplementedException.class)
    public void decompressByteArray_withValidData_shouldDecompress()
    {
        // given
        byte[] input = ENCODED_DATA.getBytes();
        byte[] expected = RAW_DATA.getBytes();

        // when
        byte[] output = lzw.decompress(input);

        // then
        // assertArrayEquals(expected, output);
    }
}
