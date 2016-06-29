package y.f.c;

import y.f.*;
import y.g.*;
import y.c.*;
import java.util.*;

class aI implements R
{
    private aJ a;
    private R b;
    private c c;
    private c d;
    private boolean e;
    private Object f;
    
    public void a(final R b, final c c, final c d, final Object f) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
    }
    
    public int a(final X x, final A a, final f f) {
        final boolean i = a.i;
        if (this.a == null || this.e) {
            if (this.a == null) {
                this.a = new aJ();
            }
            final int a2 = this.b.a(x, a, f);
            this.a.a = Math.max(this.a.a, a2);
            final x o = x.o();
            while (o.f()) {
                final q e = o.e();
                this.a.b.put(this.b(e), am.a(new Integer(a.a(e)), this.f));
                o.g();
                if (i) {
                    break;
                }
            }
            return a2;
        }
        final boolean[] array = new boolean[this.a.a];
        final x o2 = x.o();
    Label_0303:
        while (true) {
        Label_0355_Outer:
            while (o2.f()) {
                final q e2 = o2.e();
                final am am = this.a.b.get(this.b(e2));
                try {
                    final int intValue = (int)am.a;
                    a.a(e2, intValue);
                    final boolean[] array2 = array;
                    if (i) {
                        break Label_0303;
                    }
                    array2[intValue] = true;
                }
                catch (NullPointerException ex) {
                    throw new IllegalStateException("Memento has no information about " + e2);
                }
                o2.g();
                if (i) {
                    break;
                }
                continue Label_0355_Outer;
                boolean[] array2 = null;
                final int[] array3 = new int[array2.length];
                int n = 0;
                int j = 0;
                while (true) {
                    while (j < array3.length) {
                        final int n2 = array[j] ? 1 : 0;
                        if (i) {
                            int n3 = 0;
                            if (n2 < array3.length) {
                                final x o3 = x.o();
                                while (o3.f()) {
                                    final q e3 = o3.e();
                                    final int a3 = a.a(e3);
                                    n3 = array3[a3];
                                    if (i) {
                                        return n3;
                                    }
                                    if (n3 != a3) {
                                        a.a(e3, array3[a3]);
                                    }
                                    o3.g();
                                    if (i) {
                                        break;
                                    }
                                }
                            }
                            f.a(w.a(x, a));
                            return n3;
                        }
                        if (n2 != 0) {
                            array3[j] = n;
                            ++n;
                        }
                        ++j;
                        if (i) {
                            break;
                        }
                    }
                    continue;
                }
            }
            continue Label_0303;
        }
    }
    
    public Object a(final Object o) {
        final Object b = this.b(o);
        if (b == null) {
            throw new IllegalArgumentException("No Id stored for " + o);
        }
        final Object value = this.a.b.get(b);
        if (value == null) {
            throw new IllegalArgumentException("No memento information stored for id " + b);
        }
        return value;
    }
    
    final Object b(final Object o) {
        final Object b = this.c.b(o);
        if (b == null) {
            throw new IllegalArgumentException("No Id stored for " + o);
        }
        return b;
    }
    
    public void a(final boolean e) {
        this.e = e;
    }
    
    public void c(final Object o) {
        if (!(o instanceof Map)) {
            throw new IllegalArgumentException("Unknown memento type!");
        }
        this.a = ((Map)o).get("y.layout.hierarchic.MementoLayerer.LayerMemento");
    }
    
    public void d(final Object o) {
        if (!(o instanceof Map)) {
            throw new IllegalArgumentException("Unknown memento type!");
        }
        ((Map)o).put("y.layout.hierarchic.MementoLayerer.LayerMemento", this.a);
    }
}
