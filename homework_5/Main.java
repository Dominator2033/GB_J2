package homework_5;

import java.util.Arrays;

public class Main {
    static final int SIZE = 1000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        methodOne(createArray());
        methodTwo(createArray());
    }

    // Create array for methods
    public static float[] createArray() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        return arr;
    }

    // First method
    public static void methodOne(float[] arr) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("The total time for one array is " + (System.currentTimeMillis() - a));
    }

    // Second method
    public static void methodTwo(float[] arr) {
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        Thread calcOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        calcOne.start();

        Thread calcTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        calcTwo.start();

        try {
            calcOne.join();
            calcTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2,0, arr, HALF, HALF);

        System.out.println("The total time for two array is " + (System.currentTimeMillis() - a));
    }
}
