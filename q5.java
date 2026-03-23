import java.util.Arrays;

class Tools {
    // Appends t to the (end of) array ts.
    // If array ts is null, create an array with one element and assign t to it
    public static <T> T[] append(T[] ts, T t) {
        if (ts == null) {
            @SuppressWarnings("unchecked")
            T[] result = (T[]) java.lang.reflect.Array.newInstance(t.getClass(), 1);
            result[0] = t;
            return result;
        }

        T[] result = Arrays.copyOf(ts, ts.length + 1);
        result[ts.length] = t;
        return result;
    }
}

interface Compatibility<U> {
    public boolean compatible(U u);

    public U[] preferences();

}

class House {
    String name;

    public House(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

}

class Client implements Compatibility<House> {
    private House[] wantsToBuy = null;
    String name;

    public Client(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }


    // Add h to the list of houses this client would
    // like to buy.
    public void likes(House h) {
        if (compatible(h))
            return;
        wantsToBuy = Tools.append(wantsToBuy, h);
    }

    // Does this client want to buy the house h?
    public boolean compatible(House h) {
        if (wantsToBuy == null)
            return false;
        for (House g : wantsToBuy) {
            if (g.equals(h))
                return true;
        }
        return false;
    }

    // Return the list of houses this client would
    // like to buy.
    public House[] preferences() {
        return wantsToBuy;
    }
}

class Pair<T, U> {
    T left;
    U right;

    public Pair(T left, U right) {
        this.left = left;
        this.right = right;
    }
}

class Match {
    // Returns a maximal matching between objects of type T in the array ts
    // and their objects of preference of type U.
    public static <U, T extends Compatibility<U>> Pair<T, U>[] match(T[] ts) {

        Pair[] likePairs = new Pair[ts.length];
        House[] hArray = new House[0];
        int foundIndex = 0;
        boolean clash = false;
        // go thought clients
        for (int i = 0; i < ts.length; i++) {

            U[] Uarray = ts[i].preferences();
           
            // go through THEIR houses
            for (int j = 0; j < Uarray.length; j++) {
                String client = ts[i].toString();
                ;
                System.out.println("\n" + client + " likes " + house);

                if (searchArray(hArray, house) == false) {
                    foundHouses = arrayExtend(foundHouses);
                    foundHouses[foundIndex] = house;
                    foundIndex++;
                } else {
                    System.out.println(house + " has been found already");
                    // Find where clash is and swap
                }
                System.out.println("\nJ value: " + j);
                System.out.println("\nI value: " + i);

                if (i == 0) {
                    likePairs[i] = new Pair(ts[i], Uarray[j]);
                    continue;

                } else if () {
                    System.out.println("ok");
                }

            }
        }
        arrayprint(foundHouses);

        return likePairs;
    }

    public static String[] arrayExtend(String[] sArray) {
        int len = sArray.length;
        String[] NewS = new String[len + 1];
        for (int i = 0; i < len; i++) {
            NewS[i] = sArray[i];
        }
        return NewS;
    }

    public static void arrayprint(String[] sArray) {
        int len = sArray.length;

        for (int i = 0; i < len; i++) {
            System.out.println(sArray[i] + "  ");
        }
    }

    public static boolean searchArray(House[] hArray, House key) {
        int len = sArray.length;

        for (int i = 0; i < len; i++) {
            if (sArray[i].equals(key)) {
                return true;
            }
        }
        return false;
    }
}

public class q5 {
    // Main for the class
    public static void main(String[] args) {
        House h1 = new House("h1");
        House h2 = new House("h2");
        House h3 = new House("h3");

        Client c1 = new Client("c1");
        Client c2 = new Client("c2");
        Client c3 = new Client("c3");

        c1.likes(h1);
        c1.likes(h2);
        c2.likes(h1);
        c3.likes(h3);

        Client[] cs = { c1, c2, c3 };
        Match.match(cs);
        //for (Pair<Client, House> p : Match.match(cs)) {
          //  System.out.print(p.left);
            //System.out.print(" --- ");
            //System.out.println(p.right);
        //}

    }
}