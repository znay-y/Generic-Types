public class q1 {
    public static void main(String[] args) {
        Drawer d = new Drawer(5, '#', 'X');
        System.out.println(d.sideLength + " " + d.filler + " " + d.special);
    }
}

interface SquareDrawer {
    public static void drawSquare() {
    }

    public static void drawSpecialSquare() {
    }

}

interface StairCaseDrawer {
    public static void DrawStairCase() {

    }
}

class Drawer {
    int sideLength;
    char filler;
    char special;

    Drawer(int len, char fil, char spec) {
        this.sideLength = len;
        this.filler = fil;
        this.special = spec;
    }
}
