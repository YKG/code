package com.tradeshift.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class KMPTest {
    @Test
    public void indexOf__should_return_the_index_when_matching_succeed() {
        byte[] in = "012345".getBytes();
        byte[] pattern = "34".getBytes();
        assertEquals(KMP.indexOf(in, pattern), 3);
    }

    @Test
    public void indexOf__should_return_negative_one_when_matching_failed() {
        byte[] in = "012345".getBytes();
        byte[] pattern = "89".getBytes();
        assertEquals(KMP.indexOf(in, pattern), -1);
    }

    @Test
    public void indexOf__should_return_negative_one_when_pattern_is_empty() {
        byte[] in = "012345".getBytes();
        byte[] pattern = "".getBytes();
        assertEquals(KMP.indexOf(in, pattern), -1);
    }

    @Test
    public void indexOf__should_return_negative_one_when_input_data_is_empty() {
        byte[] in = "".getBytes();
        byte[] pattern = "1".getBytes();
        assertEquals(KMP.indexOf(in, pattern), -1);
    }

    @Test
    public void replace__should_return_a_new_array_with_replacement_when_matching_succeed() {
        byte[] in = "012345".getBytes();
        byte[] pattern = "34".getBytes();
        byte[] replacement = "xyz".getBytes();
        byte[] out = "012xyz5".getBytes();
        assertTrue(Arrays.equals(KMP.replace(in, pattern, replacement), out));
    }

    @Test
    public void replace__should_return_the_same_array_as_input_data_when_matching_failed() {
        byte[] in = "012345".getBytes();
        byte[] pattern = "89".getBytes();
        byte[] replacement = "xyz".getBytes();
        assertTrue(Arrays.equals(KMP.replace(in, pattern, replacement), in));
    }

    @Test
    public void replace__should_return_the_same_array_as_input_data_when_pattern_is_empty() {
        byte[] in = "012345".getBytes();
        byte[] pattern = "".getBytes();
        byte[] replacement = "xyz".getBytes();
        assertTrue(Arrays.equals(KMP.replace(in, pattern, replacement), in));
    }
}
