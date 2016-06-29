package y.f.c.a;

import java.util.*;
import y.c.*;
import y.f.*;
import y.d.*;
import y.g.*;

final class cT implements Comparator
{
    private final float[] a;
    
    public cT(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        this.a = new float[x.h()];
        int i = 0;
    Label_0298_Outer:
        while (i < au.b()) {
            final aQ a = au.a(i);
            int n = 0;
            p p3 = a.d().k();
        Label_0298:
            while (true) {
                while (p3 != null) {
                    Object c = p3.c();
                Label_0068:
                    while (true) {
                        final q q = (q)c;
                        if (!x2) {
                            d d = q.g();
                            while (d != null) {
                                final aE e = av.a(d).e();
                                final t o = x.o(d);
                                final q q2 = (q)(c = e);
                                if (x2) {
                                    continue Label_0068;
                                }
                                float n2 = 0.0f;
                                Label_0252: {
                                    if (q2 == null || e.g()) {
                                        n2 = (float)(o.a / 10000.0);
                                        if (!x2) {
                                            break Label_0252;
                                        }
                                    }
                                    Label_0220: {
                                        switch (e.b()) {
                                            case 4: {
                                                n2 = 0.3f + (float)(o.b / 10000.0);
                                                if (x2) {
                                                    break Label_0220;
                                                }
                                                break Label_0252;
                                            }
                                            case 8: {
                                                n2 = -0.3f - (float)(o.b / 10000.0);
                                                if (x2) {
                                                    break;
                                                }
                                                break Label_0252;
                                            }
                                        }
                                    }
                                    n2 = (float)(o.a / 10000.0);
                                }
                                this.a[d.b()] = n + n2;
                                d = d.h();
                                if (x2) {
                                    break;
                                }
                            }
                            break;
                        }
                        break Label_0298;
                    }
                    p3 = p3.a();
                    ++n;
                    if (x2) {
                        break;
                    }
                    continue Label_0298_Outer;
                    if (x2) {
                        break Label_0298_Outer;
                    }
                    continue Label_0298_Outer;
                }
                ++i;
                continue Label_0298;
            }
        }
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(this.a[((d)o).b()], this.a[((d)o2).b()]);
    }
}
