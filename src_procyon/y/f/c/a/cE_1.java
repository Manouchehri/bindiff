package y.f.c.a;

import y.f.*;
import y.d.*;

class cE extends cn
{
    protected int h;
    protected boolean i;
    protected am j;
    
    public cE(final am j, final int h, final boolean i) {
        this.j = j;
        this.h = h;
        this.i = i;
    }
    
    public double b(final double n, final double n2) {
        if (this.i) {
            switch (this.h) {
                case 0: {
                    return this.j.getWidth() * 0.5 - n;
                }
                case 1: {
                    return this.j.getWidth() * 0.5 + n2;
                }
                case 2: {
                    return this.j.getWidth() * -0.5 + n;
                }
                case 3: {
                    return this.j.getWidth() * -0.5 - n2;
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
        else {
            switch (this.h) {
                case 0: {
                    return this.j.getWidth() * -0.5 + n;
                }
                case 1: {
                    return this.j.getWidth() * 0.5 + n2;
                }
                case 2: {
                    return this.j.getWidth() * 0.5 - n;
                }
                case 3: {
                    return this.j.getWidth() * -0.5 - n2;
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
    }
    
    public double c(final double n, final double n2) {
        if (this.i) {
            switch (this.h) {
                case 0: {
                    return this.j.getHeight() * -0.5 - n2;
                }
                case 1: {
                    return this.j.getHeight() * 0.5 - n;
                }
                case 2: {
                    return this.j.getHeight() * 0.5 + n2;
                }
                case 3: {
                    return this.j.getHeight() * -0.5 + n;
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
        else {
            switch (this.h) {
                case 0: {
                    return this.j.getHeight() * -0.5 - n2;
                }
                case 1: {
                    return this.j.getHeight() * -0.5 + n;
                }
                case 2: {
                    return this.j.getHeight() * 0.5 + n2;
                }
                case 3: {
                    return this.j.getHeight() * 0.5 - n;
                }
                default: {
                    throw new RuntimeException("Cannot be!");
                }
            }
        }
    }
    
    public t d(final double n, final double n2) {
        return new t(this.j.getX() + this.j.getWidth() * 0.5 + this.b(n, n2), this.j.getY() + this.j.getHeight() * 0.5 + this.c(n, n2));
    }
}
