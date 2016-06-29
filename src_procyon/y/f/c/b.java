package y.f.c;

import y.f.*;
import y.c.*;

public class b implements v
{
    public static final Object a;
    private v b;
    
    public b(final v b) {
        if (b == null) {
            throw new NullPointerException();
        }
        this.b = b;
    }
    
    protected void a(final X x, final y[] array) {
        final boolean i = y.f.c.a.i;
        double n = 0.0;
        int j = 0;
    Label_0275_Outer:
        while (j < array.length) {
            final x a = array[j].a();
            double max = 0.0;
            double max2 = 0.0;
            double min = Double.MAX_VALUE;
            double max3 = -1.7976931348623157E308;
            a.i();
            while (a.f()) {
                final q e = a.e();
                final am a2 = x.a((Object)e);
                min = Math.min(min, a2.getY());
                max3 = Math.max(max3, a2.getY() + a2.getHeight());
                final double a3 = a(e);
                max = Math.max(max, a2.getHeight() * 0.5 + a3);
                max2 = Math.max(max2, a2.getHeight() * 0.5 - a3);
                a.g();
                if (i) {
                    continue Label_0275_Outer;
                }
                if (i) {
                    break;
                }
            }
            final double n2 = max + max2;
            final double n3 = min + n + max;
            a.i();
            while (true) {
                while (a.f()) {
                    final q e2 = a.e();
                    x.a(e2, x.j(e2), n3 - a(e2));
                    a.g();
                    if (!i) {
                        if (i) {
                            break;
                        }
                        continue Label_0275_Outer;
                    }
                    else {
                        if (i) {
                            break Label_0275_Outer;
                        }
                        continue Label_0275_Outer;
                    }
                }
                n += n2 - (max3 - min);
                ++j;
                continue;
            }
        }
    }
    
    private static final double a(final q q) {
        final c c = q.e().c(b.a);
        if (c == null) {
            return 0.0;
        }
        return c.c(q);
    }
    
    public void a(final X x, final y[] array, final c c) {
        this.b.a(x, array, c);
        this.a(x, array);
    }
    
    public void a(final A a) {
        this.b.a(a);
    }
    
    public void a(final double n) {
        this.b.a(n);
    }
    
    public void d(final double n) {
        this.b.d(n);
    }
    
    public void b(final double n) {
        this.b.b(n);
    }
    
    public void c(final double n) {
        this.b.c(n);
    }
    
    static {
        a = "y.layout.hierarchic.AlignmentDrawer.NODE_ALIGNMENT_POINT_DPKEY";
    }
}
