package functionalInterfaces_ex;

import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(comparator.compare(10,10));

        Comparator<String> stringComparator = (a, b) -> {
            if (a.equals(b)) {
                return 0;
            }
            return 1;
        };

        System.out.println(stringComparator.compare("Apple","Banana"));

    }
}
