/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import y.h.eH;
import y.h.eI;
import y.h.fj;

public class C {
    private double[] b;
    private int c;
    private double d;
    private double e;
    private short f;
    private short g;
    private short h;
    private Rectangle2D.Double i;
    private final eH j;
    private final double[] k;
    double[] a;

    public void a() {
        this.c = 0;
    }

    public short b() {
        return this.h;
    }

    public short c() {
        return this.g;
    }

    public short d() {
        return this.f;
    }

    public void a(double d2, double d3, double d4, double d5) {
        double d6 = 2.0 * this.d;
        double d7 = d2 - d6;
        double d8 = d3 - d6;
        double d9 = d4 + d6;
        double d10 = d5 + d6;
        this.i.setFrame(d7, d8, d9 - d7, d10 - d8);
    }

    public PathIterator a(PathIterator pathIterator) {
        boolean bl2 = fj.z;
        eH eH2 = this.j;
        double[] arrd = this.k;
        eH2.c();
        eH2.a(pathIterator);
        double d2 = 0.0;
        double d3 = 0.0;
        eI eI2 = eH2.a();
        do {
            if (eI2 == null) return eH2.getPathIterator(null);
            switch (eI2.a()) {
                case 4: {
                    if (!bl2) break;
                }
                case 3: {
                    eI2.a(arrd);
                    d2 = arrd[4];
                    d3 = arrd[5];
                    if (!bl2) break;
                }
                case 1: {
                    eI2.a(arrd);
                    this.a(eH2, eI2, d2, d3, arrd[0], arrd[1]);
                    d2 = arrd[0];
                    d3 = arrd[1];
                    if (!bl2) break;
                }
                case 0: {
                    eI2.a(arrd);
                    d2 = arrd[0];
                    d3 = arrd[1];
                    if (!bl2) break;
                }
                case 2: {
                    eI2.a(arrd);
                    d2 = arrd[2];
                    d3 = arrd[3];
                }
            }
            eI2 = eI2.b();
        } while (!bl2);
        return eH2.getPathIterator(null);
    }

    public void b(PathIterator pathIterator) {
        boolean bl2 = fj.z;
        double[] arrd = this.k;
        double d2 = 0.0;
        double d3 = 0.0;
        do {
            if (pathIterator.isDone()) return;
            int n2 = pathIterator.currentSegment(arrd);
            switch (n2) {
                case 4: {
                    if (!bl2) break;
                }
                case 3: {
                    d2 = arrd[4];
                    d3 = arrd[5];
                    if (!bl2) break;
                }
                case 1: {
                    this.b(d2, d3, arrd[0], arrd[1]);
                    d2 = arrd[0];
                    d3 = arrd[1];
                    if (!bl2) break;
                }
                case 0: {
                    d2 = arrd[0];
                    d3 = arrd[1];
                    if (!bl2) break;
                }
                case 2: {
                    d2 = arrd[2];
                    d3 = arrd[3];
                }
            }
            pathIterator.next();
        } while (!bl2);
    }

    public void b(double d2, double d3, double d4, double d5) {
        if (!this.i.intersectsLine(d2, d3, d4, d5)) {
            return;
        }
        this.c(d2, d3, d4, d5);
    }

