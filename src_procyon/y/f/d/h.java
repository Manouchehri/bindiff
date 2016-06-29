package y.f.d;

import java.util.*;
import y.c.*;

class h implements Comparator
{
    r[] a;
    private final f b;
    
    h(final f b, final r[] a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final q q = (q)o;
        final q q2 = (q)o2;
        final boolean c = this.a[this.b.p.a(q)].c();
        final boolean c2 = this.a[this.b.p.a(q2)].c();
        if (c && c2) {
            return 0;
        }
        if (c) {
            return -1;
        }
        if (c2) {
            return 1;
        }
        if (f.a(this.b).c(q) < f.a(this.b).c(q2)) {
            return 1;
        }
        if (f.a(this.b).c(q2) < f.a(this.b).c(q)) {
            return -1;
        }
        return 0;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof h && this.a == ((h)o).a);
    }
    
    public int hashCode() {
        return (this.a != null) ? this.a.hashCode() : 0;
    }
}
