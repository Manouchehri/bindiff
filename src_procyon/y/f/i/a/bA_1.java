package y.f.i.a;

import java.util.*;
import y.g.*;

class bA implements Comparator
{
    private final bz a;
    
    bA(final bz a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final bB bb = (bB)o;
        final bB bb2 = (bB)o2;
        if (Math.abs(bb.a - bb2.a) < 1.0E-6) {
            return e.a(bb2.b, bb.b);
        }
        return e.a(bb.a, bb2.a);
    }
}
