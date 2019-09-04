package io.github.marcelovca90.datacomp;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.NotImplementedException;

public class LempelZivWelch extends CompressionAlgorithm
{
    @Override
    public String compress(String data)
    {
        if (data.isEmpty())
        {
            throw new IllegalArgumentException("There must be at least one byte of data.");
        }

        Map<String, Integer> dict = buildDictionary(data);
        StringBuilder builder = new StringBuilder();

        // iterate the whole data string
        int start = 0, end = 1;
        String word;

        while (end < data.length())
        {
            // to find the substrings that are present in the dictionary
            do
            {
                word = data.substring(start, end);
                end++;
            } while (dict.containsKey(word));

            // add the symbol of the current data to the buffer
            word = word.substring(0, word.length() - 1);
            builder.append(dict.get(word));
            builder.append("!");

            // shift the start and end of the new candidate word
            start = end - 2;
            end = start + 1;
        }

        // add the symbol of the remaining data to the buffer
        word = data.substring(start);
        builder.append(dict.get(word));
        builder.append("!");

        return builder.toString();
    }

    @Override
    public String decompress(String data)
    {
        if (data.isEmpty())
        {
            throw new IllegalArgumentException("There must be at least one byte of data.");
        }
        else
        {
            throw new NotImplementedException("Not implemented yet.");
        }
    }

    private Map<String, Integer> buildDictionary(String data)
    {
        Map<String, Integer> dict = new LinkedHashMap<>();

        // initialize dictionary with default ASCII symbols
        int value;
        for (value = 0; value <= 255; value++)
            dict.put(String.valueOf((char) value), value);

        // iterate the whole data string
        int start = 0, end = 0;
        while (end < data.length())
        {
            // to find the substrings that are present in the dictionary
            String word;
            do
            {
                word = data.substring(start, ++end);
            } while (dict.containsKey(word));

            // put the new word (and its value) into the dictionary
            dict.put(word, value++);

            // shift the start and end of the new candidate word
            start = end++;
        }

        return dict;
    }
}
