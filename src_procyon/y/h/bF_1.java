package y.h;

import y.h.a.*;
import y.g.*;
import java.util.*;
import y.c.*;

public class bF implements C
{
    private v a;
    private v b;
    private Map c;
    private int d;
    private B e;
    private final C f;
    
    public bF(final C f) {
        this.f = f;
        this.e = new B(this);
    }
    
    public d a(final i i, final q q, final q q2, final d d) {
        return this.f.a(i, q, q2, d);
    }
    
    public q a(final i i, final q q) {
        return this.f.a(i, q);
    }
    
    public B a() {
        return this.e;
    }
    
    public void a(final B e) {
        this.e = e;
    }
    
    public void a(final i i, final i j, final Map map, final Map map2) {
        this.f.a(i, j, map, map2);
        this.a(i, map, map2);
        if (this.d == 0) {
            this.a = null;
            this.b = null;
            this.c = null;
        }
    }
    
    public void a(final i i, final i j) {
        this.f.a(i, j);
        if (this.d == 0) {
            this.c = new HashMap();
            this.b = this.a(i);
            this.a = this.a(j);
            if (this.b != null && this.a == null && i instanceof bu) {
                ((bu)i).a(this.a = new v(j));
            }
        }
    }
    
    private void a(final i i, final Map map, final Map map2) {
        final boolean z = fj.z;
        final x o = i.o();
        while (o.f()) {
            final q e = o.e();
            final Object value = map.get(e);
            if (z) {
                return;
            }
            if (value != null) {
                this.c.put(e, value);
            }
            o.g();
            if (z) {
                break;
            }
        }
        if (this.b == null || this.a == null || this.a() == null) {
            return;
        }
        int n = 0;
        final ArrayList<Object> list = new ArrayList<Object>();
        final x o2 = i.o();
        while (o2.f()) {
            final q e2 = o2.e();
            final q q = map.get(e2);
            if (z) {
                return;
            }
            if (q != null && this.b.j(e2) && !this.a.j(q)) {
                list.add(e2);
                n += e2.a();
                this.a.d(q);
                ++this.d;
                try {
                    this.a(e2, this.b, q, this.a);
                }
                finally {
                    --this.d;
                }
            }
            o2.g();
            if (z) {
                break;
            }
        }
        if (n > 0) {
            int j = 0;
            while (j < list.size()) {
                I value2 = list.get(j);
            Label_0305:
                while (true) {
                    final e k = ((q)value2).j();
                    while (k.f()) {
                        final d a = k.a();
                        final d d = map2.get(a);
                        final q q2 = (q)(value2 = d);
                        if (z) {
                            continue Label_0305;
                        }
                        if (q2 != null && this.b.e(a)) {
                            final q b = this.b.b(a);
                            final q c = this.b.c(a);
                            final q q3 = this.c.get(b);
                            final q q4 = this.c.get(c);
                            if (q3 != null && q4 != null) {
                                this.a(a, this.a, d, q3, q4);
                            }
                        }
                        k.g();
                        if (z) {
                            break;
                        }
                    }
                    break;
                }
                ++j;
                if (z) {
                    break;
                }
            }
        }
    }
    
    protected void a(final d d, final v v, final d d2, final q q, final q q2) {
        v.b(d2, q, q2);
    }
    
    private v a(final i i) {
        v v = null;
        if (i instanceof bu) {
            v = ((bu)i).C();
        }
        else if (y.h.a.v.a(i) != null) {
            v = y.h.a.v.a(i);
        }
        return v;
    }
    
    protected void a(final q q, final v v, final q q2, final v v2) {
        final i m = v2.m(q2);
        final B b = this.b(q, v, q2, v2);
        if (b.a() != this) {
            final bG bg = new bG(this, b.a());
            b.a(bg);
            try {
                b.a(v.m(q), m);
                return;
            }
            finally {
                b.a(bg.a);
            }
        }
        b.a(v.m(q), m);
    }
    
    protected B b(final q q, final v v, final q q2, final v v2) {
        return this.a();
    }
    
    static void a(final bF bf, final i i, final Map map, final Map map2) {
        bf.a(i, map, map2);
    }
}
