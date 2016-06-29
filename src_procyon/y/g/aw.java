package y.g;

import java.util.*;

final class aw implements Comparator
{
    private aw() {
    }
    
    public int compare(final Object o, final Object o2) {
        return ((Comparable)o).compareTo(o2);
    }
    
    aw(final av av) {
        this();
    }
}
