/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import y.c.A;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.f;
import y.c.i;
import y.d.n;
import y.d.q;
import y.d.t;
import y.f.C;
import y.f.E;
import y.f.F;
import y.f.S;
import y.f.X;
import y.f.aG;
import y.f.f.a;
import y.f.f.b.g;
import y.f.f.b.h;
import y.f.f.b.o;
import y.f.h.Q;
import y.f.h.p;
import y.f.y;

public class e
implements Q {
    public static final Object a = "EDGE_LABEL_REF";
    protected h b;
    protected y.f.h.D c;
    protected X d;
    protected y.c.h e;
    protected A f;
    protected E g;
    protected y.c.h h;
    protected boolean i = false;
    protected int j;
    protected F k;
    protected List l = new ArrayList();

    public void a(y.f.h.D d2, c c2, int n2) {
        int n3 = h.a;
        this.c = d2;
        this.j = n2;
        this.d = (X)d2.g();
        this.e = this.d.u();
        this.f = this.d.t();
        this.g = null;
        this.d.a(a, this.f);
        y.c.e e2 = this.d.p();
        while (e2.f()) {
            d d3 = e2.a();
            S[] arrs = (S[])c2.b(d3);
            if (n3 != 0) return;
            if (arrs != null) {
                C[] arrc;
                block5 : {
                    ArrayList<S> arrayList = new ArrayList<S>(arrs.length);
                    for (int i2 = 0; i2 < arrs.length; ++i2) {
                        arrayList.add(arrs[i2]);
                        if (n3 == 0) {
                            if (n3 == 0) continue;
                        }
                        break block5;
                    }
                    this.l.addAll(arrayList);
                    y.g.e.a(arrayList, (Comparator)new g());
                    this.e.a((Object)d3, arrayList);
                }
                if (this.g == null && (arrc = this.d.d(d3)) != null && arrc.length > 0) {
                    C c3 = arrc[0];
                    this.g = c3.getLabelModel();
                }
            }
            e2.g();
            if (n3 == 0) continue;
        }
        d2.a(this);
        this.k = new F();
    }

    public void a(y.c.h h2) {
        this.h = h2;
    }

    public void a(h h2) {
        this.b = h2;
    }

    public void a() {
        this.d.d_(a);
        this.d.a(this.e);
        this.d.a(this.f);
        this.c.b(this);
    }

    public void b() {
        block2 : {
            e e2;
            int n2 = h.a;
            this.i = true;
            d[] arrd = this.d.n();
            for (int i2 = 0; i2 < arrd.length; ++i2) {
                d d2 = arrd[i2];
                e2 = this;
                if (n2 == 0) {
                    ArrayList arrayList;
                    int n3;
                    if (e2.c.n(d2) || (arrayList = (ArrayList)this.e.b(d2)) == null || (n3 = arrayList.size()) == 0) continue;
                    this.b.e(d2, n3);
                    if (n2 == 0) continue;
                }
                break block2;
            }
            e2 = this;
        }
        e2.i = false;
    }

    private static y.d.y a(y.d.y y2, t t2) {
        y.d.y y3 = new y.d.y(y2.c() - 5.0, y2.d() - 5.0, y2.a() + 10.0, y2.b() + 10.0);
        double d2 = Math.min(y3.c(), t2.a());
        double d3 = Math.min(y3.d(), t2.b());
        double d4 = Math.max(y3.c() + y3.a(), t2.a());
        double d5 = Math.max(y3.d() + y3.b(), t2.b());
        return new y.d.y(d2, d3, d4 - d2, d5 - d3);
    }

    /*
     * Exception decompiling
     */
    public void a(y.f.f.d.C var1_1) {
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

    private D a(y.d.y y2, D d2) {
        int n2 = h.a;
        D d3 = new D();
        y.c.C c2 = d2.m();
        do {
            if (!c2.f()) return d3;
            y.d.y y3 = (y.d.y)c2.d();
            if (y.d.y.a(y3, y2) || y3.b(y2) || y2.b(y3)) {
                d3.add(y3);
            }
            c2.g();
        } while (n2 == 0);
        return d3;
    }

    @Override
    public void a(d d2, d[] arrd) {
        if (this.i) {
            this.c(d2, arrd);
            if (h.a == 0) return;
        }
        this.b(d2, arrd);
    }

    public void b(d d2, d[] arrd) {
        Object object3;
        ArrayList<Object> arrayList;
        Object object2;
        ArrayList<Object> arrayList2;
        int n2;
        ArrayList<Object> arrayList3;
        int n3;
        int n4;
        block6 : {
            n2 = h.a;
            ArrayList arrayList4 = (ArrayList)this.e.b(d2);
            if (arrayList4 == null) return;
            if (arrayList4.isEmpty()) return;
            if (arrd.length < 2) {
                return;
            }
            arrayList = new ArrayList<Object>();
            arrayList3 = new ArrayList<Object>();
            arrayList2 = new ArrayList<Object>();
            for (Object object3 : arrayList4) {
                n4 = object3.f().a();
                object2 = object3.f();
                n3 = (int)object2.i() ? 1 : 0;
                if (n2 == 0) {
                    if (n3 != 0) {
                        arrayList.add(object3);
                        if (n2 == 0) continue;
                    }
                    if (!object2.i() && !object2.j()) {
                        arrayList2.add(object3);
                        if (n2 == 0) continue;
                    }
                    arrayList3.add(object3);
                    if (n2 == 0) continue;
                }
                break block6;
            }
            n3 = arrd.length;
        }
        if (n3 == 2) {
            this.e.a((Object)arrd[0], arrayList);
            arrayList3.addAll(arrayList2);
            this.e.a((Object)arrd[1], arrayList3);
            if (n2 == 0) return;
        }
        d d3 = arrd[0];
        object3 = arrd[arrd.length - 1];
        n4 = (arrd.length + 1) / 2 - 1;
        object2 = arrd[n4];
        this.e.a((Object)d3, arrayList);
        this.e.a(object3, arrayList2);
        this.e.a(object2, arrayList3);
    }

    private static a a(double d2) {
        a a2 = new a();
        a2.a(0.0);
        a2.b(0.0);
        a2.c(d2);
        return a2;
    }

    /*
     * Unable to fully structure code
     */
    public void c(d var1_1, d[] var2_2) {
        var12_3 = h.a;
        var3_4 = (ArrayList)this.e.b(var1_1);
        var4_5 = this.a(var1_1);
        if (this.h == null || this.h.b(var1_1) == null) ** GOTO lbl-1000
        var5_6 = (a)this.h.b(var1_1);
        var6_8 = 0;
        for (var7_10 = 0; var7_10 < var3_4.size(); var6_8 += (int)Math.floor((double)(var4_5.e() != false ? var8_12.c() : var8_12.b())), ++var7_10) {
            var8_12 = (S)var3_4.get(var7_10);
            v0 = this;
            if (var12_3 == 0) {
                if (v0.k == null) continue;
                this.k.a((i)this.d, var8_12, var4_5);
                if (var12_3 == 0) continue;
            }
            ** GOTO lbl17
        }
        if ((var7_10 = (int)Math.ceil(Math.max(var5_6.a() + var5_6.b(), var5_6.c()))) > var6_8) {
            v0 = this;
lbl17: // 2 sources:
            var8_13 = v0.j * ((var7_10 - var6_8) / ((var3_4.size() + 1) * this.j));
            var9_15 = var7_10 - var8_13 * (var3_4.size() + 1);
            for (var10_16 = 0; var10_16 < var2_2.length; ++var10_16) {
                v1 = var10_16;
                if (var12_3 == 0) {
                    var11_17 = v1 == 0 ? var8_13 + var9_15 : var8_13;
                    this.h.a((Object)var2_2[var10_16], e.a(var11_17));
                    if (var12_3 == 0) continue;
                }
                break;
            }
        } else lbl-1000: // 4 sources:
        {
            v1 = 0;
        }
        var5_7 = v1;
        do {
            if (var5_7 >= var3_4.size()) return;
            var6_9 = var2_2[var5_7].d();
            this.c.g(var6_9);
            var7_11 = (S)var3_4.get(var5_7);
            this.f.a((Object)var6_9, var7_11);
            var8_14 = this.a(var7_11, var1_1);
            this.d.a(var6_9, var8_14);
            ++var5_7;
        } while (var12_3 == 0);
    }

    private y a(d d2) {
        o o2 = this.b.h(d2);
        if (o.a.a(o2)) {
            return y.a;
        }
        if (o.b.a(o2)) {
            return y.b;
        }
        if (o.c.a(o2)) {
            return y.c;
        }
        if (!o.d.a(o2)) return null;
        return y.d;
    }

    private q a(S s2, d d2) {
        y y2 = this.a(d2);
        aG aG2 = s2.f();
        double d3 = s2.b();
        double d4 = s2.c();
        if (aG2.m()) return new q(d3, d4);
        if (y2 == y.c || y2 == y.a) {
            d3 += Math.max(0.0, aG2.h());
            if (h.a == 0) return new q(d3, d4);
        }
        if (y2 != y.d) {
            if (y2 != y.b) return new q(d3, d4);
        }
        d4 += Math.max(0.0, aG2.h());
        return new q(d3, d4);
    }

    private void a(S s2, y.c.q q2) {
        int n2 = h.a;
        d d2 = this.a(q2);
        double d3 = this.d.p(d2).a();
        double d4 = this.d.p(d2).b();
        aG aG2 = s2.f();
        int n3 = this.a(d2, aG2);
        double d5 = s2.b();
        double d6 = s2.c();
        double d7 = this.d.m(q2);
        double d8 = this.d.n(q2);
        double d9 = Math.max(0.0, aG2.h());
        switch (n3) {
            case 2: {
                d7 = d3 + d9;
                if (n2 == 0) break;
            }
            case 3: {
                d7 = d3 - d9 - d5;
                if (n2 == 0) break;
            }
            case 1: {
                d8 = d4 + d9;
                if (n2 == 0) break;
            }
            case 0: {
                d8 = d4 - d9 - d6;
            }
        }
        t t2 = new t(d7 + d5 * 0.5, d8 + d6 * 0.5);
        s2.a().b(t2);
    }

    private d a(y.c.q q2) {
        d d2 = q2.g();
        if (!this.b.c(d2)) return d2;
        return this.b.a(d2);
    }

    public void c() {
        int n2 = h.a;
        if (this.k == null) return;
        Iterator iterator = this.l.iterator();
        do {
            if (!iterator.hasNext()) return;
            S s2 = (S)iterator.next();
            this.k.a((i)this.d, s2);
        } while (n2 == 0);
    }

    private int a(d d2, aG aG2) {
        byte by2 = aG2.b();
        y y2 = this.a(d2);
        if (by2 == 8) return 4;
        if (y2 == y.a) {
            if (by2 == 16) return 3;
        }
        if (y2 == y.c && by2 == 32) {
            return 3;
        }
        if (y2 == y.a) {
            if (by2 == 32) return 2;
        }
        if (y2 == y.c && by2 == 16) {
            return 2;
        }
        if (y2 == y.d) {
            if (by2 == 32) return 0;
        }
        if (y2 == y.b && by2 == 16) {
            return 0;
        }
        if (y2 == y.d) {
            if (by2 == 16) return 1;
        }
        if (y2 != y.b) return 4;
        if (by2 != 32) return 4;
        return 1;
    }

    @Override
    public void a(d[] arrd, d d2) {
        int n2 = h.a;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < arrd.length; ++i2) {
            ArrayList arrayList2 = (ArrayList)this.e.b(arrd[i2]);
            if (n2 != 0) return;
            if (arrayList2 == null) continue;
            if (arrayList == null) {
                arrayList = arrayList2;
                if (n2 == 0) continue;
            }
            arrayList.addAll(arrayList2);
            if (n2 == 0) continue;
        }
        this.e.a((Object)d2, arrayList);
    }

    @Override
    public void a(d d2, p[] arrp, p[] arrp2) {
    }

    @Override
    public void b(d d2, p[] arrp, p[] arrp2) {
    }

    private S b(y.c.q q2) {
        return (S)this.f.b(q2);
    }
}

