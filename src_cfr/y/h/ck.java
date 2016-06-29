/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;
import y.c.C;
import y.c.e;
import y.c.q;
import y.h.aA;
import y.h.aB;
import y.h.b.a;
import y.h.b.c;
import y.h.b.d;
import y.h.b.f;
import y.h.b.g;
import y.h.b.i;
import y.h.bu;
import y.h.ch;
import y.h.cm;
import y.h.eR;
import y.h.eU;
import y.h.fj;
import y.h.gZ;
import y.h.gd;
import y.h.x;
import y.h.y;

public class cK
extends AbstractAction {
    private final ch a;
    private int b;
    private int c;
    private boolean d;

    public cK() {
        this(null);
    }

    public cK(ch ch2) {
        super(cm.h.toString());
        this.a = ch2;
        this.b = 123;
        this.c = 9;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.d;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ch ch2 = this.a(actionEvent);
        if (ch2 == null) return;
        this.a(ch2);
        ch2.getGraph2D().T();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(ch ch2) {
        bu bu2 = ch2.getGraph2D();
        bu2.r();
        try {
            this.b(bu2);
            return;
        }
        finally {
            bu2.s();
        }
    }

    private void b(bu bu2) {
        this.a(bu2, this.a(this.a(bu2)));
    }

    /*
     * Unable to fully structure code
     */
    protected int a(int var1_1) {
        var3_2 = fj.z;
        if (this.c()) {
            var2_3 = var1_1;
            if (var2_3 == 0) {
                var2_3 = this.a();
                if (var3_2 == false) return var2_3 & this.b();
            }
            if ((var2_3 & 9) != var2_3) return var2_3 & this.b();
            var2_3 = 9;
            return var2_3 & this.b();
        }
        var2_4 = var1_1;
        if (var2_4 == 0) {
            var2_4 = this.a();
        }
        if ((var2_4 & 2) != 2) ** GOTO lbl16
        var2_4 = 2;
        if (!var3_2) ** GOTO lbl20
lbl16: // 2 sources:
        if ((var2_4 & 9) == 0) ** GOTO lbl-1000
        var2_4 = 9;
        if (var3_2) lbl-1000: // 2 sources:
        {
            var2_4 = cK.b(var2_4);
        }
lbl20: // 4 sources:
        if ((var2_4 & 48) == 0) return var2_4 & this.b();
        var2_4 = 48;
        return var2_4 & this.b();
    }

    private static int b(int n2) {
        return n2 & - n2;
    }

    protected void a(bu bu2, int n2) {
        boolean bl2 = fj.z;
        C c2 = bu2.o();
        while (c2.f()) {
            this.a(bu2, c2.e(), n2);
            c2.g();
            if (!bl2) continue;
        }
        c2 = bu2.p();
        do {
            if (!c2.f()) return;
            this.a(bu2, c2.a(), n2);
            c2.g();
        } while (!bl2);
    }

    protected void a(bu bu2, y.c.d d2, int n2) {
        boolean bl2 = fj.z;
        boolean bl3 = (n2 & 2) == 2;
        boolean bl4 = (n2 & 32) == 32;
        boolean bl5 = (n2 & 8) == 8;
        this.a(bu2, d2, bl3);
        aB aB2 = bu2.i(d2);
        if (aB2.labelCount() > 0) {
            int n3 = aB2.labelCount();
            for (int i2 = 0; i2 < n3; ++i2) {
                this.a(bu2, aB2.getLabel(i2), bl4);
                if (bl2) return;
                if (!bl2) continue;
            }
        }
        if (aB2.bendCount() <= 0) return;
        y y2 = aB2.bends();
        do {
            if (!y2.f()) return;
            this.a(bu2, y2.a(), bl5);
            y2.g();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    protected void a(bu var1_1, q var2_2, int var3_3) {
        block7 : {
            var12_4 = fj.z;
            var4_5 = (var3_3 & 1) == 1;
            var5_6 = (var3_3 & 16) == 16;
            var6_7 = (var3_3 & 64) == 64;
            var7_8 = (var3_3 & 16384) == 16384;
            var8_9 = (var3_3 & 32768) == 32768;
            this.a(var1_1, var2_2, var4_5);
            var9_10 = var1_1.t(var2_2);
            if (var9_10.labelCount() > 0) {
                var11_14 = var9_10.labelCount();
                for (var10_11 = 0; var10_11 < var11_14; ++var10_11) {
                    this.a(var1_1, var9_10.getLabel(var10_11), var5_6);
                    if (!var12_4) {
                        if (!var12_4) continue;
                    }
                    break block7;
                }
            }
            if (var9_10.portCount() <= 0) ** GOTO lbl23
            var10_12 = var9_10.ports();
            while (var10_12.hasNext()) {
                this.a(var1_1, (eU)var10_12.next(), var6_7);
                if (!var12_4) {
                    if (!var12_4) continue;
                }
                ** GOTO lbl-1000
            }
        }
        if (var9_10 instanceof gd) {
            v0 = ((gd)var9_10).e();
        } else lbl-1000: // 2 sources:
        {
            v0 = var9_10;
        }
        var10_13 = v0;
        if (var10_13 instanceof a == false) return;
        var11_15 = ((a)var10_13).l();
        this.a(var1_1, var11_15, var7_8);
        this.a(var1_1, var11_15, var8_9);
    }

    private void a(bu bu2, d d2, boolean bl2) {
        boolean bl3 = fj.z;
        int n2 = 0;
        int n3 = d2.k();
        do {
            if (n2 >= n3) return;
            c c2 = d2.b(n2);
            this.a(bu2, c2, bl2);
            if (c2.k() > 0) {
                this.a(bu2, (d)c2, bl2);
            }
            ++n2;
        } while (!bl3);
    }

    private void a(bu bu2, g g2, boolean bl2) {
        boolean bl3 = fj.z;
        int n2 = 0;
        int n3 = g2.n();
        do {
            if (n2 >= n3) return;
            f f2 = g2.c(n2);
            this.a(bu2, f2, bl2);
            if (f2.n() > 0) {
                this.a(bu2, (g)f2, bl2);
            }
            ++n2;
        } while (!bl3);
    }

    protected int a(bu bu2) {
        int n2;
        C c2;
        boolean bl2 = fj.z;
        int n3 = 0;
        int n4 = this.b();
        if ((n4 & 49233) != 0) {
            c2 = bu2.o();
            while (c2.f()) {
                n3 |= this.a(bu2, c2.e());
                c2.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break;
            }
        } else if ((n4 & 42) != 0) {
            c2 = bu2.p();
            while (c2.f()) {
                n2 = n3 | this.a(bu2, c2.a());
                if (bl2) return n2;
                n3 = n2;
                c2.g();
                if (!bl2) continue;
            }
        }
        n2 = n3 & n4;
        return n2;
    }

    protected int a(bu bu2, y.c.d d2) {
        int n2;
        int n3;
        boolean bl2 = fj.z;
        int n4 = 0;
        if (this.b(bu2, d2)) {
            n4 |= 2;
        }
        aB aB2 = bu2.i(d2);
        if ((n4 & 32) != 32 && aB2.labelCount() > 0) {
            int n5 = aB2.labelCount();
            for (int i2 = 0; i2 < n5; ++i2) {
                n2 = (int)this.a(bu2, aB2.getLabel(i2)) ? 1 : 0;
                if (!bl2) {
                    if (n2 == 0) continue;
                    n4 |= 32;
                    if (!bl2) break;
                    if (!bl2) continue;
                }
                break;
            }
        } else {
            n2 = n4 & 8;
        }
        if (n2 != 8 && aB2.bendCount() > 0) {
            y y2 = aB2.bends();
            while (y2.f()) {
                n3 = (int)this.a(bu2, y2.a()) ? 1 : 0;
                if (bl2) return n3;
                if (n3 != 0) {
                    n4 |= 8;
                    if (!bl2) break;
                }
                y2.g();
                if (!bl2) continue;
            }
        }
        n3 = n4;
        return n3;
    }

    protected int a(bu bu2, q q2) {
        int n2;
        boolean bl2 = fj.z;
        int n3 = 0;
        if (this.b(bu2, q2)) {
            n3 |= true;
        }
        fj fj2 = bu2.t(q2);
        if ((n3 & 16) != 16 && fj2.labelCount() > 0) {
            int n4 = fj2.labelCount();
            for (int i2 = 0; i2 < n4; ++i2) {
                n2 = (int)this.a(bu2, fj2.getLabel(i2)) ? 1 : 0;
                if (!bl2) {
                    if (n2 == 0) continue;
                    n3 |= 16;
                    if (!bl2) break;
                    if (!bl2) continue;
                }
                break;
            }
        } else {
            n2 = n3 & 64;
        }
        if (n2 != 64 && fj2.portCount() > 0) {
            Iterator iterator = fj2.ports();
            while (iterator.hasNext()) {
                if (!this.a(bu2, (eU)iterator.next())) continue;
                n3 |= 64;
                if (bl2) return n3;
                break;
            }
        }
        if ((this.b() & 49152) == 0) return n3;
        fj fj3 = fj2 instanceof gd ? ((gd)fj2).e() : fj2;
        if (!(fj3 instanceof a)) return n3;
        i i3 = ((a)fj3).l();
        if ((n3 & 16384) != 16384 && this.a(bu2, i3)) {
            n3 |= 16384;
        }
        if ((n3 & 32768) == 32768) return n3;
        if (!this.a(bu2, i3)) return n3;
        n3 |= 32768;
        return n3;
    }

    private boolean a(bu bu2, d d2) {
        boolean bl2 = fj.z;
        int n2 = 0;
        int n3 = d2.k();
        do {
            if (n2 >= n3) return false;
            c c2 = d2.b(n2);
            boolean bl3 = this.a(bu2, c2);
            if (bl2) return bl3;
            if (bl3) {
                return true;
            }
            if (c2.k() > 0 && this.a(bu2, (d)c2)) {
                return true;
            }
            ++n2;
        } while (!bl2);
        return false;
    }

    private boolean a(bu bu2, g g2) {
        boolean bl2 = fj.z;
        int n2 = 0;
        int n3 = g2.n();
        do {
            if (n2 >= n3) return false;
            f f2 = g2.c(n2);
            boolean bl3 = this.a(bu2, f2);
            if (bl2) return bl3;
            if (bl3) {
                return true;
            }
            if (f2.n() > 0 && this.a(bu2, (g)f2)) {
                return true;
            }
            ++n2;
        } while (!bl2);
        return false;
    }

    protected void a(bu bu2, eU eU2, boolean bl2) {
        bu2.a(eU2, bl2);
    }

    protected void a(bu bu2, q q2, boolean bl2) {
        bu2.a(q2, bl2);
    }

    protected void a(bu bu2, y.c.d d2, boolean bl2) {
        bu2.a(d2, bl2);
    }

    protected void a(bu bu2, gZ gZ2, boolean bl2) {
        bu2.a(gZ2, bl2);
    }

    protected void a(bu bu2, x x2, boolean bl2) {
        bu2.a(x2, bl2);
    }

    protected void a(bu bu2, c c2, boolean bl2) {
        c2.a(bl2);
    }

    protected void a(bu bu2, f f2, boolean bl2) {
        f2.a(bl2);
    }

    protected boolean a(bu bu2, x x2) {
        return bu2.a(x2);
    }

    protected boolean a(bu bu2, gZ gZ2) {
        return bu2.a(gZ2);
    }

    protected boolean b(bu bu2, y.c.d d2) {
        return bu2.r(d2);
    }

    protected boolean b(bu bu2, q q2) {
        return bu2.v(q2);
    }

    protected boolean a(bu bu2, eU eU2) {
        return bu2.a(eU2);
    }

    protected boolean a(bu bu2, c c2) {
        return c2.e();
    }

    protected boolean a(bu bu2, f f2) {
        return f2.e();
    }

    protected ch a(ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }
}

