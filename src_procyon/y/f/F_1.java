package y.f;

import java.util.*;
import y.c.*;
import y.d.*;

public class F
{
    private final Map a;
    private final Map b;
    
    public F() {
        this.a = new HashMap();
        this.b = new HashMap();
    }
    
    private static byte d(final i i) {
        final c c = i.c("PARTITION_ORIENTATION_DPKEY");
        if (c != null) {
            return ((an)c.b(i)).b();
        }
        return 0;
    }
    
    static boolean a(final i i) {
        final c c = i.c("PARTITION_ORIENTATION_DPKEY");
        if (c != null) {
            final an an = (an)c.b(i);
            return an.b(an.b());
        }
        return false;
    }
    
    public void b(final i i) {
        final boolean j = X.j;
        final c c = i.c(U.a);
        if (c != null) {
            final e p = i.p();
            while (p.f()) {
                final S[] array = (S[])c.b(p.a());
                Label_0130: {
                    if (array != null) {
                        int k = 0;
                        while (k < array.length) {
                            final S s = array[k];
                            final aG f = s.f();
                            final aG a = this.a(f);
                            this.b.put(a, f);
                            s.a(a);
                            ++k;
                            if (j) {
                                break Label_0130;
                            }
                            if (j) {
                                break;
                            }
                        }
                    }
                    p.g();
                }
                if (j) {
                    break;
                }
            }
        }
    }
    
    public void c(final i i) {
        final boolean j = X.j;
        final c c = i.c(U.a);
        if (c != null) {
            final e p = i.p();
            while (p.f()) {
                final S[] array = (S[])c.b(p.a());
                Label_0124: {
                    if (array != null) {
                        int k = 0;
                        while (k < array.length) {
                            final S s = array[k];
                            s.a((aG)this.b.get(s.f()));
                            ++k;
                            if (j) {
                                break Label_0124;
                            }
                            if (j) {
                                break;
                            }
                        }
                    }
                    p.g();
                }
                if (j) {
                    break;
                }
            }
        }
    }
    
    public void a(final i i, final S s, final y y) {
        if (this.a.containsKey(s)) {
            return;
        }
        final aG f = s.f();
        final y a = a(i, y);
        this.a.put(s, new H(f, a, null));
        s.a(this.a(i, this.a(f), a));
        a(s, y);
    }
    
    private aG a(final aG ag) {
        final boolean j = X.j;
        final aG ag2 = new aG(ag);
        Label_0050: {
            if (ag.i()) {
                ag2.a((byte)1);
                if (!j) {
                    break Label_0050;
                }
            }
            if (ag.j()) {
                ag2.a((byte)4);
                if (!j) {
                    break Label_0050;
                }
            }
            ag2.a((byte)2);
        }
        Label_0090: {
            if (ag.l()) {
                ag2.b((byte)16);
                if (!j) {
                    break Label_0090;
                }
            }
            if (ag.m()) {
                ag2.b((byte)8);
                if (!j) {
                    break Label_0090;
                }
            }
            ag2.b((byte)32);
        }
        Label_0127: {
            if (ag.u()) {
                ag2.c((byte)1);
                if (!j) {
                    break Label_0127;
                }
            }
            if (ag.v()) {
                ag2.c((byte)2);
                if (!j) {
                    break Label_0127;
                }
            }
            ag2.c((byte)4);
        }
        Label_0148: {
            if (ag.p()) {
                ag2.d((byte)2);
                if (!j) {
                    break Label_0148;
                }
            }
            ag2.d((byte)1);
        }
        Label_0169: {
            if (ag.q()) {
                ag2.e((byte)1);
                if (!j) {
                    break Label_0169;
                }
            }
            ag2.e((byte)2);
        }
        if (ag.s()) {
            ag2.f((byte)1);
            if (!j) {
                return ag2;
            }
        }
        ag2.f((byte)2);
        return ag2;
    }
    
