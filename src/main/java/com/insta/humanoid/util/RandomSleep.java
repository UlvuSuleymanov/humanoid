package com.insta.humanoid.util;

import java.util.Random;

public class RandomSleep {
    public static Random random = new Random();

    public static void start(int min,int max) throws InterruptedException {

        Thread.sleep(random.nextInt(min,max));
    }


}
