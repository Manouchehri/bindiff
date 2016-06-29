package y.f.h;

import java.util.*;
import y.c.*;
import y.f.*;

public class D extends N
{
    private h e;
    private h f;
    private f g;
    private A h;
    private ArrayList i;
    
    public D(final i i) {
        final boolean d = N.d;
        super(i);
        this.h = i.t();
        this.e = i.u();
        this.f = i.u();
        this.i = new ArrayList();
        this.g = new f();
        final e p = i.p();
        while (p.f()) {
            this.f(p.a()).b(true);
            p.g();
            if (d) {
                break;
            }
        }
    }
    
    public void e() {
        super.e();
        this.a.a(this.e);
        this.a.a(this.f);
        this.a.a(this.h);
        this.g.clear();
    }
    
    public void a(final q q, final int n) {
        this.i(q).a(n);
    }
    
    public int a(final q q) {
        return this.i(q).a();
    }
    
    public boolean b(final q q) {
        return this.a(q) == 1;
    }
    
    public void c(final q q) {
        this.a(q, 1);
    }
    
    public void d(final q q) {
        this.a(q, 2);
    }
    
    public boolean e(final q q) {
        return this.a(q) == 2;
    }
    
    public boolean f(final q q) {
        return this.a(q) == 0;
    }
    
    public void g(final q q) {
        this.a(q, 0);
    }
    
    public int a() {
        final boolean d = N.d;
        int n = 0;
        final x o = this.a.o();
        while (o.f()) {
            final int b2;
            final boolean b = (b2 = (this.b(o.e()) ? 1 : 0)) != 0;
            if (d) {
                return b2;
            }
            if (b) {
                ++n;
            }
            o.g();
            if (d) {
                break;
            }
        }
        return n;
    }
    
    public p[] a(final p p2, final d d) {
        return this.a(p2, d, null, null);
    }
    
    public p[] a(final p p4, final d d, d a, d d2) {
        final boolean d3 = N.d;
        if (a != null && this.i(a) != p4) {
            throw new RuntimeException("Fatal Error in edge to face assignment!");
        }
        if (d2 != null && this.i(d2) != p4) {
            throw new RuntimeException("Fatal Error in edge to face assignment!");
        }
        if (this.e(d.c())) {
            this.c(d.c());
        }
        if (this.e(d.d())) {
            this.c(d.d());
        }
        this.b.remove(p4);
        final e a2 = p4.a();
        Label_0220: {
            d a3 = null;
            Label_0218: {
            Label_0211:
                while (true) {
                    q d4 = null;
                    q c = null;
                    Label_0196: {
                        if (a == null) {
                            while (a2.f()) {
                                d4 = a2.a().d();
                                c = d.c();
                                if (d3) {
                                    break Label_0196;
                                }
                                if (d4 == c) {
                                    break;
                                }
                                a2.b();
                                if (d3) {
                                    break;
                                }
                            }
                            a = a2.a();
                        }
                        if (d2 != null) {
                            break Label_0220;
                        }
                        if (!a2.f()) {
                            break Label_0211;
                        }
                        a3 = a2.a();
                        if (d3) {
                            break Label_0218;
                        }
                        a3.d();
                        d.d();
                    }
                    if (d4 != c) {
                        a2.b();
                        if (!d3) {
                            continue;
                        }
                    }
                    break;
                }
                a2.a();
            }
            d2 = a3;
        }
        final d g = this.g(d);
        final p[] array = new p[2];
        final p p5 = new p();
        final p p6 = new p();
        d d5 = null;
        d d6 = null;
        Label_0281: {
            if (a.d() == d.d()) {
                d5 = d;
                d6 = g;
                if (!d3) {
                    break Label_0281;
                }
            }
            d5 = g;
            d6 = d;
        }
        this.f(d5).a(p5);
        this.f(d6).a(p6);
        a2.i();
        while (true) {
        Label_0488:
            while (true) {
                while (a2.f()) {
                    final d a4 = a2.a();
                    final d d7 = a;
                    if (d3) {
                        if (a4 != d7) {
                            this.f(a2.a()).a(p6);
                            p6.a(a2.a());
                            a2.b();
                            if (!d3) {
                                if (a2.f()) {
                                    a2.a();
                                    continue Label_0488;
                                }
                            }
                        }
                        this.f(a).a(p6);
                        p6.a(a);
                        p6.a(d6);
                        this.b.add(p6);
                        array[1] = p6;
                        if (this.i() == p4) {
                            this.b(a(p5, p6));
                        }
                        this.a.a(d5, this.h(d2), null, 0, 1);
                        this.a.a(d6, this.h(a), null, 0, 1);
                        final p[] array2 = { p4 };
                        final p[] array3 = { p5, p6 };
                        if (this.f(d).f()) {
                            final y.c.p d8 = this.g.d(d);
                            if (d8 != null) {
                                this.g.h(d8);
                            }
                        }
                        this.a(d, array2, array3);
                        final p[] array4 = array;
                        if (y.c.i.g) {
                            N.d = !d3;
                        }
                        return array4;
                    }
                    if (a4 == d7) {
                        break;
                    }
                    a2.b();
                    if (d3) {
                        break;
                    }
                }
                a2.b();
                while (a2.f()) {
                    final d a5 = a2.a();
                    final d d9 = d2;
                    if (d3) {
                        continue Label_0488;
                    }
                    if (a5 == d9) {
                        break;
                    }
                    this.f(a2.a()).a(p5);
                    p5.a(a2.a());
                    a2.b();
                    if (d3) {
                        break;
                    }
                }
                break;
            }
            this.f(d2).a(p5);
            p5.a(d2);
            p5.a(d5);
            this.b.add(p5);
            array[0] = p5;
            a2.b();
            continue;
        }
    }
    