    public void a(final i i, final S s) {
        final t a = this.a(i, s.a().k());
        final H h = this.a.get(s);
        if (h != null) {
            s.a(this.a(H.a(h)));
            a(s, H.b(h));
            s.a(H.a(h));
            this.a.remove(s);
        }
        s.a().b(a);
    }
    
    private aG a(final i i, final aG ag, final y y) {
        final aG ag2 = new aG(ag);
        ag2.b(this.b(i, ag, y));
        ag2.c((byte)1);
        double c = this.c(i, ag, y);
        if (ag.n()) {
            if (ag2.r()) {
                c = 3.141592653589793 - c;
            }
            if (ag2.t()) {
                c += 3.141592653589793;
            }
        }
        ag2.a(c);
        ag2.d((byte)2);
        ag2.e((byte)1);
        ag2.f((byte)1);
        return ag2;
    }
    
    private byte b(final i i, final aG ag, final y y) {
        byte b = ag.b();
        if ((ag.v() && (y == y.c || y == y.d)) || (ag.w() && (y == y.c || y == y.b))) {
            b = this.a(b);
        }
        if (a(i)) {
            b = this.a(b);
        }
        return b;
    }
    
    private double c(final i i, final aG ag, final y y) {
        final boolean j = X.j;
        double d = ag.d();
        Label_0102: {
            if (ag.p()) {
                d += 0.0;
                if (!j) {
                    break Label_0102;
                }
            }
            if (y == y.b) {
                d += 0.0;
                if (!j) {
                    break Label_0102;
                }
            }
            if (y == y.a) {
                d += 1.5707963267948966;
                if (!j) {
                    break Label_0102;
                }
            }
            if (y == y.d) {
                d += 3.141592653589793;
                if (!j) {
                    break Label_0102;
                }
            }
            if (y == y.c) {
                d += 4.71238898038469;
            }
        }
        if (a(i)) {
            d = 3.141592653589793 - d;
        }
        return d;
    }
    
    private t a(final i i, final t t) {
        final byte d = d(i);
        if (a(i)) {
            switch (d) {
                case 0: {
                    return new t(-t.a(), t.b());
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
        switch (d) {
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
    
    private static y a(final i i, final y y) {
        final y y2 = (a(i) && y.d()) ? y.c() : y;
        switch (d(i)) {
            case 0: {
                return y2;
            }
            case 2: {
                return y2.c();
            }
            case 1: {
                return y2.b();
            }
            case 3: {
                return y2.a();
            }
            default: {
                return null;
            }
        }
    }
    
    private byte a(final byte b) {
        switch (b) {
            case 16: {
                return 32;
            }
            case 32: {
                return 16;
            }
            default: {
                return 8;
            }
        }
    }
    
    public static void a(final S s, final y y) {
        final z a = a(s.f(), y);
        final n a2 = s.a();
        a2.c(a.a(), a.b());
        s.a(a2);
    }
    
    public static z a(final aG ag, final y y) {
        final boolean j = X.j;
        double n = 0.0;
        Label_0090: {
            if (ag.o()) {
                n = 0.0;
                if (!j) {
                    break Label_0090;
                }
            }
            if (y.b.equals(y)) {
                n = 0.0;
                if (!j) {
                    break Label_0090;
                }
            }
            if (y.c.equals(y)) {
                n = 1.5707963267948966;
                if (!j) {
                    break Label_0090;
                }
            }
            if (y.d.equals(y)) {
                n = 3.141592653589793;
                if (!j) {
                    break Label_0090;
                }
            }
            if (y.a.equals(y)) {
                n = 4.71238898038469;
            }
        }
        double d = ag.d();
        if (ag.n()) {
            if (ag.r()) {
                d = -d;
            }
            if (ag.t()) {
                d -= 3.141592653589793;
            }
        }
        return a(n + d);
    }
    
    public static z a(final double n) {
        return new z(Math.sin(n), -Math.cos(n));
    }
}
