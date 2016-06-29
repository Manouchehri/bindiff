/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.a.b;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.e;
import y.c.f;
import y.d.m;
import y.d.q;
import y.d.s;
import y.d.t;
import y.f.E;
import y.f.I;
import y.f.K;
import y.f.Q;
import y.f.X;
import y.f.ae;
import y.f.ah;
import y.f.aj;
import y.f.al;
import y.f.am;
import y.f.as;
import y.f.g.d;
import y.f.i.ab;
import y.f.i.i;
import y.f.i.n;
import y.f.i.v;
import y.g.M;
import y.h.aA;
import y.h.aB;
import y.h.b.h;
import y.h.bI;
import y.h.bu;
import y.h.cF;
import y.h.eR;
import y.h.eU;
import y.h.fL;
import y.h.fM;
import y.h.fN;
import y.h.ff;
import y.h.fj;
import y.h.gZ;
import y.h.gu;
import y.h.gv;
import y.h.gw;
import y.h.gx;
import y.h.hW;
import y.h.hX;
import y.h.x;
import y.h.y;

class hV {
    private cF f;
    static final Object a = "STRAIGHT_LINE";
    static final Object b = "ORTHOGONAL";
    static final Object c = "PARAXIAL";
    static final Object d = "MARKED_INTER_EDGES";
    static final Object e = "ORTHOGONAL_INTER_EDGES";

    hV(cF cF2) {
        this.f = cF2;
    }

    void a(bu bu2) {
        y.c.y y2 = new y.c.y();
        f f2 = new f();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.f.a(bu2, y2, f2, hashMap, hashMap2);
        if (y2.isEmpty() && f2.isEmpty()) {
            D d2 = new D();
            D d3 = new D();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            this.f.a(bu2, d2, d3, hashMap3, hashMap4);
            this.f.b(bu2, d2, d3, hashMap3, hashMap4);
            this.f.c(bu2, d2, d3, hashMap3, hashMap4);
            if (!fj.z) return;
        }
        this.f.b(bu2, y2, f2, hashMap, hashMap2);
        this.f.c(bu2, y2, f2, hashMap, hashMap2);
    }

