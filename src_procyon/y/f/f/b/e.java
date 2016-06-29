package y.f.f.b;

import y.f.h.*;
import y.d.*;
import y.g.*;
import java.util.*;
import y.f.*;
import y.f.f.*;
import y.c.*;

public class e implements Q
{
    public static final Object a;
    protected h b;
    protected D c;
    protected X d;
    protected y.c.h e;
    protected A f;
    protected E g;
    protected y.c.h h;
    protected boolean i;
    protected int j;
    protected F k;
    protected List l;
    
    public e() {
        this.i = false;
        this.l = new ArrayList();
    }
    
    public void a(final D c, final c c2, final int j) {
        final int a = y.f.f.b.h.a;
        this.c = c;
        this.j = j;
        this.d = (X)c.g();
        this.e = this.d.u();
        this.f = this.d.t();
        this.g = null;
        this.d.a(y.f.f.b.e.a, this.f);
        final y.c.e p3 = this.d.p();
    Label_0202_Outer:
        while (p3.f()) {
            final d a2 = p3.a();
            final S[] array = (S[])c2.b(a2);
            if (a != 0) {
                return;
            }
            Label_0248: {
                if (array != null) {
                    final ArrayList list = new ArrayList<S>(array.length);
                    int i = 0;
                    while (true) {
                        while (i < array.length) {
                            list.add(array[i]);
                            ++i;
                            if (a == 0) {
                                if (a != 0) {
                                    break;
                                }
                                continue Label_0202_Outer;
                            }
                            else {
                                if (this.g != null) {
                                    break Label_0248;
                                }
                                final C[] d = this.d.d((Object)a2);
                                if (d != null && d.length > 0) {
                                    this.g = d[0].getLabelModel();
                                }
                                break Label_0248;
                            }
                        }
                        this.l.addAll(list);
                        y.g.e.a(list, new g());
                        this.e.a(a2, list);
                        continue;
                    }
                }
            }
            p3.g();
            if (a != 0) {
                break;
            }
        }
        c.a(this);
        this.k = new F();
    }
    
    public void a(final y.c.h h) {
        this.h = h;
    }
    
    public void a(final h b) {
        this.b = b;
    }
    
    public void a() {
        this.d.d_(y.f.f.b.e.a);
        this.d.a(this.e);
        this.d.a(this.f);
        this.c.b(this);
    }
    
    public void b() {
        final int a = y.f.f.b.h.a;
        this.i = true;
        final d[] n = this.d.n();
        int i = 0;
        while (true) {
            while (i < n.length) {
                final d d = n[i];
                final e e = this;
                if (a != 0) {
                    e.i = false;
                    return;
                }
                if (!this.c.n(d)) {
                    final ArrayList list = (ArrayList)this.e.b(d);
                    if (list != null) {
                        final int size = list.size();
                        if (size != 0) {
                            this.b.e(d, size);
                        }
                    }
                }
                ++i;
                if (a != 0) {
                    break;
                }
            }
            final e e = this;
            continue;
        }
    }
    
    private static y a(final y y, final t t) {
        final y y2 = new y(y.c() - 5.0, y.d() - 5.0, y.a() + 10.0, y.b() + 10.0);
        final double min = Math.min(y2.c(), t.a());
        final double min2 = Math.min(y2.d(), t.b());
        return new y(min, min2, Math.max(y2.c() + y2.a(), t.a()) - min, Math.max(y2.d() + y2.b(), t.b()) - min2);
    }
    
