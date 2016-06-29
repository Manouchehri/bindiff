package y.g.a;

import java.util.*;

class m extends r
{
    public m(final Comparator comparator) {
        super(comparator);
    }
    
    public void a(final Object d) {
        final boolean a = d.a;
        l l = null;
        l i = this.a;
        Label_0184: {
            if (i != null) {
                while (true) {
                    while (i != null) {
                        l = i;
                        final int a2 = this.a(d, i.d);
                        if (!a) {
                            if (a2 < 0) {
                                i = i.b;
                                if (!a) {
                                    continue;
                                }
                            }
                            if (this.a(d, i.d) > 0) {
                                i = i.c;
                                if (!a) {
                                    continue;
                                }
                            }
                            i.d = d;
                            return;
                        }
                        if (a2 < 0) {
                            l.a(i);
                            if (l.e == 1) {
                                l.e = 0;
                                if (!a) {
                                    break Label_0184;
                                }
                            }
                            l.e = -1;
                            this.a(l);
                            if (!a) {
                                break Label_0184;
                            }
                        }
                        l.b(i);
                        if (l.e == -1) {
                            l.e = 0;
                            if (!a) {
                                break Label_0184;
                            }
                        }
                        l.e = 1;
                        this.a(l);
                        break Label_0184;
                    }
                    i = new l(d);
                    this.a(d, l.d);
                    continue;
                }
            }
            this.a = new l(d);
        }
        ++this.b;
    }
    
