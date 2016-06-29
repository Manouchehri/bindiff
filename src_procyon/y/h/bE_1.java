package y.h;

import y.h.a.*;
import y.f.b.*;
import y.g.*;
import java.util.*;
import y.c.*;

public class bE extends F
{
    private c a;
    private v b;
    
    public bE() {
        this(new bD());
    }
    
    public bE(final C c) {
        super(c);
    }
    
    protected void b(final i i, final i j) {
        final boolean z = fj.z;
        super.b(i, j);
        final v a = this.a(i);
        Label_0045: {
            if (a != null) {
                this.a = a.e();
                if (!z) {
                    break Label_0045;
                }
            }
            this.a = i.c(f.d);
        }
        if (this.a == null) {
            this.a = q.a(Boolean.FALSE);
            if (!z) {
                return;
            }
        }
        this.b = this.a(j);
        if (this.b == null) {
            ((bu)j).a(this.b = new v(j));
        }
    }
    
    public void a(final i i, final i j, final Map map, final Map map2) {
        final boolean z = fj.z;
        super.a(i, j, map, map2);
        final v a = this.a(i);
        c c = null;
        c c2 = null;
        Label_0063: {
            if (a != null) {
                c = a.c();
                c2 = a.d();
                if (!z) {
                    break Label_0063;
                }
            }
            c = i.c(f.b);
            c2 = i.c(f.c);
        }
        Label_0331: {
            if (this.b != null && c != null && c2 != null) {
                final HashMap<Object, y.c.q> hashMap = new HashMap<Object, y.c.q>();
                final HashMap<y.c.q, y.c.q> hashMap2 = new HashMap<y.c.q, y.c.q>();
                x x = i.o();
                while (true) {
                    while (x.f()) {
                        final y.c.q e = x.e();
                        hashMap.put(c.b(e), e);
                        x.g();
                        if (z) {
                            while (true) {
                                while (x.f()) {
                                    final y.c.q e2 = x.e();
                                    hashMap2.put(e2, hashMap.get(c2.b(e2)));
                                    x.g();
                                    if (z) {
                                        while (x.f()) {
                                            final y.c.q e3 = x.e();
                                            final y.c.q q = hashMap2.get(e3);
                                            if (z) {
                                                return;
                                            }
                                            if (q != null) {
                                                final y.c.q q2 = map.get(e3);
                                                if (q2 != null) {
                                                    final y.c.q q3 = map.get(q);
                                                    if (q3 != null) {
                                                        this.b.c(q2, q3);
                                                    }
                                                }
                                            }
                                            x.g();
                                            if (z) {
                                                break;
                                            }
                                        }
                                        break Label_0331;
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                                x = i.o();
                                continue;
                            }
                        }
                        if (z) {
                            break;
                        }
                    }
                    x = i.o();
                    continue;
                }
            }
        }
        this.b = null;
        this.a = null;
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
    
    protected void a(final y.c.q q, final y.c.q q2) {
        super.a(q, q2);
        if (this.a.d(q)) {
            this.b.c(q2);
        }
    }
    
    protected void a(final d d, final d d2) {
        super.a(d, d2);
    }
}
