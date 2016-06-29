package y.f;

final class aB implements aA
{
    ax a;
    int b;
    int c;
    
    aB(final ax a, final int n) {
        this.a = a;
        this.c = n;
        this.b = n;
    }
    
    public aB(final aB ab) {
        this(ab.a, ab.c);
    }
    
    public int b() {
        return this.b;
    }
    
    public ax a() {
        return this.a;
    }
    
    public String toString() {
        return "PortCandidateSet.Entry(candidate=" + this.a + ", connections=" + this.b + ')';
    }
}
