package y.f.h;

import y.c.*;

public class p
{
    private f a;
    
    p() {
        this.a = new f();
    }
    
    public boolean a(final q q) {
        final boolean d = N.d;
        final e a = this.a();
        while (a.f()) {
            if (a.a().c() == q) {
                return true;
            }
            a.g();
            if (d) {
                break;
            }
        }
        return false;
    }
    
    public e a() {
        return this.a.a();
    }
    
    public m b() {
        return new S(this.a.a());
    }
    
    void a(final d d) {
        this.a.b(d);
    }
    
    public void a(final d d, final d d2) {
        final boolean d3 = N.d;
        final q c = d.c();
        y.c.p p2 = this.a.k();
        while (p2 != null) {
            final d d4 = (d)p2.c();
            if (d3) {
                return;
            }
            if (d4.c().equals(c)) {
                break;
            }
            p2 = this.a.c(p2);
            if (d3) {
                break;
            }
        }
        this.a.a(d, p2);
        this.a.a(d2, p2);
    }
    
    public void a(final d d, final d d2, final d d3) {
        final boolean d4 = N.d;
        y.c.p p3 = this.a.k();
        while (p3 != null) {
            final Object c = p3.c();
            if (d4) {
                return;
            }
            if (c.equals(d)) {
                break;
            }
            p3 = this.a.c(p3);
            if (d4) {
                break;
            }
        }
        if (p3 == null) {
            System.err.println("Face: replace Edge: Edge not found !");
            return;
        }
        this.a.a(d2, p3);
        this.a.a(d3, p3);
        this.a.h(p3);
    }
    
    void a(final d d, final f f) {
        final boolean d2 = N.d;
        y.c.p p2 = this.a.k();
        while (true) {
            while (p2 != null) {
                final y.c.p p3 = p2;
                if (!d2) {
                    if (p3.c().equals(d)) {
                        break;
                    }
                    p2 = this.a.c(p2);
                    if (d2) {
                        break;
                    }
                    continue;
                }
                else {
                    if (p3 == null) {
                        System.err.println("Face: replace Edge: Edge not found !");
                        return;
                    }
                    final e a = f.a();
                    while (a.f()) {
                        this.a.a(a.a(), p2);
                        a.g();
                        if (d2) {
                            return;
                        }
                        if (d2) {
                            break;
                        }
                    }
                    this.a.h(p2);
                    return;
                }
            }
            continue;
        }
    }
    
    void b(final d d, final d d2, final d d3) {
        final boolean d4 = N.d;
        y.c.p p3 = this.a.k();
        while (true) {
            while (p3 != null) {
                final y.c.p p4 = p3;
                if (!d4) {
                    if (p4.c().equals(d)) {
                        break;
                    }
                    p3 = this.a.c(p3);
                    if (d4) {
                        break;
                    }
                    continue;
                }
                else {
                    if (p4 == null) {
                        System.err.println("Face: unreplace Edge: first edge not found !");
                        return;
                    }
                    y.c.p p5 = this.a.c(p3);
                    if (p5 == null) {
                        p5 = this.a.k();
                    }
                    if (this.a.g(p5) != d2) {
                        System.err.println("Face: unreplace Edge: second edge not found !");
                        return;
                    }
                    this.a.h(p5);
                    this.a.a(p3, d3);
                    return;
                }
            }
            continue;
        }
    }
    
    public String toString() {
        final boolean d = N.d;
        final StringBuffer sb = new StringBuffer();
        sb.append("Edges: ");
        final e a = this.a();
        while (a.f()) {
            final StringBuffer append = sb.append(a.a().toString()).append(" ");
            if (d) {
                return append.toString();
            }
            a.g();
            if (d) {
                break;
            }
        }
        final StringBuffer append = sb;
        return append.toString();
    }
}
