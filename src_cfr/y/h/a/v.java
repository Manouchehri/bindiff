/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.WeakHashMap;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.m;
import y.c.o;
import y.c.p;
import y.c.q;
import y.h.a.A;
import y.h.a.B;
import y.h.a.C;
import y.h.a.D;
import y.h.a.E;
import y.h.a.F;
import y.h.a.H;
import y.h.a.I;
import y.h.a.J;
import y.h.a.K;
import y.h.a.c;
import y.h.a.d;
import y.h.a.t;
import y.h.a.u;
import y.h.a.w;
import y.h.a.x;
import y.h.a.y;
import y.h.a.z;
import y.h.bu;

public class v {
    private static final Collection b = new ArrayList();
    private Map c;
    private Map d;
    private Map e;
    private z f;
    private o g;
    private m h;
    private Vector i;
    private K j;
    private i k;
    private Map l;
    private Map m;
    private y.c.A n;
    private y.c.A o;
    private q p;
    private int q;
    private y.c.c r;
    private y.c.c s;
    private y.c.c t;
    public static int a;

    public v(i i2) {
        this(i2, new c());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public v(i var1_1, m var2_2) {
        var7_3 = v.a;
        super();
        this.r = new I();
        this.s = new C(this);
        this.t = new H(this);
        this.d = new WeakHashMap<K, V>();
        this.e = new WeakHashMap<K, V>();
        this.c = new WeakHashMap<K, V>();
        this.f = new z(this, var1_1, null);
        this.c.put(var1_1, this.f);
        this.g = new B(this);
        this.i = new Vector<E>();
        this.h = var2_2;
        this.j = new d();
        if (!(var1_1 instanceof bu)) ** GOTO lbl19
        ((bu)var1_1).a(this);
        if (var7_3 != 0) {
            i.g = i.g == false;
lbl19: // 2 sources:
            var3_4 = v.b;
            // MONITORENTER : var3_4
            v.b.add(this);
            // MONITOREXIT : var3_4
        }
        this.k = new i();
        this.l = new WeakHashMap<K, V>();
        this.m = new WeakHashMap<K, V>();
        this.n = this.k.t();
        this.o = this.k.t();
        this.p = this.k.d();
        this.l.put(var1_1, this.p);
        this.m.put(null, this.p);
        this.q = 0;
        this.k.a(new w(this));
        var1_1.a(this.g);
        var3_4 = var1_1.o();
        do {
            if (var3_4.f() == false) return;
            var4_5 = var3_4.e();
            var5_6 = (q)this.l.get(var1_1);
            var6_7 = this.k.d();
            this.m.put(var4_5, var6_7);
            this.n.a((Object)var6_7, var4_5);
            this.k.a(var6_7, var5_6);
            var3_4.g();
        } while (var7_3 == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static v a(i i2) {
        if (i2 instanceof bu) {
            return ((bu)i2).C();
        }
        Collection collection = b;
        synchronized (collection) {
            v v2;
            Iterator iterator = b.iterator();
            do {
                if (!iterator.hasNext()) return null;
            } while (!(v2 = (v)iterator.next()).d(i2));
            return v2;
        }
    }

    public q a(q q2) {
        int n2 = a;
        i i2 = null;
        i2 = q2 == null ? this.g() : (this.j(q2) ? this.m(q2) : q2.e());
        i i3 = this.h(i2);
        if (i3 instanceof bu) {
            ((bu)i3).a(this);
        }
        q q3 = this.h.a(i2, i3);
        this.a(new t(this, 6, i2, (Object)q3));
        z z2 = new z(this, i3, q3);
        this.c.put(i3, z2);
        this.e.put(q3, z2);
        q q4 = (q)this.m.get(q3);
        this.l.put(i3, q4);
        this.a(new t(this, 4, i2, (Object)q3));
        if (this.k(q2)) {
            this.c(new y.c.y(q3), q2);
        }
        this.k.a(q4.f(), null, q4.f().d().g(), 0, 1);
        if (!i.g) return q3;
        a = ++n2;
        return q3;
    }

    public q b(i i2) {
        return this.a(this.e(i2));
    }

    public q b(q q2) {
        i i2 = null;
        i2 = q2 == null ? this.g() : (this.j(q2) ? this.m(q2) : q2.e());
        q q3 = this.h.a(i2, q2);
        this.c(q3);
        if (!this.k(q2)) return q3;
        this.c(new y.c.y(q3), q2);
        return q3;
    }

    public q c(i i2) {
        return this.b(this.e(i2));
    }

    public void c(q q2) {
        i i2 = q2.e();
        y.c.y y2 = null;
        boolean bl2 = this.j(q2);
        if (bl2) {
            y2 = new y.c.y(this.m(q2).o());
            this.a(this.m(q2), y2);
            this.g(q2);
        }
        this.a(new t(this, 6, q2.e(), (Object)q2));
        q q3 = (q)this.m.get(q2);
        if (!this.o.d(q3)) {
            this.o.a((Object)q3, true);
        }
        this.a(new t(this, 4, i2, (Object)q2));
        if (bl2) {
            this.c(y2, q2);
        }
        this.k.a(q3.f(), null, q3.f().d().g(), 0, 1);
    }

    public y.c.d a(q q2, q q3) {
        i i2 = q2.e();
        i i3 = q3.e();
        if (i2 == null) throw new IllegalArgumentException("Not all endpoints lie in a graph.");
        if (i3 == null) {
            throw new IllegalArgumentException("Not all endpoints lie in a graph.");
        }
        if (i2 == i3) {
            return i2.a(q2, q3);
        }
        i i4 = this.a(i2, i3);
        if (i4 == null) {
            throw new IllegalArgumentException("No common ancestor found.");
        }
        q q4 = this.a(q2, i4);
        q q5 = this.a(q3, i4);
        y.c.d d2 = i4.a(q4, q5);
        this.b(d2, q2, q3);
        return d2;
    }

    public void a(y.c.d d2, q q2, q q3) {
        Object object;
        q q4;
        i i2;
        int n2 = a;
        i i3 = d2.a();
        if (i3 != null && !this.d(i3)) {
            throw new IllegalArgumentException("Edge not in graph hierarchy.");
        }
        i i4 = q2.e();
        i i5 = q3.e();
        if (i4 == null) throw new IllegalArgumentException("Not all endpoints lie in a graph.");
        if (i5 == null) {
            throw new IllegalArgumentException("Not all endpoints lie in a graph.");
        }
        if (this.e(d2)) {
            if (i4 == i5) {
                this.b(i4, i3);
                this.a(d2);
                this.a(i3, i4, d2, q2, q3);
                this.c(i3, i4);
                if (n2 == 0) return;
            }
            if ((i2 = this.a(i4, i5)) == null) {
                throw new IllegalArgumentException("No common ancestor found.");
            }
            this.b(i2, i3);
            object = this.f(d2);
            q4 = this.a(q2, i2);
            q q5 = this.a(q3, i2);
            this.a(d2);
            this.a(i3, i2, d2, q4, q5);
            object.a = q2;
            object.b = q3;
            this.a(d2, 7);
            this.d.put(d2, object);
            this.a(d2, 5);
            this.c(i3, i2);
            if (n2 == 0) return;
        }
        if (i4 == i5) {
            this.b(i4, i3);
            this.a(i3, i4, d2, q2, q3);
            this.c(i3, i4);
            if (n2 == 0) return;
        }
        if ((i2 = this.a(i4, i5)) == null) {
            throw new IllegalArgumentException("No common ancestor found.");
        }
        this.b(i2, i3);
        object = this.a(q2, i2);
        q4 = this.a(q3, i2);
        this.a(i3, i2, d2, (q)object, q4);
        this.b(d2, q2, q3);
        this.c(i3, i2);
    }

    private void a(i i2, i i3, y.c.d d2, q q2, q q3) {
        if (i2 != i3 && i2 != null) {
            i2.a(d2);
        }
        i3.a(d2, q2, q3);
        if (i2 == i3) return;
        if (i2 == null) return;
        i3.b(d2);
    }

    private void b(i i2, i i3) {
        if (i2 != null) {
            i2.r();
        }
        if (i3 == null) return;
        i3.r();
    }

    private void c(i i2, i i3) {
        if (i2 != null) {
            i2.s();
        }
        if (i3 == null) return;
        i3.s();
    }

    private void a(y.c.d d2, byte by2) {
        this.a(new t(this, by2, d2.a(), (Object)d2));
    }

    public q a(q q2, i i2) {
        int n2 = a;
        if (q2.e() == i2) {
            return q2;
        }
        try {
            q q3;
            q q4 = this.e(q2.e());
            while (q4 != null) {
                q3 = q4;
                if (n2 != 0) return q3;
                if (q3.e() == i2) break;
                q4 = this.e(q4.e());
                if (n2 == 0) continue;
            }
            q3 = q4;
            return q3;
        }
        catch (RuntimeException var3_5) {
            throw new IllegalArgumentException("No representative of v in inGraph.");
        }
    }

    public void d(q q2) {
        this.b(q2, this.h(q2.e()));
    }

    public void b(q q2, i i2) {
        i i3 = q2.e();
        i3.r();
        boolean bl2 = this.k(q2);
        this.a(new t(this, 6, i3, (Object)q2));
        if (i2 instanceof bu) {
            ((bu)i2).a(this);
        }
        z z2 = new z(this, i2, q2);
        this.c.put(i2, z2);
        this.e.put(q2, z2);
        q q3 = (q)this.m.get(q2);
        this.l.put(i2, q3);
        if (bl2) {
            this.o.a((Object)q3, false);
        }
        this.a(new t(this, 4, i3, (Object)q2));
        this.k.a(q3.f(), null, q3.f().d().g(), 0, 1);
        i3.s();
    }

    public void e(q q2) {
        i i2 = q2.e();
        i2.r();
        y.c.y y2 = new y.c.y(this.p(q2));
        this.b(y2);
        this.d(q2);
        this.a(y2, q2);
        i2.s();
    }

    public void f(q q2) {
        i i2 = q2.e();
        i2.r();
        y.c.y y2 = new y.c.y(this.m(q2).o());
        this.a(this.m(q2), y2);
        this.c(q2);
        this.c(y2, q2);
        i2.s();
    }

    /*
     * Unable to fully structure code
     */
    public void g(q var1_1) {
        var4_2 = v.a;
        var2_3 = var1_1.e();
        this.a(new t(this, 6, var2_3, (Object)var1_1));
        if (!this.j(var1_1)) ** GOTO lbl-1000
        this.c.remove(this.q(var1_1).c());
        var3_4 = this.q(var1_1).c();
        if (var3_4 instanceof bu) {
            ((bu)var3_4).a((v)null);
        }
        this.e.remove(var1_1);
        if (var4_2 != 0) lbl-1000: // 2 sources:
        {
            if (this.k(var1_1) == false) throw new IllegalArgumentException("convertToNode. Node is already normal");
            var3_4 = this.m.get(var1_1);
            this.o.a(var3_4, false);
            if (var4_2 != 0) {
                throw new IllegalArgumentException("convertToNode. Node is already normal");
            }
        }
        var3_4 = this.s(var1_1);
        this.k.a(var3_4.f(), null, var3_4.f().d().i(), 0, 0);
        this.a(new t(this, 4, var2_3, (Object)var1_1));
    }

    public void b(y.c.d d2, q q2, q q3) {
        this.a(d2, 7);
        this.d.put(d2, new E(q2, q3));
        this.a(d2, 5);
    }

    public void a(y.c.d d2) {
        this.a(d2, 7);
        this.d.remove(d2);
        this.a(d2, 5);
    }

    public K a() {
        return this.j;
    }

    public void a(q q2, y y2) {
        this.b(this.s(q2), y2);
    }

    private void b(q q2, y y2) {
        int n2 = a;
        y.c.d d2 = q2.g();
        do {
            if (d2 == null) return;
            q q3 = d2.c();
            q q4 = (q)this.n.b(q3);
            y2.a(q4);
            if (q3.b() > 0 && !this.j(q4)) {
                this.b(q3, y2);
            }
            d2 = d2.h();
        } while (n2 == 0);
    }

    public Iterator h(q q2) {
        return new J(this, this.s(q2));
    }

    public Iterator b() {
        return new D(this, this.p);
    }

    public Iterator i(q q2) {
        return new D(this, this.s(q2));
    }

    public y.c.c c() {
        return this.r;
    }

    public y.c.c d() {
        return this.s;
    }

    public y.c.c e() {
        return this.t;
    }

    public q b(y.c.d d2) {
        return this.f(d2).a();
    }

    public q c(y.c.d d2) {
        return this.f(d2).b();
    }

    public boolean d(i i2) {
        if (this.i(i2) == null) return false;
        return true;
    }

    public x d(y.c.d d2) {
        E e2 = this.f(d2);
        if (e2 == null) {
            return null;
        }
        F f2 = new F(e2);
        return f2;
    }

    public boolean e(y.c.d d2) {
        if (this.d.get(d2) == null) return false;
        return true;
    }

    public boolean j(q q2) {
        if (this.e.get(q2) == null) return false;
        return true;
    }

    public boolean k(q q2) {
        return this.o.d(this.m.get(q2));
    }

    public boolean l(q q2) {
        if (this.o.d(this.m.get(q2))) return false;
        if (this.e.get(q2) != null) return false;
        return true;
    }

    public boolean f() {
        int n2 = a;
        y.c.x x2 = this.k.o();
        do {
            if (!x2.f()) return false;
            boolean bl2 = this.o.d(x2.e());
            if (n2 != 0) return bl2;
            if (bl2) {
                return true;
            }
            x2.g();
        } while (n2 == 0);
        return false;
    }

    public i m(q q2) {
        z z2 = this.q(q2);
        if (z2 == null) return this.f.c();
        return z2.c();
    }

    public q e(i i2) {
        return (q)this.n.b(this.l.get(i2));
    }

    public q n(q q2) {
        q q3 = (q)this.m.get(q2);
        q q4 = q3.f().d();
        return (q)this.n.b(q4);
    }

    public boolean b(q q2, q q3) {
        int n2 = a;
        if (q2 == null) {
            return true;
        }
        Object v2 = this.m.get(q2);
        q q4 = (q)this.m.get(q3);
        do {
            if (q4 == this.p) return false;
            if (v2 == q4) {
                return true;
            }
            q4 = q4.f().d();
        } while (n2 == 0);
        return false;
    }

    public i f(i i2) {
        return this.i(i2).a();
    }

    public i g() {
        return this.f.a;
    }

    public boolean g(i i2) {
        if (this.f.a != i2) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public Object[] a(Object var1_1) {
        var4_2 = v.a;
        var2_3 = new y.c.D();
        if (!(var1_1 instanceof q)) ** GOTO lbl-1000
        var1_1 = ((q)var1_1).e();
        if (var4_2 != 0) lbl-1000: // 2 sources:
        {
            if (!(var1_1 instanceof i)) {
                throw new IllegalArgumentException("argument neither instance of Graph nor of Node.");
            }
        }
        var3_4 = (q)this.l.get(var1_1);
        while (var3_4 != this.p) {
            var2_3.c(this.n.b(var3_4));
            var3_4 = var3_4.f().d();
            if (var4_2 != 0) return var2_3.toArray();
            if (var4_2 == 0) continue;
        }
        var2_3.c(this.g());
        return var2_3.toArray();
    }

    /*
     * Unable to fully structure code
     */
    public Object[] a(Object var1_1, boolean var2_2) {
        var5_3 = v.a;
        var3_4 = new y.c.D();
        if (!(var1_1 instanceof i)) ** GOTO lbl-1000
        var4_5 = (q)this.l.get(var1_1);
        if (var5_3 != 0) lbl-1000: // 2 sources:
        {
            var4_5 = (q)this.m.get(var1_1);
            if (!var2_2 && var4_5 != null) {
                var4_5 = var4_5.f().d();
            }
        }
        while (var4_5 != this.p && var4_5 != null) {
            var3_4.c(this.n.b(var4_5));
            var4_5 = var4_5.f().d();
            if (var5_3 == 0) continue;
        }
        var3_4.c(this.g());
        return var3_4.toArray();
    }

    public q a(y.c.y y2) {
        Object object;
        int n2 = a;
        y.c.y y3 = new y.c.y();
        y.c.x x2 = y2.a();
        while (x2.f()) {
            y3.add(this.m.get(x2.e()));
            object = x2;
            if (n2 != 0) return (q)object;
            object.g();
            if (n2 == 0) continue;
        }
        object = this.n.b(y.a.A.a(this.k, this.p, false, y3));
        return (q)object;
    }

    public i a(i i2, i i3) {
        i i4;
        Object object;
        int n2;
        int n3;
        block9 : {
            Object object2;
            int n4 = a;
            i4 = this.g();
            if (i2 == i3) {
                return i2;
            }
            if (i2 == i4) return i4;
            if (i3 == i4) {
                return i4;
            }
            y.c.D d2 = new y.c.D();
            z z2 = this.i(i2);
            if (z2 == null) {
                return i4;
            }
            d2.c(i2);
            while (z2.b != null) {
                object2 = z2.b.e();
                if (object2 == i3) {
                    return i3;
                }
                d2.c(object2);
                z2 = z2.b();
                if (n4 == 0) continue;
            }
            object2 = new y.c.D();
            z2 = this.i(i3);
            if (z2 == null) {
                return i4;
            }
            object2.c(i3);
            while (z2.b != null) {
                object = z2.b.e();
                if (object == i2) {
                    return i2;
                }
                object2.c(object);
                z2 = z2.b();
                if (n4 == 0) continue;
            }
            object = d2.toArray();
            Object[] arrobject = object2.toArray();
            n3 = 0;
            do {
                if (n3 >= object.length) return i4;
                n2 = n3;
                if (n4 != 0) break block9;
                if (n2 >= arrobject.length || object[n3] != arrobject[n3]) break;
                ++n3;
            } while (n4 == 0);
            n2 = n3;
        }
        if (n2 != 0) return (i)object[n3 - 1];
        return i4;
    }

    public int o(q q2) {
        int n2;
        int n3 = a;
        q q3 = this.s(q2);
        int n4 = 0;
        q3 = this.t(q3);
        while (q3 != this.p) {
            n2 = (int)this.j(this.r(q3)) ? 1 : 0;
            if (n3 != 0) return n2;
            if (n2 != 0) break;
            ++n4;
            q3 = this.t(q3);
            if (n3 == 0) continue;
        }
        n2 = n4;
        return n2;
    }

    public y.c.x p(q q2) {
        return new A(this, (q)this.m.get(q2));
    }

    public void a(u u2) {
        this.i.add(u2);
    }

    protected void a(t t2) {
        int n2 = a;
        if (this.i.isEmpty()) return;
        u[] arru = new u[this.i.size()];
        this.i.toArray(arru);
        int n3 = 0;
        do {
            if (n3 >= arru.length) return;
            arru[n3].a(t2);
            ++n3;
        } while (n2 == 0);
    }

    /*
     * Unable to fully structure code
     */
    public void a(y.c.y var1_1, q var2_2) {
        var13_3 = v.a;
        if (var1_1.isEmpty()) {
            return;
        }
        var3_4 = var2_2.e();
        var3_4.r();
        var4_5 = this.q(var2_2);
        var5_6 = var4_5.c();
        this.e(var1_1, this.n(var2_2));
        var1_1 = this.c(var1_1);
        var6_7 = var3_4.a(var1_1, var5_6);
        var7_8 = var6_7.a();
        while (var7_8.f()) {
            var8_9 = var7_8.a();
            var9_10 = this.f(var8_9);
            if (var13_3 != 0) return;
            if (var8_9.c() != var2_2 && var8_9.d() != var2_2) ** GOTO lbl50
            if (var9_10 != null && var9_10.a != var2_2 && var9_10.b != var2_2) ** GOTO lbl35
            var10_11 = var8_9.c();
            var11_12 = var8_9.d();
            if (var8_9.c() != var2_2) ** GOTO lbl28
            var3_4.a(var8_9, var8_9.c(), var2_2);
            var3_4.b(var8_9);
            this.g(var8_9);
            if (var9_10 == null) {
                this.b(var8_9, (q)var10_11, var11_12);
            }
            this.a(var8_9, var9_10 != null, (q)var10_11, var11_12);
            if (var13_3 == 0) ** GOTO lbl65
lbl28: // 2 sources:
            var3_4.a(var8_9, var2_2, var8_9.d());
            var3_4.b(var8_9);
            this.g(var8_9);
            if (var9_10 == null) {
                this.b(var8_9, (q)var10_11, var11_12);
            }
            this.a(var8_9, var9_10 != null, (q)var10_11, var11_12);
            if (var13_3 == 0) ** GOTO lbl65
lbl35: // 2 sources:
            var11_12 = var8_9.c();
            var12_13 = var8_9.d();
            if (var8_9.c() != var2_2) ** GOTO lbl44
            var10_11 = var4_5.a(var9_10.a());
            var4_5.a.a(var8_9, var10_11.b(), var8_9.d());
            var4_5.a.b(var8_9);
            this.g(var8_9);
            this.a(var8_9, true, var11_12, var12_13);
            if (var13_3 == 0) ** GOTO lbl65
lbl44: // 2 sources:
            var10_11 = var4_5.a(var9_10.b());
            var4_5.a.a(var8_9, var8_9.c(), var10_11.b());
            var4_5.a.b(var8_9);
            this.g(var8_9);
            this.a(var8_9, true, var11_12, var12_13);
            if (var13_3 == 0) ** GOTO lbl65
lbl50: // 2 sources:
            var10_11 = var8_9.c();
            var11_12 = var8_9.d();
            if (var10_11.e() == var3_4) ** GOTO lbl-1000
            var3_4.a(var8_9, var2_2, var11_12);
            var3_4.b(var8_9);
            this.g(var8_9);
            if (var13_3 != 0) lbl-1000: // 2 sources:
            {
                var3_4.a(var8_9, (q)var10_11, var2_2);
                var3_4.b(var8_9);
                this.g(var8_9);
            }
            if (var9_10 != null) ** GOTO lbl-1000
            this.b(var8_9, (q)var10_11, var11_12);
            this.a(var8_9, false, (q)var10_11, var11_12);
            if (var13_3 != 0) lbl-1000: // 2 sources:
            {
                this.a(var8_9, true, (q)var10_11, var11_12);
            }
lbl65: // 7 sources:
            var7_8.g();
            if (var13_3 == 0) continue;
        }
        var3_4.s();
    }

    /*
     * Unable to fully structure code
     */
    public void a(i var1_1, y.c.y var2_2) {
        block9 : {
            var15_3 = v.a;
            if (var2_2.isEmpty()) {
                return;
            }
            var3_4 = this.i(var1_1);
            var4_5 = var3_4.b();
            var5_6 = var4_5.c();
            var5_6.r();
            var2_2 = this.c(var2_2);
            var6_7 = var3_4.d();
            var7_8 = var1_1.a(var2_2, var5_6);
            var8_9 = new f(var6_7.j()).a();
            while (var8_9.f()) {
                var9_10 = var8_9.a();
                v0 = this.e(var9_10);
                if (var15_3 == 0) {
                    if (v0) {
                        var10_11 = var9_10.c();
                        var11_12 = var9_10.d();
                        if (var10_11 == var6_7 && (var14_15 = (var13_14 = var4_5.a((var12_13 = this.f(var9_10)).a())).b()) != var6_7) {
                            var5_6.a(var9_10);
                            var5_6.a(var9_10, var14_15, var9_10.d());
                            var5_6.b(var9_10);
                            this.g(var9_10);
                            this.a(var9_10, true, var10_11, var11_12);
                        }
                        if (var11_12 == var6_7 && (var12_13 = this.f(var9_10)) != null && (var13_14 = var4_5.a(var12_13.b()).b()) != var6_7) {
                            var5_6.a(var9_10);
                            var5_6.a(var9_10, var9_10.c(), (q)var13_14);
                            var5_6.b(var9_10);
                            this.g(var9_10);
                            this.a(var9_10, true, var10_11, var11_12);
                        }
                    }
                    var8_9.g();
                    if (var15_3 == 0) continue;
                }
                ** GOTO lbl37
            }
            var8_9 = var7_8.a();
            do {
                v0 = var8_9.f();
lbl37: // 2 sources:
                if (!v0) break;
                var9_10 = var8_9.a();
                var10_11 = var9_10.c();
                var11_12 = var9_10.d();
                v1 = var9_10.c().e();
                if (var15_3 != 0) break block9;
                if (v1 != var1_1) ** GOTO lbl-1000
                var5_6.a(var9_10, var6_7, var9_10.d());
                var5_6.b(var9_10);
                this.a(var9_10, var10_11, var11_12, var6_7, var9_10.d());
                this.a(var9_10, true, var10_11, var11_12);
                if (var15_3 != 0) lbl-1000: // 2 sources:
                {
                    if (var9_10.d().e() == var1_1) {
                        var5_6.a(var9_10, var9_10.c(), var6_7);
                        var5_6.b(var9_10);
                        this.a(var9_10, var10_11, var11_12, var9_10.c(), var6_7);
                        this.a(var9_10, true, var10_11, var11_12);
                    }
                }
                var8_9.g();
            } while (var15_3 == 0);
            v1 = var5_6;
        }
        v1.s();
    }

    public void b(y.c.y y2, q q2) {
        int n2 = a;
        y.c.x x2 = y2.a();
        do {
            if (!x2.f()) return;
            this.c(x2.e(), q2);
            x2.g();
        } while (n2 == 0);
    }

    public void c(q q2, q q3) {
        block8 : {
            v v2;
            int n2;
            q q4;
            i i2;
            i i3;
            block7 : {
                n2 = a;
                if (q2 == q3) {
                    throw new IllegalArgumentException("node may not be identical to parentNode");
                }
                if (this.b(q2, q3)) {
                    throw new IllegalArgumentException("node may not be an ancestor of parentNode");
                }
                i2 = q3 == null ? this.g() : (this.j(q3) ? this.m(q3) : q3.e());
                i i4 = q2.e();
                i3 = this.a(i2, i4);
                while (i4 != i3) {
                    v2 = this;
                    if (n2 == 0) {
                        v2.a(i4, new y.c.y(q2));
                        i4 = q2.e();
                        if (n2 == 0) continue;
                    }
                    break block7;
                }
                v2 = this;
            }
            Object[] arrobject = v2.a((Object)q3, true);
            int n3 = 0;
            i i5 = (i)arrobject[n3++];
            while (i5 != i3) {
                if (!this.j(q4 = (q)arrobject[n3++])) continue;
                i5 = this.m(q4);
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block8;
            }
            while (i5 != i2) {
                if (!this.j(q4 = (q)arrobject[n3++])) continue;
                this.a(new y.c.y(q2), q4);
                i5 = this.m(q4);
                if (n2 != 0) return;
                if (n2 == 0) continue;
            }
        }
        if (this.n(q2) == q3) return;
        this.c(new y.c.y(q2), q3);
    }

    public void c(y.c.y y2, q q2) {
        if (y2.isEmpty()) return;
        this.f(this.d(y2), q2);
    }

    public void b(y.c.y y2) {
        int n2 = a;
        if (y2.isEmpty()) {
            return;
        }
        y2 = this.d(y2);
        y.c.y y3 = new y.c.y();
        q q2 = this.n(y2.b());
        y.c.x x2 = y2.a();
        while (x2.f()) {
            q q3 = x2.e();
            q q4 = this.n(q3);
            if (n2 != 0) return;
            if (q4 != null && !this.j(q4)) {
                if (q4 != q2) {
                    if (q2 != null) {
                        this.f(y3, this.n(q2));
                    }
                    q2 = q4;
                    y3 = new y.c.y();
                }
                y3.add(q3);
            }
            x2.g();
            if (n2 == 0) continue;
        }
        if (y3.size() <= 0) return;
        this.c(y3, this.n(q2));
    }

    private i h(i i2) {
        return this.h.a(i2);
    }

    private z i(i i2) {
        return (z)this.c.get(i2);
    }

    private z q(q q2) {
        return (z)this.e.get(q2);
    }

    private E f(y.c.d d2) {
        return (E)this.d.get(d2);
    }

    private q r(q q2) {
        return (q)this.n.b(q2);
    }

    private q s(q q2) {
        return (q)this.m.get(q2);
    }

    private q j(i i2) {
        return (q)this.l.get(i2);
    }

    private q t(q q2) {
        return q2.f().d();
    }

    private y.c.y c(y.c.y y2) {
        y.c.y y3;
        boolean[] arrbl;
        int n2;
        Object object;
        block5 : {
            n2 = a;
            if (y2.isEmpty()) {
                return y2;
            }
            y3 = new y.c.y();
            i i2 = y2.b().e();
            arrbl = new boolean[i2.e()];
            object = y2.a();
            while (object.f()) {
                arrbl[object.e().d()] = true;
                object.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block5;
            }
            object = y2.a();
        }
        while (object.f()) {
            if (this.k(object.e()) && arrbl[object.e().d()]) {
                this.a(object.e(), arrbl, y3);
            }
            object.g();
            if (n2 == 0) continue;
        }
        object = null;
        if (y3.size() <= 0) return y2;
        object = new y.c.y(y2.a());
        object.a(y3);
        return object;
    }

    private void a(q q2, boolean[] arrbl, y.c.y y2) {
        int n2 = a;
        y.c.x x2 = this.p(q2);
        do {
            if (!x2.f()) return;
            q q3 = x2.e();
            if (!arrbl[q3.d()]) {
                y2.add(q3);
            }
            if (this.k(q3)) {
                this.a(q3, arrbl, y2);
            }
            x2.g();
        } while (n2 == 0);
    }

    private y.c.y d(y.c.y y2) {
        return this.d(y2, null);
    }

    private y.c.y d(y.c.y y2, q q2) {
        int n2;
        boolean[] arrbl;
        y.c.y y3;
        y.c.x x2;
        block6 : {
            n2 = a;
            y3 = new y.c.y();
            arrbl = new boolean[this.k.e()];
            x2 = y2.a();
            while (x2.f()) {
                arrbl[this.s((q)x2.e()).d()] = true;
                x2.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block6;
            }
            q2 = this.s(q2);
        }
        x2 = y2.a();
        do {
            boolean bl2;
            block7 : {
                if (!x2.f()) return y3;
                q q3 = this.s(x2.e());
                q q4 = this.t(q3);
                while (q4 != q2) {
                    bl2 = arrbl[q4.d()];
                    if (n2 == 0) {
                        if (bl2) break;
                        q4 = this.t(q4);
                        if (n2 == 0) continue;
                    }
                    break block7;
                }
                bl2 = arrbl[q4.d()];
            }
            if (!bl2) {
                y3.add(x2.e());
            }
            x2.g();
        } while (n2 == 0);
        return y3;
    }

    private void e(y.c.y y2, q q2) {
        q q3;
        boolean[] arrbl;
        y.c.x x2;
        q q4;
        int n2;
        block6 : {
            n2 = a;
            i i2 = null;
            i2 = q2 == null ? this.g() : (this.j(q2) ? this.m(q2) : q2.e());
            q4 = this.s(q2);
            q3 = this.j(i2);
            arrbl = new boolean[i2.e()];
            x2 = y2.a();
            while (x2.f()) {
                arrbl[x2.e().d()] = true;
                x2.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block6;
            }
            x2 = y2.a();
        }
        do {
            if (!x2.f()) return;
            q q5 = x2.e();
            q q6 = this.t(this.s(q5));
            boolean bl2 = true;
            block2 : do {
                q q7 = q6;
                q q8 = q4;
                while (q7 != q8) {
                    q7 = q6;
                    q8 = q3;
                    if (n2 != 0) continue;
                    if (q7 == q8) break block2;
                    q q9 = this.r(q6);
                    bl2 = arrbl[q9.d()];
                    q6 = this.t(q6);
                    if (n2 == 0) continue block2;
                }
                break block2;
                break;
            } while (true);
            if (!bl2) {
                this.c(new y.c.y(q5), q2);
            }
            x2.g();
        } while (n2 == 0);
    }

    private void f(y.c.y y2, q q2) {
        boolean bl2;
        q q3;
        y.c.y y3;
        block7 : {
            int n2 = a;
            if (y2.isEmpty()) {
                return;
            }
            q q4 = this.s(q2);
            q3 = this.n(y2.b());
            y3 = new y.c.y();
            y.c.x x2 = y2.a();
            while (x2.f()) {
                q q5 = x2.e();
                q q6 = this.s(q5);
                q q7 = this.n(q5);
                y.c.d d2 = q6.f();
                bl2 = this.j(q5);
                if (n2 == 0) {
                    block6 : {
                        if (bl2 || this.k(q5)) {
                            this.k.a(d2, q6, (y.c.d)null, 1, q4, q4.g(), 1);
                            if (n2 == 0) break block6;
                        }
                        this.k.a(d2, q6, (y.c.d)null, 1, q4, q4.i(), 0);
                    }
                    if (q3 != q7) {
                        this.a(new t(this, 8, q3, (Object)y3));
                        q3 = q7;
                        y3 = new y.c.y();
                    }
                    y3.add(q5);
                    x2.g();
                    if (n2 == 0) continue;
                }
                break block7;
            }
            bl2 = y3.isEmpty();
        }
        if (bl2) return;
        this.a(new t(this, 8, q3, (Object)y3));
    }

    private void g(y.c.d d2) {
        E e2 = this.f(d2);
        if (e2 == null) {
            return;
        }
        if (d2.c() != e2.a()) return;
        if (d2.d() != e2.b()) return;
        this.a(d2);
    }

    private void a(y.c.d d2, q q2, q q3, q q4, q q5) {
        E e2 = this.f(d2);
        if (e2 != null) {
            if (d2.c() != e2.a()) return;
            if (d2.d() != e2.b()) return;
            this.a(d2);
            return;
        }
        if (q2 == q4) {
            if (q3 == q5) return;
        }
        this.b(d2, q2, q3);
    }

    private void a(y.c.d d2, boolean bl2, q q2, q q3) {
        K k2 = this.a();
        if (k2 == null) return;
        k2.a(d2, bl2, q2, q3);
    }

    static int a(v v2) {
        return ++v2.q;
    }

    static z a(v v2, i i2) {
        return v2.i(i2);
    }

    static Map b(v v2) {
        return v2.m;
    }

    static i c(v v2) {
        return v2.k;
    }

    static Map d(v v2) {
        return v2.l;
    }

    static y.c.A e(v v2) {
        return v2.n;
    }

    static q a(v v2, q q2) {
        return v2.s(q2);
    }

    static y.c.y a(v v2, y.c.y y2) {
        return v2.d(y2);
    }

    static q b(v v2, q q2) {
        return v2.t(q2);
    }

    static q c(v v2, q q2) {
        return v2.r(q2);
    }

    static E a(v v2, y.c.d d2) {
        return v2.f(d2);
    }

    static int f(v v2) {
        return v2.q;
    }
}

