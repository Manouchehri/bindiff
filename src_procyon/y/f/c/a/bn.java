package y.f.c.a;

import y.f.b.*;
import y.f.*;
import y.g.*;
import y.c.*;
import java.util.*;

public class bn extends a
{
    private static final Object a;
    private HashMap b;
    private c c;
    private HashMap d;
    private D e;
    private l f;
    private c g;
    private c h;
    private byte i;
    private boolean n;
    private HashMap o;
    private HashMap p;
    
    public bn() {
        this.i = 0;
        this.n = false;
    }
    
    public void c(final X x) {
        final boolean x2 = N.x;
        final bk c = bk.c(x);
        if (c == null) {
            this.a().c(x);
            if (!x2) {
                return;
            }
        }
        this.g = x.c(bk.a);
        this.h = x.c(bk.b);
        if (!x.i()) {
            if (c.a()) {
                c.f(x);
            }
            if (c.b()) {
                c.e(x);
            }
            if (this.b(x)) {
                x.a(bk.b, new bo(this, x.c(y.f.b.f.d), c.a(0, 0)));
            }
        }
        final bk a = this.a(x, c);
        final c c2 = x.c(y.f.b.f.c);
        final y f = this.f(x);
        final I i = new I(x);
        i.a(f);
        Label_0205: {
            if (x.f() > 0) {
                this.a(a, x);
                this.a().c(x);
                this.e(x);
                if (!x2) {
                    break Label_0205;
                }
            }
            this.a(a);
        }
        i.f();
        final c c3 = x.c(bk.b);
        x x3 = f.a();
    Label_0226:
        while (true) {
        Label_0435_Outer:
            while (x3.f()) {
                final q e = x3.e();
                final bh bh = (bh)c3.b(e);
                double min = Double.MAX_VALUE;
                double min2 = Double.MAX_VALUE;
                double max = -1.7976931348623157E308;
                double max2 = -1.7976931348623157E308;
                if (!x2) {
                    while (true) {
                        for (final bj bj : bh.a()) {
                            final l b = bj.b;
                            min = Math.min(min, b.h());
                            max = Math.max(max, b.h() + b.e());
                            final bt a2 = bj.a;
                            min2 = Math.min(min2, a2.h());
                            max2 = Math.max(max2, a2.h() + a2.e());
                            if (!x2) {
                                if (x2) {
                                    break;
                                }
                                continue Label_0435_Outer;
                            }
                            else {
                                if (x2) {
                                    break Label_0435_Outer;
                                }
                                continue Label_0226;
                            }
                        }
                        x.b(e, max - min, max2 - min2);
                        x.c(e, min, min2);
                        x3.g();
                        continue;
                    }
                }
            Label_0514_Outer:
                while (x3.f()) {
                    final e j = x3.e().j();
                    while (true) {
                        while (j.f()) {
                            ae.a(x, j.a());
                            j.g();
                            if (!x2) {
                                if (x2) {
                                    break;
                                }
                                continue Label_0514_Outer;
                            }
                            else {
                                if (x2) {
                                    break Label_0514_Outer;
                                }
                                continue Label_0447;
                            }
                        }
                        x3.g();
                        continue;
                    }
                }
                this.d(x);
                if (c2 != null) {
                    x.a(y.f.b.f.c, c2);
                }
                x.a(bk.b, this.h);
                x.a(bk.a, this.g);
                return;
            }
            x3 = f.a();
            continue;
        }
    }
    
    private boolean b(final X x) {
        final boolean x2 = N.x;
        final c c = x.c(bk.b);
        if (c == null) {
            return true;
        }
        final x o = x.o();
        while (o.f()) {
            final bh bh = (bh)c.b(o.e());
            if (bh != null && !bh.b()) {
                return false;
            }
            o.g();
            if (x2) {
                break;
            }
        }
        return true;
    }
    