    private void a(eH eH2, eI eI2, double d2, double d3, double d4, double d5) {
        boolean bl2 = fj.z;
        if (!this.i.intersectsLine(d2, d3, d4, d5)) {
            return;
        }
        if (this.c > 0) {
            double d6;
            double d7 = d4 - d2;
            double d8 = d5 - d3;
            if (this.h != 0) {
                switch (this.h) {
                    case 1: {
                        if (Math.abs(d7) >= Math.abs(d8)) break;
                        return;
                    }
                    case 2: {
                        if (Math.abs(d7) <= Math.abs(d8)) break;
                        return;
                    }
                }
            }
            if ((d6 = Math.sqrt(d7 * d7 + d8 * d8)) > 0.0) {
                int n2;
                double d9;
                double d10;
                int n3;
                block12 : {
                    d10 = d7 / d6;
                    d9 = d8 / d6;
                    n2 = 0;
                    for (int i2 = 0; i2 < this.c; i2 += 4) {
                        n3 = (int)Line2D.linesIntersect(d2, d3, d4, d5, this.b[i2], this.b[i2 + 1], this.b[i2 + 2], this.b[i2 + 3]) ? 1 : 0;
                        if (!bl2) {
                            double d11;
                            double d12;
                            double d13;
                            double d14;
                            double d15;
                            double d16;
                            double d17;
                            double d18;
                            if (n3 == 0 || (d13 = ((d16 = this.b[i2 + 2] - (d12 = this.b[i2])) * (d3 - (d15 = this.b[i2 + 1])) - (d11 = this.b[i2 + 3] - d15) * (d2 - d12)) / (d18 = d11 * d7 - d16 * d8)) <= 0.0 || d13 >= 1.0 || (d17 = (d7 * (d3 - d15) - d8 * (d2 - d12)) / d18) <= 0.0 || d17 >= 1.0 || (d14 = d13 * d6) <= 0.1 || d14 >= d6 - 0.1) continue;
                            if (n2 == this.a.length) {
                                double[] arrd = new double[this.a.length * 2];
                                System.arraycopy(this.a, 0, arrd, 0, this.a.length);
                                this.a = arrd;
                            }
                            this.a[n2++] = d14;
                            if (!bl2) continue;
                        }
                        break block12;
                    }
                    n3 = n2;
                }
                if (n3 > 0) {
                    Arrays.sort(this.a, 0, n2);
                    this.a(eH2, eI2, d2, d3, d4, d5, d7, d8, d10, d9, d6, this.a, n2);
                }
            }
        }
        if (this.h != 0) return;
        this.c(d2, d3, d4, d5);
    }

    private void c(double d2, double d3, double d4, double d5) {
        if (this.h != 0) {
            switch (this.h) {
                case 1: {
                    if (Math.abs(d4 - d2) <= Math.abs(d5 - d3)) break;
                    return;
                }
                case 2: {
                    if (Math.abs(d4 - d2) >= Math.abs(d5 - d3)) break;
                    return;
                }
            }
        }
        if (this.c == this.b.length) {
            double[] arrd = new double[this.b.length * 2];
            System.arraycopy(this.b, 0, arrd, 0, this.b.length);
            this.b = arrd;
        }
        this.b[this.c++] = d2;
        this.b[this.c++] = d3;
        this.b[this.c++] = d4;
        this.b[this.c++] = d5;
    }

    private void a(eH eH2, eI eI2, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double[] arrd, int n2) {
        double d11;
        double d12;
        double d13;
        block3 : {
            boolean bl2 = fj.z;
            double d14 = this.d * 0.5;
            d12 = Math.max(0.0, arrd[0] - d14);
            d11 = Math.min(d10, arrd[0] + d14);
            for (int i2 = 1; i2 < n2; ++i2) {
                double d15 = arrd[i2];
                double d16 = Math.max(0.0, d15 - d14);
                double d17 = Math.min(d10, d15 + d14);
                d13 = d16 DCMPL d11;
                if (!bl2) {
                    if (d13 > 0) {
                        double d18 = d2 + d12 / d10 * d6;
                        double d19 = d3 + d12 / d10 * d7;
                        eH2.b(d18, d19, eI2);
                        this.a(eH2, eI2, d12, d18, d19, d11, d2 + d11 / d10 * d6, d3 + d11 / d10 * d7, d8, d9);
                        d12 = d16;
                        d11 = d17;
                        if (!bl2) continue;
                    }
                    d11 = d17;
                    if (!bl2) continue;
                }
                break block3;
            }
            d13 = d11 DCMPL d12;
        }
        if (d13 <= 0) return;
        double d20 = d2 + d12 / d10 * d6;
        double d21 = d3 + d12 / d10 * d7;
        eH2.b(d20, d21, eI2);
        this.a(eH2, eI2, d12, d20, d21, d11, d2 + d11 / d10 * d6, d3 + d11 / d10 * d7, d8, d9);
    }

