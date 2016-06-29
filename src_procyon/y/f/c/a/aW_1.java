package y.f.c.a;

import java.util.*;
import y.f.*;
import y.a.*;
import y.c.*;
import y.g.*;

public class aW implements aT
{
    private aT a;
    private aS b;
    private Comparator c;
    
    public aW(final aT at) {
        this(at, new x(), null);
    }
    
    public aW(final aT a, final aS b, final Comparator c) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        this.c = c;
        this.b = b;
        this.a = a;
    }
    
    public void a(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final aT a = this.a();
        final aS b = this.b();
        final A t = x.t();
        try {
            final int a2 = h.a(x, t);
            if (a2 == 1) {
                a.a(x, au, av);
                if (!x2) {
                    return;
                }
            }
            final y[] array = new y[a2];
            int i = 0;
            while (i < array.length) {
                array[i] = new y();
                ++i;
                if (x2) {
                    return;
                }
                if (x2) {
                    break;
                }
            }
            final y.c.x o = x.o();
            while (true) {
                while (o.f()) {
                    array[t.a(o.e())].add(o.e());
                    o.g();
                    if (x2) {
                        final J j = new J(x, t);
                        int k = 0;
                        while (k < a2) {
                            j.c(t.b(array[k].b()));
                            final aU a3 = au.a();
                            a.a(x, a3, av);
                            b.a(x, av, a3, au);
                            ++k;
                            if (x2) {
                                return;
                            }
                            if (x2) {
                                break;
                            }
                        }
                        j.b();
                        return;
                    }
                    if (x2) {
                        break;
                    }
                }
                this.a(array, t);
                continue;
            }
        }
        finally {
            x.a(t);
        }
    }
    
    protected void a(final y[] array, final c c) {
        final Comparator c2 = this.c();
        if (c2 != null) {
            e.a(array, c2);
        }
    }
    
    public aT a() {
        return this.a;
    }
    
    public aS b() {
        return this.b;
    }
    
    public Comparator c() {
        return this.c;
    }
}
