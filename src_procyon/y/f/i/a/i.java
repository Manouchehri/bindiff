package y.f.i.a;

import y.f.*;
import y.c.*;
import java.util.*;

public class i
{
    private static final k a;
    private Z b;
    private HashMap c;
    
    public i() {
        this.c = new HashMap();
    }
    
    public void a(final Z b) {
        this.b = b;
    }
    
    public void a() {
        this.c.clear();
        this.b = null;
    }
    
    private X b() {
        return this.b.a();
    }
    
    public void a(final f f, final ac ac) {
        final int a = ab.a;
        final X b = this.b();
        if (b.h() == 0) {
            return;
        }
        D a2 = null;
        boolean a3 = false;
        int i = 0;
        while (true) {
            while (i < 2) {
                this.c.clear();
                a2 = this.a(ac);
                this.a(a2);
                this.a(a2, this.a(a2, ac, this.b));
                if (a != 0) {
                    final e a4 = f.a();
                    while (a4.f()) {
                        final d a5 = a4.a();
                        b.a(a5, ac.a(a5).g());
                        a4.g();
                        if (a != 0) {
                            return;
                        }
                        if (a != 0) {
                            break;
                        }
                    }
                    ac.a(a3);
                    return;
                }
                if (!a3) {
                    a3 = this.a(a2, ac);
                    if (!a3) {
                        break;
                    }
                }
                ++i;
                if (a != 0) {
                    break;
                }
            }
            this.b(a2);
            continue;
        }
    }
    
    private boolean a(final D d, final ac ac) {
        final int a = ab.a;
        boolean b = false;
        final Iterator iterator = d.iterator();
        boolean b2 = false;
        while (iterator.hasNext()) {
            b2 = (b | this.a(iterator.next(), ac));
            if (a != 0) {
                return b2;
            }
            b = b2;
            if (a != 0) {
                break;
            }
        }
        return b2;
    }
    
    private boolean a(final h h, final ac ac) {
        final int a = ab.a;
        boolean b = false;
        final List d = h.d();
        ai ai = null;
        for (final ai ai2 : d) {
            if (ai != null && a(ai, ai2) && a(ai, ai2, h)) {
                final w a2 = this.a(ai, ac);
                final w a3 = this.a(ai2, ac);
                final M a4 = this.a(ai, a2);
                final M a5 = this.a(ai2, a3);
                if (a4 != null && a5 != null && a4.b(a5) == 0.0) {
                    final M a6 = M.a(a4, a5);
                    if (a6.d() < a4.d() && a6.d() < a5.d()) {
                        final boolean b2 = a4.a() < a5.a();
                        final ai ai3 = b2 ? ai : ai2;
                        final ai ai4 = b2 ? ai2 : ai;
                        final M b3 = b(a6, ai3);
                        final M a7 = a(a6, ai4);
                        final boolean b4 = !this.a(ai3);
                        final boolean a8 = this.a(ai3, b3, b4, ac);
                        final boolean a9 = this.a(ai4);
                        final boolean a10 = this.a(ai4, a7, a9, ac);
                        if (a8 || a10) {
                            boolean b5;
                            if ((b5 = a8) && a10) {
                                b5 = (b3.d() >= a7.d());
                            }
                            final ai ai5 = b5 ? ai3 : ai4;
                            final boolean a11 = this.a(ai5);
                            final w w = (b5 ^ b2) ? a3 : a2;
                            final int n = (b5 ? b4 : a9) ? (ai5.j() - 1) : (ai5.j() + 1);
                            final M m = b5 ? b3 : a7;
                            final ai a12 = w.a(n);
                            final boolean a13 = this.a(a12);
                            final boolean b6 = b5 ^ a11;
                            this.a(ai5, a12, b6 ^ a13, b6, m, a6, ac);
                            b = true;
                        }
                    }
                }
            }
            ai = ai2;
            if (a != 0) {
                break;
            }
        }
        return b;
    }
    
    private static M a(final M m, final ai ai) {
        M c = null;
        if (ai.a() == null) {
            c = new M(m.b(), ai.b().b());
        }
        else if (m.b() < ai.a().a()) {
            c = M.c(ai.a(), m);
        }
        return c;
    }
    
