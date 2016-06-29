/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.q;
import y.f.X;
import y.f.ae;
import y.f.i.a.J;
import y.f.i.a.L;
import y.f.i.a.N;
import y.f.i.a.O;
import y.f.i.a.Q;
import y.f.i.a.R;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.bc;
import y.f.i.a.l;
import y.f.i.a.m;
import y.f.i.a.x;
import y.f.i.a.y;

public class I
implements Q,
l,
m {
    private final O a;
    private final List b;
    private final HashMap c;
    private final D d;
    private Z e;
    private double f;

    public I(O o2) {
        this.a = o2;
        this.d = new D();
        this.b = new ArrayList();
        this.c = new HashMap();
    }

    @Override
    public void a(m m2) {
        this.b.add(m2);
    }

    @Override
    public void b(m m2) {
        this.b.remove(m2);
    }

    public void a(Z z2) {
        I i2;
        block3 : {
            int n2 = ab.a;
            this.e = z2;
            this.f = this.c();
            if (this.a instanceof l) {
                ((l)((Object)this.a)).a(this);
            }
            for (int i3 = 0; i3 < this.b.size(); ++i3) {
                i2 = this;
                if (n2 == 0) {
                    if (!(i2.b.get(i3) instanceof J)) continue;
                    ((J)this.b.get(i3)).a(z2, this);
                    if (n2 == 0) continue;
                }
                break block3;
            }
            i2 = this;
        }
        y.d.y y2 = i2.a(z2.a(), (List)this.d);
        this.a.a(this.d, y2);
    }

    y.d.y a(X x2, List list) {
        y.d.y y2;
        int n2 = ab.a;
        Rectangle2D rectangle2D = ae.a(x2, x2.o());
        for (N n3 : list) {
            y2 = n3.a();
            if (n2 != 0) return y2;
            y.d.y y3 = y2;
            Rectangle2D.Double double_ = new Rectangle2D.Double(y3.c(), y3.d(), y3.a(), y3.b());
            Rectangle2D.union(rectangle2D, double_, rectangle2D);
            if (n2 == 0) continue;
        }
        y2 = new y.d.y(rectangle2D.getX() - 100.0, rectangle2D.getY() - 100.0, rectangle2D.getWidth() + 200.0, rectangle2D.getHeight() + 200.0);
        return y2;
    }

    @Override
    public List c(R r2) {
        return this.a.c(r2);
    }

    public List d(R r2) {
        ArrayList<Object> arrayList;
        int n2 = ab.a;
        List list = this.a.d(r2);
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        for (N n3 : list) {
            if (!(n3.b() instanceof q)) continue;
            arrayList = arrayList2;
            if (n2 != 0) return arrayList;
            arrayList.add(n3.b());
            if (n2 == 0) continue;
        }
        arrayList = arrayList2;
        return arrayList;
    }

    public List e(R r2) {
        return this.a.d(r2);
    }

    public List a(q q2) {
        N n2 = (N)this.c.get(q2);
        if (n2 == null) throw new IllegalArgumentException("Unknown node");
        return this.a.a(n2);
    }

    @Override
    public List a(y.d.y y2) {
        return this.a.a(y2);
    }

    @Override
    public y.d.y b() {
        return this.a.b();
    }

    public void a() {
        boolean bl2;
        block3 : {
            int n2 = ab.a;
            for (int i2 = 0; i2 < this.b.size(); ++i2) {
                bl2 = this.b.get(i2) instanceof J;
                if (n2 == 0) {
                    if (!bl2) continue;
                    ((J)this.b.get(i2)).a();
                    if (n2 == 0) continue;
                }
                break block3;
            }
            bl2 = this.a instanceof l;
        }
        if (bl2) {
            ((l)((Object)this.a)).b(this);
        }
        this.e = null;
        this.c.clear();
        this.d.clear();
        this.a.a();
    }

    @Override
    public void a(R r2, List list) {
        int n2 = ab.a;
        int n3 = this.b.size() - 1;
        do {
            if (n3 < 0) return;
            ((m)this.b.get(n3)).a(r2, list);
            --n3;
        } while (n2 == 0);
    }

    @Override
    public void b(R r2) {
        int n2 = ab.a;
        int n3 = this.b.size() - 1;
        do {
            if (n3 < 0) return;
            ((m)this.b.get(n3)).b(r2);
            --n3;
        } while (n2 == 0);
    }

    @Override
    public void a(R r2) {
        int n2 = ab.a;
        r2.a(new bc(r2, this.f, this.e.c().k()));
        int n3 = this.b.size() - 1;
        do {
            if (n3 < 0) return;
            ((m)this.b.get(n3)).a(r2);
            --n3;
        } while (n2 == 0);
    }

    private double c() {
        double d2;
        int n2 = ab.a;
        double d3 = 0.0;
        y y2 = this.e.c();
        e e2 = this.e.a().E().a();
        while (e2.f()) {
            d d4 = e2.a();
            d2 = Math.max(d3, y2.a(d4).c());
            if (n2 != 0) return d2;
            d3 = d2;
            e2.g();
            if (n2 == 0) continue;
        }
        d2 = d3;
        return d2;
    }

    public N a(y.d.y y2, Object object) {
        N n2 = new N(y2, object);
        this.c.put(object, n2);
        this.d.add(n2);
        return n2;
    }
}

