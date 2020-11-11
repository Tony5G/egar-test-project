import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCounter {

    public String longestConsec(int wordCount, String[] list) {
//        currentMaxIndex - текущее значение индекса конца максимальной последовательности
        int currentMaxIndex = wordCount - 1;

//        temporalMax - временная максимальная длина последовательности
        int temporalMax = (int) IntStream.iterate(0, x -> x + 1)
                .boxed()
                .limit(wordCount)
                .map(x -> list[x].length())
                .mapToDouble(x -> x)
                .sum();

//        max - максимальная длина последовательности
        int max = temporalMax;

        for (int i = wordCount; i < list.length; i++) {

//            вычитаем длину первого слова и добавляем длину нового слова
            temporalMax -= list[i - wordCount].length();
            temporalMax += list[i].length();

            if (temporalMax > max) {
                max = temporalMax;
                currentMaxIndex = i;
            }
        }

        return IntStream.iterate(currentMaxIndex - wordCount + 1, x -> x + 1)
                .boxed()
                .limit(wordCount)
                .map(a -> list[a])
                .collect(Collectors.joining());
    }
}
