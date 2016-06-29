package y.h;

import java.util.*;
import y.g.*;

class J implements Comparator
{
    private final F a;
    
    J(final F a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(((fj)o).getCenterX(), ((fj)o2).getCenterX());
    }
}
