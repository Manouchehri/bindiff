package y.h;

import java.util.*;
import y.g.*;

class K implements Comparator
{
    private final F a;
    
    K(final F a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(((fj)o).getCenterY(), ((fj)o2).getCenterY());
    }
}