    public void a(final y.f.f.d.C c) {
        final int a = y.f.f.b.h.a;
        final y.c.y y = new y.c.y();
        final y.c.y y2 = new y.c.y();
        final y.c.D d = new y.c.D();
        final A a2 = M.a();
        final A a3 = M.a();
        final x o = this.d.o();
    Label_0049:
        while (o.f()) {
            final q e = o.e();
            final y.c.C m = c.a(this.d, e).m();
            while (m.f()) {
                a2.a(e, d.b(m.d()));
                m.g();
                if (a != 0) {
                    continue Label_0049;
                }
                if (a != 0) {
                    break;
                }
            }
            Label_0232: {
                if (this.b(e) != null) {
                    if (this.b.h(e.f()).d()) {
                        y2.add(e);
                        a3.a(e, this.d.m(e));
                        if (a == 0) {
                            break Label_0232;
                        }
                    }
                    y.add(e);
                    a3.a(e, this.d.n(e));
                }
            }
            o.g();
            if (a != 0) {
                break;
            }
        }
        final f f = new f(a3, false);
        y2.sort(f);
        x x = y2.a();
        while (true) {
        Label_2352_Outer:
            while (x.f()) {
                final q e2 = x.e();
                final byte a4 = this.b(e2).f().a();
                final boolean c2 = this.b.c(e2.f());
                if (a != 0) {
                    while (true) {
                        if (c2) {
                            final q e3 = x.e();
                            final byte a5 = this.b(e3).f().a();
                            final d d2 = this.b.c(e3.f()) ? e3.h() : e3.f();
                            final d d3 = this.b.c(e3.f()) ? e3.f() : e3.h();
                            Label_1652: {
                                Label_1645: {
                                    if (a5 == 1) {
                                        if (!this.b.e(d2).equals("_")) {
                                            break Label_1645;
                                        }
                                        final y y3 = (y)d.h((p)a2.b(e3));
                                        final double n = this.d.n(d3.d()) + this.d.q(d3.d());
                                        final y a6 = a(y3, this.d.p(d2));
                                        final y.c.D a7 = this.a(new y(a6.c(), n, a6.a(), a6.d() + a6.b() - n), d);
                                        double max = n;
                                        final y.c.C i = a7.m();
                                        while (i.f()) {
                                            final y y4 = (y)i.d();
                                            max = Math.max(max, y4.d() + y4.b());
                                            i.g();
                                            if (a != 0) {
                                                break Label_1652;
                                            }
                                            if (a != 0) {
                                                break;
                                            }
                                        }
                                        final y y5 = new y(y3.c(), Math.min(max + 5.0, y3.d()), y3.a(), y3.b());
                                        a2.a(e3, d.b(y5));
                                        this.d.b(e3, y5.e());
                                        if (a == 0) {
                                            break Label_1645;
                                        }
                                    }
                                    if (a5 == 2 && this.b.e(d2).equals("^")) {
                                        final y y6 = (y)d.h((p)a2.b(e3));
                                        final double n2 = this.d.n(d2.d()) + this.d.q(d2.d());
                                        final y a8 = a(y6, this.d.p(d2));
                                        final y.c.D a9 = this.a(new y(a8.c(), n2, a8.a(), a8.d() + a8.b() - n2), d);
                                        double max2 = n2;
                                        final y.c.C j = a9.m();
                                        while (j.f()) {
                                            final y y7 = (y)j.d();
                                            max2 = Math.max(max2, y7.d() + y7.b());
                                            j.g();
                                            if (a != 0) {
                                                break Label_1652;
                                            }
                                            if (a != 0) {
                                                break;
                                            }
                                        }
                                        final y y8 = new y(y6.c(), Math.min(max2 + 5.0, y6.d()), y6.a(), y6.b());
                                        a2.a(e3, d.b(y8));
                                        this.d.b(e3, y8.e());
                                    }
                                }
                                x.g();
                            }
                            if (a == 0) {
                                x.f();
                                continue Label_2352_Outer;
                            }
                        }
                        break;
                    }
                    final f f2 = new f(a3, true);
                    y2.sort(f2);
                    x x2 = y2.a();
                    while (true) {
                        while (x2.f()) {
                            final q e4 = x2.e();
                            final byte a10 = this.b(e4).f().a();
                            final boolean c3 = this.b.c(e4.f());
                            if (a != 0) {
                                while (true) {
                                    boolean c4 = false;
                                    Label_3027: {
                                        while (true) {
                                            if (c3) {
                                                final q e5 = x2.e();
                                                final byte a11 = this.b(e5).f().a();
                                                c4 = this.b.c(e5.f());
                                                if (a != 0) {
                                                    break Label_3027;
                                                }
                                                final d d4 = c4 ? e5.h() : e5.f();
                                                final d d5 = this.b.c(e5.f()) ? e5.f() : e5.h();
                                                Label_3006: {
                                                    Label_2999: {
                                                        if (a11 == 1) {
                                                            if (!this.b.e(d4).equals("^")) {
                                                                break Label_2999;
                                                            }
                                                            final y y9 = (y)d.h((p)a2.b(e5));
                                                            final double n3 = this.d.n(d5.d());
                                                            final y a12 = a(y9, this.d.p(d4));
                                                            final y.c.D a13 = this.a(new y(a12.c(), a12.d(), a12.a(), n3 - a12.d()), d);
                                                            double min = n3;
                                                            final y.c.C k = a13.m();
                                                            while (k.f()) {
                                                                min = Math.min(min, ((y)k.d()).d());
                                                                k.g();
                                                                if (a != 0) {
                                                                    break Label_3006;
                                                                }
                                                                if (a != 0) {
                                                                    break;
                                                                }
                                                            }
                                                            final y y10 = new y(y9.c(), Math.max(min - 5.0 - y9.b(), y9.d()), y9.a(), y9.b());
                                                            a2.a(e5, d.b(y10));
                                                            this.d.b(e5, y10.e());
                                                            if (a == 0) {
                                                                break Label_2999;
                                                            }
                                                        }
                                                        if (a11 == 2 && this.b.e(d4).equals("_")) {
                                                            final y y11 = (y)d.h((p)a2.b(e5));
                                                            final double n4 = this.d.n(d4.d());
                                                            final y a14 = a(y11, this.d.p(d4));
                                                            final y.c.D a15 = this.a(new y(a14.c(), a14.d(), a14.a(), n4 - a14.d()), d);
                                                            double min2 = n4;
                                                            final y.c.C l = a15.m();
                                                            while (l.f()) {
                                                                min2 = Math.min(min2, ((y)l.d()).d());
                                                                l.g();
                                                                if (a != 0) {
                                                                    break Label_3006;
                                                                }
                                                                if (a != 0) {
                                                                    break;
                                                                }
                                                            }
                                                            final y y12 = new y(y11.c(), Math.max(min2 - 5.0 - y11.b(), y11.d()), y11.a(), y11.b());
                                                            a2.a(e5, d.b(y12));
                                                            this.d.b(e5, y12.e());
                                                        }
                                                    }
                                                    x2.g();
                                                }
                                                if (a == 0) {
                                                    x2.f();
                                                    continue Label_2352_Outer;
                                                }
                                            }
                                            break;
                                        }
                                        x2 = this.d.o();
                                        x2.f();
                                    }
                                    if (c4) {
                                        final q e6 = x2.e();
                                        final S b = this.b(e6);
                                        if (b != null) {
                                            this.a(b, e6);
                                            this.b.f(e6);
                                        }
                                        x2.g();
                                        if (a == 0) {
                                            continue;
                                        }
                                    }
                                    break;
                                }
                                return;
                            }
                            final d d6 = c3 ? e4.h() : e4.f();
                            final d d7 = this.b.c(e4.f()) ? e4.f() : e4.h();
                            Label_2335: {
                                Label_2328: {
                                    if (a10 == 2) {
                                        if (!this.b.e(d6).equals(">")) {
                                            break Label_2328;
                                        }
                                        final y y13 = (y)d.h((p)a2.b(e4));
                                        final double m2 = this.d.m(d6.d());
                                        final y a16 = a(y13, this.d.p(d6));
                                        final y.c.D a17 = this.a(new y(a16.c(), a16.d(), m2 - a16.c(), a16.b()), d);
                                        double min3 = m2;
                                        final y.c.C m3 = a17.m();
                                        while (m3.f()) {
                                            min3 = Math.min(min3, ((y)m3.d()).c());
                                            m3.g();
                                            if (a != 0) {
                                                break Label_2335;
                                            }
                                            if (a != 0) {
                                                break;
                                            }
                                        }
                                        final y y14 = new y(Math.max(min3 - 5.0 - y13.a(), y13.c()), y13.d(), y13.a(), y13.b());
                                        a2.a(e4, d.b(y14));
                                        this.d.b(e4, y14.e());
                                        if (a == 0) {
                                            break Label_2328;
                                        }
                                    }
                                    if (a10 == 1 && this.b.e(d6).equals("<")) {
                                        final y y15 = (y)d.h((p)a2.b(e4));
                                        final double m4 = this.d.m(d7.d());
                                        final y a18 = a(y15, this.d.p(d6));
                                        final y.c.D a19 = this.a(new y(a18.c(), a18.d(), m4 - a18.c(), a18.b()), d);
                                        double min4 = m4;
                                        final y.c.C m5 = a19.m();
                                        while (m5.f()) {
                                            min4 = Math.min(min4, ((y)m5.d()).c());
                                            m5.g();
                                            if (a != 0) {
                                                break Label_2335;
                                            }
                                            if (a != 0) {
                                                break;
                                            }
                                        }
                                        final y y16 = new y(Math.max(min4 - 5.0 - y15.a(), y15.c()), y15.d(), y15.a(), y15.b());
                                        a2.a(e4, d.b(y16));
                                        this.d.b(e4, y16.e());
                                    }
                                }
                                x2.g();
                            }
                            if (a != 0) {
                                break;
                            }
                        }
                        y.sort(f2);
                        x2 = y.a();
                        continue;
                    }
                }
                final d d8 = c2 ? e2.h() : e2.f();
                final d d9 = this.b.c(e2.f()) ? e2.f() : e2.h();
                Label_0954: {
                    Label_0947: {
                        if (a4 == 1) {
                            if (!this.b.e(d8).equals(">")) {
                                break Label_0947;
                            }
                            final y y17 = (y)d.h((p)a2.b(e2));
                            final double n5 = this.d.m(d9.d()) + this.d.p(d9.d());
                            final y a20 = a(y17, this.d.p(d8));
                            final y.c.D a21 = this.a(new y(n5, a20.d(), a20.c() + a20.a() - n5, a20.b()), d);
                            double max3 = n5;
                            final y.c.C m6 = a21.m();
                            while (m6.f()) {
                                final y y18 = (y)m6.d();
                                max3 = Math.max(max3, y18.c() + y18.a());
                                m6.g();
                                if (a != 0) {
                                    break Label_0954;
                                }
                                if (a != 0) {
                                    break;
                                }
                            }
                            final y y19 = new y(Math.min(max3 + 5.0, y17.c()), y17.d(), y17.a(), y17.b());
                            a2.a(e2, d.b(y19));
                            this.d.b(e2, y19.e());
                            if (a == 0) {
                                break Label_0947;
                            }
                        }
                        if (a4 == 2 && this.b.e(d8).equals("<")) {
                            final y y20 = (y)d.h((p)a2.b(e2));
                            final double n6 = this.d.m(d8.d()) + this.d.p(d8.d());
                            final y a22 = a(y20, this.d.p(d8));
                            final y.c.D a23 = this.a(new y(n6, a22.d(), a22.c() + a22.a() - n6, a22.b()), d);
                            double max4 = n6;
                            final y.c.C m7 = a23.m();
                            while (m7.f()) {
                                final y y21 = (y)m7.d();
                                max4 = Math.max(max4, y21.c() + y21.a());
                                m7.g();
                                if (a != 0) {
                                    break Label_0954;
                                }
                                if (a != 0) {
                                    break;
                                }
                            }
                            final y y22 = new y(Math.min(max4 + 5.0, y20.c()), y20.d(), y20.a(), y20.b());
                            a2.a(e2, d.b(y22));
                            this.d.b(e2, y22.e());
                        }
                    }
                    x.g();
                }
                if (a != 0) {
                    break;
                }
            }
            y.sort(f);
            x = y.a();
            continue;
        }
    }
    
