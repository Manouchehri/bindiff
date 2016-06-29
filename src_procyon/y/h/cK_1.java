package y.h;

import javax.swing.*;
import java.awt.event.*;
import y.c.*;
import java.util.*;
import y.h.b.*;

public class cK extends AbstractAction
{
    private final ch a;
    private int b;
    private int c;
    private boolean d;
    
    public cK() {
        this((ch)null);
    }
    
    public cK(final ch a) {
        super(cm.h.toString());
        this.a = a;
        this.b = 123;
        this.c = 9;
    }
    
    public int a() {
        return this.c;
    }
    
    public int b() {
        return this.b;
    }
    
    public boolean c() {
        return this.d;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final ch a = this.a(actionEvent);
        if (a != null) {
            this.a(a);
            a.getGraph2D().T();
        }
    }
    
    public void a(final ch ch) {
        final bu graph2D = ch.getGraph2D();
        graph2D.r();
        try {
            this.b(graph2D);
        }
        finally {
            graph2D.s();
        }
    }
    
    private void b(final bu bu) {
        this.a(bu, this.a(this.a(bu)));
    }
    
    protected int a(final int n) {
        final boolean z = fj.z;
        if (this.c()) {
            int a = n;
            if (a == 0) {
                a = this.a();
                if (!z) {
                    return a & this.b();
                }
            }
            if ((a & 0x9) == a) {
                a = 9;
            }
            return a & this.b();
        }
        int n2 = n;
        if (n2 == 0) {
            n2 = this.a();
        }
        Label_0087: {
            if ((n2 & 0x2) == 0x2) {
                n2 = 2;
                if (!z) {
                    break Label_0087;
                }
            }
            if ((n2 & 0x9) != 0x0) {
                n2 = 9;
                if (!z) {
                    break Label_0087;
                }
            }
            n2 = b(n2);
        }
        if ((n2 & 0x30) != 0x0) {
            n2 = 48;
        }
        return n2 & this.b();
    }
    
    private static int b(final int n) {
        return n & -n;
    }
    
    protected void a(final bu bu, final int n) {
        final boolean z = fj.z;
        final x o = bu.o();
        while (o.f()) {
            this.a(bu, o.e(), n);
            o.g();
            if (z) {
                break;
            }
        }
        final e p2 = bu.p();
        while (p2.f()) {
            this.a(bu, p2.a(), n);
            p2.g();
            if (z) {
                break;
            }
        }
    }
    
