package y.f.c;

import y.f.*;
import java.util.*;
import y.c.*;

class aB implements Q
{
    aD a;
    private Q b;
    private c c;
    private boolean d;
    private Comparator e;
    
    public aB() {
        this.e = new aC(this);
    }
    
    void a(final Q b, final c c) {
        this.b = b;
        this.c = c;
    }
    
    public void a(final Object o) {
        if (!(o instanceof Map)) {
            throw new IllegalArgumentException("Unknown memento type!");
        }
        this.a = ((Map)o).get("y.layout.hierarchic.MementoSequencer.SequencerMemento");
    }
    
    public void b(final Object o) {
        if (!(o instanceof Map)) {
            throw new IllegalArgumentException("Unknown memento type!");
        }
        ((Map)o).put("y.layout.hierarchic.MementoSequencer.SequencerMemento", this.a);
    }
    
    public y[] a(final X x, final A a, final int n) {
        final boolean i = a.i;
        if (this.a == null || this.d) {
            if (this.a == null) {
                this.a = new aD();
            }
            final y[] a2 = this.b.a(x, a, n);
            final Map a3 = this.a.a;
            int j = 0;
            y[] array = null;
        Label_0147_Outer:
            while (j < a2.length) {
                array = a2;
                if (!i) {
                    final y y = array[j];
                    int n2 = 0;
                    p p3 = y.k();
                    while (true) {
                        while (p3 != null) {
                            a3.put(this.c(p3.c()), new Integer(n2));
                            p3 = p3.a();
                            ++n2;
                            if (!i) {
                                if (i) {
                                    break;
                                }
                                continue Label_0147_Outer;
                            }
                            else {
                                if (i) {
                                    break Label_0147_Outer;
                                }
                                continue Label_0147_Outer;
                            }
                        }
                        ++j;
                        continue;
                    }
                }
                return array;
            }
            return array;
        }
        final y[] array2 = new y[n];
        int k = array2.length - 1;
        while (k >= 0) {
            array2[k] = new y();
            --k;
            if (i) {
                break;
            }
        }
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            final Object c = this.c(e);
            if (this.a.a.get(c) == null) {
                throw new IllegalStateException("No memento stored for " + c);
            }
            array2[a.a(e)].add(e);
            o.g();
            if (i) {
                break;
            }
        }
        final ArrayList list = new ArrayList<y>(array2.length);
        int l = 0;
        y[] array3 = null;
        while (l < array2.length) {
            array3 = array2;
            if (i) {
                return array3;
            }
            final y y2 = array3[l];
            if (y2.size() > 0) {
                y2.sort(this.e);
                list.add(y2);
            }
            ++l;
            if (i) {
                break;
            }
        }
        final y[] array4 = list.toArray(new y[list.size()]);
        return array3;
    }
    
    final Object c(final Object o) {
        final Object b = this.c.b(o);
        if (b == null) {
            throw new IllegalArgumentException("No Id stored for " + o);
        }
        return b;
    }
    
    public void a(final boolean d) {
        this.d = d;
    }
}
