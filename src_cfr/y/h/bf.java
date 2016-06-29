/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.g.B;
import y.g.C;
import y.h.a.v;
import y.h.bG;
import y.h.bu;
import y.h.fj;

public class bF
implements C {
    private v a;
    private v b;
    private Map c;
    private int d;
    private B e;
    private final C f;

    public bF(C c2) {
        this.f = c2;
        this.e = new B(this);
    }

    @Override
    public d a(i i2, q q2, q q3, d d2) {
        return this.f.a(i2, q2, q3, d2);
    }

    @Override
    public q a(i i2, q q2) {
        return this.f.a(i2, q2);
    }

    public B a() {
        return this.e;
    }

    public void a(B b2) {
        this.e = b2;
    }

    @Override
    public void a(i i2, i i3, Map map, Map map2) {
        this.f.a(i2, i3, map, map2);
        this.a(i2, map, map2);
        if (this.d != 0) return;
        this.a = null;
        this.b = null;
        this.c = null;
    }

    @Override
    public void a(i i2, i i3) {
        this.f.a(i2, i3);
        if (this.d != 0) return;
        this.c = new HashMap();
        this.b = this.a(i2);
        this.a = this.a(i3);
        if (this.b == null) return;
        if (this.a != null) return;
        if (!(i2 instanceof bu)) return;
        this.a = new v(i3);
        ((bu)i2).a(this.a);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(i i2, Map map, Map map2) {
        Object object;
        Object object2;
        q q2;
        Object object3;
        boolean bl2 = fj.z;
        x x2 = i2.o();
        while (x2.f()) {
            object = x2.e();
            object3 = map.get(object);
            if (bl2) return;
            if (object3 != null) {
                this.c.put(object, object3);
            }
            x2.g();
            if (!bl2) continue;
        }
        if (this.b == null) return;
        if (this.a == null) return;
        if (this.a() == null) return;
        int n2 = 0;
        object = new ArrayList();
        object3 = i2.o();
        while (object3.f()) {
            q2 = object3.e();
            object2 = (q)map.get(q2);
            if (bl2) return;
            if (object2 != null && this.b.j(q2) && !this.a.j((q)object2)) {
                object.add(q2);
                n2 += q2.a();
                this.a.d((q)object2);
                ++this.d;
                try {
                    this.a(q2, this.b, (q)object2, this.a);
                }
                finally {
                    --this.d;
                }
            }
            object3.g();
            if (!bl2) continue;
        }
        if (n2 <= 0) return;
        int n3 = 0;
        do {
            if (n3 >= object.size()) return;
            Object object4 = object.get(n3);
            block6 : do {
                q2 = (q)object4;
                object2 = q2.j();
                while (object2.f()) {
                    d d2;
                    d d3 = object2.a();
                    object4 = d2 = (d)map2.get(d3);
                    if (bl2) continue block6;
                    if (object4 != null && this.b.e(d3)) {
                        q q3 = this.b.b(d3);
                        q q4 = this.b.c(d3);
                        q q5 = (q)this.c.get(q3);
                        q q6 = (q)this.c.get(q4);
                        if (q5 != null && q6 != null) {
                            this.a(d3, this.a, d2, q5, q6);
                        }
                    }
                    object2.g();
                    if (!bl2) continue;
                }
                break block6;
                break;
            } while (true);
            ++n3;
        } while (!bl2);
    }

    protected void a(d d2, v v2, d d3, q q2, q q3) {
        v2.b(d3, q2, q3);
    }

    private v a(i i2) {
        v v2 = null;
        if (i2 instanceof bu) {
            return ((bu)i2).C();
        }
        if (v.a(i2) == null) return v2;
        return v.a(i2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void a(q q2, v v2, q q3, v v3) {
        i i2 = v3.m(q3);
        B b2 = this.b(q2, v2, q3, v3);
        if (b2.a() != this) {
            bG bG2 = new bG(this, b2.a());
            b2.a(bG2);
            try {
                b2.a(v2.m(q2), i2);
                return;
            }
            finally {
                b2.a(bG2.a);
            }
        } else {
            b2.a(v2.m(q2), i2);
        }
    }

    protected B b(q q2, v v2, q q3, v v3) {
        return this.a();
    }

    static void a(bF bF2, i i2, Map map, Map map2) {
        bF2.a(i2, map, map2);
    }
}

