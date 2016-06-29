/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import java.util.ArrayList;
import y.a.ag;
import y.a.h;
import y.c.A;
import y.c.a;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.g.M;
import y.g.a.f;

class ai {
    i e;
    y.c.h f;
    A g;
    int h;
    ArrayList i;
    private final f a;
    private final y.c.h b;
    private final ag c;

    ai(ag ag2, i i2) {
        this.c = ag2;
        this.e = i2;
        this.f = i2.u();
        this.b = i2.u();
        this.a = new f(i2.g(), this.b, this.b);
        this.g = M.a(new int[i2.e()]);
        this.h = 0;
        this.i = new ArrayList();
    }

    void a() {
        this.a.d();
        this.e.a(this.f);
        this.e.a(this.b);
        this.e = null;
    }

    void b(y y2) {
        x x2;
        boolean bl2;
        block6 : {
            bl2 = h.a;
            x2 = y2.a();
            while (x2.f()) {
                this.g.a((Object)x2.e(), this.h);
                x2.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block6;
            }
            this.i.add(y2);
        }
        if (y2.size() > Math.max(ag.c(this.c), 1)) {
            ag.a(this.c).a(this.e, y2, this.f);
            x2 = y2.a();
            while (x2.f()) {
                block7 : {
                    for (d d2 = x2.e().f(); d2 != null; d2 = d2.g()) {
                        this.a.a(d2, - this.f.c(d2));
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block7;
                    }
                    x2.g();
                }
                if (!bl2) continue;
            }
        }
        ++this.h;
    }

    /*
     * Unable to fully structure code
     */
    y[] a(y var1_1, A var2_2) {
        block6 : {
            block5 : {
                var9_3 = h.a;
                var3_4 = 2;
                var4_5 = new y[var3_4];
                for (var5_6 = 0; var5_6 < var3_4; ++var5_6) {
                    var4_5[var5_6] = new y();
                    if (!var9_3) {
                        if (!var9_3) continue;
                    }
                    break block5;
                }
                var5_6 = this.g.a(var1_1.b());
            }
            var6_7 = this.h;
            var7_8 = var1_1.a();
            while (var7_8.f()) {
                v0 = var8_10 = var2_2.a(var7_8.e());
                if (var9_3) break block6;
                if (v0 <= 0) ** GOTO lbl-1000
                var4_5[1].b(var7_8.e());
                this.g.a((Object)var7_8.e(), var6_7);
                if (var9_3) lbl-1000: // 2 sources:
                {
                    var4_5[0].b(var7_8.e());
                    this.g.a((Object)var7_8.e(), var5_6);
                }
                var7_8.g();
                if (!var9_3) continue;
            }
            this.i.add(new y());
            ++this.h;
            v0 = 0;
        }
        var7_9 = v0;
        do {
            if (var7_9 >= var3_4) return var4_5;
            this.c(var4_5[var7_9]);
            ++var7_9;
        } while (!var9_3);
        return var4_5;
    }

    void c(y y2) {
        this.i.set(this.g.a(y2.b()), y2);
        if (y2.size() > Math.max(ag.c(this.c), 1)) {
            this.a(y2);
            if (!h.a) return;
        }
        this.d(y2);
    }

    void a(y y2) {
        boolean bl2 = h.a;
        ag.a(this.c).a(this.e, y2, this.f);
        x x2 = y2.a();
        block0 : do {
            if (!x2.f()) return;
            for (d d2 = x2.e().f(); d2 != null; d2 = d2.g()) {
                this.a(d2);
                if (bl2) continue block0;
                if (!bl2) continue;
            }
            x2.g();
        } while (!bl2);
    }

    void a(d d2) {
        if (ag.d(this.c) && this.c(d2)) {
            this.a.c(d2, Double.MAX_VALUE);
            if (!h.a) return;
        }
        this.a.c(d2, - this.f.c(d2));
    }

    void d(y y2) {
        boolean bl2 = h.a;
        x x2 = y2.a();
        block0 : do {
            if (!x2.f()) return;
            for (d d2 = x2.e().f(); d2 != null; d2 = d2.g()) {
                this.a.b(d2);
                if (bl2) continue block0;
                if (!bl2) continue;
            }
            x2.g();
        } while (!bl2);
    }

    void b(d d2) {
        boolean bl2;
        int n2;
        e e2;
        block6 : {
            bl2 = h.a;
            if (!ag.d(this.c)) {
                return;
            }
            if (d2.c().a() != 2) return;
            e2 = d2.c().j();
            while (e2.f()) {
                n2 = (int)e2.a().equals(d2) ? 1 : 0;
                if (!bl2) {
                    if (n2 == 0) {
                        this.a.c(e2.a(), Double.MAX_VALUE);
                    }
                    e2.g();
                    if (!bl2) continue;
                }
                break block6;
            }
            n2 = d2.d().a();
        }
        if (n2 != 2) return;
        e2 = d2.d().j();
        do {
            if (!e2.f()) return;
            if (!e2.a().equals(d2)) {
                this.a.c(e2.a(), Double.MAX_VALUE);
            }
            e2.g();
        } while (!bl2);
    }

    d b() {
        d d2;
        d d3;
        ai ai2;
        block2 : {
            boolean bl2 = h.a;
            d3 = (d)this.a.a();
            while (ag.d(this.c)) {
                ai2 = this;
                d2 = d3;
                if (!bl2) {
                    if (!ai2.c(d2) || !this.c()) break;
                    this.a.a(d3, Double.MAX_VALUE);
                    d3 = (d)this.a.a();
                    if (!bl2) continue;
                }
                break block2;
            }
            ai2 = this;
            d2 = d3;
        }
        ai2.b(d2);
        return d3;
    }

    boolean c() {
        if (this.a.c()) return false;
        if (this.a.b() >= 1.0) return false;
        return true;
    }

    boolean c(d d2) {
        if (d2.c().a() < 2) return true;
        if (d2.d().a() < 2) return true;
        return false;
    }

    y a(q q2) {
        return (y)this.i.get(this.g.a(q2));
    }

    int d() {
        return this.h;
    }

    A e() {
        return this.g;
    }
}