    private void d(final X x) {
        final boolean x2 = N.x;
        final bk bk = (bk)this.g.b(x);
        Label_0205: {
            if (this.i == 0) {
                C c = bk.f().m();
                while (true) {
                    while (c.f()) {
                        final l l = (l)c.d();
                        final l i = this.p.get(l);
                        final boolean n = this.n;
                        if (!x2) {
                            Label_0111: {
                                if (n) {
                                    l.g(i.h() + i.e());
                                    if (!x2) {
                                        break Label_0111;
                                    }
                                }
                                l.g(i.h());
                            }
                            l.d(i.e());
                            c.g();
                            if (x2) {
                                break;
                            }
                            continue;
                        }
                        else {
                            while (true) {
                                if (!n) {
                                    return;
                                }
                                final bt bt = (bt)c.d();
                                final bt bt2 = this.o.get(bt);
                                bt.g(bt2.h());
                                bt.d(bt2.e());
                                c.g();
                                if (x2) {
                                    break Label_0205;
                                }
                                c.f();
                                continue;
                            }
                        }
                    }
                    c = bk.e().m();
                    continue;
                }
            }
        }
        Label_0392: {
            if (this.i == 1) {
                C c2 = bk.f().m();
                while (true) {
                    while (c2.f()) {
                        final l j = (l)c2.d();
                        final bt bt3 = this.p.get(j);
                        j.g(bt3.h());
                        j.d(bt3.e());
                        c2.g();
                        if (x2) {
                            while (c2.f()) {
                                final bt bt4 = (bt)c2.d();
                                final l k = this.o.get(bt4);
                                Label_0371: {
                                    if (this.n) {
                                        bt4.g(k.h());
                                        if (!x2) {
                                            break Label_0371;
                                        }
                                    }
                                    bt4.g(k.h() + k.e());
                                }
                                bt4.d(k.e());
                                c2.g();
                                if (x2) {
                                    break Label_0392;
                                }
                            }
                            return;
                        }
                        if (x2) {
                            break;
                        }
                    }
                    c2 = bk.e().m();
                    continue;
                }
            }
        }
        Label_0585: {
            if (this.i == 3) {
                C c3 = bk.f().m();
                while (true) {
                    while (c3.f()) {
                        final l m = (l)c3.d();
                        final bt bt5 = this.p.get(m);
                        m.g(bt5.h() + bt5.e());
                        m.d(bt5.e());
                        c3.g();
                        if (x2) {
                            while (c3.f()) {
                                final bt bt6 = (bt)c3.d();
                                final l l2 = this.o.get(bt6);
                                Label_0564: {
                                    if (this.n) {
                                        bt6.g(l2.h() + l2.e());
                                        if (!x2) {
                                            break Label_0564;
                                        }
                                    }
                                    bt6.g(l2.h());
                                }
                                bt6.d(l2.e());
                                c3.g();
                                if (x2) {
                                    break Label_0585;
                                }
                            }
                            return;
                        }
                        if (x2) {
                            break;
                        }
                    }
                    c3 = bk.e().m();
                    continue;
                }
            }
        }
        if (this.i == 2) {
            C c4 = bk.f().m();
            while (true) {
                while (c4.f()) {
                    final l l3 = (l)c4.d();
                    final l l4 = this.p.get(l3);
                    final boolean n2 = this.n;
                    if (!x2) {
                        Label_0678: {
                            if (n2) {
                                l3.g(l4.h());
                                if (!x2) {
                                    break Label_0678;
                                }
                            }
                            l3.g(l4.h() + l4.e());
                        }
                        l3.d(l4.e());
                        c4.g();
                        if (x2) {
                            break;
                        }
                        continue;
                    }
                    else {
                        while (true) {
                            if (!n2) {
                                return;
                            }
                            final bt bt7 = (bt)c4.d();
                            final bt bt8 = this.o.get(bt7);
                            bt7.g(bt8.h() + bt8.e());
                            bt7.d(bt8.e());
                            c4.g();
                            if (x2) {
                                return;
                            }
                            c4.f();
                            continue;
                        }
                    }
                }
                c4 = bk.e().m();
                continue;
            }
        }
    }
    
