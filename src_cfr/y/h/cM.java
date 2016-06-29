/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import y.c.d;
import y.c.e;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.ae;
import y.h.D;
import y.h.aC;
import y.h.bu;
import y.h.bw;
import y.h.cB;
import y.h.cC;
import y.h.cD;
import y.h.cE;
import y.h.cF;
import y.h.cH;
import y.h.cI;
import y.h.cJ;
import y.h.cK;
import y.h.cL;
import y.h.cM;
import y.h.ch;
import y.h.cn;
import y.h.co;
import y.h.cq;
import y.h.cs;
import y.h.ct;
import y.h.cu;
import y.h.cv;
import y.h.cw;
import y.h.cx;
import y.h.cy;
import y.h.cz;
import y.h.fj;
import y.h.gX;
import y.h.gd;

public class cm {
    ch a;
    ActionMap b;
    public static final Object c = "FOCUS_RIGHT_NODE";
    public static final Object d = "EDIT_NODE";
    public static final Object e = "FOCUS_LEFT_NODE";
    public static final Object f = "FOCUS_TOP_NODE";
    public static final Object g = "FOCUS_BOTTOM_NODE";
    public static final Object h = "SELECT_ALL";
    public static final Object i = "TOP_ALIGN";
    public static final Object j = "ALIGN_VERTICALLY";
    public static final Object k = "BOTTOM_ALIGN";
    public static final Object l = "DISTRIBUTE_VERTICALLY";
    public static final Object m = "LEFT_ALIGN";
    public static final Object n = "ALIGN_HORIZONTALLY";
    public static final Object o = "RIGHT_ALIGN";
    public static final Object p = "DISTRIBUTE_HORIZONTALLY";
    public static final Object q = "SELECT_LEFT_EDGE";
    public static final Object r = "SELECT_RIGHT_EDGE";
    public static final Object s = "SELECT_TOP_EDGE";
    public static final Object t = "SELECT_BOTTOM_EDGE";
    public static final Object u = "DELETE_SELECTION";
    public static final Object v = "GROUP_SELECTION";
    public static final Object w = "FOLD_SELECTION";
    public static final Object x = "UNGROUP_SELECTION";
    public static final Object y = "UNFOLD_SELECTION";
    public static final Object z = "OPEN_FOLDERS";
    public static final Object A = "CLOSE_GROUPS";
    public static final Object B = "EDIT_LABEL";
    public static final Object C = "DUPLICATE_GRAPH";
    public static final Object D = "ADD_SUCCESSORS";
    public static final Object E = "ADD_PREDECESSORS";
    Map F = new WeakHashMap();

    public cm() {
        this(null);
    }

    public cm(ch ch2) {
        this.a = ch2;
        this.b = new ActionMap();
        this.b.put(g, this.e());
        this.b.put(f, this.d());
        this.b.put(e, this.b());
        this.b.put(c, this.c());
        this.b.put(t, this.j());
        this.b.put(s, this.i());
        this.b.put(q, this.f());
        this.b.put(r, this.g());
        this.b.put(u, this.k());
        this.b.put(B, this.u());
        this.b.put(d, this.a());
        this.b.put(h, this.h());
        this.b.put(m, this.a(m, false, -1));
        this.b.put(n, this.a(n, false, 0));
        this.b.put(o, this.a(o, false, 1));
        this.b.put(p, this.a(p, false, 2));
        this.b.put(i, this.a(i, true, -1));
        this.b.put(j, this.a(j, true, 0));
        this.b.put(k, this.a(k, true, 1));
        this.b.put(l, this.a(l, true, 2));
        this.b.put(A, this.l());
        this.b.put(z, this.m());
        this.b.put(v, this.n());
        this.b.put(w, this.o());
        this.b.put(x, this.p());
        this.b.put(y, this.q());
        this.b.put(C, this.r());
        this.b.put(D, this.s());
        this.b.put(E, this.t());
    }

    Action a() {
        return new cn(this, d.toString());
    }

    protected ch a(ActionEvent actionEvent) {
        return cm.b(actionEvent, this.a);
    }

