package y.f.c.a;

import y.f.b.*;
import y.g.*;
import java.awt.geom.*;
import y.f.*;
import y.c.*;
import y.d.*;
import java.util.*;

public class E
{
    final f a;
    X b;
    aV c;
    c d;
    b e;
    c f;
    private D h;
    private I i;
    private dd j;
    private double k;
    private final h l;
    private final h m;
    private final Map n;
    private Random o;
    c g;
    
    E(final X b, final aV c, final c d) {
        this.a = new f();
        this.h = new D();
        this.k = 0.0;
        this.o = new Random(0L);
        this.b = b;
        this.c = c;
        this.d = d;
        this.j = new dd(this, b, c);
        this.n = new HashMap();
        this.l = M.b();
        this.m = M.b();
        this.f = b.c(y.f.b.f.d);
        if (this.f != null) {
            b.a(y.f.b.f.d, new F(this));
        }
    }
    
    boolean a() {
        return this.d != null;
    }
    
    public void b() {
        final boolean x = N.x;
        if (!this.k()) {
            (this.e = new b()).b(this.b);
            if (!x) {
                return;
            }
        }
        this.i = new I(this.b);
        int i = 0;
        while (i < this.j.d.size()) {
            final dg dg = this.j.d.get(i);
            if (dg.f != null && dg.f.e() != null) {
                this.i.a(dg.f);
            }
            ++i;
            if (x) {
                break;
            }
        }
    }
    
    public void c() {
        if (!this.k()) {
            this.e.d(this.b);
            if (!N.x) {
                return;
            }
        }
        if (this.i != null) {
            this.i.f();
            this.i = null;
        }
    }
    
    void a(final aU au) {
        this.a(au, (A)null);
    }
    
    void a(final aU au, final A a) {
        if (!this.k()) {
            return;
        }
        this.j.a(au, a);
    }
    
    void b(final aU au) {
        if (!this.k()) {
            return;
        }
        this.j.a(this.c);
    }
    
    void c(final aU au) {
        if (!this.k()) {
            return;
        }
        this.j.a(au, this.c, this.j);
    }
    
    void d(final aU au) {
        if (!this.k()) {
            return;
        }
        this.j.d(au, this.c);
    }
    
