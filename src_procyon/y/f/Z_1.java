package y.f;

import y.g.*;
import y.f.b.*;
import java.util.*;
import y.c.*;

public class Z extends F
{
    private c a;
    private c b;
    private c c;
    private b d;
    private b e;
    private b f;
    
    public Z() {
        this(new Y());
    }
    
    public Z(final C c) {
        super(c);
    }
    
    protected void b(final i i, final i j) {
        super.b(i, j);
        this.a = i.c(y.f.b.f.d);
        this.b = i.c(y.f.b.f.b);
        this.c = i.c(y.f.b.f.c);
        if (this.a != null && this.b != null && this.c != null) {
            this.d = (b)j.c(y.f.b.f.d);
            this.e = (b)j.c(y.f.b.f.b);
            this.f = (b)j.c(y.f.b.f.c);
            if (this.d == null) {
                j.a(y.f.b.f.d, this.d = j.t());
            }
            if (this.e == null) {
                j.a(y.f.b.f.b, this.e = j.t());
            }
            if (this.f == null) {
                j.a(y.f.b.f.c, this.f = j.t());
            }
        }
    }
    
    protected void b(final i i, final i j, final Map map, final Map map2) {
        final boolean k = X.j;
        super.b(i, j, map, map2);
        Label_0212: {
            if (this.e != null) {
                final HashMap<Object, q> hashMap = new HashMap<Object, q>();
                x x = i.o();
                while (true) {
                    while (x.f()) {
                        final q e = x.e();
                        hashMap.put(this.b.b(e), e);
                        x.g();
                        if (k) {
                            while (x.f()) {
                                final q e2 = x.e();
                                final q q = map.get(e2);
                                final q q2 = map.get(hashMap.get(this.c.b(e2)));
                                if (k) {
                                    return;
                                }
                                if (q != null && q2 != null) {
                                    this.f.a(q, this.e.b(q2));
                                }
                                x.g();
                                if (k) {
                                    break;
                                }
                            }
                            break Label_0212;
                        }
                        if (k) {
                            break;
                        }
                    }
                    x = i.o();
                    continue;
                }
            }
        }
        final b d = null;
        this.f = d;
        this.e = d;
        this.d = d;
        final c a = null;
        this.c = a;
        this.b = a;
        this.a = a;
    }
    
    protected void a(final q q, final q q2) {
        super.a(q, q2);
        if (this.b != null && this.e != null) {
            this.e.a(q2, this.a(this.b.b(q), q2));
            this.d.a(q2, this.a.d(q));
        }
    }
    
    protected Object a(final Object o, final q q) {
        return q;
    }
}
