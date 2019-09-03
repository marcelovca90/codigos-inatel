package io.github.marcelovca90.datacomp;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.when;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RunLengthEncodingTest
{
    @Spy
    private RunLengthEncoding RLE;

    @Test(expected = IllegalArgumentException.class)
    public void compress_withInvalidData_shouldThrowException()
    {
        // given
        Byte[] input = new Byte[0];

        // when
        RLE.compress(input);
    }

    @Test
    public void compress_withValidData_shouldCompress()
    {
        // given
        Byte[] input = ArrayUtils.toObject("Maaaaarrrceelooo".getBytes());

        // when
        Byte[] output = RLE.compress(input);

        // then
        Byte[] expecteds = new Byte[] { 1, 77, 5, 97, 3, 114, 1, 99, 2, 101, 1, 108, 3, 111 };
        assertArrayEquals(expecteds, output);
    }

    @Test
    public void decompress_withMockedData_shouldPass()
    {
        // given
        Byte[] input = new Byte[] { 1, 77, 5, 97, 3, 114, 1, 99, 2, 101, 1, 108, 3, 111 };
        Byte[] expecteds = ArrayUtils.toObject("Maaaaarrrceelooo".getBytes());
        when(RLE.decompress(input)).thenReturn(expecteds);

        // when
        Byte[] output = RLE.decompress(input);

        // then
        assertArrayEquals(expecteds, output);
    }
}
