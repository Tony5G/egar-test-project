import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCounterTest {
    StringCounter stringCounter = new StringCounter();

    String[] firstCase = {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"};
    String[] secondCase = {"a", "ab", "abc", "abcd", "abcde", "abc", "ab", "a"};
    String[] thirdCase = {"abcde", "abcd", "abc", "ab", "a", "abc", "abcdef", "abcdefg"};

    @Test
    void longestConsecWithOneWordCount() {
        Assertions.assertEquals("abigail", stringCounter.longestConsec(1, firstCase));
        Assertions.assertEquals("abcde", stringCounter.longestConsec(1, secondCase));
        Assertions.assertEquals("abcdefg", stringCounter.longestConsec(1, thirdCase));
    }

    @Test
    void longestConsecWithTwoWordCount() {
        Assertions.assertEquals("abigailtheta", stringCounter.longestConsec(2, firstCase));
        Assertions.assertEquals("abcdabcde", stringCounter.longestConsec(2, secondCase));
        Assertions.assertEquals("abcdefabcdefg", stringCounter.longestConsec(2, thirdCase));
    }

    @Test
    void longestConsecWithFiveWordCount() {
        Assertions.assertEquals("zoneabigailthetaformlibe", stringCounter.longestConsec(5, firstCase));
        Assertions.assertEquals("ababcabcdabcdeabc", stringCounter.longestConsec(5, secondCase));
        Assertions.assertEquals("abaabcabcdefabcdefg", stringCounter.longestConsec(5, thirdCase));
    }
}