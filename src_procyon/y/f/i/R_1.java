package y.f.i;

import y.g.*;

abstract class R implements Comparable, g
{
    private byte a;
    private double b;
    
    protected R(final byte a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    public void a(final double b) {
        this.b = b;
    }
    
    public void a(final byte a) {
        this.a = a;
    }
    
    public int compareTo(final Object o) {
        final R r = (R)o;
        final int a = e.a(this.b, r.j());
        if (a != 0) {
            return a;
        }
        switch (this.k()) {
            case 0: {
                switch (r.k()) {
                    case 0: {
                        return 0;
                    }
                    case 1: {
                        return 1;
                    }
                    case 2: {
                        return -1;
                    }
                    default: {
                        return 0;
                    }
                }
                break;
            }
            case 1: {
                switch (r.k()) {
                    case 0: {
                        return -1;
                    }
                    case 1: {
                        return 0;
                    }
                    case 2: {
                        return 1;
                    }
                    default: {
                        return 0;
                    }
                }
                break;
            }
            case 2: {
                switch (r.k()) {
                    case 0: {
                        return 1;
                    }
                    case 1: {
                        return -1;
                    }
                    case 2: {
                        return 0;
                    }
                    default: {
                        return 0;
                    }
                }
                break;
            }
            default: {
                return 0;
            }
        }
    }
    
    public double j() {
        return this.b;
    }
    
    public byte k() {
        return this.a;
    }
}
