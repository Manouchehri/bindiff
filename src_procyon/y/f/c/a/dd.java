package y.f.c.a;

import y.f.*;
import y.g.*;
import y.f.b.*;
import java.util.*;
import y.c.*;

class dd extends dg
{
    X a;
    aV b;
    A c;
    ArrayList d;
    boolean e;
    
    dd(final E e, final X a, final aV b) {
        final boolean x = N.x;
        super(e, null);
        this.e = true;
        this.a = a;
        this.b = b;
        this.d = new ArrayList();
        final y.c.c c = a.c(y.f.b.f.d);
        final y.c.c c2 = a.c(y.f.b.f.b);
        final y.c.c c3 = a.c(y.f.b.f.c);
        if (c == null || c2 == null || c3 == null) {
            this.e = false;
            return;
        }
        this.c = M.a();
        final c c4 = new c(a);
        final HashMap<Object, dd> hashMap = new HashMap<Object, dd>();
        this.d.add(this);
        this.c.a(null, this);
        final x o = a.o();
        while (o.f()) {
            final q e2 = o.e();
            final Object b2 = c2.b(e2);
            Label_0250: {
                if (c4.d(e2) && !c4.b(e2).isEmpty()) {
                    final dg dg = new dg(e, e2);
                    hashMap.put(b2, (dd)dg);
                    this.d.add(dg);
                    this.c.a(e2, dg);
                    if (!x) {
                        break Label_0250;
                    }
                }
                hashMap.put(b2, (dd)e2);
            }
            o.g();
            if (x) {
                break;
            }
        }
        final x o2 = a.o();
        while (o2.f() && hashMap.containsKey(c3.b(o2.e()))) {
            o2.g();
        }
        final x o3 = a.o();
        while (o3.f()) {
            final q e3 = o3.e();
            final Object b3 = c2.b(e3);
            final Object b4 = c3.b(e3);
            final dd value = hashMap.get(b3);
            final dd value2 = hashMap.get(b4);
            if (x) {
                return;
            }
            final dd dd = (value2 == null) ? this : value2;
            ((as)b.a(e3)).a(dd.f);
            this.a(value, dd);
            o3.g();
            if (x) {
                break;
            }
        }
        if (this.d.size() <= 1) {
            this.e = false;
        }
        c4.c();
    }
    
    void a(final aU au, final aP ap) {
        final boolean x = N.x;
        int i = 0;
        while (i < au.b()) {
            final aQ a = au.a(i);
            this.a(a, a.d().k(), ap, this);
            ++i;
            if (x) {
                break;
            }
        }
    }
    
    void a(final aU au, final A a) {
        final boolean x = N.x;
        for (final dg dg : this.d) {
            dg.g = null;
            dg.h = null;
            dg.A = null;
            dg.B = null;
            if (x) {
                break;
            }
        }
        int i = 0;
    Label_0284_Outer:
        while (i < au.b()) {
            final aQ a2 = au.a(i);
            final y d = a2.d();
            if (!x) {
                p p2 = d.k();
                while (true) {
                    while (p2 != null) {
                        final q q = (q)p2.c();
                        if (!x) {
                            if (a == null || !a.d(q)) {
                                dg dg2 = this.a((Object)q);
                                if (dg2 == null) {
                                    dg2 = this.C.f(this.b.a(q).l());
                                }
                                if (dg2.g == null) {
                                    dg2.g = a2;
                                }
                                if (dg2.A == null && a2.e() != 2 && a2.e() != 3) {
                                    dg2.A = a2;
                                }
                                if (a2.e() != 2 && a2.e() != 3) {
                                    dg2.B = a2;
                                }
                                dg2.h = a2;
                            }
                            p2 = p2.a();
                            if (x) {
                                break;
                            }
                            continue Label_0284_Outer;
                        }
                        else {
                            if (x) {
                                break Label_0284_Outer;
                            }
                            continue Label_0284_Outer;
                        }
                    }
                    ++i;
                    continue;
                }
            }
            return;
        }
        this.d();
    }
    
