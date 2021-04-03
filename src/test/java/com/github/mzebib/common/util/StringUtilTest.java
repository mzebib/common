package com.github.mzebib.common.util;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author mzebib
 */
public class StringUtilTest {

    @Test
    public void testIsEmpty() {
        assertFalse(StringUtil.isEmpty("Hello World!"));

        assertTrue(StringUtil.isEmpty(""));
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void testTruncate() {
        assertEquals("Hello", StringUtil.truncate("Hello World!", 5));
    }

    @Test
    public void testValueBeforeToken() {
        assertEquals("http://localhost:8080/v1/api",
                StringUtil.valueBeforeToken(
                        "http://localhost:8080/v1/api?country=US", "?"));
    }

    @Test
    public void testValueAfterToken() {
        assertEquals("country=US",
                StringUtil.valueAfterToken(
                        "http://localhost:8080/v1/api?country=US", "?"));
    }

    @Test
    public void testPermute() {
        String[] result = StringUtil.permute("ABC");
        assertNotNull(result);
        assertEquals(6, result.length);

        Set<String> permutations = new HashSet<String>();
        permutations.add("ABC");
        permutations.add("ACB");
        permutations.add("BAC");
        permutations.add("BCA");
        permutations.add("CBA");
        permutations.add("CAB");

        for (String str : result) {
            assertTrue(permutations.contains(str));
        }
    }

    @Test
    public void testIsAnagram() {
        assertTrue(StringUtil.isAnagram("a", "a"));
        assertTrue(StringUtil.isAnagram("bob", "bob"));
        assertTrue(StringUtil.isAnagram("BoB", "bob"));
        assertTrue(StringUtil.isAnagram("BoB", "b o b"));
        assertTrue(StringUtil.isAnagram("BoB", "bbo"));
        assertTrue(StringUtil.isAnagram("word", "wrdo"));
        assertTrue(StringUtil.isAnagram("mary", "army"));
        assertTrue(StringUtil.isAnagram("stop", "tops"));
        assertTrue(StringUtil.isAnagram("boat", "btoa"));

        assertFalse(StringUtil.isAnagram("a", "b"));
        assertFalse(StringUtil.isAnagram("pure", "in"));
        assertFalse(StringUtil.isAnagram("fill", "fil"));
        assertFalse(StringUtil.isAnagram("b", "bbb"));
        assertFalse(StringUtil.isAnagram("ccc", "ccccccc"));
        assertFalse(StringUtil.isAnagram("sleep", "slep"));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtil.isPalindrome("A"));
        assertTrue(StringUtil.isPalindrome("AA"));
        assertTrue(StringUtil.isPalindrome("mom"));
        assertTrue(StringUtil.isPalindrome("Mom"));
        assertTrue(StringUtil.isPalindrome("kinnikinnik"));

        assertFalse(StringUtil.isPalindrome("Blah"));
        assertFalse(StringUtil.isPalindrome("sgsdsdgsgsgg"));
    }


}
