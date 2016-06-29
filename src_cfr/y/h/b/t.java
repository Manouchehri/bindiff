/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.WeakHashMap;
import y.c.q;
import y.c.x;
import y.h.b.U;
import y.h.b.V;
import y.h.b.W;
import y.h.b.a;
import y.h.b.ae;
import y.h.b.c;
import y.h.b.f;
import y.h.b.i;
import y.h.bu;
import y.h.cW;
import y.h.ce;
import y.h.cf;
import y.h.ch;
import y.h.dw;
import y.h.fj;
import y.h.gg;
import y.h.y;

public class T
extends ae
implements cf {
    private f a;
    private c b;
    private byte c = 1;
    private boolean d = true;
    private boolean e;
    private boolean f = true;
    private final WeakHashMap g = new WeakHashMap();

    @Override
    public boolean a(double d2, double d3) {
        q q2;
        cW cW2;
        bu bu2;
        this.a = null;
        this.b = null;
        if (this.h != null && this.i != null && (q2 = this.a(cW2 = new cW(this.h, d2, d3, true))) != null && (bu2 = this.h.getGraph2D()) != null && T.a(bu2, q2) == this.i) {
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
            if (f2 == null && c2 == null) {
                if (!T.a(this.i.l())) return this.h();
                if (this.i.isSelected()) return false;
                return true;
            }
        }
        this.i();
        return false;
    }

    private static boolean a(i i2) {
        if (!i2.c().isEmpty()) return false;
        if (!i2.b().isEmpty()) return false;
        return true;
    }

    protected boolean a(c c2, double d2, double d3) {
        return this.a(this.i, c2, d2, d3, this.k());
    }

    protected boolean a(f f2, double d2, double d3) {
        return this.a(this.i, f2, d2, d3, this.k());
    }

    protected boolean d(dw dw2) {
        if ((dw2.d() & 64) == 0) return false;
        return true;
    }

    @Override
    public void onGraph2DSelectionEvent(ce ce2) {
        Object object = ce2.d();
        if (!ce2.a()) return;
        if (!this.l()) return;
        fj fj2 = T.a(ce2.e(), (q)object);
        if (!(fj2 instanceof a)) return;
        if (fj2.isSelected()) return;
        this.a((a)fj2);
    }

    public byte g() {
        return this.c;
    }

    public boolean h() {
        return this.d;
    }

    public boolean j() {
        return this.e;
    }

    public boolean k() {
        return this.f;
    }

    private void a(a a2) {
        Iterator iterator;
        Object object;
        int n2;
        block3 : {
            n2 = a.H;
            iterator = a2.l().c().iterator();
            while (iterator.hasNext()) {
                object = (c)iterator.next();
                this.a((c)object, false);
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block3;
            }
            iterator = a2.l().b().iterator();
        }
        do {
            if (!iterator.hasNext()) return;
            object = (f)iterator.next();
            this.a((f)object, false);
        } while (n2 == 0);
    }

    @Override
    public boolean a(dw dw2) {
        return this.i(dw2);
    }

    private boolean i(dw dw2) {
        if (!this.g(dw2)) return false;
        if (!this.a(dw2.a(), dw2.b())) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void b(dw var1_1) {
        var3_2 = a.H;
        if (!this.i(var1_1) || this.h == null) ** GOTO lbl16
        var2_3 = this.h.getGraph2D();
        if (this.i == null) ** GOTO lbl15
        if (this.l() && !this.g.containsKey(var2_3)) {
            var2_3.a(this);
            this.g.put(var2_3, null);
        }
        if (this.a == null) ** GOTO lbl11
        this.a(var2_3, this.a, this.d(var1_1));
        if (var3_2 == 0) ** GOTO lbl15
lbl11: // 2 sources:
        if (this.b == null) ** GOTO lbl-1000
        this.a(var2_3, this.b, this.d(var1_1));
        if (var3_2 != 0) lbl-1000: // 2 sources:
        {
            this.a(var2_3, this.i.l(), this.d(var1_1));
        }
lbl15: // 5 sources:
        var2_3.T();
lbl16: // 2 sources:
        this.e();
    }

    protected void a(bu bu2, c c2, boolean bl2) {
        this.a(bu2, new V(this, c2), bl2);
    }

    protected void a(bu bu2, f f2, boolean bl2) {
        this.a(bu2, new U(this, f2), bl2);
    }

    /*
     * Exception decompiling
     */
    private void a(bu var1_1, W var2_2, boolean var3_3) {
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

    private boolean l() {
        if (2 != this.g()) return false;
        return true;
    }

    protected void a(bu bu2, i i2, boolean bl2) {
        int n2 = a.H;
        if (T.a(i2)) {
            if (bl2) {
                if (!this.a(bu2)) return;
                this.a(i2.a(), true);
                if (n2 == 0) return;
            }
            bu2.N();
            this.a(i2.a(), true);
            if (n2 == 0) return;
        }
        if (!this.h()) return;
        this.a(i2.a());
    }

    private boolean a(bu bu2) {
        if (bu2.H()) return true;
        if (bu2.J().f()) return true;
        if (bu2.M().f()) return true;
        return false;
    }

    protected void a(a a2, boolean bl2) {
        int n2 = a.H;
        if (bl2) {
            q q2 = a2.getNode();
            if (q2 == null) {
                a2.setSelected(true);
                if (n2 == 0) return;
            }
            gg.a((bu)q2.e(), q2);
            if (n2 == 0) return;
        }
        a2.setSelected(false);
    }

    protected void a(c c2, boolean bl2) {
        c2.a(bl2);
    }

    protected void a(f f2, boolean bl2) {
        f2.a(bl2);
    }

    @Override
    void i() {
        super.i();
        this.a = null;
        this.b = null;
    }
}

