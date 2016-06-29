package y.f;

import y.f.c.a.*;
import y.g.*;
import y.f.b.*;
import y.c.*;
import y.d.*;

public class an extends a
{
    c a;
    c b;
    c c;
    c d;
    private b e;
    private b f;
    private byte g;
    private int h;
    private boolean i;
    
    public an(final ah ah) {
        this();
        this.a(ah);
        this.a((byte)0);
    }
    
    public an() {
        this.e = null;
        this.f = null;
        this.h = 4;
        this.i = true;
    }
    
    public an(final byte b) {
        this.e = null;
        this.f = null;
        this.h = 4;
        this.i = true;
        this.a(b);
    }
    
    public void a(final byte g) {
        this.g = g;
    }
    
    public byte b() {
        return this.g;
    }
    
    public int c() {
        return this.h;
    }
    
    public void a(final int h) {
        this.h = h;
    }
    
    public boolean d() {
        return this.g == 1 || this.g == 3;
    }
    
    public boolean e() {
        return this.i;
    }
    
    public void a(final boolean i) {
        this.i = i;
    }
    
    public void c(final X x) {
        x.a("PARTITION_ORIENTATION_DPKEY", q.a(this));
        final ao ao = new ao(this);
        final bk c = bk.c(x);
        if (c != null) {
            c.b(this, ao);
        }
        this.e = M.c();
        this.f = M.c();
        this.b(x);
        if (this.a() != null) {
            this.a(x);
        }
        this.d(x);
        this.e = null;
        this.f = null;
        if (c != null) {
            c.a(this, ao);
        }
        x.d_("PARTITION_ORIENTATION_DPKEY");
    }
    
    public boolean b(final byte b) {
        final boolean j = X.j;
        Label_0093: {
            switch (b) {
                case 0: {
                    final boolean b2 = (0x1 & this.h) != 0x0;
                    if (j) {
                        break Label_0093;
                    }
                    return b2;
                }
                case 3: {
                    final boolean b2 = (0x2 & this.h) != 0x0;
                    if (j) {
                        break Label_0093;
                    }
                    return b2;
                }
                case 2: {
                    final boolean b2 = (0x4 & this.h) != 0x0;
                    if (j) {
                        break Label_0093;
                    }
                    return b2;
                }
                case 1: {
                    final boolean b2 = (0x8 & this.h) != 0x0;
                    if (j) {
                        break;
                    }
                    return b2;
                }
            }
        }
        return false;
    }
    
    protected void b(final X x) {
        this.i(x);
        this.l(x);
        this.o(x);
        this.p(x);
        this.g(x);
        this.e(x);
    }
    
    private void e(final X x) {
        final c c = x.c(y.f.b.f.f);
        if (c != null) {
            x.a(y.f.b.f.f, new ar(this, c));
        }
    }
    
    private void f(final X x) {
        final c c = x.c(y.f.b.f.f);
        if (c != null) {
            final c a = ((ar)c).a;
            x.d_(y.f.b.f.f);
            x.a(y.f.b.f.f, a);
        }
    }
    
    private void g(final X x) {
        final c c = x.c(y.f.b.f.e);
        if (y.f.b.c.b(x) && c != null) {
            x.a(y.f.b.f.e, new ap(this, c));
        }
    }
    
    private void h(final X x) {
        final c c = x.c(y.f.b.f.e);
        if (y.f.b.c.b(x) && c instanceof ap) {
            final c a = ((ap)c).a;
            x.d_(y.f.b.f.e);
            x.a(y.f.b.f.e, a);
        }
    }
    
    private void i(final X x) {
        final boolean j = X.j;
        final x o = x.o();
        while (o.f()) {
            final t l = x.l(o.e());
            if (this.d()) {
                final am h = x.h(o.e());
                h.setSize(h.getHeight(), h.getWidth());
            }
            x.a(o.e(), this.a(l));
            o.g();
            if (j) {
                break;
            }
        }
    }
    
    protected void d(final X x) {
        this.j(x);
        this.k(x);
        this.m(x);
        this.n(x);
        this.h(x);
        this.f(x);
    }
    