    private void e(final X x) {
        final boolean x2 = N.x;
        final bk c = bk.c(x);
        if (c == null) {
            return;
        }
        x.d_(bn.a);
        if (this.c != null) {
            x.a(bn.a, this.c);
        }
        final D f = c.f();
        if (f != null) {
            while (true) {
                for (final l l : f) {
                    final bK bk = this.b.get(l);
                    if (bk != null) {
                        double h = bk.h();
                        double n = 0.0;
                        final D d2;
                        final D d = d2 = this.d.get(bk);
                        if (!x2) {
                            Label_0233: {
                                if (d2 != null) {
                                    final C m = d.m();
                                    while (m.f()) {
                                        final l i = (l)m.d();
                                        i.g(h);
                                        i.d(i.b());
                                        n += i.e();
                                        h += i.e();
                                        m.g();
                                        if (x2) {
                                            break Label_0233;
                                        }
                                        if (x2) {
                                            break;
                                        }
                                    }
                                }
                                l.g(h);
                                l.d(bk.i() - n);
                            }
                            if (x2) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (d2 != null) {
                                double n2 = this.f.h() + this.f.e();
                                this.e.n();
                                final C j = this.e.m();
                                while (j.f()) {
                                    final l k = (l)j.d();
                                    n2 -= k.b();
                                    k.g(n2);
                                    k.d(k.b());
                                    j.g();
                                    if (x2) {
                                        return;
                                    }
                                    if (x2) {
                                        break;
                                    }
                                }
                                this.f.d(n2 - this.f.h());
                            }
                            return;
                        }
                    }
                }
                final D e = this.e;
                continue;
            }
        }
    }
    
    private void a(final bk bk) {
        final boolean x = N.x;
        double n = 0.0;
        int i = 0;
        while (true) {
            while (i < bk.f().size()) {
                final l b = bk.b(i);
                b.g(n);
                b.d(b.b());
                final double n2 = n + b.e();
                if (x) {
                    double n3 = n2;
                    int j = 0;
                    while (j < bk.e().size()) {
                        final bt a = bk.a(j);
                        a.g(n3);
                        a.d(a.b());
                        n3 += a.e();
                        ++j;
                        if (x) {
                            break;
                        }
                    }
                    return;
                }
                n = n2;
                ++i;
                if (x) {
                    break;
                }
            }
            continue;
        }
    }
    
