package y.d;

public class q implements Comparable
{
    public final double a;
    public final double b;
    
    public q(final double a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    public final double a() {
        return this.a;
    }
    
    public final double b() {
        return this.b;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof q)) {
            return false;
        }
        final q q = (q)o;
        return q.a == this.a && q.b == this.b;
    }
    
    public int hashCode() {
        final long n = Double.doubleToLongBits(this.a) << 1 ^ Double.doubleToLongBits(this.b);
        return (int)(n ^ n >> 32);
    }
    
    public String toString() {
        return "W: " + this.a + " H: " + this.b;
    }
    
    public int compareTo(final Object o) {
        final q q = (q)o;
        if (this.equals(q)) {
            return 0;
        }
        if (q.a > this.a) {
            return -1;
        }
        if (q.a < this.a) {
            return 1;
        }
        if (q.b > this.b) {
            return -1;
        }
        if (q.b < this.b) {
            return 1;
        }
        return 0;
    }
}
