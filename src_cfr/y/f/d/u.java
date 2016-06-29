/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.awt.geom.Rectangle2D;
import java.util.Comparator;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.i;
import y.d.m;
import y.d.n;
import y.d.q;
import y.d.t;
import y.f.C;
import y.f.E;
import y.f.I;
import y.f.K;
import y.f.M;
import y.f.R;
import y.f.X;
import y.f.aG;
import y.f.aj;
import y.f.al;
import y.f.am;
import y.f.b.c;
import y.f.b.f;
import y.f.d.a;
import y.f.d.v;
import y.f.d.w;
import y.f.d.x;
import y.f.d.y;
import y.f.d.z;

class u {
    private X a;
    private D b;
    private double c = 15.0;
    private double d = 60.0;
    private double e = 5.0;
    private boolean f = true;
    private boolean g = true;
    private boolean h = true;
    private c i;

    u() {
    }

    public void a(boolean bl2) {
        this.h = bl2;
    }

    public void a(double d2) {
        this.e = d2;
    }

    public void b(boolean bl2) {
        this.g = bl2;
    }

    public void c(boolean bl2) {
        this.f = bl2;
    }

    public void b(double d2) {
        this.d = d2;
    }

    public void c(double d2) {
        this.c = d2;
    }

    public void a(X x2, y.c.c c2) {
        int n2 = a.f;
        this.a = x2;
        if (x2.c(f.d) != null) {
            this.i = new c(x2);
        }
        this.a(c2);
        D d2 = this.d(this.g);
        d2.sort(new v(this));
        y.c.C c3 = d2.m();
        while (c3.f()) {
            z z2 = (z)c3.d();
            this.c(z2);
            c3.g();
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        if (this.i == null) return;
        this.i.c();
        this.i = null;
    }

    private boolean a(aj aj2) {
        al al2 = aj2.a();
        return al2 instanceof M;
    }

    private boolean a(C c2) {
        E e2 = c2.getLabelModel();
        return e2 instanceof K;
    }

    private boolean a(y.c.q q2, aj aj2) {
        y.d.y y2 = this.a(aj2, q2);
        if (!this.a.s(q2).b(y2)) return false;
        if (aj2 instanceof M) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private void a(y.c.c var1_1) {
        block9 : {
            var11_2 = a.f;
            this.b = new D();
            var2_3 = this.a.o();
            while (var2_3.f()) {
                var3_4 = var2_3.e();
                v0 = this;
                if (var11_2 == 0) {
                    if (v0.i == null || !this.i.d(var3_4)) {
                        this.b.add(new z(this, var3_4, var3_4, 0, false));
                        var4_7 = this.a.a_(var3_4);
                        for (var5_8 = 0; var5_8 < var4_7.length; ++var5_8) {
                            var6_11 = var4_7[var5_8];
                            if (var11_2 == 0) {
                                var7_12 = (var1_1 == null || var1_1.d(var6_11) != false) && this.a((aj)var6_11) != false && this.a(var3_4, (aj)var6_11) == false;
                                this.b.add(new z(this, var6_11, var3_4, 2, var7_12));
                                if (var11_2 == 0) continue;
                            }
                            break;
                        }
                    } else {
                        var2_3.g();
                    }
                    if (var11_2 == 0) continue;
                }
                break block9;
            }
            v0 = this;
        }
        var2_3 = v0.a.p();
        block2 : do lbl-1000: // 3 sources:
        {
            if (var2_3.f() == false) return;
            var3_6 = var2_3.a();
            var4_7 = this.a.l(var3_6);
            var5_10 = var4_7.b();
            var6_11 = var5_10.a();
            var5_10.g();
            while (var5_10.f()) {
                var7_13 = var5_10.a();
                var8_15 = new m((t)var6_11, var7_13);
                this.b.add(new z(this, var8_15, var3_6, 1, false));
                var6_11 = var7_13;
                var5_10.g();
                if (var11_2 != 0) ** GOTO lbl-1000
                if (var11_2 == 0) continue;
            }
            var7_14 = this.a.d(var3_6);
            for (var8_16 = 0; var8_16 < var7_14.length; ++var8_16) {
                var9_17 = var7_14[var8_16];
                if (var11_2 != 0) continue block2;
                var10_18 = (var1_1 == null || var1_1.d(var9_17) != false) && this.a(var9_17) != false;
                this.b.add(new z(this, var9_17, var3_6, 3, var10_18));
                if (var11_2 == 0) continue;
            }
            var2_3.g();
        } while (var11_2 == 0);
    }

    private double a(z z2) {
        y.d.y y2 = z2.h();
        double d2 = Math.sqrt(y2.a() * y2.a() + y2.b() * y2.b());
        return this.c + d2 * 0.5;
    }

    /*
     * Exception decompiling
     */
    private D a(n var1_1, z var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:420)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:219)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:619)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:45)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:681)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    private D d(boolean bl2) {
        int n2 = a.f;
        y.d.f.a(this.b, new y(this));
        D d2 = new D();
        y.c.C c2 = this.b.m();
        do {
            if (!c2.f()) return d2;
            z z2 = (z)c2.d();
            if (z2.a() && z2.e && (!bl2 || z2.d > 0)) {
                d2.add(z2);
            }
            c2.g();
        } while (n2 == 0);
        return d2;
    }

    private t b(z z2) {
        y.d.y y2 = z2.h();
        t t2 = new t(y2.c() + y2.a() * 0.5, y2.d() + y2.b() * 0.5);
        if (z2.c == 3) {
            d d2 = (d)z2.b;
            y.d.v v2 = this.a.l(d2);
            double[] arrd = w.a(v2, t2);
            return new t(arrd[0], arrd[1]);
        }
        if (z2.c != 2) return t2;
        y.c.q q2 = (y.c.q)z2.b;
        return this.a.l(q2);
    }

    private n a(t t2, t t3, R r2) {
        n n2;
        if (this.h && this.b(r2)) {
            return null;
        }
        if (t2.equals(t3)) {
            n2 = new n(t2.a() - this.d, t2.b() + this.d, 2.0 * this.d, 2.0 * this.d);
            if (a.f == 0) return n2;
        }
        y.d.z z2 = new y.d.z(t3, t2);
        double d2 = z2.d();
        double d3 = Math.max(this.d - d2, 0.0);
        z2.c();
        y.d.z z3 = y.d.z.c(z2);
        t t4 = y.d.z.a(t2, new y.d.z((- z3.a()) * this.d, (- z3.b()) * this.d));
        if (d3 > 0.0) {
            t4 = y.d.z.a(t4, new y.d.z((- z2.a()) * d3, (- z2.b()) * d3));
        }
        n2 = new n(t4, new q(this.d + d3, 2.0 * this.d), z2);
        if (!this.h) return n2;
        if (this.d <= d2) return n2;
        if (!this.a(r2)) return n2;
        return new n(t4, new q(d2 + d3, 2.0 * this.d), z2);
    }

    private boolean a(R r2) {
        if (!(r2 instanceof C)) return false;
        C c2 = (C)r2;
        byte by2 = c2.getPreferredPlacementDescriptor().b();
        if (by2 == 16) return true;
        if (by2 == 32) return true;
        return false;
    }

    private boolean b(R r2) {
        if (!(r2 instanceof C)) return false;
        C c2 = (C)r2;
        byte by2 = c2.getPreferredPlacementDescriptor().b();
        if (by2 != 8) return false;
        return true;
    }

    private boolean c(z z2) {
        int n2;
        t t2;
        int n3;
        int n4;
        R r2 = (R)z2.a;
        y.d.y y2 = z2.h();
        t t3 = new t(y2.c() + y2.a() * 0.5, y2.d() + y2.b() * 0.5);
        n n5 = this.a(t3, t2 = this.b(z2), r2);
        if (n5 == null) {
            return false;
        }
        D d2 = this.a(n5, z2);
        x x2 = this.a(d2);
        x x3 = u.a(this.d(z2), this.c);
        n5 = new n(n5.b() / this.c, n5.c() / this.c, n5.e() / this.c, n5.f() / this.c, n5.g(), n5.i());
        int n6 = (int)Math.floor(t3.a / this.c);
        boolean bl2 = x3.a(x2, n6, n3 = (int)Math.floor(t3.b / this.c), n4 = (int)Math.max(1.0, Math.ceil(this.e / this.c)), n2 = (int)Math.floor(this.d / this.c), n5, this.f);
        if (!bl2) return bl2;
        double d3 = t3.a() + (double)x3.a() * this.c;
        double d4 = t3.b() + (double)x3.b() * this.c;
        this.a(r2, d3, d4, z2.b);
        return bl2;
    }

    private void a(R r2, double d2, double d3, Object object) {
        Object object2;
        Object object3;
        R r3;
        Object object4;
        if (r2 instanceof C) {
            r3 = (C)r2;
            object2 = r3.getLabelModel();
            object4 = (d)object;
            object3 = this.a.b(object4);
            am am2 = this.a.a(object4.c());
            am am3 = this.a.a(object4.d());
            n n2 = new n(r2.getOrientedBox());
            n2.e(d2, d3);
            Object object5 = object2.a(n2, (I)object3, am2, am3);
            r3.setModelParameter(object5);
            if (a.f == 0) return;
        }
        if (!(r2 instanceof aj)) return;
        r3 = (aj)r2;
        object2 = new n(r2.getOrientedBox());
        object2.e(d2, d3);
        object4 = r3.a();
        object3 = object4.a((n)object2, this.a.a(object));
        r3.setModelParameter(object3);
    }

    private y.d.y a(R r2, Object object) {
        if (r2 instanceof C) {
            C c2 = (C)r2;
            d d2 = (d)object;
            n n2 = c2.getLabelModel().a(c2.getOrientedBox().d(), this.a.b(d2), this.a.a(d2.c()), this.a.a(d2.d()), c2.getModelParameter());
            return n2.h();
        }
        if (!(r2 instanceof aj)) return null;
        aj aj2 = (aj)r2;
        y.c.q q2 = (y.c.q)object;
        n n3 = aj2.a().a(aj2.getOrientedBox().d(), this.a.a(q2), aj2.getModelParameter());
        return n3.h();
    }

    private n d(z z2) {
        if (!z2.a()) {
            return null;
        }
        if (z2.a instanceof C) {
            C c2 = (C)z2.a;
            d d2 = (d)z2.b;
            q q2 = c2.getOrientedBox().d();
            return c2.getLabelModel().a(q2, this.a.b(d2), this.a.a(d2.c()), this.a.a(d2.d()), c2.getModelParameter());
        }
        if (!(z2.a instanceof aj)) return null;
        aj aj2 = (aj)z2.a;
        y.c.q q3 = (y.c.q)z2.b;
        q q4 = aj2.getOrientedBox().d();
        return aj2.a().a(q4, this.a.a(q3), aj2.getModelParameter());
    }

    /*
     * Unable to fully structure code
     */
    private x a(D var1_1) {
        block4 : {
            var11_2 = a.f;
            var2_3 = Integer.MAX_VALUE;
            var3_4 = Integer.MIN_VALUE;
            var4_5 = Integer.MAX_VALUE;
            var5_6 = Integer.MIN_VALUE;
            var6_7 = new Rectangle2D.Double();
            var7_8 = var1_1.m();
            while (var7_8.f()) {
                var8_9 = (z)var7_8.d();
                var9_10 = var8_9.h();
                var6_7.setFrame(var9_10.c(), var9_10.d(), var9_10.a(), var9_10.b());
                var2_3 = Math.min((int)Math.floor(var6_7.x / this.c), var2_3);
                var4_5 = Math.min((int)Math.floor(var6_7.y / this.c), var4_5);
                var3_4 = Math.max((int)Math.floor((var6_7.x + var6_7.width) / this.c), var3_4);
                var5_6 = Math.max((int)Math.floor((var6_7.y + var6_7.height) / this.c), var5_6);
                var7_8.g();
                if (var11_2 == 0) {
                    if (var11_2 == 0) continue;
                }
                break block4;
            }
            var2_3 -= 2;
            var4_5 -= 2;
            var3_4 += 2;
            var5_6 += 2;
        }
        var7_8 = new x(var2_3, var4_5, var3_4 - var2_3, var5_6 - var4_5);
        var8_9 = var1_1.m();
        do {
            if (var8_9.f() == false) return var7_8;
            var9_12 = (z)var8_9.d();
            if (var9_12.c != 1) ** GOTO lbl34
            var10_14 = (m)var9_12.a;
            u.a((x)var7_8, var10_14, this.c);
            if (var11_2 == 0) ** GOTO lbl39
lbl34: // 2 sources:
            if (var9_12.c != 0) ** GOTO lbl-1000
            var10_15 = var9_12.h();
            u.a((x)var7_8, var10_15, this.c);
            if (var11_2 != 0) lbl-1000: // 2 sources:
            {
                u.a((x)var7_8, this.d(var9_12), this.c);
            }
lbl39: // 4 sources:
            var8_9.g();
        } while (var11_2 == 0);
        return var7_8;
    }

    static void a(x x2, n n2, double d2) {
        x2.a(u.a(n2, d2));
    }

    static x a(n n2, double d2) {
        int n3 = a.f;
        y.d.y y2 = n2.h();
        int n4 = (int)(Math.floor(y2.c / d2) - 2.0);
        int n5 = (int)(Math.floor(y2.d / d2) - 2.0);
        int n6 = (int)(Math.floor((y2.c + y2.a) / d2) + 2.0);
        int n7 = (int)(Math.floor((y2.d + y2.b) / d2) + 2.0);
        x x2 = new x(n4, n5, n6 - n4, n7 - n5);
        t[] arrt = n.a(n2);
        u.a(x2, arrt[0], arrt[1], d2);
        u.a(x2, arrt[1], arrt[2], d2);
        u.a(x2, arrt[2], arrt[3], d2);
        u.a(x2, arrt[3], arrt[0], d2);
        x2.c();
        if (n3 == 0) return x2;
        i.g = !i.g;
        return x2;
    }

    static void a(x x2, y.d.y y2, double d2) {
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        double_.setFrame(y2.c(), y2.d(), y2.a(), y2.b());
        x2.a((int)Math.floor(double_.x / d2), (int)Math.floor(double_.y / d2), 1 + (int)Math.floor((double_.x + double_.width) / d2), 1 + (int)Math.floor((double_.y + double_.height) / d2));
    }

    static void a(x x2, m m2, double d2) {
        u.a(x2, m2.c(), m2.d(), d2);
    }

    /*
     * Exception decompiling
     */
    static void a(x var0, t var1_1, t var2_2, double var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:420)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:219)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:619)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:45)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:714)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    static y.d.y a(u u2, R r2, Object object) {
        return u2.a(r2, object);
    }

    static X a(u u2) {
        return u2.a;
    }
}