    private y.c.D a(final y y, final y.c.D d) {
        final int a = y.f.f.b.h.a;
        final y.c.D d2 = new y.c.D();
        final y.c.C m = d.m();
        while (m.f()) {
            final y y2 = (y)m.d();
            if (y.a(y2, y) || y2.b(y) || y.b(y2)) {
                d2.add(y2);
            }
            m.g();
            if (a != 0) {
                break;
            }
        }
        return d2;
    }
    
    public void a(final d d, final d[] array) {
        if (this.i) {
            this.c(d, array);
            if (y.f.f.b.h.a == 0) {
                return;
            }
        }
        this.b(d, array);
    }
    
    public void b(final d d, final d[] array) {
        final int a = y.f.f.b.h.a;
        final ArrayList list = (ArrayList)this.e.b(d);
        if (list == null || list.isEmpty() || array.length < 2) {
            return;
        }
        final ArrayList<S> list2 = new ArrayList<S>();
        final ArrayList<S> list3 = new ArrayList<S>();
        final ArrayList<S> list4 = new ArrayList<S>();
        while (true) {
            for (final S s : list) {
                s.f().a();
                final aG f = s.f();
                final int n;
                final boolean b = (n = (f.i() ? 1 : 0)) != 0;
                if (a != 0) {
                    if (n == 2) {
                        this.e.a(array[0], list2);
                        list3.addAll(list4);
                        this.e.a(array[1], list3);
                        if (a == 0) {
                            return;
                        }
                    }
                    final d d2 = array[0];
                    final d d3 = array[array.length - 1];
                    final d d4 = array[(array.length + 1) / 2 - 1];
                    this.e.a(d2, list2);
                    this.e.a(d3, list4);
                    this.e.a(d4, list3);
                    return;
                }
                if (b) {
                    list2.add(s);
                    if (a == 0) {
                        continue;
                    }
                }
                if (!f.i() && !f.j()) {
                    list4.add(s);
                    if (a == 0) {
                        continue;
                    }
                }
                list3.add(s);
                if (a != 0) {
                    break;
                }
            }
            int n = array.length;
            continue;
        }
    }
    
