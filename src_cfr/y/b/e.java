/*
 * Decompiled with CFR 0_115.
 */
package y.b;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import y.b.a;
import y.b.c;
import y.b.d;
import y.b.f;
import y.b.g;
import y.b.h;
import y.b.i;
import y.b.j;
import y.b.k;
import y.c.D;

public class e {
    private static final c[] b = new c[0];
    private final a c;
    private final a d;
    private final a e;
    private int f;
    private double g;
    private final D h;
    private final List i;
    private Timer j;
    private boolean k;
    private boolean l;
    private boolean m;
    private volatile boolean n;
    public static int a;

    public e() {
        this(1.0, true);
    }

    public e(double d2, boolean bl2) {
        int n2 = a;
        this.c = new a(this, 3);
        this.d = new a(this, 0);
        this.e = new a(this, 4);
        this.f = 120;
        this.g = d2;
        this.h = new D();
        this.i = new ArrayList(2);
        this.j = null;
        this.k = bl2;
        this.l = true;
        this.m = true;
        if (n2 == 0) return;
        y.c.i.g = !y.c.i.g;
    }

    public e(boolean bl2) {
        this(1.0, bl2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(c c2) {
        if (c2 == null) {
            return;
        }
        List list = this.i;
        synchronized (list) {
            this.i.add(c2);
            return;
        }
    }

    public void a(boolean bl2) {
        this.l = bl2;
    }

    public boolean a() {
        return this.m;
    }

    public boolean b() {
        return this.k;
    }

    public void b(boolean bl2) {
        this.k = bl2;
    }

    public void a(d d2) {
        this.m = EventQueue.isDispatchThread();
        if (this.k) {
            this.c(d2);
            if (a == 0) return;
        }
        this.b(d2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void b(d d2) {
        if (this.j == null) {
            this.b(this.c);
        }
        this.a(new k(d2));
        D d3 = this.h;
        synchronized (d3) {
            this.h.add(new h(this, d2));
        }
        this.c();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void c(d d2) {
        int n2 = a;
        this.n = true;
        try {
            block7 : {
                long l2;
                e e2;
                this.a(this.c);
                this.a(new k(d2));
                j j2 = new j(d2);
                long l3 = d2.preferredDuration();
                long l4 = l2 = 0 < l3 ? (long)((double)l3 / this.g) : 0;
                if (l2 > 0) {
                    long l5 = Math.max(1, 1000 / (long)this.f);
                    double d3 = 0.0;
                    long l6 = 0;
                    long l7 = System.currentTimeMillis();
                    while (d3 < 1.0) {
                        e2 = this;
                        if (n2 != 0) break block7;
                        if (!e2.n) break;
                        j2.a(d3);
                        this.a(j2);
                        this.a(this.d);
                        long l8 = (l6 += l5) - System.currentTimeMillis() + l7;
                        if (l8 > 10) {
                            try {
                                Thread.sleep(l8);
                            }
                            catch (Exception var17_10) {
                                // empty catch block
                            }
                        }
                        d3 = (double)(System.currentTimeMillis() - l7) / (double)l2;
                        if (n2 == 0) continue;
                    }
                }
                j2.a(1.0);
                this.a(j2);
                this.a(this.d);
                this.a(new i(d2));
                this.a(this.e);
                e2 = this;
            }
            e2.n = false;
            return;
        }
        catch (Throwable var18_12) {
            this.n = false;
            throw var18_12;
        }
    }

    private void c() {
        if (this.j != null) return;
        this.j = new Timer(1000 / this.f, new g(this, null));
        this.j.setInitialDelay(0);
        this.j.start();
    }

    private void d() {
        if (this.j == null) return;
        this.j.stop();
        this.j = null;
        this.b(this.e);
    }

    private void a(Runnable runnable) {
        if (this.l && !EventQueue.isDispatchThread()) {
            try {
                EventQueue.invokeAndWait(runnable);
                return;
            }
            catch (InvocationTargetException var2_2) {
                if (var2_2.getTargetException() instanceof RuntimeException) {
                    throw (RuntimeException)var2_2.getTargetException();
                }
                if (!(var2_2.getTargetException() instanceof Error)) throw new RuntimeException(var2_2.toString());
                throw (Error)var2_2.getTargetException();
            }
            catch (InterruptedException var2_3) {
                if (a == 0) return;
            }
        }
        runnable.run();
    }

    private void a(a a2) {
        c[] arrc;
        int n2 = a;
        if (null == this.i) return;
        if (this.i.isEmpty()) return;
        if (this.l && !EventQueue.isDispatchThread()) {
            arrc = this.i.toArray(b);
            try {
                EventQueue.invokeAndWait(new f(this, arrc, a2));
                return;
            }
            catch (InvocationTargetException var3_4) {
                if (var3_4.getTargetException() instanceof RuntimeException) {
                    throw (RuntimeException)var3_4.getTargetException();
                }
                if (!(var3_4.getTargetException() instanceof Error)) throw new RuntimeException(var3_4.toString());
                throw (Error)var3_4.getTargetException();
            }
            catch (InterruptedException var3_5) {
                if (n2 == 0) return;
            }
        }
        arrc = this.i.toArray(b);
        int n3 = 0;
        int n4 = arrc.length;
        do {
            if (n3 >= n4) return;
            arrc[n3].animationPerformed(a2);
            ++n3;
        } while (n2 == 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void b(a a2) {
        int n2 = a;
        List list = this.i;
        synchronized (list) {
            if (this.i.isEmpty()) {
                return;
            }
            c[] arrc = this.i.toArray(b);
            int n3 = 0;
            int n4 = arrc.length;
            do {
                if (n3 >= n4) return;
                arrc[n3].animationPerformed(a2);
                ++n3;
                if (n2 != 0) return;
            } while (n2 == 0);
            return;
        }
    }

    static double a(e e2) {
        return e2.g;
    }

    static D b(e e2) {
        return e2.h;
    }

    static a c(e e2) {
        return e2.d;
    }

    static void a(e e2, a a2) {
        e2.b(a2);
    }

    static void d(e e2) {
        e2.d();
    }
}

