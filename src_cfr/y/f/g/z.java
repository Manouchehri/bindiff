/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import java.awt.geom.Rectangle2D;
import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.X;
import y.f.ae;
import y.f.b.c;
import y.f.g.b;
import y.f.g.d;
import y.f.g.u;

class z {
    z() {
    }

    public SortedSet a(X x2, y y2, y y3, b b2, t t2, boolean bl2) {
        boolean bl3 = d.d;
        TreeSet<u> treeSet = new TreeSet<u>(u.a);
        c c2 = new c(x2);
        Rectangle2D rectangle2D = ae.a(x2, y3.a());
        Rectangle2D rectangle2D2 = ae.a(x2, y2.a());
        HashSet<Double> hashSet = new HashSet<Double>();
        HashSet<Double> hashSet2 = new HashSet<Double>();
        double d2 = rectangle2D2.getMinX() - (double)x2.f() * rectangle2D.getWidth();
        double d3 = rectangle2D2.getMaxX() + (double)x2.f() * rectangle2D.getWidth();
        double d4 = rectangle2D2.getMinY() - (double)x2.f() * rectangle2D.getHeight();
        double d5 = rectangle2D2.getMaxY() + (double)x2.f() * rectangle2D.getHeight();
        boolean bl4 = false;
        x x3 = y3.a();
        block0 : do {
            boolean bl5 = x3.f();
            block1 : while (bl5) {
                q q2 = x3.e();
                if (bl3) return treeSet;
                x x4 = y2.a();
                while (x4.f()) {
                    double d6;
                    double d7;
                    q q3 = x4.e();
                    double d8 = x2.k(q3) - x2.k(q2);
                    bl5 = hashSet.add(new Double(d8));
                    if (bl3) continue block1;
                    if (bl5 && (d6 = rectangle2D.getCenterY() + d8) >= b2.d() && d6 <= b2.d() + b2.b()) {
                        int n2;
                        block8 : {
                            if (bl2) {
                                n2 = (int)Math.abs(x2.k(q3) - t2.b());
                                if (!bl3) break block8;
                            }
                            n2 = (int)t.a(x2.l(q3), t2);
                        }
                        bl4 = true;
                        treeSet.add(new u(new t(d2, d6), new t(d3, d6), n2));
                    }
                    if (hashSet2.add(new Double(d6 = x2.j(q3) - x2.j(q2))) && (d7 = rectangle2D.getCenterX() + d6) >= b2.c() && d7 <= b2.c() + b2.a()) {
                        int n3 = (int)t.a(x2.l(q3), t2);
                        treeSet.add(new u(new t(d7, d4), new t(d7, d5), n3));
                    }
                    x4.g();
                    if (!bl3) continue;
                }
                x3.g();
                if (!bl3) continue block0;
            }
            break block0;
            break;
        } while (true);
        if (!bl4 && bl2) {
            double d9 = b2.f().b();
            int n4 = (int)Math.abs(d9 - t2.b());
            treeSet.add(new u(new t(d2, d9), new t(d3, d9), n4));
        }
        c2.c();
        return treeSet;
    }
}

