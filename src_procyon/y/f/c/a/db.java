package y.f.c.a;

import y.f.*;
import y.g.*;
import y.c.*;
import java.util.*;

class db
{
    private boolean a;
    private bK[] b;
    
    public db() {
        this.a = false;
        this.b = null;
    }
    
    public void a(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        if (!this.a) {
            return;
        }
        final int[] array = new int[x.e()];
        final dc dc = new dc(this, array);
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            final bK h = av.a(e).h();
            Label_0109: {
                if (h != null) {
                    array[e.d()] = h.j();
                    if (!x2) {
                        break Label_0109;
                    }
                }
                array[e.d()] = -1;
            }
            o.g();
            if (x2) {
                break;
            }
        }
        Object[] array2 = null;
        int n = 0;
    Label_0477:
        do {
            int i = 0;
        Label_0129:
            while (i < au.b()) {
                final aQ a = au.a(n);
                final p l = a.d().l();
                p p3 = null;
                for (p p4 = a.d().k(); p4 != l; p4 = p4.a()) {
                    final int d = ((q)p4.c()).d();
                    final int d2 = ((q)p4.a().c()).d();
                    i = array[d];
                    if (x2) {
                        continue Label_0129;
                    }
                    if (i >= 0 && array[d2] >= 0 && array[d] > array[d2]) {
                        p3 = p4;
                        break;
                    }
                }
                Label_0474: {
                    if (p3 != null) {
                        int n2 = -1;
                        if (array2 == null || array2.length < a.d().size()) {
                            array2 = new q[a.d().size()];
                        }
                        int n3 = 0;
                        p p5 = a.d().k();
                        while (true) {
                            while (p5 != null) {
                                final int d3 = ((q)p5.c()).d();
                                final int n5;
                                final int n4 = n5 = array[d3];
                                if (x2) {
                                    int n6 = n5;
                                    p p6 = a.d().k();
                                    while (p6 != null) {
                                        p6.a(array2[n6]);
                                        p6 = p6.a();
                                        ++n6;
                                        if (x2) {
                                            continue Label_0477;
                                        }
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    a.a(a.d());
                                    break Label_0474;
                                }
                                Label_0372: {
                                    if (n5 < 0) {
                                        array[d3] = n2;
                                        if (!x2) {
                                            break Label_0372;
                                        }
                                    }
                                    n2 = n4;
                                }
                                array2[n3] = p5.c();
                                p5 = p5.a();
                                ++n3;
                                if (x2) {
                                    break;
                                }
                            }
                            e.a(array2, 0, n3, dc);
                            continue;
                        }
                    }
                }
                ++n;
            }
            break;
        } while (!x2);
    }
    
    public void b(final X x, final aU au, final aV av) {
        final boolean x2 = N.x;
        final ArrayList<Object> list = new ArrayList<Object>();
        int i = 0;
    Label_0124_Outer:
        while (i < au.b()) {
            final aQ a = au.a(i);
            if (!x2) {
                p p3 = a.d().k();
                while (true) {
                    while (p3 != null) {
                        final bK h = av.a((q)p3.c()).h();
                        if (!x2) {
                            if (h != null) {
                                list.add(h);
                            }
                            p3 = p3.a();
                            if (x2) {
                                break;
                            }
                            continue Label_0124_Outer;
                        }
                        else {
                            if (x2) {
                                break Label_0124_Outer;
                            }
                            continue Label_0124_Outer;
                        }
                    }
                    ++i;
                    continue;
                }
            }
            return;
        }
        if (list.size() > 0) {
            final bK[] array = new bK[list.size()];
            this.a = true;
            e.a(list, null);
            int n = 0;
            bK bk = list.get(0);
            (array[n] = bk).a(n);
            int j = 1;
            while (true) {
                while (j < list.size()) {
                    final bK bk2 = list.get(j);
                    if (x2) {
                        System.arraycopy(array, 0, this.b, 0, this.b.length);
                        return;
                    }
                    if (bk2.compareTo(bk) > 0) {
                        ++n;
                        array[n] = bk2;
                    }
                    bk2.a(n);
                    bk = bk2;
                    ++j;
                    if (x2) {
                        break;
                    }
                }
                this.b = new bK[n + 1];
                continue;
            }
        }
    }
    
    bK a(final int n) {
        if (this.b == null || n < 0 || n >= this.b.length) {
            return null;
        }
        return this.b[n];
    }
}
