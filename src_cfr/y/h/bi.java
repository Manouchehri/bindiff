/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Cursor;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import y.b.d;
import y.c.A;
import y.c.h;
import y.f.O;
import y.f.P;
import y.f.X;
import y.f.ad;
import y.f.ae;
import y.f.ah;
import y.f.an;
import y.f.aw;
import y.f.c;
import y.f.e;
import y.h.a.i;
import y.h.a.v;
import y.h.bJ;
import y.h.bO;
import y.h.bP;
import y.h.bQ;
import y.h.bR;
import y.h.bS;
import y.h.bu;
import y.h.ch;
import y.h.dj;
import y.h.dm;
import y.h.ff;
import y.h.fj;
import y.h.fk;
import y.h.gg;

public class bI {
    private byte d;
    private boolean e;
    private boolean f = true;
    private boolean g = true;
    private boolean h = true;
    private boolean i;
    private boolean j = true;
    private y.h.b.v k;
    private ff l;
    private boolean m;
    private dj n;
    private boolean o = true;
    static Class a;
    static Class b;
    static Class c;

    public bI() {
        this(3);
    }

    public bI(byte by2) {
        this.a(by2);
    }

    public byte a() {
        return this.d;
    }

    /*
     * Unable to fully structure code
     */
    public void a(byte var1_1) {
        switch (var1_1) {
            case 0: 
            case 1: 
            case 3: 
            case 5: 
            case 7: {
                if (!fj.z) ** GOTO lbl5
            }
        }
        throw new IllegalArgumentException("illegal mode");
lbl5: // 1 sources:
        this.d = var1_1;
    }

    public boolean b() {
        return this.e;
    }

    public y.h.b.v c() {
        if (this.k != null) return this.k;
        this.k = new y.h.b.v();
        return this.k;
    }

    public ff d() {
        if (this.l != null) return this.l;
        this.l = new ff();
        return this.l;
    }

    public dj e() {
        if (this.n != null) return this.n;
        this.n = this.l();
        return this.n;
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.h;
    }

    public boolean h() {
        return this.i;
    }

    public boolean i() {
        return this.j;
    }

    public boolean j() {
        return this.f;
    }

    public void a(boolean bl2) {
        this.f = bl2;
    }

    private void a(ch ch2, bu bu2, ah ah2, Map map) {
        bu2.r();
        if (this.j()) {
            bu2.V();
        }
        A a2 = null;
        h h2 = null;
        i i2 = null;
        y.h.b.v v2 = null;
        ff ff2 = null;
        if (this.o) {
            if (bu2.c(ah.g_) == null) {
                a2 = gg.a(bu2);
                bu2.a(ah.g_, a2);
            }
            if (bu2.c(ah.h_) == null) {
                h2 = gg.b(bu2);
                bu2.a(ah.h_, h2);
            }
        }
        if (this.i()) {
            ff2 = this.c(ch2, bu2, ah2);
        }
        if (bu2.C() != null) {
            if (this.h()) {
                i2 = this.a(ch2, bu2, ah2);
                v2 = this.b(ch2, bu2, ah2);
            } else if (this.f()) {
                i2 = this.a(ch2, bu2, ah2);
            }
        }
        map.put("nodeSelection", a2);
        map.put("edgeSelection", h2);
        Class class_ = a == null ? (bI.a = bI.a("y.h.a.i")) : a;
        map.put(class_, i2);
        Class class_2 = b == null ? (bI.b = bI.a("y.h.b.v")) : b;
        map.put(class_2, v2);
        Class class_3 = c == null ? (bI.c = bI.a("y.h.ff")) : c;
        map.put(class_3, ff2);
    }

    protected i a(ch ch2, bu bu2, ah ah2) {
        i i2 = new i(bu2);
        i2.k();
        return i2;
    }

    protected y.h.b.v b(ch ch2, bu bu2, ah ah2) {
        c c2;
        y.h.b.v v2 = this.c();
        if (ah2 instanceof c && (c2 = (c)ah2).g() instanceof an && c2.i()) {
            v2.a(((an)c2.g()).d());
        }
        v2.a(bu2);
        return v2;
    }

    protected ff c(ch ch2, bu bu2, ah ah2) {
        ff ff2 = this.d();
        ff2.a(bu2);
        return ff2;
    }

