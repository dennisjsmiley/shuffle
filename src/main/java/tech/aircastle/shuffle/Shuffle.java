package tech.aircastle.shuffle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffle {

    private static final Logger logger = LoggerFactory.getLogger(Shuffle.class);

    public static <T> void shuffle(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int j = ThreadLocalRandom.current().nextInt(i + 1, list.size());
            list.set(i, list.set(j, list.get(i)));
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        logger.info("list: {}", list);
        shuffle(list);
        logger.info("list (shuffled): {}", list);
    }
}
