package y.f.f.b;

import y.f.h.*;
import y.c.*;
import y.f.*;
import y.d.*;

public class h
{
    private D b;
    private static double c;
    private N d;
    private y.f.h.D e;
    private y.c.h f;
    private A g;
    private boolean h;
    public static int a;
    
    public h(final i i) {
        this(new N(i));
        this.h = true;
    }
    
    public h(final N d) {
        this.d = d;
        Label_0052: {
            if (this.d instanceof y.f.h.D) {
                this.e = (y.f.h.D)this.d;
                if (y.f.f.b.h.a == 0) {
                    break Label_0052;
                }
            }
            this.e = null;
            this.g = this.a().t();
        }
        this.b = new D();
        this.f = this.a().u();
    }
    
    public h(final y.f.h.D d) {
        this((N)d);
    }
    
    public i a() {
        return this.d.g();
    }
    
    public N b() {
        return this.d;
    }
    
    public d a(final d d) {
        return this.d.h(d);
    }
    
    public void a(final d d, final d d2) {
        this.d.b(d, d2);
    }
    
    public q c() {
        return this.d.h();
    }
    
    public void a(final p p) {
        this.d.b(p);
    }
    
    public p d() {
        return this.d.i();
    }
    
    public int e() {
        return this.d.j();
    }
    
    public p b(final d d) {
        return this.d.i(d);
    }
    
    public void f() {
        this.d.l();
    }
    
    public r g() {
        return this.d.m();
    }
    
    public void a(final r r) {
        this.d.a(r);
    }
    
    public boolean h() {
        return this.d.n();
    }
    
    public boolean c(final d d) {
        return this.d.n(d);
    }
    
    protected void a(final y.c.q q, final int n) {
        if (this.e == null) {
            this.j(q).a(n);
            if (y.f.f.b.h.a == 0) {
                return;
            }
        }
        this.e.a(q, n);
    }
    
    protected int a(final y.c.q q) {
        if (this.e == null) {
            return this.j(q).a();
        }
        return this.e.a(q);
    }
    
    public boolean b(final y.c.q q) {
        return this.a(q) == 1;
    }
    
    public void c(final y.c.q q) {
        this.a(q, 1);
    }
    
    public boolean d(final y.c.q q) {
        return this.a(q) == 0;
    }
    
    public void e(final y.c.q q) {
        this.a(q, 0);
    }
    
    public void f(final y.c.q q) {
        this.a(q, 2);
    }
    
    public boolean g(final y.c.q q) {
        return this.a(q) == 2;
    }
    
    public void a(final d d, final int n) {
        this.q(d).a(n);
    }
    
    public void a(final d d, final double n) {
        this.q(d).a((int)Math.floor(n + y.f.f.b.h.c));
    }
    
    public int d(final d d) {
        return this.q(d).a();
    }
    
    public String e(final d d) {
        return this.q(d).b();
    }
    
    public void a(final d d, final String s) {
        this.q(d).a(s);
    }
    
    public void a(final d d, final char c) {
        this.q(d).a(new String(new char[] { c }));
    }
    
    public void a(final d d, final o o) {
        this.q(d).a(o.toString());
    }
    
    public void f(final d d) {
        final d a = this.a(d);
        final String e = this.e(d);
        if (e == null) {
            this.a(a, (String)null);
            if (y.f.f.b.h.a == 0) {
                return;
            }
        }
        this.a(a, a(e));
    }
    
    public static String a(final String s) {
        final int a = h.a;
        final StringBuffer sb = new StringBuffer();
        int i = s.length() - 1;
        while (i >= 0) {
            final StringBuffer append = sb.append(o.a(s.charAt(i)).c().toString());
            if (a != 0) {
                return append.toString();
            }
            --i;
            if (a != 0) {
                break;
            }
        }
        final StringBuffer append = sb;
        return append.toString();
    }
    