    void a(final l l) {
        final boolean a = d.a;
        if (l.a == null) {
            return;
        }
        final l a2 = l.a;
        if (a2.b == l) {
            Label_0081: {
                switch (a2.e) {
                    case 1: {
                        a2.e = 0;
                        if (a) {
                            break Label_0081;
                        }
                        break;
                    }
                    case 0: {
                        a2.e = -1;
                        this.a(a2);
                        if (a) {
                            break Label_0081;
                        }
                        break;
                    }
                    case -1: {
                        Label_0135: {
                            switch (l.e) {
                                case -1: {
                                    this.e(a2);
                                    a2.e = 0;
                                    a2.c.e = 0;
                                    if (a) {
                                        break Label_0135;
                                    }
                                    break Label_0081;
                                }
                                case 1: {
                                    final byte e = a2.b.c.e;
                                    this.g(a2);
                                    a2.e = 0;
                                    Label_0226: {
                                        switch (e) {
                                            case 0: {
                                                a2.b.e = 0;
                                                a2.c.e = 0;
                                                if (a) {
                                                    break Label_0226;
                                                }
                                                break Label_0081;
                                            }
                                            case 1: {
                                                a2.b.e = -1;
                                                a2.c.e = 0;
                                                if (a) {
                                                    break Label_0226;
                                                }
                                                break Label_0081;
                                            }
                                            case -1: {
                                                a2.b.e = 0;
                                                a2.c.e = 1;
                                                break Label_0081;
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }
            if (!a) {
                return;
            }
        }
        Label_0470: {
            if (a2.c == l) {
                Label_0309: {
                    switch (a2.e) {
                        case -1: {
                            a2.e = 0;
                            if (a) {
                                break Label_0309;
                            }
                            break;
                        }
                        case 0: {
                            a2.e = 1;
                            this.a(a2);
                            if (a) {
                                break Label_0309;
                            }
                            break;
                        }
                        case 1: {
                            Label_0363: {
                                switch (l.e) {
                                    case 1: {
                                        this.d(a2);
                                        a2.e = 0;
                                        a2.b.e = 0;
                                        if (a) {
                                            break Label_0363;
                                        }
                                        break Label_0470;
                                    }
                                    case -1: {
                                        final byte e2 = a2.c.b.e;
                                        this.f(a2);
                                        a2.e = 0;
                                        Label_0454: {
                                            switch (e2) {
                                                case 0: {
                                                    a2.c.e = 0;
                                                    a2.b.e = 0;
                                                    if (a) {
                                                        break Label_0454;
                                                    }
                                                    break Label_0470;
                                                }
                                                case -1: {
                                                    a2.c.e = 1;
                                                    a2.b.e = 0;
                                                    if (a) {
                                                        break Label_0454;
                                                    }
                                                    break Label_0470;
                                                }
                                                case 1: {
                                                    a2.c.e = 0;
                                                    a2.b.e = -1;
                                                    break Label_0470;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void b(final Object o) {
        final l d = this.d(o);
        if (d != null) {
            this.b(d);
        }
        --this.b;
    }
    
    void b(final l l) {
        final boolean a = d.a;
        final l a2 = l.a;
        if (l.b == null && l.c == null) {
            if (a2 == null) {
                this.a = null;
                if (!a) {
                    return;
                }
            }
            this.c(l);
            if (l.a.b == l) {
                l.a.b = null;
                if (!a) {
                    return;
                }
            }
            l.a.c = null;
            if (!a) {
                return;
            }
        }
        if (l.b == null || l.c == null) {
            Label_0128: {
                if (l.b != null) {
                    l.d = l.b.d;
                    if (!a) {
                        break Label_0128;
                    }
                }
                l.d = l.c.d;
            }
            final l i = null;
            l.c = i;
            l.b = i;
            l.e = 0;
            this.c(l);
            if (!a) {
                return;
            }
        }
        final l h = this.h(l.c);
        r.a(l, h);
        this.b(h);
    }
    
    void c(final l l) {
        final boolean a = d.a;
        if (l.a == null) {
            return;
        }
        final l a2 = l.a;
        if (a2.b == l) {
            Label_0081: {
                switch (a2.e) {
                    case -1: {
                        a2.e = 0;
                        this.c(a2);
                        if (a) {
                            break Label_0081;
                        }
                        break;
                    }
                    case 0: {
                        a2.e = 1;
                        if (a) {
                            break Label_0081;
                        }
                        break;
                    }
                    case 1: {
                        Label_0248: {
                            switch (a2.c.e) {
                                case 0: {
                                    this.d(a2);
                                    a2.e = -1;
                                    a2.b.e = 1;
                                    if (a) {
                                        break Label_0248;
                                    }
                                    break Label_0081;
                                }
                                case -1: {
                                    final byte e = a2.c.b.e;
                                    this.f(a2);
                                    a2.e = 0;
                                    Label_0222: {
                                        switch (e) {
                                            case -1: {
                                                a2.b.e = 0;
                                                a2.c.e = 1;
                                                if (a) {
                                                    break Label_0222;
                                                }
                                                break;
                                            }
                                            case 0: {
                                                a2.c.e = 0;
                                                if (a) {
                                                    break Label_0222;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                a2.b.e = -1;
                                                a2.c.e = 0;
                                                break;
                                            }
                                        }
                                    }
                                    this.c(a2);
                                    if (a) {
                                        break Label_0248;
                                    }
                                    break Label_0081;
                                }
                                case 1: {
                                    this.d(a2);
                                    a2.e = 0;
                                    a2.b.e = 0;
                                    this.c(a2);
                                    break Label_0081;
                                }
                            }
                        }
                        break;
                    }
                }
            }
            if (!a) {
                return;
            }
        }
        Label_0531: {
            if (a2.c == l) {
                Label_0341: {
                    switch (a2.e) {
                        case 1: {
                            a2.e = 0;
                            this.c(a2);
                            if (a) {
                                break Label_0341;
                            }
                            break;
                        }
                        case 0: {
                            a2.e = -1;
                            if (a) {
                                break Label_0341;
                            }
                            break;
                        }
                        case -1: {
                            Label_0508: {
                                switch (a2.b.e) {
                                    case 0: {
                                        this.e(a2);
                                        a2.e = 1;
                                        a2.c.e = -1;
                                        if (a) {
                                            break Label_0508;
                                        }
                                        break Label_0531;
                                    }
                                    case 1: {
                                        final byte e2 = a2.b.c.e;
                                        this.g(a2);
                                        a2.e = 0;
                                        Label_0482: {
                                            switch (e2) {
                                                case 1: {
                                                    a2.c.e = 0;
                                                    a2.b.e = -1;
                                                    if (a) {
                                                        break Label_0482;
                                                    }
                                                    break;
                                                }
                                                case 0: {
                                                    a2.b.e = 0;
                                                    if (a) {
                                                        break Label_0482;
                                                    }
                                                    break;
                                                }
                                                case -1: {
                                                    a2.c.e = 1;
                                                    a2.b.e = 0;
                                                    break;
                                                }
                                            }
                                        }
                                        this.c(a2);
                                        if (a) {
                                            break Label_0508;
                                        }
                                        break Label_0531;
                                    }
                                    case -1: {
                                        this.e(a2);
                                        a2.e = 0;
                                        a2.c.e = 0;
                                        this.c(a2);
                                        break Label_0531;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    
    void d(final l l) {
        final l c = l.c;
        l.b(c.c);
        c.b(c.b);
        c.a(l.b);
        l.a(c);
        r.a(l, c);
    }
    
    void e(final l l) {
        final l b = l.b;
        l.a(b.b);
        b.a(b.c);
        b.b(l.c);
        l.b(b);
        r.a(l, b);
    }
    
    void f(final l l) {
        final l c = l.c;
        final l b = c.b;
        c.a(b.c);
        b.b(b.b);
        b.a(l.b);
        l.a(b);
        r.a(l, b);
    }
    
    void g(final l l) {
        final l b = l.b;
        final l c = b.c;
        b.b(c.b);
        c.a(c.c);
        c.b(l.c);
        l.b(c);
        r.a(l, c);
    }
}
