/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import java.util.HashMap;
import java.util.Map;
import y.c.A;
import y.c.b;
import y.c.c;
import y.c.i;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.Y;
import y.f.b.f;
import y.g.C;
import y.g.F;

public class Z
extends F {
    private c a;
    private c b;
    private c c;
    private b d;
    private b e;
    private b f;

    public Z() {
        this(new Y());
    }

    public Z(C c2) {
        super(c2);
    }

    @Override
    protected void b(i i2, i i3) {
        super.b(i2, i3);
        this.a = i2.c(f.d);
        this.b = i2.c(f.b);
        this.c = i2.c(f.c);
        if (this.a == null) return;
        if (this.b == null) return;
        if (this.c == null) return;
        this.d = (b)i3.c(f.d);
        this.e = (b)i3.c(f.b);
        this.f = (b)i3.c(f.c);
        if (this.d == null) {
            this.d = i3.t();
            i3.a(f.d, this.d);
        }
        if (this.e == null) {
            this.e = i3.t();
            i3.a(f.b, this.e);
        }
        if (this.f != null) return;
        this.f = i3.t();
        i3.a(f.c, this.f);
    }

    @Override
    protected void b(i i2, i i3, Map map, Map map2) {
        boolean bl2 = X.j;
        super.b(i2, i3, map, map2);
        if (this.e != null) {
            q q2;
            x x2;
            HashMap<Object, q> hashMap;
            block5 : {
                hashMap = new HashMap<Object, q>();
                x2 = i2.o();
                while (x2.f()) {
                    q2 = x2.e();
                    hashMap.put(this.b.b(q2), q2);
                    x2.g();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block5;
                }
                x2 = i2.o();
            }
            while (x2.f()) {
                q2 = x2.e();
                q q3 = (q)map.get(q2);
                q q4 = (q)hashMap.get(this.c.b(q2));
                q q5 = (q)map.get(q4);
                if (bl2) return;
                if (q3 != null && q5 != null) {
                    this.f.a((Object)q3, this.e.b(q5));
                }
                x2.g();
                if (!bl2) continue;
            }
        }
        this.f = null;
        this.e = null;
        this.d = null;
        this.c = null;
        this.b = null;
        this.a = null;
    }

    @Override
    protected void a(q q2, q q3) {
        super.a(q2, q3);
        if (this.b == null) return;
        if (this.e == null) return;
        Object object = this.b.b(q2);
        this.e.a((Object)q3, this.a(object, q3));
        this.d.a((Object)q3, this.a.d(q2));
    }

    protected Object a(Object object, q q2) {
        return q2;
    }
}