    private void a(eH eH2, eI eI2, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10;
        double d11;
        boolean bl2 = fj.z;
        short s2 = this.d();
        boolean bl3 = this.a(d8, d9);
        switch (s2) {
            case 4: {
                d11 = d6 - d3;
                d10 = d7 - d4;
                if (bl3) {
                    eH2.a(d3 + d10 * 0.5, d4 - d11 * 0.5, d3 + (d10 + d11) * 0.5, d4 + (d10 - d11) * 0.5, eI2);
                    eH2.a(d6 + d10 * 0.5, d7 - d11 * 0.5, d6, d7, eI2);
                    if (!bl2) return;
                }
                eH2.a(d3 - d10 * 0.5, d4 + d11 * 0.5, d3 + (d11 - d10) * 0.5, d4 + (d11 + d10) * 0.5, eI2);
                eH2.a(d6 - d10 * 0.5, d7 + d11 * 0.5, d6, d7, eI2);
                if (!bl2) return;
            }
            case 1: {
                d11 = bl3 ? - this.e : this.e;
                d10 = (d5 - d2) * 0.5;
                if (this.e < d10) {
                    double d12 = this.e;
                    eH2.a(d3 - d9 * d11, d4 + d8 * d11, d3 - d9 * d11 + d8 * d12, d4 + d8 * d11 + d9 * d12, eI2);
                    eH2.b(d6 - d9 * d11 - d8 * d12, d7 + d8 * d11 - d9 * d12, eI2);
                    eH2.a(d6 - d9 * d11, d7 + d8 * d11, d6, d7, eI2);
                    if (!bl2) return;
                }
                eH2.a(d3 - d9 * d11, d4 + d8 * d11, d3 - d9 * d11 + d8 * d10, d4 + d8 * d11 + d9 * d10, eI2);
                eH2.a(d6 - d9 * d11, d7 + d8 * d11, d6, d7, eI2);
                if (!bl2) return;
            }
            case 127: {
                this.a(eH2, eI2, d2, d3, d4, d5, d6, d7);
                if (!bl2) return;
            }
            default: {
                eH2.a(d6, d7, eI2);
                if (!bl2) return;
            }
            case 5: {
                d11 = d6 - d3;
                d10 = d7 - d4;
                if (bl3) {
                    eH2.b(d3 + d10 * 0.5, d4 - d11 * 0.5, eI2);
                    eH2.b(d6 + d10 * 0.5, d7 - d11 * 0.5, eI2);
                    eH2.b(d6, d7, eI2);
                    if (!bl2) return;
                }
                eH2.b(d3 - d10 * 0.5, d4 + d11 * 0.5, eI2);
                eH2.b(d6 - d10 * 0.5, d7 + d11 * 0.5, eI2);
                eH2.b(d6, d7, eI2);
                if (!bl2) return;
            }
            case 2: {
                d11 = bl3 ? - this.e : this.e;
                eH2.b(d3 - d9 * d11, d4 + d8 * d11, eI2);
                eH2.b(d6 - d9 * d11, d7 + d8 * d11, eI2);
                eH2.b(d6, d7, eI2);
                if (!bl2) return;
            }
            case 3: {
                d11 = bl3 ? - this.e : this.e;
                d10 = this.e;
                eH2.b(d3 - d9 * d11 + d8 * d10, d4 + d8 * d11 + d9 * d10, eI2);
                eH2.b(d6 - d9 * d11 - d8 * d10, d7 + d8 * d11 - d9 * d10, eI2);
                eH2.b(d6, d7, eI2);
                if (!bl2) return;
            }
            case 6: 
        }
        d11 = d6 - d3;
        d10 = d7 - d4;
        if (bl3) {
            eH2.b(d3 + (d10 + d11) * 0.5, d4 + (d10 - d11) * 0.5, eI2);
            eH2.b(d6, d7, eI2);
            if (!bl2) return;
        }
        eH2.b(d3 + (d11 - d10) * 0.5, d4 + (d11 + d10) * 0.5, eI2);
        eH2.b(d6, d7, eI2);
    }

    protected void a(eH eH2, eI eI2, double d2, double d3, double d4, double d5, double d6, double d7) {
    }

    private boolean a(double d2, double d3) {
        switch (this.c()) {
            case 8: {
                return false;
            }
            case 7: {
                return true;
            }
            default: {
                if (Math.abs(d2) > Math.abs(d3)) {
                    if (d2 < 0.0) return false;
                    return true;
                }
                if (d3 < 0.0) return false;
                return true;
            }
            case 6: {
                if (Math.abs(d2) > Math.abs(d3)) {
                    if (d2 > 0.0) return false;
                    return true;
                }
                if (d3 > 0.0) return false;
                return true;
            }
            case 1: {
                if (d2 > 0.0) return true;
                if (d2 != 0.0) return false;
                if (d3 <= 0.0) return false;
                return true;
            }
            case 2: {
                if (d2 < 0.0) return true;
                if (d2 != 0.0) return false;
                if (d3 <= 0.0) return false;
                return true;
            }
            case 4: {
                if (d3 > 0.0) return true;
                if (d3 != 0.0) return false;
                if (d2 <= 0.0) return false;
                return true;
            }
            case 3: 
        }
        if (d3 < 0.0) return true;
        if (d3 != 0.0) return false;
        if (d2 <= 0.0) return false;
        return true;
    }
}