    private static a a(final double n) {
        final a a = new a();
        a.a(0.0);
        a.b(0.0);
        a.c(n);
        return a;
    }
    
    public void c(final d d, final d[] array) {
        final int a = y.f.f.b.h.a;
        final ArrayList list = (ArrayList)this.e.b(d);
        final y.f.y a2 = this.a(d);
        int n4 = 0;
        Label_0281: {
            if (this.h != null && this.h.b(d) != null) {
                final a a3 = (a)this.h.b(d);
                int n = 0;
                int i = 0;
                while (true) {
                    while (i < list.size()) {
                        final S s = list.get(i);
                        final e e = this;
                        if (a != 0) {
                            final int n2 = e.j * ((i - n) / ((list.size() + 1) * this.j));
                            final int n3 = i - n2 * (list.size() + 1);
                            int j = 0;
                            while (j < array.length) {
                                n4 = j;
                                if (a != 0) {
                                    break;
                                }
                                this.h.a(array[j], a((n4 == 0) ? (n2 + n3) : n2));
                                ++j;
                                if (a != 0) {
                                    break;
                                }
                            }
                            break Label_0281;
                        }
                        if (this.k != null) {
                            this.k.a(this.d, s, a2);
                        }
                        n += (int)Math.floor(a2.e() ? s.c() : s.b());
                        ++i;
                        if (a != 0) {
                            break;
                        }
                    }
                    i = (int)Math.ceil(Math.max(a3.a() + a3.b(), a3.c()));
                    if (i > n) {
                        final e e = this;
                        continue;
                    }
                    break;
                }
            }
        }
        int k = n4;
        while (k < list.size()) {
            final q d2 = array[k].d();
            this.c.g(d2);
            final S s2 = list.get(k);
            this.f.a(d2, s2);
            this.d.a(d2, this.a(s2, d));
            ++k;
            if (a != 0) {
                break;
            }
        }
    }
    
