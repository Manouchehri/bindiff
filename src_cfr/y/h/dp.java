/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.c.C;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.p;
import y.c.q;
import y.d.r;
import y.d.t;
import y.g.o;
import y.h.a.a;
import y.h.a.v;
import y.h.aB;
import y.h.aC;
import y.h.az;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dI;
import y.h.dQ;
import y.h.dR;
import y.h.dS;
import y.h.dU;
import y.h.ek;
import y.h.el;
import y.h.fj;
import y.h.fu;
import y.h.gX;
import y.h.gg;
import y.h.ic;
import y.h.x;
import y.h.y;
import y.h.z;

public class dP
extends gX {
    private double b;
    private double c;
    private double d;
    private double e;
    private boolean f;
    private y.c.y g;
    private List h;
    private Cursor i;
    private int j;
    private f k;
    private dU l;
    private boolean m;
    private byte n = 1;
    private boolean o = true;
    private boolean p;
    private boolean q;
    private az r;
    private y.c.y s;
    private y.c.y t;
    private boolean u;
    private boolean v;
    private Map w;
    private Rectangle2D.Double[] x;
    private boolean y;
    private y.c.y z;
    private Set A;
    private int B;
    boolean a;

    @Override
    public void activate(boolean bl2) {
        if (!bl2) {
            this.c().f();
        }
        super.activate(bl2);
        this.c().a(this.view);
    }

    public int a() {
        return this.B;
    }

    protected boolean a(MouseEvent mouseEvent) {
        if ((mouseEvent.getModifiers() & this.a()) == 0) return false;
        return true;
    }

    public dU c() {
        if (this.l != null) return this.l;
        this.l = this.e();
        return this.l;
    }

    protected dU e() {
        return new dU(this.view);
    }

    public boolean f() {
        return this.m;
    }

    public void a(boolean bl2) {
        this.m = bl2;
    }

    public dP() {
        this.r = new dQ(this);
        this.A = Collections.EMPTY_SET;
        this.B = 2;
    }

    @Override
    public void mouseShiftPressedLeft(double d2, double d3) {
        v v2 = this.i();
        this.u = v2 != null && this.k();
        this.a(d2, d3, this.u);
    }

    @Override
    public void mousePressedLeft(double d2, double d3) {
        this.u = false;
        this.a(d2, d3, false);
    }

    @Override
    public void mouseShiftReleasedLeft(double d2, double d3) {
        this.v = this.a = this.k();
        this.d(d2, d3);
        this.v = false;
    }

    @Override
    public void mouseReleasedLeft(double d2, double d3) {
        this.a = this.u;
        this.d(d2, d3);
    }

    /*
     * Unable to fully structure code
     */
    private void d(double var1_1, double var3_2) {
        block9 : {
            var9_3 = fj.z;
            if (!this.f() || this.a(this.lastReleaseEvent)) ** GOTO lbl-1000
            var5_4 = this.c().b(new t(var1_1, var3_2));
            var1_1 = var5_4.a;
            var3_2 = var5_4.b;
            if (var9_3) lbl-1000: // 2 sources:
            {
                this.c().h();
                var1_1 = this.getGridX(var1_1);
                var3_2 = this.getGridY(var3_2);
            }
            var5_4 = this.getGraph2D();
            this.view.updateWorldRect();
            this.view.setDrawingMode(0);
            if (this.k != null) {
                for (var6_5 = this.k.k(); var6_5 != null; var6_5 = var6_5.a()) {
                    var7_6 = (d)var6_5.c();
                    var8_7 = var5_4.i((d)var7_6);
                    v0 = this.A.contains(var7_6);
                    if (!var9_3) {
                        if (!v0) continue;
                        fu.a((aB)var8_7);
                        if (!var9_3) continue;
                    }
                    break block9;
                }
                this.k = null;
            }
            v0 = this.y;
        }
        if (v0) {
            block10 : {
                var6_5 = new HashSet<E>();
                var7_6 = this.getGraph2D().J();
                while (var7_6.f()) {
                    var6_5.addAll(new f(var7_6.e().j()));
                    var7_6.g();
                    if (!var9_3) {
                        if (!var9_3) continue;
                    }
                    break block10;
                }
                if (this.h != null) {
                    for (Object var8_7 : this.h) {
                        if (!(var8_7 instanceof ek)) continue;
                        var6_5.add(((ek)var8_7).a().a());
                        if (var9_3 != false) return;
                        if (!var9_3) continue;
                    }
                }
            }
            fu.a((bu)var5_4, (Collection)var6_5);
        }
        this.q();
        this.c().f();
        this.b(var1_1 - this.b, var3_2 - this.c, var1_1, var3_2);
        this.view.setViewCursor(this.i);
        this.i = null;
        var5_4.T();
        this.setEditing(false);
        this.reactivateParent();
        this.g = null;
        this.A = Collections.EMPTY_SET;
        this.h = null;
        this.x = null;
    }

    private void m() {
        boolean bl2 = fj.z;
        if (this.view == null) return;
        bu bu2 = this.view.getGraph2D();
        if (bu2 == null) {
            return;
        }
        if (this.j != 1) {
            o.a((Object)new StringBuffer().append("Unexpected BracketCounter in MoveSelectionMode : ").append(this.j).toString());
        }
        do {
            if (this.j <= 0) return;
            --this.j;
            bu2.s();
        } while (!bl2);
    }

    @Override
    public void reactivateParent() {
        this.m();
        super.reactivateParent();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void mouseDraggedLeft(double var1_1, double var3_2) {
        var9_3 = fj.z;
        if (!this.f() || this.a(this.lastDragEvent)) ** GOTO lbl-1000
        var5_4 = this.c().b(new t(var1_1, var3_2));
        var1_1 = var5_4.a;
        var3_2 = var5_4.b;
        if (var9_3) lbl-1000: // 2 sources:
        {
            var1_1 = this.getGridX(var1_1);
            var3_2 = this.getGridY(var3_2);
            this.c().h();
        }
        if (!this.f || !this.n() || !this.isGridMode()) ** GOTO lbl-1000
        this.f = false;
        this.d = var1_1;
        this.e = var3_2;
        if (var9_3) lbl-1000: // 2 sources:
        {
            var5_5 = var1_1 - this.d;
            var7_6 = var3_2 - this.e;
            if (var5_5 != 0.0 || var7_6 != 0.0) {
                this.d = var1_1;
                this.e = var3_2;
                this.e(var1_1 - this.b, var3_2 - this.c);
                this.a(var5_5, var7_6, var1_1, var3_2);
            }
        }
        this.view.updateView();
    }

    private void e(double d2, double d3) {
        Object object;
        boolean bl2 = fj.z;
        if (this.g == null) {
            return;
        }
        bu bu2 = this.getGraph2D();
        for (p p2 = this.g.k(); p2 != null; p2 = p2.a()) {
            object = (q)p2.c();
            try {
                Rectangle2D.Double double_ = this.x[object.d()];
                fj fj2 = bu2.t((q)object);
                fj2.setLocation(double_.x + d2, double_.y + d3);
                continue;
            }
            catch (ArrayIndexOutOfBoundsException var8_10) {
                continue;
            }
            catch (NullPointerException var8_11) {
                // empty catch block
            }
            if (!bl2) continue;
        }
        for (int i2 = 0; i2 < this.h.size(); ++i2) {
            try {
                object = (el)this.h.get(i2);
                object.a(d2, d3);
                if (bl2) return;
                continue;
            }
            catch (NullPointerException var7_8) {
                // empty catch block
            }
            if (!bl2) continue;
        }
        this.o();
    }

    /*
     * Unable to fully structure code
     */
    private void b(fj var1_1) {
        var5_2 = fj.z;
        var2_3 = var1_1.getNode();
        var3_4 = this.getGraph2D();
        for (var4_5 = var2_3.f(); var4_5 != null; var4_5 = var4_5.g()) {
            v0 = this.A.contains(var4_5);
            if (!var5_2) {
                if (!v0) continue;
                ic.a(this.view, var3_4.i(var4_5), true);
                if (!var5_2) continue;
            }
            ** GOTO lbl15
        }
        var4_5 = var2_3.g();
        do {
            if (var4_5 == null) return;
            v0 = this.A.contains(var4_5);
lbl15: // 2 sources:
            if (v0) {
                ic.a(this.view, var3_4.i(var4_5), false);
            }
            var4_5 = var4_5.h();
        } while (!var5_2);
    }

    protected void a(double d2, double d3) {
    }

    protected void a(double d2, double d3, double d4, double d5) {
        if (this.s == null) return;
        this.a(this.s);
    }

    private void a(y.c.y y2) {
        boolean bl2 = fj.z;
        bu bu2 = this.getGraph2D();
        if (this.j() != 1) return;
        p p2 = y2.k();
        do {
            if (p2 == null) return;
            q q2 = (q)p2.c();
            fj fj2 = bu2.t(q2);
            a a2 = fj2.getAutoBoundsFeature();
            if (a2 != null) {
                Rectangle2D rectangle2D = (Rectangle2D)this.w.get(q2);
                Rectangle2D rectangle2D2 = a2.getMinimalAutoBounds();
                double d2 = Math.max(0.0, rectangle2D2.getX() - rectangle2D.getX());
                double d3 = Math.max(0.0, rectangle2D2.getY() - rectangle2D.getY());
                double d4 = Math.max(0.0, rectangle2D.getMaxX() - rectangle2D2.getMaxX());
                double d5 = Math.max(0.0, rectangle2D.getMaxY() - rectangle2D2.getMaxY());
                a2.setAutoBoundsInsets(new r(d3, d2, d5, d4));
            }
            p2 = p2.a();
        } while (!bl2);
    }

    /*
     * Exception decompiling
     */
    protected void b(double var1_1, double var3_2, double var5_3, double var7_4) {
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

    protected y.c.y g() {
        boolean bl2 = fj.z;
        y.c.y y2 = new y.c.y();
        bu bu2 = this.getGraph2D();
        y.c.x x2 = bu2.o();
        do {
            if (!x2.f()) return y2;
            if (bu2.v(x2.e())) {
                y2.add(x2.e());
            }
            x2.g();
        } while (!bl2);
        return y2;
    }

    protected z h() {
        boolean bl2 = fj.z;
        z z2 = new z();
        bu bu2 = this.getGraph2D();
        y y2 = bu2.D();
        do {
            if (!y2.f()) return z2;
            x x2 = y2.a();
            if (bu2.a(x2)) {
                z2.b(x2);
            }
            y2.g();
        } while (!bl2);
        return z2;
    }

    private void a(y.c.y y2, z z2) {
        v v2 = this.i();
        if (v2 == null) {
            this.s = null;
            this.t = null;
            y2.addAll(this.g());
            z2.addAll(this.h());
            if (!fj.z) return;
        }
        this.s = new y.c.y();
        this.t = this.g();
        y2.addAll(this.t);
        z2.addAll(this.h());
        this.a(y2, this.s, z2);
    }

    protected void a(y.c.y y2, y.c.y y3, z z2) {
        HashSet hashSet = new HashSet(y2);
        HashSet hashSet2 = new HashSet(z2);
        gg.a(this.getGraph2D(), new dR(this, hashSet), new dS(this, hashSet2), y2, y3, z2);
    }

    /*
     * Exception decompiling
     */
    void a(double var1_1, double var3_2, boolean var5_3) {
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

    protected boolean a(d d2) {
        return aC.b(d2, this.getGraph2D());
    }

    private boolean n() {
        if ((this.h != null ? this.h.size() : 0) + (this.g != null ? this.g.size() : 0) != 1) return false;
        return true;
    }

    @Override
    public void cancelEditing() {
        this.c().f();
        if (!this.isEditing()) return;
        this.b(this.d - this.b, this.e - this.c, this.d, this.e);
        this.q();
        this.view.setDrawingMode(0);
        if (this.i != null) {
            this.view.setViewCursor(this.i);
            this.i = null;
        }
        this.view.getGraph2D().T();
        this.setEditing(false);
        this.reactivateParent();
        this.g = null;
        this.A = Collections.EMPTY_SET;
        this.h = null;
        this.x = null;
    }

    protected Object b(double d2, double d3) {
        bu bu2;
        boolean bl2 = fj.z;
        bu bu3 = this.getGraph2D();
        cW cW2 = this.c(d2, d3);
        if (!cW2.t()) {
            return bu3;
        }
        v v2 = this.i();
        C c2 = cW2.e();
        while (c2.f()) {
            q q2 = (q)c2.d();
            bu2 = bu3;
            if (bl2) return bu2;
            if (!bu2.v(q2) && v2.k(q2)) {
                return q2;
            }
            c2.g();
            if (!bl2) continue;
        }
        bu2 = bu3;
        return bu2;
    }

    protected cW c(double d2, double d3) {
        return new cW(this.view, d2, d3, false, 4);
    }

    protected v i() {
        return v.a(this.getGraph2D());
    }

    public byte j() {
        return this.n;
    }

    public boolean k() {
        return this.o;
    }

    public boolean l() {
        return this.p;
    }

    protected void a(Graphics2D graphics2D, fj fj2) {
        dI.b(graphics2D, fj2);
    }

    protected Rectangle2D a(fj fj2) {
        return new Rectangle2D.Double(fj2.getX() - 10.0, fj2.getY() - 10.0, fj2.getWidth() + 20.0, fj2.getHeight() + 20.0);
    }

    private void o() {
        boolean bl2 = fj.z;
        if (this.k() && this.l()) {
            boolean bl3;
            MouseEvent mouseEvent = this.lastDragEvent != null ? this.lastDragEvent : this.lastPressEvent;
            boolean bl4 = bl3 = mouseEvent != null && (mouseEvent.getModifiers() & 1) != 0;
            if (bl3) {
                this.p();
                if (!bl2) return;
            }
            this.q();
            if (!bl2) return;
        }
        this.q();
    }

    private void p() {
        if (this.q) return;
        this.q = true;
        this.view.addDrawable(this.r);
    }

    private void q() {
        if (!this.q) return;
        this.view.removeDrawable(this.r);
        this.q = false;
    }

    private void b(boolean bl2) {
        boolean bl3;
        block8 : {
            Object object;
            Object object2;
            boolean bl4 = fj.z;
            v v2 = this.i();
            if (v2 == null) {
                this.s = null;
                return;
            }
            bu bu2 = this.getGraph2D();
            if (this.s != null) {
                bu2.a(this.s.a());
                for (object = this.s.k(); object != null; object = object.a()) {
                    object2 = bu2.t((q)object.c());
                    object2.setLayer(0, true);
                    if (!bl4) {
                        if (!bl4) continue;
                    }
                    break;
                }
            } else {
                this.w = new HashMap();
            }
            object = bu2.o();
            while (object.f()) {
                object2 = object.e();
                bl3 = v2.k((q)object2);
                if (!bl4) {
                    if (bl3) {
                        fj fj2 = bu2.t((q)object2);
                        this.w.put(object2, fj2.getBoundingBox());
                    }
                    object.g();
                    if (!bl4) continue;
                }
                break block8;
            }
            bl3 = bl2;
        }
        if (!bl3) return;
        this.e(false);
    }

    private void d(boolean bl2) {
        if (bl2) {
            this.e(true);
        }
        this.s = null;
        this.t = null;
        this.w = null;
    }

    private void e(boolean bl2) {
        p p2;
        Object object;
        Object object2;
        boolean bl3 = fj.z;
        bu bu2 = this.getGraph2D();
        if (bl2) {
            block6 : {
                if (this.z == null) return;
                for (p2 = this.z.k(); p2 != null; p2 = p2.a()) {
                    object = bu2.t((q)p2.c());
                    object2 = object.getAutoBoundsFeature();
                    if (!bl3) {
                        if (object2 == null) continue;
                        object2.setAutoBoundsEnabled(true);
                        if (!bl3) continue;
                    }
                    break block6;
                }
                this.z = null;
            }
            if (!bl3) return;
        }
        if (this.s == null) return;
        if (this.z == null) {
            this.z = new y.c.y();
        }
        p2 = this.s.k();
        do {
            if (p2 == null) return;
            object = (q)p2.c();
            object2 = bu2.t((q)object);
            a a2 = object2.getAutoBoundsFeature();
            if (a2 != null && a2.isAutoBoundsEnabled()) {
                a2.setAutoBoundsEnabled(false);
                this.z.add(object);
            }
            p2 = p2.a();
        } while (!bl3);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        super.mouseReleased(mouseEvent);
        this.u = false;
    }

    @Override
    public void mouseReleasedRight(double d2, double d3) {
        this.mouseReleasedLeft(d2, d3);
    }

    @Override
    public void mouseDraggedRight(double d2, double d3) {
        this.mouseDraggedLeft(d2, d3);
    }

    static double a(dP dP2) {
        return dP2.d;
    }

    static double b(dP dP2) {
        return dP2.e;
    }
}

