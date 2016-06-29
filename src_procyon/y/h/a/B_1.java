package y.h.a;

import y.c.*;

class B implements o
{
    private final v a;
    
    B(final v a) {
        this.a = a;
    }
    
    public void onGraphEvent(final l l) {
        final int a = v.a;
        Label_0462: {
            switch (l.a()) {
                case 12: {
                    this.a.a(new t(this.a, (byte)10, null, null));
                    if (a != 0) {
                        break Label_0462;
                    }
                    break;
                }
                case 13: {
                    this.a.a(new t(this.a, (byte)11, null, null));
                    if (a != 0) {
                        break Label_0462;
                    }
                    break;
                }
                case 2: {
                    final q q = (q)l.b();
                    if (this.a.k(q)) {
                        this.a.b(new y(this.a.p(q)));
                        this.a.g(q);
                    }
                    if (this.a.k(this.a.n(q))) {
                        this.a.c(new y(q), this.a.e(l.c()));
                    }
                    v.a(this.a, l.c()).b((q)l.b());
                    this.a.a(new t(this.a, (byte)1, l.c(), l.b()));
                    if (a != 0) {
                        break Label_0462;
                    }
                    break;
                }
                case 3: {
                    final q q2 = (q)l.b();
                    v.c(this.a).a((q)v.b(this.a).get(q2));
                    v.b(this.a).remove(q2);
                    if (a != 0) {
                        break Label_0462;
                    }
                    break;
                }
                case 0:
                case 6: {
                    final q q3 = (q)l.b();
                    final q q4 = v.d(this.a).get(l.c());
                    final q d = v.c(this.a).d();
                    v.b(this.a).put(q3, d);
                    v.e(this.a).a(d, q3);
                    v.c(this.a).a(d, q4);
                    this.a.a(new t(this.a, (byte)0, l.c(), l.b()));
                    if (a != 0) {
                        break Label_0462;
                    }
                    break;
                }
                case 11: {
                    final y y = (y)l.b();
                    if (y.size() > 0) {
                        final i e = y.b().e();
                        final i c = l.c();
                        final q e2 = this.a.e(e);
                        final q e3 = this.a.e(c);
                        Label_0721: {
                            if (this.a.b(e3, e2)) {
                                final q a2 = v.a(this.a, e2);
                                final y a3 = v.a(this.a, y);
                                final x a4 = a3.a();
                                while (true) {
                                    while (a4.f()) {
                                        final q e4 = a4.e();
                                        final q a5 = v.a(this.a, e4);
                                        final d f = a5.f();
                                        final v a6 = this.a;
                                        if (a == 0) {
                                            Label_0667: {
                                                if (a6.j(e4)) {
                                                    v.c(this.a).a(f, a5, null, 1, a2, a2.g(), 1);
                                                    if (a == 0) {
                                                        break Label_0667;
                                                    }
                                                }
                                                v.c(this.a).a(f, a5, null, 1, a2, a2.i(), 0);
                                            }
                                            a4.g();
                                            if (a != 0) {
                                                break;
                                            }
                                            continue;
                                        }
                                        else {
                                            a6.a(new t(this.a, (byte)3, v.c(this.a, v.b(this.a, a2)), a3));
                                            if (a != 0) {
                                                break Label_0721;
                                            }
                                            break Label_0462;
                                        }
                                    }
                                    final v a7 = this.a;
                                    continue;
                                }
                            }
                        }
                        final q a8 = v.a(this.a, this.a.n(e3));
                        final y a9 = v.a(this.a, y);
                        final x a10 = a9.a();
                        while (true) {
                            while (a10.f()) {
                                final q e5 = a10.e();
                                final q a11 = v.a(this.a, e5);
                                final d f2 = a11.f();
                                final v a12 = this.a;
                                if (a != 0) {
                                    a12.a(new t(this.a, (byte)3, c, a9));
                                    break Label_0462;
                                }
                                Label_0881: {
                                    if (a12.j(e5) || this.a.k(e5)) {
                                        v.c(this.a).a(f2, a11, null, 1, a8, a8.g(), 1);
                                        if (a == 0) {
                                            break Label_0881;
                                        }
                                    }
                                    v.c(this.a).a(f2, a11, null, 1, a8, a8.i(), 0);
                                }
                                a10.g();
                                if (a != 0) {
                                    break;
                                }
                            }
                            final v a13 = this.a;
                            continue;
                        }
                    }
                    break;
                }
            }
        }
    }
}
