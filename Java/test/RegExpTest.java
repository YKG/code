package com.tradeshift.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class RegExpTest {
    @Test
    public void indexOf__should_return_the_index_when_matching_succeed() {
        String filename = extractDocumentFileName();
        String r = "^attachment\\[" + filename + "].+";
        boolean result = filename.match(r);
        assertFalse(result);
    }

    private String extractDocumentFileName() {
        //      x y z10 !@#$%<>{}[]+&^*§`\'"/test.pdf
        //      x y z10 !@#$%<>{}[]+&^*§`\ '" /test.pdf
        return "x y z10 !@#$%<>{}[]+&^*§`\\'\"/test.pdf";
    }
}
