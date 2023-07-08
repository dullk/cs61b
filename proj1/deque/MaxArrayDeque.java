package deque;
import java.util.*;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        if (size() == 0) {
            return null;
        }
        T returnItem = get(0);
        for (int i = 0; i < size(); i += 1) {
            if (comparator.compare(get(i), returnItem) > 0) {
                returnItem = get(i);
            }
        }
        return returnItem;
    }

    public T max(Comparator<T> c) {
        if (size() == 0) {
            return null;
        }
        T returnItem = get(0);
        for (int i = 0; i < size(); i += 1) {
            if (c.compare(get(i), returnItem) > 0) {
                returnItem = get(i);
            }
        }
        return returnItem;
    }


}