    private static M b(final M m, final ai ai) {
        M c = null;
        if (ai.a() == null) {
            c = new M(ai.b().a(), m.a());
        }
        else if (ai.a().b() < m.a()) {
            c = M.c(ai.a(), m);
        }
        return c;
    }
    
    private static boolean a(final ai ai, final ai ai2, final h h) {
        return Math.abs(h.b(ai) - h.b(ai2)) < 1.0;
    }
    
    private static boolean a(final ai ai, final ai ai2) {
        return ai.k() == null || ai.k() != ai2.k();
    }
    
    private void a(final ai ai, final ai ai2, final boolean b, final boolean b2, final M m, final M i, final ac ac) {
        final int a = ab.a;
        final int j = ai.j();
        final int k = ai2.j();
        final ah ah = (j < k) ? ai.k() : ai2.k();
        if (ah == null) {
            final w a2 = ac.a(ai.i());
            final ai a3 = this.a(ai, ai2, b, m);
            final ai a4 = this.a(ai, ai2, b2, m, i);
            final M a5 = ai.a();
            if (a5 != null) {
                final double n = (b2 ^ this.a(ai)) ? a5.a() : a5.b();
                ai.a(new M(n, n));
            }
            final M a6 = ai2.a();
            if (a6 != null) {
                final double n2 = b ? a6.b() : a6.a();
                ai2.a(new M(n2, n2));
            }
            a2.a(a3, a4);
            if (a == 0) {
                return;
            }
        }
        final D d = new D();
        final ah ah2 = new ah(m, d);
        final D d2 = new D();
        final ah ah3 = new ah(null, d2);
        double min = Double.MAX_VALUE;
        double max = -1.7976931348623157E308;
        Iterator iterator = ah.b().iterator();
        while (true) {
            while (iterator.hasNext()) {
                final w a7 = ac.a(iterator.next().i());
                final ai a8 = a7.a(j);
                final ai a9 = a7.a(k);
                final ai a10 = this.a(a8, a9, b, m);
                a10.a(ah2);
                d.add(a10);
                final ai a11 = this.a(a8, a9, b2, m, i);
                d2.add(a11);
                min = Math.min(min, a11.c().a());
                max = Math.max(max, a11.c().b());
                final M a12 = a8.a();
                Object next;
                final M l = (M)(next = a12);
                if (a == 0) {
                    if (l != null) {
                        final double n3 = (b2 ^ this.a(a8)) ? a12.a() : a12.b();
                        a8.a(new M(n3, n3));
                    }
                    final M a13 = a9.a();
                    if (a13 != null) {
                        final double n4 = b ? a13.b() : a13.a();
                        a9.a(new M(n4, n4));
                    }
                    a7.a(a10, a11);
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    while (true) {
                        ((ai)next).a(ah3);
                        if (a == 0) {
                            if (a == 0) {
                                if (iterator.hasNext()) {
                                    next = iterator.next();
                                    continue;
                                }
                            }
                            ah3.d();
                        }
                        break;
                    }
                    return;
                }
            }
            ah2.d();
            ah3.a(new M(min, max));
            iterator = d2.iterator();
            continue;
        }
    }
    
    private ai a(final ai ai, final ai ai2, final boolean b, final M m, final M i) {
        return new ai(ai.i(), b ? ai.j() : (ai.j() + 2), ai.h(), new M(ai2.b().a() + 1.0, ai2.b().b() - 1.0), i, M.b(m, i), null);
    }
    
    private ai a(final ai ai, final ai ai2, final boolean b, final M m) {
        return new ai(ai.i(), ai.j() + 1, ai2.h(), m, b ? new M(ai2.b().a(), ai2.b().a()) : new M(ai2.b().b(), ai2.b().b()), ai2.b(), null);
    }
    
    private boolean a(final ai ai, final M m, final boolean b, final ac ac) {
        final int a = ab.a;
        if (m == null) {
            return false;
        }
        if (ai.k() == null) {
            return true;
        }
        Object o = null;
        final int n = b ? (ai.j() - 1) : (ai.j() + 1);
        if (n < 0) {
            return false;
        }
        final Iterator<ai> iterator = ai.k().b().iterator();
        boolean b2 = false;
        while (iterator.hasNext()) {
            final w a2 = ac.a(iterator.next().i());
            if (a2.e() <= n) {
                return false;
            }
            final y h = a2.a(n).h();
            if (o == null) {
                o = h;
                if (a == 0) {
                    continue;
                }
            }
            if (o.equals(h)) {
                continue;
            }
            b2 = false;
            if (a == 0) {
                return b2;
            }
            return b2;
        }
        return b2;
    }
    