    private static p a(final p p2, final p p3) {
        return (p2.a().k() > p3.a().k()) ? p2 : p3;
    }
    
    public void a(final d d, final d d2) {
        final boolean d3 = N.d;
        if (d == null && d2.c().a() > 2) {
            d d4 = null;
            final e l = d2.c().l();
            while (l.f()) {
                final d a = l.a();
                if (d3) {
                    return;
                }
                if (d2 != a) {
                    if (d4 == null) {
                        d4 = a;
                    }
                    if (this.i(a).a().k() == 1) {
                        d4 = a;
                    }
                }
                l.g();
                if (d3) {
                    break;
                }
            }
            this.a(d4, d2);
            return;
        }
        final p p2 = new p();
        final d g = this.g(d2);
        p2.a(g);
        this.b.add(p2);
        this.f(g).a(p2);
        if (d != null) {
            final p i = this.i(d);
            i.a(d, d2, d);
            this.f(d2).a(i);
            this.a(d2, new p[] { i }, new p[] { p2, i });
            if (!d3) {
                return;
            }
        }
        final p p3 = new p();
        this.b.add(p3);
        this.f(d2).a(p3);
        p3.a(d2);
        this.a(d2, new p[0], new p[] { p2, p3 });
    }
    
    public p a(final d d, final d d2, final d d3) {
        final boolean d4 = N.d;
        final p p3 = new p();
        p p4 = null;
        p p5 = null;
        final q c = d.c();
        final q d5 = d.d();
        final d g = this.g(d);
        d a14 = null;
        Label_0932: {
            Label_0906: {
                d f = null;
                d a6 = null;
                d d8 = null;
                Label_0560: {
                    d d7 = null;
                    Label_0537: {
                        Label_0536: {
                            if (d2 != null) {
                                p3.a(g);
                                this.f(g).a(p3);
                                p4 = this.i(d2);
                                this.b.remove(p4);
                                final e a = p4.a();
                                while (true) {
                                    while (a.f()) {
                                        final d a2 = a.a();
                                        d d6 = d2;
                                        if (!d4) {
                                            if (a2 == d2) {
                                                break;
                                            }
                                            a.b();
                                            if (d4) {
                                                break;
                                            }
                                            continue;
                                        }
                                        else {
                                            while (true) {
                                                if (a2 != d6) {
                                                    final d a3 = a.a();
                                                    p3.a(a3);
                                                    this.f(a3).a(p3);
                                                    a.b();
                                                    if (!d4) {
                                                        if (a.f()) {
                                                            final d a4;
                                                            d7 = (a4 = a.a());
                                                            if (!d4) {
                                                                d6 = d2;
                                                                continue;
                                                            }
                                                            break Label_0537;
                                                        }
                                                    }
                                                }
                                                break;
                                            }
                                            p3.a(d2);
                                            this.f(d2).a(p3);
                                            p3.a(d);
                                            this.f(d).a(p3);
                                            if (this.i() == p4) {
                                                this.b(p3);
                                            }
                                            break Label_0536;
                                        }
                                    }
                                    a.b();
                                    continue;
                                }
                            }
                            if (c.a() == 2) {
                                p3.a(g);
                                this.f(g).a(p3);
                                p3.a(d);
                                this.f(d).a(p3);
                                if (!d4) {
                                    break Label_0536;
                                }
                            }
                            p3.a(g);
                            this.f(g).a(p3);
                            f = c.f();
                            if (f == d) {
                                throw new RuntimeException("Bridge Face failed !");
                            }
                            p4 = this.i(f);
                            this.b.remove(p4);
                            final e a5 = p4.a();
                            while (a5.f()) {
                                a6 = a5.a();
                                d8 = f;
                                if (d4) {
                                    break Label_0560;
                                }
                                if (a6 == d8) {
                                    break;
                                }
                                a5.b();
                                if (d4) {
                                    break;
                                }
                            }
                            final d a7 = a5.a();
                            p3.a(a7);
                            this.f(a7).a(p3);
                            a5.b();
                            while (a5.f()) {
                                final d a8 = a5.a();
                                final d d9 = a7;
                                if (d4) {
                                    break Label_0560;
                                }
                                if (a8 == d9) {
                                    break;
                                }
                                p3.a(a5.a());
                                this.f(a5.a()).a(p3);
                                a5.b();
                                if (d4) {
                                    break;
                                }
                            }
                            p3.a(d);
                            this.f(d).a(p3);
                            if (this.i() == p4) {
                                this.b(p3);
                            }
                        }
                        d7 = d3;
                    }
                    if (d7 != null) {
                        p5 = this.i(d3);
                        this.b.remove(p5);
                        final e a9 = p5.a();
                        while (true) {
                            while (a9.f()) {
                                final d a10 = a9.a();
                                d d10 = d3;
                                if (d4) {
                                    while (true) {
                                        if (a10 != d10) {
                                            final d a11 = a9.a();
                                            p3.a(a11);
                                            this.f(a11).a(p3);
                                            a9.b();
                                            if (!d4) {
                                                if (a9.f()) {
                                                    a9.a();
                                                    if (!d4) {
                                                        d10 = d3;
                                                        continue;
                                                    }
                                                    break Label_0932;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    p3.a(d3);
                                    this.f(d3).a(p3);
                                    break Label_0906;
                                }
                                if (a10 == d3) {
                                    break;
                                }
                                a9.b();
                                if (d4) {
                                    break;
                                }
                            }
                            a9.b();
                            continue;
                        }
                    }
                    if (d5.a() == 2) {
                        break Label_0906;
                    }
                    final d f2;
                    f = (f2 = d5.f());
                }
                if (a6 == d8) {
                    throw new RuntimeException("Error in bridge Face !");
                }
                p5 = this.i(f);
                this.b.remove(p5);
                final e a12 = p5.a();
                while (true) {
                    while (a12.f()) {
                        final d a13 = a12.a();
                        if (!d4) {
                            if (a13 == f) {
                                break;
                            }
                            a12.b();
                            if (d4) {
                                break;
                            }
                            continue;
                        }
                        else {
                            final d d11 = a13;
                            p3.a(d11);
                            this.f(d11).a(p3);
                            a12.b();
                            while (a12.f()) {
                                a14 = a12.a();
                                if (d4) {
                                    break Label_0932;
                                }
                                if (a14 == d11) {
                                    break;
                                }
                                p3.a(a12.a());
                                this.f(a12.a()).a(p3);
                                a12.b();
                                if (d4) {
                                    break;
                                }
                            }
                            if (this.i() == p5) {
                                this.b(p3);
                            }
                            break Label_0906;
                        }
                    }
                    a12.a();
                    continue;
                }
            }
            this.b.add(p3);
            if (this.i() == p5) {
                this.b(p3);
            }
        }
        if (a14 != null) {
            this.a.a(d, this.h(d2), null, 0, 1);
        }
        if (d3 != null) {
            this.a.a(this.h(d), this.h(d3), null, 0, 1);
        }
        final p[] array = { p3 };
        final ArrayList<Object> list = new ArrayList<Object>(2);
        if (p4 != null) {
            list.add(p4);
        }
        if (p5 != null) {
            list.add(p5);
        }
        final p[] array2 = new p[list.size()];
        list.toArray(array2);
        if (this.f(d).f()) {
            final y.c.p d12 = this.g.d(d);
            if (d12 != null) {
                this.g.h(d12);
            }
        }
        this.a(d, array2, array);
        return p3;
    }
    
    public void a(final d d) {
        final boolean d2 = N.d;
        final d h = this.h(d);
        p[] array = null;
        p[] array2 = null;
        Label_0662: {
            Label_0313: {
                if (this.i(d) != this.i(h)) {
                    final p i = this.i(d);
                    final p j = this.i(h);
                    final p p = new p();
                    array = new p[2];
                    array2 = new p[] { null };
                    array[0] = i;
                    array[1] = j;
                    array2[0] = p;
                    final e a = i.a();
                    final e a2 = j.a();
                    this.b.remove(i);
                    this.b.remove(j);
                    while (true) {
                        while (a.f()) {
                            final d a3 = a.a();
                            if (!d2) {
                                Label_0259: {
                                    Label_0252: {
                                        if (a3 != d) {
                                            p.a(a3);
                                            this.f(a3).a(p);
                                            if (!d2) {
                                                break Label_0252;
                                            }
                                        }
                                        while (true) {
                                            while (a2.a() != h) {
                                                a2.b();
                                                if (d2) {
                                                    while (a2.a() != h) {
                                                        p.a(a2.a());
                                                        this.f(a2.a()).a(p);
                                                        a2.b();
                                                        if (d2) {
                                                            break Label_0259;
                                                        }
                                                        if (d2) {
                                                            break;
                                                        }
                                                    }
                                                    break Label_0252;
                                                }
                                                if (d2) {
                                                    break;
                                                }
                                            }
                                            a2.b();
                                            continue;
                                        }
                                    }
                                    a.g();
                                }
                                if (d2) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (i != this.i() && j != this.i()) {
                                    break Label_0662;
                                }
                                this.b(p);
                                if (d2) {
                                    break Label_0313;
                                }
                                break Label_0662;
                            }
                        }
                        this.p(d);
                        this.p(h);
                        this.b.add(p);
                        continue;
                    }
                }
            }
            final p k = this.i(d);
            final p p2 = new p();
            final p p3 = new p();
            array = new p[] { null };
            array2 = new p[] { p2, p3 };
            array[0] = k;
            this.b.remove(k);
            final e a4 = k.a();
            while (true) {
            Label_0481_Outer:
                while (a4.a() != d) {
                    a4.b();
                    if (d2) {
                        while (true) {
                            while (a4.a() != h) {
                                p2.a(a4.a());
                                this.f(a4.a()).a(p2);
                                a4.b();
                                if (!d2) {
                                    if (d2) {
                                        break;
                                    }
                                    continue Label_0481_Outer;
                                }
                                else {
                                    while (true) {
                                        while (a4.a() != d) {
                                            p3.a(a4.a());
                                            this.f(a4.a()).a(p3);
                                            a4.b();
                                            if (d2) {
                                                if (p3.a().k() > 0) {
                                                    if (k == this.i()) {
                                                        this.b(p3);
                                                    }
                                                    this.b.add(p3);
                                                }
                                                if (p2.a().k() == 0 && p3.a().k() == 0) {
                                                    this.b(this.h().a());
                                                }
                                                this.p(d);
                                                this.p(h);
                                                break Label_0662;
                                            }
                                            if (d2) {
                                                break;
                                            }
                                        }
                                        if (p2.a().k() > 0) {
                                            if (k == this.i()) {
                                                this.b(p2);
                                            }
                                            this.b.add(p2);
                                        }
                                        continue;
                                    }
                                }
                            }
                            a4.b();
                            continue;
                        }
                    }
                    if (d2) {
                        break;
                    }
                }
                a4.b();
                continue;
            }
        }
        this.b(d, array, array2);
    }
    
    public void a(final d d, final q q, final p p3) {
        final d g = this.g(d);
        Label_0038: {
            if (d.d().equals(q)) {
                p3.a(d, g);
                if (!N.d) {
                    break Label_0038;
                }
            }
            p3.a(g, d);
        }
        this.f(d).a(p3);
        this.f(g).a(p3);
    }
    
    public q b(final d d) {
        final d h = this.h(d);
        final q c = d.c();
        final q d2 = d.d();
        final q d3 = this.a.d();
        this.d(d3);
        final d a = this.a.a(c, d, d3, null, 1, 0);
        this.f(a).c(false);
        final d a2 = this.a.a(d3, null, d2, d, 0, 1);
        this.f(a2).c(false);
        final d a3 = this.a.a(d2, h, d3, null, 1, 0);
        this.f(a3).c(true);
        final d a4 = this.a.a(d3, null, c, h, 0, 1);
        this.f(a4).c(true);
        final f f = new f();
        f.add(a);
        f.add(a2);
        this.a(d, f, 0);
        final p i = this.i(d);
        final p j = this.i(h);
        this.f(a).a(i);
        this.f(a2).a(i);
        this.f(a3).a(j);
        this.f(a4).a(j);
        i.a(d, a, a2);
        j.a(h, a3, a4);
        this.b(a, a4);
        this.b(a2, a3);
        this.a(d, f.e());
        this.p(d);
        this.p(h);
        return d3;
    }
    
    public f a(final d d, final int n) {
        final boolean d2 = N.d;
        final d h = this.h(d);
        final q c = d.c();
        final q d3 = d.d();
        final p i = this.i(d);
        final p j = this.i(h);
        final q[] array = new q[n];
        final q[] array2 = new q[n + 2];
        final boolean n2 = this.n(d);
        array2[0] = c;
        array2[n + 1] = d3;
        int k = 0;
        while (k < n) {
            array2[k + 1] = (array[k] = this.a.d());
            this.d(array[k]);
            ++k;
            if (d2) {
                break;
            }
        }
        final f f = new f();
        final f f2 = new f();
        final d a = this.a.a(c, d, array[0], null, 1, 0);
        f.b(a);
        final d a2 = this.a.a(array[0], null, c, h, 0, 1);
        f2.a(a2);
        this.b(a, a2);
        int l = 1;
        while (true) {
            while (l < n) {
                final d a3 = this.a.a(array2[l], array2[l + 1]);
                final d a4 = this.a.a(array2[l + 1], array2[l]);
                f.b(a3);
                f2.a(a4);
                final D d4 = this;
                if (d2) {
                    final d a5 = d4.a.a(array[n - 1], null, d3, d, 0, 1);
                    f.b(a5);
                    final d a6 = this.a.a(d3, h, array[n - 1], null, 1, 0);
                    f2.a(a6);
                    this.b(a5, a6);
                    Label_0382: {
                        if (n2) {
                            this.a(h, f2, 0);
                            if (!d2) {
                                break Label_0382;
                            }
                        }
                        this.a(d, f, 0);
                    }
                    this.a(d, f.e());
                    this.p(d);
                    this.p(h);
                    e e = f.a();
                    while (true) {
                        while (e.f()) {
                            final d a7 = e.a();
                            this.f(a7).a(i);
                            this.f(a7).c(n2);
                            e.g();
                            if (d2) {
                                while (e.f()) {
                                    final d a8 = e.a();
                                    this.f(a8).a(j);
                                    if (d2) {
                                        return f;
                                    }
                                    this.f(a8).c(!n2);
                                    e.g();
                                    if (d2) {
                                        break;
                                    }
                                }
                                i.a(d, f);
                                j.a(h, f2);
                                return f;
                            }
                            if (d2) {
                                break;
                            }
                        }
                        e = f2.a();
                        continue;
                    }
                }
                this.b(a3, a4);
                ++l;
                if (d2) {
                    break;
                }
            }
            final D d4 = this;
            continue;
        }
    }
    
    public d h(final q q) {
        final boolean d = N.d;
        final f f = new f();
        if (q.b() != 2 || q.c() != 2) {
            throw new RuntimeException("Node is not a crossing");
        }
        final e k = q.k();
        final d a = k.a();
        k.g();
        final d a2 = k.a();
        final e l = q.l();
        final d a3 = l.a();
        l.g();
        final d a4 = l.a();
        d d2 = null;
        d d3 = null;
        Label_0131: {
            if (this.n(a)) {
                d2 = a2;
                d3 = a;
                if (!d) {
                    break Label_0131;
                }
            }
            d2 = a;
            d3 = a2;
        }
        d d4 = null;
        d d5 = null;
        Label_0158: {
            if (a3 == this.h(d2)) {
                d4 = a4;
                d5 = a3;
                if (!d) {
                    break Label_0158;
                }
            }
            d4 = a3;
            d5 = a4;
        }
        final d d6 = (d)this.f.b(d2);
        d a5 = null;
        Label_0234: {
            if (d2.c() == d6.c() && d4.d() == d6.d()) {
                this.q(d6);
                a5 = d6;
                if (!d) {
                    break Label_0234;
                }
            }
            a5 = this.a.a(d2.c(), d4.d());
        }
        final d g = this.g(a5);
        if (d3.c() != g.c() || d5.d() != g.d()) {
            throw new RuntimeException("Reverse Edge Restauration failed!");
        }
        final p i = this.i(d2);
        i.b(d2, d4, a5);
        this.f(a5).a(i);
        final p j = this.i(d3);
        j.b(d3, d5, g);
        this.f(g).a(j);
        this.j(q);
        f.a(d4);
        f.a(d2);
        this.a(a5, f, 1);
        this.a(f.e(), a5);
        return a5;
    }
    
    public void a(final Q q) {
        this.i.add(q);
    }
    
    public void b(final Q q) {
        final int index = this.i.indexOf(q);
        if (index >= 0) {
            this.i.remove(index);
        }
    }
    
    protected void a(final d d, final d[] array) {
        final boolean d2 = N.d;
        int i = 0;
        while (i < this.i.size()) {
            ((Q)this.i.get(i)).a(d, array);
            ++i;
            if (d2) {
                break;
            }
        }
    }
    
    protected void a(final d[] array, final d d) {
        final boolean d2 = N.d;
        int i = 0;
        while (i < this.i.size()) {
            ((Q)this.i.get(i)).a(array, d);
            ++i;
            if (d2) {
                break;
            }
        }
    }
    
    protected void a(final d d, final p[] array, final p[] array2) {
        final boolean d2 = N.d;
        int i = 0;
        while (i < this.i.size()) {
            ((Q)this.i.get(i)).a(d, array, array2);
            ++i;
            if (d2) {
                break;
            }
        }
    }
    
    protected void b(final d d, final p[] array, final p[] array2) {
        final boolean d2 = N.d;
        int i = 0;
        while (i < this.i.size()) {
            ((Q)this.i.get(i)).b(d, array, array2);
            ++i;
            if (d2) {
                break;
            }
        }
    }
    
    public e c(final d d) {
        if (this.g.d(d) == null) {
            final f f = new f();
            f.add(d);
            return f.a();
        }
        return ((f)this.e.b(d)).a();
    }
    
    public d d(final d d) {
        d d2 = (d)this.f.b(d);
        if (d2 == null) {
            d2 = d;
        }
        return d2;
    }
    
    public void a(final d d, final f f, final int n) {
        final boolean d2 = N.d;
        Label_0291: {
            if (n == 0) {
                Label_0116: {
                    if (this.f(d).f()) {
                        if (this.g.d(d) == null) {
                            this.g.add(d);
                        }
                        this.e.a(d, f);
                        final e a = f.a();
                        while (a.f()) {
                            final d a2 = a.a();
                            this.f.a(a2, d);
                            this.e.a(a2, f);
                            a.g();
                            if (d2) {
                                break Label_0116;
                            }
                        }
                        return;
                    }
                }
                final f f2 = (f)this.e.b(d);
                final y.c.p d3 = f2.d(d);
                final d d4 = (d)this.f.b(d3.c());
                y.c.p c = d3;
                final e a3 = f.a();
                while (true) {
                    while (a3.f()) {
                        final d a4 = a3.a();
                        this.f.a(a4, d4);
                        f2.b(a4, c);
                        c = f2.c(c);
                        a3.g();
                        if (d2) {
                            final e a5 = f2.a();
                            while (a5.f()) {
                                this.e.a(a5.a(), f2);
                                a5.g();
                                if (d2) {
                                    break Label_0291;
                                }
                            }
                            return;
                        }
                        if (d2) {
                            break;
                        }
                    }
                    f2.h(d3);
                    continue;
                }
            }
        }
        if (n == 1) {
            final e a6 = f.a();
            this.e.a(d, this.e.b(a6.a()));
            this.f.a(d, this.f.b(a6.a()));
            final f f3 = (f)this.e.b(d);
            y.c.p d5 = f3.d(a6.a());
            f3.a(d, d5);
            while (a6.f()) {
                if (a6.a() == f3.g(d5)) {
                    final y.c.p c2 = f3.c(d5);
                    f3.h(d5);
                    d5 = c2;
                    if (!d2) {
                        a6.g();
                        if (d2) {
                            break;
                        }
                        continue;
                    }
                }
                throw new RuntimeException("WRONG SEGMENTS IN EDGE RECOVERY");
            }
            if (f3.size() != 1) {
                return;
            }
            this.g.remove(d);
            this.e(d);
            if (!d2) {
                return;
            }
        }
        throw new RuntimeException("UNSPECIFIED EDGE RECOVERY");
    }
    
    public void b() {
        final boolean d = N.d;
        final X x = (X)this.a;
        final y.c.D d2 = new y.c.D();
        final e a = this.g.a();
        while (true) {
            do {
                Label_0029: {
                    a.f();
                }
                boolean e = false;
                Label_0035:
                while (e) {
                    d2.clear();
                    final d a2 = a.a();
                    this.q(a2);
                    final e a3 = ((f)this.e.b(a2)).a();
                    if (!d) {
                        if (a3 != null && a3.f()) {
                            while (a3.f()) {
                                d2.a(x.k(a3.a()));
                                e = this.e(a3.a().d());
                                if (d) {
                                    continue Label_0035;
                                }
                                if (e) {
                                    d2.add(x.l(a3.a().d()));
                                }
                                a3.g();
                                if (d) {
                                    break;
                                }
                            }
                            x.b(a2, d2);
                            a3.i();
                            x.a(a2, x.n(a3.a()));
                            a3.j();
                            x.b(a2, x.o(a3.a()));
                        }
                        this.e.a(a.a(), null);
                        a.g();
                        continue Label_0029;
                    }
                    final x o = this.a.o();
                    while (o.f()) {
                        if (this.b(o.e()) || this.e(o.e())) {
                            this.j(o.e());
                        }
                        o.g();
                        if (d) {
                            break;
                        }
                    }
                    return;
                }
                break;
            } while (!d);
            this.g.clear();
            continue;
        }
    }
    
    public void e(final d d) {
        this.f(d).b(true);
    }
    
    protected F i(final q q) {
        F c = (F)this.h.b(q);
        if (c == null) {
            c = this.c();
            this.h.a(q, c);
        }
        return c;
    }
    
    protected F c() {
        return new F();
    }
    
    protected E f(final d d) {
        return (E)this.o(d);
    }
    
    protected E d() {
        return new E();
    }
    
    protected P d_() {
        return this.d();
    }
    
    private void p(final d d) {
        if (this.f(d).f()) {
            this.a.d(d);
            if (!N.d) {
                return;
            }
        }
        this.a.a(d);
    }
    
    private void q(final d d) {
        if (this.f(d).f()) {
            this.a.e(d);
            if (!N.d) {
                return;
            }
        }
        throw new RuntimeException("Tried to reinsert non-original edge !");
    }
    
    private void j(final q q) {
        final boolean d = N.d;
        final e j = q.j();
        while (j.f()) {
            this.p(j.a());
            j.g();
            if (d) {
                return;
            }
            if (d) {
                break;
            }
        }
        this.a.a(q);
    }
}