    private static ch b(ActionEvent actionEvent, ch ch2) {
        if (actionEvent.getSource() instanceof bw) {
            return (ch)((bw)actionEvent.getSource()).getParent();
        }
        if (!(actionEvent.getSource() instanceof ch)) return ch2;
        return (ch)actionEvent.getSource();
    }

    Action b() {
        return new cs(this, e.toString());
    }

    Action c() {
        return new ct(this, c.toString());
    }

    Action d() {
        return new cu(this, f.toString());
    }

    Action e() {
        return new cv(this, g.toString());
    }

    Action f() {
        return new cw(this, q.toString());
    }

    Action g() {
        return new cx(this, r.toString());
    }

    Action h() {
        return new cK(this.a);
    }

    Action a(Object object, boolean bl2, byte by2) {
        return new cy(this, object.toString(), bl2, by2);
    }

    Action i() {
        return new cz(this, s.toString());
    }

    Action j() {
        return new co(this, t.toString());
    }

    Action k() {
        return new cE(this.a);
    }

    Action l() {
        return new cD(this.a);
    }

    Action m() {
        return new cJ(this.a);
    }

    Action n() {
        return new cI(this.a);
    }

    Action o() {
        return new cH(this.a);
    }

    Action p() {
        return new cM(this.a);
    }

    Action q() {
        return new cL(this.a);
    }

    Action r() {
        return new cF(this.a);
    }

    Action s() {
        return new cC(this.a);
    }

    Action t() {
        return new cB(this.a);
    }

    private static fj b(bu bu2, q q2) {
        fj fj2 = bu2.t(q2);
        if (!(fj2 instanceof gd)) return fj2;
        return ((gd)fj2).e();
    }

    Action u() {
        return new cq(this);
    }

    public ActionMap v() {
        ActionMap actionMap;
        boolean bl2 = fj.z;
        ActionMap actionMap2 = new ActionMap();
        Object[] arrobject = this.b.keys();
        for (int i2 = 0; i2 < arrobject.length; ++i2) {
            actionMap = actionMap2;
            if (bl2) return actionMap;
            actionMap.put(arrobject[i2], this.b.get(arrobject[i2]));
            if (!bl2) continue;
        }
        actionMap = actionMap2;
        return actionMap;
    }

