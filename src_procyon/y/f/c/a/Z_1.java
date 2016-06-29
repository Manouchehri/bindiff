package y.f.c.a;

public final class Z
{
    public static final Z a;
    static final Z b;
    static final Z c;
    static final Z d;
    static final Z e;
    static final Z f;
    final byte g;
    
    private Z(final byte g) {
        this.g = g;
    }
    
    public byte a() {
        return this.g;
    }
    
    static {
        a = new Z((byte)(-1));
        b = new Z((byte)0);
        c = new Z((byte)1);
        d = new Z((byte)4);
        e = new Z((byte)6);
        f = new Z((byte)5);
    }
}
