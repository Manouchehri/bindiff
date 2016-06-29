package y.g;

import java.util.*;
import y.c.*;

public class J
{
    private i a;
    private List b;
    private List c;
    private boolean d;
    private c e;
    private Map f;
    private static final Object g;
    
    public J(final i a, final c c) {
        this.d = true;
        this.a = a;
        this.b = new ArrayList(a.g());
        this.c = new ArrayList(a.e());
        this.a(c);
    }
    
    public void a(final c e) {
        final boolean c = p.c;
        this.f = new HashMap();
        this.e = e;
        final x o = this.a.o();
        while (o.f()) {
            final q e2 = o.e();
            final Object b = e.b(e2);
            K k = this.f.get((b == null) ? J.g : b);
            if (k == null) {
                k = new K();
                this.f.put((b == null) ? J.g : b, k);
            }
            k.a.add(e2);
            d d = e2.g();
            Object o2 = null;
            Object o4;
            Object o3 = null;
            Object o6;
            Object o5 = null;
            Label_0165_Outer:Label_0217_Outer:
            while (true) {
                while (true) {
                    while (true) {
                        Label_0239: {
                            Label_0211: {
                                if (d == null) {
                                    break Label_0211;
                                }
                                o2 = e.b(d.c());
                                o3 = (o4 = o2);
                                o5 = (o6 = b);
                                if (c) {
                                    break Label_0239;
                                }
                                if (o4 != o6) {
                                    if (o2 == null || !o2.equals(b)) {
                                        k.c.add(d);
                                    }
                                }
                                d = d.h();
                                if (!c) {
                                    continue Label_0165_Outer;
                                }
                            }
                            d = e2.f();
                            if (d == null) {
                                break;
                            }
                            o2 = e.b(d.d());
                            o3 = (o4 = o2);
                            o5 = (o6 = b);
                        }
                        if (c) {
                            continue Label_0217_Outer;
                        }
                        break;
                    }
                    Label_0293: {
                        if (o3 == o5 || (o2 != null && o2.equals(b))) {
                            k.b.add(d);
                            if (!c) {
                                break Label_0293;
                            }
                        }
                        k.c.add(d);
                    }
                    d = d.g();
                    if (c) {
                        break;
                    }
                    continue;
                }
            }
            o.g();
            if (c) {
                break;
            }
        }
    }
    
    public void a(final Object o) {
        final boolean c = p.c;
        final K k = this.f.get((o == null) ? J.g : o);
        if (k != null) {
            int i = k.a.size() - 1;
            while (i >= 0) {
                this.a((q)k.a.get(i));
                --i;
                if (c) {
                    break;
                }
            }
        }
    }
    
    public void b(final Object o) {
        final boolean c = p.c;
        final K k = this.f.get((o == null) ? J.g : o);
        if (k != null) {
            int i = k.a.size() - 1;
            while (true) {
                while (i >= 0) {
                    final q q = k.a.get(i);
                    final int f;
                    final int n = f = (this.a.f(q) ? 1 : 0);
                    if (c) {
                        int j = f;
                        while (true) {
                            while (j >= 0) {
                                final d d = k.b.get(j);
                                final int f2;
                                final int n2 = f2 = (this.a.f(d) ? 1 : 0);
                                if (c) {
                                    int l = f2;
                                    while (l >= 0) {
                                        final d d2 = k.c.get(l);
                                        if (this.a.f(d2.c()) && this.a.f(d2.d()) && !this.a.f(d2)) {
                                            this.a(d2);
                                        }
                                        --l;
                                        if (c) {
                                            break;
                                        }
                                    }
                                    return;
                                }
                                if (n2 == 0) {
                                    this.a(d);
                                }
                                --j;
                                if (c) {
                                    break;
                                }
                            }
                            int f2 = k.c.size() - 1;
                            continue;
                        }
                    }
                    if (n == 0) {
                        this.b(q);
                    }
                    --i;
                    if (c) {
                        break;
                    }
                }
                int f = k.b.size() - 1;
                continue;
            }
        }
    }
    