    private w a(final ai ai, final ac ac) {
        if (ai.i() == null) {
            final w w = ac.a(ai.k().b().get(0).i());
            if (ab.a == 0) {
                return w;
            }
        }
        return ac.a(ai.i());
    }
    
    private boolean a(final ai ai) {
        return ai.h() == y.b || ai.h() == y.c;
    }
    
    private M a(final ai ai, final w w) {
        final int a = ab.a;
        final int j = ai.j();
        double n = 0.0;
        Label_0107: {
            if (j == 0) {
                if (this.a(ai)) {
                    n = ai.b().a();
                    if (a == 0) {
                        break Label_0107;
                    }
                }
                n = ai.b().b();
                if (a == 0) {
                    break Label_0107;
                }
            }
            ai ai2 = w.a(j - 1);
            if (ai2.k() != null) {
                ai2 = ai2.k().c();
            }
            final h h = this.c.get(ai2);
            if (h == null) {
                return null;
            }
            n = h.b(ai2);
        }
        if (j == w.e() - 1) {
            if (this.a(ai)) {
                final double n2 = ai.b().b();
                if (a == 0) {
                    return new M(n, n2);
                }
            }
            final double n2 = ai.b().a();
            if (a == 0) {
                return new M(n, n2);
            }
        }
        ai ai3 = w.a(j + 1);
        if (ai3.k() != null) {
            ai3 = ai3.k().c();
        }
        final h h2 = this.c.get(ai3);
        if (h2 == null) {
            return null;
        }
        final double n2 = h2.b(ai3);
        return new M(n, n2);
    }
    
    private void a(final D d) {
        final int a = ab.a;
        final Iterator iterator = d.iterator();
    Label_0099:
        while (iterator.hasNext()) {
            for (final ai ai : iterator.next().d()) {
                ai.b(this.b.c().a(ai.i()).c());
                if (a != 0 || a != 0) {
                    break Label_0099;
                }
            }
        }
    }
    
    protected Comparator a(final D d, final ac ac, final Z z) {
        return new aj(d, ac, z);
    }
    
    private boolean b(final ai ai, final ai ai2) {
        final y.f.i.a.y c = this.b.c();
        final double max = Math.max(c.a(ai.i()).c(), c.a(ai2.i()).c());
        return ai.b().a(ai2.b()) && ai.c().b(ai2.c()) < max;
    }
    
