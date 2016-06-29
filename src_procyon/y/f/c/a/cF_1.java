package y.f.c.a;

import java.util.*;
import y.g.*;
import y.c.*;
import y.f.*;

final class cF
{
    private final Comparator a;
    private final Comparator b;
    private final Comparator c;
    private final Comparator d;
    private final Comparator e;
    private final Comparator f;
    private final int[] g;
    
    public static cF a(final int[] array, final int[] array2, final byte[] array3, final int[] array4, final byte[] array5, final int[] array6, final byte b, final byte b2) {
        final boolean x = N.x;
        Comparator comparator = null;
        Comparator comparator2 = null;
        Label_0114: {
            switch (b) {
                default: {
                    comparator = new cL(array3);
                    comparator2 = new cL(array5);
                    if (x) {
                        break Label_0114;
                    }
                    break;
                }
                case 2: {
                    comparator = new cN(array3);
                    comparator2 = new cN(array5);
                    if (x) {
                        break Label_0114;
                    }
                    break;
                }
                case 0: {
                    comparator = new cX(array3);
                    comparator2 = new cX(array5);
                    if (x) {
                        break Label_0114;
                    }
                    break;
                }
                case 3: {
                    comparator = new cM(array3);
                    comparator2 = new cM(array5);
                    break;
                }
            }
        }
        Comparator comparator3;
        Comparator comparator4;
        while (true) {
            switch (b2) {
                case 1: {
                    comparator3 = new cJ(array4);
                    comparator4 = new cJ(array6);
                    if (x) {
                        break;
                    }
                    return new cF(array, new cO(array), new cP(array2), comparator, comparator3, comparator2, comparator4);
                }
                case 3: {
                    comparator3 = new cW(array4);
                    comparator4 = new cW(array6);
                    return new cF(array, new cO(array), new cP(array2), comparator, comparator3, comparator2, comparator4);
                }
            }
            comparator3 = new cZ(array4);
            comparator4 = new cZ(array6);
            if (x) {
                continue;
            }
            break;
        }
        return new cF(array, new cO(array), new cP(array2), comparator, comparator3, comparator2, comparator4);
    }
    