    public InputMap a(ActionMap actionMap) {
        int n2;
        boolean bl2 = fj.z;
        HashSet<Object> hashSet = new HashSet<Object>();
        Object[] arrobject = actionMap.keys();
        if (arrobject != null) {
            for (n2 = 0; n2 < arrobject.length; ++n2) {
                hashSet.add(arrobject[n2]);
                if (!bl2) {
                    if (!bl2) continue;
                }
                break;
            }
        } else {
            n2 = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        }
        InputMap inputMap = new InputMap();
        if (hashSet.contains(e)) {
            inputMap.put(KeyStroke.getKeyStroke(37, 0), e);
        }
        if (hashSet.contains(c)) {
            inputMap.put(KeyStroke.getKeyStroke(39, 0), c);
        }
        if (hashSet.contains(g)) {
            inputMap.put(KeyStroke.getKeyStroke(40, 0), g);
        }
        if (hashSet.contains(f)) {
            inputMap.put(KeyStroke.getKeyStroke(38, 0), f);
        }
        int n3 = 8;
        if (hashSet.contains(q)) {
            inputMap.put(KeyStroke.getKeyStroke(37, n3), q);
        }
        if (hashSet.contains(r)) {
            inputMap.put(KeyStroke.getKeyStroke(39, n3), r);
        }
        if (hashSet.contains(t)) {
            inputMap.put(KeyStroke.getKeyStroke(40, n3), t);
        }
        if (hashSet.contains(s)) {
            inputMap.put(KeyStroke.getKeyStroke(38, n3), s);
        }
        if (hashSet.contains(u)) {
            inputMap.put(KeyStroke.getKeyStroke(127, 0), u);
        }
        if (hashSet.contains(h)) {
            inputMap.put(KeyStroke.getKeyStroke(65, n2), h);
        }
        if (hashSet.contains(B)) {
            inputMap.put(KeyStroke.getKeyStroke(113, 0), B);
        }
        if (hashSet.contains(d)) {
            inputMap.put(KeyStroke.getKeyStroke(10, 0), d);
        }
        n3 = 10;
        if (hashSet.contains(o)) {
            inputMap.put(KeyStroke.getKeyStroke(39, n3), o);
        }
        if (hashSet.contains(m)) {
            inputMap.put(KeyStroke.getKeyStroke(37, n3), m);
        }
        if (hashSet.contains(n)) {
            inputMap.put(KeyStroke.getKeyStroke(72, n3), n);
        }
        if (hashSet.contains(j)) {
            inputMap.put(KeyStroke.getKeyStroke(86, n3), j);
        }
        if (hashSet.contains(i)) {
            inputMap.put(KeyStroke.getKeyStroke(38, n3), i);
        }
        if (hashSet.contains(k)) {
            inputMap.put(KeyStroke.getKeyStroke(40, n3), k);
        }
        if (hashSet.contains(A)) {
            inputMap.put(KeyStroke.getKeyStroke(67, n3), A);
        }
        if (hashSet.contains(z)) {
            inputMap.put(KeyStroke.getKeyStroke(79, n3), z);
        }
        if (hashSet.contains(v)) {
            inputMap.put(KeyStroke.getKeyStroke(71, n3), v);
        }
        if (hashSet.contains(w)) {
            inputMap.put(KeyStroke.getKeyStroke(70, n3), w);
        }
        if (hashSet.contains(x)) {
            inputMap.put(KeyStroke.getKeyStroke(85, n3), x);
        }
        if (hashSet.contains(y)) {
            inputMap.put(KeyStroke.getKeyStroke(77, n3), y);
        }
        n3 = 3;
        if (hashSet.contains(l)) {
            inputMap.put(KeyStroke.getKeyStroke(86, n3), l);
        }
        if (!hashSet.contains(p)) return inputMap;
        inputMap.put(KeyStroke.getKeyStroke(72, n3), p);
        return inputMap;
    }

    protected void a(ch ch2) {
        q q2;
        gX gX2;
        block4 : {
            boolean bl2 = fj.z;
            bu bu2 = this.d(ch2);
            if (!bu2.I()) return;
            x x2 = bu2.J();
            if (!x2.f()) return;
            q2 = x2.e();
            gX2 = null;
            gX gX3 = null;
            Iterator iterator = ch2.getViewModes();
            while (iterator.hasNext()) {
                gX gX4 = (gX)iterator.next();
                if (gX4 instanceof D) {
                    gX3 = (D)gX4;
                }
                if (!(gX4 instanceof aC)) continue;
                gX2 = (aC)gX4;
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block4;
            }
            if (gX3 != null && gX3.isActive() && !gX3.a()) {
                if (!gX3.a(q2)) return;
                gX3.a(q2, null);
                if (!bl2) return;
            }
        }
        if (gX2 == null) return;
        if (!gX2.isActive()) return;
        if (gX2.isEditing()) return;
        gX2.editNode(q2, null);
    }