    void a(bu bu2, y.c.y y2, f f2, Map map, Map map2) {
        y.c.y[] arry;
        Object object;
        Object object2;
        boolean bl2 = fj.z;
        y.c.y y3 = this.f.a(bu2);
        if (!y3.isEmpty()) {
            block4 : {
                object = bu2.t();
                arry = b.a((y.c.i)bu2, y3, false, (A)object, 2);
                if (arry.length > 1) {
                    object2 = arry[1];
                    if (!bl2) break block4;
                }
                object2 = new y.c.y();
            }
            this.a(bu2, y3, (y.c.y)object2, new f(bu2.p()), false, y2, f2, map, map2);
            if (!bl2) return;
        }
        object = new y.c.y();
        arry = this.f.b(bu2);
        object2 = arry.a();
        while (object2.f()) {
            y.c.d d2 = object2.a();
            object.add(d2.c());
            object.add(d2.d());
            object2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.a(bu2, new y.c.y(), (y.c.y)object, (f)arry, true, new y.c.y(), f2, map, map2);
    }

    y.c.y b(bu bu2) {
        boolean bl2 = fj.z;
        y.c.y y2 = new y.c.y();
        y.c.x x2 = bu2.o();
        do {
            if (!x2.f()) return y2;
            y.c.q q2 = x2.e();
            if (bu2.v(q2)) {
                y2.add(q2);
            }
            x2.g();
        } while (!bl2);
        return y2;
    }

    f c(bu bu2) {
        boolean bl2 = fj.z;
        f f2 = new f();
        e e2 = bu2.p();
        do {
            if (!e2.f()) return f2;
            y.c.d d2 = e2.a();
            if (bu2.r(d2)) {
                f2.add(d2);
            }
            e2.g();
        } while (!bl2);
        return f2;
    }

    void b(bu bu2, y.c.y y2, f f2, Map map, Map map2) {
        if (y2.isEmpty()) {
            this.a(bu2, f2, map2, 20.0, 20.0);
            if (!fj.z) return;
        }
        this.a(bu2, y2, f2, map2);
        hV.a(bu2, y2);
        bu2.d_(d);
    }

    void a(bu bu2, y.c.y y2, f f2, Map map) {
        boolean bl2;
        HashSet hashSet;
        Object object;
        Object object2;
        y.c.h h2;
        f f3;
        boolean bl3;
        block6 : {
            bl2 = fj.z;
            hashSet = new HashSet(y2);
            h2 = M.b();
            f3 = new f();
            e e2 = f2.a();
            while (e2.f()) {
                object = e2.a();
                bl3 = hashSet.contains(object.c());
                if (!bl2) {
                    if (bl3 && !hashSet.contains(object.d()) || !hashSet.contains(object.c()) && hashSet.contains(object.d())) {
                        object2 = hV.a(bu2, (y.c.d)map.get(object));
                        h2.a(object, object2);
                        if (object2 == c) {
                            f3.add(object);
                        }
                    }
                    e2.g();
                    if (!bl2) continue;
                }
                break block6;
            }
            bl3 = f3.isEmpty();
        }
        if (!bl3) {
            boolean bl4 = ae.b((X)bu2, new hW(this, hashSet));
            object = bl4 ? b : a;
            object2 = f3.a();
            while (object2.f()) {
                h2.a((Object)object2.a(), object);
                object2.g();
                if (bl2) return;
                if (!bl2) continue;
            }
        }
        bu2.a(d, h2);
    }

    /*
     * Unable to fully structure code
     */
    static Object a(bu var0, y.c.d var1_1) {
        block4 : {
            var8_2 = fj.z;
            var2_3 = 0;
            var3_4 = false;
            var4_5 = var0.l(var1_1).j();
            while (var4_5.f()) {
                var5_6 = var4_5.a();
                var6_7 = var5_6.c();
                var7_8 = var5_6.d();
                v0 = Math.abs(var6_7.a() - var7_8.a()) DCMPG 1.0E-12;
                if (var8_2) break block4;
                if (v0 >= 0) ** GOTO lbl-1000
                var3_4 = true;
                if (var8_2) lbl-1000: // 2 sources:
                {
                    if (Math.abs(var6_7.b() - var7_8.b()) >= 1.0E-12) return hV.a;
                    var2_3 = 1;
                    if (var8_2) {
                        return hV.a;
                    }
                }
                var4_5.g();
                if (!var8_2) continue;
            }
            v0 = var2_3;
        }
        if (v0 != 0 && var3_4) {
            v1 = hV.b;
            return v1;
        }
        v1 = hV.c;
        return v1;
    }

    void a(bu bu2, y.c.y y2, f f2) {
        bu2.N();
        if (y2.isEmpty()) {
            if (f2.isEmpty()) return;
            bu2.a(f2.a(), true);
            if (!fj.z) return;
        }
        bu2.a(y2.a(), true);
    }

    /*
     * Exception decompiling
     */
    private void a(bu var1_1, y.c.y var2_2, y.c.y var3_3, f var4_4, boolean var5_5, y.c.y var6_6, f var7_7, Map var8_8, Map var9_9) {
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
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void a(bu var1_1, f var2_2, Map var3_3, double var4_4, double var6_5) {
        block6 : {
            var14_6 = fj.z;
            var8_7 = M.b();
            var9_8 = var2_2.a();
            while (var9_8.f()) {
                var10_9 = var9_8.a();
                if (var14_6) break block6;
                if (!var10_9.e() || var1_1.i((y.c.d)var10_9).bendCount() > 1) ** GOTO lbl-1000
                var11_10 = var1_1.i((y.c.d)var10_9);
                var12_11 = var11_10.getSourceRealizer();
                if (var1_1.i((y.c.d)var10_9).bendCount() == 0) {
                    var11_10.appendBend(var11_10.getSourcePort().a(var12_11), var11_10.getSourcePort().b(var12_11) - 20.0 - var12_11.getHeight());
                }
                this.a(var1_1, var4_4, var6_5, (y.c.d)var10_9, true, false, false, var10_9.c());
                if (var14_6) lbl-1000: // 2 sources:
                {
                    var8_7.a(var10_9, true);
                    var8_7.a((Object)var3_3.get(var10_9), true);
                }
                var9_8.g();
                if (!var14_6) continue;
            }
            var1_1.a(as.a, var8_7);
        }
        var9_8 = new as();
        var9_8.a(5.0);
        var9_8.b(false);
        var9_8.a(true);
        try {
            var10_9 = new bI(1);
            var10_9.a(false);
            var10_9.b(true);
            var10_9.d().a(true);
            var10_9.a(var1_1, (ah)var9_8);
            return;
        }
        finally {
            var1_1.d_(as.a);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void a(bu bu2, y.c.y y2) {
        Object object;
        Object object2;
        A a2;
        block8 : {
            boolean bl2;
            block7 : {
                bl2 = fj.z;
                a2 = bu2.t();
                y.c.x x2 = y2.a();
                while (x2.f()) {
                    object2 = x2.e();
                    a2.a(object2, true);
                    x2.g();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block7;
                }
                bu2.a(d.a, a2);
            }
            boolean bl3 = bu2.c(d) != null;
            object2 = new d();
            object2.b(3);
            object2.a(2);
            if (bl3) {
                object = new v();
                object.b(2);
                object.a(e);
                object.f(true);
                object.d(4);
                object.e(false);
                object.c(5);
                object.c(true);
                object.a(1);
                object.b(true);
                object.c(1);
                object.a("routingPreferMiddleOfNode", (Object)Boolean.TRUE);
                i i2 = new i(new n(new ab(new y.f.i.X((ah)object))));
                object2.b(new hX(i2));
                if (!bl2) break block8;
            }
            object2.c(2);
        }
        object2.d(5);
        object2.a(true);
        object2.b(false);
        try {
            object = new bI(1);
            object.a(false);
            object.b(true);
            object.d().a(true);
            object.a(bu2, (ah)object2);
            return;
        }
        finally {
            bu2.d_(d.a);
            bu2.a(a2);
        }
    }

    /*
     * Unable to fully structure code
     */
    void a(bu var1_1, double var2_2, double var4_3, y.c.d var6_4, boolean var7_5, boolean var8_6, boolean var9_7, y.c.q var10_8) {
        var14_9 = fj.z;
        var11_10 = var1_1.i(var6_4);
        if (var11_10.bendCount() <= 0) return;
        var12_11 = 0;
        var13_12 = var11_10.bends();
        do {
            if (var13_12.f() == false) return;
            if (var6_4.c() != var10_8 || var12_11 != 0 || !var8_6 && !var9_7) ** GOTO lbl15
            if (!var8_6) ** GOTO lbl12
            var13_12.a().b(0.0, var4_3);
            if (!var14_9) ** GOTO lbl24
lbl12: // 2 sources:
            if (!var9_7) ** GOTO lbl24
            var13_12.a().b(var2_2, 0.0);
            if (!var14_9) ** GOTO lbl24
lbl15: // 2 sources:
            if (var6_4.d() != var10_8 || var12_11 != var11_10.bendCount() - 1 || !var8_6 && !var9_7) ** GOTO lbl-1000
            if (!var8_6) ** GOTO lbl-1000
            var13_12.a().b(0.0, var4_3);
            if (var14_9) lbl-1000: // 2 sources:
            {
                if (var9_7) {
                    var13_12.a().b(var2_2, 0.0);
                    ** if (!var14_9) goto lbl24
                }
            }
            ** GOTO lbl24
lbl-1000: // 2 sources:
            {
                var13_12.a().b(var2_2, var4_3);
            }
lbl24: // 6 sources:
            if (var7_5) {
                var13_12.a().a(true);
            }
            var13_12.g();
            ++var12_11;
        } while (!var14_9);
    }

    void a(bu bu2, List list, List list2, Map map, Map map2) {
        Object object;
        boolean bl2;
        Object object2;
        Set set;
        block8 : {
            Iterator iterator;
            y.c.y y2;
            bl2 = fj.z;
            List list3 = this.f.c(bu2);
            if (!list3.isEmpty()) {
                block7 : {
                    set = new HashSet();
                    y2 = new y.c.y();
                    iterator = list3.iterator();
                    while (iterator.hasNext()) {
                        object = ((eR)iterator.next()).f();
                        if (!set.add(object)) continue;
                        y2.add(object);
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block7;
                    }
                    bu2.a(y2.a());
                }
                iterator = list3.iterator();
                do {
                    if (!iterator.hasNext()) return;
                    object = (eR)iterator.next();
                    object2 = (eR)object.clone();
                    object.g().addLabel((eR)object2);
                    list.add(object2);
                    map.put(object2, object);
                } while (!bl2);
            }
            if ((set = this.f.d(bu2)).isEmpty()) return;
            y2 = new HashSet();
            iterator = new f();
            object = set.iterator();
            while (object.hasNext()) {
                object2 = ((aA)object.next()).getEdge();
                if (y2.contains(object2)) continue;
                y2.add(object2);
                iterator.add(object2);
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block8;
            }
            bu2.a(iterator.a());
        }
        object = set.iterator();
        do {
            if (!object.hasNext()) return;
            object2 = (aA)object.next();
            aA aA2 = (aA)object2.clone();
            object2.getRealizer().addLabel(aA2);
            list2.add(aA2);
            map2.put(aA2, object2);
        } while (!bl2);
    }

    List d(bu bu2) {
        boolean bl2 = fj.z;
        D d2 = new D();
        y.c.x x2 = bu2.o();
        do {
            boolean bl3 = x2.f();
            block1 : do {
                if (!bl3) return d2;
                y.c.q q2 = x2.e();
                fj fj2 = bu2.t(q2);
                for (int i2 = 0; i2 < fj2.labelCount(); ++i2) {
                    eR eR2 = fj2.getLabel(i2);
                    bl3 = bu2.a(eR2);
                    if (bl2) continue block1;
                    if (!bl3) continue;
                    d2.add(eR2);
                    if (!bl2) continue;
                }
                break;
            } while (true);
            x2.g();
        } while (!bl2);
        return d2;
    }

    List e(bu bu2) {
        boolean bl2 = fj.z;
        D d2 = new D();
        e e2 = bu2.p();
        do {
            boolean bl3 = e2.f();
            block1 : do {
                if (!bl3) return d2;
                y.c.d d3 = e2.a();
                aB aB2 = bu2.i(d3);
                for (int i2 = 0; i2 < aB2.labelCount(); ++i2) {
                    aA aA2 = aB2.getLabel(i2);
                    bl3 = bu2.a(aA2);
                    if (bl2) continue block1;
                    if (!bl3) continue;
                    d2.add(aA2);
                    if (!bl2) continue;
                }
                break;
            } while (true);
            e2.g();
        } while (!bl2);
        return d2;
    }

    /*
     * Unable to fully structure code
     */
    void a(List var1_1, List var2_2) {
        var9_3 = fj.z;
        for (eR var4_5 : var1_1) {
            block10 : {
                var5_6 = var4_5.a();
                var6_7 = new D();
                var7_8 = var4_5.g();
                v0 = 0;
                if (var9_3 != false) return;
                for (var8_9 = v2296153; var8_9 < var7_8.labelCount(); ++var8_9) {
                    var6_7.add(var7_8.getLabel(var8_9).getOrientedBox());
                    if (!var9_3) {
                        if (!var9_3) continue;
                    }
                    break block10;
                }
                if (var5_6 instanceof y.f.A) {
                    hV.a(var4_5, var6_7);
                    if (!var9_3) continue;
                }
            }
            if (var5_6 instanceof gw) {
                hV.c(var4_5, var6_7);
                if (!var9_3) continue;
            }
            if (var5_6 instanceof fM) {
                hV.b(var4_5, var6_7);
                if (!var9_3) continue;
            }
            if (var5_6 instanceof h) {
                hV.d(var4_5, var6_7);
                if (!var9_3) continue;
            }
            hV.e(var4_5, var6_7);
            if (!var9_3) continue;
        }
        var3_4 = var2_2.iterator();
        do lbl-1000: // 4 sources:
        {
            block11 : {
                v0 = var3_4.hasNext();
                if (v0 == 0) return;
                var4_5 = (aA)var3_4.next();
                var5_6 = var4_5.getLabelModel();
                var6_7 = new D();
                var7_8 = var4_5.getRealizer();
                for (var8_9 = 0; var8_9 < var7_8.labelCount(); ++var8_9) {
                    var6_7.add(var7_8.getLabel(var8_9).getOrientedBox());
                    if (!var9_3) {
                        if (!var9_3) continue;
                    }
                    break block11;
                }
                if (!(var5_6 instanceof K)) ** GOTO lbl44
                hV.a((aA)var4_5, var6_7);
                if (!var9_3) ** GOTO lbl-1000
            }
            if (!(var5_6 instanceof gu)) ** GOTO lbl48
            hV.b((aA)var4_5, var6_7);
            if (!var9_3) ** GOTO lbl-1000
lbl48: // 2 sources:
            hV.c((aA)var4_5, var6_7);
        } while (!var9_3);
    }

    void a(bu bu2, List list, List list2) {
        boolean bl2;
        Iterator iterator;
        block3 : {
            bl2 = fj.z;
            bu2.N();
            iterator = list.iterator();
            while (iterator.hasNext()) {
                bu2.a((gZ)iterator.next(), true);
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            iterator = list2.iterator();
        }
        do {
            if (!iterator.hasNext()) return;
            bu2.a((gZ)iterator.next(), true);
        } while (!bl2);
    }

    private static void a(eR eR2, D d2) {
        Object object;
        boolean bl2 = fj.z;
        fj fj2 = eR2.g();
        y.f.A a2 = (y.f.A)eR2.a();
        HashSet<Object> hashSet = new HashSet<Object>(17);
        for (int i2 = 0; i2 < fj2.labelCount(); ++i2) {
            object = fj2.getLabel(i2);
            if (!(object.getModelParameter() instanceof Integer)) continue;
            hashSet.add(object.getModelParameter());
            if (!bl2) continue;
        }
        D d3 = a2.a(eR2, (am)fj2);
        object = d3.m();
        do {
            if (!object.f()) return;
            Q q2 = (Q)object.d();
            Object object2 = q2.b();
            if (!hashSet.contains(object2) && hV.b(q2.d(), d2)) {
                eR2.setModelParameter(object2);
                return;
            }
            object.g();
        } while (!bl2);
    }

    private static void b(eR eR2, D d2) {
        Object object;
        boolean bl2 = fj.z;
        fj fj2 = eR2.g();
        fM fM2 = (fM)eR2.a();
        boolean[] arrbl = new boolean[5];
        eU eU2 = fM.a(eR2);
        for (int i2 = 0; i2 < fj2.labelCount(); ++i2) {
            object = fj2.getLabel(i2);
            if (eU2 != fM.a((eR)object) || !(object.getModelParameter() instanceof fN)) continue;
            arrbl[fM.b((Object)object.getModelParameter())] = true;
            if (!bl2) continue;
        }
        D d3 = fM2.a((aj)eR2, (am)fj2);
        object = d3.m();
        do {
            if (!object.f()) return;
            Q q2 = (Q)object.d();
            Object object2 = q2.b();
            if (!arrbl[fM.b(object2)] && hV.b(q2.d(), d2)) {
                eR2.setModelParameter(object2);
                return;
            }
            object.g();
        } while (!bl2);
    }

    private static void c(eR eR2, D d2) {
        boolean bl2 = fj.z;
        gx gx2 = (gx)eR2.getModelParameter();
        y.d.n n2 = new y.d.n(eR2.getOrientedBox());
        do {
            Object object;
            if (hV.a(n2, d2)) return;
            n2.e(n2.k().a(), n2.k().b() + n2.f() + 5.0);
            gx gx3 = (gx)eR2.getBestModelParameterForBounds(n2);
            gx gx4 = (gx)eR2.getModelParameter();
            eR2.setModelParameter(gx3);
            if (gx4.e() != 0.0) {
                object = ((gw)eR2.a()).a(gx2.a(), gx3.b(), gx2.c(), gx3.d(), gx2.e(), gx3.f(), gx3.g(), gx3.h());
                eR2.setModelParameter(object);
                gx3 = (gx)object;
            }
            if (gx4.f() != 0.0) {
                object = ((gw)eR2.a()).a(gx3.a(), gx2.b(), gx3.c(), gx2.d(), gx3.e(), gx2.f() + n2.f() + 5.0, gx3.g(), gx3.h());
                eR2.setModelParameter(object);
                gx3 = (gx)object;
            }
            gx2 = gx3;
        } while (!bl2);
    }

    private static void d(eR eR2, D d2) {
        boolean bl2 = fj.z;
        y.d.n n2 = new y.d.n(eR2.getOrientedBox());
        do {
            if (hV.a(n2, d2)) return;
            n2.e(n2.k().a() + n2.e() + 5.0, n2.k().b());
            eR2.setModelParameter(eR2.getBestModelParameterForBounds(n2));
        } while (!bl2);
    }

    private static void e(eR eR2, D d2) {
        boolean bl2 = fj.z;
        y.d.n n2 = new y.d.n(eR2.getOrientedBox());
        do {
            if (hV.a(n2, d2)) return;
            n2.e(n2.k().a(), n2.k().b() + n2.f() + 5.0);
            eR2.setModelParameter(eR2.getBestModelParameterForBounds(n2));
        } while (!bl2);
    }

    private static void a(aA aA2, D d2) {
        boolean bl2 = fj.z;
        y.d.n n2 = new y.d.n(aA2.getOrientedBox());
        do {
            if (hV.a(n2, d2)) return;
            n2.e(n2.k().a(), n2.k().b() + n2.f() + 5.0);
            aA2.setModelParameter(aA2.getBestModelParameterForBounds(n2));
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private static void b(aA var0, D var1_1) {
        var15_2 = fj.z;
        var2_3 = var0.getRealizer();
        var3_4 = (gu)var0.getLabelModel();
        var4_5 = (gv)var0.getModelParameter();
        var5_6 = var2_3.pointCount() + 1;
        var6_7 = var4_5;
        var8_8 = false;
        var9_9 = true;
        do {
            if (var8_8 != false) return;
            var13_13 = var6_7.a();
            if (!var9_9) ** GOTO lbl29
            if (var6_7.b() + 0.1 <= hV.b(var0)) ** GOTO lbl26
            var12_12 = var13_13 + 1;
            if (var12_12 >= var5_6 || var12_12 == 0) ** GOTO lbl22
            var14_14 = (aA)var0.clone();
            var14_14.setLabelModel(new gu(), new gv(var12_12, var6_7.b(), var6_7.c(), var6_7.d(), var6_7.e(), var6_7.f()));
            var2_3.addLabel((aA)var14_14);
            var10_11 = hV.a((aA)var14_14);
            var2_3.removeLabel((aA)var14_14);
            if (!var15_2) ** GOTO lbl45
lbl22: // 2 sources:
            var10_11 = var4_5.b();
            var12_12 = var4_5.a();
            var9_9 = false;
            if (!var15_2) ** GOTO lbl45
lbl26: // 2 sources:
            var12_12 = var13_13;
            var10_11 = var6_7.b() + 0.1;
            if (!var15_2) ** GOTO lbl45
lbl29: // 2 sources:
            if (var6_7.b() - 0.1 >= hV.a(var0)) ** GOTO lbl-1000
            var12_12 = var13_13 - 1;
            if (var12_12 < - var5_6 || var12_12 == -1) ** GOTO lbl-1000
            var14_14 = (aA)var0.clone();
            var14_14.setLabelModel(new gu(), new gv(var12_12, var6_7.b(), var6_7.c(), var6_7.d(), var6_7.e(), var6_7.f()));
            var2_3.addLabel((aA)var14_14);
            var10_11 = hV.b((aA)var14_14);
            var2_3.removeLabel((aA)var14_14);
            if (var15_2) lbl-1000: // 2 sources:
            {
                var10_11 = var4_5.b();
                var12_12 = var4_5.a();
                var8_8 = true;
                ** if (!var15_2) goto lbl45
            }
            ** GOTO lbl45
lbl-1000: // 2 sources:
            {
                var12_12 = var13_13;
                var10_11 = var6_7.b() - 0.1;
            }
lbl45: // 6 sources:
            var7_10 = new gv(var12_12, var10_11, var6_7.c(), var6_7.d(), var6_7.e(), var6_7.f());
            var14_14 = var3_4.a(var0.getOrientedBox().d(), var2_3, var2_3.getSourceRealizer(), var2_3.getTargetRealizer(), var7_10);
            var0.setModelParameter(var7_10);
            if (hV.a((y.d.n)var14_14, var1_1)) {
                var8_8 = true;
            }
            var6_7 = var7_10;
        } while (!var15_2);
    }

    private static void c(aA aA2, D d2) {
        boolean bl2 = fj.z;
        aB aB2 = aA2.getRealizer();
        E e2 = aA2.getLabelModel();
        t t2 = aA2.getOrientedBox().k();
        double d3 = Double.MAX_VALUE;
        Q q2 = null;
        D d4 = e2.a(aA2, (I)aB2, (am)aB2.getSourceRealizer(), (am)aB2.getTargetRealizer());
        C c2 = d4.m();
        while (c2.f()) {
            double d5;
            Q q3 = (Q)c2.d();
            y.d.n n2 = q3.d();
            if (bl2) return;
            if (hV.a(n2, d2) && (d5 = t.a(t2, q3.d().k())) < d3) {
                d3 = d5;
                q2 = q3;
            }
            c2.g();
            if (!bl2) continue;
        }
        if (q2 == null) return;
        aA2.setModelParameter(q2.b());
    }

    private static double a(aA aA2) {
        boolean bl2 = fj.z;
        double d2 = 1.0;
        y.d.v v2 = aA2.getGraph2D().l(aA2.getEdge());
        gv gv2 = (gv)aA2.getModelParameter();
        int n2 = gv2.a();
        n2 = n2 < 0 ? v2.h() - 1 + n2 : n2;
        E e2 = aA2.getLabelModel();
        aB aB2 = aA2.getRealizer();
        D d3 = e2.a(aA2, (I)aB2, (am)aB2.getSourceRealizer(), (am)aB2.getTargetRealizer());
        C c2 = d3.m();
        do {
            int n3;
            if (!c2.f()) return Math.max(d2, 0.0);
            gv gv3 = (gv)((Q)c2.d()).b();
            int n4 = n3 = gv3.a() < 0 ? v2.h() - 1 + gv3.a() : gv3.a();
            if (n3 == n2 && gv3.e() == gv2.e()) {
                d2 = Math.min(d2, gv3.b());
            }
            c2.g();
        } while (!bl2);
        return Math.max(d2, 0.0);
    }

    private static double b(aA aA2) {
        boolean bl2 = fj.z;
        double d2 = 0.0;
        y.d.v v2 = aA2.getGraph2D().l(aA2.getEdge());
        E e2 = aA2.getLabelModel();
        gv gv2 = (gv)aA2.getModelParameter();
        int n2 = gv2.a();
        n2 = n2 < 0 ? v2.h() - 1 + n2 : n2;
        aB aB2 = aA2.getRealizer();
        D d3 = e2.a(aA2, (I)aB2, (am)aB2.getSourceRealizer(), (am)aB2.getTargetRealizer());
        C c2 = d3.m();
        do {
            int n3;
            if (!c2.f()) return Math.min(d2, 1.0);
            gv gv3 = (gv)((Q)c2.d()).b();
            int n4 = n3 = gv3.a() < 0 ? v2.h() - 1 + gv3.a() : gv3.a();
            if (n3 == n2 && gv3.e() == gv2.e()) {
                d2 = Math.max(d2, gv3.b());
            }
            c2.g();
        } while (!bl2);
        return Math.min(d2, 1.0);
    }

    private static boolean a(y.d.n n2, D d2) {
        boolean bl2;
        boolean bl3 = fj.z;
        boolean bl4 = true;
        C c2 = d2.m();
        while (c2.f()) {
            bl2 = bl4;
            if (bl3) return bl2;
            if (!bl2) break;
            bl4 = !hV.a(n2, (y.d.n)c2.d(), 0.0);
            c2.g();
            if (!bl3) continue;
        }
        bl2 = bl4;
        return bl2;
    }

    private static boolean b(y.d.n n2, D d2) {
        boolean bl2;
        boolean bl3 = fj.z;
        boolean bl4 = true;
        C c2 = d2.m();
        while (c2.f()) {
            bl2 = bl4;
            if (bl3) return bl2;
            if (!bl2) break;
            bl4 = !y.d.n.a((y.d.n)c2.d(), n2, 0.0);
            c2.g();
            if (!bl3) continue;
        }
        bl2 = bl4;
        return bl2;
    }

    private static boolean a(y.d.n n2, y.d.n n3, double d2) {
        t[] arrt = y.d.n.a(n3);
        if (y.d.n.a(n2, new m(arrt[0], arrt[1]), d2)) return true;
        if (y.d.n.a(n2, new m(arrt[1], arrt[2]), d2)) return true;
        if (y.d.n.a(n2, new m(arrt[2], arrt[3]), d2)) return true;
        if (y.d.n.a(n2, new m(arrt[3], arrt[0]), d2)) return true;
        return false;
    }
}

