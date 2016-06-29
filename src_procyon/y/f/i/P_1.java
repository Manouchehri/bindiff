package y.f.i;

import y.g.*;

class P extends R
{
    private final Q a;
    
    P(final byte b, final double n, final Q a) {
        super(b, n);
        this.a = a;
    }
    
    Q a() {
        return this.a;
    }
    
    public int compareTo(final Object o) {
        final R r = (R)o;
        final int a = e.a(this.j(), r.j());
        if (a != 0) {
            return a;
        }
        switch (this.k()) {
            case 3: {
                switch (r.k()) {
                    case 3: {
                        return 0;
                    }
                    case 4: {
                        return 1;
                    }
                    default: {
                        return 0;
                    }
                }
                break;
            }
            case 4: {
                switch (r.k()) {
                    case 3: {
                        return -1;
                    }
                    case 4: {
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
    
    public String toString() {
        return "x = " + this.j() + ", type = " + ((this.k() == 3) ? "Start" : "End");
    }
}
