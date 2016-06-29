package y.a;

import y.g.*;
import y.c.*;

class i extends e
{
    int[] a;
    int[] f;
    d g;
    h h;
    A i;
    boolean j;
    int k;
    
    i(final h h, final A i) {
        this.i = i;
        this.h = h;
        this.j = false;
    }
    
    public void a(final y.c.i i) {
        this.a = new int[i.f()];
        this.f = new int[i.f()];
        this.g = new d(i.g());
        super.a(i);
    }
    
    protected void a(final q q, final int n) {
        this.f[q.d()] = (this.a[q.d()] = n);
    }
    
    protected void a(final y.c.d d, final q q, final boolean b) {
        this.g.a(d);
        if (!b) {
            if (d.e()) {
                this.h.a(d, -1);
                this.g.b();
                if (!y.a.h.a) {
                    return;
                }
            }
            final q a = d.a(q);
            this.a[a.d()] = Math.min(this.a[a.d()], this.f[q.d()]);
        }
    }
    
    protected void a(final q q) {
        this.j = false;
    }
    
    protected void a(final y.c.d d, final q q) {
        final boolean a = y.a.h.a;
        final q a2 = d.a(q);
        Label_0157: {
            if (this.a[q.d()] >= this.f[a2.d()]) {
                while (true) {
                    while (this.g.a() != d) {
                        this.h.a(this.g.b(), this.k);
                        if (a) {
                            if (this.g.c()) {
                                if (this.j) {
                                    this.i.a(a2, true);
                                    if (!a) {
                                        break Label_0157;
                                    }
                                }
                                this.j = true;
                                if (!a) {
                                    break Label_0157;
                                }
                            }
                            this.i.a(a2, true);
                            break Label_0157;
                        }
                        if (a) {
                            break;
                        }
                    }
                    this.h.a(this.g.b(), this.k);
                    ++this.k;
                    continue;
                }
            }
        }
        this.a[a2.d()] = Math.min(this.a[a2.d()], this.a[q.d()]);
    }
}
