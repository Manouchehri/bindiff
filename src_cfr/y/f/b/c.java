/*
 * Decompiled with CFR 0_115.
 */
package y.f.b;

import java.util.HashMap;
import java.util.HashSet;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.i;
import y.c.p;
import y.c.x;
import y.c.y;
import y.f.b.d;
import y.f.b.e;
import y.f.b.f;
import y.g.q;

public class c
implements f {
    private i g;
    private A h;
    private e i;
    public static int a;

    public c(i i2) {
        this.g = i2;
        this.a();
    }

    /*
     * Unable to fully structure code
     */
    protected void a() {
        var10_1 = c.a;
        var1_2 = this.g.c(f.b);
        if (var1_2 == null) {
            var1_2 = new d(this);
        }
        if ((var2_3 = this.g.c(f.c)) == null) {
            var2_3 = q.a((Object)null);
        }
        if ((var3_4 = this.g.c(f.d)) == null) {
            var3_4 = q.a(Boolean.FALSE);
        }
        this.h = this.a(this.g);
        this.i = new e(null, new y());
        var4_5 = new HashMap<Object, y.c.q>();
        var5_6 = this.g.o();
        while (var5_6.f()) {
            var6_7 = var5_6.e();
            v0 = var7_8 = var1_2.b(var6_7);
            if (var10_1 == 0) {
                if (v0 == null) {
                    throw new IllegalArgumentException(new StringBuffer().append("no id defined for node ").append(var6_7).toString());
                }
                var4_5.put(var7_8, var6_7);
                var5_6.g();
                if (var10_1 == 0) continue;
            }
            ** GOTO lbl27
        }
        var5_6 = this.g.o();
        while (var5_6.f()) {
            var6_7 = var5_6.e();
            v0 = var4_5.get(var2_3.b(var6_7));
lbl27: // 2 sources:
            var7_8 = (y.c.q)v0;
            var8_9 = this.i(var6_7);
            var9_10 = this.i((y.c.q)var7_8);
            this.a(var9_10, var6_7);
            var8_9.a = var7_8;
            if (var10_1 != 0) return;
            if (var3_4.d(var6_7) && var8_9.b == null) {
                var8_9.b = new y();
            }
            var5_6.g();
            if (var10_1 == 0) continue;
        }
        this.a(this.b(), this.i);
    }

    /*
     * Exception decompiling
     */
    private void a(y.c.q var1_1, e var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[FORLOOP]], but top level block is 3[FORLOOP]
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

    private void a(e e2, y.c.q q2) {
        if (e2.b == null) {
            e2.b = new y();
        }
        e2.b.add(q2);
    }

    private e i(y.c.q q2) {
        if (q2 == null) {
            return this.i;
        }
        e e2 = (e)this.h.b(q2);
        if (e2 != null) return e2;
        e2 = new e(null, null);
        this.h.a((Object)q2, e2);
        return e2;
    }

    protected A a(i i2) {
        return i2.t();
    }

    protected void a(i i2, A a2) {
        if (i2 == null) return;
        if (a2 == null) return;
        i2.a(a2);
    }

    public y.c.q a(y.c.q q2) {
        if (q2 != null) return ((e)this.h.b((Object)q2)).a;
        throw new IllegalArgumentException("node is root!");
    }

    public y.c.q b() {
        return null;
    }

    public y b(y.c.q q2) {
        y y2;
        if (q2 == null) {
            y2 = this.i.b;
            return y2;
        }
        y2 = ((e)this.h.b((Object)q2)).b;
        return y2;
    }

    public y c(y.c.q q2) {
        y y2 = new y();
        this.a(q2, y2);
        return y2;
    }

    private void a(y.c.q q2, y y2) {
        int n2 = a;
        e e2 = q2 == null ? this.i : (e)this.h.b(q2);
        p p2 = e2.b.k();
        do {
            if (p2 == null) return;
            y.c.q q3 = (y.c.q)p2.c();
            y2.add(q3);
            if (this.d(q3)) {
                this.a(q3, y2);
            }
            p2 = p2.a();
        } while (n2 == 0);
    }

    public boolean d(y.c.q q2) {
        if (q2 == null) return true;
        if (((e)this.h.b((Object)q2)).b != null) return true;
        return false;
    }

    public boolean e(y.c.q q2) {
        if (!this.d(q2)) return false;
        if (this.b(q2).isEmpty()) return false;
        return true;
    }

    public boolean a(y.c.d d2) {
        if (this.a(d2.c()) != this.a(d2.d())) return false;
        return true;
    }

    public y.c.f f(y.c.q q2) {
        return this.i((y.c.q)q2).c;
    }

    public y.c.f g(y.c.q q2) {
        return this.i((y.c.q)q2).d;
    }

    public y.c.q a(y.c.q q2, y.c.q q3) {
        y.c.q q4;
        block3 : {
            int n2 = a;
            if (q2 == null) {
                throw new IllegalArgumentException("no representative for virtual root!");
            }
            y.c.q q5 = this.a(q2);
            while (q5 != q3) {
                q4 = q5;
                if (n2 == 0) {
                    if (q4 == null) break;
                    q2 = q5;
                    q5 = this.a(q2);
                    if (n2 == 0) continue;
                }
                break block3;
            }
            q4 = q5;
        }
        if (q4 != null) return q2;
        if (q3 == null) return q2;
        return null;
    }

    public void c() {
        this.a(this.g, this.h);
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public static boolean b(i i2) {
        if (i2.c(f.d) == null) return false;
        if (i2.c(f.b) == null) return false;
        if (i2.c(f.c) == null) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public static boolean c(i var0) {
        var5_1 = c.a;
        if (!c.b(var0)) {
            return true;
        }
        var1_2 = var0.c(f.b);
        var2_3 = var0.c(f.c);
        var3_4 = new HashSet<Object>();
        var4_5 = var0.o();
        while (var4_5.f()) {
            var3_4.add(var2_3.b(var4_5.e()));
            v0 = var3_4.contains(var1_2.b(var4_5.e()));
            if (var5_1 == 0) {
                if (v0) {
                    return false;
                }
                var4_5.g();
                if (var5_1 == 0) continue;
            }
            ** GOTO lbl20
        }
        var4_5 = var0.o();
        do {
            v0 = var4_5.f();
lbl20: // 2 sources:
            if (v0 == false) return true;
            v1 = var3_4.contains(var1_2.b(var4_5.e()));
            if (var5_1 != 0) return v1;
            if (v1) {
                return false;
            }
            var4_5.g();
        } while (var5_1 == 0);
        return true;
    }

    D h(y.c.q q2) {
        D d2;
        int n2 = a;
        D d3 = new D();
        y.c.q q3 = this.a(q2);
        while (q3 != null) {
            d2 = d3;
            if (n2 != 0) return d2;
            d2.add(q3);
            q3 = this.a(q3);
            if (n2 == 0) continue;
        }
        d2 = d3;
        return d2;
    }

    /*
     * Unable to fully structure code
     */
    public y.c.q b(y.c.q var1_1, y.c.q var2_2) {
        var9_3 = c.a;
        if (var1_1 == var2_2) {
            return this.a(var1_1);
        }
        if (var1_1 == null) return null;
        if (var2_2 == null) {
            return null;
        }
        var3_4 = new int[var1_1.e().e()];
        var4_5 = this.h(var1_1);
        var5_6 = this.h(var2_2);
        v0 = var3_4;
        v1 = var1_1.d();
        v0[v1] = v0[v1] + 1;
        var6_7 = var4_5.m();
        while (var6_7.f()) {
            var7_8 = var6_7.d();
            var8_9 = null;
            v2 = var7_8 instanceof y.c.q;
            if (var9_3 == 0) {
                if (v2) {
                    var8_9 = (y.c.q)var7_8;
                }
                if (var8_9 != null) {
                    v3 = var3_4;
                    v4 = var8_9.d();
                    v3[v4] = v3[v4] + 1;
                }
                var6_7.g();
                if (var9_3 == 0) continue;
            }
            ** GOTO lbl31
        }
        var6_7 = var5_6.m();
        do {
            v2 = var6_7.f();
lbl31: // 2 sources:
            if (v2 == false) return this.b();
            var7_8 = var6_7.d();
            var8_9 = null;
            if (var7_8 instanceof y.c.q && (var8_9 = (y.c.q)var7_8) != null && var3_4[var8_9.d()] > 0) {
                return var8_9;
            }
            var6_7.g();
        } while (var9_3 == 0);
        return this.b();
    }
}

