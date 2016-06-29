/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import y.a.m;
import y.c.A;
import y.c.D;
import y.c.I;
import y.c.c;
import y.c.d;
import y.c.h;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.bR;
import y.f.c.a.cA;
import y.f.c.a.dA;
import y.f.c.a.dB;
import y.f.c.a.du;
import y.f.c.a.dv;
import y.f.c.a.dw;
import y.f.c.a.dy;
import y.f.c.a.dz;
import y.g.e;

class dt
extends cA
implements bR {
    private final boolean c;
    private dA d;
    private dA e;

    dt(boolean bl2) {
        this.c = bl2;
    }

    @Override
    public void a() {
        if (this.e != null) {
            throw new IllegalStateException("Internal sequence constraints not disposed.");
        }
        this.d = null;
    }

    @Override
    public boolean a(i i2, q q2, q q3) {
        if (this.d == null) {
            return false;
        }
        if (this.d.a(q2)) return false;
        if (this.d.a(q3)) {
            return false;
        }
        q q4 = this.d.c(q2);
        q q5 = this.d.c(q3);
        if (q4 == null) {
            if (q5 == null) return false;
            dy dy2 = dA.a(this.d, q5);
            return dy2.b();
        }
        dy dy3 = dA.a(this.d, q4);
        if (q5 == null) return dy3.a();
        dy dy4 = dA.a(this.d, q5);
        if (dy3.c > -1) {
            if (dy4.c <= -1) return dy3.a();
            return dA.b(this.d)[dy3.c][dy4.c];
        }
        if (dy4.c > -1) {
            return dy4.b();
        }
        if (dy3.b == dy4.b) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void a(i var1_1, int[] var2_2, int[] var3_3) {
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

    private static void a(i i2, A a2) {
        boolean bl2 = N.x;
        y y2 = m.a(i2);
        x x2 = y2.a();
        do {
            int n2;
            q q2;
            int n3 = x2.f();
            block1 : do {
                if (n3 == 0) return;
                q2 = x2.e();
                n2 = -1;
                y.c.e e2 = q2.k();
                while (e2.f()) {
                    d d2 = e2.a();
                    int n4 = a2.a(d2.c());
                    n3 = n2;
                    if (bl2) continue block1;
                    if (n3 < n4) {
                        n2 = n4;
                    }
                    e2.g();
                    if (!bl2) continue;
                }
                break block1;
                break;
            } while (true);
            a2.a((Object)q2, ++n2);
            x2.g();
        } while (!bl2);
    }

    @Override
    public void a(i i2, aU aU2, aV aV2) {
        boolean bl2 = N.x;
        if (this.d == null) {
            return;
        }
        if (!this.a(new dB(aU2), null)) {
            return;
        }
        du du2 = new du(this);
        Object[] arrobject = new q[]{};
        int n2 = 0;
        int n3 = aU2.b();
        block0 : do {
            p p2;
            y y2;
            int n4;
            block7 : {
                if (n2 >= n3) return;
                y2 = aU2.a(n2).d();
                if (arrobject.length < y2.size()) {
                    arrobject = new q[y2.size()];
                }
                n4 = 0;
                for (p2 = y2.k(); p2 != null; p2 = p2.a()) {
                    arrobject[n4++] = (q)p2.c();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block7;
                }
                e.a(arrobject, 0, n4, du2);
                n4 = 0;
            }
            for (p2 = y2.k(); p2 != null; p2 = p2.a()) {
                p2.a(arrobject[n4++]);
                if (bl2) continue block0;
                if (!bl2) continue;
            }
            aU2.a(n2).a(y2);
            ++n2;
        } while (!bl2);
    }

    @Override
    public Comparator a(i i2, D[] arrd, int[] arrn) {
        if (this.d == null) {
            throw new IllegalStateException("SequenceConstraintSupport has not been initialized.");
        }
        this.a(new dz(arrd), arrn);
        return new dv(this);
    }

    private boolean a(Iterator iterator, int[] arrn) {
        D d2;
        boolean bl2;
        i i2;
        Object object;
        dz dz2;
        boolean bl3;
        block19 : {
            int[] arrn2;
            Object object2;
            I i3;
            bl3 = N.x;
            i2 = dA.c(this.d);
            bl2 = false;
            HashSet<d> hashSet = new HashSet<d>();
            d2 = new D();
            block0 : while (iterator.hasNext()) {
                Object object3 = iterator.next();
                block1 : while ((arrn2 = (int[])object3).size() >= 2) {
                    block17 : {
                        if (arrn != null) {
                            object = new q[arrn2.size()];
                            arrn2.toArray((Object[])object);
                            e.a((Object[])object, (Comparator)new dw(this, arrn));
                            dz2 = new dz((Object[])object);
                            if (!bl3) break block17;
                        }
                        dz2 = arrn2.iterator();
                    }
                    object = new y();
                    object.add(dz2.next());
                    while (dz2.hasNext()) {
                        q q2 = (q)dz2.next();
                        object3 = object.a();
                        if (bl3) continue block1;
                        Object object4 = object3;
                        while (object4.f()) {
                            q q3;
                            object2 = object4.e();
                            object3 = i3 = this.d.c((q)object2);
                            if (bl3) continue block1;
                            if (object3 == null) {
                                i3 = this.d.d((q)object2);
                            }
                            if ((q3 = this.d.c(q2)) == null) {
                                q3 = this.d.d(q2);
                            }
                            d d3 = i2.a((q)i3, q3);
                            hashSet.add(d3);
                            d2.add(d3);
                            object4.g();
                            if (!bl3) continue;
                        }
                        object.add(q2);
                        if (!bl3) continue;
                    }
                    continue block0;
                }
            }
            if ((arrn2 = dA.e(this.d)).length < i2.f()) {
                arrn2 = new int[i2.f()];
            }
            if (!m.a(i2, arrn2)) {
                bl2 = true;
                dz2 = i2.u();
                object = i2.u();
                int n2 = 2 * hashSet.size();
                object2 = i2.p();
                while (object2.f()) {
                    block18 : {
                        if (hashSet.contains(object2.a())) {
                            object.a((Object)object2.a(), 1.0);
                            if (!bl3) break block18;
                        }
                        object.a((Object)object2.a(), (double)n2);
                    }
                    object2.g();
                    if (!bl3) continue;
                }
                y.a.c.a(i2, (h)((Object)dz2), (c)object);
                object2 = d2.iterator();
                while (object2.hasNext()) {
                    i3 = (d)object2.next();
                    if (!dz2.d(i3)) continue;
                    i2.a((d)i3);
                    object2.remove();
                    if (!bl3) {
                        if (!bl3) continue;
                    }
                    break block19;
                }
                if (!m.a(i2, arrn2)) {
                    throw new IllegalArgumentException("Cyclic sequence constraints!");
                }
            }
            dA.a(this.d, arrn2);
        }
        dz2 = d2.iterator();
        do {
            if (!dz2.hasNext()) return bl2;
            object = (d)dz2.next();
            i2.a((d)object);
        } while (!bl3);
        return bl2;
    }

    @Override
    public void b(i i2, aV aV2, boolean bl2) {
        if (this.e != null) {
            this.d = this.e.a(this.d);
            this.e = null;
        }
        this.d.b();
    }

    @Override
    public void a(i i2, aV aV2, boolean bl2) {
        this.e = this.d;
        this.d = new dA(i2, aV2, bl2, this.c);
        this.d.a();
    }

    static dA a(dt dt2) {
        return dt2.d;
    }
}

