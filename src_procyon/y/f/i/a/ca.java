package y.f.i.a;

import y.c.*;
import java.util.*;

class ca extends ab
{
    private int b;
    private int c;
    private int[] d;
    private int[] e;
    private int f;
    private double[] g;
    private boolean h;
    private boolean i;
    
    ca() {
        this.h = true;
    }
    
    protected void b(final aa aa) {
        super.b(aa);
        this.b = aa.d().f().i();
        this.i = (this.b > 0);
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        final int a = ab.a;
        if (!this.i || f.d() == null) {
            this.b("min edge dist penalty", 0.0, false);
            return new double[array.length];
        }
        D d = null;
        List list = null;
        final HashMap<Object, D> hashMap = new HashMap<Object, D>();
        if (this.h) {
            this.a(f, hashMap);
            d = hashMap.get(f.a());
            list = hashMap.get(r);
        }
        final boolean[] array4 = new boolean[array.length];
        final P c = f.c();
        final R a2 = f.a();
        final P a3 = this.a(a2, array[0].a());
        Label_0395: {
            switch (array2[0].c()) {
                case 0:
                case 1: {
                    final aU a4 = this.a().a(this.b().c());
                    int n = 0;
                    Label_0284: {
                        if (!f.i() && a4.b(true).size() > 0) {
                            int i = 0;
                            while (i < array.length) {
                                final byte b = (byte)(n = array2[i].c());
                                if (a != 0) {
                                    break Label_0284;
                                }
                                if (b == 0) {
                                    array4[i] = (a4.a(a4.a(f.a(), r, array[i], true)).size() > 0);
                                }
                                ++i;
                                if (a != 0) {
                                    break;
                                }
                            }
                        }
                        n = a4.b(false).size();
                    }
                    if (n > 0) {
                        int j = 0;
                        while (j < array.length) {
                            final List a5 = a4.a(a4.a(f.a(), r, array[j], false));
                            if (a != 0) {
                                return super.a(f, r, array, array2, array3);
                            }
                            final boolean[] array5 = array4;
                            final int n2 = j;
                            array5[n2] |= (a5.size() > 0);
                            ++j;
                            if (a != 0) {
                                break;
                            }
                        }
                    }
                    this.c = this.a(a2, new P[] { a3 }, d, new boolean[1])[0];
                    if (a != 0) {
                        break Label_0395;
                    }
                    break;
                }
                case 2: {
                    if (a != 0) {
                        break Label_0395;
                    }
                    break;
                }
                case 3: {
                    this.c = this.a(a2, new P[] { a3 }, d, new boolean[1])[0];
                    if (d == null) {
                        d = new D();
                    }
                    d.add(c);
                    break;
                }
            }
        }
        this.d = this.a(a2, array, d, array4);
        this.e = this.a(r, array, list, array4);
        this.a(f, array, array2, hashMap, array4);
        this.f = 0;
        return super.a(f, r, array, array2, array3);
    }
    
    private void a(final f f, final HashMap hashMap) {
        final int a = ab.a;
        f f2 = f.b();
        v v = f.j();
        while (f2 != null) {
            final R a2 = f2.a();
            if (v != null) {
                List<?> list = hashMap.get(a2);
                if (list == null) {
                    list = (List<?>)new D();
                    hashMap.put(a2, list);
                }
                list.add(v.j());
                final byte c = v.c();
                if (c == 1 || c == 2 || c == 3) {
                    list.add(v.i());
                    if (c != 2) {
                        list.add(this.a(a2, v.i().a()));
                    }
                }
            }
            v = f2.j();
            f2 = f2.b();
            if (a != 0) {
                break;
            }
        }
    }
    
    private void a(final f f, final P[] array, final v[] array2, final HashMap hashMap, final boolean[] array3) {
        final int a = ab.a;
        if (f.d() == array2[0].l()) {
            this.g = new double[array.length];
            final D d = new D();
            final int[] array4 = new int[array.length];
            int i = 0;
            while (true) {
                while (i < array.length) {
                    final P p5 = array[i];
                    final int n;
                    final byte b = (byte)(n = array2[i].c());
                    if (a == 0) {
                        if (b == 0 && array2[i].i().d() > p5.d()) {
                            array4[d.size()] = i;
                            d.add(p5);
                        }
                        ++i;
                        if (a != 0) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if (n > 0) {
                            final P[] array5 = (P[])d.toArray(new P[d.size() + 1]);
                            final int n2 = array5.length - 1;
                            array5[n2] = f.c();
                            final int[] array6 = new int[array5.length];
                            v v = f.j();
                            f f2 = f.b();
                            while (true) {
                            Label_0311:
                                while (f2 != null) {
                                    final R a2 = f2.a();
                                    final int[] a3 = this.a(a2, array5, hashMap.get(a2), new boolean[array5.length]);
                                    final int n3 = a3[n2];
                                    final int n4 = 0;
                                    if (a != 0) {
                                        int j = n4;
                                        while (j < array6.length - 1) {
                                            final int n5 = array4[j];
                                            if (!array3[n5]) {
                                                this.g[n5] = array6[j];
                                            }
                                            ++j;
                                            if (a != 0) {
                                                break;
                                            }
                                        }
                                        return;
                                    }
                                    int k = n4;
                                    while (k < array6.length) {
                                        array6[k] = array6[k] - n3 + a3[k];
                                        ++k;
                                        if (a != 0) {
                                            break Label_0311;
                                        }
                                        if (a != 0) {
                                            break;
                                        }
                                    }
                                    if (v == null) {
                                        break;
                                    }
                                    if (v.c() != 0) {
                                        break;
                                    }
                                    v = f2.j();
                                    f2 = f2.b();
                                    if (a != 0) {
                                        break;
                                    }
                                }
                                continue;
                            }
                        }
                        return;
                    }
                }
                int n = d.size();
                continue;
            }
        }
    }
    
    protected double a(final f f, final R r, final P p5, final v v, final double n) {
        final int a = ab.a;
        final int n2 = this.f++;
        double n3 = this.e[n2];
        if (n3 > n) {
            this.a("min edge dist penalty", n3, false);
            return n3;
        }
        Label_0130: {
            switch (v.c()) {
                case 1:
                case 3: {
                    n3 = n3 + this.d[n2] + this.c;
                    if (a != 0) {
                        break Label_0130;
                    }
                    break;
                }
                case 2: {
                    n3 += this.d[n2];
                    if (a != 0) {
                        break Label_0130;
                    }
                    break;
                }
                case 0: {
                    n3 += this.g[n2];
                    break;
                }
            }
        }
        this.a("min edge dist penalty", n3, false);
        return n3;
    }
    
    protected int[] a(final R r, final P[] array, final List list, final boolean[] array2) {
        final int a = ab.a;
        final bc b = r.b();
        final boolean[] array3 = (list == null || list.isEmpty()) ? b.a(array, array2) : b.a(array, list);
        final int[] array4 = new int[array.length];
        int i = 0;
        int[] array5 = null;
        while (i < array.length) {
            array5 = array4;
            if (a != 0) {
                return array5;
            }
            array5[i] = (array3[i] ? 0 : this.b);
            ++i;
            if (a != 0) {
                break;
            }
        }
        return array5;
    }
    
    private P a(final R r, final boolean b) {
        return r.a(b ? S.a : S.d);
    }
}
