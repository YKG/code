package com.tradeshift.util;

/**
 * Knuth-Morris-Pratt Algorithm for Pattern Matching & Replacement
 */
public class KMP {
    public static byte[] replace(byte[] in, byte[] pattern, byte[] replacement) {
        int i = indexOf(in, pattern);
        if (i == -1) {
            return in;
        }

        byte[] out = new byte[in.length - pattern.length + replacement.length];
        System.arraycopy(in, 0, out, 0, i);
        System.arraycopy(replacement, 0, out, i, replacement.length);
        System.arraycopy(in, i + pattern.length, out, i + replacement.length, in.length - i - pattern.length);
        return out;
    }

    /**
     * Finds the first occurrence of the pattern in the text.
     */
    public static int indexOf(byte[] data, byte[] pattern) {
        int[] failure = computeFailure(pattern);

        int j = 0;
        if (data.length == 0 || pattern.length == 0) {
            return -1;
        }

        for (int i = 0; i < data.length; i++) {
            while (j > 0 && pattern[j] != data[i]) {
                j = failure[j - 1];
            }
            if (pattern[j] == data[i]) {
                j++;
            }
            if (j == pattern.length) {
                return i - pattern.length + 1;
            }
        }
        return -1;
    }

    /**
     * Computes the failure function using a boot-strapping process,
     * where the pattern is matched against itself.
     */
    private static int[] computeFailure(byte[] pattern) {
        int[] failure = new int[pattern.length];

        int j = 0;
        for (int i = 1; i < pattern.length; i++) {
            while (j > 0 && pattern[j] != pattern[i]) {
                j = failure[j - 1];
            }
            if (pattern[j] == pattern[i]) {
                j++;
            }
            failure[i] = j;
        }

        return failure;
    }
}
