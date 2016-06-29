package y.b;

import javax.swing.*;
import java.util.*;
import y.c.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class e
{
    private static final c[] b;
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
    
    public e(final double g, final boolean k) {
        final int a = y.b.e.a;
        this.c = new a(this, 3);
        this.d = new a(this, 0);
        this.e = new a(this, 4);
        this.f = 120;
        this.g = g;
        this.h = new D();
        this.i = new ArrayList(2);
        this.j = null;
        this.k = k;
        this.l = true;
        this.m = true;
        if (a != 0) {
            y.c.i.g = !y.c.i.g;
        }
    }
    
    public e(final boolean b) {
        this(1.0, b);
    }
    
    public void a(final c c) {
        if (c == null) {
            return;
        }
        synchronized (this.i) {
            this.i.add(c);
        }
    }
    
    public void a(final boolean l) {
        this.l = l;
    }
    
    public boolean a() {
        return this.m;
    }
    
    public boolean b() {
        return this.k;
    }
    
    public void b(final boolean k) {
        this.k = k;
    }
    
    public void a(final d d) {
        this.m = EventQueue.isDispatchThread();
        if (this.k) {
            this.c(d);
            if (y.b.e.a == 0) {
                return;
            }
        }
        this.b(d);
    }
    
    private void b(final d d) {
        if (this.j == null) {
            this.b(this.c);
        }
        this.a(new k(d));
        synchronized (this.h) {
            this.h.add(new h(this, d));
        }
        this.c();
    }
    
    private void c(final d d) {
        final int a = y.b.e.a;
        this.n = true;
        try {
            this.a(this.c);
            this.a(new k(d));
            final j j = new j(d);
            final long preferredDuration = d.preferredDuration();
            final long n = (0L < preferredDuration) ? ((long)(preferredDuration / this.g)) : 0L;
            if (n > 0L) {
                final long max = Math.max(1L, 1000L / this.f);
                double n2 = 0.0;
                long n3 = 0L;
                final long currentTimeMillis = System.currentTimeMillis();
                while (n2 < 1.0) {
                    if (a != 0) {
                        return;
                    }
                    if (!this.n) {
                        break;
                    }
                    j.a(n2);
                    this.a(j);
                    this.a(this.d);
                    n3 += max;
                    final long n4 = n3 - System.currentTimeMillis() + currentTimeMillis;
                    if (n4 > 10L) {
                        try {
                            Thread.sleep(n4);
                        }
                        catch (Exception ex) {}
                    }
                    n2 = (System.currentTimeMillis() - currentTimeMillis) / n;
                    if (a != 0) {
                        break;
                    }
                }
            }
            j.a(1.0);
            this.a(j);
            this.a(this.d);
            this.a(new y.b.i(d));
            this.a(this.e);
        }
        finally {
            this.n = false;
        }
    }
    
    private void c() {
        if (this.j == null) {
            (this.j = new Timer(1000 / this.f, new g(this, null))).setInitialDelay(0);
            this.j.start();
        }
    }
    
    private void d() {
        if (this.j != null) {
            this.j.stop();
            this.j = null;
            this.b(this.e);
        }
    }
    
    private void a(final Runnable runnable) {
        if (this.l && !EventQueue.isDispatchThread()) {
            try {
                EventQueue.invokeAndWait(runnable);
                return;
            }
            catch (InvocationTargetException ex) {
                if (ex.getTargetException() instanceof RuntimeException) {
                    throw (RuntimeException)ex.getTargetException();
                }
                if (ex.getTargetException() instanceof Error) {
                    throw (Error)ex.getTargetException();
                }
                throw new RuntimeException(ex.toString());
            }
            catch (InterruptedException ex2) {
                if (y.b.e.a == 0) {
                    return;
                }
            }
        }
        runnable.run();
    }
    
    private void a(final a a) {
        final int a2 = y.b.e.a;
        if (null != this.i && !this.i.isEmpty()) {
            if (this.l && !EventQueue.isDispatchThread()) {
                final c[] array = this.i.toArray(y.b.e.b);
                try {
                    EventQueue.invokeAndWait(new f(this, array, a));
                    return;
                }
                catch (InvocationTargetException ex) {
                    if (ex.getTargetException() instanceof RuntimeException) {
                        throw (RuntimeException)ex.getTargetException();
                    }
                    if (ex.getTargetException() instanceof Error) {
                        throw (Error)ex.getTargetException();
                    }
                    throw new RuntimeException(ex.toString());
                }
                catch (InterruptedException ex2) {
                    if (a2 == 0) {
                        return;
                    }
                }
            }
            final c[] array2 = this.i.toArray(y.b.e.b);
            int i = 0;
            while (i < array2.length) {
                array2[i].animationPerformed(a);
                ++i;
                if (a2 != 0) {
                    break;
                }
            }
        }
    }
    
    private void b(final a a) {
        final int a2 = y.b.e.a;
        synchronized (this.i) {
            if (this.i.isEmpty()) {
                return;
            }
            final c[] array = this.i.toArray(y.b.e.b);
            int i = 0;
            while (i < array.length) {
                array[i].animationPerformed(a);
                ++i;
                if (a2 == 0 && a2 == 0) {
                    continue;
                }
                return;
            }
            goto Label_0080;
        }
    }
    
    static double a(final e e) {
        return e.g;
    }
    
    static D b(final e e) {
        return e.h;
    }
    
    static a c(final e e) {
        return e.d;
    }
    
    static void a(final e e, final a a) {
        e.b(a);
    }
    
    static void d(final e e) {
        e.d();
    }
    
    static {
        b = new c[0];
    }
}
