public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        boolean condition, value;
        for (int j = 0; i < 500; ++i, ++j) {
            value = Flik.isSameNumber(i, j);
            condition = Flik.isSameNumber(i, j);
            condition = !condition;
            if (condition) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}
