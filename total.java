public class total {

    public static void main(String[] args) {
        int total = 0;
        for (int i = 0; i < 500; i++) {
            total = total + i;
        }

        System.out.println("The total is " + total);
    }
}