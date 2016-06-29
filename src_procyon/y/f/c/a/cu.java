package y.f.c.a;

class cu implements Comparable
{
    private double a;
    private byte b;
    private cw c;
    
    cu(final double a, final byte b, final cw c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    boolean a() {
        return this.b == 0;
    }
    
    public int compareTo(final Object o) {
        final cu cu = (cu)o;
        if (this.a < cu.a) {
            return -1;
        }
        if (this.a > cu.a) {
            return 1;
        }
        return 0;
    }
    
    static double a(final cu cu) {
        return cu.a;
    }
    
    static cw b(final cu cu) {
        return cu.c;
    }
}
