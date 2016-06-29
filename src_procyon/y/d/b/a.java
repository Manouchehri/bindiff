package y.d.b;

import java.util.*;

public class a
{
    protected u a;
    private Object[] c;
    private Object[] d;
    private Object e;
    private Object f;
    private Object g;
    private Object h;
    int b;
    
    public a(final Object[] array, final boolean b, final u a) {
        final int a2 = y.d.b.c.a;
        this.a = a;
        boolean b2 = false;
        final int a3 = this.a(array);
        Label_0053: {
            if (b) {
                this.b = a3;
                if (a2 == 0) {
                    break Label_0053;
                }
            }
            this.b = 0;
            if (a3 == 1) {
                b2 = true;
            }
        }
        final int length = array.length;
        this.c = new Object[length];
        this.d = new Object[length];
        final Comparator d = this.a.d();
        final Comparator e = this.a.e();
        this.e = array[0];
        this.f = array[0];
        this.g = array[0];
        this.h = array[0];
        int i = 0;
        while (i < length) {
            final Object o = array[i];
            Label_0233: {
                if (b2) {
                    this.c[length - i - 1] = o;
                    this.d[length - i - 1] = this.a.c(o, array[(i - 1) % length]);
                    if (a2 == 0) {
                        break Label_0233;
                    }
                }
                this.c[i] = o;
                this.d[i] = this.a.c(o, array[(i + 1) % length]);
            }
            if (d.compare(o, this.e) < 0) {
                this.e = o;
            }
            if (d.compare(o, this.f) > 0) {
                this.f = o;
            }
            if (e.compare(o, this.g) < 0) {
                this.g = o;
            }
            if (e.compare(o, this.h) > 0) {
                this.h = o;
            }
            ++i;
            if (a2 != 0) {
                break;
            }
        }
    }
    
    public int a(final Object o) {
        final int a = y.d.b.c.a;
        final Comparator c = this.a.c();
        final int compare = c.compare(o, this.e);
        final int compare2 = c.compare(o, this.f);
        final int compare3 = c.compare(o, this.g);
        final int compare4 = c.compare(o, this.h);
        if (compare < 0 || compare2 > 0 || compare3 < 0 || compare4 > 0) {
            return 2;
        }
        int i = 0;
        while (true) {
            while (i < this.d.length) {
                final u a2 = this.a;
                if (a != 0) {
                    final Comparator d = a2.d();
                    int n = 0;
                    int j = 0;
                    int compare5 = 0;
                    while (j < this.d.length) {
                        final Object o2 = this.d[j];
                        Object c2 = this.a.c(o2);
                        Object d2 = this.a.d(o2);
                        final int n2 = compare5 = d.compare(c2, d2);
                        if (a != 0) {
                            return (compare5 == 0) ? 2 : 1;
                        }
                        if (compare5 != 0) {
                            if (n2 > 0) {
                                final Object o3 = c2;
                                c2 = d2;
                                d2 = o3;
                            }
                            if (d.compare(c2, o) <= 0 && d.compare(o, d2) < 0 && this.a.c(c2, d2, o) < 0) {
                                ++n;
                            }
                        }
                        ++j;
                        if (a != 0) {
                            break;
                        }
                    }
                    return (compare5 == 0) ? 2 : 1;
                }
                if (a2.e(this.d[i], o)) {
                    return 0;
                }
                ++i;
                if (a != 0) {
                    break;
                }
            }
            final u a3 = this.a;
            continue;
        }
    }
    
    public int b(final Object o) {
        final int a = this.a(o);
        switch (a) {
            case 1: {
                return (this.b == 0) ? 1 : -1;
            }
            case 2: {
                return (this.b == 0) ? -1 : 1;
            }
            case 0: {
                return 0;
            }
            default: {
                throw new RuntimeException("Illegal return value of regionOf: " + a);
            }
        }
    }
    
    public int a() {
        return this.b;
    }
    
    protected int a(final Object[] array) {
        final int a = y.d.b.c.a;
        final int length = array.length;
        Object o = array[0];
        int n = 0;
        final Comparator c = this.a.c();
        int i = 1;
        while (true) {
            while (i < length) {
                final Object o2 = array[i];
                final int compare = c.compare(o2, o);
                if (a != 0) {
                    final Object o3 = array[(compare > 0) ? (n - 1) : (array.length - 1)];
                    int n2 = 0;
                Block_6:
                    while (true) {
                        final Object o4 = array[n++ % length];
                        final int c2 = this.a.c(o3, o, o4);
                        while (c2 != 0 || o4 == o3) {
                            n2 = c2;
                            if (a == 0) {
                                break Block_6;
                            }
                        }
                    }
                    return (n2 < 0) ? 1 : 0;
                }
                if (compare < 0) {
                    o = o2;
                    n = i;
                }
                ++i;
                if (a != 0) {
                    break;
                }
            }
            continue;
        }
    }
}