    private void a(bu bu2, Map map) {
        Object v2;
        A a2 = (A)map.get("nodeSelection");
        h h2 = (h)map.get("edgeSelection");
        Class class_ = a == null ? (bI.a = bI.a("y.h.a.i")) : a;
        i i2 = (i)map.get(class_);
        this.b(bu2, map);
        this.c(bu2, map);
        Object v3 = map.get("nrics");
        if (v3 instanceof y.c.c) {
            bu2.d_(P.a);
        }
        if ((v2 = map.get("nrict")) instanceof y.c.c) {
            bu2.d_(P.b);
        }
        if (i2 != null) {
            this.a(bu2, i2);
        }
        if (a2 != null) {
            bu2.d_(ah.g_);
        }
        if (h2 != null) {
            bu2.d_(ah.h_);
        }
        bu2.s();
    }

    private void b(bu bu2, Map map) {
        Class class_ = b == null ? (bI.b = bI.a("y.h.b.v")) : b;
        y.h.b.v v2 = (y.h.b.v)map.get(class_);
        if (v2 == null) return;
        this.a(bu2, v2);
        map.remove(b == null ? (bI.b = bI.a("y.h.b.v")) : b);
    }

    private void c(bu bu2, Map map) {
        Class class_ = c == null ? (bI.c = bI.a("y.h.ff")) : c;
        Class class_2 = class_;
        ff ff2 = (ff)map.get(class_2);
        if (ff2 == null) return;
        this.a(bu2, ff2);
        map.remove(class_2);
    }

    protected void a(bu bu2, i i2) {
        i2.l();
    }

    protected void a(bu bu2, y.h.b.v v2) {
        v2.d(bu2);
    }

    protected void a(bu bu2, ff ff2) {
        ff2.d(bu2);
    }

    private ah a(ch ch2, ah ah2) {
        Object object;
        ad ad2;
        if (this.g() && ch2 != null && ah2 instanceof c && (object = (c)ah2).e() instanceof e) {
            ad2 = (e)object.e();
            this.a(ch2, (e)ad2);
        }
        if ((ad2 = (object = this.d()).d()) == null) return ah2;
        ad2.a(ah2);
        return ad2;
    }

    final void a(X x2, aw aw2) {
        if (!this.m()) return;
        aw2.c(x2);
    }

    private aw d(bu bu2, Map map) {
        fk fk2;
        aw aw2 = new aw();
        if (bu2.c(P.a) == null) {
            fk2 = new fk(bu2, true);
            map.put("nrics", fk2);
            bu2.a(P.a, fk2);
        }
        if (bu2.c(P.b) != null) return aw2;
        fk2 = new fk(bu2, false);
        map.put("nrict", fk2);
        bu2.a(P.b, fk2);
        return aw2;
    }

    private bS a(ch ch2, bu bu2, ah ah2, Runnable runnable, bQ bQ2, boolean bl2) {
        return new bJ(this, ch2, bu2, ah2, bl2, bQ2, runnable);
    }

    private bS b(ch ch2, bu bu2, ah ah2, Runnable runnable, bQ bQ2, boolean bl2) {
        return new bO(this, ch2, bu2, ah2, bl2, bQ2, runnable);
    }

    public void a(bu bu2, ah ah2) {
        this.a(null, bu2, ah2, null, null);
    }

