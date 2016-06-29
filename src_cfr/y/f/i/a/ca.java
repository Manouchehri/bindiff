/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.HashMap;
import java.util.List;
import y.c.D;
import y.c.d;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.S;
import y.f.i.a.Z;
import y.f.i.a.aU;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ad;
import y.f.i.a.bc;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.x;
import y.f.y;

class ca
extends ab {
    private int b;
    private int c;
    private int[] d;
    private int[] e;
    private int f;
    private double[] g;
    private boolean h = true;
    private boolean i;

    ca() {
    }

    @Override
    protected void b(aa aa2) {
        super.b(aa2);
        this.b = aa2.d().f().i();
        this.i = this.b > 0;
    }

    @Override
    double[] a(f f2, R r2, P[] arrp, v[] arrv, double[] arrd) {
        int n2 = ab.a;
        if (!this.i || f2.d() == null) {
            this.b("min edge dist penalty", 0.0, false);
            return new double[arrp.length];
        }
        D d2 = null;
        D d3 = null;
        HashMap hashMap = new HashMap();
        if (this.h) {
            this.a(f2, hashMap);
            d2 = (D)hashMap.get(f2.a());
            d3 = (D)hashMap.get(r2);
        }
        boolean[] arrbl = new boolean[arrp.length];
        P p2 = f2.c();
        R r3 = f2.a();
        P p3 = this.a(r3, arrp[0].a());
        byte by2 = arrv[0].c();
        switch (by2) {
            Object object;
            case 0: 
            case 1: {
                int n3;
                int n4;
                aU aU2 = this.a().a(this.b().c());
                if (!f2.i() && aU2.b(true).size() > 0) {
                    for (n3 = 0; n3 < arrp.length; ++n3) {
                        n4 = arrv[n3].c();
                        if (n2 == 0) {
                            if (n4 != 0) continue;
                            object = aU2.a(aU2.a(f2.a(), r2, arrp[n3], true));
                            arrbl[n3] = object.size() > 0;
                            if (n2 == 0) continue;
                        }
                        break;
                    }
                } else {
                    n4 = aU2.b(false).size();
                }
                if (n4 > 0) {
                    for (n3 = 0; n3 < arrp.length; ++n3) {
                        object = aU2.a(aU2.a(f2.a(), r2, arrp[n3], false));
                        if (n2 != 0) return super.a(f2, r2, arrp, arrv, arrd);
                        boolean[] arrbl2 = arrbl;
                        int n5 = n3;
                        arrbl2[n5] = arrbl2[n5] | object.size() > 0;
                        if (n2 == 0) continue;
                    }
                }
                P[] arrp2 = new P[]{p3};
                this.c = this.a(r3, arrp2, d2, new boolean[1])[0];
                if (n2 == 0) break;
            }
            case 2: {
                if (n2 == 0) break;
            }
            case 3: {
                object = new P[]{p3};
                this.c = this.a(r3, (P[])object, d2, new boolean[1])[0];
                if (d2 == null) {
                    d2 = new D();
                }
                d2.add(p2);
            }
        }
        this.d = this.a(r3, arrp, d2, arrbl);
        this.e = this.a(r2, arrp, d3, arrbl);
        this.a(f2, arrp, arrv, hashMap, arrbl);
        this.f = 0;
        return super.a(f2, r2, arrp, arrv, arrd);
    }

    private void a(f f2, HashMap hashMap) {
        int n2 = ab.a;
        f f3 = f2.b();
        v v2 = f2.j();
        do {
            if (f3 == null) return;
            R r2 = f3.a();
            if (v2 != null) {
                List list = (List)hashMap.get(r2);
                if (list == null) {
                    list = new D();
                    hashMap.put(r2, list);
                }
                list.add(v2.j());
                byte by2 = v2.c();
                if (by2 == 1 || by2 == 2 || by2 == 3) {
                    list.add(v2.i());
                    if (by2 != 2) {
                        P p2 = this.a(r2, v2.i().a());
                        list.add(p2);
                    }
                }
            }
            v2 = f3.j();
            f3 = f3.b();
        } while (n2 == 0);
    }

    private void a(f f2, P[] arrp, v[] arrv, HashMap hashMap, boolean[] arrbl) {
        int[] arrn;
        int[] arrn2;
        int n2;
        int n3;
        block8 : {
            D d2;
            int n4;
            block7 : {
                n2 = ab.a;
                if (f2.d() != arrv[0].l()) return;
                this.g = new double[arrp.length];
                d2 = new D();
                arrn2 = new int[arrp.length];
                for (int i2 = 0; i2 < arrp.length; ++i2) {
                    P p2 = arrp[i2];
                    n4 = arrv[i2].c();
                    if (n2 == 0) {
                        if (n4 != 0 || arrv[i2].i().d() <= p2.d()) continue;
                        arrn2[d2.size()] = i2;
                        d2.add(p2);
                        if (n2 == 0) continue;
                    }
                    break block7;
                }
                n4 = d2.size();
            }
            if (n4 <= 0) return;
            P[] arrp2 = (P[])d2.toArray(new P[d2.size() + 1]);
            int n5 = arrp2.length - 1;
            arrp2[n5] = f2.c();
            arrn = new int[arrp2.length];
            v v2 = f2.j();
            block1 : for (f f3 = f2.b(); f3 != null; f3 = f3.b()) {
                R r2 = f3.a();
                List list = (List)hashMap.get(r2);
                int[] arrn3 = this.a(r2, arrp2, list, new boolean[arrp2.length]);
                int n6 = arrn3[n5];
                n3 = 0;
                if (n2 == 0) {
                    for (int i3 = v1977702; i3 < arrn.length; ++i3) {
                        arrn[i3] = arrn[i3] - n6 + arrn3[i3];
                        if (n2 != 0) break block1;
                        if (n2 == 0) continue;
                    }
                    if (v2 == null || v2.c() != 0) break;
                    v2 = f3.j();
                    if (n2 == 0) continue;
                }
                break block8;
            }
            n3 = 0;
        }
        int n7 = n3;
        do {
            if (n7 >= arrn.length - 1) return;
            int n8 = arrn2[n7];
            if (!arrbl[n8]) {
                this.g[n8] = arrn[n7];
            }
            ++n7;
        } while (n2 == 0);
    }

    @Override
    protected double a(f f2, R r2, P p2, v v2, double d2) {
        double d3;
        int n2;
        int n3 = ab.a;
        if ((d3 = (double)this.e[n2 = this.f++]) > d2) {
            this.a("min edge dist penalty", d3, false);
            return d3;
        }
        switch (v2.c()) {
            case 1: 
            case 3: {
                d3 += (double)this.d[n2];
                d3 += (double)this.c;
                if (n3 == 0) break;
            }
            case 2: {
                d3 += (double)this.d[n2];
                if (n3 == 0) break;
            }
            case 0: {
                d3 += this.g[n2];
            }
        }
        this.a("min edge dist penalty", d3, false);
        return d3;
    }

    protected int[] a(R r2, P[] arrp, List list, boolean[] arrbl) {
        int[] arrn;
        int n2 = ab.a;
        bc bc2 = r2.b();
        boolean[] arrbl2 = list == null || list.isEmpty() ? bc2.a(arrp, arrbl) : bc2.a(arrp, list);
        int[] arrn2 = new int[arrp.length];
        for (int i2 = 0; i2 < arrp.length; ++i2) {
            arrn = arrn2;
            if (n2 != 0) return arrn;
            arrn[i2] = arrbl2[i2] ? 0 : this.b;
            if (n2 == 0) continue;
        }
        arrn = arrn2;
        return arrn;
    }

    private P a(R r2, boolean bl2) {
        S s2 = bl2 ? S.a : S.d;
        return r2.a(s2);
    }
}

