package sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {

    public static void main(String ... args) {
        List<String> test = intersection(Arrays.asList("abc", "def", "ghi"), Arrays.asList("def", "xyz"));
        System.out.println(test);
        System.out.println(test.size() == 1);
        System.out.println(test.get(0).equals("def"));

        test = intersection(Arrays.asList("abc", "def", "ghi"), Arrays.asList("def", "ghi", "xyz"));
        System.out.println(test);
        System.out.println(test.size() == 2);
        System.out.println(test.get(0).equals("def"));
        System.out.println(test.get(1).equals("ghi"));

        test = intersection(Arrays.asList("abc", "def", "ghi"), Arrays.asList("xyz"));
        System.out.println(test);
        System.out.println(test.size() == 0);

        test = intersection(null, Arrays.asList("xyz"));
        System.out.println(test);
        System.out.println(test.size() == 0);

        test = intersection(Arrays.asList("xyz"), null);
        System.out.println(test);
        System.out.println(test.size() == 0);

        test = intersection(null, null);
        System.out.println(test);
        System.out.println(test.size() == 0);

        test = intersection(null, new ArrayList<String>());
        System.out.println(test);
        System.out.println(test.size() == 0);

        List<Integer> intTest = intersection(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 5));
        System.out.println(intTest);
        System.out.println(intTest.size() == 2);
    }

    public static <T> List<T> intersection(List<T> lista, List<T> listb) {
        List<T> intersect = new ArrayList<T>();
        if (lista != null && listb != null) {
            for(T o : lista) {
                if (listb.contains(o)) {
                    intersect.add(o);
                }
            }
        }
        return intersect;
    }
}
