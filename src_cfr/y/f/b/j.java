/*
 * Decompiled with CFR 0_115.
 */
package y.f.b;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.x;
import y.d.q;
import y.d.t;
import y.d.u;
import y.d.v;
import y.d.y;
import y.f.I;
import y.f.X;
import y.f.aE;
import y.f.aF;
import y.f.ae;
import y.f.ah;
import y.f.am;
import y.f.ax;
import y.f.ay;
import y.f.b.a;
import y.f.b.c;
import y.f.b.f;
import y.f.b.h;
import y.f.b.k;
import y.f.b.l;
import y.f.b.m;
import y.f.b.n;
import y.f.b.o;
import y.f.b.p;
import y.g.M;

public class j
extends y.f.a {
    public static final Object a = "y.layout.grouping.RecursiveGroupLayouter.GROUP_NODE_LAYOUTER_DPKEY";
    public static final ah b = new o(null);
    private X c;
    private A d;
    private y.c.h e;
    private A f;
    private boolean g = false;
    private y.c.c h;
    private boolean i = false;
    private boolean n = true;
    private a o;
    private y.c.c p;
    private y.c.c q;
    private y.c.c r;
    private A s;
    private Map t;
    private Map u;
    private Map v;
    private Map w;
    private y.c.c x;
    private y.c.c y;
    private y.c.c z;
    private y.c.c A;
    private y.c.h B;
    private y.c.h C;
    private y.c.h D;
    private y.c.h E;
    private A F;
    private A G;
    private A H;

    public j() {
        this(null, new h());
    }

    public j(ah ah2) {
        this(ah2, new h());
    }

    public j(ah ah2, a a2) {
        this.a(ah2);
        this.o = a2;
    }

    public boolean b() {
        return this.n;
    }

    public void a(boolean bl2) {
        this.n = bl2;
    }

    private boolean a(y.c.q q2) {
        if (this.h == null) return true;
        if (this.h.b(q2) == null) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private void a(y.c.q var1_1, c var2_2) {
        var6_3 = c.a;
        var3_4 = new y.c.y(var2_2.b(var1_1));
        do lbl-1000: // 3 sources:
        {
            if (var3_4.isEmpty() != false) return;
            var4_5 = var3_4.d();
            if (this.b(var4_5, var2_2) && !this.a(var4_5)) {
                var3_4.addAll(var2_2.b(var4_5));
            }
            if ((var5_6 = (t)this.s.b(var4_5)) == null) ** GOTO lbl-1000
            this.c.a(var4_5, var5_6);
        } while (var6_3 == 0);
    }

    private boolean b(y.c.q q2, c c2) {
        if (!c2.d(q2)) return false;
        if (this.b()) return true;
        if (!c2.e(q2)) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private void a(y.c.q var1_1, Object var2_2, A var3_3, c var4_4) {
        var8_5 = c.a;
        var5_6 = var4_4.b(var1_1);
        var6_7 = var5_6.a();
        do {
            if (var6_7.f() == false) return;
            var7_8 = var6_7.e();
            var3_3.a((Object)var7_8, var2_2);
            if (!this.b(var7_8, var4_4)) ** GOTO lbl13
            if (!this.a(var7_8)) ** GOTO lbl-1000
            this.a(var7_8, (Object)var7_8, var3_3, var4_4);
            if (var8_5 != 0) lbl-1000: // 2 sources:
            {
                this.a(var7_8, var2_2, var3_3, var4_4);
            }
lbl13: // 4 sources:
            var6_7.g();
        } while (var8_5 == 0);
    }

    private ah b(y.c.q q2) {
        if (this.h == null) return this.a();
        if (q2 != null) return (ah)this.h.b(q2);
        return this.a();
    }

    private void c() {
        block8 : {
            int n2 = c.a;
            this.B = this.c.u();
            this.C = this.c.u();
            this.D = this.c.u();
            this.E = this.c.u();
            e e2 = this.c.p();
            while (e2.f()) {
                d d2 = e2.a();
                ArrayList arrayList = p.a(this.c, d2, true);
                arrayList = p.a(this.c, d2, (Collection)arrayList, true);
                ArrayList arrayList2 = p.a(this.c, d2, false);
                arrayList2 = p.a(this.c, d2, (Collection)arrayList2, false);
                if (n2 == 0) {
                    if (d2.e()) {
                        if (arrayList == null || arrayList.isEmpty()) {
                            arrayList = new ArrayList(1);
                        }
                        if (arrayList2 == null || arrayList2.isEmpty()) {
                            arrayList2 = new ArrayList(1);
                        }
                        p.a(this.c, d2, arrayList, arrayList2);
                    }
                    this.D.a((Object)d2, arrayList);
                    this.E.a((Object)d2, arrayList2);
                    if (arrayList != null) {
                        this.B.a((Object)d2, new D(arrayList));
                    }
                    if (arrayList2 != null) {
                        this.C.a((Object)d2, new D(arrayList2));
                    }
                    e2.g();
                    if (n2 == 0) continue;
                }
                break block8;
            }
            this.c.a(ax.a, this.D);
            this.c.a(ax.b, this.E);
        }
        if (this.x != null) {
            this.c.d_(aF.a);
        }
        if (this.y == null) return;
        this.c.d_(aF.b);
    }

    private void d() {
        block7 : {
            int n2;
            block6 : {
                n2 = c.a;
                if (this.z != null) {
                    this.c.a(ax.a, this.z);
                    if (n2 == 0) break block6;
                }
                this.c.d_(ax.a);
            }
            this.c.a(this.D);
            if (this.A != null) {
                this.c.a(ax.b, this.A);
                if (n2 == 0) break block7;
            }
            this.c.d_(ax.b);
        }
        this.c.a(this.E);
        if (this.x != null) {
            this.c.a(aF.a, this.x);
        }
        if (this.y != null) {
            this.c.a(aF.b, this.y);
        }
        this.c.a(this.B);
        this.c.a(this.C);
    }

    @Override
    public void c(X x2) {
        Object object;
        int n2 = c.a;
        this.c = x2;
        if (c.b(x2)) {
            Object object2;
            l l2;
            A a2;
            ah ah2;
            Object object3;
            Object object4;
            block20 : {
                Object object5;
                block18 : {
                    this.h = x2.c(a);
                    if (this.h != null) {
                        x2.d_(a);
                    }
                    this.f = x2.t();
                    object = x2.o();
                    while (object.f()) {
                        this.f.a((Object)object.e(), new m());
                        object.g();
                        if (n2 != 0) return;
                        if (n2 == 0) continue;
                    }
                    object = new c(x2);
                    this.k();
                    this.d = x2.t();
                    a2 = x2.t();
                    Object object6 = new Object();
                    this.a(object.b(), object6, a2, (c)object);
                    l2 = new l(this, x2, (c)object);
                    this.s = x2.t();
                    if (this.i) {
                        this.e();
                    }
                    this.f();
                    this.i();
                    this.c();
                    this.F = x2.t();
                    this.G = x2.t();
                    object3 = x2.o();
                    while (object3.f()) {
                        object5 = object3.e();
                        this.F.a(object5, object5.a());
                        this.G.a(object5, new n());
                        object3.g();
                        if (n2 == 0) {
                            if (n2 == 0) continue;
                        }
                        break block18;
                    }
                    this.H = x2.t();
                }
                if ((object3 = x2.c(ay.a)) == null) {
                    x2.a(ay.a, this.H);
                }
                this.e = x2.u();
                object5 = object.c(object.b());
                for (object2 = object5.l(); object2 != null; object2 = object2.b()) {
                    object4 = (y.c.q)object2.c();
                    ah2 = this;
                    if (n2 == 0) {
                        Object object7;
                        ah ah3;
                        block19 : {
                            if (!super.b((y.c.q)object4, (c)object) || !this.a((y.c.q)object4)) continue;
                            ah3 = this.b((y.c.q)object4);
                            l2.a((y.c.q)object4);
                            if (ah3 != null) {
                                this.b((c)object);
                                if (this.i) {
                                    this.a((y.c.q)object4, (c)object);
                                }
                                this.a((c)object);
                                ah3.c(x2);
                                this.g();
                            }
                            if (this.o != null) {
                                object7 = this.o.a(x2, (y.c.q)object4, object.b((y.c.q)object4));
                                x2.d((y.c.q)object4);
                                x2.b((y.c.q)object4, object7.getWidth(), object7.getHeight());
                                x2.c((y.c.q)object4, object7.getX(), object7.getY());
                                if (n2 == 0) break block19;
                            }
                            x2.d((y.c.q)object4);
                        }
                        if (ah3 == null) continue;
                        object7 = x2.a(object4);
                        this.d.a(object4, new Point2D.Double(object7.getX(), object7.getY()));
                        this.c((c)object);
                        if (n2 == 0) continue;
                    }
                    break block20;
                }
                ah2 = this.b((y.c.q)null);
            }
            object2 = ah2;
            l2.a(object.b());
            if (object2 != null) {
                this.b((c)object);
                if (this.i) {
                    this.a(object.b(), (c)object);
                }
                this.a((c)object);
                object2.c(x2);
                this.g();
                this.c((c)object);
            }
            l2.a();
            if (object2 != null) {
                this.a((c)object, object.b(), 0.0, 0.0);
            }
            x2.a(this.e);
            this.e = null;
            this.d();
            this.j();
            this.h();
            object4 = this.a(a2);
            this.a(x2, (y.c.f)object4);
            if (object3 == null) {
                x2.d_(ay.a);
            }
            if (this.h != null) {
                x2.a(a, this.h);
            }
            x2.a(this.s);
            x2.a(this.F);
            x2.a(this.G);
            x2.a(this.H);
            x2.a(a2);
            x2.a(this.f);
            x2.a(this.d);
            this.d = null;
            object.c();
            if (n2 == 0) return;
        }
        if ((object = this.a()) == null) return;
        object.c(x2);
    }

    private y.c.f a(y.c.c c2) {
        int n2 = c.a;
        y.c.f f2 = new y.c.f();
        e e2 = this.c.p();
        do {
            if (!e2.f()) return f2;
            d d2 = e2.a();
            if (c2.b(d2.c()) != c2.b(d2.d())) {
                f2.add(d2);
            }
            e2.g();
        } while (n2 == 0);
        return f2;
    }

    protected void a(X x2, y.c.f f2) {
        int n2 = c.a;
        e e2 = f2.a();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            am am2 = x2.a(d2.c());
            am am3 = x2.a(d2.d());
            if (!j.a(am2, x2.p(d2)) || !j.a(am3, x2.q(d2))) {
                ae.a(x2, d2);
            }
            e2.g();
        } while (n2 == 0);
    }

    private static boolean a(am am2, t t2) {
        if (am2.getX() - 0.1 >= t2.a) return false;
        if (am2.getX() + am2.getWidth() + 0.1 <= t2.a) return false;
        if (am2.getY() - 0.1 >= t2.b) return false;
        if (am2.getY() + am2.getHeight() + 0.1 <= t2.b) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    private void a(c var1_1, y.c.q var2_2, double var3_3, double var5_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[DOLOOP]], but top level block is 4[DOLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
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

    private void a(d d2, double d3, double d4) {
        int n2 = c.a;
        I i2 = this.c.b(d2);
        int n3 = 0;
        do {
            if (n3 >= i2.pointCount()) return;
            t t2 = i2.getPoint(n3);
            i2.setPoint(n3, t2.a + d3, t2.b + d4);
            ++n3;
        } while (n2 == 0);
    }

    public void a(a a2) {
        this.o = a2;
    }

    private void e() {
        int n2 = c.a;
        x x2 = this.c.o();
        do {
            if (!x2.f()) return;
            y.c.q q2 = x2.e();
            this.s.a((Object)q2, this.c.l(q2));
            x2.g();
        } while (n2 == 0);
    }

    private void f() {
        this.r = this.c.c(f.d);
        this.p = this.c.c(f.b);
        this.q = this.c.c(f.c);
        this.c.d_(f.d);
        this.c.d_(f.b);
        this.c.d_(f.c);
    }

    private void g() {
        if (this.c.c(f.d) == null) return;
        this.c.d_(f.d);
        this.c.d_(f.b);
        this.c.d_(f.c);
    }

    private void a(c c2) {
        A a2;
        A a3;
        boolean bl2;
        block6 : {
            int n2 = c.a;
            a3 = M.a();
            a2 = M.a();
            boolean bl3 = false;
            x x2 = this.c.o();
            while (x2.f()) {
                y.c.q q2 = x2.e();
                bl2 = this.b(q2, c2);
                if (n2 == 0) {
                    if (bl2 && !this.a(q2)) {
                        bl3 = true;
                        a3.a((Object)q2, true);
                        x x3 = c2.b(q2).a();
                        while (x3.f()) {
                            y.c.q q3 = x3.e();
                            a2.a((Object)q3, this.p.b(q2));
                            x3.g();
                            if (n2 == 0) {
                                if (n2 == 0) continue;
                            }
                            break;
                        }
                    } else {
                        x2.g();
                    }
                    if (n2 == 0) continue;
                }
                break block6;
            }
            bl2 = bl3;
        }
        if (!bl2) return;
        this.c.a(f.d, a3);
        this.c.a(f.c, a2);
        this.c.a(f.b, new k(this));
    }

    private void h() {
        this.c.a(f.d, this.r);
        this.c.a(f.b, this.p);
        this.c.a(f.c, this.q);
    }

    private void i() {
        int n2 = c.a;
        e e2 = this.c.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            if (this.x != null && this.a(d2, this.x)) {
                this.v.put(d2, this.c.n(d2));
            }
            if (this.y != null && this.a(d2, this.y)) {
                this.w.put(d2, this.c.o(d2));
            }
            e2.g();
        } while (n2 == 0);
    }

    private void j() {
        int n2 = c.a;
        e e2 = this.c.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            t t2 = (t)this.v.get(d2);
            if (t2 != null && this.c.n(d2).compareTo(t2) != 0) {
                this.c.a(d2, t2);
            }
            if ((t2 = (t)this.w.get(d2)) != null && this.c.o(d2).compareTo(t2) != 0) {
                this.c.b(d2, t2);
            }
            e2.g();
        } while (n2 == 0);
    }

    private void k() {
        this.t = new HashMap();
        this.u = new HashMap();
        this.v = new HashMap();
        this.w = new HashMap();
        this.x = this.c.c(aF.a);
        this.y = this.c.c(aF.b);
        this.z = this.c.c(ax.a);
        this.A = this.c.c(ax.b);
    }

    private D a(ax ax2, t t2, d d2, boolean bl2) {
        D d3 = new D();
        if (ax2.b()) {
            d3.add(ax.a(ax2.c() + t2.a, ax2.d() + t2.b, ax2.a(), ax2.f()));
            if (c.a == 0) return d3;
        }
        y.c.q q2 = bl2 ? d2.c() : d2.d();
        m m2 = (m)this.f.b(q2);
        if (ax2.a(1)) {
            d3.addAll(this.a(d2, bl2, t2, ax2.f(), m2.a));
        }
        if (ax2.a(2)) {
            d3.addAll(this.b(d2, bl2, t2, ax2.f(), m2.b));
        }
        if (ax2.a(8)) {
            d3.addAll(this.c(d2, bl2, t2, ax2.f(), m2.c));
        }
        if (!ax2.a(4)) return d3;
        d3.addAll(this.d(d2, bl2, t2, ax2.f(), m2.d));
        return d3;
    }

    private D a(y.c.q q2, d d2, t t2) {
        D d3;
        int n2 = c.a;
        if (d2.d() == q2) {
            D d4;
            D d5 = (D)this.C.b(d2);
            if (d5 == null || d5.isEmpty()) {
                if (!this.g) return null;
                return this.a(d2, false, t2, 1.0);
            }
            D d6 = new D();
            C c2 = d5.m();
            while (c2.f()) {
                ax ax2 = (ax)c2.d();
                d4 = d6;
                if (n2 != 0) return d4;
                d4.a(this.a(ax2, t2, d2, false));
                c2.g();
                if (n2 == 0) continue;
            }
            d4 = d6;
            return d4;
        }
        if (d2.c() != q2) return null;
        D d7 = (D)this.B.b(d2);
        if (d7 == null || d7.isEmpty()) {
            if (!this.g) return null;
            return this.a(d2, true, t2, 1.0);
        }
        D d8 = new D();
        C c3 = d7.m();
        while (c3.f()) {
            ax ax3 = (ax)c3.d();
            d3 = d8;
            if (n2 != 0) return d3;
            d3.a(this.a(ax3, t2, d2, true));
            c3.g();
            if (n2 == 0) continue;
        }
        d3 = d8;
        return d3;
    }

    private static t a(t t2, t t3) {
        return new t(t2.a() - t3.a(), t2.b() - t3.b());
    }

    private void a(y y2, v v2, m m2) {
        int n2 = c.a;
        int n3 = 0;
        y.d.m m3 = v2.a(n3);
        while (n3 < v2.h() - 1 && y2.a(m3.c()) && y2.a(m3.d())) {
            m3 = v2.a(++n3);
            if (n2 == 0) continue;
        }
        if (m3 == null) {
            return;
        }
        t t2 = m3.c();
        t t3 = y2.e();
        t t4 = new t(t3.a() + y2.a() * 0.5, t3.b() + y2.b() * 0.5);
        if (y2.a(t2)) {
            y.d.m m4 = new y.d.m(t3, new t(t3.a + y2.a(), t3.b));
            t t5 = y.d.m.a(m3, m4);
            if (t5 != null) {
                m2.a.add(j.a(t5, t4));
                return;
            }
            y.d.m m5 = new y.d.m(new t(t3.a, t3.b + y2.b()), new t(t3.a + y2.a(), t3.b + y2.b()));
            t5 = y.d.m.a(m3, m5);
            if (t5 != null) {
                m2.b.add(j.a(t5, t4));
                return;
            }
            y.d.m m6 = new y.d.m(new t(t3.a, t3.b), new t(t3.a, t3.b + y2.b()));
            t5 = y.d.m.a(m3, m6);
            if (t5 != null) {
                m2.c.add(j.a(t5, t4));
                return;
            }
            y.d.m m7 = new y.d.m(new t(t3.a + y2.a(), t3.b), new t(t3.a + y2.a(), t3.b + y2.b()));
            t5 = y.d.m.a(m3, m7);
            if (t5 != null) {
                m2.d.add(j.a(t5, t4));
                return;
            }
        }
        if (t2.b() <= t3.b()) {
            m2.a.add(j.a(t2, t4));
            if (n2 == 0) return;
        }
        if (t2.b() >= t3.b() + y2.b()) {
            m2.b.add(j.a(t2, t4));
            if (n2 == 0) return;
        }
        if (t2.a() <= t3.a()) {
            m2.c.add(j.a(t2, t4));
            if (n2 == 0) return;
        }
        if (t2.a() < t3.a() + y2.a()) return;
        m2.d.add(j.a(t2, t4));
    }

    private void a(d d2, boolean bl2, v v2) {
        y.c.q q2 = bl2 ? d2.c() : d2.d();
        m m2 = (m)this.f.b(q2);
        y y2 = this.c.s(q2);
        if (!bl2) {
            v2 = v2.g();
        }
        this.a(y2, v2, m2);
    }

    private boolean a(double d2, double d3) {
        if (d2 + 2.0 <= d3) return false;
        if (d2 - 2.0 >= d3) return false;
        return true;
    }

    private D a(d d2, boolean bl2, t t2, double d3, D d4) {
        int n2;
        n n3;
        D d5;
        int n4;
        block7 : {
            int n5;
            n2 = c.a;
            n3 = (n)(bl2 ? this.G.b(d2.c()) : this.G.b(d2.d()));
            d5 = new D();
            if (bl2) {
                n5 = this.F.a(d2.c());
                int n6 = n4 = n5 % 2 == 0 ? n5 + 1 : n5;
                if (n2 == 0) break block7;
            }
            n4 = (n5 = this.F.a(d2.d())) % 2 == 0 ? n5 + 1 : n5;
        }
        q q2 = bl2 ? this.c.r(d2.c()) : this.c.r(d2.d());
        C c2 = d4.m();
        double d6 = c2.f() ? ((t)c2.d()).a() : Double.MAX_VALUE;
        double d7 = q2.b() / 2.0;
        double d8 = q2.a() / 2.0;
        double d9 = q2.a() / (double)(n4 + 1);
        int n7 = (n4 - 1) / 2;
        int n8 = 0;
        block0 : do {
            int n9 = n8;
            block1 : while (n9 < n4) {
                double d10 = - d8 + d9 * (double)(n8 + 1);
                while (d10 > d6 + 2.0) {
                    c2.g();
                    n9 = (int)c2.f() ? 1 : 0;
                    if (n2 != 0) continue block1;
                    double d11 = d6 = n9 != 0 ? ((t)c2.d()).a() : Double.MAX_VALUE;
                    if (n2 == 0) continue;
                }
                double d12 = d3;
                if (n8 != n7) {
                    d12 += 1.0;
                }
                if (this.a(d10, d6)) {
                    d12 += 10.0;
                }
                d5.add(ax.a(d10 + t2.a, - d7 + t2.b, 1, d12));
                ++n8;
                if (n2 == 0) continue block0;
            }
            break block0;
            break;
        } while (true);
        if (n3 == null) return d5;
        n3.a = d5;
        return d5;
    }

    private D b(d d2, boolean bl2, t t2, double d3, D d4) {
        int n2;
        n n3;
        D d5;
        int n4;
        block7 : {
            int n5;
            n2 = c.a;
            n3 = (n)(bl2 ? this.G.b(d2.c()) : this.G.b(d2.d()));
            d5 = new D();
            if (bl2) {
                n5 = this.F.a(d2.c());
                int n6 = n4 = n5 % 2 == 0 ? n5 + 1 : n5;
                if (n2 == 0) break block7;
            }
            n4 = (n5 = this.F.a(d2.d())) % 2 == 0 ? n5 + 1 : n5;
        }
        q q2 = bl2 ? this.c.r(d2.c()) : this.c.r(d2.d());
        C c2 = d4.m();
        double d6 = c2.f() ? ((t)c2.d()).a() : Double.MAX_VALUE;
        double d7 = q2.b() / 2.0;
        double d8 = q2.a() / 2.0;
        double d9 = q2.a() / (double)(n4 + 1);
        int n7 = (n4 - 1) / 2;
        int n8 = 0;
        block0 : do {
            int n9 = n8;
            block1 : while (n9 < n4) {
                double d10 = - d8 + d9 * (double)(n8 + 1);
                while (d10 > d6 + 2.0) {
                    c2.g();
                    n9 = (int)c2.f() ? 1 : 0;
                    if (n2 != 0) continue block1;
                    double d11 = d6 = n9 != 0 ? ((t)c2.d()).a() : Double.MAX_VALUE;
                    if (n2 == 0) continue;
                }
                double d12 = d3;
                if (n8 != n7) {
                    d12 += 1.0;
                }
                if (this.a(d10, d6)) {
                    d12 += 10.0;
                }
                d5.add(ax.a(d10 + t2.a, d7 + t2.b, 2, d12));
                ++n8;
                if (n2 == 0) continue block0;
            }
            break block0;
            break;
        } while (true);
        if (n3 == null) return d5;
        n3.b = d5;
        return d5;
    }

    private D c(d d2, boolean bl2, t t2, double d3, D d4) {
        int n2;
        n n3;
        D d5;
        int n4;
        block7 : {
            int n5;
            n2 = c.a;
            n3 = (n)(bl2 ? this.G.b(d2.c()) : this.G.b(d2.d()));
            d5 = new D();
            if (bl2) {
                n5 = this.F.a(d2.c());
                int n6 = n4 = n5 % 2 == 0 ? n5 + 1 : n5;
                if (n2 == 0) break block7;
            }
            n4 = (n5 = this.F.a(d2.d())) % 2 == 0 ? n5 + 1 : n5;
        }
        q q2 = bl2 ? this.c.r(d2.c()) : this.c.r(d2.d());
        C c2 = d4.m();
        double d6 = c2.f() ? ((t)c2.d()).b() : Double.MAX_VALUE;
        double d7 = q2.b() / 2.0;
        double d8 = q2.a() / 2.0;
        double d9 = q2.b() / (double)(n4 + 1);
        int n7 = (n4 - 1) / 2;
        int n8 = 0;
        block0 : do {
            int n9 = n8;
            block1 : while (n9 < n4) {
                double d10 = - d7 + d9 * (double)(n8 + 1);
                while (d10 > d6 + 2.0) {
                    c2.g();
                    n9 = (int)c2.f() ? 1 : 0;
                    if (n2 != 0) continue block1;
                    double d11 = d6 = n9 != 0 ? ((t)c2.d()).b() : Double.MAX_VALUE;
                    if (n2 == 0) continue;
                }
                double d12 = d3;
                if (n8 != n7) {
                    d12 += 1.0;
                }
                if (this.a(d10, d6)) {
                    d12 += 10.0;
                }
                d5.add(ax.a(- d8 + t2.a, d10 + t2.b, 8, d12));
                ++n8;
                if (n2 == 0) continue block0;
            }
            break block0;
            break;
        } while (true);
        if (n3 == null) return d5;
        n3.c = d5;
        return d5;
    }

    private D d(d d2, boolean bl2, t t2, double d3, D d4) {
        int n2;
        n n3;
        D d5;
        int n4;
        block7 : {
            int n5;
            n2 = c.a;
            n3 = (n)(bl2 ? this.G.b(d2.c()) : this.G.b(d2.d()));
            d5 = new D();
            if (bl2) {
                n5 = this.F.a(d2.c());
                int n6 = n4 = n5 % 2 == 0 ? n5 + 1 : n5;
                if (n2 == 0) break block7;
            }
            n4 = (n5 = this.F.a(d2.d())) % 2 == 0 ? n5 + 1 : n5;
        }
        q q2 = bl2 ? this.c.r(d2.c()) : this.c.r(d2.d());
        C c2 = d4.m();
        double d6 = c2.f() ? ((t)c2.d()).b() : Double.MAX_VALUE;
        double d7 = q2.b() / 2.0;
        double d8 = q2.a() / 2.0;
        double d9 = q2.b() / (double)(n4 + 1);
        int n7 = (n4 - 1) / 2;
        int n8 = 0;
        block0 : do {
            int n9 = n8;
            block1 : while (n9 < n4) {
                double d10 = - d7 + d9 * (double)(n8 + 1);
                while (d10 > d6 + 2.0) {
                    c2.g();
                    n9 = (int)c2.f() ? 1 : 0;
                    if (n2 != 0) continue block1;
                    double d11 = d6 = n9 != 0 ? ((t)c2.d()).b() : Double.MAX_VALUE;
                    if (n2 == 0) continue;
                }
                double d12 = d3;
                if (n8 != n7) {
                    d12 += 1.0;
                }
                if (this.a(d10, d6)) {
                    d12 += 10.0;
                }
                d5.add(ax.a(d8 + t2.a, d10 + t2.b, 4, d12));
                ++n8;
                if (n2 == 0) continue block0;
            }
            break block0;
            break;
        } while (true);
        if (n3 == null) return d5;
        n3.d = d5;
        return n3.d;
    }

    private D a(d d2, boolean bl2, t t2, double d3) {
        y.c.q q2 = bl2 ? d2.c() : d2.d();
        m m2 = (m)this.f.b(q2);
        this.a(d2, bl2, t2, d3, m2.a);
        this.b(d2, bl2, t2, d3, m2.b);
        this.c(d2, bl2, t2, d3, m2.c);
        this.d(d2, bl2, t2, d3, m2.d);
        n n2 = (n)(bl2 ? this.G.b(d2.c()) : this.G.b(d2.d()));
        if (n2 == null) return null;
        return n2.a();
    }

    private ay a(y.c.q q2, int n2) {
        double d2;
        int n3;
        double d3;
        ay ay2;
        ay ay3;
        int n4;
        double d4;
        double d5;
        int n5;
        block4 : {
            n3 = c.a;
            ay2 = new ay();
            if (n2 == 0) {
                return ay2;
            }
            q q3 = this.c.r(q2);
            n5 = n2 % 2 == 0 ? n2 + 1 : n2;
            d5 = q3.b() / 2.0;
            d2 = q3.a() / 2.0;
            d3 = q3.a() / (double)(n5 + 1);
            for (n4 = 0; n4 < n5; ++n4) {
                d4 = - d2 + d3 * (double)(n4 + 1);
                ay2.a(ax.a(d4, - d5, 1));
                ay2.a(ax.a(d4, d5, 2));
                if (n3 == 0) {
                    if (n3 == 0) continue;
                }
                break block4;
            }
            d3 = q3.b() / (double)(n5 + 1);
        }
        for (n4 = 0; n4 < n5; ++n4) {
            d4 = - d5 + d3 * (double)(n4 + 1);
            ay2.a(ax.a(- d2, d4, 8));
            ay3 = ay2;
            if (n3 != 0) return ay3;
            ay3.a(ax.a(d2, d4, 4));
            if (n3 == 0) continue;
        }
        ay3 = ay2;
        return ay3;
    }

    /*
     * Exception decompiling
     */
    private void b(c var1_1) {
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

    private void a(d d2, y.c.q q2, y.c.q q3) {
        boolean bl2 = false;
        y.c.q q4 = d2.c();
        if (q4.e() == null) {
            this.c.d(q4);
            bl2 = true;
        }
        boolean bl3 = false;
        y.c.q q5 = d2.d();
        if (q5.e() == null) {
            this.c.d(q5);
            bl3 = true;
        }
        boolean bl4 = false;
        if (d2.a() == null) {
            this.c.e(d2);
            bl4 = true;
        }
        this.c.a(d2, q2, q3);
        if (bl4) {
            this.c.d(d2);
        }
        if (bl2) {
            this.c.c(q4);
        }
        if (!bl3) return;
        this.c.c(q5);
    }

    private static v a(v v2, t t2) {
        int n2 = c.a;
        if (t2 == null) {
            t2 = new t(0.0, 0.0);
        }
        t[] arrt = new t[v2.h()];
        int n3 = 0;
        u u2 = v2.b();
        do {
            if (!u2.f()) return new v(arrt);
            t t3 = u2.a();
            arrt[n3++] = new t(t3.a - t2.a, t3.b - t2.b);
            u2.g();
        } while (n2 == 0);
        return new v(arrt);
    }

    /*
     * Exception decompiling
     */
    private void c(c var1_1) {
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

    private boolean a(d d2, y.c.c c2) {
        aE aE2 = (aE)c2.b(d2);
        if (aE2 == null) return false;
        boolean bl2 = aE2.a();
        return bl2;
    }

    private t c(y.c.q q2) {
        t t2;
        Point2D.Double double_;
        t t3 = null;
        am am2 = this.c.a(q2);
        if (this.d != null && (double_ = (Point2D.Double)this.d.b(q2)) != null) {
            t3 = new t(am2.getX() - double_.x, am2.getY() - double_.y);
        }
        if (t3 != null) {
            t2 = t3;
            return t2;
        }
        t2 = new t();
        return t2;
    }

    private t a(c c2, y.c.q q2, y.c.q q3) {
        int n2 = c.a;
        t t2 = new t();
        if (this.d == null) return t2;
        y.c.q q4 = c2.a(q2);
        do {
            if (q4 == null) return t2;
            if (q4 == q3) return t2;
            t2 = t.b(t2, this.c(q4));
            q4 = c2.a(q4);
        } while (n2 == 0);
        return t2;
    }

    static boolean a(j j2, y.c.q q2) {
        return j2.a(q2);
    }

    static boolean a(j j2, y.c.q q2, c c2) {
        return j2.b(q2, c2);
    }

    static y.c.c a(j j2) {
        return j2.p;
    }
}

