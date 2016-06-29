/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.Cursor;
import java.awt.geom.Rectangle2D;
import java.util.List;
import y.c.q;
import y.d.r;
import y.h.az;
import y.h.b.a;
import y.h.b.aa;
import y.h.b.ac;
import y.h.b.ad;
import y.h.b.ae;
import y.h.b.c;
import y.h.b.d;
import y.h.b.f;
import y.h.b.g;
import y.h.b.i;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dw;

public class S
extends ae {
    private f a;
    private c b;
    private ad c = new ad();
    private ac d;
    private g e;
    private d f;
    private g g;
    private d j;
    private aa k = new aa();
    private byte l = 1;
    private boolean m = true;
    private int n;
    private int o;
    private int p;
    private int q = Integer.MAX_VALUE;
    private int r = Integer.MAX_VALUE;

    @Override
    public boolean a(double d2, double d3) {
        q q2;
        cW cW2;
        bu bu2;
        this.b = null;
        this.a = null;
        if (this.h != null && this.i != null && (q2 = this.a(cW2 = new cW(this.h, d2, d3, true))) != null && (bu2 = this.h.getGraph2D()) != null && S.a(bu2, q2) == this.i) {
            f f2 = this.i.l().a(d2, d3);
            if (f2 != null && this.a(f2, d2, d3)) {
                this.a = f2;
                return true;
            }
            c c2 = this.i.l().b(d2, d3);
            if (c2 != null && this.a(c2, d2, d3)) {
                this.b = c2;
                return true;
            }
        }
        this.i();
        return false;
    }

    protected boolean a(c c2, double d2, double d3) {
        if (this.g() != 2) {
            if (!c2.e()) return false;
        }
        if (!this.a(this.i, c2, d2, d3, this.h())) return false;
        return true;
    }

    protected boolean a(f f2, double d2, double d3) {
        if (this.g() != 2) {
            if (!f2.e()) return false;
        }
        if (!this.a(this.i, f2, d2, d3, this.h())) return false;
        return true;
    }

    protected void b(double d2, double d3) {
        if (this.a(d2, d3) && (this.b != null || this.a != null)) {
            this.e = null;
            this.f = null;
            this.n = -1;
            this.p = 0;
            Rectangle2D rectangle2D = null;
            if (this.a != null) {
                rectangle2D = this.a.h();
                this.c.a(this.a(this.a, rectangle2D));
                this.e = this.a.a();
                this.n = this.a.b();
                this.p = this.b(this.a);
            } else if (this.b != null) {
                rectangle2D = this.b.h();
                this.c.a(this.a(this.b, rectangle2D));
                this.f = this.b.a();
                this.n = this.b.b();
                this.p = this.b(this.b);
            }
            this.h.addDrawable(this.c);
            this.h.updateView(rectangle2D);
            this.g = this.e;
            this.j = this.f;
            this.o = this.n;
            if (a.H == 0) return;
        }
        this.i();
    }

    /*
     * Exception decompiling
     */
    protected void c(double var1_1, double var3_2) {
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

    /*
     * Exception decompiling
     */
    protected void d(double var1_1, double var3_2) {
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

    /*
     * Unable to fully structure code
     */
    private void e(double var1_1, double var3_2) {
        var13_3 = a.H;
        if (this.i == null) return;
        var5_4 = this.i.l().a(var1_1, var3_2);
        if (var5_4 == null || var5_4 != this.a && this.p + 1 >= this.q) ** GOTO lbl40
        var6_5 = this.a(var5_4);
        while (var5_4 != this.a && var6_5 + this.p > this.q) {
            var5_4 = (f)var5_4.a();
            --var6_5;
            if (var13_3 == 0) continue;
        }
        var7_7 = var5_4.i();
        var8_8 = var5_4.h();
        if (var6_5 + this.p < this.q && (var7_7 == null || var1_1 >= var8_8.getX() + var7_7.b)) ** GOTO lbl16
        var9_9 = var5_4.a();
        var10_10 = var5_4.b();
        if (var13_3 == 0) ** GOTO lbl25
lbl16: // 2 sources:
        var9_9 = var5_4;
        if (var7_7 == null || var3_2 <= var8_8.getMaxY() - var7_7.c) ** GOTO lbl-1000
        if (var9_9 != this.a.a()) ** GOTO lbl-1000
        var10_10 = var9_9.n() - 1;
        if (var13_3 != 0) lbl-1000: // 2 sources:
        {
            var10_10 = var9_9.n();
            ** if (var13_3 == 0) goto lbl25
        }
        ** GOTO lbl25
lbl-1000: // 2 sources:
        {
            var10_10 = 0;
        }
lbl25: // 4 sources:
        var11_12 = var9_9;
        var12_13 = false;
        while (var11_12 instanceof f) {
            if (var11_12 == this.a) {
                var12_13 = true;
            }
            var11_12 = ((f)var11_12).a();
            if (var13_3 == 0) continue;
            if (!var12_13) break;
            this.g = this.e;
            this.o = this.n;
            if (var13_3 == 0) return;
            break;
        }
        this.g = var9_9;
        this.o = var10_10;
        if (var13_3 == 0) return;
lbl40: // 2 sources:
        var6_6 = this.i.getY() + this.i.t();
        var8_8 = this.i.l();
        if (var3_2 < var6_6) {
            this.g = var8_8;
            this.o = 0;
            if (var13_3 == 0) return;
        }
        for (f var10_11 : var8_8.o()) {
            if (var3_2 >= (var6_6 += var10_11.g())) continue;
            this.g = var8_8;
            this.o = var10_11.b();
            if (var13_3 != 0) return;
            break;
        }
        if (var3_2 < var6_6) return;
        this.g = var8_8;
        this.o = this.e == var8_8 ? var8_8.n() - 1 : var8_8.n();
    }

    /*
     * Unable to fully structure code
     */
    private void f(double var1_1, double var3_2) {
        var13_3 = a.H;
        if (this.i == null) return;
        var5_4 = this.i.l().b(var1_1, var3_2);
        if (var5_4 == null || var5_4 != this.b && this.p + 1 >= this.r) ** GOTO lbl40
        var6_5 = this.a(var5_4);
        while (var5_4 != this.b && var6_5 + this.p > this.r) {
            var5_4 = (c)var5_4.a();
            --var6_5;
            if (var13_3 == 0) continue;
        }
        var7_7 = var5_4.i();
        var8_8 = var5_4.h();
        if (var6_5 + this.p < this.r && (var7_7 == null || var3_2 >= var8_8.getY() + var7_7.a)) ** GOTO lbl16
        var9_9 = var5_4.a();
        var10_10 = var5_4.b();
        if (var13_3 == 0) ** GOTO lbl25
lbl16: // 2 sources:
        var9_9 = var5_4;
        if (var7_7 == null || var1_1 <= var8_8.getMaxX() - var7_7.d) ** GOTO lbl-1000
        if (var9_9 != this.b.a()) ** GOTO lbl-1000
        var10_10 = var9_9.k() - 1;
        if (var13_3 != 0) lbl-1000: // 2 sources:
        {
            var10_10 = var9_9.k();
            ** if (var13_3 == 0) goto lbl25
        }
        ** GOTO lbl25
lbl-1000: // 2 sources:
        {
            var10_10 = 0;
        }
lbl25: // 4 sources:
        var11_12 = var9_9;
        var12_13 = false;
        while (var11_12 instanceof c) {
            if (var11_12 == this.b) {
                var12_13 = true;
            }
            var11_12 = ((c)var11_12).a();
            if (var13_3 == 0) continue;
            if (!var12_13) break;
            this.j = this.f;
            this.o = this.n;
            if (var13_3 == 0) return;
            break;
        }
        this.j = var9_9;
        this.o = var10_10;
        if (var13_3 == 0) return;
lbl40: // 2 sources:
        var6_6 = this.i.getX() + this.i.v();
        var8_8 = this.i.l();
        if (var1_1 < var6_6) {
            this.j = var8_8;
            this.o = 0;
            if (var13_3 == 0) return;
        }
        for (c var10_11 : var8_8.l()) {
            if (var1_1 >= (var6_6 += var10_11.g())) continue;
            this.j = var8_8;
            this.o = var10_11.b();
            if (var13_3 != 0) return;
            break;
        }
        if (var1_1 < var6_6) return;
        this.j = var8_8;
        this.o = this.f == var8_8 ? var8_8.k() - 1 : var8_8.k();
    }

    private int a(f f2) {
        int n2 = a.H;
        int n3 = 1;
        g g2 = f2.a();
        do {
            if (!(g2 instanceof f)) return n3;
            ++n3;
            g2 = ((f)g2).a();
        } while (n2 == 0);
        return n3;
    }

    private int a(c c2) {
        int n2 = a.H;
        int n3 = 1;
        d d2 = c2.a();
        do {
            if (!(d2 instanceof c)) return n3;
            ++n3;
            d2 = ((c)d2).a();
        } while (n2 == 0);
        return n3;
    }

    private int b(f f2) {
        int n2;
        int n3 = a.H;
        int n4 = 0;
        if (f2.n() > 0) {
            List list = f2.o();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                f f3 = (f)list.get(i2);
                int n5 = this.b(f3);
                n2 = n5 + 1;
                if (n3 != 0) return n2;
                if (n2 <= n4) continue;
                n4 = n5 + 1;
                if (n3 == 0) continue;
            }
        }
        n2 = n4;
        return n2;
    }

    private int b(c c2) {
        int n2;
        int n3 = a.H;
        int n4 = 0;
        if (c2.k() > 0) {
            List list = c2.l();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                c c3 = (c)list.get(i2);
                int n5 = this.b(c3);
                n2 = n5 + 1;
                if (n3 != 0) return n2;
                if (n2 <= n4) continue;
                n4 = n5 + 1;
                if (n3 == 0) continue;
            }
        }
        n2 = n4;
        return n2;
    }

    @Override
    public void e() {
        if (this.c.a() != null) {
            this.c.a((az)null);
            this.h.removeDrawable(this.c);
        }
        this.h.setViewCursor(Cursor.getDefaultCursor());
        this.h.getGraph2D().T();
        super.e();
    }

    protected az a(f f2, Rectangle2D rectangle2D) {
        if (this.d == null) {
            this.d = new ac();
        }
        this.d.a(true);
        if (f2 != null && f2.i() != null) {
            this.d.a(f2.i().b);
        }
        this.d.a(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        return this.d;
    }

    protected az a(c c2, Rectangle2D rectangle2D) {
        if (this.d == null) {
            this.d = new ac();
        }
        this.d.a(false);
        if (c2 != null && c2.i() != null) {
            this.d.a(c2.i().a);
        }
        this.d.a(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        return this.d;
    }

    public byte g() {
        return this.l;
    }

    @Override
    public boolean a(dw dw2) {
        if (!this.f(dw2)) return false;
        if (!this.a(dw2.a(), dw2.b())) return false;
        return true;
    }

    @Override
    public void b(dw dw2) {
        int n2 = a.H;
        switch (dw2.c()) {
            case 501: {
                if (!this.e(dw2)) return;
                this.b(dw2.a(), dw2.b());
                if (n2 == 0) return;
            }
            case 506: {
                this.d(dw2.a(), dw2.b());
                if (n2 == 0) return;
            }
            case 502: {
                if (!this.e(dw2)) return;
                this.c(dw2.a(), dw2.b());
            }
        }
    }

    @Override
    public Cursor c(dw dw2) {
        if (!this.a(dw2.a(), dw2.b())) return null;
        return Cursor.getPredefinedCursor(13);
    }

    public boolean h() {
        return this.m;
    }

    @Override
    void i() {
        super.i();
        this.a = null;
        this.b = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.j = null;
    }
}