    private y.f.y a(final d d) {
        final o h = this.b.h(d);
        if (o.a.a(h)) {
            return y.f.y.a;
        }
        if (o.b.a(h)) {
            return y.f.y.b;
        }
        if (o.c.a(h)) {
            return y.f.y.c;
        }
        if (o.d.a(h)) {
            return y.f.y.d;
        }
        return null;
    }
    
    private y.d.q a(final S s, final d d) {
        final y.f.y a = this.a(d);
        final aG f = s.f();
        double b = s.b();
        double c = s.c();
        if (!f.m()) {
            if (a == y.f.y.c || a == y.f.y.a) {
                b += Math.max(0.0, f.h());
                if (y.f.f.b.h.a == 0) {
                    return new y.d.q(b, c);
                }
            }
            if (a == y.f.y.d || a == y.f.y.b) {
                c += Math.max(0.0, f.h());
            }
        }
        return new y.d.q(b, c);
    }
    
    private void a(final S s, final q q) {
        final int a = y.f.f.b.h.a;
        final d a2 = this.a(q);
        final double a3 = this.d.p(a2).a();
        final double b = this.d.p(a2).b();
        final aG f = s.f();
        final int a4 = this.a(a2, f);
        final double b2 = s.b();
        final double c = s.c();
        double m = this.d.m(q);
        double n = this.d.n(q);
        final double max = Math.max(0.0, f.h());
        Label_0167: {
            switch (a4) {
                case 2: {
                    m = a3 + max;
                    if (a != 0) {
                        break Label_0167;
                    }
                    break;
                }
                case 3: {
                    m = a3 - max - b2;
                    if (a != 0) {
                        break Label_0167;
                    }
                    break;
                }
                case 1: {
                    n = b + max;
                    if (a != 0) {
                        break Label_0167;
                    }
                    break;
                }
                case 0: {
                    n = b - max - c;
                    break;
                }
            }
        }
        s.a().b(new t(m + b2 * 0.5, n + c * 0.5));
    }
    