    public void c(final Object o) {
        final boolean c = p.c;
        final x o2 = this.a.o();
        while (true) {
            while (o2.f()) {
                final q e = o2.e();
                final Object b;
                final Object o3 = b = this.e.b(e);
                if (c) {
                    final K k = (K)b;
                    if (k != null) {
                        int i = k.a.size() - 1;
                        while (true) {
                            while (i >= 0) {
                                final q q = k.a.get(i);
                                final int f;
                                final int n = f = (this.a.f(q) ? 1 : 0);
                                if (c) {
                                    int j = f;
                                    while (j >= 0) {
                                        final d d = k.b.get(j);
                                        if (!this.a.f(d)) {
                                            this.a(d);
                                        }
                                        --j;
                                        if (c) {
                                            break;
                                        }
                                    }
                                    return;
                                }
                                if (n == 0) {
                                    this.b(q);
                                }
                                --i;
                                if (c) {
                                    break;
                                }
                            }
                            int f = k.b.size() - 1;
                            continue;
                        }
                    }
                    return;
                }
                if (b != o && (o == null || !o.equals(o3))) {
                    this.a(e);
                }
                o2.g();
                if (c) {
                    break;
                }
            }
            this.f.get((o == null) ? J.g : o);
            continue;
        }
    }
    
    public void a() {
        final boolean c = p.c;
        final x o = this.a.o();
        while (o.f()) {
            this.a(o.e());
            o.g();
            if (c) {
                break;
            }
        }
    }
    
    public void b() {
        this.c();
        this.d();
    }
    
    public void c() {
        final boolean c = p.c;
        int i = this.c.size() - 1;
        while (true) {
            while (i >= 0) {
                final q q = this.c.get(i);
                final J j = this;
                if (c) {
                    j.c.clear();
                    return;
                }
                if (!this.a.f(q)) {
                    this.b(q);
                }
                --i;
                if (c) {
                    break;
                }
            }
            final J j = this;
            continue;
        }
    }
    
    public void d() {
        final boolean c = p.c;
        int i = this.b.size() - 1;
        while (true) {
            while (i >= 0) {
                final d d = this.b.get(i);
                final J j = this;
                if (c) {
                    j.b.clear();
                    return;
                }
                if (!this.a.f(d)) {
                    this.a(d);
                }
                --i;
                if (c) {
                    break;
                }
            }
            final J j = this;
            continue;
        }
    }
    
    public void a(final q q) {
        final boolean c = p.c;
        if (!this.a.f(q)) {
            return;
        }
        d d = q.g();
    Label_0162:
        while (true) {
            while (d != null) {
                final d d2 = d;
                d = d.h();
                this.b.add(d2);
                final boolean d3 = this.d;
                if (c) {
                    if (d3) {
                        this.a.c(q);
                        if (!c) {
                            return;
                        }
                    }
                    this.a.a(q);
                    return;
                }
                if (d3) {
                    this.a.d(d2);
                    if (!c) {
                        continue;
                    }
                }
                this.a.a(d2);
                if (c) {
                    break;
                }
            }
            d d4 = q.f();
            while (d4 != null) {
                final d d5 = d4;
                d4 = d4.g();
                this.b.add(d5);
                final boolean d6 = this.d;
                if (c) {
                    continue Label_0162;
                }
                if (d6) {
                    this.a.d(d5);
                    if (!c) {
                        continue;
                    }
                }
                this.a.a(d5);
                if (c) {
                    break;
                }
            }
            this.c.add(q);
            final boolean d7 = this.d;
            continue Label_0162;
        }
    }
    
    protected void a(final d d) {
        if (this.d) {
            this.a.e(d);
            if (!p.c) {
                return;
            }
        }
        this.a.b(d);
    }
    
    protected void b(final q q) {
        if (this.d) {
            this.a.d(q);
            if (!p.c) {
                return;
            }
        }
        this.a.b(q);
    }
    
    static {
        g = new Object();
    }
}
