package y.f.k;

import java.util.*;

public class l
{
    public static final l a;
    public static final l b;
    public static final l c;
    public static final l d;
    public static final l e;
    public static final l f;
    public static final l g;
    public static final l h;
    public static final List i;
    private final double[][] j;
    private l k;
    private n[] l;
    private n[] m;
    
    l(final double n, final double n2, final double n3, final double n4) {
        this.j = new double[2][2];
        this.j[0][0] = n;
        this.j[0][1] = n2;
        this.j[1][0] = n3;
        this.j[1][1] = n4;
        this.l = new n[] { n.a(new double[] { this.j[0][0], this.j[1][0] }), n.a(new double[] { this.j[0][1], this.j[1][1] }) };
        this.m = new n[] { n.a(this.j[0]), n.a(this.j[1]) };
    }
    
    n a(final int n) {
        return this.l[n];
    }
    
    public String toString() {
        final int g = y.f.k.d.g;
        final StringBuffer sb = new StringBuffer("Matrix:\n");
        int i = 0;
    Label_0102_Outer:
        while (i < this.j.length) {
            final double[] array = this.j[i];
            final StringBuffer append = sb.append(i).append(": ");
            if (g == 0) {
                int j = 0;
                while (true) {
                    while (j < array.length) {
                        sb.append(array[j]);
                        sb.append(' ');
                        ++j;
                        if (g == 0) {
                            if (g != 0) {
                                break;
                            }
                            continue Label_0102_Outer;
                        }
                        else {
                            if (g != 0) {
                                break Label_0102_Outer;
                            }
                            continue Label_0102_Outer;
                        }
                    }
                    sb.append('\n');
                    ++i;
                    continue;
                }
            }
            return append.toString();
        }
        final StringBuffer append = sb;
        return append.toString();
    }
    
    l a() {
        return this.k;
    }
    
    static l a(final l l) {
        return l.k;
    }
    
    static {
        a = new l(1.0, 0.0, 0.0, 1.0);
        b = new l(0.0, -1.0, 1.0, 0.0);
        c = new l(-1.0, 0.0, 0.0, -1.0);
        d = new l(0.0, 1.0, -1.0, 0.0);
        e = new l(1.0, 0.0, 0.0, -1.0);
        f = new l(-1.0, 0.0, 0.0, 1.0);
        g = new l(0.0, -1.0, -1.0, 0.0);
        h = new l(0.0, 1.0, 1.0, 0.0);
        final ArrayList<l> list = new ArrayList<l>(10);
        list.add(l.a);
        list.add(l.b);
        list.add(l.c);
        list.add(l.d);
        list.add(l.e);
        list.add(l.f);
        list.add(l.g);
        list.add(l.h);
        i = Collections.unmodifiableList((List<?>)list);
        l.a.k = l.a;
        l.b.k = l.d;
        l.d.k = l.b;
        l.c.k = l.c;
        l.e.k = l.e;
        l.f.k = l.f;
        l.g.k = l.g;
        l.h.k = l.h;
    }
}
