package y.f;

public final class y
{
    public static final y a;
    public static final y b;
    public static final y c;
    public static final y d;
    private final int e;
    
    private y(final int e) {
        this.e = e;
    }
    
    public y a() {
        switch (this.e) {
            case 0: {
                return y.b;
            }
            case 1: {
                return y.c;
            }
            case 2: {
                return y.d;
            }
            case 3: {
                return y.a;
            }
            default: {
                throw new IllegalArgumentException("Invalid direction: " + this.e);
            }
        }
    }
    
    public y b() {
        switch (this.e) {
            case 0: {
                return y.d;
            }
            case 1: {
                return y.a;
            }
            case 2: {
                return y.b;
            }
            case 3: {
                return y.c;
            }
            default: {
                throw new IllegalArgumentException("Invalid direction: " + this.e);
            }
        }
    }
    
    public y c() {
        switch (this.e) {
            case 0: {
                return y.c;
            }
            case 1: {
                return y.d;
            }
            case 2: {
                return y.a;
            }
            case 3: {
                return y.b;
            }
            default: {
                throw new IllegalArgumentException("Invalid direction: " + this.e);
            }
        }
    }
    
    public boolean d() {
        return this.e == 1 || this.e == 3;
    }
    
    public boolean e() {
        return this.e == 0 || this.e == 2;
    }
    
    public int f() {
        return this.e;
    }
    
    public String toString() {
        switch (this.e) {
            case 0: {
                return "^";
            }
            case 1: {
                return ">";
            }
            case 2: {
                return "v";
            }
            case 3: {
                return "<";
            }
            default: {
                throw new IllegalArgumentException("Invalid direction: " + this.e);
            }
        }
    }
    
    static {
        a = new y(0);
        b = new y(1);
        c = new y(2);
        d = new y(3);
    }
}
