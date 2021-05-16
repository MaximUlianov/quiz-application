package com.ulianoff.quizapplication.util;

import java.util.Random;
import java.util.UUID;

public class RandomUtil {

    private static final String DASH = "-";

    public static String generateRandomUUIDId() {

        return UUID.randomUUID().toString();
    }

    public static String generateRandomCode() {

        Random random = new Random();

        int min = 100;
        int max = 1000;
        int diff = max - min;

        int firstPart = random.nextInt(diff + 1);
        int secondPart = random.nextInt(diff + 1);

        firstPart += min;
        secondPart += min;

        return String.join(DASH, String.valueOf(firstPart), String.valueOf(secondPart));
    }
}
