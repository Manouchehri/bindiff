package y.f.h.a;

import y.c.*;
import java.util.*;
import y.f.h.*;

public class b
{
    D a;
    i b;
    n[] c;
    protected f[] d;
    protected f e;
    private f h;
    s f;
    public static boolean g;
    
    public b() {
        this(new j());
    }
    
    b(final s f) {
        this.d = new f[2];
        this.e = new f();
        this.h = new f();
        this.d[0] = new f();
        this.d[1] = new f();
        this.f = f;
    }
    
    public String toString() {
        final boolean g = y.f.h.a.b.g;
        String s = "";
        String string = null;
        Label_0068: {
            if (this.c != null) {
                int i = 0;
                while (i < this.c.length) {
                    string = s + this.c[i].toString() + "\n";
                    if (g) {
                        break;
                    }
                    s = string;
                    ++i;
                    if (g) {
                        break Label_0068;
                    }
                }
                return string;
            }
        }
        s = "nodes not initialized yet";
        return string;
    }
    
    protected void a() {
        final boolean g = y.f.h.a.b.g;
        int i = 0;
        while (i < 2) {
            this.d[i].b();
            ++i;
            if (g) {
                return;
            }
            if (g) {
                break;
            }
        }
        this.h.b();
        this.e.b();
    }
    
    boolean b() {
        final boolean g = y.f.h.a.b.g;
        this.c = new n[this.b.f()];
        final x o = this.b.o();
        while (o.f()) {
            final int d = o.e().d();
            this.c[d] = new n(o.e(), -1, null);
            if (g) {
                return true;
            }
            o.e();
        Label_0078:
            while (true) {
                q d2 = null;
                final e l = d2.l();
                while (l.f()) {
                    d2 = l.a().d();
                    if (g) {
                        continue Label_0078;
                    }
                    if (d2 == l.a().c() && !this.b(l.a())) {
                        this.c[d].a(l.a());
                        this.b.d(l.a());
                    }
                    l.g();
                    if (g) {
                        break;
                    }
                }
                break;
            }
            o.g();
            if (g) {
                break;
            }
        }
        this.f.a(this.b);
        this.a(this.f);
        this.e();
        return true;
    }
    
    private void e() {
        final boolean g = y.f.h.a.b.g;
        int i = 0;
        while (i < this.c.length) {
            Label_0076: {
                if (this.c[i].q() != null) {
                    final Iterator iterator = this.c[i].q().iterator();
                    while (iterator.hasNext()) {
                        this.b.e(iterator.next());
                        if (g) {
                            break Label_0076;
                        }
                        if (g) {
                            break;
                        }
                    }
                }
                ++i;
            }
            if (g) {
                break;
            }
        }
    }
    
    private d a(final d d) {
        if (this.a == null) {
            return null;
        }
        final d h = this.a.h(d);
        if (h != null) {
            return h;
        }
        return this.a.g(d);
    }
    
    private boolean b(final d d) {
        return this.a != null && this.a.n(this.a.d(d));
    }
    
