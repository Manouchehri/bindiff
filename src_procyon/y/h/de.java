package y.h;

import java.util.*;
import y.g.*;

final class de implements Comparable
{
    final double a;
    final ArrayList b;
    
    de(final double a) {
        this.b = new ArrayList();
        this.a = a;
    }
    
    public int compareTo(final Object o) {
        return e.a(this.a, ((de)o).a);
    }
    
    public String toString() {
        return "Entry{nodes=" + this.b + ", size=" + this.a + '}';
    }
}