    private D a(final List list) {
        final int a = ab.a;
        Collections.sort((List<Object>)list, i.a);
        final D d = new D();
        final D d2 = new D();
        Iterator<ai> iterator = list.iterator();
    Label_0036:
        while (true) {
            ai ai;
            double a2;
            D d3;
            Object o;
            C c;
            C c2;
            h h;
            double n;
            D d4;
            C m;
            h h2;
            int n2;
            boolean b;
            h h3;
            C i;
            h h4;
            Iterator iterator2;
            Label_0166_Outer:Label_0416_Outer:
            while (iterator.hasNext()) {
                ai = iterator.next();
                a2 = ai.c().a();
                d3 = new D();
                c = (C)(o = d2.m());
                if (a == 0) {
                    c2 = c;
                    while (true) {
                        while (c2.f()) {
                            h = (h)c2.d();
                            n = dcmpg(h.a().b() + this.d(h), a2);
                            if (a != 0) {
                                d.a(d3);
                                d4 = new D();
                                m = d2.m();
                                while (true) {
                                    while (m.f()) {
                                        h2 = (h)m.d();
                                        b = ((n2 = (this.a(h2, ai) ? 1 : 0)) != 0);
                                        if (a == 0) {
                                            if (b) {
                                                d4.add(h2);
                                            }
                                            m.g();
                                            if (a != 0) {
                                                break;
                                            }
                                            continue Label_0166_Outer;
                                        }
                                        else {
                                            if (n2 == 0) {
                                                d2.add(new h(ai));
                                                continue Label_0036;
                                            }
                                            if (d4.size() == 1) {
                                                ((h)d4.get(0)).a(ai);
                                                continue Label_0036;
                                            }
                                            h3 = new h(ai);
                                            i = d4.m();
                                            while (true) {
                                                while (i.f()) {
                                                    h3.a((h)i.d());
                                                    i.g();
                                                    if (a == 0) {
                                                        if (a != 0) {
                                                            break;
                                                        }
                                                        continue Label_0166_Outer;
                                                    }
                                                    else {
                                                        if (a != 0) {
                                                            break Label_0166_Outer;
                                                        }
                                                        continue Label_0036;
                                                    }
                                                }
                                                d2.removeAll(d4);
                                                d2.add(h3);
                                                continue Label_0416_Outer;
                                            }
                                        }
                                    }
                                    n2 = d4.size();
                                    continue Label_0416_Outer;
                                }
                            }
                            if (n < 0) {
                                d3.add(h);
                            }
                            c2.g();
                            if (a != 0) {
                                break;
                            }
                        }
                        d2.removeAll(d3);
                        continue Label_0416_Outer;
                    }
                }
                while (true) {
                    h4 = (h)o;
                    iterator2 = h4.d().iterator();
                    while (iterator2.hasNext()) {
                        this.c.put(iterator2.next(), h4);
                        if (a != 0 || a != 0) {
                            return d;
                        }
                    }
                    if (iterator.hasNext()) {
                        o = iterator.next();
                        continue;
                    }
                    break;
                }
                return d;
            }
            d.a(d2);
            iterator = (Iterator<ai>)d.iterator();
            continue;
        }
    }
    
    private double d(final h h) {
        final int a = ab.a;
        double n = 0.0;
        final Iterator<ai> iterator = (Iterator<ai>)h.d().iterator();
        double max = 0.0;
        while (iterator.hasNext()) {
            max = Math.max(n, this.b.c().a(iterator.next().i()).c());
            if (a != 0) {
                return max;
            }
            n = max;
            if (a != 0) {
                break;
            }
        }
        return max;
    }
    