    private boolean a(final s s) {
        final boolean g = y.f.h.a.b.g;
        final ArrayList list = new ArrayList<n>();
        final ArrayList list2 = new ArrayList<d>();
        final n[] c = new n[this.c.length];
        int n = 0;
        final y.c.D[] array = new y.c.D[this.c.length];
        int i = 0;
    Label_0519:
        while (true) {
        Label_0521:
            while (true) {
            Label_0666_Outer:
                while (i < array.length) {
                    array[i] = new y.c.D();
                    ++i;
                    if (g) {
                    Label_0666:
                        while (true) {
                            while (i < array.length) {
                                Label_0654: {
                                    while (true) {
                                        final int empty;
                                        final int n2 = empty = (array[i].isEmpty() ? 1 : 0);
                                        if (g) {
                                            break Label_0666;
                                        }
                                        if (n2 != 0) {
                                            break;
                                        }
                                        final m m = (m)array[i].g();
                                        final n b = m.f().b();
                                        final n b2 = m.e().b();
                                        final m p = b.p();
                                        if (g) {
                                            break Label_0654;
                                        }
                                        if (p != null) {
                                            if (p.e() == b2) {
                                                p.a(m.i());
                                                if (!g) {
                                                    continue Label_0666_Outer;
                                                }
                                            }
                                            b.b(m);
                                            if (!g) {
                                                continue Label_0666_Outer;
                                            }
                                        }
                                        b.b(m);
                                        if (g) {
                                            break;
                                        }
                                    }
                                    ++i;
                                }
                                if (g) {
                                    break;
                                }
                                continue Label_0666_Outer;
                                int empty = 0;
                                int j = empty;
                                while (true) {
                                    while (j >= 0) {
                                        final n[] c2 = this.c;
                                        if (g) {
                                            final y.c.D[] array2 = new y.c.D[c2.length];
                                            int k = this.c.length - 1;
                                            while (true) {
                                            Label_1023:
                                                while (true) {
                                                Label_1006_Outer:
                                                    while (k >= 0) {
                                                        n n3 = this.c[k];
                                                        final int l = n3.l();
                                                        final y.c.D d = array2[l];
                                                        if (g) {
                                                        Label_1006:
                                                            while (true) {
                                                                Label_1195: {
                                                                    Label_1192: {
                                                                        Iterator iterator = null;
                                                                        Block_45: {
                                                                            while (true) {
                                                                                d.iterator();
                                                                                do {
                                                                                    Iterator<y.f.h.a.i> a = null;
                                                                                    Label_1036: {
                                                                                        a = (Iterator<y.f.h.a.i>)iterator;
                                                                                    }
                                                                                    while (true) {
                                                                                        while (a.hasNext()) {
                                                                                            final m m2 = (m)a.next();
                                                                                            m2.e().b().a(m2);
                                                                                            if (!g) {
                                                                                                if (g) {
                                                                                                    break;
                                                                                                }
                                                                                                continue Label_0666_Outer;
                                                                                            }
                                                                                            else {
                                                                                                while (a.hasNext()) {
                                                                                                    list.add(a.next().c());
                                                                                                    if (g) {
                                                                                                        break Label_1006;
                                                                                                    }
                                                                                                    if (g) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                if (n3.h() != null) {
                                                                                                    iterator = n3.h().iterator();
                                                                                                    continue Label_1036;
                                                                                                }
                                                                                                break Label_1006;
                                                                                            }
                                                                                        }
                                                                                        a = (Iterator<y.f.h.a.i>)n3.c().a();
                                                                                        continue Label_1006_Outer;
                                                                                    }
                                                                                } while (g);
                                                                                break Block_45;
                                                                                if (!list.isEmpty()) {
                                                                                    final Object remove = list.remove(list.size() - 1);
                                                                                    n3 = (n)remove;
                                                                                    n3.m();
                                                                                    continue Label_1006_Outer;
                                                                                }
                                                                                break;
                                                                            }
                                                                            break Label_1192;
                                                                        }
                                                                        final Iterator<y.f.h.a.i> iterator2 = (Iterator<y.f.h.a.i>)iterator;
                                                                        while (iterator2.hasNext()) {
                                                                            list.add(iterator2.next().c());
                                                                            if (g) {
                                                                                break Label_1195;
                                                                            }
                                                                            if (g) {
                                                                                break Label_1192;
                                                                            }
                                                                        }
                                                                        continue Label_1006;
                                                                    }
                                                                    ++k;
                                                                }
                                                                if (!g) {
                                                                    if (k < this.c.length) {
                                                                        if (this.c[k].j() == null) {
                                                                            list.add(this.c[k]);
                                                                        }
                                                                        continue Label_1006;
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                            return true;
                                                        }
                                                        if (d == null) {
                                                            array2[l] = new y.c.D();
                                                        }
                                                        if (n3.j() != null) {
                                                            array2[l].b(n3.j().e());
                                                        }
                                                        --k;
                                                        if (g) {
                                                            break;
                                                        }
                                                    }
                                                    k = 0;
                                                    do {
                                                        Label_0826: {
                                                            final int length = array2.length;
                                                        }
                                                        int l2 = 0;
                                                        int f = 0;
                                                        Label_0831:
                                                        while (l2 < f) {
                                                            final Object remove;
                                                            final y.c.D d2 = (y.c.D)(remove = array2[k]);
                                                            if (!g) {
                                                                if (d2 != null) {
                                                                    for (final y.f.h.a.i i2 : array2[k]) {
                                                                        l2 = i2.c().l();
                                                                        f = i2.c().f();
                                                                        if (g) {
                                                                            continue Label_0831;
                                                                        }
                                                                        if (l2 != f && i2.c().l() != i2.f()) {
                                                                            i2.a(i2.b().a(i2));
                                                                            if (!g) {
                                                                                continue Label_0666_Outer;
                                                                            }
                                                                        }
                                                                        i2.a(null);
                                                                        i2.b().b(i2);
                                                                        if (g) {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                                ++k;
                                                                continue Label_0826;
                                                            }
                                                            continue Label_1023;
                                                        }
                                                        break;
                                                    } while (!g);
                                                    break;
                                                }
                                                k = 0;
                                                continue;
                                            }
                                        }
                                        final n n4 = c2[j];
                                        if (n4.j() != null) {
                                            n4.j().e().b().b(n4.l());
                                        }
                                        --j;
                                        if (g) {
                                            break;
                                        }
                                    }
                                    final n[] c3 = this.c;
                                    continue;
                                }
                            }
                            int empty = this.c.length - 1;
                            continue Label_0666;
                        }
                    }
                    if (g) {
                        break;
                    }
                }
                final Iterator b3 = s.b();
            Label_0106_Outer:
                while (b3.hasNext()) {
                    final q q = b3.next();
                    int f4 = 0;
                Label_0106:
                    while (true) {
                        while (true) {
                            q c4 = null;
                            final q q2 = c4;
                            this.c[q2.d()].f();
                        Label_0122:
                            while (true) {
                                int f2 = 0;
                                int f3 = 0;
                                if (f2 == f3) {
                                    list.add(null);
                                    list.add(this.c[q2.d()]);
                                    list2.add(null);
                                }
                                while (!list.isEmpty()) {
                                    final n n5 = list.remove(list.size() - 1);
                                    final n n6 = list.remove(list.size() - 1);
                                    final d d3 = list2.remove(list2.size() - 1);
                                    f4 = n5.f();
                                    if (g) {
                                        break Label_0519;
                                    }
                                    Label_0417: {
                                        if (f4 == -1) {
                                            Label_0294: {
                                                if (n6 != null) {
                                                    final y.f.h.a.i i3 = new y.f.h.a.i(n6, n5);
                                                    final m m3 = new m(i3, n5, d3);
                                                    i3.d(m3);
                                                    n5.d(m3);
                                                    n5.a(n, m3);
                                                    m3.j();
                                                    if (!g) {
                                                        break Label_0294;
                                                    }
                                                }
                                                n5.a(n, null);
                                            }
                                            c[n] = n5;
                                            ++n;
                                            final Iterator a2 = s.a(n5.i());
                                            while (a2.hasNext()) {
                                                final d d4 = a2.next();
                                                if (!this.b(d4)) {
                                                    c4 = d4.c();
                                                    if (g) {
                                                        continue Label_0106;
                                                    }
                                                    if (c4 == d4.d()) {
                                                        continue Label_0106_Outer;
                                                    }
                                                    final n n7 = this.c[d4.a(n5.i()).d()];
                                                    if (n7 == n6) {
                                                        continue Label_0106_Outer;
                                                    }
                                                    list.add(n5);
                                                    list.add(n7);
                                                    list2.add(d4);
                                                    if (g) {
                                                        break Label_0417;
                                                    }
                                                    continue Label_0106_Outer;
                                                }
                                            }
                                            continue Label_0106_Outer;
                                        }
                                    }
                                    if (n6 == null) {
                                        continue Label_0106_Outer;
                                    }
                                    f2 = n6.f();
                                    f3 = n5.f();
                                    if (g) {
                                        continue Label_0122;
                                    }
                                    if (f2 >= f3) {
                                        continue Label_0106_Outer;
                                    }
                                    if (n6.f() == n5.k()) {
                                        n5.j().a(d3);
                                        if (!g) {
                                            continue Label_0106_Outer;
                                        }
                                    }
                                    n5.a(n6.f());
                                    array[n6.f()].add(new m(n6, n5, d3));
                                    if (g) {
                                        break Label_0521;
                                    }
                                }
                                continue Label_0106_Outer;
                            }
                        }
                        break;
                    }
                    i = f4;
                    continue Label_0521;
                }
                break;
            }
            this.c = c;
            continue Label_0519;
        }
    }
    
    protected static m a(final r r, final r r2, final int n, final int n2, final int n3) {
        if (r2.u()) {
            return b(r, r2, n, n2, n3);
        }
        return r2.s();
    }
    
    protected static m b(final r r, final r r2, final int n, final int n2, final int n3) {
        final boolean g = b.g;
        if (r.f(n) != r2.f(n2)) {
            final a a = (r.f() < r2.f()) ? new a(r, r2, 1) : new a(r2, r, 1);
            Label_0077: {
                if (n == 0) {
                    r.e(a);
                    if (!g) {
                        break Label_0077;
                    }
                }
                r.d(a);
            }
            if (n2 == 0) {
                r2.e(a);
                if (!g) {
                    return a;
                }
            }
            r2.d(a);
            return a;
        }
        return r.f(n);
    }
    
    protected void a(final n n, final int n2, final int n3) {
        final boolean g = y.f.h.a.b.g;
        while (n.d(n3)) {
            n.a(n.c().c(), n2 ^ 0x1, n2);
            if (g) {
                break;
            }
        }
    }
    
    protected boolean a(final n n, final n n2, final m m) {
        final boolean g = y.f.h.a.b.g;
        final int f = n.f();
        boolean b = false;
        int n3 = 0;
        final boolean[] array = new boolean[2];
        n b2 = n2;
        y.f.h.a.i i = null;
        int n4 = 0;
        this.d[0].b();
        this.d[1].b();
        this.e.b();
        this.e.a(m);
        int n5 = 0;
        boolean b3 = false;
        int n6 = 0;
        int n13 = 0;
    Label_0682_Outer:
        while (!b && n3 < 2) {
            b3 = (b3 || n6 != 0 || b2.c(f));
            array[0] = !b2.u();
            array[1] = false;
            y.f.h.a.i j = null;
            int a = 0;
            if (!b3 && b2.d(f)) {
                this.a(b2, 1, f);
            }
            int n7 = 0;
        Label_0988:
            while (true) {
                do {
                    int k = 0;
                Label_0928_Outer:
                    while (k < 2) {
                        final int n8 = array[n7] ? 1 : 0;
                        if (!g) {
                            if (n8 == 0) {
                                n n9 = b2;
                                int n10 = n7;
                                r r = null;
                                m l = null;
                                Label_0265: {
                                    if (n7 == 1 && !b3 && i != null) {
                                        r = b2;
                                        n5 = n7;
                                        l = b2.f(n7 ^ 0x1);
                                        if (!g) {
                                            break Label_0265;
                                        }
                                    }
                                    l = b2.f(n7);
                                    r = l.a(b2);
                                }
                                int n11 = 0;
                                while (n11 == 0 && !array[n7]) {
                                    if (r instanceof y.f.h.a.i) {
                                        final y.f.h.a.i i2 = (y.f.h.a.i)r;
                                        n11 = 1;
                                        Label_0378: {
                                            if (b3) {
                                                if (n7 != 1 || array[0]) {
                                                    break Label_0378;
                                                }
                                                a(b2, j, 0, a, 1);
                                                array[0] = true;
                                                if (!g) {
                                                    break Label_0378;
                                                }
                                            }
                                            if (n7 == 1) {
                                                array[0] = true;
                                                if (!g) {
                                                    break Label_0378;
                                                }
                                            }
                                            l = a(n9, i2, n10, i2.a(l, n7 ^ 0x1), 1);
                                        }
                                        j = i2;
                                        a = i2.a(l, n7 ^ 0x1);
                                        if (!g) {
                                            continue Label_0682_Outer;
                                        }
                                    }
                                    if (r instanceof n) {
                                        final n n12 = (n)r;
                                        k = (n12.c(f) ? 1 : 0);
                                        if (g) {
                                            continue Label_0928_Outer;
                                        }
                                        if (k != 0) {
                                            ++n3;
                                            array[n7] = true;
                                            a(n9, r, n10, n12.a(l, 0x1 ^ n5), 1);
                                            n6 = 1;
                                            n11 = (array[0] ? 0 : 1);
                                            if (!g) {
                                                continue Label_0682_Outer;
                                            }
                                        }
                                        if (n12.e(f)) {
                                            n5 = (n12.a(l, n5 ^ 0x1) ^ 0x1);
                                            if (n12.d(f)) {
                                                this.a(n12, n5, f);
                                            }
                                            if (!n12.m().isEmpty()) {
                                                final m o = n12.o();
                                                n10 = n5;
                                                n9 = n12;
                                                Label_0581: {
                                                    if (n10 == 1) {
                                                        n12.e(o);
                                                        if (!g) {
                                                            break Label_0581;
                                                        }
                                                    }
                                                    n12.d(o);
                                                }
                                                l = o;
                                                this.d[n7].a(o);
                                                if (b3) {
                                                    if (n7 == 1 && !array[0]) {
                                                        a(b2, j, 0, a, 1);
                                                    }
                                                    if (!array[n7 ^ 0x1]) {
                                                        ++n3;
                                                    }
                                                    array[n7 ^ 0x1] = true;
                                                }
                                            }
                                        }
                                        l = r.c(l);
                                        r = l.a(r);
                                        if (g) {
                                            break;
                                        }
                                        continue Label_0682_Outer;
                                    }
                                }
                            }
                            ++n7;
                        }
                        else {
                            if (n8 >= 2) {
                                continue Label_0682_Outer;
                            }
                            n13 = (array[0] ? 1 : 0);
                            if (g) {
                                break Label_0988;
                            }
                            final int n14 = n13;
                            Label_0793: {
                                if (i != null) {
                                    if (n4 == n14) {
                                        i.d();
                                    }
                                    if (n14 == 0) {
                                        b2.r().b(i.r());
                                        if (!g) {
                                            break Label_0793;
                                        }
                                    }
                                    b2.r().a(i.r());
                                    if (!g) {
                                        break Label_0793;
                                    }
                                }
                                Label_0787: {
                                    if (n14 == 0) {
                                        b2.e(m);
                                        if (!g) {
                                            break Label_0787;
                                        }
                                    }
                                    b2.d(m);
                                }
                                b2.o();
                            }
                            this.e.a(this.d[n14]);
                            if (!b3) {
                                this.e.d(this.d[n14 ^ 0x1]);
                            }
                            Label_0963: {
                                Label_0940: {
                                    if (j.f() == f) {
                                        b = true;
                                        final Iterator d = this.e.d();
                                        while (true) {
                                            while (true) {
                                                while (d.hasNext()) {
                                                    final m m2 = d.next();
                                                    m2.b(j);
                                                    m2.j();
                                                    if (!g) {
                                                        if (g) {
                                                            break;
                                                        }
                                                        continue Label_0682_Outer;
                                                    }
                                                    else {
                                                        j.r().c(this.e);
                                                        this.e.b();
                                                        if (g) {
                                                            break Label_0940;
                                                        }
                                                        break Label_0963;
                                                    }
                                                }
                                                if (a != 0) {
                                                    continue Label_0928_Outer;
                                                }
                                                j.r().b(this.e);
                                                if (g) {
                                                    continue Label_0928_Outer;
                                                }
                                                break;
                                            }
                                            continue;
                                        }
                                    }
                                }
                                j.e();
                                i = j;
                                n4 = a;
                                b2 = j.b();
                                n3 = 0;
                            }
                            this.d[0].b();
                            this.d[1].b();
                            if (g) {
                                break Label_0682_Outer;
                            }
                            continue Label_0682_Outer;
                        }
                    }
                    break;
                } while (!g);
                continue;
            }
            return n13 != 0;
        }
        return n13 != 0;
    }
    
    protected void c() {
        final boolean g = y.f.h.a.b.g;
        int i = 0;
        while (i < this.c.length) {
            this.c[i].e();
            ++i;
            if (g) {
                break;
            }
        }
    }
    
    private void f() {
        final boolean g = y.f.h.a.b.g;
        final ArrayList list = new ArrayList<n>();
        final int[] array = new int[this.c.length];
        int i = 0;
        while (i < this.c.length) {
            Label_0220: {
                if (array[this.c[i].f()] == 0) {
                    array[this.c[i].f()] = 1;
                    list.add(this.c[i]);
                Label_0073_Outer:
                    while (true) {
                        list.isEmpty();
                    Label_0073:
                        while (true) {
                            boolean k = false;
                            while (!k) {
                                Object o = list.remove(list.size() - 1);
                            Label_0086:
                                while (true) {
                                    final n n = (n)o;
                                    final int n2 = array[n.f()];
                                    if (n2 < 0) {
                                        n.r().c();
                                    }
                                    final Iterator d = n.r().d();
                                    while (d.hasNext()) {
                                        final m m = d.next();
                                        final y.c.D d2 = (y.c.D)(o = m.d());
                                        if (g) {
                                            continue Label_0086;
                                        }
                                        if (d2 == null) {
                                            continue Label_0073_Outer;
                                        }
                                        k = m.k();
                                        if (g) {
                                            continue Label_0073;
                                        }
                                        if (!k) {
                                            continue Label_0073_Outer;
                                        }
                                        final n b = m.a(n).b();
                                        if (b.j() != m) {
                                            continue Label_0073_Outer;
                                        }
                                        list.add(b);
                                        array[b.f()] = n2 * m.h();
                                        if (g) {
                                            break Label_0220;
                                        }
                                    }
                                    continue Label_0073_Outer;
                                }
                            }
                            break;
                        }
                        break;
                    }
                }
            }
            ++i;
            if (g) {
                break;
            }
        }
    }
    
    private void g() {
        final boolean g = y.f.h.a.b.g;
        final e p = this.b.p();
        while (p.f()) {
            this.b.d(p.a());
            p.g();
            if (g) {
                break;
            }
        }
        int n = 0;
    Label_0229:
        do {
            int i = 0;
        Label_0049:
            while (i < this.c.length) {
                final n n2 = this.c[n];
                final Iterator d = n2.r().d();
            Label_0176:
                while (d.hasNext()) {
                    final m m = d.next();
                    if (m.d() != null) {
                        i = (m.k() ? 1 : 0);
                        if (g) {
                            continue Label_0049;
                        }
                        if (i == 0) {
                            continue;
                        }
                        for (final d d2 : m.d()) {
                            if (d2.c() == n2.i()) {
                                this.b.e(d2);
                                if (g || g) {
                                    break Label_0176;
                                }
                                continue;
                            }
                        }
                    }
                }
                if (n2.q() != null) {
                    final Iterator iterator2 = n2.q().iterator();
                    while (iterator2.hasNext()) {
                        this.b.e(iterator2.next());
                        if (g) {
                            continue Label_0229;
                        }
                        if (g) {
                            break;
                        }
                    }
                }
                ++n;
            }
            break;
        } while (!g);
    }
    
    private void h() {
        final boolean g = y.f.h.a.b.g;
        final y.c.D d = new y.c.D();
        int n = 0;
    Label_0308:
        do {
            final int length = this.c.length;
            int i = 0;
            int n2 = 0;
        Label_0021:
            while (i < n2) {
                final Iterator d2 = this.c[n].r().d();
            Label_0159_Outer:
                while (d2.hasNext()) {
                    final m m = d2.next();
                    if (m.d() != null) {
                        i = m.a(this.c[n]).f();
                        n2 = n;
                        if (g) {
                            continue Label_0021;
                        }
                        if (i <= n2) {
                            continue;
                        }
                        Label_0164: {
                            if (m.k()) {
                                d.clear();
                                final Iterator iterator = m.d().iterator();
                                while (true) {
                                    while (iterator.hasNext()) {
                                        d.a(this.a(iterator.next()));
                                        if (!g) {
                                            if (g) {
                                                break;
                                            }
                                            continue Label_0159_Outer;
                                        }
                                        else {
                                            if (g) {
                                                break Label_0164;
                                            }
                                            continue Label_0159_Outer;
                                        }
                                    }
                                    m.d().addAll(d);
                                    continue;
                                }
                            }
                        }
                        final Iterator iterator2 = m.d().iterator();
                        while (iterator2.hasNext()) {
                            this.b.d(iterator2.next());
                            if (g || g) {
                                break Label_0159_Outer;
                            }
                        }
                    }
                }
                if (this.c[n].q() != null) {
                    final y.c.D d3 = new y.c.D();
                    for (final d d4 : this.c[n].q()) {
                        d3.b(d4);
                        d3.b(this.a(d4));
                        if (g) {
                            continue Label_0308;
                        }
                        if (g) {
                            break;
                        }
                    }
                    this.c[n].a(d3);
                }
                ++n;
                continue Label_0308;
            }
            break;
        } while (!g);
    }
    
    private boolean b(final D a) {
        if (a == null) {
            return false;
        }
        this.a = a;
        return this.a(a.g());
    }
    
    public boolean a(final i b) {
        final boolean g = b.g;
        this.b = b;
        this.a();
        this.b();
        int n = this.c.length - 1;
        do {
            int i = 0;
        Label_0028:
            while (i >= 0) {
                for (final m m : this.c[n].d()) {
                    if (!m.k()) {
                        i = (this.a(this.c[n], m.a(this.c[n]).b(), m) ? 1 : 0);
                        if (g) {
                            continue Label_0028;
                        }
                        if (i == 0) {
                            return false;
                        }
                        continue;
                    }
                }
                --n;
            }
            break;
        } while (!g);
        return true;
    }
    
    private void i() {
        this.f();
        this.c();
        this.h();
        this.g();
    }
    
    public boolean a(final D d) {
        final boolean g = y.f.h.a.b.g;
        if (!this.b(d)) {
            return false;
        }
        this.i();
        d.l();
        final y.f.h.q h = d.h();
        if (!h.f()) {
            return true;
        }
        h.a();
        p a = null;
        int n = 0;
        final y.f.h.q h2 = d.h();
        while (true) {
            while (h2.f()) {
                final int k;
                final int n2 = k = h2.a().a().k();
                if (!g) {
                    if (k > n) {
                        n = n2;
                        a = h2.a();
                    }
                    h2.g();
                    if (g) {
                        break;
                    }
                    continue;
                }
                else {
                    if (k != 0) {
                        return true;
                    }
                    throw new RuntimeException("Constructed planar embedding was corrupt!");
                }
            }
            d.b(a);
            d.n();
            continue;
        }
    }
    
    public y.c.f d() {
        final boolean g = y.f.h.a.b.g;
        final y.c.f f = new y.c.f();
        final Iterator d = this.h.d();
        y.c.f f2 = null;
        while (d.hasNext()) {
            f2 = f;
            if (g) {
                return f2;
            }
            f2.addAll(d.next().d());
            if (g) {
                break;
            }
        }
        return f2;
    }
}
