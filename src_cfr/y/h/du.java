/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.c.d;
import y.c.q;
import y.d.t;
import y.f.X;
import y.g.ai;
import y.g.aj;
import y.g.am;
import y.h.aB;
import y.h.az;
import y.h.b.a;
import y.h.b.c;
import y.h.b.f;
import y.h.b.i;
import y.h.bu;
import y.h.ch;
import y.h.e;
import y.h.ed;
import y.h.ee;
import y.h.ef;
import y.h.eg;
import y.h.eh;
import y.h.ei;
import y.h.ej;
import y.h.ek;
import y.h.el;
import y.h.em;
import y.h.en;
import y.h.eo;
import y.h.ep;
import y.h.eq;
import y.h.es;
import y.h.eu;
import y.h.ev;
import y.h.ew;
import y.h.ex;
import y.h.ey;
import y.h.fL;
import y.h.fj;
import y.h.gy;
import y.h.gz;
import y.h.id;
import y.h.x;
import y.h.y;

public class dU
extends e {
    private Set a;
    private Set b;
    private y.c.c c;
    private List d;
    private List e;
    private boolean f;
    private boolean g = true;
    private double h;
    private double i = -1.0;
    private double j;
    private boolean k;
    private boolean l = true;
    private ai m;
    private ai n;
    private boolean o;
    private boolean p;
    private Set q;
    private boolean r = true;
    private boolean s = true;
    private ArrayList t;
    private boolean u;
    private boolean v;
    private double w = 40.0;
    private Collection x;
    private Collection y;
    private boolean z = true;
    private boolean A;
    private double B = 10.0;

    public dU() {
        this(null);
    }

    public dU(ch ch2) {
        super(ch2);
    }

    public boolean l() {
        return this.v;
    }

    public void b(boolean bl2) {
        this.s = bl2;
    }

    public void c(boolean bl2) {
        this.u = bl2;
    }

    public void d(boolean bl2) {
        this.r = bl2;
    }

    public void e(boolean bl2) {
        this.p = bl2;
    }

    public void f(boolean bl2) {
        this.o = bl2;
    }

    public void g(boolean bl2) {
        this.k = bl2;
    }

    public double m() {
        return this.j;
    }

    public void b(double d2) {
        this.j = d2;
    }

    public void c(double d2) {
        this.i = d2;
    }

    public boolean n() {
        return this.A;
    }

    public void a(t t2, Collection collection, Collection collection2, Collection collection3, y.c.c c2) {
        Object object;
        block3 : {
            boolean bl2 = fj.z;
            super.g();
            this.a(t2);
            this.a = new HashSet(collection);
            this.b = new HashSet(collection2.size());
            this.x = collection2;
            this.y = collection3;
            object = collection2.iterator();
            while (object.hasNext()) {
                ek ek2 = (ek)object.next();
                this.b.add(ek2.a());
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            this.c = c2;
            this.q = new HashSet(Math.max(32, this.c().getGraph2D().e() - collection.size()));
            this.a(collection, this.q);
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.b(this.d, this.e);
            this.m = new ai();
            this.n = new ai();
            this.o();
            this.q();
            this.p();
        }
        if (this.A && (object = this.b(t2, collection, collection2, collection3, c2)) != null) {
            this.a((gz)object);
        }
        this.v = true;
    }

    @Override
    public void f() {
        super.f();
        this.v = false;
        this.a = null;
        this.b = null;
        this.c = null;
        this.x = null;
        this.y = null;
        this.d = null;
        this.e = null;
        this.q = null;
        this.t = null;
        this.n = null;
        this.m = null;
    }

    protected gz b(t t2, Collection collection, Collection collection2, Collection collection3, y.c.c c2) {
        boolean bl2 = fj.z;
        if (collection.isEmpty() && collection2.isEmpty()) {
            return null;
        }
        ArrayList<ew> arrayList = new ArrayList<ew>();
        for (Object object2 : collection) {
            bu bu2 = (bu)object2.e();
            t t3 = bu2.l((q)object2);
            arrayList.add(new ew(t3, bu2.p((q)object2), bu2.q((q)object2)));
            if (bl2) return new ep(1.0, this.c(), this.B, t2, arrayList);
            if (!bl2) continue;
        }
        if (!collection.isEmpty()) return new ep(1.0, this.c(), this.B, t2, arrayList);
        Iterator iterator = collection2.iterator();
        do {
            Object object2;
            if (!iterator.hasNext()) return new ep(1.0, this.c(), this.B, t2, arrayList);
            object2 = (ek)iterator.next();
            arrayList.add(new ew(object2.b(), object2.d(), object2.c(), 1.0, 1.0));
        } while (!bl2);
        return new ep(1.0, this.c(), this.B, t2, arrayList);
    }

    private void o() {
        boolean bl2 = fj.z;
        if (!this.r) {
            return;
        }
        HashSet hashSet = new HashSet(Math.min(32, this.b.size()));
        HashMap hashMap = new HashMap(this.b.size());
        HashMap hashMap2 = new HashMap(this.y.size());
        this.a(hashMap, hashMap2, hashSet);
        bu bu2 = this.c().getGraph2D();
        Iterator iterator = hashSet.iterator();
        block0 : do {
            boolean bl3 = iterator.hasNext();
            block1 : do {
                double d2;
                double d3;
                el el2;
                el[] arrel;
                el el3;
                int n2;
                block9 : {
                    int n3;
                    if (!bl3) return;
                    d d4 = (d)iterator.next();
                    aB aB2 = bu2.i(d4);
                    arrel = this.a(aB2, hashMap, hashMap2);
                    for (n2 = 1; n2 < arrel.length; ++n2) {
                        el3 = arrel[n2 - 1];
                        el2 = arrel[n2];
                        d2 = el3.b().a - el2.b().a;
                        d3 = el3.b().b - el2.b().b;
                        n3 = (int)el2.d() ? 1 : 0;
                        if (!bl2) {
                            if (n3 == 0 && el3.d()) {
                                this.m.a(new ev(this.k().a + d2, el3, el2));
                            }
                            if (el2.c() || !el3.c()) continue;
                            this.n.a(new ev(this.k().b + d3, el3, el2));
                            if (!bl2) continue;
                        }
                        break block9;
                    }
                    n3 = n2 = arrel.length - 2;
                }
                do {
                    if (n2 < 1) continue block0;
                    el3 = arrel[n2 + 1];
                    el2 = (ek)arrel[n2];
                    d2 = el3.b().a - el2.b().a;
                    d3 = el3.b().b - el2.b().b;
                    bl3 = el2.d();
                    if (bl2) continue block1;
                    if (!bl3 && el3.d()) {
                        this.m.a(new ev(this.k().a + d2, el3, el2));
                    }
                    if (!el2.c() && el3.c()) {
                        this.n.a(new ev(this.k().b + d3, el3, el2));
                    }
                    --n2;
                } while (!bl2);
                break;
            } while (true);
            break;
        } while (true);
    }

    private el a(fL fL2, Map map) {
        if (fL2 == fL2.d().getSourcePort()) {
            if (!this.q.contains(fL2.d().getEdge().c())) {
                return new em(fL2, fL2.f(), 3);
            }
            if (map.isEmpty()) return new em(fL2, fL2.f(), 0);
            el el2 = (el)map.get(fL2);
            if (el2 == null) return new em(fL2, fL2.f(), 0);
            return el2;
        }
        if (!this.q.contains(fL2.d().getEdge().d())) {
            return new em(fL2, fL2.f(), 3);
        }
        if (map.isEmpty()) return new em(fL2, fL2.f(), 0);
        el el3 = (el)map.get(fL2);
        if (el3 == null) return new em(fL2, fL2.f(), 0);
        return el3;
    }

    /*
     * Exception decompiling
     */
    private void p() {
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

    private void a(Map map, Map map2, Set set) {
        boolean bl2;
        Iterator iterator;
        Object object2;
        block12 : {
            block10 : {
                bl2 = fj.z;
                for (Object object2 : this.x) {
                    map.put(object2.a(), object2);
                    if (set == null) continue;
                    set.add(object2.a().a());
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block10;
                }
                if (set != null) {
                    iterator = this.a.iterator();
                    while (iterator.hasNext()) {
                        d d2;
                        block11 : {
                            object2 = (q)iterator.next();
                            for (d2 = object2.g(); d2 != null; d2 = d2.h()) {
                                set.add(d2);
                                if (!bl2) {
                                    if (!bl2) continue;
                                }
                                break block11;
                            }
                            d2 = object2.f();
                        }
                        while (d2 != null) {
                            set.add(d2);
                            d2 = d2.g();
                            if (!bl2) {
                                if (!bl2 && !bl2) continue;
                            }
                            break block12;
                        }
                    }
                }
            }
            iterator = this.y.iterator();
        }
        do {
            if (!iterator.hasNext()) return;
            object2 = (em)iterator.next();
            if (!(object2.d() && object2.c() || set == null)) {
                set.add(object2.a().d().getEdge());
            }
            map2.put(object2.a(), object2);
        } while (!bl2);
    }

    private el[] a(aB aB2, Map map, Map map2) {
        boolean bl2 = fj.z;
        el[] arrel = new el[aB2.bendCount() + 2];
        arrel[0] = this.a(aB2.getSourcePort(), map2);
        int n2 = 1;
        y y2 = aB2.bends();
        while (y2.f()) {
            ek ek2 = (ek)map.get(y2.a());
            if (bl2) return arrel;
            if (ek2 == null) {
                ek2 = new ek(y2.a(), new t(y2.a().b(), y2.a().c()), 0);
            }
            arrel[n2++] = ek2;
            y2.g();
            if (!bl2) continue;
        }
        arrel[arrel.length - 1] = this.a(aB2.getTargetPort(), map2);
        return arrel;
    }

    public void a(en en2) {
        this.t.add(en2);
    }

    public en a(el el2, el el3) {
        double d2 = el3.b().a - el2.b().a;
        double d3 = el3.b().b - el2.b().b;
        en en2 = null;
        if (d2 == 0.0 && (d3 != 0.0 || el2.c() != el3.c())) {
            if (el2.d()) return en2;
            if (el3.d()) return en2;
            en2 = new en(el2, el3);
            this.t.add(en2);
            return en2;
        }
        if (d3 != 0.0) return en2;
        if (d2 == 0.0) {
            if (el2.d() == el3.d()) return en2;
        }
        if (el2.c()) return en2;
        if (el3.c()) return en2;
        en2 = new en(el2, el3);
        this.t.add(en2);
        return en2;
    }

    public void b(en en2) {
        if (en2 == null) return;
        if (this.t == null) return;
        this.t.remove(en2);
    }

    /*
     * Unable to fully structure code
     */
    private void q() {
        var9_1 = fj.z;
        if (!this.s) {
            return;
        }
        var1_2 = this.c().getGraph2D();
        var2_3 = this.a.iterator();
        block0 : do {
            v0 = var2_3.hasNext();
            block1 : do lbl-1000: // 3 sources:
            {
                if (v0 == 0) return;
                var3_4 = (q)var2_3.next();
                for (var4_5 = var3_4.g(); var4_5 != null; var4_5 = var4_5.h()) {
                    var5_6 = var1_2.i(var4_5);
                    var6_7 = null;
                    v0 = var5_6.bendCount();
                    if (var9_1) ** GOTO lbl-1000
                    if (v0 == 0) {
                        if (this.q.contains(var4_5.c())) {
                            var6_7 = new em(var5_6.getSourcePort(), var1_2.p(var4_5), 0);
                        }
                    } else {
                        var7_8 = var5_6.lastBend();
                        if (!this.b.contains(var7_8)) {
                            var6_7 = new ek((x)var7_8, var7_8.e(), 0);
                        }
                    }
                    if (var6_7 == null) continue;
                    var7_8 = var1_2.q(var4_5);
                    var8_9 = new em(var5_6.getTargetPort(), (t)var7_8, 3);
                    this.m.a(new ev(this.k().a + (var6_7.b().a - var7_8.a), var6_7, var8_9));
                    this.n.a(new ev(this.k().b + (var6_7.b().b - var7_8.b), var6_7, var8_9));
                    if (!var9_1) continue;
                }
                var4_5 = var3_4.f();
                do {
                    if (var4_5 == null) continue block0;
                    var5_6 = var1_2.i(var4_5);
                    var6_7 = null;
                    v0 = var5_6.bendCount();
                    if (var9_1) continue block1;
                    if (v0 == 0) {
                        if (this.q.contains(var4_5.d())) {
                            var6_7 = new em(var5_6.getTargetPort(), var1_2.q(var4_5), 0);
                        }
                    } else {
                        var7_8 = var5_6.firstBend();
                        if (!this.b.contains(var7_8)) {
                            var6_7 = new ek((x)var7_8, var7_8.e(), 0);
                        }
                    }
                    if (var6_7 != null) {
                        var7_8 = var1_2.p(var4_5);
                        var8_9 = new em(var5_6.getSourcePort(), (t)var7_8, 3);
                        this.m.a(new ev(this.k().a + (var6_7.b().a - var7_8.a), var6_7, var8_9));
                        this.n.a(new ev(this.k().b + (var6_7.b().b - var7_8.b), var6_7, var8_9));
                    }
                    var4_5 = var4_5.g();
                } while (!var9_1);
                break;
            } while (true);
            break;
        } while (true);
    }

    protected void a(q q2, fj fj2, Collection collection, Collection collection2) {
        double d2;
        if (fj2 instanceof a) {
            this.a(q2, (a)fj2, collection, collection2);
        }
        double d3 = fj2.getCenterX();
        double d4 = fj2.getCenterY();
        double d5 = fj2.getX();
        double d6 = fj2.getWidth();
        double d7 = fj2.getY();
        double d8 = fj2.getHeight();
        double d9 = d5 + d6;
        double d10 = d7 + d8;
        Object object = am.a(q2, Boolean.TRUE);
        Object object2 = am.a(q2, Boolean.FALSE);
        double d11 = this.w;
        collection.add(new eo(0, 2, new t(d3, d7), d5 - d11, d9 + d11, object2, 0.9));
        collection.add(new eo(0, 1, new t(d3, d10), d5 - d11, d9 + d11, object2, 0.9));
        collection.add(new eo(1, 8, new t(d5, d4), d7 - d11, d10 + d11, object, 0.9));
        collection.add(new eo(1, 4, new t(d9, d4), d7 - d11, d10 + d11, object, 0.9));
        double d12 = this.h;
        if (d12 > 0.0) {
            collection.add(new ex(0, 2, new t(d3, d7 - d12), d5 - d11, d9 + d11, object2, 0.95, d12));
            collection.add(new ex(0, 1, new t(d3, d10 + d12), d5 - d11, d9 + d11, object2, 0.95, d12));
            collection.add(new ex(1, 8, new t(d5 - d12, d4), d7 - d11, d10 + d11, object, 0.95, d12));
            collection.add(new ex(1, 4, new t(d9 + d12, d4), d7 - d11, d10 + d11, object, 0.95, d12));
        }
        if ((d2 = this.i) >= 0.0) {
            collection2.add(new ex(0, 2, new t(d3, d7 - d2), d5 - d11, d9 + d11, object2, 0.95, d2));
            collection2.add(new ex(0, 1, new t(d3, d10 + d2), d5 - d11, d9 + d11, object2, 0.95, d2));
            collection2.add(new ex(1, 8, new t(d5 - d2, d4), d7 - d11, d10 + d11, object, 0.95, d2));
            collection2.add(new ex(1, 4, new t(d9 + d2, d4), d7 - d11, d10 + d11, object, 0.95, d2));
        }
        eo eo2 = new eo(0, 16, new t(d3, d4), object2, 1.0);
        eo eo3 = new eo(1, 16, new t(d3, d4), object, 1.0);
        collection.add(eo2);
        collection.add(eo3);
        collection2.add(eo2);
        collection2.add(eo3);
        collection.add(new eo(0, 1, new t(d3, d7), object2, 0.5));
        collection.add(new eo(0, 2, new t(d3, d10), object2, 0.5));
        collection.add(new eo(1, 4, new t(d5, d4), object, 0.5));
        collection.add(new eo(1, 8, new t(d9, d4), object, 0.5));
    }

    /*
     * Unable to fully structure code
     */
    protected void a(q var1_1, a var2_2, Collection var3_3, Collection var4_4) {
        block4 : {
            var11_5 = fj.z;
            var5_6 = am.a(var1_1, Boolean.TRUE);
            var6_7 = am.a(var1_1, Boolean.FALSE);
            var7_8 = new ArrayList<E>();
            var7_8.addAll(var2_2.l().o());
            while (!var7_8.isEmpty()) {
                v0 = var7_8;
                if (!var11_5) {
                    var8_9 = (f)v0.remove(0);
                    if (var8_9.o().isEmpty()) {
                        var9_10 = var8_9.h();
                        var3_3.add(new gy(0, 16, new t(var9_10.getX(), var9_10.getCenterY()), var9_10.getX(), var9_10.getMaxX(), var6_7, 0.9));
                        if (!var11_5) continue;
                    }
                    var7_8.addAll(var8_9.o());
                    if (!var11_5) continue;
                }
                break block4;
            }
            v0 = new ArrayList<E>();
        }
        var8_9 = v0;
        var8_9.addAll(var2_2.l().l());
        do lbl-1000: // 3 sources:
        {
            if (var8_9.isEmpty() != false) return;
            var9_10 = (c)var8_9.remove(0);
            if (!var9_10.l().isEmpty()) ** GOTO lbl28
            var10_11 = var9_10.h();
            var3_3.add(new gy(1, 16, new t(var10_11.getCenterX(), var10_11.getY()), var10_11.getY(), var10_11.getMaxY(), var5_6, 0.9));
            if (!var11_5) ** GOTO lbl-1000
lbl28: // 2 sources:
            var8_9.addAll(var9_10.l());
        } while (!var11_5);
    }

    protected void b(Collection collection, Collection collection2) {
        bu bu2 = this.c().getGraph2D();
        if (this.k) {
            this.e(collection, collection2);
        }
        if (this.l) {
            this.c(collection, collection2);
        }
        if (this.f || this.g) {
            new ed(this, bu2, collection, collection2).a(bu2, this.q, this.c().getVisibleRect().getBounds2D(), true);
            new ee(this, bu2, collection, collection2).a(bu2, this.q, this.c().getVisibleRect().getBounds2D(), false);
        }
        if (!this.z) return;
        this.d(collection, collection2);
    }

    /*
     * Unable to fully structure code
     */
    private void c(Collection var1_1, Collection var2_2) {
        var7_3 = fj.z;
        var3_4 = this.c().getGraph2D();
        var4_5 = this.q.iterator();
        do lbl-1000: // 3 sources:
        {
            if (var4_5.hasNext() == false) return;
            var5_6 = (q)var4_5.next();
            var6_7 = var3_4.t(var5_6);
            if (!this.a(var6_7)) ** GOTO lbl-1000
            this.a(var5_6, var1_1, var2_2);
        } while (!var7_3);
    }

    private void d(Collection collection, Collection collection2) {
        boolean bl2 = fj.z;
        if (collection.isEmpty()) {
            if (collection2.isEmpty()) return;
        }
        if (this.q.isEmpty()) {
            return;
        }
        bu bu2 = this.c().getGraph2D();
        ArrayList<es> arrayList = new ArrayList<es>();
        ArrayList<es> arrayList2 = new ArrayList<es>();
        for (q q2 : this.q) {
            fj fj2 = bu2.t(q2);
            if (!this.a(fj2)) continue;
            arrayList.add(new es(fj2.getX(), fj2.getY(), fj2.getY() + fj2.getHeight(), true));
            arrayList.add(new es(fj2.getX() + fj2.getWidth(), fj2.getY(), fj2.getY() + fj2.getHeight(), false));
            arrayList2.add(new es(fj2.getY(), fj2.getX(), fj2.getX() + fj2.getWidth(), true));
            arrayList2.add(new es(fj2.getY() + fj2.getHeight(), fj2.getX(), fj2.getX() + fj2.getWidth(), false));
            if (!bl2) continue;
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(collection);
        hashSet.addAll(collection2);
        this.a(arrayList, arrayList2, (Collection)hashSet);
        this.a(arrayList);
        this.a(arrayList2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(List var1_1) {
        var11_2 = fj.z;
        y.g.e.a(var1_1, null);
        var2_3 = new ai(new ef(this));
        var3_4 = var1_1.iterator();
        do lbl-1000: // 6 sources:
        {
            block4 : {
                if (var3_4.hasNext() == false) return;
                var4_5 = (ey)var3_4.next();
                if (!(var4_5 instanceof es)) ** GOTO lbl34
                var5_7 = (es)var4_5;
                var6_9 = new eq(null, 0.0, var5_7.a, 0.0, null);
                var7_10 = new eq(null, 0.0, var5_7.c, 0.0, null);
                if (var2_3.a() == 0) ** GOTO lbl-1000
                var8_11 = var2_3.c(var7_10);
                var9_12 = var2_3.b(var6_9);
                if (var9_12 == null) {
                    var9_12 = var2_3.b();
                    if (!var11_2) break block4;
                }
                var9_12 = var9_12.a();
            }
            do lbl-1000: // 5 sources:
            {
                if (var9_12 == var8_11) ** GOTO lbl-1000
                var10_13 = (eq)var9_12.c();
                var9_12 = var9_12.a();
                if (!var5_7.b) ** GOTO lbl30
                if (var5_7.f <= var10_13.c) ** GOTO lbl-1000
                var10_13.a.b(var5_7.f);
                var2_3.a(var10_13.e);
                var10_13.e = null;
                if (!var11_2) ** GOTO lbl-1000
lbl30: // 2 sources:
                if (var5_7.f >= var10_13.c) ** GOTO lbl-1000
                var10_13.a.a(var5_7.f);
                if (var11_2 != false) return;
            } while (!var11_2);
lbl34: // 2 sources:
            var5_8 = (eq)var4_5;
            if (var5_8.d != null) ** GOTO lbl38
            var5_8.e = var2_3.a(var5_8);
            if (!var11_2) ** GOTO lbl-1000
lbl38: // 2 sources:
            if (var5_8.d.e == null) ** GOTO lbl-1000
            var2_3.a(var5_8.d.e);
            var5_8.d.e = null;
        } while (!var11_2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(List var1_1, List var2_2, Collection var3_3) {
        var8_4 = fj.z;
        var4_5 = var3_3.iterator();
        do lbl-1000: // 3 sources:
        {
            if (var4_5.hasNext() == false) return;
            var5_6 = (gy)var4_5.next();
            var6_7 = var5_6.b();
            if (var5_6.c() != 0) ** GOTO lbl12
            var7_8 = new eq(var5_6, var5_6.e(), var6_7.b, var6_7.a, null);
            var1_1.add(var7_8);
            var1_1.add(new eq(var5_6, var5_6.f(), var6_7.b, var6_7.a, var7_8));
            if (!var8_4) ** GOTO lbl-1000
lbl12: // 2 sources:
            var7_8 = new eq(var5_6, var5_6.e(), var6_7.a, var6_7.b, null);
            var2_2.add(var7_8);
            var2_2.add(new eq(var5_6, var5_6.f(), var6_7.a, var6_7.b, var7_8));
        } while (!var8_4);
    }

    private void e(Collection collection, Collection collection2) {
        boolean bl2 = fj.z;
        bu bu2 = this.c().getGraph2D();
        HashMap hashMap = new HashMap(this.b.size());
        HashMap hashMap2 = new HashMap(this.y.size());
        this.a(hashMap, hashMap2, null);
        y.c.e e2 = bu2.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            aB aB2 = bu2.i(d2);
            dU dU2 = this;
            block1 : do {
                el[] arrel = dU2.a(aB2, hashMap, hashMap2);
                for (int i2 = 1; i2 < arrel.length; ++i2) {
                    el el2 = arrel[i2 - 1];
                    el el3 = arrel[i2];
                    dU2 = this;
                    if (bl2) continue block1;
                    dU2.a(collection, collection2, aB2, el2.b(), el3.b(), el2.d() && el3.d(), el2.c() && el3.c());
                    if (!bl2) continue;
                }
                break;
            } while (true);
            e2.g();
        } while (!bl2);
    }

    private void a(Collection collection, Collection collection2, aB aB2, t t2, t t3, boolean bl2, boolean bl3) {
        double d2;
        Object object;
        double d3;
        t t4;
        double d4 = this.i;
        double d5 = this.j;
        if (t2.a == t3.a && bl2) {
            if (!this.a(aB2, t2, t3)) return;
            object = am.a(aB2.getEdge(), Boolean.TRUE);
            t4 = new t(t2.a, (t3.b + t2.b) * 0.5);
            d3 = Math.min(t2.b, t3.b) - this.w;
            d2 = Math.max(t2.b, t3.b) + this.w;
            collection2.add(new eo(1, 4, t4, object, 0.2));
            collection2.add(new eo(1, 8, t4, object, 0.2));
            if (d4 > 0.0) {
                collection.add(new ex(1, 4, new t(t4.a + d4, t4.b), d3, d2, object, 0.4, d4));
                collection.add(new ex(1, 8, new t(t4.a - d4, t4.b), d3, d2, object, 0.4, d4));
            }
            if (d5 <= 0.0) return;
            collection2.add(new ex(1, 4, new t(t4.a + d5, t4.b), d3, d2, object, 0.4, d5));
            collection2.add(new ex(1, 8, new t(t4.a - d5, t4.b), d3, d2, object, 0.4, d5));
            if (!fj.z) return;
        }
        if (t2.b != t3.b) return;
        if (!bl3) return;
        if (!this.a(aB2, t2, t3)) return;
        object = am.a(aB2.getEdge(), Boolean.FALSE);
        t4 = new t((t2.a + t3.a) * 0.5, t3.b);
        d3 = Math.min(t2.a, t3.a) - this.w;
        d2 = Math.max(t2.a, t3.a) + this.w;
        collection2.add(new eo(0, 1, t4, object, 0.2));
        collection2.add(new eo(0, 2, t4, object, 0.2));
        if (d4 > 0.0) {
            collection.add(new ex(0, 1, new t(t4.a, t4.b + d4), d3, d2, object, 0.4, d4));
            collection.add(new ex(0, 2, new t(t4.a, t4.b - d4), d3, d2, object, 0.4, d4));
        }
        if (d5 <= 0.0) return;
        collection2.add(new ex(0, 1, new t(t4.a, t4.b + d5), d3, d2, object, 0.4, d5));
        collection2.add(new ex(0, 2, new t(t4.a, t4.b - d5), d3, d2, object, 0.4, d5));
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public t b(t var1_1) {
        block18 : {
            var24_2 = fj.z;
            if (!this.v) {
                return var1_1;
            }
            var2_3 = new ArrayList<gz>();
            var3_4 = this.e() / this.c().getZoom();
            this.a(var3_4, this.m, var1_1.a, var2_3, true);
            this.a(var3_4, this.n, var1_1.b, var2_3, false);
            var5_5 = var1_1.a - this.k().a;
            var7_6 = var1_1.b - this.k().b;
            var9_7 = this.t.iterator();
            block2 : while (var9_7.hasNext()) {
                var10_8 = (en)var9_7.next();
                for (gy var12_10 : this.e) {
                    this.a((en)var10_8, var5_5, var7_6, var3_4, var2_3, var12_10);
                    if (var24_2) continue block2;
                    if (!var24_2) continue;
                }
                if (this.j().isEmpty()) continue;
                v0 = this.j().iterator();
                if (!var24_2) {
                    var11_9 = v0;
                    while (var11_9.hasNext()) {
                        var12_10 = (gy)var11_9.next();
                        this.a((en)var10_8, var5_5, var7_6, var3_4, var2_3, var12_10);
                        if (!var24_2 && !var24_2) continue;
                    }
                    continue;
                }
                break block18;
            }
            v0 = var9_7 = this.a.iterator();
        }
        block5 : while (var9_7.hasNext()) {
            var10_8 = (q)var9_7.next();
            try {
                var11_9 = (Rectangle2D.Double)this.c.b(var10_8);
                if (var11_9 == null && !var24_2) continue;
            }
            catch (Exception var12_12) {
                continue;
            }
            var12_13 = var11_9.getX() + var5_5;
            var14_15 = var12_13 + var11_9.getWidth();
            var16_16 = var11_9.getY() + var7_6;
            var18_17 = var16_16 + var11_9.getHeight();
            var20_20 = this.c().getGraph2D().t((q)var10_8);
            var21_21 = new eu(var20_20);
            for (var22_22 = 0; var22_22 < this.d.size(); ++var22_22) {
                var23_24 = (gy)this.d.get(var22_22);
                this.a(var23_24, var21_21, var1_1, var12_13, var16_16, var14_15, var18_17, var3_4, var2_3);
                if (var24_2) continue block5;
                if (!var24_2) continue;
            }
            if (this.j().isEmpty()) continue;
            v1 = this.j().iterator();
            if (!var24_2) {
                var22_23 = v1;
                while (var22_23.hasNext()) {
                    var23_24 = (gy)var22_23.next();
                    this.a(var23_24, var21_21, var1_1, var12_13, var16_16, var14_15, var18_17, var3_4, var2_3);
                    if (!var24_2 && !var24_2) continue;
                }
                continue;
            }
            ** GOTO lbl60
        }
        if (this.p) {
            v1 = var9_7 = this.x.iterator();
lbl60: // 5 sources:
            block8 : while (var9_7.hasNext()) {
                var10_8 = (el)var9_7.next();
                var11_9 = var10_8.b();
                var12_14 = var10_8.d();
                var13_25 = var12_14 != false ? var11_9.a : var11_9.a + var5_5;
                var15_26 = var10_8.c();
                var16_16 = var15_26 != false ? var11_9.b : var11_9.b + var7_6;
                for (var18_18 = 0; var18_18 < this.e.size(); ++var18_18) {
                    var19_27 = (gy)this.e.get(var18_18);
                    this.a(var19_27, var1_1, var12_14, var15_26, var13_25, var16_16, var2_3);
                    if (var24_2) continue block8;
                    if (!var24_2) continue;
                }
                if (this.j().isEmpty()) continue;
                v2 = this;
                if (!var24_2) {
                    for (gy var19_27 : v2.j()) {
                        this.a(var19_27, var1_1, var12_14, var15_26, var13_25, var16_16, var2_3);
                        if (!var24_2 && !var24_2) continue;
                    }
                    continue;
                }
                break;
            }
        } else {
            v2 = this;
        }
        if (v2.o == false) return this.a(var2_3, var1_1);
        if (Math.abs(var5_5) < Math.abs(var7_6)) {
            if (Math.abs(var5_5) >= var3_4) return this.a(var2_3, var1_1);
            var2_3.add(new eh(this, 10.0, new eg(this, var1_1)));
            if (var24_2 == false) return this.a(var2_3, var1_1);
        }
        if (Math.abs(var7_6) >= var3_4) return this.a(var2_3, var1_1);
        var2_3.add(new ej(this, 10.0, new ei(this, var1_1)));
        return this.a(var2_3, var1_1);
    }

    private void a(gy gy2, t t2, boolean bl2, boolean bl3, double d2, double d3, List list) {
        double d4;
        if (gy2.c() == 0) {
            if (bl3) return;
            if (gy2.e() > d2) return;
            if (gy2.f() < d2) return;
            d4 = gy2.b().b - d3;
            if (Math.abs(d4) >= 5.0) return;
            list.add(gz.a(0.1, gy2, false, t2.b + d4));
            if (!fj.z) return;
        }
        if (bl2) return;
        if (gy2.e() > d3) return;
        if (gy2.f() < d3) return;
        d4 = gy2.b().a - d2;
        if (Math.abs(d4) >= 5.0) return;
        list.add(gz.a(0.1, gy2, true, t2.a + d4));
    }

    private void a(gy az2, Rectangle2D rectangle2D, t t2, double d2, double d3, double d4, double d5, double d6, List list) {
        boolean bl2 = fj.z;
        switch (az2.d()) {
            double d7;
            double d8;
            gy gy2;
            double d9;
            case 16: {
                double d10;
                gy gy3;
                if (az2.c() == 1) {
                    if (d3 >= az2.f()) return;
                    if (d5 <= az2.e()) return;
                    d7 = (d2 + d4) * 0.5;
                    d9 = az2.b().a - d7;
                    d8 = Math.abs(d9);
                    if (d8 >= d6) return;
                    d10 = d6 - d8;
                    gy3 = az2 instanceof id ? ((id)((Object)az2)).a(rectangle2D) : az2;
                    list.add(gz.a(d10 * az2.a(), gy3, true, t2.a + d9, az2.g()));
                    if (!bl2) return;
                }
                if (d2 >= az2.f()) return;
                if (d4 <= az2.e()) return;
                d7 = (d3 + d5) * 0.5;
                d9 = az2.b().b - d7;
                d8 = Math.abs(d9);
                if (d8 >= d6) return;
                d10 = d6 - d8;
                gy3 = az2 instanceof id ? ((id)((Object)az2)).a(rectangle2D) : az2;
                list.add(gz.a(d10 * az2.a(), gy3, false, t2.b + d9, az2.g()));
                if (!bl2) return;
            }
            case 1: {
                if (d2 >= az2.f()) return;
                if (d4 <= az2.e()) return;
                d7 = az2.b().b - d3;
                d9 = Math.abs(d7);
                if (d9 >= d6) return;
                d8 = d6 - d9;
                gy2 = az2 instanceof id ? ((id)((Object)az2)).a(rectangle2D) : az2;
                list.add(gz.a(d8 * az2.a(), gy2, false, t2.b + d7, az2.g()));
                if (!bl2) return;
            }
            case 8: {
                if (d3 >= az2.f()) return;
                if (d5 <= az2.e()) return;
                d7 = az2.b().a - d4;
                d9 = Math.abs(d7);
                if (d9 >= d6) return;
                d8 = d6 - d9;
                gy2 = az2 instanceof id ? ((id)((Object)az2)).a(rectangle2D) : az2;
                list.add(gz.a(d8 * az2.a(), gy2, true, t2.a + d7, az2.g()));
                if (!bl2) return;
            }
            case 2: {
                if (d2 >= az2.f()) return;
                if (d4 <= az2.e()) return;
                d7 = az2.b().b - d5;
                d9 = Math.abs(d7);
                if (d9 >= d6) return;
                d8 = d6 - d9;
                gy2 = az2 instanceof id ? ((id)((Object)az2)).a(rectangle2D) : az2;
                list.add(gz.a(d8 * az2.a(), gy2, false, t2.b + d7, az2.g()));
                if (!bl2) return;
            }
            case 4: {
                if (d3 >= az2.f()) return;
                if (d5 <= az2.e()) return;
                d7 = az2.b().a - d2;
                d9 = Math.abs(d7);
                if (d9 >= d6) return;
                d8 = d6 - d9;
                gy2 = az2 instanceof id ? ((id)((Object)az2)).a(rectangle2D) : az2;
                list.add(gz.a(d8 * az2.a(), gy2, true, t2.a + d7, az2.g()));
            }
        }
    }

    private void a(en en2, double d2, double d3, double d4, List list, gy gy2) {
        gz gz2 = en2.a(gy2, this.k(), d2, d3, d4);
        if (gz2 == gz.b) return;
        list.add(gz2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(double var1_1, ai var3_2, double var4_3, List var6_4, boolean var7_5) {
        var19_6 = fj.z;
        if (var3_2.a() == 0) {
            return;
        }
        var8_7 = var3_2.b(new ev(var4_3, null, null));
        var9_8 = var8_7 != null ? var8_7.a() : var3_2.b();
        var10_9 = var8_7 != null ? ((ev)var8_7.c()).a : Double.POSITIVE_INFINITY;
        var12_10 = var9_8 != null ? ((ev)var9_8.c()).a : Double.POSITIVE_INFINITY;
        var14_11 = var10_9 - var4_3;
        var16_12 = var12_10 - var4_3;
        if (Math.abs(var14_11) >= var1_1) ** GOTO lbl-1000
        if (Math.abs(var16_12) >= Math.abs(var14_11)) ** GOTO lbl-1000
        var18_13 = (ev)var9_8.c();
        if (var19_6) lbl-1000: // 2 sources:
        {
            var18_13 = (ev)var8_7.c();
            ** if (!var19_6) goto lbl21
        }
        ** GOTO lbl21
lbl-1000: // 2 sources:
        {
            if (Math.abs(var16_12) >= var1_1) return;
            var18_13 = (ev)var9_8.c();
            if (var19_6) {
                return;
            }
        }
lbl21: // 4 sources:
        if (var18_13 == null) return;
        while (var9_8 != null) {
            v0 = ((ev)var9_8.c()).a DCMPL var18_13.a;
            if (!var19_6) {
                if (v0 != false) break;
                var6_4.add(((ev)var9_8.c()).a(var7_5));
                var9_8 = var9_8.a();
                if (!var19_6) continue;
            }
            ** GOTO lbl33
        }
        do {
            if (var8_7 == null) return;
            v0 = ((ev)var8_7.c()).a DCMPL var18_13.a;
lbl33: // 2 sources:
            if (v0 != false) return;
            var6_4.add(((ev)var8_7.c()).a(var7_5));
            var8_7 = var8_7.b();
        } while (!var19_6);
    }

    protected void a(q q2, Collection collection, Collection collection2) {
        bu bu2 = this.c().getGraph2D();
        fj fj2 = bu2.t(q2);
        if (!this.a(fj2)) return;
        this.a(q2, fj2, collection, collection2);
    }

    static double a(dU dU2) {
        return dU2.w;
    }

    static boolean b(dU dU2) {
        return dU2.g;
    }

    static boolean c(dU dU2) {
        return dU2.f;
    }
}

