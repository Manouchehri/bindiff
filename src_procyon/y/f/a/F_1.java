package y.f.a;

import java.util.*;
import y.g.*;
import y.c.*;

class F implements Comparator, g
{
    A a;
    A b;
    A c;
    
    public F(final A a, final A b, final A c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int compare(final Object o, final Object o2) {
        final q q = (q)o;
        final q q2 = (q)o2;
        if (this.a.a(q) < this.a.a(q2)) {
            return 1;
        }
        if (this.a.a(q) > this.a.a(q2)) {
            return -1;
        }
        if (this.a(this.b.a(q), this.b.a(q2))) {
            return -1;
        }
        if (this.a(this.b.a(q2), this.b.a(q))) {
            return 1;
        }
        if (this.c.a(q) < this.c.a(q2)) {
            return -1;
        }
        if (this.c.a(q) > this.c.a(q2)) {
            return 1;
        }
        return 0;
    }
    
    private boolean a(final int n, final int n2) {
        if (n >= n2) {
            return false;
        }
        if (n > -1) {
            return 100.0 < n2 - n;
        }
        return n + 100.0 < n2;
    }
}