    public void a(final y.c.h h, final d d, final o o) {
        final int i = h.a;
        final boolean[] array = new boolean[this.e()];
        final d[] array2 = new d[this.e()];
        final r g = this.g();
        int n = 0;
        q q = this.c();
        while (true) {
            while (q.f()) {
                g.a(q.a(), n);
                array2[n] = null;
                array[n] = false;
                ++n;
                q.g();
                if (i != 0) {
                    d a = this.a(d);
                    final p b = this.b(a);
                    this.a(this.a(a), o.toString());
                    array2[g.a(b)] = a;
                    int j = 0;
                    p a2 = b;
                Label_0570:
                    while (j < this.e()) {
                    Label_0316_Outer:
                        while (i == 0) {
                            if (array[g.a(a2)] || array2[g.a(a2)] == null) {
                                q.g();
                                if (!q.f()) {
                                    q = this.c();
                                }
                                a2 = q.a();
                                if (i == 0) {
                                    continue Label_0316_Outer;
                                }
                            }
                            d a3 = array2[g.a(a2)];
                            o o2 = o.a(this.e(this.a(a3)).charAt(0)).c();
                            final e a4 = a2.a();
                            while (true) {
                                while (a4.a() != a3) {
                                    a4.g();
                                    if (i != 0) {
                                        while (true) {
                                            o o3 = o2.c().b(this.d(a3));
                                            final String s = (String)h.b(a3);
                                            String s2;
                                            if (s.length() > 0) {
                                                final StringBuffer sb = new StringBuffer(o3.toString());
                                                int n2 = 0;
                                                do {
                                                    int k = 0;
                                                    Label_0397: {
                                                        k = n2;
                                                    }
                                                    int length = s.length();
                                                    while (k < length) {
                                                        final char c = (char)(k = s.charAt(n2));
                                                        final int n3 = length = 60;
                                                        if (i == 0) {
                                                            if (c == n3) {
                                                                o3 = o3.b();
                                                            }
                                                            if (s.charAt(n2) == '>') {
                                                                o3 = o3.a();
                                                            }
                                                            sb.append(o3.toString());
                                                            ++n2;
                                                            continue Label_0397;
                                                        }
                                                    }
                                                    break;
                                                } while (i == 0);
                                                s2 = sb.toString();
                                            }
                                            else {
                                                s2 = o3.toString();
                                            }
                                            this.a(a3, s2);
                                            array2[g.a(this.b(this.a(a3)))] = this.a(a3);
                                            o2 = o.a(s2.charAt(s2.length() - 1));
                                            while (a3 == a) {
                                                array[g.a(a2)] = true;
                                                ++j;
                                                if (i == 0) {
                                                    if (i != 0) {
                                                        break Label_0570;
                                                    }
                                                    continue Label_0570;
                                                }
                                            }
                                            a4.b();
                                            a3 = a4.a();
                                            continue Label_0316_Outer;
                                        }
                                    }
                                    if (i != 0) {
                                        break;
                                    }
                                }
                                a = a3;
                                continue;
                            }
                        }
                        return;
                    }
                    this.a(g);
                    return;
                }
                if (i != 0) {
                    break;
                }
            }
            q = this.c();
            continue;
        }
    }
    
    public int[] h(final y.c.q q) {
        final int a = y.f.f.b.h.a;
        final int[] array = { 0, 0, 0, 0 };
        final e l = q.l();
        while (l.f()) {
            final o a2 = o.a(this.e(l.a()).charAt(0));
            final int[] array3;
            final int[] array2 = array3 = array;
            if (a != 0) {
                return array3;
            }
            final int f = a2.f();
            ++array2[f];
            l.g();
            if (a != 0) {
                break;
            }
        }
        return array;
    }
    
