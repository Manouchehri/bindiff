package y.h;

import y.c.*;
import y.g.*;

final class eB implements Comparable
{
    final double a;
    final q b;
    
    private eB(final double a, final q b) {
        this.a = a;
        this.b = b;
    }
    
    public int compareTo(final Object o) {
        return e.a(this.a, ((eB)o).a);
    }
    
    public String toString() {
        return "SweepEntry{coordinate=" + this.a + ", node=" + this.b + '}';
    }
    
    eB(final double n, final q q, final dV dv) {
        this(n, q);
    }
}
