/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Map;
import y.c.A;
import y.c.D;
import y.c.c;
import y.c.f;
import y.c.q;
import y.c.x;
import y.f.X;
import y.f.c.R;
import y.f.c.a;
import y.f.c.aJ;
import y.f.c.w;
import y.g.am;

class aI
implements R {
    private aJ a;
    private R b;
    private c c;
    private c d;
    private boolean e;
    private Object f;

    public void a(R r2, c c2, c c3, Object object) {
        this.b = r2;
        this.c = c2;
        this.d = c3;
        this.f = object;
    }

    @Override
    public int a(X x2, A a2, f f2) {
        int n2;
        int[] arrn;
        Object object;
        int n3;
        int n4;
        boolean bl2;
        block12 : {
            boolean[] arrbl;
            boolean[] arrbl2;
            block11 : {
                bl2 = a.i;
                if (this.a == null || this.e) {
                    if (this.a == null) {
                        this.a = new aJ();
                    }
                    int n5 = this.b.a(x2, a2, f2);
                    this.a.a = Math.max(this.a.a, n5);
                    x x3 = x2.o();
                    do {
                        if (!x3.f()) return n5;
                        q q2 = x3.e();
                        Object object2 = this.b(q2);
                        this.a.b.put(object2, am.a(new Integer(a2.a(q2)), this.f));
                        x3.g();
                    } while (!bl2);
                    return n5;
                }
                arrbl = new boolean[this.a.a];
                arrn = x2.o();
                while (arrn.f()) {
                    q q3 = arrn.e();
                    Object object3 = this.b(q3);
                    object = (am)this.a.b.get(object3);
                    try {
                        Integer n6 = (Integer)object.a;
                        int n7 = n6;
                        a2.a((Object)q3, n7);
                        arrbl2 = arrbl;
                        if (bl2) break block11;
                        arrbl2[n7] = true;
                    }
                    catch (NullPointerException var9_18) {
                        throw new IllegalStateException(new StringBuffer().append("Memento has no information about ").append(q3).toString());
                    }
                    arrn.g();
                    if (!bl2) continue;
                }
                arrbl2 = arrbl;
            }
            arrn = new int[arrbl2.length];
            n2 = 0;
            for (int i2 = 0; i2 < arrn.length; ++i2) {
                n4 = arrbl[i2];
                if (!bl2) {
                    if (n4 == 0) continue;
                    arrn[i2] = n2++;
                    if (!bl2) continue;
                }
                break block12;
            }
            n4 = n2;
        }
        if (n4 < arrn.length) {
            x x4 = x2.o();
            while (x4.f()) {
                object = x4.e();
                int n8 = a2.a(object);
                n3 = arrn[n8];
                if (bl2) return n3;
                if (n3 != n8) {
                    a2.a(object, arrn[n8]);
                }
                x4.g();
                if (!bl2) continue;
            }
        }
        f2.a(w.a(x2, a2));
        n3 = n2;
        return n3;
    }

    public Object a(Object object) {
        Object object2 = this.b(object);
        if (object2 == null) {
            throw new IllegalArgumentException(new StringBuffer().append("No Id stored for ").append(object).toString());
        }
        Object v2 = this.a.b.get(object2);
        if (v2 != null) return v2;
        throw new IllegalArgumentException(new StringBuffer().append("No memento information stored for id ").append(object2).toString());
    }

    final Object b(Object object) {
        Object object2 = this.c.b(object);
        if (object2 != null) return object2;
        throw new IllegalArgumentException(new StringBuffer().append("No Id stored for ").append(object).toString());
    }

    public void a(boolean bl2) {
        this.e = bl2;
    }

    public void c(Object object) {
        if (!(object instanceof Map)) {
            throw new IllegalArgumentException("Unknown memento type!");
        }
        Map map = (Map)object;
        this.a = (aJ)map.get("y.layout.hierarchic.MementoLayerer.LayerMemento");
    }

    public void d(Object object) {
        if (!(object instanceof Map)) {
            throw new IllegalArgumentException("Unknown memento type!");
        }
        Map map = (Map)object;
        map.put("y.layout.hierarchic.MementoLayerer.LayerMemento", this.a);
    }
}