    protected void a(final bu bu, final d d, final int n) {
        final boolean z = fj.z;
        final boolean b = (n & 0x2) == 0x2;
        final boolean b2 = (n & 0x20) == 0x20;
        final boolean b3 = (n & 0x8) == 0x8;
        this.a(bu, d, b);
        final aB i = bu.i(d);
        if (i.labelCount() > 0) {
            int j = 0;
            while (j < i.labelCount()) {
                this.a(bu, i.getLabel(j), b2);
                ++j;
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
        }
        if (i.bendCount() > 0) {
            final y bends = i.bends();
            while (bends.f()) {
                this.a(bu, bends.a(), b3);
                bends.g();
                if (z) {
                    break;
                }
            }
        }
    }
    
    protected void a(final bu bu, final q q, final int n) {
        final boolean z = fj.z;
        final boolean b = (n & 0x1) == 0x1;
        final boolean b2 = (n & 0x10) == 0x10;
        final boolean b3 = (n & 0x40) == 0x40;
        final boolean b4 = (n & 0x4000) == 0x4000;
        final boolean b5 = (n & 0x8000) == 0x8000;
        this.a(bu, q, b);
        final fj t = bu.t(q);
        fj e = null;
        Label_0225: {
            Label_0223: {
                Label_0204: {
                    if (t.labelCount() > 0) {
                        int i = 0;
                        while (i < t.labelCount()) {
                            this.a(bu, t.getLabel(i), b2);
                            ++i;
                            if (z) {
                                break Label_0204;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                    if (t.portCount() > 0) {
                        final Iterator ports = t.ports();
                        while (ports.hasNext()) {
                            this.a(bu, ports.next(), b3);
                            if (z) {
                                break Label_0223;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                }
                if (t instanceof gd) {
                    e = ((gd)t).e();
                    break Label_0225;
                }
            }
            e = t;
        }
        final fj fj = e;
        if (fj instanceof a) {
            final i l = ((a)fj).l();
            this.a(bu, (y.h.b.d)l, b4);
            this.a(bu, (g)l, b5);
        }
    }
    
    private void a(final bu bu, final y.h.b.d d, final boolean b) {
        final boolean z = fj.z;
        int i = 0;
        while (i < d.k()) {
            final c b2 = d.b(i);
            this.a(bu, b2, b);
            if (b2.k() > 0) {
                this.a(bu, (y.h.b.d)b2, b);
            }
            ++i;
            if (z) {
                break;
            }
        }
    }
    
    private void a(final bu bu, final g g, final boolean b) {
        final boolean z = fj.z;
        int i = 0;
        while (i < g.n()) {
            final f c = g.c(i);
            this.a(bu, c, b);
            if (c.n() > 0) {
                this.a(bu, (g)c, b);
            }
            ++i;
            if (z) {
                break;
            }
        }
    }
    
    protected int a(final bu bu) {
        final boolean z = fj.z;
        int n = 0;
        final int b = this.b();
        int n2 = 0;
        if ((b & 0xC051) != 0x0) {
            final x o = bu.o();
            while (o.f()) {
                n |= this.a(bu, o.e());
                o.g();
                if (z) {
                    return n2;
                }
                if (z) {
                    break;
                }
            }
        }
        if ((b & 0x2A) != 0x0) {
            final e p = bu.p();
            while (p.f()) {
                n2 = (n | this.a(bu, p.a()));
                if (z) {
                    break;
                }
                n = n2;
                p.g();
                if (z) {
                    break;
                }
            }
        }
        return n2;
    }
    
    protected int a(final bu bu, final d d) {
        final boolean z = fj.z;
        int n = 0;
        if (this.b(bu, d)) {
            n |= 0x2;
        }
        final aB i = bu.i(d);
        int a = 0;
        Label_0103: {
            if ((n & 0x20) != 0x20 && i.labelCount() > 0) {
                int j = 0;
                while (j < i.labelCount()) {
                    final boolean b = (a = (this.a(bu, i.getLabel(j)) ? 1 : 0)) != 0;
                    if (z) {
                        break Label_0103;
                    }
                    if (b) {
                        n |= 0x20;
                        if (!z) {
                            break;
                        }
                    }
                    ++j;
                    if (z) {
                        break;
                    }
                }
            }
            a = (n & 0x8);
        }
        if (a != 8 && i.bendCount() > 0) {
            final y bends = i.bends();
            while (bends.f()) {
                final int a2;
                final boolean b2 = (a2 = (this.a(bu, bends.a()) ? 1 : 0)) != 0;
                if (z) {
                    return a2;
                }
                if (b2) {
                    n |= 0x8;
                    if (!z) {
                        break;
                    }
                }
                bends.g();
                if (z) {
                    break;
                }
            }
        }
        return n;
    }
    
    protected int a(final bu bu, final q q) {
        final boolean z = fj.z;
        int n = 0;
        if (this.b(bu, q)) {
            n |= 0x1;
        }
        final fj t = bu.t(q);
        int a = 0;
        Label_0103: {
            if ((n & 0x10) != 0x10 && t.labelCount() > 0) {
                int i = 0;
                while (i < t.labelCount()) {
                    final boolean b = (a = (this.a(bu, t.getLabel(i)) ? 1 : 0)) != 0;
                    if (z) {
                        break Label_0103;
                    }
                    if (b) {
                        n |= 0x10;
                        if (!z) {
                            break;
                        }
                    }
                    ++i;
                    if (z) {
                        break;
                    }
                }
            }
            a = (n & 0x40);
        }
        if (a != 64 && t.portCount() > 0) {
            final Iterator ports = t.ports();
            while (ports.hasNext()) {
                if (this.a(bu, ports.next())) {
                    n |= 0x40;
                    if (!z) {
                        break;
                    }
                    return n;
                }
            }
        }
        if ((this.b() & 0xC000) != 0x0) {
            final fj fj = (t instanceof gd) ? ((gd)t).e() : t;
            if (fj instanceof a) {
                final i l = ((a)fj).l();
                if ((n & 0x4000) != 0x4000 && this.a(bu, (y.h.b.d)l)) {
                    n |= 0x4000;
                }
                if ((n & 0x8000) != 0x8000 && this.a(bu, (g)l)) {
                    n |= 0x8000;
                }
            }
        }
        return n;
    }
    
    private boolean a(final bu bu, final y.h.b.d d) {
        final boolean z = fj.z;
        int i = 0;
        boolean a = false;
        while (i < d.k()) {
            final c b = d.b(i);
            a = this.a(bu, b);
            if (z) {
                return a;
            }
            if (a) {
                return true;
            }
            if (b.k() > 0 && this.a(bu, (y.h.b.d)b)) {
                return true;
            }
            ++i;
            if (z) {
                break;
            }
        }
        return a;
    }
    
    private boolean a(final bu bu, final g g) {
        final boolean z = fj.z;
        int i = 0;
        boolean a = false;
        while (i < g.n()) {
            final f c = g.c(i);
            a = this.a(bu, c);
            if (z) {
                return a;
            }
            if (a) {
                return true;
            }
            if (c.n() > 0 && this.a(bu, (g)c)) {
                return true;
            }
            ++i;
            if (z) {
                break;
            }
        }
        return a;
    }
    
    protected void a(final bu bu, final eU eu, final boolean b) {
        bu.a(eu, b);
    }
    
    protected void a(final bu bu, final q q, final boolean b) {
        bu.a(q, b);
    }
    
    protected void a(final bu bu, final d d, final boolean b) {
        bu.a(d, b);
    }
    
    protected void a(final bu bu, final gZ gz, final boolean b) {
        bu.a(gz, b);
    }
    
    protected void a(final bu bu, final y.h.x x, final boolean b) {
        bu.a(x, b);
    }
    
    protected void a(final bu bu, final c c, final boolean b) {
        c.a(b);
    }
    
    protected void a(final bu bu, final f f, final boolean b) {
        f.a(b);
    }
    
    protected boolean a(final bu bu, final y.h.x x) {
        return bu.a(x);
    }
    
    protected boolean a(final bu bu, final gZ gz) {
        return bu.a(gz);
    }
    
    protected boolean b(final bu bu, final d d) {
        return bu.r(d);
    }
    
    protected boolean b(final bu bu, final q q) {
        return bu.v(q);
    }
    
    protected boolean a(final bu bu, final eU eu) {
        return bu.a(eu);
    }
    
    protected boolean a(final bu bu, final c c) {
        return c.e();
    }
    
    protected boolean a(final bu bu, final f f) {
        return f.e();
    }
    
    protected ch a(final ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }
}