    private d a(final q q) {
        d d = q.g();
        if (this.b.c(d)) {
            d = this.b.a(d);
        }
        return d;
    }
    
    public void c() {
        final int a = y.f.f.b.h.a;
        if (this.k != null) {
            final Iterator<S> iterator = (Iterator<S>)this.l.iterator();
            while (iterator.hasNext()) {
                this.k.a(this.d, iterator.next());
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    private int a(final d d, final aG ag) {
        final byte b = ag.b();
        final y.f.y a = this.a(d);
        if (b != 8) {
            if ((a == y.f.y.a && b == 16) || (a == y.f.y.c && b == 32)) {
                return 3;
            }
            if ((a == y.f.y.a && b == 32) || (a == y.f.y.c && b == 16)) {
                return 2;
            }
            if ((a == y.f.y.d && b == 32) || (a == y.f.y.b && b == 16)) {
                return 0;
            }
            if ((a == y.f.y.d && b == 16) || (a == y.f.y.b && b == 32)) {
                return 1;
            }
        }
        return 4;
    }
    
    public void a(final d[] array, final d d) {
        final int a = y.f.f.b.h.a;
        ArrayList list = null;
        int i = 0;
        while (i < array.length) {
            final ArrayList list2 = (ArrayList)this.e.b(array[i]);
            if (a != 0) {
                return;
            }
            Label_0064: {
                if (list2 != null) {
                    if (list == null) {
                        list = list2;
                        if (a == 0) {
                            break Label_0064;
                        }
                    }
                    list.addAll(list2);
                }
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
        this.e.a(d, list);
    }
    
    public void a(final d d, final y.f.h.p[] array, final y.f.h.p[] array2) {
    }
    
    public void b(final d d, final y.f.h.p[] array, final y.f.h.p[] array2) {
    }
    
    private S b(final q q) {
        return (S)this.f.b(q);
    }
    
    static {
        a = "EDGE_LABEL_REF";
    }
}
