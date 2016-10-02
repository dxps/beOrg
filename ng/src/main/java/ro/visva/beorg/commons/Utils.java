package ro.visva.beorg.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <br><br>
 * 2016-03-13 17:29 | visvadw | Creation time.
 */
public class Utils {

    /** Convert a Map to a List. */
    public static <E> List<E> convertMapToList(Map<?,E> map) {
        if ( (map == null) || (map.size() == 0) )
            return new ArrayList<E>(0);
        List<E> list = new ArrayList<E>(map.size());
        for (E e : map.values())
            list.add(e);
        return list;
    }

    /** Get a printer friendly (JSON format) list. */
    public static <E> String printerFriendlyList(List<E> list) {
        if ( (list == null) || (list.size() == 0) )
            return "{}";
        StringBuilder sb = new StringBuilder("{ ");
        boolean firstElement = true;
        for (E element : list) {
            if (firstElement) {
                sb.append(element);
                firstElement = false;
            } else {
                sb.append(", ").append(element);
            }
        }
        sb.append(" }");
        return sb.toString();
    }

    /** Get a printer friendly (JSON format) map. */
    public static <E> String printerFriendlyMap(Map<?,E> map) {
        if ( (map == null) || (map.size() == 0) )
            return "{}";
        StringBuilder sb = new StringBuilder("{ ");
        boolean firstElement = true;
        for (E element : map.values()) {
            if (firstElement) {
                sb.append(element);
                firstElement = false;
            } else {
                sb.append(", ").append(element);
            }
        }
        sb.append(" }");
        return sb.toString();
    }

}