    void e(final aU au) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        int n = 0;
        do {
            int i = 0;
            Label_0015: {
                i = n;
            }
            int b = au.b();
            Label_0022:
            while (i < b) {
                final aQ a = au.a(n);
                if (a.e() != 2 && a.e() != 3) {
                    p p = a.d().k();
                    while (p != null) {
                        final q q = (q)p.c();
                        final aX a2 = this.c.a(q);
                        final byte b2 = (byte)(i = a2.b());
                        final int n2 = b = 12;
                        if (x) {
                            continue Label_0022;
                        }
                        if (b2 == n2 || a2.b() == 13) {
                            double m = this.b.m(q);
                            if (a2.b() == 13) {
                                m += this.b.p(q);
                            }
                            final dg f = this.f(a2.l());
                            Label_0228: {
                                if (f.w == null) {
                                    f.w = new Rectangle2D.Double(m, this.b.n(q), 0.0, 0.0);
                                    if (!x) {
                                        break Label_0228;
                                    }
                                }
                                f.w.add(m, this.b.n(q));
                            }
                            if (a2.b() == 12 && f.A == a) {
                                f.w.add(m, this.b.n(q) - f.x);
                            }
                            if (a2.b() == 12 && f.B == a) {
                                f.w.add(m, this.b.n(q) + f.y);
                            }
                        }
                        p = p.a();
                        if (x) {
                            break;
                        }
                    }
                }
                ++n;
                continue Label_0015;
            }
            break;
        } while (!x);
        for (final dg dg : this.j.d) {
            if (dg != this.j) {
                this.b.b(dg.f, dg.w.getWidth(), dg.w.getHeight());
                this.b.c(dg.f, dg.w.getX(), dg.w.getY());
                if (x) {
                    break;
                }
                continue;
            }
        }
    }
    
    void f(final aU au) {
        final boolean x = N.x;
        if (!this.k() || !this.a()) {
            return;
        }
        final y y = new y();
        this.a(this.j, new G(this, y));
        final HashSet<q> set = new HashSet<q>();
        for (final q q : y) {
            if (set.contains(q)) {
                continue;
            }
            set.add(q);
            if (!this.d(q)) {
                continue;
            }
            this.a(q, au);
            if (x) {
                break;
            }
        }
        int b = au.b();
        while (b-- > 0) {
            if (au.a(b).d().isEmpty()) {
                au.b(b);
                if (x) {
                    break;
                }
                continue;
            }
        }
    }
    
    private void a(final q q, final aU au) {
        final boolean x = N.x;
        final dg f = this.f(q);
        if (f == null) {
            return;
        }
        final q i = this.i(q);
        final bK a = this.a(q);
        final int n = (a != null) ? a.j() : 0;
        final bK b = this.b(q);
        final int n2 = (b != null) ? b.j() : 0;
        final int c = f.h.c();
        final int c2 = f.g.c();
        final D[] array = new D[c - c2 + 1];
        int c3 = Integer.MAX_VALUE;
        int c4 = Integer.MIN_VALUE;
        final y y = new y();
        final HashSet set = new HashSet<q>();
        final y y2 = new y();
        final HashSet set2 = new HashSet<q>();
        int n3 = c2;
        final int n4 = c + 1;
    Label_0796_Outer:
        while (true) {
            do {
                int j = 0;
            Label_0161:
                while (j < n4) {
                    array[n3 - c2] = new D();
                    final x a2 = au.a(n3).d().a();
                    if (x) {
                        final x x2 = a2;
                        while (x2.f()) {
                            if (this.d(x2.e())) {
                                this.a(x2.e(), au);
                            }
                            x2.g();
                            if (x) {
                                break;
                            }
                        }
                        return;
                    }
                    final x x3 = a2;
                    while (x3.f()) {
                        final q e = x3.e();
                        final bK h = this.c.a(e).h();
                        j = (this.a(e, q) ? 1 : 0);
                        if (x) {
                            continue Label_0161;
                        }
                        Label_0572: {
                            if (j != 0) {
                                array[n3 - c2].add(e);
                                if (!x) {
                                    break Label_0572;
                                }
                            }
                            if (h != null) {
                                final int k = h.j();
                                boolean b2 = false;
                                Label_0416: {
                                    if (n < k && n2 > k) {
                                        b2 = true;
                                        if (!x) {
                                            break Label_0416;
                                        }
                                    }
                                    if (n != n2) {
                                        final q l = this.i(e);
                                        if (l != null) {
                                            if (n == k) {
                                                final bK b3 = this.b(l);
                                                b2 |= (b3 != null && b3.j() > n);
                                            }
                                            if (n2 == k) {
                                                final bK a3 = this.a(l);
                                                b2 |= (a3 != null && a3.j() < n2);
                                            }
                                        }
                                    }
                                }
                                if (b2 && !set.contains(e)) {
                                    y.add(e);
                                    set.add(e);
                                    final q m = this.i(e);
                                    if (m != null && m != i && !set2.contains(m)) {
                                        y2.add(m);
                                        set2.add(m);
                                        final dg f2 = this.f(m);
                                        if (f2 != null) {
                                            if (c3 > f2.g.c()) {
                                                c3 = f2.g.c();
                                            }
                                            if (c4 < f2.h.c()) {
                                                c4 = f2.h.c();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        x3.g();
                        if (x) {
                            break;
                        }
                    }
                    ++n3;
                }
                break;
            } while (!x);
            Label_1460: {
                if (!y.isEmpty()) {
                    boolean b4 = false;
                    boolean b5 = false;
                    int n5 = Integer.MIN_VALUE;
                    int n6 = Integer.MAX_VALUE;
                    final HashSet set3 = new HashSet();
                    int n7 = 0;
                    while (true) {
                        while (n7 < array.length) {
                            set3.addAll(array[n7]);
                            ++n7;
                            if (x) {
                                final D[] array2 = new D[n7];
                                final D[] array3 = new D[n7];
                                int n8 = 0;
                                while (true) {
                                Label_1028:
                                    while (true) {
                                    Label_1367_Outer:
                                        while (n8 < n7) {
                                            array2[n8] = new D();
                                            array3[n8] = new D();
                                            ++n8;
                                            if (x) {
                                                int n14 = 0;
                                                Label_1273: {
                                                    Label_1267: {
                                                        if (b4 || b5) {
                                                            int n9 = 0;
                                                            while (true) {
                                                                while (n9 < array.length) {
                                                                    final int empty;
                                                                    final int n10 = empty = (array[n9].isEmpty() ? 1 : 0);
                                                                    if (x) {
                                                                        int n11 = empty;
                                                                        int n12 = 0;
                                                                        while (true) {
                                                                            while (n12 < array.length) {
                                                                                final int empty2;
                                                                                final int n13 = empty2 = (array[n12].isEmpty() ? 1 : 0);
                                                                                if (!x) {
                                                                                    Label_1250: {
                                                                                        if (n13 == 0) {
                                                                                            final aQ a4 = au.a((byte)0, n8 + n11);
                                                                                            final C m2 = array[n12].m();
                                                                                            while (m2.f()) {
                                                                                                a4.a((q)m2.d());
                                                                                                m2.g();
                                                                                                if (x) {
                                                                                                    break Label_1250;
                                                                                                }
                                                                                                if (x) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            ++n11;
                                                                                        }
                                                                                        ++n12;
                                                                                    }
                                                                                    if (x) {
                                                                                        break;
                                                                                    }
                                                                                    continue Label_0796_Outer;
                                                                                }
                                                                                else {
                                                                                    n14 = empty2;
                                                                                    if (x) {
                                                                                        break Label_1267;
                                                                                    }
                                                                                    break Label_1273;
                                                                                }
                                                                            }
                                                                            int empty2 = n11 + n8;
                                                                            continue Label_1367_Outer;
                                                                        }
                                                                    }
                                                                    Label_1138: {
                                                                        if (n10 == 0) {
                                                                            final aQ a5 = au.a(c2 + n9);
                                                                            final C m3 = array[n9].m();
                                                                            while (m3.f()) {
                                                                                a5.b((q)m3.d());
                                                                                m3.g();
                                                                                if (x) {
                                                                                    break Label_1138;
                                                                                }
                                                                                if (x) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                        ++n9;
                                                                    }
                                                                    if (x) {
                                                                        break;
                                                                    }
                                                                }
                                                                int empty = 0;
                                                                continue Label_1367_Outer;
                                                            }
                                                        }
                                                    }
                                                    n14 = c + 1;
                                                }
                                                int n15 = 0;
                                            Label_1367:
                                                while (true) {
                                                    aQ aq;
                                                    C m4;
                                                    C c5;
                                                    C c6;
                                                    Label_1364:Label_1401_Outer:Label_1450_Outer:
                                                    while (n15 < n7) {
                                                        aq = au.a((byte)0, n14 + n15);
                                                        m4 = array3[n15].m();
                                                        if (!x) {
                                                            c5 = m4;
                                                            while (true) {
                                                                while (c5.f()) {
                                                                    aq.a((q)c5.d());
                                                                    c5.g();
                                                                    if (!x) {
                                                                        if (x) {
                                                                            break;
                                                                        }
                                                                        continue Label_0796_Outer;
                                                                    }
                                                                    else {
                                                                        if (x) {
                                                                            break Label_1364;
                                                                        }
                                                                        continue Label_1367;
                                                                    }
                                                                }
                                                                ++n15;
                                                                continue Label_1401_Outer;
                                                            }
                                                        }
                                                    Label_1455:
                                                        while (true) {
                                                            Label_1447: {
                                                                while (true) {
                                                                    c6 = m4;
                                                                    while (c6.f()) {
                                                                        aq.a((q)c6.d());
                                                                        c6.g();
                                                                        if (!x) {
                                                                            if (x) {
                                                                                break;
                                                                            }
                                                                            continue Label_0796_Outer;
                                                                        }
                                                                        else {
                                                                            if (x) {
                                                                                break Label_1455;
                                                                            }
                                                                            break Label_1367;
                                                                        }
                                                                    }
                                                                    break Label_1447;
                                                                    if (n15 >= n7) {
                                                                        break Label_1455;
                                                                    }
                                                                    aq = au.a((byte)0, n8 + n15);
                                                                    if (!x) {
                                                                        array2[n15].m();
                                                                        continue Label_1450_Outer;
                                                                    }
                                                                    break;
                                                                }
                                                                break Label_1460;
                                                            }
                                                            ++n15;
                                                            continue Label_1367_Outer;
                                                        }
                                                        this.a(au);
                                                        break Label_1460;
                                                    }
                                                    n15 = 0;
                                                    continue Label_1367;
                                                }
                                            }
                                            if (x) {
                                                break;
                                            }
                                        }
                                        for (final q q2 : y2) {
                                            final boolean a6 = this.a(q2, set2);
                                            if (!x) {
                                                if (a6) {
                                                    continue Label_0796_Outer;
                                                }
                                                if (this.a(this.g(q2), c2, c)) {
                                                    this.a(q2, au, array2, c3);
                                                    if (!x) {
                                                        continue Label_0796_Outer;
                                                    }
                                                }
                                                this.a(q2, au, array3, c3);
                                                if (x) {
                                                    break;
                                                }
                                                continue Label_0796_Outer;
                                            }
                                            else {
                                                if (a6 && b5) {
                                                    final int n16 = n5 + n6;
                                                    n8 = ((n16 % 2 == 0) ? (n16 / 2) : (n16 / 2 + 1));
                                                    continue Label_1028;
                                                }
                                                if (b4) {
                                                    n8 = n5 + 1;
                                                    continue Label_1028;
                                                }
                                                if (b5) {
                                                    n8 = n6;
                                                    continue Label_1028;
                                                }
                                                n8 = c2;
                                                continue Label_1028;
                                            }
                                        }
                                        break;
                                    }
                                    continue;
                                }
                            }
                            if (x) {
                                break;
                            }
                        }
                        for (final q q3 : y) {
                            final q i2 = this.i(q3);
                            if (i2 == null || i2 == i) {
                                final int j2 = this.c.a(q3).j();
                                if (this.a(set3, q3)) {
                                    b4 = true;
                                    if (n5 >= j2) {
                                        continue Label_0796_Outer;
                                    }
                                    n5 = j2;
                                    if (!x) {
                                        continue Label_0796_Outer;
                                    }
                                }
                                b5 = true;
                                if (n6 <= j2) {
                                    continue Label_0796_Outer;
                                }
                                n6 = j2;
                                if (x) {
                                    break Label_1460;
                                }
                                if (x) {
                                    break;
                                }
                                continue Label_0796_Outer;
                            }
                        }
                        n7 = c4 - c3 + 1;
                        continue;
                    }
                }
            }
            this.h(q).a();
            continue;
        }
    }
    
    private boolean a(final Set set, final q q) {
        final boolean x = N.x;
        int n = 0;
        int n2 = 0;
        final int j = this.c.a(q).j();
        e e = q.k();
        while (true) {
            while (e.f()) {
                final q c = e.a().c();
                final boolean contains = set.contains(c);
                if (x) {
                    int contains2 = 0;
                    while (true) {
                        if (contains) {
                            final q d = e.a().d();
                            contains2 = (set.contains(d) ? 1 : 0);
                            if (!x) {
                                if (contains2 != 0) {
                                    if (this.c.a(d).j() >= j) {
                                        ++n2;
                                    }
                                }
                                e.g();
                                if (!x) {
                                    e.f();
                                    continue;
                                }
                            }
                        }
                        break;
                    }
                    return contains2 <= n2;
                }
                if (contains) {
                    if (this.c.a(c).j() <= j) {
                        ++n;
                    }
                }
                e.g();
                if (x) {
                    break;
                }
            }
            e = q.l();
            continue;
        }
    }
    
    private boolean a(final y y, final int n, final int n2) {
        final boolean x = N.x;
        int n3 = 0;
        int n4 = 0;
        final HashSet set = new HashSet(y);
        final x a = y.a();
        do {
            Label_0027: {
                a.f();
            }
            boolean contains = false;
            Label_0034:
        Label_0177_Outer:
            while (contains) {
                final int j = this.c.a(a.e()).j();
                if (!x) {
                    e e = a.e().k();
                    while (true) {
                        while (e.f()) {
                            final q c = e.a().c();
                            final boolean contains2 = set.contains(c);
                            if (x) {
                                while (true) {
                                    if (contains2) {
                                        final q d = e.a().d();
                                        contains = set.contains(d);
                                        if (x) {
                                            continue Label_0034;
                                        }
                                        if (!contains) {
                                            final int i = this.c.a(d).j();
                                            if (i <= n2 && i >= j) {
                                                ++n4;
                                            }
                                        }
                                        e.g();
                                        if (!x) {
                                            e.f();
                                            continue Label_0177_Outer;
                                        }
                                    }
                                    break;
                                }
                                a.g();
                                continue Label_0027;
                            }
                            if (!contains2) {
                                final int k = this.c.a(c).j();
                                if (k >= n && k <= j) {
                                    ++n3;
                                }
                            }
                            e.g();
                            if (x) {
                                break;
                            }
                        }
                        e = a.e().l();
                        continue;
                    }
                }
                return false;
            }
            break;
        } while (!x);
        if (n3 <= n4) {
            return true;
        }
        return false;
    }
    
    private void a(final q q, final aU au, final D[] array, final int n) {
        final boolean x = N.x;
        final x a = this.h(q).a();
        while (a.f()) {
            final q e = a.e();
            Label_0104: {
                if (this.d(e)) {
                    this.a(e, au, array, n);
                    if (!x) {
                        break Label_0104;
                    }
                }
                final int j = this.c.a(e).j();
                au.a(j).b(e);
                array[j - n].add(e);
            }
            a.g();
            if (x) {
                break;
            }
        }
    }
    
    private boolean a(final q q, final Set set) {
        final boolean x = N.x;
        q q2 = this.i(q);
        boolean contains = false;
        while (q2 != null) {
            contains = set.contains(q2);
            if (x) {
                return contains;
            }
            if (contains) {
                return true;
            }
            q2 = this.i(q2);
            if (x) {
                break;
            }
        }
        return contains;
    }
    
    bK a(final q q) {
        if (this.a()) {
            this.j(q);
            return ((bK[])this.n.get(q))[0];
        }
        return null;
    }
    
    bK b(final q q) {
        if (this.a()) {
            this.j(q);
            return ((bK[])this.n.get(q))[1];
        }
        return null;
    }
    
    private void j(final q q) {
        final boolean x = N.x;
        if (this.n.containsKey(q)) {
            return;
        }
        final bK[] array = { null, null };
        final x a = this.h(q).a();
        while (a.f()) {
            if (x) {
                return;
            }
            Label_0293: {
                if (this.d(a.e())) {
                    this.j(a.e());
                    final bK[] array2 = this.n.get(a.e());
                    if (array2[0] != null && (array[0] == null || array[0].j() > array2[0].j())) {
                        array[0] = array2[0];
                    }
                    if (array2[1] == null || (array[1] != null && array[1].j() >= array2[1].j())) {
                        break Label_0293;
                    }
                    array[1] = array2[1];
                    if (!x) {
                        break Label_0293;
                    }
                }
                bK h = this.c.a(a.e()).h();
                if (h == null) {
                    final Object b = this.d.b(a.e());
                    if (b instanceof bK) {
                        h = (bK)b;
                    }
                }
                if (h != null) {
                    if (array[0] == null || array[0].j() > h.j()) {
                        array[0] = h;
                    }
                    if (array[1] == null || array[1].j() < h.j()) {
                        array[1] = h;
                    }
                }
            }
            a.g();
            if (x) {
                break;
            }
        }
        this.n.put(q, array);
    }
    
    void g(final aU au) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        final float[] array = new float[this.b.e()];
        this.a(0, au.b());
        if (this.j.g == null || this.j.h == null) {
            return;
        }
        final int c = this.j.g.c();
        final int c2 = this.j.h.c();
        int i = c;
    Label_0218_Outer:
        while (i <= c2) {
            final y d = au.a(i).d();
            int n = 0;
            if (!x) {
                p p = d.k();
                while (true) {
                    while (p != null) {
                        array[((q)p.c()).d()] = n;
                        p = p.a();
                        ++n;
                        if (!x) {
                            if (x) {
                                break;
                            }
                            continue Label_0218_Outer;
                        }
                        else {
                            if (x) {
                                break Label_0218_Outer;
                            }
                            continue Label_0218_Outer;
                        }
                    }
                    this.j.a(i, array, this.d(), this.c, true);
                    this.j.a(i, true, this.d());
                    this.j.a(i, d.k());
                    ++i;
                    continue;
                }
            }
            return;
        }
        this.g();
    }
    
    void a(final c g) {
        this.g = g;
    }
    
    c d() {
        return this.g;
    }
    
    void a(final int n) {
        if (!this.k()) {
            return;
        }
        this.j.a(n);
    }
    
    void a(final D[] array, final int[] array2, final boolean b) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        final c d = this.d();
        final float[] array3 = new float[this.b.e()];
        int i = 0;
        Label_0125: {
            Label_0104: {
                Label_0068: {
                    if (b) {
                        i = 0;
                        while (i < array3.length) {
                            array3[i] = array2[i];
                            ++i;
                            if (x) {
                                break Label_0125;
                            }
                            if (x) {
                                break Label_0068;
                            }
                        }
                        break Label_0104;
                    }
                }
                i = 0;
                while (i < array3.length) {
                    array3[i] = this.o.nextFloat();
                    ++i;
                    if (x) {
                        break Label_0125;
                    }
                    if (x) {
                        break;
                    }
                }
            }
            this.a(0, array.length);
            i = this.j.g.c();
        }
        final int c = this.j.h.c();
        int j = i;
        while (j <= c) {
            final D d2 = array[j];
            this.j.a(j, array3, d, this.c, true);
            this.j.a(j, true, d);
            this.j.a(j, d2.k());
            this.a(d2, array2);
            ++j;
            if (x) {
                return;
            }
            if (x) {
                break;
            }
        }
        this.g();
    }
    
    void a(final int n, final int n2) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        final ArrayList d = this.j.d;
        int i = d.size() - 1;
        while (i >= 0) {
            final dg dg = d.get(i);
            if (dg.g != null && dg.h != null && dg.g.c() >= n && dg.h.c() <= n2) {
                dg.r = -1;
            }
            --i;
            if (x) {
                break;
            }
        }
    }
    
    private void a(final D d, final int[] array) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        int n = 0;
        p p2 = d.k();
        while (p2 != null) {
            array[((q)p2.c()).d()] = n;
            p2 = p2.a();
            ++n;
            if (x) {
                break;
            }
        }
    }
    
    void a(final D d, final int n, final float[] array, final int[] array2, final boolean b) {
        if (!this.k()) {
            return;
        }
        final c d2 = this.d();
        this.j.a(n, array, d2, this.c, b);
        this.j.a(n, b, d2);
        this.j.a(n, d.k());
        this.a(d, array2);
    }
    
    void e() {
        if (!this.k()) {
            return;
        }
        this.j.c();
    }
    
    void f() {
        this.j = null;
        if (this.f != null) {
            this.b.a(y.f.b.f.d, this.f);
        }
    }
    
    void a(final aU au, final aP ap) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        final HashMap<q, q> hashMap = new HashMap<q, q>();
        final HashMap<q, q> hashMap2 = new HashMap<q, q>();
        int n = 0;
        do {
            int i = 0;
            Label_0033: {
                i = n;
            }
            int b = au.b();
            Label_0041:
            while (i < b) {
                p p2 = au.a(n).d().k();
                while (p2 != null) {
                    final q q = (q)p2.c();
                    final aX a = this.c.a(q);
                    a.b();
                    final byte b2 = (byte)(i = a.b());
                    final int n2 = b = 12;
                    if (x) {
                        continue Label_0041;
                    }
                    if (b2 == n2) {
                        final q f = a.f();
                        final q q2 = hashMap.get(f);
                        if (q2 != null && q2.a(q) == null) {
                            ap.a(q2, q);
                        }
                        hashMap.put(f, q);
                    }
                    if (a.b() == 13) {
                        final q f2 = a.f();
                        final q q3 = hashMap2.get(f2);
                        if (q3 != null && q3.a(q) == null) {
                            ap.a(q3, q);
                        }
                        hashMap2.put(f2, q);
                    }
                    p2 = p2.a();
                    if (x) {
                        break;
                    }
                }
                ++n;
                continue Label_0033;
            }
            break;
        } while (!x);
    }
    
    void b(final aU au, final aP ap) {
        if (!this.k()) {
            return;
        }
        this.g();
        this.j.a(au, ap);
    }
    
    void g() {
        final boolean x = N.x;
        this.j.b();
        final Iterator<dg> iterator = this.j.d.iterator();
        while (iterator.hasNext()) {
            iterator.next().b();
            if (x) {
                break;
            }
        }
    }
    
    void h(final aU au) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        int n = 0;
        while (true) {
            do {
                int i = 0;
                Label_0015: {
                    i = n;
                }
                int b = au.b();
                Label_0022:
                while (i < b) {
                    final aQ a = au.a(n);
                    final y d = a.d();
                    if (!x) {
                        p p = d.k();
                        while (p != null) {
                            final byte b2 = this.c.a((q)p.c()).b();
                            final int n2 = i = b2;
                            final int n3 = b = 12;
                            if (x) {
                                continue Label_0022;
                            }
                            if (n2 == n3 || b2 == 13) {
                                d.h(p);
                            }
                            p = p.a();
                            if (x) {
                                break;
                            }
                        }
                        a.a(d);
                        ++n;
                        continue Label_0015;
                    }
                    final x o = this.b.o();
                    while (o.f()) {
                        final q e = o.e();
                        final byte b3 = this.c.a(e).b();
                        if (b3 == 12 || b3 == 13) {
                            this.b.a(e);
                        }
                        o.g();
                        if (x) {
                            break;
                        }
                    }
                    return;
                }
                break;
            } while (!x);
            this.j.b(this.c);
            continue;
        }
    }
    
    r c(final q q) {
        if (!this.k()) {
            return null;
        }
        r a = null;
        final c c = this.b.c(y.f.b.f.e);
        if (c != null) {
            a = r.a(c.b(q));
        }
        if (a == null) {
            a = new r(0.0, 0.0, 0.0, 0.0);
        }
        return a;
    }
    
    void a(final cr cr, final aQ aq, final boolean b, final double n) {
        if (!this.k()) {
            return;
        }
        this.j.a(cr, aq, b, n);
    }
    
    void b(final cr cr, final aQ aq, final boolean b, final double n) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        final y.d.c c = cr.c();
        p p4 = aq.d().k();
        while (p4 != null) {
            final q q = (q)p4.c();
            final aX a = this.c.a(q);
            Label_0273: {
                if (a.b() == 12) {
                    final dg f = this.f(a.l());
                    if (cr.b(f)) {
                        final double d = cr.d(f);
                        final r c2 = this.c(f.f);
                        if (b && f.A == aq) {
                            final double e = d;
                            f.x = this.b.n(q) + n - e;
                            f.E = e;
                            if (c == null) {
                                break Label_0273;
                            }
                            final cy a2 = cr.a(f);
                            c.b(a2.b, a2.c, e + c2.a);
                            if (!x) {
                                break Label_0273;
                            }
                        }
                        if (!b && f.B == aq) {
                            final double n2 = d;
                            f.F = n2 + n;
                            f.y = n2 - n - this.b.n(q);
                            if (c != null) {
                                final cy a3 = cr.a(f);
                                c.b(a3.b, a3.c, n2);
                            }
                        }
                    }
                }
            }
            p4 = p4.a();
            if (x) {
                break;
            }
        }
    }
    
    public double h() {
        return this.k;
    }
    
    public void a(final double k) {
        this.k = k;
    }
    
    void i(final aU au) {
        if (this.k()) {
            this.j.a(au, this.c);
        }
    }
    
    void j(final aU au) {
        if (this.k()) {
            this.j.b(au, this.c);
        }
    }
    
    void b(final aU au, final A a) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        x x2 = this.b.o();
        while (true) {
            while (x2.f()) {
                q q = x2.e();
                aX ax = this.c.a(q);
                final byte b = ax.b();
                final byte b2 = 12;
                if (x) {
                    while (true) {
                        if (b == b2 || ax.b() == 13) {
                            final dg f = this.f(ax.l());
                            if (f.g != null && f.h != null && f.g.c() <= ax.j() && f.h.c() >= ax.j()) {
                                a.a(q, false);
                            }
                        }
                        x2.g();
                        if (!x) {
                            if (x2.f()) {
                                q = x2.e();
                                ax = this.c.a(q);
                                ax.b();
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                if (b == b2 || ax.b() == 13) {
                    a.a(q, true);
                }
                x2.g();
                if (x) {
                    break;
                }
            }
            this.a(au, a);
            this.c(au);
            x2 = this.b.o();
            continue;
        }
    }
    
    public void k(final aU au) {
        if (!this.k()) {
            return;
        }
        this.j.a(au);
    }
    
    public boolean d(final q q) {
        return this.k() && this.j.c.b(q) != null;
    }
    
    void c(final aU au, final aP ap) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        this.c();
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        final y y = new y();
        final e p2 = this.b.p();
        while (true) {
            while (p2.f()) {
                final d a = p2.a();
                final y.f.c.a.A a2 = this.c.a(a);
                final q c = a.c();
                final q d = a.d();
                final E e = this;
                if (x) {
                    final y.d.q l = e.l();
                    if (l != null) {
                        final double n = l.a * 0.5;
                        final A a3 = (A)this.b.c(cp.a);
                        final A a4 = (A)this.b.c(cp.b);
                        final x a5 = y.a();
                        while (a5.f()) {
                            final q e2 = a5.e();
                            a3.a(e2, n);
                            a4.a(e2, n);
                            a5.g();
                            if (x) {
                                break;
                            }
                        }
                    }
                    return;
                }
                if (this.d(c)) {
                    q a6 = null;
                    Object o = null;
                    if (a2.g() != null) {
                        o = new L(this, c, a2.g());
                        if (o != null) {
                            a6 = hashMap.get(o);
                        }
                    }
                    Label_0889: {
                        if (a6 == null) {
                            final q q = c;
                            final q q2 = d;
                            final dg f = this.f(q);
                            final aQ g = f.g;
                            final aQ h = f.h;
                            final aX a7 = this.c.a(q2);
                            if (a7 != null) {
                                final aE ae = (a2.c() != null && !a2.c().g()) ? a2.c() : null;
                                if (ae != null) {
                                    ap.a(a, true, aE.a(ae.b()));
                                }
                                aQ aq = null;
                                Label_0804: {
                                    if (ae != null && ae.c()) {
                                        aq = g;
                                        if (!x) {
                                            break Label_0804;
                                        }
                                    }
                                    if (ae != null && ae.d()) {
                                        aq = h;
                                        if (!x) {
                                            break Label_0804;
                                        }
                                    }
                                    if (!this.d(q2)) {
                                        if (g.c() > a7.j()) {
                                            aq = g;
                                            if (!x) {
                                                break Label_0804;
                                            }
                                        }
                                        if (h.c() < a7.j()) {
                                            aq = h;
                                            if (!x) {
                                                break Label_0804;
                                            }
                                        }
                                        if (ae == null && this.a(q2, q)) {
                                            aq = h;
                                            ap.a(a, true, aE.a((byte)2));
                                            if (((a2.e() != null && !a2.e().g()) ? a2.e() : null) != null) {
                                                break Label_0804;
                                            }
                                            ap.a(a, false, aE.a((byte)1));
                                            if (!x) {
                                                break Label_0804;
                                            }
                                        }
                                        aq = au.a(a7.j());
                                        if (!x) {
                                            break Label_0804;
                                        }
                                    }
                                    final dg f2 = this.f(q2);
                                    if (this.a(q2, q) || this.a(q, f2.f)) {
                                        aq = h;
                                        if (ae != null) {
                                            break Label_0804;
                                        }
                                        ap.a(a, true, aE.a((byte)2));
                                        if (!x) {
                                            break Label_0804;
                                        }
                                    }
                                    if (q == f2.f) {
                                        final aE ae2 = (a2.e() != null && !a2.e().g()) ? a2.e() : null;
                                        Label_0641: {
                                            if (ae != null && ae2 != null && ae2.d() && (ae.e() || ae.f())) {
                                                aq = h;
                                                if (!x) {
                                                    break Label_0641;
                                                }
                                            }
                                            aq = g;
                                        }
                                        if (ae != null) {
                                            break Label_0804;
                                        }
                                        ap.a(a, true, aE.a((byte)2));
                                        if (!x) {
                                            break Label_0804;
                                        }
                                    }
                                    if (g.c() > f2.h.c()) {
                                        aq = g;
                                        if (!x) {
                                            break Label_0804;
                                        }
                                    }
                                    if (h.c() < f2.g.c()) {
                                        aq = h;
                                        if (!x) {
                                            break Label_0804;
                                        }
                                    }
                                    final int max = Math.max(g.c(), f2.g.c());
                                    final int min = Math.min(h.c(), f2.h.c());
                                    if (min < max) {
                                        throw new IllegalStateException("huh?");
                                    }
                                    aq = au.a((max + min) / 2);
                                }
                                a6 = ap.a(q, f, aq, a);
                                if (o != null) {
                                    hashMap.put(o, a6);
                                }
                                y.add(a6);
                                this.j.a((Object)a6, f);
                                if (!x) {
                                    break Label_0889;
                                }
                            }
                            throw new IllegalStateException("nodeData == null for node " + q2);
                        }
                    }
                    final t p3 = this.b.p(a);
                    this.b.a(a, a6, a.d());
                    this.b.a(a6, p3);
                    this.b.a(a, t.c);
                }
                if (this.d(d)) {
                    q a8 = null;
                    Object o2 = null;
                    if (a2.h() != null) {
                        o2 = new L(this, d, a2.h());
                        if (o2 != null) {
                            a8 = hashMap.get(o2);
                        }
                    }
                    Label_1715: {
                        if (a8 == null) {
                            final q q3 = d;
                            final q q4 = c;
                            final dg f3 = this.f(q3);
                            final aQ g2 = f3.g;
                            final aQ h2 = f3.h;
                            final aX a9 = this.c.a(q4);
                            if (a9 != null) {
                                final aE ae3 = (a2.e() != null && !a2.e().g()) ? a2.e() : null;
                                if (ae3 != null) {
                                    ap.a(a, false, aE.a(ae3.b()));
                                }
                                aQ aq2;
                                if (ae3 != null && ae3.c()) {
                                    aq2 = g2;
                                }
                                else if (ae3 != null && ae3.d()) {
                                    aq2 = h2;
                                }
                                else if (!this.d(q4)) {
                                    if (g2.c() > a9.j()) {
                                        aq2 = g2;
                                    }
                                    else if (h2.c() < a9.j()) {
                                        aq2 = h2;
                                    }
                                    else if (ae3 == null && this.a(q4, q3)) {
                                        aq2 = g2;
                                        if (((a2.c() != null && !a2.c().g()) ? a2.c() : null) == null) {
                                            ap.a(a, true, aE.a((byte)2));
                                        }
                                        ap.a(a, false, aE.a((byte)1));
                                    }
                                    else {
                                        aq2 = au.a(a9.j());
                                    }
                                }
                                else {
                                    final dg f4 = this.f(q4);
                                    if (this.a(q4, q3) || this.a(q3, f4.f)) {
                                        aq2 = g2;
                                        if (ae3 == null) {
                                            ap.a(a, false, aE.a((byte)1));
                                        }
                                    }
                                    else if (q3 == f4.f) {
                                        final aE ae4 = (a2.c() != null && !a2.c().g()) ? a2.c() : null;
                                        if (ae4 != null && ae3 != null && ae4.d() && (ae3.e() || ae3.f())) {
                                            aq2 = h2;
                                        }
                                        else {
                                            aq2 = g2;
                                        }
                                        if (ae3 == null) {
                                            ap.a(a, false, aE.a((byte)1));
                                        }
                                    }
                                    else if (g2.c() > f4.h.c()) {
                                        aq2 = g2;
                                    }
                                    else if (h2.c() < f4.g.c()) {
                                        aq2 = h2;
                                    }
                                    else {
                                        final int max2 = Math.max(g2.c(), f4.g.c());
                                        final int min2 = Math.min(h2.c(), f4.h.c());
                                        if (min2 < max2) {
                                            throw new IllegalStateException("huh?");
                                        }
                                        aq2 = au.a((max2 + min2) / 2);
                                    }
                                }
                                a8 = ap.a(q3, f3, aq2, a);
                                if (o2 != null) {
                                    hashMap.put(o2, a8);
                                }
                                y.add(a8);
                                this.j.a((Object)a8, f3);
                                if (!x) {
                                    break Label_1715;
                                }
                            }
                            throw new IllegalStateException("nodeData == null for node " + q4);
                        }
                    }
                    final t q5 = this.b.q(a);
                    this.b.a(a, a.c(), a8);
                    this.b.a(a8, q5);
                    this.b.b(a, t.c);
                }
                p2.g();
                if (x) {
                    break;
                }
            }
            this.b();
            final E e = this;
            continue;
        }
    }
    
    private y.d.q l() {
        final c c = this.b.c(N.u);
        if (c == null) {
            return null;
        }
        return (y.d.q)c.b(this.b);
    }
    
    private boolean a(final q q, final d d, final aV av) {
        return this.a(q, d, av, (byte)8);
    }
    
    private boolean b(final q q, final d d, final aV av) {
        return this.a(q, d, av, (byte)4);
    }
    
    private boolean a(final q q, final d d, final aV av, final byte b) {
        final boolean b2 = q == d.c();
        final y.f.c.a.A a = av.a(d);
        final aE ae = b2 ? a.c() : a.e();
        return ae != null && ae.b() == b;
    }
    
    private q a(final q q, final D d, final aV av) {
        final q q2 = (q)d.f();
        if (av.a(q2).b() == 12) {
            return q2;
        }
        return this.a(q, d, av, (byte)12);
    }
    
    private q b(final q q, final D d, final aV av) {
        final q q2 = (q)d.i();
        if (av.a(q2).b() == 13) {
            return q2;
        }
        return this.a(q, d, av, (byte)13);
    }
    
    private q a(final q q, final D d, final aV av, final byte b) {
        final boolean x = N.x;
        p p4 = d.k();
        while (p4 != null) {
            if (p4.c() instanceof q) {
                final q q2 = (q)p4.c();
                final aX a = av.a(q2);
                if (a.l() == q && a.b() == b) {
                    return q2;
                }
            }
            p4 = p4.a();
            if (x) {
                break;
            }
        }
        return null;
    }
    
    void i() {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        final C m = this.h.m();
        while (m.f()) {
            y.f.c.a.M.a((y.f.c.a.M)m.d());
            m.g();
            if (x) {
                break;
            }
        }
    }
    
    void a(final X x, final aV av) {
        final boolean x2 = N.x;
        this.a.clear();
        final e p2 = x.p();
        while (p2.f()) {
            final d a = p2.a();
            final y.f.c.a.A a2 = av.a(a);
            final aX a3 = av.a(a.c());
            final aX a4 = av.a(a.d());
            final aE c = a2.c();
            if (a3.b() == 15 && a4.b() == a3.b() && a3.l() == a4.l() && c != null && c == a2.e() && (c.e() || c.f())) {
                this.a.add(a);
                x.d(a);
            }
            p2.g();
            if (x2) {
                break;
            }
        }
    }
    
    private double a(final d d) {
        final boolean x = N.x;
        final B k = this.c.a(d).k();
        final double n = (k != null) ? Math.max(k.a(), k.b()) : 15.0;
        double max = 0.0;
        final y.f.C[] d2 = this.b.d((Object)d);
        double d3 = 0.0;
        Label_0119: {
            Label_0116: {
                if (d2 != null) {
                    int i = 0;
                    while (i < d2.length) {
                        max = Math.max(max, d2[i].getBox().a());
                        ++i;
                        if (x) {
                            break Label_0116;
                        }
                        if (x) {
                            break;
                        }
                    }
                }
                if (k != null) {
                    d3 = k.d();
                    break Label_0119;
                }
            }
            d3 = 5.0;
        }
        final double n2 = d3;
        final y.d.q l = this.l();
        return ((l != null) ? (l.a * 0.5) : 0.0) + n2 + Math.max(max, n);
    }
    
    private double a(final d d, final q q) {
        double n = 0.0;
        final B k = this.c.a(d).k();
        Label_0085: {
            if (k != null) {
                final boolean i = this.c.a(d).i();
                if ((d.c() == q && !i) || (d.d() == q && i)) {
                    n = k.a();
                    if (!N.x) {
                        break Label_0085;
                    }
                }
                n = k.b();
            }
        }
        final double n2 = (k != null) ? k.d() : 5.0;
        final y.d.q l = this.l();
        return ((l != null) ? (l.a * 0.5) : 0.0) + n2 + n;
    }
    
    void a(final aU au, final cd cd) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        this.h.clear();
        final A a = (A)this.b.c(cp.a);
        final A a2 = (A)this.b.c(cp.b);
        final e a3 = this.a.a();
        while (true) {
            while (a3.f()) {
                final d a4 = a3.a();
                this.b.e(a4);
                final q c = a4.c();
                final aX a5 = this.c.a(c);
                final q d = a4.d();
                final aX a6 = this.c.a(d);
                final int a7 = this.a(c, a4, this.c) ? 1 : 0;
                final q f = a5.f();
                final da b = this.f(f).b(a5.j());
                final int n2;
                final int n = n2 = a7;
                if (x) {
                    int n3 = n2;
                    do {
                        int i = 0;
                        Label_0570: {
                            i = n3;
                        }
                        int b2 = au.b();
                        Label_0578:
                        while (i < b2) {
                            final aQ a8 = au.a(n3);
                            p p2 = a8.d().k();
                        Label_1466:
                            while (true) {
                                while (p2 != null) {
                                    final q q = (q)p2.c();
                                    final aX a9 = this.c.a(q);
                                    final byte b3 = (byte)(i = a9.b());
                                    final int n4 = b2 = 15;
                                    if (x) {
                                        continue Label_0578;
                                    }
                                    Label_1452: {
                                        if (b3 == n4) {
                                            final as as = (as)a9;
                                            final e j = q.j();
                                            while (j.f()) {
                                                final d a10 = j.a();
                                                final boolean a11 = this.a(q, a10, this.c);
                                                final boolean b4 = this.b(q, a10, this.c);
                                                final boolean b5 = a11;
                                                if (x) {
                                                    break Label_1466;
                                                }
                                                if (b5 || b4) {
                                                    final q f2 = as.f();
                                                    final da b6 = this.f(f2).b(as.j());
                                                    final q q2 = a11 ? this.a(f2, b6, this.c) : this.b(f2, b6, this.c);
                                                    this.h.add(new y.f.c.a.M(this, a10, q, q2));
                                                    Label_0867: {
                                                        if (a10.c() == q) {
                                                            this.b.a(a10, q2, a10.d());
                                                            if (!x) {
                                                                break Label_0867;
                                                            }
                                                        }
                                                        this.b.a(a10, a10.c(), q2);
                                                    }
                                                    this.c.a(a10).k();
                                                    Label_0959: {
                                                        if (a11) {
                                                            a.a(q2, Math.max(a.c(q2), this.a(a10, q)));
                                                            if (!x) {
                                                                break Label_0959;
                                                            }
                                                        }
                                                        a2.a(q2, Math.max(a2.c(q2), this.a(a10, q)));
                                                    }
                                                    if (q.a() == 0 && a9.e() == 0) {
                                                        this.b.c(q);
                                                        a8.d().h(p2);
                                                        this.f(as.l()).b(as.j()).remove(q);
                                                    }
                                                }
                                                j.g();
                                                if (x) {
                                                    break;
                                                }
                                            }
                                            p p3 = a9.d();
                                            while (p3 != null) {
                                                final d d2 = (d)p3.c();
                                                final boolean a12 = this.a(q, d2, this.c);
                                                final boolean b7 = this.b(q, d2, this.c);
                                                final boolean b8 = a12;
                                                if (x) {
                                                    break Label_1466;
                                                }
                                                if (b8 || b7) {
                                                    final q f3 = as.f();
                                                    final da b9 = this.f(f3).b(as.j());
                                                    final q q3 = a12 ? this.a(f3, b9, this.c) : this.b(f3, b9, this.c);
                                                    ((as)this.c.a(q3)).a(d2);
                                                    as.a(p3);
                                                    this.h.add(new y.f.c.a.M(this, d2, q, q3));
                                                    Label_1288: {
                                                        if (d2.c() == q) {
                                                            this.b.a(d2, q3, d2.d());
                                                            if (!x) {
                                                                break Label_1288;
                                                            }
                                                        }
                                                        this.b.a(d2, d2.c(), q3);
                                                    }
                                                    Label_1362: {
                                                        if (a12) {
                                                            a.a(q3, Math.max(a.c(q3), this.a(d2, q)));
                                                            if (!x) {
                                                                break Label_1362;
                                                            }
                                                        }
                                                        a2.a(q3, Math.max(a2.c(q3), this.a(d2, q)));
                                                    }
                                                    if (q.a() == 0 && a9.e() == 0) {
                                                        this.b.c(q);
                                                        a8.d().h(p2);
                                                        this.f(as.l()).b(as.j()).remove(q);
                                                    }
                                                }
                                                p3 = p3.a();
                                                if (x) {
                                                    break;
                                                }
                                            }
                                            break Label_1452;
                                            boolean b5 = false;
                                            if (b5) {
                                                a8.a(a8.d());
                                            }
                                            ++n3;
                                            continue Label_0570;
                                        }
                                    }
                                    p2 = p2.a();
                                    if (x) {
                                        break;
                                    }
                                }
                                continue Label_1466;
                            }
                        }
                        break;
                    } while (!x);
                    return;
                }
                final q q4 = (n != 0) ? this.a(f, b, this.c) : this.b(f, b, this.c);
                this.h.add(new y.f.c.a.M(this, a4, c, q4));
                this.h.add(new y.f.c.a.M(this, a4, d, q4));
                this.b.a(a4, q4, q4);
                final aQ a13 = au.a(a5.j());
                if (c.a() == 0 && a5.e() == 0) {
                    this.b.c(c);
                    a13.d().remove(c);
                    this.f(a5.l()).b(a5.j()).remove(c);
                }
                a13.a(a13.d());
                final aQ a14 = au.a(a6.j());
                if (d.a() == 0 && a6.e() == 0) {
                    this.b.c(d);
                    a14.d().remove(d);
                    this.f(a6.l()).b(a6.j()).remove(d);
                }
                a14.a(a14.d());
                Label_0545: {
                    if (a7 != 0) {
                        a.a(q4, Math.max(a.c(q4), this.a(a4)));
                        if (!x) {
                            break Label_0545;
                        }
                    }
                    a2.a(q4, Math.max(a2.c(q4), this.a(a4)));
                }
                cd.a(this.b, a4);
                a3.g();
                if (x) {
                    break;
                }
            }
            int n2 = 0;
            continue;
        }
    }
    
    void a(final X x) {
        final boolean x2 = N.x;
        if (!this.k()) {
            return;
        }
        final e p = x.p();
        while (p.f()) {
            final d a = p.a();
            final q q = (q)this.l.b(a);
            if (q != null) {
                if (!x.f(q)) {
                    x.d(q);
                }
                final t p2 = x.p(a);
                x.a(q, x.l(a.c()));
                x.a(a, q, a.d());
                x.c(a, p2);
            }
            final q q2 = (q)this.m.b(a);
            if (q2 != null) {
                if (!x.f(q2)) {
                    x.d(q2);
                }
                final t q3 = x.q(a);
                x.a(q2, x.l(a.d()));
                x.a(a, a.c(), q2);
                x.d(a, q3);
            }
            p.g();
            if (x2) {
                break;
            }
        }
    }
    
    void l(final aU au) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        int n = 0;
    Label_0799:
        do {
        Label_0791:
            while (true) {
                au.b();
                int i = 0;
                int k = 0;
            Label_0022:
                while (i < k) {
                    final aQ a = au.a(n);
                    D b = null;
                    boolean b2 = false;
                    if (x) {
                        return;
                    }
                    p p = a.d().k();
                    while (p != null) {
                        final q q = (q)p.c();
                        final aX a2 = this.c.a(q);
                        final byte b4;
                        final byte b3 = b4 = a2.b();
                        final int n3;
                        final int n2 = n3 = 15;
                        if (x) {
                            continue Label_0022;
                        }
                        Label_0696: {
                            if (b3 == n2) {
                                p p2 = a2.d();
                                if (p2 != null) {
                                    final ar ar = (ar)a2;
                                    final dg f = this.f(ar.l());
                                    final d d = (d)p2.c();
                                    final y.f.c.a.A a3 = this.c.a(d);
                                    final aE ae = (d.c() == q) ? a3.c() : a3.e();
                                    final as as = (as)this.c.a(d.a(q));
                                    if (as.l() != f.f && as.b() != 8 && as.b() != 9) {
                                        if (ae != null) {
                                            if (ae.c()) {
                                                break Label_0696;
                                            }
                                            if (ae.d()) {
                                                break Label_0696;
                                            }
                                        }
                                        if (a3.a() != 4) {
                                            if (f.g.c() == ar.j() && a3.j()) {
                                                break Label_0696;
                                            }
                                            if (f.h.c() == ar.j() && !a3.j()) {
                                                break Label_0696;
                                            }
                                        }
                                        b = f.b(ar.j());
                                        final q q2 = (q)b.f();
                                        final q q3 = (q)b.i();
                                        final as as2 = (as)this.c.a(q2);
                                        final as as3 = (as)this.c.a(q3);
                                        while (p2 != null) {
                                            final d d2 = (d)p2.c();
                                            final as as4 = (as)this.c.a(d2.a(q));
                                            i = as4.k();
                                            k = as2.k();
                                            if (x) {
                                                continue Label_0022;
                                            }
                                            q q4;
                                            as as5;
                                            if (i < k) {
                                                q4 = q2;
                                                as5 = as2;
                                            }
                                            else if (as4.k() > as3.k()) {
                                                q4 = q3;
                                                as5 = as3;
                                            }
                                            else if (ar.k() > as4.k()) {
                                                q4 = q3;
                                                as5 = as3;
                                            }
                                            else {
                                                q4 = q2;
                                                as5 = as2;
                                            }
                                            as5.a(d2);
                                            ar.a(p2);
                                            Label_0636: {
                                                if (d2.c() == q) {
                                                    this.b.a(d2, q4, d2.d());
                                                    this.l.a(d2, q);
                                                    if (!x) {
                                                        break Label_0636;
                                                    }
                                                }
                                                this.b.a(d2, d2.c(), q4);
                                                this.m.a(d2, q);
                                            }
                                            p2 = p2.a();
                                            if (x) {
                                                break;
                                            }
                                        }
                                        if (q.a() == 0 && ar.e() == 0) {
                                            this.b.c(q);
                                            a.d().h(p);
                                            b.remove(q);
                                            b2 = true;
                                        }
                                    }
                                }
                            }
                        }
                        p = p.a();
                        if (x) {
                            break;
                        }
                    }
                    if (b2) {
                        a.a(a.d());
                        p p3 = b.k();
                        while (p3 != null) {
                            final boolean b5 = p3.c() instanceof q;
                            if (x) {
                                continue Label_0791;
                            }
                            if (b5 && ((q)p3.c()).e() == null) {
                                b.h(p3);
                            }
                            p3 = p3.a();
                            if (x) {
                                break;
                            }
                        }
                        break Label_0791;
                    }
                    break Label_0791;
                }
                break Label_0799;
            }
            ++n;
        } while (!x);
        this.m(au);
    }
    
    void m(final aU au) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        this.j.c(au, this.c);
        int i = 0;
        while (i < au.b()) {
            final y d = au.a(i).d();
            this.j.a(i, d.k());
            au.a(i).a(d);
            ++i;
            if (x) {
                break;
            }
        }
    }
    
    void j() {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        final boolean b = false;
        final x o = this.b.o();
        do {
            Label_0023: {
                o.f();
            }
            boolean b2 = false;
            Label_0029:
            while (b2) {
                final q e = o.e();
                final aX a = this.c.a(e);
                a.b();
                Label_0060:
                Label_0747: {
                Label_0248_Outer:
                    while (true) {
                        Label_0414: {
                            final byte a2;
                            final byte b3;
                            if (a2 == b3) {
                                e e2 = new f(e.k()).a();
                                while (true) {
                                    while (e2.f()) {
                                        final d a3 = e2.a();
                                        this.c.a(a3);
                                        final dg f = this.f(a.l());
                                        final q f2 = f.f;
                                        final Rectangle2D w = f.w;
                                        final D m = this.b.m(a3);
                                        final boolean b4 = b;
                                        if (!x) {
                                            if (!b4) {
                                                this.a(m, false, true, new y.d.y(w.getX(), w.getY(), w.getWidth(), w.getHeight()));
                                            }
                                            this.b.a(a3, a3.c(), f2);
                                            this.b.a(a3, m);
                                            e2.g();
                                            if (x) {
                                                break;
                                            }
                                            continue Label_0248_Outer;
                                        }
                                        else {
                                            while (true) {
                                                if (b4) {
                                                    final d a4 = e2.a();
                                                    this.c.a(a4);
                                                    final dg f3 = this.f(a.l());
                                                    final q f4 = f3.f;
                                                    final D i = this.b.m(a4);
                                                    final Rectangle2D w2 = f3.w;
                                                    this.b.a(a4, f4, a4.d());
                                                    b2 = b;
                                                    if (x) {
                                                        continue Label_0029;
                                                    }
                                                    if (!b2) {
                                                        this.a(i, true, false, new y.d.y(w2.getX(), w2.getY(), w2.getWidth(), w2.getHeight()));
                                                    }
                                                    this.b.a(a4, i);
                                                    e2.g();
                                                    if (!x) {
                                                        e2.f();
                                                        continue Label_0248_Outer;
                                                    }
                                                }
                                                break;
                                            }
                                            this.b.a(e);
                                            if (x) {
                                                break Label_0414;
                                            }
                                            break Label_0747;
                                        }
                                    }
                                    e2 = new f(e.l()).a();
                                    continue;
                                }
                            }
                        }
                        if (a.b() == 12 || a.b() == 13) {
                            final e a5 = new f(e.j()).a();
                            while (a5.f()) {
                                final d a6 = a5.a();
                                this.c.a(a6.a(e));
                                final byte a2 = this.c.a(a6).a();
                                final byte b3 = 6;
                                if (x) {
                                    continue Label_0060;
                                }
                                Label_0735: {
                                    if (a2 != b3) {
                                        final dg f5 = this.f(a.l());
                                        final q f6 = f5.f;
                                        if (a6.d() == e) {
                                            final D j = this.b.m(a6);
                                            final Rectangle2D w3 = f5.w;
                                            if (!b) {
                                                this.a(j, false, true, new y.d.y(w3.getX(), w3.getY(), w3.getWidth(), w3.getHeight()));
                                            }
                                            this.b.a(a6, a6.c(), f6);
                                            this.b.a(a6, j);
                                            if (!x) {
                                                break Label_0735;
                                            }
                                        }
                                        if (a6.c() == e) {
                                            final D k = this.b.m(a6);
                                            final Rectangle2D w4 = f5.w;
                                            this.b.a(a6, f6, a6.d());
                                            if (!b) {
                                                this.a(k, true, false, new y.d.y(w4.getX(), w4.getY(), w4.getWidth(), w4.getHeight()));
                                            }
                                            this.b.a(a6, k);
                                        }
                                    }
                                }
                                a5.g();
                                if (x) {
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                }
                o.g();
                continue Label_0023;
            }
            break;
        } while (!x);
    }
    
    void n(final aU au) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        int i = 0;
        while (true) {
            while (i < au.b()) {
                final E e = this;
                if (x) {
                    final y.d.q l = e.l();
                    if (l != null) {
                        final x o = this.b.o();
                        while (o.f()) {
                            final q e2 = o.e();
                            final byte b = this.c.a(e2).b();
                            byte b2 = 0;
                        Label_0112:
                            while (b == b2 || b == 13) {
                                int n = 0;
                                final e j = e2.j();
                                while (j.f()) {
                                    final byte a = this.c.a(j.a()).a();
                                    b2 = 6;
                                    if (x) {
                                        continue Label_0112;
                                    }
                                    if (a != b2) {
                                        ++n;
                                    }
                                    j.g();
                                    if (x) {
                                        break;
                                    }
                                }
                                this.b.a(e2, new y.d.q(this.b.p(e2), Math.max(n * l.b, this.b.q(e2))));
                                break;
                            }
                            o.g();
                            if (x) {
                                break;
                            }
                        }
                    }
                    return;
                }
                this.j.a(au.a(i), this.b);
                ++i;
                if (x) {
                    break;
                }
            }
            final E e = this;
            continue;
        }
    }
    
    void o(final aU au) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        int n = 0;
        do {
            int i = 0;
        Label_0016:
            while (i < au.b()) {
                final aQ a = au.a(n);
                int n2 = 0;
                p p = a.d().k();
                while (p != null) {
                    final aX a2 = this.c.a((q)p.c());
                    i = ((a2 instanceof as) ? 1 : 0);
                    if (x) {
                        continue Label_0016;
                    }
                    if (i != 0) {
                        ((as)a2).b(n2);
                    }
                    p = p.a();
                    ++n2;
                    if (x) {
                        break;
                    }
                }
                ++n;
            }
            break;
        } while (!x);
    }
    
    void a(final D d, final boolean b, final boolean b2, final y.d.y y) {
        final boolean x = N.x;
        if (d.size() < 2) {
            return;
        }
        final D d2 = new D(d.m());
        boolean a = false;
        Label_0111: {
            if (b) {
                t t = null;
                t t2 = null;
                while (!d.isEmpty()) {
                    a = y.a((t)d.f());
                    if (!x) {
                        if (a) {
                            t = (t)d.g();
                            if (!x) {
                                continue;
                            }
                        }
                        t2 = (t)d.f();
                        break;
                    }
                    break Label_0111;
                }
                if (t != null) {
                    d.a(this.a(t, t2, y));
                }
            }
        }
        int a2 = 0;
        Label_0197: {
            if (a) {
                t t3 = null;
                t t4 = null;
                while (!d.isEmpty()) {
                    a2 = (y.a((t)d.i()) ? 1 : 0);
                    if (!x) {
                        if (a2 != 0) {
                            t3 = (t)d.j();
                            if (!x) {
                                continue;
                            }
                        }
                        t4 = (t)d.i();
                        break;
                    }
                    break Label_0197;
                }
                if (t3 != null) {
                    d.b(this.a(t3, t4, y));
                }
            }
            d.size();
        }
        if (a2 < 2) {
            d.clear();
            d.a(d2);
        }
    }
    
    private static boolean a(final t t, final t t2) {
        return Math.abs(Math.abs(t.a - t2.a) - Math.abs(t.b - t2.b)) < 0.001;
    }
    
    private t a(final t t, final t t2, final y.d.y y) {
        final boolean x = N.x;
        if (t == null || t2 == null) {
            return null;
        }
        if (a(t, t2)) {
            return y.d.n.b(new n(y), new m(t, t2), 0.001);
        }
        double n = t.a();
        double n2 = t.b();
        Label_0108: {
            if (t2.a < y.c()) {
                n = y.c();
                if (!x) {
                    break Label_0108;
                }
            }
            if (t2.a > y.c() + y.a()) {
                n = y.c() + y.a();
            }
        }
        if (t2.b < y.d()) {
            n2 = y.d();
            if (!x) {
                return new t(n, n2);
            }
        }
        if (t2.b > y.d() + y.b()) {
            n2 = y.d() + y.b();
        }
        return new t(n, n2);
    }
    
    public void d(final aU au, final aP ap) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        int n = 0;
        while (true) {
            do {
                int i = 0;
                Label_0018: {
                    i = n;
                }
                int b = au.b();
                Label_0026:
                while (i < b) {
                    final aQ a = au.a(n);
                    final byte e = a.e();
                    if (!x) {
                        if (e == 1) {
                            dg dg = this.j;
                            final D d = new D();
                            d.add(dg);
                            p p2 = a.d().k();
                            while (p2 != null) {
                                final q q = (q)p2.c();
                                final as as = (as)this.c.a(q);
                                final byte b2 = (byte)(i = as.b());
                                final int n2 = b = 1;
                                if (x) {
                                    continue Label_0026;
                                }
                                Label_0254: {
                                    if (b2 == n2 || as.b() == 4) {
                                        as.a(dg.f);
                                        dg.b(q);
                                        this.j.a(dg.f, as);
                                        if (!x) {
                                            break Label_0254;
                                        }
                                    }
                                    if (as.b() == 12) {
                                        dg = this.f(as.l());
                                        d.c(dg);
                                        if (!x) {
                                            break Label_0254;
                                        }
                                    }
                                    if (as.b() == 13) {
                                        d.g();
                                        dg = (dg)d.h();
                                    }
                                }
                                p2 = p2.a();
                                if (x) {
                                    break;
                                }
                            }
                        }
                        ++n;
                        continue Label_0018;
                    }
                    if (e != 0) {
                        this.d(au);
                        this.o(au);
                    }
                    return;
                }
                break;
            } while (!x);
            continue;
        }
    }
    
    boolean e(final q q) {
        final byte b = this.c.a(q).b();
        return b == 12 || b == 13;
    }
    
    double a(final cr cr, final double n, double n2) {
        if (this.k()) {
            final double c = cr.c().a(false, false).c(cr.b().a(false, false));
            if (c < n) {
                final double n3 = n - c;
                cr.e(n3);
                n2 += n3;
            }
        }
        return n2;
    }
    
    void a(final D[] array, final int[] array2, final int[] array3) {
        final boolean x = N.x;
        final int[] array4 = new int[this.j.d.size()];
        final int[] array5 = new int[this.j.d.size()];
        final H h = new H(this, array2, array4, array5);
        int i = 0;
        while (true) {
            while (i < this.j.d.size()) {
                final ArrayList d = this.j.d;
                if (x) {
                    int j = 0;
                    while (j < array.length) {
                        final dd k = this.j;
                        this.a(k, array2, j, array4, array5);
                        final int n = j;
                        array3[n] += this.a(k, j, array2, array4, array5, h, 0);
                        ++j;
                        if (x) {
                            break;
                        }
                    }
                    return;
                }
                d.get(i).u = i;
                ++i;
                if (x) {
                    break;
                }
            }
            final ArrayList list = new ArrayList();
            continue;
        }
    }
    
    private int a(final dg dg, final int n, final int[] array, final int[] array2, final int[] array3, final Comparator comparator, int a) {
        final boolean x = N.x;
        final ArrayList list = new ArrayList<dg>(dg.b(n));
        y.g.e.a(list, comparator);
        int i = 0;
        while (i < list.size()) {
            final dg value = list.get(i);
            final int n2;
            final boolean b = (n2 = ((value instanceof dg) ? 1 : 0)) != 0;
            if (x) {
                return n2;
            }
            Label_0352: {
                if (b) {
                    final dg dg2 = value;
                    final boolean b2 = array2[dg2.u] != array3[dg2.u];
                    Label_0198: {
                        if (b2 && i > 0) {
                            final dg value2 = list.get(i - 1);
                            if (value2 instanceof q) {
                                final int n3 = array[((q)value2).d()] - a;
                                if (n3 != -1 && n3 != array2[dg2.u]) {
                                    break Label_0198;
                                }
                                ++a;
                                if (!x) {
                                    break Label_0198;
                                }
                            }
                            if (array2[value2.u] == array3[dg2.u]) {
                                ++a;
                            }
                        }
                    }
                    a = this.a(dg2, n, array, array2, array3, comparator, a);
                    if (!b2 || i >= list.size() - 1) {
                        break Label_0352;
                    }
                    final dg value3 = list.get(i + 1);
                    if (value3 instanceof q) {
                        if (array[((q)value3).d()] > array3[dg2.u]) {
                            break Label_0352;
                        }
                        ++a;
                        if (!x) {
                            break Label_0352;
                        }
                    }
                    if (array2[value3.u] > array3[dg2.u]) {
                        break Label_0352;
                    }
                    ++a;
                    if (!x) {
                        break Label_0352;
                    }
                }
                final q q = (q)value;
                final int n4 = array[q.d()];
                if (n4 >= 0) {
                    array[q.d()] = n4 + a;
                }
            }
            ++i;
            if (x) {
                break;
            }
        }
        return a;
    }
    
    private void a(final dg dg, final int[] array, final int n, final int[] array2, final int[] array3) {
        final boolean x = N.x;
        array2[dg.u] = Integer.MAX_VALUE;
        array3[dg.u] = -1;
        p p5 = dg.b(n).k();
        while (p5 != null) {
            Label_0210: {
                if (p5.c() instanceof dg) {
                    final dg dg2 = (dg)p5.c();
                    this.a(dg2, array, n, array2, array3);
                    final int n2 = array2[dg2.u];
                    if (n2 >= 0) {
                        array2[dg.u] = Math.min(array2[dg.u], n2);
                    }
                    final int n3 = array3[dg2.u];
                    if (n3 < 0) {
                        break Label_0210;
                    }
                    array3[dg.u] = Math.max(array3[dg.u], n3);
                    if (!x) {
                        break Label_0210;
                    }
                }
                final int n4 = array[((q)p5.c()).d()];
                if (n4 >= 0) {
                    array2[dg.u] = Math.min(array2[dg.u], n4);
                    array3[dg.u] = Math.max(array3[dg.u], n4);
                }
            }
            p5 = p5.a();
            if (x) {
                break;
            }
        }
    }
    
    dg f(final q q) {
        if (!this.k()) {
            return null;
        }
        return (dg)this.j.c.b(q);
    }
    
    public boolean k() {
        return this.j.a();
    }
    
    public void a(final q q, final J j) {
        if (!this.k()) {
            return;
        }
        this.a(this.f(q), j);
    }
    
    private void a(final dg dg, final J j) {
        final boolean x = N.x;
        if (!this.k()) {
            return;
        }
        for (final q next : dg.f()) {
            if (next instanceof q) {
                j.a(next, dg.f);
                if (!x) {
                    continue;
                }
            }
            if (next instanceof dg) {
                this.a((dg)next, j);
                if (x) {
                    break;
                }
                continue;
            }
        }
    }
    
    public y g(final q q) {
        if (!this.k()) {
            return null;
        }
        final y y = new y();
        this.a(this.f(q), new y.f.c.a.I(this, y));
        return y;
    }
    
    public y h(final q q) {
        final boolean x = N.x;
        if (!this.k()) {
            return null;
        }
        final dg f = this.f(q);
        final y y = new y();
        for (final dg next : f.f()) {
            if (next instanceof q) {
                y.add(next);
                if (!x) {
                    continue;
                }
            }
            y.add(next.f);
            if (x) {
                break;
            }
        }
        return y;
    }
    
    public q i(final q q) {
        if (!this.k()) {
            return null;
        }
        return this.j.a((Object)q).f;
    }
    
    public boolean a(final q q, final q q2) {
        final boolean x = N.x;
        q q3 = this.i(q);
        while (q2 != q3) {
            final q q4 = q3;
            if (x || q4 == null) {
                return q4 == q2;
            }
            q3 = this.i(q3);
            if (x) {
                goto Label_0036;
            }
        }
        goto Label_0036;
    }
}
