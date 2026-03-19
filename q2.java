public class q2 {
    public static void main(String[] args) {
        ShapeDrawer2 sd = new ShapeDrawer2(5, '#', 'X');

        sd.drawSquare();
        System.out.println();
        sd.drawSpecialSquare();
        System.out.println();
        sd.DrawStairCase();
    }
}

interface SquareDrawer {
    public void drawSquare();

    public void drawSpecialSquare();

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

class ShapeDrawer1 extends Drawer implements SquareDrawer {
    ShapeDrawer1(int len, char fil, char spec) {
        super(len, fil, spec);
    }

    public void drawSquare() {

        for (int i = 0; i < sideLength; i++) {
            String row = "";
            String fill = String.valueOf(filler);

            for (int j = 0; j < sideLength; j++) {

                row = row.concat(fill);
            }

            System.out.println(row);
        }
    }

    public void drawSpecialSquare() {
        int diagPos = 0;

        String fill = String.valueOf(filler);
        String spec = String.valueOf(special);

        for (int rowln = 0; rowln < sideLength; rowln++) {
            String rowPrnt = "";
            for (int col = 0; col < sideLength; col++) {
                if (col == diagPos || col == sideLength - diagPos - 1) {
                    rowPrnt = rowPrnt.concat(spec);
                } else {
                    rowPrnt = rowPrnt.concat(fill);
                }
            }
            diagPos++;
            System.out.println(rowPrnt);
        }

    }

}
