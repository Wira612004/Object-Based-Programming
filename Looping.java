//Wira Harsa - TI22I

class Main {
    public static void main(String[] args) {
        sequence1();
        sequence2();
        sequence3();
        sequence4();
        sequence5();
    }

    static void sequence1() {
        System.out.println("Sequence 1:");
        for (int i = 0; i <= 8; i += 2) {
            System.out.print(i);
            if (i < 8) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

    static void sequence2() {
        System.out.println("Sequence 2:");
        for (int i = 1; i <= 9; i += 2) {
            System.out.print(i);
            if (i < 9) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

    static void sequence3() {
        System.out.println("Sequence 3:");
        int[] sequence = {1, 2, 4, 7, 11, 16, 22};
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i]);
            if (i < sequence.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

    static void sequence4() {
        System.out.println("Sequence 4:");
        int[] sequence = {-3, -1, 2, 6, 11, 17, 24};
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i]);
            if (i < sequence.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n");
    }

    static void sequence5() {
        System.out.println("Sequence 5:");
        fibonacci(8);
        System.out.println("\n");
    }

    static void fibonacci(int n) {
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a);
            int sum = a + b;
            a = b;
            b = sum;
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
    }
}
