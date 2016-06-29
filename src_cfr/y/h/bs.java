/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import y.f.X;
import y.f.ah;
import y.f.aw;
import y.f.l;
import y.h.bI;
import y.h.bK;
import y.h.bL;
import y.h.bM;
import y.h.bR;
import y.h.bT;
import y.h.bu;
import y.h.ch;
import y.h.fj;

abstract class bS
implements Runnable {
    private aw i;
    volatile l a;
    volatile Throwable b;
    volatile ah c;
    final ch d;
    final bu e;
    final ah f;
    final boolean g;
    final Map h;
    private volatile Map j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile Thread m;
    private final bI n;

    bS(bI bI2, ch ch2, bu bu2, ah ah2, boolean bl2) {
        this.n = bI2;
        this.h = new HashMap();
        this.e = bu2;
        this.f = ah2;
        this.d = ch2;
        this.g = bl2;
    }

    bR b() {
        return new bT(this);
    }

    protected void c() {
        block2 : {
            this.j = bI.a(this.n, this.d);
            bI.a(this.n, this.d, this.e, this.f, this.h);
            this.c = bI.a(this.n, this.d, this.f);
            if (this.n.m()) {
                this.i = bI.a(this.n, this.e, this.h);
                if (!fj.z) break block2;
            }
            this.i = null;
        }
        this.a = new l(this.e);
    }

    protected void d() {
    }

    protected abstract void a(l var1);

    protected void b(l l2) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void a() {
        try {
            bI.b(this.n, this.e, this.h);
            Object var2_1 = null;
            if (this.j == null) return;
            this.n.b(this.d, this.j);
            return;
        }
        catch (Throwable var1_3) {
            Object var2_2 = null;
            if (this.j == null) throw var1_3;
            this.n.b(this.d, this.j);
            throw var1_3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            this.m = Thread.currentThread();
            if (this.k) return;
            this.a(new bK(this));
            if (this.b != null) {
                this.d();
            }
            try {
                if (!this.k && this.b == null && this.a != null && this.c != null) {
                    try {
                        this.c.c(this.a);
                    }
                    catch (RuntimeException var1_1) {
                        this.b = var1_1;
                    }
                    catch (Error var1_2) {
                        this.b = var1_2;
                    }
                }
                if (!this.k && this.b == null && this.a != null) {
                    this.a(new bL(this));
                }
                if (this.k) return;
                if (this.b != null) return;
                if (this.a == null) return;
                this.b(this.a);
                return;
            }
            finally {
                this.a(new bM(this));
            }
        }
        finally {
            this.l = true;
        }
    }

    void a(Runnable runnable) {
        if (this.g && !SwingUtilities.isEventDispatchThread()) {
            try {
                SwingUtilities.invokeAndWait(runnable);
                return;
            }
            catch (InterruptedException var2_2) {
                this.b = var2_2;
                return;
            }
            catch (InvocationTargetException var2_3) {
                this.b = var2_3.getTargetException();
                if (!fj.z) return;
            }
        }
        runnable.run();
    }

    static aw a(bS bS2) {
        return bS2.i;
    }

    static bI b(bS bS2) {
        return bS2.n;
    }
}

