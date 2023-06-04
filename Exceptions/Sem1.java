package Exceptions;

import java.util.Arrays;

public class Sem1 {
    public static void main(String[] args) {
        int[] a = {2, 3, 4};
        int[] b = {1, 2, 3, 2};
        int[] c = arraysDiff(a, b);
        System.out.println(Arrays.toString(c));
    }

    public static void printArr() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[4]);
    }

    public static Integer nullInt() {
        Integer n = null;
        return n.intValue();
    }

    public static int divide() {
        return 1 / 0;
    }

    public static int[] arraysDiff(int[] a, int[] b) {
        if (a.length != b.length) {
            System.out.println("Lengths aren't equal each other");
        } else {
            int[] c = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] - b[i];
            }
            return c;
        }
        return null;
    }
    public static int[] arraysDivide(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new RuntimeException("Lengths aren't equal each other");
        } else {
            int[] c = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] / b[i];
            }
            return c;
        }
    }
}