    public static cF a(final X x, final aU au, final aV av, final int[] array, final int[] array2, byte[] array3, int[] array4, byte[] array5, int[] array6, final byte b, final byte b2) {
        final boolean x2 = N.x;
        final d[] array7 = new d[x.g()];
        final ArrayList<Object> list = new ArrayList<Object>(31);
        final ArrayList<Object> list2 = new ArrayList<Object>(31);
        final ArrayList<Object> list3 = new ArrayList<Object>(31);
        final cV cv = new cV(x, true, true);
        final cV cv2 = new cV(x, true, false);
        final cV cv3 = new cV(x, false, true);
        final cV cv4 = new cV(x, false, false);
        if (array3 == null) {
            array3 = new byte[x.h()];
        }
        Arrays.fill(array3, (byte)(-2));
        if (array6 == null) {
            array4 = new int[x.h()];
        }
        if (array5 == null) {
            array5 = new byte[x.h()];
        }
        Arrays.fill(array5, (byte)(-2));
        if (array6 == null) {
            array6 = new int[x.h()];
        }
        int n = 0;
    Label_1373:
        do {
            double n2 = n;
        Label_0166:
            while (n2 < au.b()) {
                final aQ a = au.a(n);
                int n3 = 0;
                p p11 = a.d().k();
                while (p11 != null) {
                    Object c = p11.c();
                    int n4 = 0;
                    double n13 = 0.0;
                    Label_1139: {
                        while (true) {
                            final q q = (q)c;
                            final int d = q.d();
                            array[d] = n;
                            array2[d] = n3;
                            list.clear();
                            list2.clear();
                            list3.clear();
                            n4 = q.a() + 1;
                            if (!x2) {
                                d d2 = q.f();
                                while (d2 != null) {
                                    final int b3 = d2.b();
                                    final aE c2 = av.a(d2).c();
                                    final q q2 = (q)(c = c2);
                                    if (x2) {
                                        continue Label_1139;
                                    }
                                    Label_0458: {
                                        if (q2 == null || c2.g()) {
                                            array3[b3] = -2;
                                            if (!x2) {
                                                break Label_0458;
                                            }
                                        }
                                        if (c2 != null) {
                                            if (!c2.a()) {
                                                if (c2.e()) {
                                                    array3[b3] = 1;
                                                    if (!x2) {
                                                        break Label_0458;
                                                    }
                                                }
                                                if (c2.f()) {
                                                    array3[b3] = -1;
                                                    if (!x2) {
                                                        break Label_0458;
                                                    }
                                                }
                                                array3[b3] = 0;
                                                if (!x2) {
                                                    break Label_0458;
                                                }
                                            }
                                            if (c2.e()) {
                                                array3[b3] = 1;
                                                list.add(d2);
                                                if (!x2) {
                                                    break Label_0458;
                                                }
                                            }
                                            if (c2.f()) {
                                                array3[b3] = -1;
                                                list2.add(d2);
                                                if (!x2) {
                                                    break Label_0458;
                                                }
                                            }
                                            array3[b3] = 0;
                                            list3.add(d2);
                                        }
                                    }
                                    d2 = d2.g();
                                    if (x2) {
                                        break;
                                    }
                                }
                                double n7 = 0.0;
                                Label_0585: {
                                    if (list.size() > 0) {
                                        list.toArray(array7);
                                        e.a(array7, 0, list.size(), cv2);
                                        int n5 = 0;
                                        double n6 = -1.7976931348623157E308;
                                        int i = 0;
                                        while (i < list.size()) {
                                            final d d3 = array7[i];
                                            final double b4 = x.n(d3).b;
                                            n7 = dcmpl(b4, n6);
                                            if (x2) {
                                                break Label_0585;
                                            }
                                            if (n7 != 0) {
                                                n6 = b4;
                                                n5 += n4;
                                            }
                                            array4[d3.b()] = n5;
                                            ++i;
                                            if (x2) {
                                                break;
                                            }
                                        }
                                    }
                                    list2.size();
                                }
                                double n10 = 0.0;
                                Label_0696: {
                                    if (n7 > 0) {
                                        list2.toArray(array7);
                                        e.a(array7, 0, list2.size(), cv2);
                                        int n8 = 0;
                                        double n9 = -1.7976931348623157E308;
                                        int j = list2.size() - 1;
                                        while (j >= 0) {
                                            final d d4 = array7[j];
                                            final double b5 = x.n(d4).b;
                                            n10 = dcmpl(b5, n9);
                                            if (x2) {
                                                break Label_0696;
                                            }
                                            if (n10 != 0) {
                                                n9 = b5;
                                                n8 += n4;
                                            }
                                            array4[d4.b()] = n8;
                                            --j;
                                            if (x2) {
                                                break;
                                            }
                                        }
                                    }
                                    list3.size();
                                }
                                if (n10 > 0) {
                                    list3.toArray(array7);
                                    e.a(array7, 0, list3.size(), cv);
                                    int n11 = 0;
                                    double n12 = -1.7976931348623157E308;
                                    int k = list3.size() - 1;
                                    while (k >= 0) {
                                        final d d5 = array7[k];
                                        final double a2 = x.n(d5).a;
                                        n13 = dcmpl(a2, n12);
                                        if (x2) {
                                            break Label_1139;
                                        }
                                        if (n13 != 0) {
                                            n12 = a2;
                                            n11 += n4;
                                        }
                                        array4[d5.b()] = n11;
                                        --k;
                                        if (x2) {
                                            break;
                                        }
                                    }
                                }
                                list.clear();
                                list2.clear();
                                list3.clear();
                                d d6 = q.g();
                                while (d6 != null) {
                                    final int b6 = d6.b();
                                    final aE e = av.a(d6).e();
                                    final q q3 = (q)(c = e);
                                    if (x2) {
                                        continue Label_1139;
                                    }
                                    Label_1011: {
                                        if (q3 == null || e.g()) {
                                            array5[b6] = -2;
                                            if (!x2) {
                                                break Label_1011;
                                            }
                                        }
                                        if (e != null) {
                                            if (!e.a()) {
                                                if (e.e()) {
                                                    array5[b6] = 1;
                                                    if (!x2) {
                                                        break Label_1011;
                                                    }
                                                }
                                                if (e.f()) {
                                                    array5[b6] = -1;
                                                    if (!x2) {
                                                        break Label_1011;
                                                    }
                                                }
                                                array5[b6] = 0;
                                                if (!x2) {
                                                    break Label_1011;
                                                }
                                            }
                                            if (e.e()) {
                                                array5[b6] = 1;
                                                list.add(d6);
                                                if (!x2) {
                                                    break Label_1011;
                                                }
                                            }
                                            if (e.f()) {
                                                array5[b6] = -1;
                                                list2.add(d6);
                                                if (!x2) {
                                                    break Label_1011;
                                                }
                                            }
                                            array5[b6] = 0;
                                            list3.add(d6);
                                        }
                                    }
                                    d6 = d6.h();
                                    if (x2) {
                                        break;
                                    }
                                }
                                break;
                            }
                            continue Label_1373;
                        }
                        if (list.size() > 0) {
                            list.toArray(array7);
                            e.a(array7, 0, list.size(), cv4);
                            int n14 = 0;
                            double n15 = -1.7976931348623157E308;
                            int l = list.size() - 1;
                            while (l >= 0) {
                                final d d7 = array7[l];
                                final double b7 = x.o(d7).b;
                                final double n16 = dcmpl(b7, n15);
                                if (x2) {
                                    break Label_1139;
                                }
                                if (n16 != 0) {
                                    n15 = b7;
                                    n14 += n4;
                                }
                                array6[d7.b()] = n14;
                                --l;
                                if (x2) {
                                    break;
                                }
                            }
                        }
                        list2.size();
                    }
                    double n20 = 0.0;
                    Label_1249: {
                        if (n13 > 0) {
                            list2.toArray(array7);
                            e.a(array7, 0, list2.size(), cv4);
                            int n17 = 0;
                            double n18 = -1.7976931348623157E308;
                            int n19 = 0;
                            while (n19 < list2.size()) {
                                final d d8 = array7[n19];
                                final double b8 = x.o(d8).b;
                                n20 = dcmpl(b8, n18);
                                if (x2) {
                                    break Label_1249;
                                }
                                if (n20 != 0) {
                                    n18 = b8;
                                    n17 += n4;
                                }
                                array6[d8.b()] = n17;
                                ++n19;
                                if (x2) {
                                    break;
                                }
                            }
                        }
                        list3.size();
                    }
                    if (n20 > 0) {
                        list3.toArray(array7);
                        e.a(array7, 0, list3.size(), cv3);
                        int n21 = 0;
                        double n22 = -1.7976931348623157E308;
                        int n23 = list3.size() - 1;
                        while (n23 >= 0) {
                            final d d9 = array7[n23];
                            final double a3 = x.o(d9).a;
                            final double n24 = n2 = dcmpl(a3, n22);
                            if (x2) {
                                continue Label_0166;
                            }
                            if (n24 != 0) {
                                n22 = a3;
                                n21 += n4;
                            }
                            array6[d9.b()] = n21;
                            --n23;
                            if (x2) {
                                break;
                            }
                        }
                    }
                    p11 = p11.a();
                    ++n3;
                    if (x2) {
                        break;
                    }
                }
                ++n;
                continue Label_1373;
            }
            break;
        } while (!x2);
        return a(array, array2, array3, array4, array5, array6, b, b2);
    }
    
    private cF(final int[] g, final Comparator a, final Comparator b, final Comparator c, final Comparator e, final Comparator d, final Comparator f) {
        this.a = a;
        this.g = g;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public Comparator a(final boolean b) {
        if (b) {
            return new cK(this.g, this.b, this.c, this.e);
        }
        return new cQ(this.g, this.b, this.d, this.f);
    }
    
    public Comparator b(final boolean b) {
        if (b) {
            return new cI(this.g, this.a, this.b, this.c, this.e, this.d, this.f);
        }
        return new cU(this.g, this.a, this.b, this.d, this.f, this.c, this.e);
    }
    
    public Comparator c(final boolean b) {
        if (b) {
            return new cH(this.g, this.a, this.b, this.c, this.e, this.d, this.f);
        }
        return new cS(this.g, this.a, this.b, this.d, this.f, this.c, this.e);
    }
}