    public void d(ch ch2, bu bu2, ah ah2) {
        this.a(ch2, bu2, ah2, null, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public bR a(ch ch2, bu bu2, ah ah2, Runnable runnable, bQ bQ2) {
        Throwable[] arrthrowable;
        boolean bl2;
        boolean bl3;
        bS bS2;
        block14 : {
            boolean bl4;
            bl2 = fj.z;
            if (bu2 == null) {
                throw new IllegalArgumentException("graph may not be null.");
            }
            if (ah2 == null) {
                throw new IllegalArgumentException("layouter may not be null.");
            }
            bl3 = (this.a() & 4) == 4;
            boolean bl5 = bl3 || this.a(ch2);
            boolean bl6 = ch2 != null && (this.a() & 2) == 2 && this.e().preferredDuration() > 0;
            boolean bl7 = bl4 = (this.a() & 1) == 1;
            if (!bl4) {
                HashMap hashMap = new HashMap();
                this.a(ch2, bu2, ah2, hashMap);
                ah ah3 = this.a(ch2, ah2);
                try {
                    try {
                        ah3.c(bu2);
                        if (this.m()) {
                            this.a((X)bu2, this.d(bu2, hashMap));
                        }
                        bu2.T();
                    }
                    catch (RuntimeException var12_18) {
                        if (bQ2 == null) throw var12_18;
                        bQ2.a(var12_18);
                        if (bl2) {
                            throw var12_18;
                        }
                        Object var14_16 = null;
                        this.a(bu2, hashMap);
                        if (runnable == null) return null;
                        runnable.run();
                        return null;
                    }
                    Object var14_15 = null;
                    this.a(bu2, hashMap);
                    if (runnable == null) return null;
                    runnable.run();
                    return null;
                }
                catch (Throwable var13_19) {
                    Object var14_17 = null;
                    this.a(bu2, hashMap);
                    if (runnable == null) throw var13_19;
                    runnable.run();
                    throw var13_19;
                }
            }
            arrthrowable = new Throwable[1];
            if (!bl3 && bQ2 == null) {
                bQ2 = new bP(this, arrthrowable);
            }
            if (bl6) {
                bS2 = this.a(ch2, bu2, ah2, runnable, bQ2, bl5);
                if (!bl2) break block14;
            }
            bS2 = this.b(ch2, bu2, ah2, runnable, bQ2, bl5);
        }
        if (bl3) {
            this.a(bS2);
            if (!bl2) return bS2.b();
        }
        bS2.run();
        if (arrthrowable[0] == null) return bS2.b();
        if (arrthrowable[0] instanceof RuntimeException) {
            throw (RuntimeException)arrthrowable[0];
        }
        if (!(arrthrowable[0] instanceof Error)) return bS2.b();
        throw (Error)arrthrowable[0];
    }

    protected void a(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    private Map b(ch ch2) {
        if (ch2 == null) return null;
        if (!this.b()) return null;
        HashMap hashMap = new HashMap();
        this.a(ch2, hashMap);
        return hashMap;
    }

    protected void a(ch ch2, Map map) {
        boolean bl2 = ch2.isInputSuppressed();
        map.put("wasInputSuppressed", bl2 ? Boolean.TRUE : Boolean.FALSE);
        ch2.setInputSuppressed(true);
        map.put("oldCursor", ch2.getViewCursor());
        ch2.setViewCursor(Cursor.getPredefinedCursor(3));
    }

    protected void b(ch ch2, Map map) {
        Object v2;
        if (map.get("wasInputSuppressed") == Boolean.FALSE) {
            ch2.setInputSuppressed(false);
        }
        if (!((v2 = map.get("oldCursor")) instanceof Cursor)) return;
        ch2.setViewCursor((Cursor)v2);
    }

    protected void a(ch ch2, e e2) {
        Dimension dimension = ch2.getSize();
        e2.a(dimension.getWidth(), dimension.getHeight());
        double d2 = ch2.getGridMode() ? ch2.getGridResolution() : 0.0;
        e2.a(0.0);
        if (d2 > 0.0) {
            e2.b(d2);
            if (!fj.z) return;
        }
        e2.b(45.0);
    }

    protected y.b.e k() {
        return new y.b.e();
    }

    protected dj l() {
        dj dj2 = new dj();
        dj2.setPreferredDuration(300);
        dj2.setEasedExecution(true);
        return dj2;
    }

    protected d a(ch ch2, bu bu2, O o2) {
        dj dj2 = this.e();
        dj2.initialize(ch2, o2);
        return dj2;
    }

    protected boolean a(ch ch2) {
        if (SwingUtilities.isEventDispatchThread()) return false;
        if (ch2 == null) return false;
        if (!ch2.isShowing()) return false;
        return true;
    }

    protected void a(bu bu2, O o2) {
        ae.a((X)bu2, new dm(bu2, o2));
    }

    public boolean m() {
        return this.m;
    }

    public void b(boolean bl2) {
        this.m = bl2;
    }

    static Class a(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static Map a(bI bI2, ch ch2) {
        return bI2.b(ch2);
    }

    static void a(bI bI2, ch ch2, bu bu2, ah ah2, Map map) {
        bI2.a(ch2, bu2, ah2, map);
    }

    static ah a(bI bI2, ch ch2, ah ah2) {
        return bI2.a(ch2, ah2);
    }

    static aw a(bI bI2, bu bu2, Map map) {
        return bI2.d(bu2, map);
    }

    static void b(bI bI2, bu bu2, Map map) {
        bI2.a(bu2, map);
    }
}