    private void j(final X x) {
        final boolean j = X.j;
        final x o = x.o();
        while (o.f()) {
            final t l = x.l(o.e());
            if (this.d()) {
                final am h = x.h(o.e());
                h.setSize(h.getHeight(), h.getWidth());
            }
            x.a(o.e(), this.b(l));
            o.g();
            if (j) {
                break;
            }
        }
    }
    
    private void k(final X x) {
        final boolean j = X.j;
        final e p = x.p();
    Label_0135_Outer:
        while (p.f()) {
            final I b = x.b((Object)p.a());
            b.setSourcePoint(this.b(b.getSourcePoint()));
            b.setTargetPoint(this.b(b.getTargetPoint()));
            int i = 0;
            while (true) {
                while (i < b.pointCount()) {
                    final t b2 = this.b(b.getPoint(i));
                    b.setPoint(i, b2.a(), b2.b());
                    ++i;
                    if (!j) {
                        if (j) {
                            break;
                        }
                        continue Label_0135_Outer;
                    }
                    else {
                        if (j) {
                            break Label_0135_Outer;
                        }
                        continue Label_0135_Outer;
                    }
                }
                p.g();
                continue;
            }
        }
    }
    
    private void l(final X x) {
        final boolean j = X.j;
        final e p = x.p();
    Label_0135_Outer:
        while (p.f()) {
            final I b = x.b((Object)p.a());
            b.setSourcePoint(this.a(b.getSourcePoint()));
            b.setTargetPoint(this.a(b.getTargetPoint()));
            int i = 0;
            while (true) {
                while (i < b.pointCount()) {
                    final t a = this.a(b.getPoint(i));
                    b.setPoint(i, a.a(), a.b());
                    ++i;
                    if (!j) {
                        if (j) {
                            break;
                        }
                        continue Label_0135_Outer;
                    }
                    else {
                        if (j) {
                            break Label_0135_Outer;
                        }
                        continue Label_0135_Outer;
                    }
                }
                p.g();
                continue;
            }
        }
    }
    
    protected t a(final t t, final boolean b) {
        return b ? this.a(t) : this.b(t);
    }
    
    protected t a(final t t) {
        if (this.b(this.g)) {
            switch (this.g) {
                case 0: {
                    return new t(-t.a, t.b);
                }
                case 1: {
                    return new t(t.b(), t.a());
                }
                case 3: {
                    return new t(-t.b(), -t.a());
                }
                case 2: {
                    return new t(t.a(), -t.b());
                }
                default: {
                    if (X.j) {
                        break;
                    }
                    return t;
                }
            }
        }
        switch (this.g) {
            case 0: {
                return t;
            }
            case 1: {
                return new t(-t.b(), t.a());
            }
            case 3: {
                return new t(t.b(), -t.a());
            }
            case 2: {
                return new t(-t.a(), -t.b());
            }
            default: {
                return t;
            }
        }
    }
    
    protected t b(final t t) {
        if (this.b(this.g)) {
            switch (this.g) {
                case 0: {
                    return new t(-t.a, t.b);
                }
                case 1: {
                    return new t(t.b(), t.a());
                }
                case 3: {
                    return new t(-t.b(), -t.a());
                }
                case 2: {
                    return new t(t.a(), -t.b());
                }
                default: {
                    if (X.j) {
                        break;
                    }
                    return t;
                }
            }
        }
        switch (this.g) {
            case 0: {
                return t;
            }
            case 1: {
                return new t(t.b(), -t.a());
            }
            case 3: {
                return new t(-t.b(), t.a());
            }
            case 2: {
                return new t(-t.a(), -t.b());
            }
            default: {
                return t;
            }
        }
    }
    
    private void m(final X x) {
        if (this.a != null) {
            x.a(aF.a, this.a);
            this.a = null;
            this.c = null;
        }
        if (this.b != null) {
            x.a(aF.b, this.b);
            this.b = null;
            this.d = null;
        }
    }
    
    private void n(final X x) {
        this.a(x, false);
    }
    
    private void o(final X x) {
        this.a = x.c(aF.a);
        if (this.a != null) {
            this.c = new aq(this, this.a);
            x.a(aF.a, this.c);
        }
        this.b = x.c(aF.b);
        if (this.b != null) {
            this.d = new aq(this, this.b);
            x.a(aF.b, this.d);
        }
    }
    
