/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.g.e;
import y.g.g;

abstract class R
implements Comparable,
g {
    private byte a;
    private double b;

    protected R(byte by2, double d2) {
        this.a = by2;
        this.b = d2;
    }

    public void a(double d2) {
        this.b = d2;
    }

    public void a(byte by2) {
        this.a = by2;
    }

    public int compareTo(Object object) {
        R r2 = (R)object;
        int n2 = e.a(this.b, r2.j());
        if (n2 != 0) {
            return n2;
        }
        switch (this.k()) {
            case 0: {
                switch (r2.k()) {
                    case 0: {
                        return 0;
                    }
                    case 1: {
                        return 1;
                    }
                    case 2: {
                        return -1;
                    }
                }
                return 0;
            }
            case 1: {
                switch (r2.k()) {
                    case 0: {
                        return -1;
                    }
                    case 1: {
                        return 0;
                    }
                    case 2: {
                        return 1;
                    }
                }
                return 0;
            }
            case 2: {
                switch (r2.k()) {
                    case 0: {
                        return 1;
                    }
                    case 1: {
                        return -1;
                    }
                    case 2: {
                        return 0;
                    }
                }
                return 0;
            }
        }
        return 0;
    }

    public double j() {
        return this.b;
    }

    public byte k() {
        return this.a;
    }
}

