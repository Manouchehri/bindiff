package y.f.c.a;

import java.util.*;
import y.c.*;
import y.f.*;
import y.d.*;
import y.g.*;

final class cY implements Comparator
{
    private final float[] a;
    
    public cY(final X x, final aU au, final aV av) {
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
                            d d = q.f();
                            while (d != null) {
                                final aE c2 = av.a(d).c();
                                final t n2 = x.n(d);
                                final q q2 = (q)(c = c2);
                                if (x2) {
                                    continue Label_0068;
                                }
                                float n3 = 0.0f;
                                Label_0252: {
                                    if (q2 == null || c2.g()) {
                                        n3 = (float)(n2.a / 10000.0);
                                        if (!x2) {
                                            break Label_0252;
                                        }
                                    }
                                    Label_0220: {
                                        switch (c2.b()) {
                                            case 4: {
                                                n3 = 0.3f - (float)(n2.b / 10000.0);
                                                if (x2) {
                                                    break Label_0220;
                                                }
                                                break Label_0252;
                                            }
                                            case 8: {
                                                n3 = -0.3f + (float)(n2.b / 10000.0);
                                                if (x2) {
                                                    break;
                                                }
                                                break Label_0252;
                                            }
                                        }
                                    }
                                    n3 = (float)(n2.a / 10000.0);
                                }
                                this.a[d.b()] = n + n3;
                                d = d.g();
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
