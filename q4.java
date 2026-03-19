public class q4 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        String s3 = "b";

        System.out.println("String Test:");
        System.out.println(areEqual(s1, s2) == areEqualGeneric(s1, s2));
        System.out.println(areEqual(s1, s3) == areEqualGeneric(s1, s3));
        System.out.println();

        Integer i1 = new Integer(2);
        Integer i2 = new Integer(2);
        Integer i3 = new Integer(3);

        System.out.println("Integer Test:");
        System.out.println(areEqual(i1, i2) == areEqualGeneric(i1, i2));
        System.out.println(areEqual(i1, i3) == areEqualGeneric(i1, i3));
        System.out.println();

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean(true);
        Boolean b3 = new Boolean(false);

        System.out.println("Boolean Test:");
        System.out.println(areEqual(b1, b2) == areEqualGeneric(b1, b2));
        System.out.println(areEqual(b1, b3) == areEqualGeneric(b1, b3));
        System.out.println();

    }

    public static boolean areEqual(String s1, String s2) {
        return s1.equals(s2);
    }

    public static boolean areEqual(Integer i1, Integer i2) {
        return i1.equals(i2);
    }

    public static boolean areEqual(Boolean b1, Boolean b2) {
        return b1.equals(b2);
    }

    public static <T, U> boolean areEqualGeneric(T first, U second){

        if (first.equals(second)){
            return true;
        }
        else{
            return false;
        }
    
    }
}
