package y.f.d;

import y.f.b.*;
import y.c.*;
import y.f.*;
import y.d.*;

class d implements g
{
    c a;
    X b;
    
    public d(final X b, final c a) {
        this.a = a;
        this.b = b;
    }
    
    public void a(final Object o, final Object o2) {
        final int f = y.f.d.a.f;
        Q q = null;
        q q2 = null;
        if (o instanceof Q) {
            q = (Q)o;
        }
        else if (o instanceof y.f.d.c) {
            q2 = ((y.f.d.c)o).e;
        }
        Label_0074: {
            if (o2 instanceof Q) {
                q = (Q)o2;
                if (f == 0) {
                    break Label_0074;
                }
            }
            if (o2 instanceof y.f.d.c) {
                q2 = ((y.f.d.c)o2).e;
            }
        }
        if (q == null || q2 == null || !n.a(q.d(), this.b.s(q2), 0.001)) {
            return;
        }
        Label_0645: {
            Label_0303: {
                if (q instanceof ai) {
                    final ai ai = (ai)q;
                    if (ai.f()) {
                        return;
                    }
                    if (this.a != null && this.a.d(q2)) {
                        final am a = this.b.a((Object)q2);
                        final y h = ai.h();
                        q q3 = this.b.a((aj)ai.e());
                        while (q3 != null) {
                            if (q3 == q2 && a.getX() <= h.c() && a.getY() <= h.d() && a.getX() + a.getWidth() >= h.c() + h.a() && a.getY() + a.getHeight() >= h.d() + h.b()) {
                                return;
                            }
                            q3 = this.a.a(q3);
                            if (f != 0) {
                                break Label_0303;
                            }
                        }
                    }
                    break Label_0645;
                }
            }
            if (q instanceof B && this.a != null && this.a.d(q2)) {
                final B b = (B)q;
                final y.c.d a2 = this.b.a((C)b.e());
                final am a3 = this.b.a((Object)q2);
                final y h2 = b.h();
                q q4 = this.a.a(a2.c());
                while (true) {
                    while (q4 != null) {
                        final q q5 = q4;
                        final q q6 = q2;
                        if (f == 0) {
                            if (q5 == q6 && a3.getX() <= h2.c() && a3.getY() <= h2.d() && a3.getX() + a3.getWidth() >= h2.c() + h2.a() && a3.getY() + a3.getHeight() >= h2.d() + h2.b()) {
                                return;
                            }
                            q4 = this.a.a(q4);
                            if (f != 0) {
                                break;
                            }
                            continue;
                        }
                        else {
                            while (true) {
                                if (q5 == q6 && a3.getX() <= h2.c() && a3.getY() <= h2.d() && a3.getX() + a3.getWidth() >= h2.c() + h2.a() && a3.getY() + a3.getHeight() >= h2.d() + h2.b()) {
                                    return;
                                }
                                q4 = this.a.a(q4);
                                if (f != 0) {
                                    break Label_0645;
                                }
                                if (q4 != null) {
                                    continue;
                                }
                                break;
                            }
                            break Label_0645;
                        }
                    }
                    q4 = this.a.a(a2.d());
                    continue;
                }
            }
        }
        q.b(1.0);
    }
}
