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

    }
}

public class q5 {
//Main for the class
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
        for (Pair<Client, House> p : Match.match(cs)) {
            System.out.print(p.left);
            System.out.print(" --- ");
            System.out.println(p.right);
        }

    }
}