    void a(final aV av) {
        final boolean x = N.x;
        final A a = M.a(new boolean[this.a.e()]);
        final x o = this.a.o();
    Label_0427:
        while (true) {
            while (o.f()) {
                q q = o.e();
                as as = (as)av.a(q);
                final byte b = as.b();
                Label_0433: {
                    if (!x) {
                        Label_0415: {
                            if (b == 1) {
                                final d g = as.g();
                                if (!a.d(q)) {
                                    if (q.g().c() == g.c()) {
                                        a.a(q, true);
                                        do {
                                            Label_0120: {
                                                as.b();
                                            }
                                            int i = 0;
                                            int n = 0;
                                            Label_0128:
                                            while (i == n) {
                                                final q c = g.c();
                                                final q d = g.d();
                                                final D a2 = this.a(c);
                                                final D a3 = this.a(d);
                                                final dd dd = this;
                                                if (!x) {
                                                    dg dg = this;
                                                    while (true) {
                                                        while (!a2.isEmpty()) {
                                                            final int n3;
                                                            final int n2 = n3 = (a3.isEmpty() ? 1 : 0);
                                                            if (x) {
                                                                final int n4 = n3;
                                                                p p = a2.k();
                                                                while (p != null) {
                                                                    final dg dg2 = (dg)p.c();
                                                                    i = dg2.h.c();
                                                                    n = n4;
                                                                    if (x) {
                                                                        continue Label_0128;
                                                                    }
                                                                    if (i >= n) {
                                                                        as.a(dg2.f);
                                                                        if (!x) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    p = p.a();
                                                                    if (x) {
                                                                        break;
                                                                    }
                                                                }
                                                                p p2 = a3.k();
                                                                while (p2 != null) {
                                                                    final dg dg3 = (dg)p2.c();
                                                                    final int c2 = dg3.g.c();
                                                                    final int n5 = n4;
                                                                    if (x) {
                                                                        continue Label_0128;
                                                                    }
                                                                    if (c2 <= n5) {
                                                                        as.a(dg3.f);
                                                                        if (!x) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    p2 = p2.a();
                                                                    if (x) {
                                                                        break;
                                                                    }
                                                                }
                                                                q = q.f().d();
                                                                as = (as)av.a(q);
                                                                continue Label_0120;
                                                            }
                                                            if (n2 || a2.i() != a3.i()) {
                                                                break;
                                                            }
                                                            dg = (dg)a2.j();
                                                            a3.j();
                                                            if (x) {
                                                                break;
                                                            }
                                                        }
                                                        as.a(dg.f);
                                                        int n3 = as.j();
                                                        continue;
                                                    }
                                                }
                                                break Label_0427;
                                            }
                                            break;
                                        } while (!x);
                                        break Label_0415;
                                        dd dd = null;
                                        dd.C.a();
                                        break Label_0433;
                                    }
                                }
                            }
                        }
                        o.g();
                        if (x) {
                            break;
                        }
                        continue;
                    }
                }
                final byte b2 = b;
                final x o2 = this.a.o();
                while (o2.f()) {
                    final q e = o2.e();
                    final aX a4 = av.a(e);
                    if (a4.b() == 1) {
                        this.a((Object)e).b(e);
                        if (b2 != 0) {
                            this.a(a4.l(), (as)a4);
                        }
                    }
                    o2.g();
                    if (x) {
                        break;
                    }
                }
                return;
            }
            final dd dd = this;
            continue Label_0427;
        }
    }
    
    void a(final q q, final as as) {
        final bK h = as.h();
        final bK a = this.C.a(q);
        final bK b = this.C.b(q);
        if (h != null) {
            final int j = h.j();
            if (a != null && a.j() > j) {
                as.a(a);
            }
            if (b != null && b.j() < j) {
                as.a(b);
            }
        }
    }
    
    D a(final q q) {
        final boolean x = N.x;
        final D d = new D();
        dg dg = this.a((Object)q);
        D d2 = null;
        while (dg != null) {
            d2 = d;
            if (x) {
                return d2;
            }
            d2.add(dg);
            dg = this.a((Object)dg);
            if (x) {
                break;
            }
        }
        return d2;
    }
    
    void a(final q q, final dg dg) {
        ((as)this.b.a(q)).a(dg.f);
    }
    
    dg a(Object f) {
        if (f instanceof dg) {
            f = ((dg)f).f;
            if (f == null) {
                return null;
            }
        }
        if (f instanceof q) {
            final dg f2 = this.C.f(this.b.a((q)f).l());
            if (f2 != null) {
                return f2;
            }
        }
        throw new IllegalStateException("Item has no parent");
    }
    
    void a(final Object o, final dg dg) {
        dg.b(o);
    }
    
    public boolean a() {
        return this.e;
    }
    
    boolean a(final d d, final aV av) {
        final q c = d.c();
        final q d2 = d.d();
        final aX a = av.a(c);
        final aX a2 = av.a(d2);
        dg dg = null;
        if (a2.b() == 9) {
            final q f = a2.f();
            if (av.a(f).b() == 15) {
                final dg a3 = this.a((Object)f);
                q f2 = c;
                if (a.b() == 8) {
                    f2 = a.f();
                }
                if (this.C.a(f2, a3.f)) {
                    dg = this.a((Object)a3);
                }
            }
        }
        if (dg == null && a.b() == 8) {
            final q f3 = a.f();
            if (av.a(f3).b() == 15) {
                final dg a4 = this.a((Object)f3);
                q f4 = d2;
                if (a2.b() == 9) {
                    f4 = a2.f();
                }
                if (this.C.a(f4, a4.f)) {
                    dg = this.a((Object)a4);
                }
            }
        }
        if (dg != null) {
            if (a2.b() == 9) {
                this.a(d2, dg);
                dg.b(d2);
                this.a(dg.f, (as)a2);
            }
            if (a.b() == 8) {
                this.a(c, dg);
                dg.b(c);
                this.a(dg.f, (as)a);
            }
            return true;
        }
        return false;
    }
    
    public void a(final aU au, final aV av) {
        final boolean x = N.x;
        final e p2 = this.a.p();
        while (p2.f()) {
            final d a = p2.a();
            Label_0548: {
                if (!this.a(a, av)) {
                    final q c = a.c();
                    final q d = a.d();
                    final aX a2 = av.a(c);
                    final aX a3 = av.a(d);
                    a3.b();
                    dg a8 = null;
                Label_0086:
                    while (true) {
                        int c2 = 0;
                        int n = 0;
                        if (c2 == n) {
                            final q f = a3.f();
                            final aX a4 = av.a(f);
                            final dg a5 = this.a((Object)this.a((Object)f));
                            if (a4.b() == 15 && a2.b() == 8 && a2.j() >= a5.g.c() && a2.j() <= a5.h.c()) {
                                this.a(d, a5);
                                this.a(c, a5);
                                a5.b(d);
                                this.a(a5.f, (as)a2);
                                a5.b(c);
                                this.a(a5.f, (as)a3);
                                if (!x) {
                                    break Label_0548;
                                }
                            }
                            dg dg;
                            if (a2.b() == 8) {
                                final q f2 = a2.f();
                                if (av.a(f2).b() == 15) {
                                    dg = this.a((Object)this.a((Object)f2));
                                }
                                else {
                                    dg = this.a((Object)a2.f());
                                }
                                this.a(c, dg);
                                dg.b(c);
                                this.a(dg.f, (as)a2);
                            }
                            else {
                                dg = this.a((Object)c);
                            }
                            final int j = a3.j();
                            dg a6 = dg;
                            while (a6 != this) {
                                c2 = a6.h.c();
                                n = j;
                                if (x) {
                                    continue Label_0086;
                                }
                                if (c2 >= n) {
                                    break;
                                }
                                a6 = this.a((Object)a6);
                                if (x) {
                                    break;
                                }
                            }
                            this.a(d, a6);
                            a6.b(d);
                            this.a(a6.f, (as)a3);
                            if (!x) {
                                break Label_0548;
                            }
                        }
                        if (a2.b() == 8) {
                            final dg a7 = this.a((Object)d);
                            final int i = a2.j();
                            a8 = a7;
                            while (a8 != this) {
                                final int c3 = a8.g.c();
                                final int n2 = i;
                                if (x) {
                                    continue Label_0086;
                                }
                                if (c3 <= n2) {
                                    break;
                                }
                                a8 = this.a((Object)a8);
                                if (x) {
                                    break;
                                }
                            }
                            break;
                        }
                        break Label_0548;
                    }
                    this.a(c, a8);
                    a8.b(c);
                    this.a(a8.f, (as)a2);
                }
            }
            p2.g();
            if (x) {
                break;
            }
        }
    }
    
    public void b(final aU au, final aV av) {
        final boolean x = N.x;
        final x o = this.a.o();
        while (o.f()) {
            final q e = o.e();
            final aX a = av.a(e);
            if (a.b() == 10) {
                final q c = e.g().c();
                final aX a2 = av.a(c);
                final aX a3 = av.a(e.f().d());
                dg dg = this.a((Object)c);
                Label_0298: {
                    if (a2.b() == 15 && a3.b() == 15) {
                        if (this.C.a(a2.l(), a3.l())) {
                            dg = this.a((Object)a3.l());
                            if (!x) {
                                break Label_0298;
                            }
                        }
                        if (this.C.a(a3.l(), a2.l())) {
                            dg = this.a((Object)a2.l());
                            if (!x) {
                                break Label_0298;
                            }
                        }
                        if (a3.l() != a2.l()) {
                            break Label_0298;
                        }
                        dg = this.a((Object)a2.l());
                        if (!x) {
                            break Label_0298;
                        }
                    }
                    if (a2.b() == 15) {
                        dg = this.a((Object)a2.l());
                        if (!x) {
                            break Label_0298;
                        }
                    }
                    if (a3.b() == 15) {
                        dg = this.a((Object)a3.l());
                    }
                }
                this.a(e, dg);
                dg.b(e);
                this.a(dg.f, (as)a);
            }
            o.g();
            if (x) {
                break;
            }
        }
    }
    
    public void c(final aU au, final aV av) {
        final boolean x = N.x;
        int n = 0;
        do {
            int i = 0;
        Label_0008:
            while (i < au.b()) {
                p p2 = this.b(n).k();
                while (p2 != null) {
                    i = ((p2.c() instanceof dg) ? 1 : 0);
                    if (x) {
                        continue Label_0008;
                    }
                    if (i != 0) {
                        ((dg)p2.c()).a(au, n, av);
                    }
                    p2 = p2.a();
                    if (x) {
                        break;
                    }
                }
                ++n;
            }
            break;
        } while (!x);
    }
    
    private dg a(final int n, final q q, final boolean b) {
        final boolean x = N.x;
        final int n2 = b ? 0 : 1;
        final int n3 = b ? 1 : 0;
        final HashMap hashMap = new HashMap<dg, Integer>();
        final HashSet set = new HashSet<dg>();
        final y a = this.a(q, true);
        final HashMap hashMap2 = new HashMap<Object, Integer>();
        final D d = new D();
        C c = a.a();
        while (true) {
            while (true) {
                do {
                    Label_0078: {
                        c.f();
                    }
                    int i = 0;
                    q e;
                    dg a2;
                    dg dg;
                    D a3;
                    int size;
                    p p3;
                    dg dg2;
                    dg dg3;
                    dg dg4;
                    y a4;
                    D d2;
                    y y;
                    C c2;
                    int j = 0;
                    q e2;
                    dg a5;
                    dg dg5;
                    D a6;
                    int size2;
                    p p4;
                    dg dg6;
                    dg dg7;
                    boolean containsKey;
                    dg dg8;
                    y y2;
                    dg dg9;
                    int intValue;
                    C m;
                    dg dg10 = null;
                    dg dg11;
                    int intValue2;
                    Label_0085:
                    Label_0742_Outer:Label_0819_Outer:
                    while (i != 0) {
                        e = ((x)c).e();
                        dg = (a2 = this.a((Object)e));
                        if (!x) {
                            Label_0180: {
                                if (a2 != null) {
                                    if (hashMap2.containsKey(dg)) {
                                        hashMap2.put(dg, new Integer(hashMap2.get(dg) + 1));
                                        if (!x) {
                                            break Label_0180;
                                        }
                                    }
                                    hashMap2.put(dg, new Integer(1));
                                }
                            }
                            a3 = this.a(e);
                            size = a3.size();
                            p3 = a3.k();
                            while (p3 != null) {
                                dg2 = (dg)p3.c();
                                i = dg2.h.c() + n3;
                                if (x) {
                                    continue Label_0085;
                                }
                                if (i >= n && dg2.g.c() - n2 <= n && !set.contains(dg2)) {
                                    d.add(dg2);
                                    set.add(dg2);
                                    hashMap.put(dg2, new Integer(size));
                                }
                                --size;
                                p3 = p3.a();
                                if (x) {
                                    break;
                                }
                            }
                            c.g();
                            continue Label_0078;
                        }
                        while (true) {
                            dg3 = a2;
                            if (hashMap2.containsKey(dg3) && hashMap2.get(dg3) == a.size()) {
                                return dg3;
                            }
                            c.g();
                            if (!x) {
                                if (c.f()) {
                                    dg4 = (dg)c.d();
                                    continue Label_0742_Outer;
                                }
                            }
                            break;
                        }
                        a4 = this.a(q, false);
                        d2 = new D();
                        y = new y();
                        set.clear();
                        hashMap2.clear();
                        c2 = a4.a();
                        while (true) {
                            while (true) {
                                do {
                                    Label_0452:
                                    c2.f();
                                    Label_0459:
                                    while (j != 0) {
                                        e2 = ((x)c2).e();
                                        dg5 = (a5 = this.a((Object)e2));
                                        if (!x) {
                                            Label_0554: {
                                                if (a5 != null) {
                                                    if (hashMap2.containsKey(dg5)) {
                                                        hashMap2.put(dg5, new Integer(hashMap2.get(dg5) + 1));
                                                        if (!x) {
                                                            break Label_0554;
                                                        }
                                                    }
                                                    hashMap2.put(dg5, new Integer(1));
                                                }
                                            }
                                            a6 = this.a(e2);
                                            size2 = a6.size();
                                            p4 = a6.k();
                                            while (p4 != null) {
                                                dg6 = (dg)p4.c();
                                                j = dg6.h.c() + n3;
                                                if (x) {
                                                    continue Label_0459;
                                                }
                                                if (j >= n && dg6.g.c() - n2 <= n) {
                                                    Label_0704: {
                                                        if (!set.contains(dg6)) {
                                                            d2.add(dg6);
                                                            set.add(dg6);
                                                            if (hashMap.containsKey(dg6)) {
                                                                y.add(dg6);
                                                                if (!x) {
                                                                    break Label_0704;
                                                                }
                                                            }
                                                            d.add(dg6);
                                                            hashMap.put(dg6, new Integer(size2));
                                                        }
                                                    }
                                                    --size2;
                                                }
                                                p4 = p4.a();
                                                if (x) {
                                                    break;
                                                }
                                            }
                                            c2.g();
                                            continue Label_0452;
                                        }
                                        while (true) {
                                            dg7 = a5;
                                            containsKey = hashMap2.containsKey(dg7);
                                            if (!x) {
                                                if (containsKey && hashMap2.get(dg7) == a4.size()) {
                                                    return dg7;
                                                }
                                                c2.g();
                                                if (!x) {
                                                    if (c2.f()) {
                                                        dg8 = (dg)c2.d();
                                                        continue Label_0742_Outer;
                                                    }
                                                }
                                                y.isEmpty();
                                            }
                                            break;
                                        }
                                        y2 = (y)(containsKey ? d : y);
                                        if (y2.isEmpty()) {
                                            return null;
                                        }
                                        dg9 = (dg)y2.f();
                                        intValue = hashMap.get(dg9);
                                        m = y2.m();
                                        while (m.f()) {
                                            dg10 = (dg)m.d();
                                            if (x) {
                                                return dg10;
                                            }
                                            dg11 = dg10;
                                            intValue2 = hashMap.get(dg11);
                                            if (intValue < intValue2) {
                                                dg9 = dg11;
                                                intValue = intValue2;
                                            }
                                            m.g();
                                            if (x) {
                                                break;
                                            }
                                        }
                                        return dg10;
                                    }
                                    break;
                                } while (!x);
                                if (!b) {
                                    c2 = d2.m();
                                    continue Label_0819_Outer;
                                }
                                break;
                            }
                            continue;
                        }
                    }
                    break;
                } while (!x);
                if (b) {
                    c = d.m();
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    private y a(final q q, final boolean b) {
        final boolean x = N.x;
        final y y = new y();
        final y y2 = new y();
        while (true) {
            Label_0040: {
                if (!b) {
                    break Label_0040;
                }
                y2.a(q.n());
                if (x) {
                    break Label_0040;
                }
                y y3 = null;
                while (!y2.isEmpty()) {
                    y3 = y2;
                    if (x) {
                        return y3;
                    }
                    final q d = y3.d();
                    final aX a = this.b.a(d);
                    if (a.b() == 6 || a.b() == 7) {
                        if (b) {
                            y2.a(d.o());
                            if (!x) {
                                continue;
                            }
                        }
                        y2.a(d.o());
                        if (!x) {
                            continue;
                        }
                    }
                    y.add(d);
                    if (x) {
                        break;
                    }
                }
                return y3;
            }
            y2.a(q.o());
            continue;
        }
    }
    
    void a(final aU au) {
        final boolean x = N.x;
        int n = 0;
        do {
            int i = 0;
            Label_0007: {
                i = n;
            }
            int b = au.b();
            Label_0014:
            while (i < b) {
                p p = au.a(n).d().k();
                while (p != null) {
                    final q q = (q)p.c();
                    final aX a = this.b.a(q);
                    final byte b2 = (byte)(i = a.b());
                    final int n2 = b = 6;
                    if (x) {
                        continue Label_0014;
                    }
                    Label_0192: {
                        if (b2 == n2) {
                            final dg a2 = this.a(n, q, true);
                            ((as)a).a(a2.f);
                            this.a((Object)q, a2);
                            this.a(a2.f, (as)a);
                            if (!x) {
                                break Label_0192;
                            }
                        }
                        if (a.b() == 7) {
                            final dg a3 = this.a(n, q, false);
                            ((as)a).a(a3.f);
                            this.a((Object)q, a3);
                            this.a(a3.f, (as)a);
                        }
                    }
                    p = p.a();
                    if (x) {
                        break;
                    }
                }
                ++n;
                continue Label_0007;
            }
            break;
        } while (!x);
    }
    
    public void d(final aU au, final aV av) {
        final boolean x = N.x;
        int i = 0;
        while (true) {
            while (i < this.d.size()) {
                ((dg)this.d.get(i)).e();
                ++i;
                if (x) {
                    do {
                        int j = i;
                        int b = au.b();
                    Label_0058:
                        while (j < b) {
                            p p2 = au.a(i).d().k();
                            while (p2 != null) {
                                final q q = (q)p2.c();
                                final dg a = this.a((Object)q);
                                a.b(i).add(q);
                                final byte b2 = (byte)(j = av.a(q).b());
                                final int n = b = 12;
                                if (x) {
                                    continue Label_0058;
                                }
                                if (b2 == n) {
                                    this.a((Object)a).b(i).add(a);
                                }
                                p2 = p2.a();
                                if (x) {
                                    break;
                                }
                            }
                            ++i;
                            continue Label_0051;
                        }
                        break;
                    } while (!x);
                    return;
                }
                if (x) {
                    break;
                }
            }
            i = 0;
            continue;
        }
    }
}
