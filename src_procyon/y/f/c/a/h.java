package y.f.c.a;

import y.d.*;
import y.c.*;

class h
{
    private double[] a;
    private double[] b;
    private double c;
    private double d;
    private int e;
    private final f f;
    
    public h(final f f) {
        this.f = f;
        this.a = new double[y.f.c.a.f.a(f).f()];
        this.b = new double[y.f.c.a.f.a(f).f()];
    }
    
    public void a(final i i, final aU au) {
        final boolean x = N.x;
        final aU b = i.b();
        if (b.b() == 0) {
            return;
        }
        if (au.b() == 0) {
            this.a(b, au, 0);
            if (!x) {
                return;
            }
        }
        final double[][] e = i.e();
        double n = 0.0;
        int n2 = 0;
        int j = 0;
        while (j <= au.b()) {
            final q a = this.a(e, au, j);
            if (x) {
                return;
            }
            if (a.a == this.d && a.b == this.c) {
                n2 = j;
                if (!x) {
                    break;
                }
            }
            final double n3 = a.a / a.b;
            if (j == 0 || y.f.c.a.f.a(this.f, n3, n)) {
                n2 = j;
                n = n3;
            }
            ++j;
            if (x) {
                break;
            }
        }
        this.a(b, au, n2);
    }
    
    private q a(final double[][] array, final aU au, final int n) {
        final boolean x = N.x;
        double c = this.c;
        double n2 = this.d;
        int i = au.b();
        int j = 0;
    Label_0083_Outer:
        while (j < array.length) {
            final int n3 = j + n;
            while (true) {
                while (i <= n3) {
                    final double n5;
                    final int n4 = (int)(n5 = i);
                    if (!x) {
                        if (n4 > 0) {
                            c += 30.0;
                        }
                        ++i;
                        if (x) {
                            break;
                        }
                        continue Label_0083_Outer;
                    }
                    else {
                        n2 = Math.max(n2, this.a[n3] + array[j][1] + ((n5 == 0 && this.a[n3] == 0.0) ? 0.0 : 30.0));
                        final double n6 = array[j][0] - this.b[n3];
                        if (n6 > 0.0) {
                            c += n6;
                        }
                        ++j;
                        if (x) {
                            break Label_0083_Outer;
                        }
                        continue Label_0083_Outer;
                    }
                }
                double n5 = dcmpl(this.b[n3], 0.0);
                continue;
            }
        }
        return new q(n2, c);
    }
    
    private void a(final aU au, final aU au2, final int n) {
        final boolean x = N.x;
        int n2 = 0;
        do {
            int i = 0;
        Label_0010:
            while (i < au.b()) {
                final aQ a = au.a(n2);
                final int n3 = n2 + n;
                while (au2.b() <= n3) {
                    au2.a(a.e(), au2.b());
                    i = this.e;
                    if (x) {
                        continue Label_0010;
                    }
                    if (i > 0) {
                        this.c += 30.0;
                    }
                    ++this.e;
                    if (x) {
                        break;
                    }
                }
                final aQ a2 = au2.a(n3);
                double max = 0.0;
                p p3 = a.d().k();
                while (p3 != null) {
                    final y.c.q q = (y.c.q)p3.c();
                    max = Math.max(max, y.f.c.a.f.a(this.f, q));
                    final boolean empty = a2.d().isEmpty();
                    if (x) {
                        continue Label_0010;
                    }
                    if (!empty) {
                        final double[] a3 = this.a;
                        final int n4 = n3;
                        a3[n4] += 30.0;
                    }
                    final double[] a4 = this.a;
                    final int n5 = n3;
                    a4[n5] += y.f.c.a.f.b(this.f, q);
                    a2.a(q);
                    p3 = p3.a();
                    if (x) {
                        break;
                    }
                }
                final double n6 = max - this.b[n3];
                if (n6 > 0.0) {
                    final double[] b = this.b;
                    final int n7 = n3;
                    b[n7] += n6;
                    this.c += n6;
                }
                this.d = Math.max(this.d, this.a[n3]);
                ++n2;
            }
            break;
        } while (!x);
    }
}
