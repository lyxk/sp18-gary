import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String a = "racecar";
        String b = "rancor";
        String c = "aaaaab";
        String corner_a = "a";
        String corner_b = "";

        assertTrue(palindrome.isPalindrome(a));
        assertFalse(palindrome.isPalindrome(b));
        assertFalse(palindrome.isPalindrome(c));
        assertTrue(palindrome.isPalindrome(corner_a));
        assertTrue(palindrome.isPalindrome(corner_b));

        // Test overloaded version of isPalindrome
        CharacterComparator offByOne = new OffByOne();
        a = "flake";
        b = "%&";
        c = "racecar";
        corner_a = "a";
        corner_b = "";
        String d = "ekalf";

        assertTrue(palindrome.isPalindrome(a, offByOne));
        assertTrue(palindrome.isPalindrome(b, offByOne));
        assertFalse(palindrome.isPalindrome(c, offByOne));
        assertTrue(palindrome.isPalindrome(d, offByOne));
        assertTrue(palindrome.isPalindrome(corner_a, offByOne));
        assertTrue(palindrome.isPalindrome(corner_b, offByOne));
    }
}