    public int[][] i(final y.c.q q) {
        final int a = y.f.f.b.h.a;
        final int[][] array = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        final e l = q.l();
        while (l.f()) {
            final d a2 = l.a();
            final o a3 = o.a(this.e(a2).charAt(0));
            Label_0249: {
                if (this.d(a2.d()) || this.b(a2.d())) {
                    final int[] array2 = array[a3.f()];
                    final int n = 1;
                    ++array2[n];
                    if (a == 0) {
                        break Label_0249;
                    }
                }
                if (this.d(this.a(a2)) == 1) {
                    final int[] array3 = array[a3.f()];
                    final int n2 = 0;
                    ++array3[n2];
                    if (a == 0) {
                        break Label_0249;
                    }
                }
                if (this.d(this.a(a2)) == 3) {
                    final int[] array4 = array[a3.f()];
                    final int n3 = 2;
                    ++array4[n3];
                    if (a == 0) {
                        break Label_0249;
                    }
                }
                y.g.o.a((Object)("Cannot classify edge : " + a2));
            }
            l.g();
            if (a != 0) {
                break;
            }
        }
        return array;
    }
    
    public int g(final d d) {
        return o.a(this.e(d).charAt(0)).f();
    }
    
    public o h(final d d) {
        return o.a(this.e(d).charAt(0));
    }
    
    public int i(final d d) {
        return this.q(d).c();
    }
    
    public boolean j(final d d) {
        return this.q(d).c() != Integer.MIN_VALUE;
    }
    
    public void b(final d d, final int n) {
        this.q(d).b(n);
    }
    
    public double k(final d d) {
        return this.q(d).d();
    }
    
    public void b(final d d, final double n) {
        this.q(d).a(n);
    }
    
    public void c(final d d, final int n) {
        y.f.f.b.i.a(this.q(d), n);
    }
    
    public void d(final d d, final int n) {
        y.f.f.b.i.b(this.q(d), n);
    }
    
    public int l(final d d) {
        return y.f.f.b.i.a(this.q(d));
    }
    
    public int m(final d d) {
        return y.f.f.b.i.b(this.q(d));
    }
    
    public void a(final n n) {
        this.b.add(n);
    }
    
    public C i() {
        return this.b.m();
    }
    
    public f e(final d d, final int n) {
        final int a = y.f.f.b.h.a;
        final y.f.h.D d2 = (y.f.h.D)this.b();
        if (this.e(d).length() != 1) {
            throw new RuntimeException("Shape not simple: " + this.e(d));
        }
        final o h = this.h(d);
        final o c = h.c();
        final int d3 = this.d(d);
        final int d4 = this.d(this.a(d));
        final f a2 = d2.a(d, n);
        final e a3 = a2.a();
        while (a3.f()) {
            final d a4 = a3.a();
            this.a(a4, h);
            this.a(this.a(a4), c);
            Label_0183: {
                if (a4.d() != d.d()) {
                    this.a(this.a(a4), 2);
                    if (a == 0) {
                        break Label_0183;
                    }
                }
                this.a(this.a(a4), d4);
            }
            Label_0215: {
                if (a4.c() != d.c()) {
                    this.a(a4, 2);
                    if (a == 0) {
                        break Label_0215;
                    }
                }
                this.a(a4, d3);
            }
            if (a4.d() != d.d()) {
                this.e(a4.d());
            }
            a3.g();
            if (a != 0) {
                break;
            }
        }
        return a2;
    }
    
