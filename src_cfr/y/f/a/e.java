/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import java.io.PrintStream;
import y.c.d;
import y.c.q;
import y.d.g;
import y.d.m;
import y.d.o;
import y.d.y;
import y.f.a.B;
import y.f.a.D;
import y.f.a.f;
import y.f.a.z;

class E
implements g {
    private boolean a;
    private boolean b;
    private final z c;

    public E(z z2, boolean bl2) {
        this.c = z2;
        this.b = bl2;
        this.a = false;
        if (!bl2) return;
        z.b(z2).clear();
    }

    public boolean a() {
        return this.a;
    }

    private boolean a(D d2) {
        if (z.b(this.c).containsKey(d2)) return false;
        return true;
    }

    @Override
    public void a(Object object, Object object2) {
        m m2;
        Object object3;
        Object object4;
        int n2 = f.u;
        B b2 = (B)object;
        B b3 = (B)object2;
        if (!y.a(b2.h(), b3.h())) {
            return;
        }
        D d2 = new D(this.c, b2, b3);
        if (b2.g() || b3.g()) {
            if (b2.g() && b3.g()) {
                if (this.b) {
                    z.b(this.c).put(d2, d2);
                    if (n2 == 0) return;
                }
                if (!this.a(d2)) return;
                this.a = true;
                if (n2 == 0) return;
            }
            if (b2.e() || b3.e()) {
                object3 = b2.e() ? b2 : b3;
                object4 = b2.g() ? b2 : b3;
                if (!z.a(this.c, (B)object3, (B)object4)) return;
                if (this.b) {
                    z.b(this.c).put(d2, d2);
                    if (n2 == 0) return;
                }
                if (!this.a(d2)) return;
                this.a = true;
                if (n2 == 0) return;
            }
            object3 = b2.g() ? b2 : b3;
            Object object5 = object4 = b2.g() ? b3 : b2;
            if (!z.b(this.c, b2, b3)) {
                if (!this.b) return;
            }
            if (!(m2 = (m)object4.j()).a(object3.j().h())) return;
            if (this.b) {
                z.b(this.c).put(d2, d2);
                if (n2 == 0) return;
            }
            if (!this.a(d2)) return;
            this.a = true;
            if (n2 == 0) return;
        }
        if (b2.e() && b3.e()) {
            if (!z.b(this.c, b2, b3)) {
                if (!this.b) return;
            }
            if (!z.c(this.c, b2, b3)) return;
            if (this.b) {
                z.b(this.c).put(d2, d2);
                if (n2 == 0) return;
            }
            if (!this.a(d2)) return;
            this.a = true;
            if (n2 == 0) return;
        }
        if (b2.f() && b3.f()) {
            m m3;
            object3 = (d)b2.i();
            if (object3 == (object4 = (d)b3.i())) return;
            if (!z.b(this.c, b2, b3)) {
                if (!this.b) return;
            }
            if (m.a(m2 = (m)b2.j(), m3 = (m)b3.j()) == null) return;
            if (this.b) {
                z.b(this.c).put(d2, d2);
                if (n2 == 0) return;
            }
            if (!this.a(d2)) return;
            this.a = true;
            if (n2 == 0) return;
        }
        if (b2.e() && b3.f() || b2.f() && b3.e()) {
            object3 = (q)(b2.e() ? b2.i() : b3.i());
            object4 = (d)(b2.f() ? b2.i() : b3.i());
            if (object4.c() == object3) return;
            if (object4.d() == object3) return;
            if (!z.b(this.c, b2, b3)) {
                if (!this.b) return;
            }
            m2 = (m)(b2.f() ? b2.j() : b3.j());
            if (!z.a(this.c, (q)object3, m2)) return;
            if (this.b) {
                z.b(this.c).put(d2, d2);
                if (n2 == 0) return;
            }
            if (!this.a(d2)) return;
            this.a = true;
            if (n2 == 0) return;
        }
        System.out.println("unhandled case detected");
    }
}

