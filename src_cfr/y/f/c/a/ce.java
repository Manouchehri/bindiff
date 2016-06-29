/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.d.t;
import y.f.am;
import y.f.c.a.cn;

class cE
extends cn {
    protected int h;
    protected boolean i;
    protected am j;

    public cE(am am2, int n2, boolean bl2) {
        this.j = am2;
        this.h = n2;
        this.i = bl2;
    }

    @Override
    public double b(double d2, double d3) {
        if (this.i) {
            switch (this.h) {
                case 0: {
                    return this.j.getWidth() * 0.5 - d2;
                }
                case 1: {
                    return this.j.getWidth() * 0.5 + d3;
                }
                case 2: {
                    return this.j.getWidth() * -0.5 + d2;
                }
                case 3: {
                    return this.j.getWidth() * -0.5 - d3;
                }
            }
            throw new RuntimeException("Cannot be!");
        }
        switch (this.h) {
            case 0: {
                return this.j.getWidth() * -0.5 + d2;
            }
            case 1: {
                return this.j.getWidth() * 0.5 + d3;
            }
            case 2: {
                return this.j.getWidth() * 0.5 - d2;
            }
            case 3: {
                return this.j.getWidth() * -0.5 - d3;
            }
        }
        throw new RuntimeException("Cannot be!");
    }

    @Override
    public double c(double d2, double d3) {
        if (this.i) {
            switch (this.h) {
                case 0: {
                    return this.j.getHeight() * -0.5 - d3;
                }
                case 1: {
                    return this.j.getHeight() * 0.5 - d2;
                }
                case 2: {
                    return this.j.getHeight() * 0.5 + d3;
                }
                case 3: {
                    return this.j.getHeight() * -0.5 + d2;
                }
            }
            throw new RuntimeException("Cannot be!");
        }
        switch (this.h) {
            case 0: {
                return this.j.getHeight() * -0.5 - d3;
            }
            case 1: {
                return this.j.getHeight() * -0.5 + d2;
            }
            case 2: {
                return this.j.getHeight() * 0.5 + d3;
            }
            case 3: {
                return this.j.getHeight() * 0.5 - d2;
            }
        }
        throw new RuntimeException("Cannot be!");
    }

    @Override
    public t d(double d2, double d3) {
        return new t(this.j.getX() + this.j.getWidth() * 0.5 + this.b(d2, d3), this.j.getY() + this.j.getHeight() * 0.5 + this.c(d2, d3));
    }
}