    public void n(final d d) {
        final int a = y.f.f.b.h.a;
        if (this.d.n(d)) {
            throw new IllegalArgumentException("Edge: " + d + " is inserted !");
        }
        final String e = this.e(d);
        if (e.length() == 1) {
            return;
        }
        final d a2 = this.a(d);
        final String e2 = this.e(a2);
        final y.f.h.D d2 = (y.f.h.D)this.b();
        final f a3 = d2.a(d, e.length() - 1);
        int n = 0;
        final e a4 = a3.a();
        while (a4.f()) {
            final d a5 = a4.a();
            final d a6 = this.a(a5);
            final y.c.q d3 = a5.d();
            Label_0213: {
                if (n == 0) {
                    this.a(a5, this.d(d));
                    if (a == 0) {
                        break Label_0213;
                    }
                }
                this.a(a5, o.a(o.a(e.charAt(n - 1)).f() - o.a(e.charAt(n)).f()).f());
            }
            Label_0316: {
                if (n == e.length() - 1) {
                    this.a(a6, this.d(a2));
                    if (a == 0) {
                        break Label_0316;
                    }
                }
                this.a(a6, o.a(o.a(e2.charAt(e2.length() - n - 2)).f() - o.a(e2.charAt(e2.length() - n - 1)).f()).f());
                this.f(d3);
                d2.d(d3);
            }
            if (e.charAt(n) != '+') {
                this.a(a5, e.charAt(n));
            }
            if (e2.charAt(e2.length() - n - 1) != '+') {
                this.a(a6, e2.charAt(e2.length() - n - 1));
            }
            ++n;
            a4.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    public void j() {
        final int a = y.f.f.b.h.a;
        final i a2 = this.a();
        final y.f.h.D d = (y.f.h.D)this.b();
        final x o = a2.o();
        while (o.f()) {
            final y.c.q e = o.e();
            if (a != 0) {
                return;
            }
            Label_0530: {
                if (this.g(e)) {
                    final e l = e.l();
                    final d a3 = l.a();
                    l.g();
                    final d a4 = l.a();
                    if (this.h(a3).c().a(this.h(a4))) {
                        final d h = d.h(a3);
                        final d h2 = d.h(a4);
                        final String string = this.e(h) + this.e(a4).substring(1);
                        final double n = this.d(h);
                        final double n2 = this.d(h2);
                        final boolean b = d.i(a3) == d.i();
                        final boolean b2 = d.i(h) == d.i();
                        final d h3 = d.h(e);
                        final d h4 = d.h(h3);
                        if (h3.c() == h.c() && h3.d() == a4.d()) {
                            this.a(h3, string);
                            this.f(h3);
                            this.a(h3, n);
                            this.a(h4, n2);
                            if (b2) {
                                d.b(d.i(h3));
                            }
                            if (b) {
                                d.b(d.i(h4));
                            }
                            if (!(a2 instanceof X)) {
                                break Label_0530;
                            }
                            final X x = (X)a2;
                            x.c(h3, x.p(h));
                            x.d(h3, x.q(a4));
                            x.b(h3, v.a);
                            if (a == 0) {
                                break Label_0530;
                            }
                        }
                        if (h3.c() == h2.c() && h3.d() == a3.d()) {
                            this.a(h4, string);
                            this.f(h4);
                            this.a(h3, n2);
                            this.a(h4, n);
                            if (b) {
                                d.b(d.i(h3));
                            }
                            if (b2) {
                                d.b(d.i(h4));
                            }
                            if (!(a2 instanceof X)) {
                                break Label_0530;
                            }
                            final X x2 = (X)a2;
                            x2.c(h3, x2.p(h2));
                            x2.d(h3, x2.q(a3));
                            x2.b(h3, v.a);
                            if (a == 0) {
                                break Label_0530;
                            }
                        }
                        throw new RuntimeException("Error in remove 180 degree bends");
                    }
                }
            }
            o.g();
            if (a != 0) {
                break;
            }
        }
        d.k();
    }
    
    public void k() {
        final int a = y.f.f.b.h.a;
        final X x = (X)this.a();
        final y.f.h.D d = (y.f.h.D)this.b();
        final x o = x.o();
        while (o.f()) {
            final y.c.q e = o.e();
            if (a != 0) {
                return;
            }
            Label_0309: {
                if (this.g(e)) {
                    final e l = e.l();
                    final d a2 = l.a();
                    l.g();
                    final d a3 = l.a();
                    final d h = d.h(a2);
                    final d h2 = d.h(a3);
                    final t p = x.p(h);
                    final t q = x.q(a3);
                    final t i = x.l(e);
                    final D k = x.k(h);
                    k.add(i);
                    k.a(x.k(a3));
                    final d h3 = d.h(e);
                    final d h4 = d.h(h3);
                    if (h3.c() == h.c() && h3.d() == a3.d()) {
                        x.c(h3, p);
                        x.d(h3, q);
                        x.b(h3, k);
                        ae.a(x, h4, h3);
                        if (a == 0) {
                            break Label_0309;
                        }
                    }
                    if (h3.c() == h2.c() && h3.d() == a2.d()) {
                        x.c(h4, p);
                        x.d(h4, q);
                        x.b(h4, k);
                        ae.a(x, h3, h4);
                        if (a == 0) {
                            break Label_0309;
                        }
                    }
                    throw new RuntimeException("Error in remove bend");
                }
            }
            o.g();
            if (a != 0) {
                break;
            }
        }
        d.k();
    }
    
    public void l() {
        final int a = y.f.f.b.h.a;
        y.g.o.a(this, "Check if all necessary data is set..");
        e e = this.a().p();
        while (true) {
            d d;
            String e2;
            String s;
            String a2;
            x x;
            y.c.q e3;
            int n;
            int i;
            y.c.q e4;
            e l;
            d a3;
            d j;
            int g;
            int g2;
            int d2;
            int n3;
            int n2;
            p d3;
            boolean b;
            q c;
            p a4;
            e k;
            Label_0158_Outer:Label_0398_Outer:
            while (e.f()) {
                d = e.a();
                e2 = this.e(d);
                if (a != 0) {
                    while (true) {
                        s = e2;
                        a2 = a(s);
                        if (a == 0) {
                            if (!a2.equals(a(s))) {
                                throw new RuntimeException("Shapes are not compatible for " + d + " !");
                            }
                            e.g();
                            if (a == 0) {
                                if (e.f()) {
                                    d = e.a();
                                    this.e(d);
                                    continue Label_0398_Outer;
                                }
                            }
                            y.g.o.a(this, 0, "Check if sum of angles around a node is four..");
                        }
                        break;
                    }
                    x = this.a().o();
                Label_0398:
                    while (true) {
                    Label_0377_Outer:
                        while (x.f()) {
                            e3 = x.e();
                            n = 0;
                            i = e3.c();
                            if (a != 0) {
                                while (true) {
                                Label_0633:
                                    while (true) {
                                        while (i != 0) {
                                            e4 = x.e();
                                            if (a == 0) {
                                                l = e4.l();
                                                while (l.f()) {
                                                    a3 = l.a();
                                                    j = this.d.j(a3);
                                                    g = this.g(a3);
                                                    g2 = this.g(j);
                                                    d2 = this.d(j);
                                                    n2 = (n3 = (g2 - g) % 4);
                                                    if (a != 0) {
                                                        continue Label_0404;
                                                    }
                                                    if (n3 < 0) {
                                                        n2 += 4;
                                                    }
                                                    if (n2 != d2 % 4) {
                                                        throw new RuntimeException("Angle <-> shape inconsistency ( " + a3 + "[" + this.e(a3) + "],  " + j + "[" + this.e(j) + "], angle field " + d2 + ", shape: " + n2 + " )" + " !");
                                                    }
                                                    l.g();
                                                    if (a != 0) {
                                                        break;
                                                    }
                                                }
                                                x.g();
                                                if (a != 0) {
                                                    break;
                                                }
                                                break Label_0398;
                                            }
                                            else {
                                                if (this.d() == null) {
                                                    throw new RuntimeException("No outer face defined !");
                                                }
                                                d3 = this.d();
                                                b = false;
                                                c = this.c();
                                                while (c.f()) {
                                                    a4 = c.a();
                                                    if (a != 0) {
                                                        return;
                                                    }
                                                    if (d3 == a4) {
                                                        b = true;
                                                    }
                                                    c.g();
                                                    if (a != 0) {
                                                        break;
                                                    }
                                                }
                                                if (!b) {
                                                    throw new RuntimeException("Non existing face set to outer face : " + d3);
                                                }
                                                return;
                                            }
                                        }
                                        break Label_0633;
                                        x.f();
                                        continue Label_0398_Outer;
                                    }
                                    y.g.o.a(this, 0, "Check if outer face is set correctly..");
                                    continue Label_0377_Outer;
                                }
                            }
                            if (i == 0) {
                                n = 4;
                            }
                            k = e3.l();
                            while (true) {
                                while (k.f()) {
                                    n += this.d(k.a());
                                    k.g();
                                    if (a == 0) {
                                        if (a != 0) {
                                            break;
                                        }
                                        continue Label_0158_Outer;
                                    }
                                    else {
                                        if (a != 0) {
                                            break Label_0377_Outer;
                                        }
                                        continue Label_0398;
                                    }
                                }
                                if (n != 4) {
                                    throw new RuntimeException("Node [" + e3 + "] has anglesum != 4 (" + n + ") !");
                                }
                                x.g();
                                continue;
                            }
                        }
                        y.g.o.a(this, 0, "Check if angles are compatible with shape..");
                        x = this.a().o();
                        continue Label_0398;
                    }
                }
                if (e2 == null) {
                    throw new RuntimeException("Null shape !");
                }
                if (this.e(d).length() == 0) {
                    throw new RuntimeException("Empty shape !");
                }
                if (this.d(d) < 0 || this.d(d) > 4) {
                    throw new RuntimeException("Angle out of bounds !");
                }
                e.g();
                if (a != 0) {
                    break;
                }
            }
            y.g.o.a(this, 0, "Check if reverse directions are compatible..");
            e = this.a().p();
            continue;
        }
    }
    
    public void m() {
        final int a = y.f.f.b.h.a;
        final e p = this.a().p();
        while (p.f()) {
            final d a2 = p.a();
            if (this.e(a2) == null) {
                throw new RuntimeException("Null shape !");
            }
            if (this.e(a2).length() != 1) {
                throw new RuntimeException("non-simple shape !");
            }
            p.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    public void n() {
        final int a = y.f.f.b.h.a;
        this.m();
        final q c = this.c();
    Label_0162_Outer:
        while (c.f()) {
            final p a2 = c.a();
            int n = 0;
            int n2 = 0;
            final e a3 = a2.a();
            while (true) {
                while (a3.f()) {
                    n += this.d(a3.a());
                    ++n2;
                    a3.g();
                    if (a == 0) {
                        if (a != 0) {
                            break;
                        }
                        continue Label_0162_Outer;
                    }
                    else {
                        if (this.d() == a2 && n != 2 * n2 + 4) {
                            throw new RuntimeException("Outer Face ( " + a2 + " ) has wrong angle sum (" + n + " != " + (2 * n2 + 4) + " ) !");
                        }
                        c.g();
                        if (a != 0) {
                            break Label_0162_Outer;
                        }
                        continue Label_0162_Outer;
                    }
                }
                if (this.d() != a2 && n != 2 * n2 - 4) {
                    throw new RuntimeException("Inner Face ( " + a2 + " ) has wrong angle sum (" + n + " != " + (2 * n2 - 4) + " ) !");
                }
                continue;
            }
        }
    }
    
    public void o() {
        if (!this.h()) {
            throw new RuntimeException("Graph is not planar !");
        }
    }
    
    protected boolean o(final d d) {
        final int d2 = this.d(this.d.j(this.d.h(d)));
        if (d2 == 1) {
            return true;
        }
        if (d2 == 3) {
            return false;
        }
        throw new RuntimeException("Undefined Angle: " + d2);
    }
    
    protected boolean p(final d d) {
        final d k = this.d.k(d);
        return this.d(d.c()) && this.g(d.d()) && this.g(k.d()) && this.d(d) == 0 && this.o(k) && !this.o(d);
    }
    
    public boolean[] p() {
        final int i = y.f.f.b.h.a;
        final boolean[] array = new boolean[this.a().g()];
        final x o = this.a().o();
        while (true) {
            do {
                Label_0023: {
                    o.f();
                }
                boolean g = false;
                Label_0029:
                while (g) {
                    final y.c.q e = o.e();
                    final h h = this;
                    if (i == 0) {
                        if (this.d(e)) {
                            final e l = e.l();
                            while (l.f()) {
                                final d a = l.a();
                                g = this.g(a.d());
                                if (i != 0) {
                                    continue Label_0029;
                                }
                                Label_0242: {
                                    if (g) {
                                        final d j = this.d.j(a);
                                        final d k = this.d.k(a);
                                        Label_0182: {
                                            if (this.d(j) == 0) {
                                                if (!this.g(j.d())) {
                                                    array[a.b()] = true;
                                                    if (i == 0) {
                                                        break Label_0182;
                                                    }
                                                }
                                                if (this.o(j) && this.o(a)) {
                                                    array[a.b()] = true;
                                                }
                                            }
                                        }
                                        if (this.d(a) == 0) {
                                            if (!this.g(k.d())) {
                                                array[a.b()] = true;
                                                if (i == 0) {
                                                    break Label_0242;
                                                }
                                            }
                                            if (!this.o(k) && !this.o(a)) {
                                                array[a.b()] = true;
                                            }
                                        }
                                    }
                                }
                                l.g();
                                if (i != 0) {
                                    break;
                                }
                            }
                        }
                        o.g();
                        continue Label_0023;
                    }
                    final q h2 = h.d.h();
                    do {
                        Label_0273:
                        h2.f();
                        boolean p = false;
                        Label_0279:
                        while (p) {
                            final p a2 = h2.a();
                            d a3 = null;
                            final e a4 = a2.a();
                            while (true) {
                                while (a4.f()) {
                                    a3 = a4.a();
                                    final boolean d = this.d(a3.c());
                                    if (i != 0) {
                                        while (true) {
                                            Label_0395: {
                                                if (!d) {
                                                    break Label_0395;
                                                }
                                                a4.b();
                                                if (i != 0) {
                                                    break Label_0395;
                                                }
                                                while (a4.a() != a3) {
                                                    final d a5 = a4.a();
                                                    final d m = this.d.k(a5);
                                                    p = this.p(a5);
                                                    if (i != 0) {
                                                        continue Label_0279;
                                                    }
                                                    Label_0504: {
                                                        if (p) {
                                                            if (array[this.d.h(this.d.j(this.d.h(m))).b()]) {
                                                                array[a5.b()] = true;
                                                                if (i == 0) {
                                                                    break Label_0504;
                                                                }
                                                            }
                                                            array[m.b()] = true;
                                                        }
                                                    }
                                                    a4.b();
                                                    if (i != 0) {
                                                        break;
                                                    }
                                                }
                                                h2.g();
                                                continue Label_0273;
                                            }
                                            a4.i();
                                            continue;
                                        }
                                    }
                                    if (d) {
                                        if (!this.p(a3)) {
                                            break;
                                        }
                                    }
                                    else if (!this.d(a3.d())) {
                                        break;
                                    }
                                    a4.g();
                                    if (i != 0) {
                                        break;
                                    }
                                }
                                a4.f();
                                continue;
                            }
                        }
                        break;
                    } while (i == 0);
                    return array;
                }
                break;
            } while (i == 0);
            final h h = this;
            continue;
        }
    }
    
    public void q() {
        this.a().a(this.f);
        if (this.e == null) {
            this.a().a(this.g);
        }
        if (this.h) {
            this.d.e();
        }
    }
    
    protected j j(final y.c.q q) {
        j r = (j)this.g.b(q);
        if (r == null) {
            r = this.r();
            this.g.a(q, r);
        }
        return r;
    }
    
    protected j r() {
        return new j();
    }
    
    protected y.f.f.b.i q(final d d) {
        y.f.f.b.i s = (y.f.f.b.i)this.f.b(d);
        if (s == null) {
            s = this.s();
            this.f.a(d, s);
        }
        return s;
    }
    
    protected y.f.f.b.i s() {
        return new y.f.f.b.i(this);
    }
    
    static {
        h.c = 0.001;
    }
}
