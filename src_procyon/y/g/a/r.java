package y.g.a;

import java.util.*;

abstract class r
{
    private Comparator c;
    protected l a;
    protected int b;
    
    public r(final Comparator c) {
        this.c = c;
    }
    
    public void a() {
        this.a = null;
    }
    
    public boolean b() {
        return this.a == null;
    }
    
    public Object c() {
        if (!this.b()) {
            return this.h(this.a).d;
        }
        return null;
    }
    
    public boolean c(final Object o) {
        return this.d(o) != null;
    }
    
    protected int a(final Object o, final Object o2) {
        return this.c.compare(o, o2);
    }
    
    protected l d(final Object o) {
        final boolean a = d.a;
        l l = this.a;
        while (l != null) {
            if (this.a(o, l.d) < 0) {
                l = l.b;
                if (!a) {
                    continue;
                }
            }
            if (this.a(o, l.d) > 0) {
                l = l.c;
                if (!a) {
                    continue;
                }
            }
            return l;
        }
        return l;
    }
    
    protected static void a(final l l, final l i) {
        final Object d = l.d;
        l.d = i.d;
        i.d = d;
    }
    
    protected l h(l l) {
        final boolean a = d.a;
        l b = null;
        while (l.b != null) {
            b = l.b;
            if (a) {
                return b;
            }
            l = b;
            if (a) {
                break;
            }
        }
        return b;
    }
}