    private void p(final X x) {
        this.a(x, true);
    }
    
    private void a(final X x, final boolean b) {
        this.c(x, b);
        if (this.e()) {
            this.b(x, b);
        }
    }
    
    private void b(final X x, final boolean b) {
        final boolean j = X.j;
        final c c = x.c(U.a);
        if (c != null) {
            final e p2 = x.p();
            while (p2.f()) {
                final S[] array = (S[])c.b(p2.a());
                Label_0107: {
                    if (array != null && array.length > 0) {
                        int i = 0;
                        while (i < array.length) {
                            this.b(array[i], b);
                            ++i;
                            if (j) {
                                break Label_0107;
                            }
                            if (j) {
                                break;
                            }
                        }
                    }
                    p2.g();
                }
                if (j) {
                    break;
                }
            }
        }
    }
    
    private void c(final X x, final boolean b) {
        final boolean j = X.j;
        final c c = x.c(U.b);
        if (c != null) {
            final x o = x.o();
            while (o.f()) {
                final S[] array = (S[])c.b(o.e());
                Label_0107: {
                    if (array != null && array.length > 0) {
                        int i = 0;
                        while (i < array.length) {
                            this.a(array[i], b);
                            ++i;
                            if (j) {
                                break Label_0107;
                            }
                            if (j) {
                                break;
                            }
                        }
                    }
                    o.g();
                }
                if (j) {
                    break;
                }
            }
        }
    }
    
    private void a(final S s, final boolean b) {
        final t a = this.a(new t(s.d() + s.b() / 2.0, s.e() + s.c() / 2.0), b);
        final t a2 = this.a(new t(s.a().g(), s.a().i()), b);
        s.a().c(a2.a, a2.b);
        s.a(a.a() - s.b() / 2.0, a.b() - s.c() / 2.0);
    }
    
    private void b(final S s, final boolean b) {
        final t a = this.a(new t(s.d() + s.b() / 2.0, s.e() + s.c() / 2.0), b);
        final t a2 = this.a(new t(s.a().g(), s.a().i()), b);
        s.a().c(a2.a, a2.b);
        s.a(a.a() - s.b() / 2.0, a.b() - s.c() / 2.0);
        if (this.b(this.g)) {
            if (b) {
                final aG f = s.f();
                byte b2 = 0;
                if (f.m()) {
                    b2 |= 0x8;
                }
                if (f.l()) {
                    b2 |= 0x20;
                }
                if (f.n()) {
                    b2 |= 0x10;
                }
                if (f.b() == b2) {
                    return;
                }
                this.e.a(s, f);
                aG ag = (aG)this.f.b(f);
                if (ag == null) {
                    ag = new aG(f);
                    ag.b(b2);
                    this.f.a(f, ag);
                }
                s.a(ag);
                if (!X.j) {
                    return;
                }
            }
            final aG ag2 = (aG)this.e.b(s);
            if (ag2 != null) {
                s.a(ag2);
            }
        }
    }
    
    public r a(final r r) {
        if (this.b(this.g)) {
            switch (this.g) {
                case 2: {
                    return new r(r.c, r.b, r.a, r.d);
                }
                case 1: {
                    return new r(r.b, r.a, r.d, r.c);
                }
                case 3: {
                    return new r(r.d, r.c, r.b, r.a);
                }
                default: {
                    return new r(r.a, r.d, r.c, r.b);
                }
            }
        }
        else {
            switch (this.g) {
                case 2: {
                    return new r(r.c, r.d, r.a, r.b);
                }
                case 1: {
                    return new r(r.b, r.c, r.d, r.a);
                }
                case 3: {
                    return new r(r.d, r.a, r.b, r.c);
                }
                default: {
                    return r;
                }
            }
        }
    }
    
    public y.d.q a(final y.d.q q) {
        switch (this.g) {
            case 1:
            case 3: {
                return new y.d.q(q.b(), q.a());
            }
            default: {
                return new y.d.q(q.a(), q.b());
            }
        }
    }
}
