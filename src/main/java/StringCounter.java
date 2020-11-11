import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCounter {

    public String longestConsec(int wordCount, String[] list) {
//        max - максимальное значение последовательности строк
        int max = 0;

//        currentMaxIndexes - текущее значение индексов максимальной последовательности
        int[] currentMaxIndexes = new int[wordCount];

        for (int i = wordCount - 1; i < list.length; i++) {

//            temporalMax - текущее максимальное значение последовательности строк
            int temporalMax = 0;

            for (int j = i - (wordCount - 1); j < i; j++) {
                temporalMax += list[j].length();
            }

            temporalMax += list[i].length();

            if (temporalMax > max) {
                max = temporalMax;

//                offset - переменная для сдвига
                int offset = wordCount - 1;

                for (int k = 0; k < wordCount; k++) {
                    currentMaxIndexes[k] = i - offset;
                    offset -= 1;
                }
            }
        }

        return Arrays.stream(currentMaxIndexes)
                .boxed()
                .map(x -> list[x])
                .collect(Collectors.joining());
    }
}