    private boolean a(final h h, final ai ai) {
        final int a = ab.a;
        final Iterator<ai> iterator = (Iterator<ai>)h.d().iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            if (this.b(ai, iterator.next())) {
                b = true;
                if (a == 0) {
                    return b;
                }
                return b;
            }
        }
        return b;
    }
    
    private D a(final ac ac) {
        final int i = ab.a;
        final ArrayList<ai> list = new ArrayList<ai>();
        final ArrayList<ai> list2 = new ArrayList<ai>();
        final e p = this.b().p();
        do {
            Label_0030: {
                p.f();
            }
            boolean g = false;
            Label_0037:
            while (g) {
                final w a = ac.a(p.a());
                if (a != null) {
                    int j = 0;
                    while (j < a.e()) {
                        final ai a2 = a.a(j);
                        g = a2.g();
                        if (i != 0) {
                            continue Label_0037;
                        }
                        Label_0116: {
                            if (g) {
                                list2.add(a2);
                                if (i == 0) {
                                    break Label_0116;
                                }
                            }
                            list.add(a2);
                        }
                        ++j;
                        if (i != 0) {
                            break;
                        }
                    }
                }
                p.g();
                continue Label_0030;
            }
            break;
        } while (i == 0);
        final D a3 = this.a(list);
        final D a4 = this.a(list2);
        final D d = a3;
        d.a(a4);
        return d;
    }
    
    private void a(final D d, final Comparator comparator) {
        final int a = ab.a;
        final C m = d.m();
        while (m.f()) {
            this.a((h)m.d(), comparator);
            m.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private void a(final h h, final Comparator comparator) {
        this.a(h.d(), comparator);
        this.e(h);
        this.a(h);
        this.b(h);
        this.c(h);
    }
    
    protected void a(final List list, final Comparator comparator) {
        final int a = ab.a;
        final D d = new D();
        final Iterator<ai> iterator = list.iterator();
        List<ai> list3 = null;
        Label_0145: {
            while (true) {
                boolean b = iterator.hasNext();
            Label_0028:
                while (b) {
                    final ai ai = iterator.next();
                    p p2 = null;
                    final List<ai> list2 = list3 = (List<ai>)d;
                    if (a != 0) {
                        break Label_0145;
                    }
                    p p3 = ((D)list2).l();
                    while (p3 != null) {
                        final int n = (b = (comparator.compare(ai, p3.c()) != 0)) ? 1 : 0;
                        if (a != 0) {
                            continue Label_0028;
                        }
                        if (n > 0) {
                            break;
                        }
                        if (n < 0) {
                            p2 = p3;
                        }
                        p3 = p3.b();
                        if (a != 0) {
                            break;
                        }
                    }
                    if (p2 != null) {
                        d.a(ai, p2);
                        if (a == 0) {
                            continue Label_0145;
                        }
                    }
                    d.b(ai);
                    if (a != 0) {
                        break;
                    }
                    continue Label_0145;
                }
                break;
            }
            list.clear();
            list3 = (List<ai>)list;
        }
        list3.addAll(d);
    }
    
    private void b(final D d) {
        final int a = ab.a;
        for (final h h : d) {
            this.f(h);
            this.g(h);
            if (a != 0) {
                break;
            }
        }
    }
    
    private void e(final h h) {
        final int a = ab.a;
        final List d = h.d();
        final D d2 = new D();
        final HashSet<ah> set = new HashSet<ah>();
        Iterator<ai> iterator = d.iterator();
    Label_0130:
        while (true) {
        Label_0137_Outer:
            while (iterator.hasNext()) {
                final ai ai = iterator.next();
                final ah k = ai.k();
                if (k != null) {
                    k.c().b(Math.max(ai.m(), k.c().m()));
                    final boolean add = set.add(k);
                    if (a != 0) {
                    Label_0227_Outer:
                        while (true) {
                            if (add) {
                                final ah ah = (ah)iterator.next();
                                int n = 0;
                                final Iterator iterator2 = ah.b().iterator();
                                while (true) {
                                    while (iterator2.hasNext()) {
                                        n += d.indexOf(iterator2.next());
                                        if (a == 0) {
                                            if (a != 0) {
                                                break;
                                            }
                                            continue Label_0137_Outer;
                                        }
                                        else {
                                            final ai c = ah.c();
                                            this.c.put(c, h);
                                            d.add(n, c);
                                            d.removeAll(ah.b());
                                            h.a(ah);
                                            if (a != 0) {
                                                return;
                                            }
                                            break Label_0130;
                                        }
                                    }
                                    Label_0212: {
                                        break Label_0212;
                                        iterator.hasNext();
                                        continue Label_0227_Outer;
                                    }
                                    n /= ah.b().size();
                                    continue;
                                }
                            }
                            break;
                        }
                        return;
                    }
                    if (!add) {
                        continue;
                    }
                    d2.add(k);
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
            }
            iterator = (Iterator<ai>)d2.iterator();
            continue Label_0130;
        }
    }
    
    protected void a(final h h) {
        new bs(h, this.b).a();
    }
    
    protected void b(final h h) {
        new bs(h, this.b).b();
    }
    
    protected void c(final h h) {
        bs.a(h, this.b);
    }
    
    private void f(final h h) {
        final int a = ab.a;
        for (final ai ai : h.d()) {
            if (!ai.f()) {
                ai.a(h.b(ai));
                if (a != 0) {
                    break;
                }
                continue;
            }
        }
    }
    
    private void g(final h h) {
        final int i = ab.a;
        final List d = h.d();
        int n = 0;
        final int e = h.e();
        do {
            int j = 0;
        Label_0019:
            while (j < e) {
                final ah b = h.b(n);
                final ai c = b.c();
                final int index = d.indexOf(c);
                d.remove(c);
                for (final ai ai : b.b()) {
                    j = (ai.f() ? 1 : 0);
                    if (i != 0) {
                        continue Label_0019;
                    }
                    if (j == 0) {
                        ai.a(c.e());
                    }
                    d.add(index, ai);
                    if (i != 0) {
                        break;
                    }
                }
                ++n;
            }
            break;
        } while (i == 0);
    }
    
    static {
        a = new k(null);
    }
}