    /*
     * Unable to fully structure code
     */
    void a(byte var1_1, ch var2_2) {
        var21_3 = fj.z;
        var3_4 = this.d(var2_2);
        var8_5 = this.b(var2_2);
        var9_6 = var3_4.o();
        if (var8_5 != null) ** GOTO lbl-1000
        var10_7 = this.c(var2_2);
        if (var10_7 == null) ** GOTO lbl-1000
        var4_9 = 0.5 * (var3_4.j(var10_7.c()) + var3_4.j(var10_7.d()));
        var6_10 = 0.5 * (var3_4.k(var10_7.c()) + var3_4.k(var10_7.d()));
        var11_11 = new y(var10_7.c());
        var11_11.add(var10_7.d());
        var9_6 = var11_11.a();
        if (var21_3) lbl-1000: // 2 sources:
        {
            var11_11 = var2_2.getCenter();
            var4_9 = var11_11.getX();
            var6_10 = var11_11.getY();
            ** if (!var21_3) goto lbl21
        }
        ** GOTO lbl21
lbl-1000: // 2 sources:
        {
            var4_9 = var3_4.j(var8_5);
            var6_10 = var3_4.k(var8_5);
        }
lbl21: // 3 sources:
        var10_8 = Double.MAX_VALUE;
        var12_12 = null;
        var13_13 = var9_6;
        while (var13_13.f()) {
            var14_14 = var13_13.e();
            var15_15 = var3_4.j(var14_14);
            var17_16 = var3_4.k(var14_14);
            var19_17 = this.a(var4_9, var6_10, var15_15, var17_16, var1_1);
            if (var21_3 != false) return;
            if (var19_17 < var10_8 && var14_14 != var8_5) {
                var10_8 = var19_17;
                var12_12 = var14_14;
            }
            var13_13.g();
            if (!var21_3) continue;
        }
        if (var12_12 == null) return;
        var3_4.N();
        var3_4.a(var12_12, true);
        var2_2.focusView(var2_2.getZoom(), new Point2D.Double(var3_4.j(var12_12), var3_4.k(var12_12)), false);
        var3_4.T();
    }

    void a(ch ch2, boolean bl2, byte by2) {
        bu bu2 = this.d(ch2);
        y y2 = new y(bu2.J());
        bu2.r();
        bu2.a(y2.a());
        ae.a(bu2, y2, null, bl2, by2);
        bu2.s();
        bu2.T();
    }

    /*
     * Exception decompiling
     */
    void b(byte var1_1, ch var2_2) {
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

    private double a(double d2, double d3, double d4, double d5) {
        double d6 = d4 - d2;
        double d7 = d5 - d3;
        return Math.atan2(d7, d6);
    }

    double a(double d2, double d3, double d4, double d5, byte by2) {
        boolean bl2 = fj.z;
        double d6 = d4 - d2;
        double d7 = d5 - d3;
        double d8 = 0.0;
        double d9 = 0.0;
        switch (by2) {
            case 0: {
                d8 = -1.0;
                d9 = 0.0;
                if (!bl2) break;
            }
            case 1: {
                d8 = 1.0;
                d9 = 0.0;
                if (!bl2) break;
            }
            case 2: {
                d8 = 0.0;
                d9 = -1.0;
                if (!bl2) break;
            }
            case 3: {
                d8 = 0.0;
                d9 = 1.0;
            }
        }
        double d10 = t.a(d2, d3, d4, d5);
        if (d10 == 0.0) {
            return d10;
        }
        double d11 = (d8 * d6 + d9 * d7) / d10;
        double d12 = Math.acos(d11);
        if (d12 < 1.5707963267948966) return t.a(d2, d3, d4, d5) * (1.0 + Math.pow(2.0 * d12 / 3.141592653589793, 8.0));
        return Double.MAX_VALUE;
    }

    q b(ch ch2) {
        boolean bl2 = fj.z;
        bu bu2 = this.d(ch2);
        x x2 = bu2.o();
        do {
            if (!x2.f()) return null;
            q q2 = x2.e();
            if (bu2.v(q2)) {
                return q2;
            }
            x2.g();
        } while (!bl2);
        return null;
    }

    d c(ch ch2) {
        boolean bl2 = fj.z;
        bu bu2 = this.d(ch2);
        e e2 = bu2.p();
        do {
            if (!e2.f()) return null;
            d d2 = e2.a();
            if (bu2.r(d2)) {
                return d2;
            }
            e2.g();
        } while (!bl2);
        return null;
    }

    bu d(ch ch2) {
        return ch2.getGraph2D();
    }

    static ch a(ActionEvent actionEvent, ch ch2) {
        return cm.b(actionEvent, ch2);
    }

    static fj a(bu bu2, q q2) {
        return cm.b(bu2, q2);
    }

    static double a(cm cm2, double d2, double d3, double d4, double d5) {
        return cm2.a(d2, d3, d4, d5);
    }
}

