package y.h;

final class gS extends gP
{
    private double a;
    private double b;
    private double c;
    private final boolean d;
    
    public gS() {
        this(false);
    }
    
    public gS(final boolean d) {
        super(null);
        this.a = 0.0;
        this.c = 1.0E-16;
        this.b = this.a + this.c;
        this.d = d;
    }
}