    private y f(final X x) {
        final boolean x2 = N.x;
        final y y = new y();
        if (y.f.b.c.b(x)) {
            final c c = x.c(y.f.b.f.b);
            final y.f.b.c c2 = new y.f.b.c(x);
            final c c3 = x.c(bk.b);
            if (c3 != null) {
                final A a = M.a();
                final x o = x.o();
                do {
                    Label_0063: {
                        o.f();
                    }
                    boolean b = false;
                    Label_0070:
                    while (b) {
                        final q e = o.e();
                        final bh bh = (bh)c3.b(e);
                        if (!x2) {
                            Label_0236: {
                                if (bh == null || !bh.b()) {
                                    q q = c2.a(e);
                                    bh bh2 = (bh)c3.b(q);
                                    while (bh2 != null) {
                                        b = bh2.b();
                                        if (x2) {
                                            continue Label_0070;
                                        }
                                        if (!b) {
                                            break;
                                        }
                                        q = c2.a(q);
                                        bh2 = (bh)c3.b(q);
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    a.a(e, (c != null && c.b(q) != null) ? c.b(q) : q);
                                    if (!x2) {
                                        break Label_0236;
                                    }
                                }
                                y.add(e);
                            }
                            o.g();
                            continue Label_0063;
                        }
                        return y;
                    }
                    break;
                } while (!x2);
                x.a(y.f.b.f.c, a);
            }
        }
        return y;
    }
    
    private void a(final bk bk, final X x) {
        final boolean x2 = N.x;
        this.b = new HashMap();
        this.d = new HashMap();
        final bp bp = new bp();
        this.e = null;
        final HashSet set = new HashSet<l>();
        set.add(null);
        final c c = x.c(bk.b);
        final x o = x.o();
        while (o.f()) {
            final bh bh = (bh)c.b(o.e());
            if (bh != null && !bh.b()) {
                set.add(bh.d());
            }
            o.g();
            if (x2) {
                break;
            }
        }
        final D f = bk.f();
        if (f != null && !f.isEmpty()) {
            y.g.e.a(f, null);
            final Iterator iterator = f.iterator();
        Label_0278_Outer:
            while (iterator.hasNext()) {
                final D e = new D();
                double n = 0.0;
                if (!x2) {
                    l f2 = iterator.next();
                    while (true) {
                        while (!set.contains(f2)) {
                            n += f2.b();
                            e.add(f2);
                            final boolean hasNext = iterator.hasNext();
                            if (!x2) {
                                if (!hasNext) {
                                    break;
                                }
                                f2 = iterator.next();
                                if (x2) {
                                    break;
                                }
                                continue Label_0278_Outer;
                            }
                            else {
                                if (hasNext) {
                                    final bK a = bp.a(f2);
                                    a.c(a.f() + n);
                                    a.b(a.e() + n);
                                    this.d.put(a, e);
                                    this.b.put(f2, a);
                                    this.f = f2;
                                    if (!x2) {
                                        continue Label_0278_Outer;
                                    }
                                }
                                this.e = e;
                                final bK bk2 = this.b.get(this.f);
                                bk2.d(bk2.g() + n);
                                bk2.b(bk2.e() + n);
                                if (x2) {
                                    break Label_0278_Outer;
                                }
                                continue Label_0278_Outer;
                            }
                        }
                        set.contains(f2);
                        continue;
                    }
                }
                return;
            }
            final A a2 = M.a();
            final x o2 = x.o();
            while (true) {
                while (o2.f()) {
                    final q e2 = o2.e();
                    final bh bh2 = (bh)c.b(e2);
                    if (x2) {
                        x.a(bn.a, a2);
                        return;
                    }
                    if (bh2 != null && !bh2.b()) {
                        a2.a(e2, this.b.get(bh2.d()));
                    }
                    o2.g();
                    if (x2) {
                        break;
                    }
                }
                this.c = x.c(bn.a);
                continue;
            }
        }
    }
    
    private bk a(final X x, final bk bk) {
        final boolean x2 = N.x;
        this.i = bk.a(x);
        this.n = bk.b(x);
        this.o = new HashMap();
        this.p = new HashMap();
        final c c = x.c(bk.b);
        bk bk2 = null;
        final A a = M.a();
        Label_2468: {
            if (this.i == 0) {
                final int n = bk.f().size() - 1;
                bk2 = new bk(bk.e().size(), bk.f().size());
                C c2 = bk.f().m();
                while (true) {
                    while (c2.f()) {
                        final l l = (l)c2.d();
                        final boolean n2 = this.n;
                        if (x2) {
                            while (true) {
                                if (n2) {
                                    final bt bt = (bt)c2.d();
                                    final bt a2 = bk2.a(bt.a());
                                    a2.a(bt.j());
                                    a2.a(bt.b());
                                    a2.b(bt.c());
                                    a2.c(bt.d());
                                    a2.h(bt.i());
                                    this.o.put(bt, a2);
                                    c2.g();
                                    if (x2) {
                                        return bk2;
                                    }
                                    if (!x2) {
                                        c2.f();
                                        continue;
                                    }
                                }
                                break;
                            }
                            final x o = x.o();
                            while (o.f()) {
                                final q e = o.e();
                                final bh bh = (bh)c.b(e);
                                if (x2) {
                                    return bk2;
                                }
                                Label_0644: {
                                    if (bh != null) {
                                        if (bh.b()) {
                                            final D d = new D();
                                            final D d2 = new D();
                                            for (final bj bj : bh.a()) {
                                                d2.add(this.o.get(bj.a));
                                                d.add(this.p.get(bj.b));
                                                if (x2) {
                                                    continue Label_0651;
                                                }
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                            a.a(e, bk2.a(d2, d));
                                            if (!x2) {
                                                break Label_0644;
                                            }
                                        }
                                        a.a(e, bk2.a((bt)this.o.get(bh.c()), (l)this.p.get(bh.d())));
                                    }
                                }
                                o.g();
                                Label_0651:;
                            }
                            break Label_2468;
                        }
                        l i = null;
                        Label_0217: {
                            if (n2) {
                                i = bk2.b(n - l.a());
                                i.c(l.c());
                                i.b(l.d());
                                if (!x2) {
                                    break Label_0217;
                                }
                            }
                            i = bk2.b(l.a());
                            i.c(l.d());
                            i.b(l.c());
                        }
                        i.a(l.j());
                        i.a(l.b());
                        i.h(l.i());
                        this.p.put(l, i);
                        c2.g();
                        if (x2) {
                            break;
                        }
                    }
                    c2 = bk.e().m();
                    continue;
                }
            }
            if (this.i == 1) {
                bk2 = new bk(bk.f().size(), bk.e().size());
                final C m = bk.f().m();
                while (m.f()) {
                    final l j = (l)m.d();
                    final bt a3 = bk2.a(j.a());
                    a3.a(j.j());
                    a3.a(j.b());
                    a3.b(j.c());
                    a3.c(j.d());
                    a3.h(j.i());
                    this.p.put(j, a3);
                    m.g();
                    if (x2) {
                        return bk2;
                    }
                    if (x2) {
                        break;
                    }
                }
                final int n3 = bk.e().size() - 1;
                final C k = bk.e().m();
                while (k.f()) {
                    final bt bt2 = (bt)k.d();
                    if (x2) {
                        return bk2;
                    }
                    l l2;
                    if (this.n) {
                        l2 = bk2.b(bt2.a());
                        l2.c(bt2.d());
                        l2.b(bt2.c());
                    }
                    else {
                        l2 = bk2.b(n3 - bt2.a());
                        l2.c(bt2.c());
                        l2.b(bt2.d());
                    }
                    l2.a(bt2.j());
                    l2.a(bt2.b());
                    l2.h(bt2.i());
                    this.o.put(bt2, l2);
                    k.g();
                    if (x2) {
                        break;
                    }
                }
                final x o2 = x.o();
                while (o2.f()) {
                    final q e2 = o2.e();
                    final bh bh2 = (bh)c.b(e2);
                    if (x2) {
                        return bk2;
                    }
                    Label_1239: {
                        if (bh2 != null) {
                            if (bh2.b()) {
                                final D d3 = new D();
                                final D d4 = new D();
                                for (final bj bj2 : bh2.a()) {
                                    d4.add(this.p.get(bj2.b));
                                    d3.add(this.o.get(bj2.a));
                                    if (x2) {
                                        continue Label_1246;
                                    }
                                    if (x2) {
                                        break;
                                    }
                                }
                                a.a(e2, bk2.a(d4, d3));
                                if (!x2) {
                                    break Label_1239;
                                }
                            }
                            a.a(e2, bk2.a((bt)this.p.get(bh2.d()), (l)this.o.get(bh2.c())));
                        }
                    }
                    o2.g();
                    Label_1246:;
                }
            }
            else if (this.i == 3) {
                bk2 = new bk(bk.f().size(), bk.e().size());
                final int n4 = bk.f().size() - 1;
                final C m2 = bk.f().m();
                while (m2.f()) {
                    final l l3 = (l)m2.d();
                    final bt a4 = bk2.a(n4 - l3.a());
                    a4.a(l3.j());
                    a4.a(l3.b());
                    a4.b(l3.d());
                    a4.c(l3.c());
                    a4.h(l3.i());
                    this.p.put(l3, a4);
                    m2.g();
                    if (x2) {
                        return bk2;
                    }
                    if (x2) {
                        break;
                    }
                }
                final int n5 = bk.e().size() - 1;
                final C m3 = bk.e().m();
                while (m3.f()) {
                    final bt bt3 = (bt)m3.d();
                    if (x2) {
                        return bk2;
                    }
                    l l4 = null;
                    Label_1542: {
                        if (this.n) {
                            l4 = bk2.b(n5 - bt3.a());
                            l4.c(bt3.c());
                            l4.b(bt3.d());
                            if (!x2) {
                                break Label_1542;
                            }
                        }
                        l4 = bk2.b(bt3.a());
                        l4.c(bt3.d());
                        l4.b(bt3.c());
                    }
                    l4.a(bt3.j());
                    l4.a(bt3.b());
                    l4.h(bt3.i());
                    this.o.put(bt3, l4);
                    m3.g();
                    if (x2) {
                        break;
                    }
                }
                final x o3 = x.o();
                while (o3.f()) {
                    final q e3 = o3.e();
                    final bh bh3 = (bh)c.b(e3);
                    if (x2) {
                        return bk2;
                    }
                    Label_1847: {
                        if (bh3 != null) {
                            if (bh3.b()) {
                                final D d5 = new D();
                                final D d6 = new D();
                                for (final bj bj3 : bh3.a()) {
                                    d6.add(this.p.get(bj3.b));
                                    d5.add(this.o.get(bj3.a));
                                    if (x2) {
                                        continue Label_1854;
                                    }
                                    if (x2) {
                                        break;
                                    }
                                }
                                a.a(e3, bk2.a(d6, d5));
                                if (!x2) {
                                    break Label_1847;
                                }
                            }
                            a.a(e3, bk2.a((bt)this.p.get(bh3.d()), (l)this.o.get(bh3.c())));
                        }
                    }
                    o3.g();
                    Label_1854:;
                }
            }
            else if (this.i == 2) {
                bk2 = new bk(bk.e().size(), bk.f().size());
                final int n6 = bk.f().size() - 1;
                final C m4 = bk.f().m();
                while (true) {
                    while (m4.f()) {
                        final l l5 = (l)m4.d();
                        final int n8;
                        final int n7 = n8 = (this.n ? 1 : 0);
                        if (x2) {
                            final int n9 = n8;
                            final C m5 = bk.e().m();
                            while (m5.f()) {
                                final bt bt4 = (bt)m5.d();
                                final bt a5 = bk2.a(n9 - bt4.a());
                                a5.a(bt4.j());
                                a5.a(bt4.b());
                                a5.b(bt4.d());
                                a5.c(bt4.c());
                                a5.h(bt4.i());
                                this.o.put(bt4, a5);
                                m5.g();
                                if (x2) {
                                    return bk2;
                                }
                                if (x2) {
                                    break;
                                }
                            }
                            final x o4 = x.o();
                            while (o4.f()) {
                                final q e4 = o4.e();
                                final bh bh4 = (bh)c.b(e4);
                                if (x2) {
                                    return bk2;
                                }
                                Label_2463: {
                                    Label_2456: {
                                        if (bh4 != null) {
                                            if (bh4.b()) {
                                                final D d7 = new D();
                                                final D d8 = new D();
                                                for (final bj bj4 : bh4.a()) {
                                                    d8.add(this.o.get(bj4.a));
                                                    d7.add(this.p.get(bj4.b));
                                                    if (x2) {
                                                        break Label_2463;
                                                    }
                                                    if (x2) {
                                                        break;
                                                    }
                                                }
                                                a.a(e4, bk2.a(d8, d7));
                                                if (!x2) {
                                                    break Label_2456;
                                                }
                                            }
                                            a.a(e4, bk2.a((bt)this.o.get(bh4.c()), (l)this.p.get(bh4.d())));
                                        }
                                    }
                                    o4.g();
                                }
                                if (x2) {
                                    break;
                                }
                            }
                            break Label_2468;
                        }
                        l l6;
                        if (n7 != 0) {
                            l6 = bk2.b(l5.a());
                            l6.c(l5.d());
                            l6.b(l5.c());
                        }
                        else {
                            l6 = bk2.b(n6 - l5.a());
                            l6.c(l5.c());
                            l6.b(l5.d());
                        }
                        l6.a(l5.j());
                        l6.a(l5.b());
                        l6.h(l5.i());
                        this.p.put(l5, l6);
                        m4.g();
                        if (x2) {
                            break;
                        }
                    }
                    int n8 = bk.e().size() - 1;
                    continue;
                }
            }
        }
        x.a(bk.b, a);
        x.a(bk.a, y.g.q.a(bk2));
        return bk2;
    }
    
    static c a(final bn bn) {
        return bn.h;
    }
    
    static {
        a = y.f.c.M.r;
    }
}
