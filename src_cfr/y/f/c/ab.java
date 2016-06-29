/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import y.c.A;
import y.c.c;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.c.Q;
import y.f.c.a;
import y.f.c.aC;
import y.f.c.aD;

class aB
implements Q {
    aD a;
    private Q b;
    private c c;
    private boolean d;
    private Comparator e;

    public aB() {
        this.e = new aC(this);
    }

    void a(Q q2, c c2) {
        this.b = q2;
        this.c = c2;
    }

    public void a(Object object) {
        if (!(object instanceof Map)) {
            throw new IllegalArgumentException("Unknown memento type!");
        }
        Map map = (Map)object;
        this.a = (aD)map.get("y.layout.hierarchic.MementoSequencer.SequencerMemento");
    }

    public void b(Object object) {
        if (!(object instanceof Map)) {
            throw new IllegalArgumentException("Unknown memento type!");
        }
        Map map = (Map)object;
        map.put("y.layout.hierarchic.MementoSequencer.SequencerMemento", this.a);
    }

    @Override
    public y[] a(X x2, A a2, int n2) {
        Object object;
        y[] arry;
        boolean bl2 = a.i;
        if (this.a == null || this.d) {
            y[] arry2;
            if (this.a == null) {
                this.a = new aD();
            }
            y[] arry3 = this.b.a(x2, a2, n2);
            Map map = this.a.a;
            int n3 = 0;
            while (n3 < arry3.length) {
                block9 : {
                    arry2 = arry3;
                    if (bl2) return arry2;
                    y y2 = arry2[n3];
                    int n4 = 0;
                    for (p p2 = y2.k(); p2 != null; p2 = p2.a(), ++n4) {
                        map.put(this.c(p2.c()), new Integer(n4));
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block9;
                    }
                    ++n3;
                }
                if (!bl2) continue;
            }
            arry2 = arry3;
            return arry2;
        }
        y[] arry4 = new y[n2];
        for (int i2 = arry4.length - 1; i2 >= 0; --i2) {
            arry4[i2] = new y();
            if (!bl2) continue;
        }
        Object object2 = x2.o();
        while (object2.f()) {
            q q2 = object2.e();
            object = this.c(q2);
            if (this.a.a.get(object) == null) {
                throw new IllegalStateException(new StringBuffer().append("No memento stored for ").append(object).toString());
            }
            arry4[a2.a(q2)].add(q2);
            object2.g();
            if (!bl2) continue;
        }
        object2 = new ArrayList(arry4.length);
        for (int i3 = 0; i3 < arry4.length; ++i3) {
            arry = arry4;
            if (bl2) return arry;
            object = arry[i3];
            if (object.size() <= 0) continue;
            object.sort(this.e);
            object2.add(object);
            if (!bl2) continue;
        }
        arry = object2.toArray(new y[object2.size()]);
        return arry;
    }

    final Object c(Object object) {
        Object object2 = this.c.b(object);
        if (object2 != null) return object2;
        throw new IllegalArgumentException(new StringBuffer().append("No Id stored for ").append(object).toString());
    }

    public void a(boolean bl2) {
        this.d = bl2;
    }
}

