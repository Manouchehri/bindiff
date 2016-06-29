package y.h;

import java.util.*;
import y.f.*;
import javax.swing.*;
import java.lang.reflect.*;

abstract class bS implements Runnable
{
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
    
    bS(final bI n, final ch d, final bu e, final ah f, final boolean g) {
        this.n = n;
        this.h = new HashMap();
        this.e = e;
        this.f = f;
        this.d = d;
        this.g = g;
    }
    
    bR b() {
        return new bT(this);
    }
    
    protected void c() {
        this.j = bI.a(this.n, this.d);
        bI.a(this.n, this.d, this.e, this.f, this.h);
        this.c = bI.a(this.n, this.d, this.f);
        Label_0097: {
            if (this.n.m()) {
                this.i = bI.a(this.n, this.e, this.h);
                if (!fj.z) {
                    break Label_0097;
                }
            }
            this.i = null;
        }
        this.a = new l(this.e);
    }
    
    protected void d() {
    }
    
    protected abstract void a(final l p0);
    
    protected void b(final l l) {
    }
    
    protected void a() {
        try {
            bI.b(this.n, this.e, this.h);
        }
        finally {
            if (this.j != null) {
                this.n.b(this.d, this.j);
            }
        }
    }
    
    public void run() {
        try {
            this.m = Thread.currentThread();
            if (!this.k) {
                this.a(new bK(this));
                if (this.b != null) {
                    this.d();
                }
                try {
                    if (!this.k && this.b == null && this.a != null && this.c != null) {
                        try {
                            this.c.c(this.a);
                        }
                        catch (RuntimeException b) {
                            this.b = b;
                        }
                        catch (Error b2) {
                            this.b = b2;
                        }
                    }
                    if (!this.k && this.b == null && this.a != null) {
                        this.a(new bL(this));
                    }
                    if (!this.k && this.b == null && this.a != null) {
                        this.b(this.a);
                    }
                }
                finally {
                    this.a(new bM(this));
                }
            }
        }
        finally {
            this.l = true;
        }
    }
    
    void a(final Runnable runnable) {
        if (this.g && !SwingUtilities.isEventDispatchThread()) {
            try {
                SwingUtilities.invokeAndWait(runnable);
                return;
            }
            catch (InterruptedException b) {
                this.b = b;
                return;
            }
            catch (InvocationTargetException ex) {
                this.b = ex.getTargetException();
                if (!fj.z) {
                    return;
                }
            }
        }
        runnable.run();
    }
    
    static aw a(final bS bs) {
        return bs.i;
    }
    
    static bI b(final bS bs) {
        return bs.n;
    }
}
