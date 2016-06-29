package y.h;

import java.util.*;

public class dD extends EventObject
{
    private final dB a;
    private final gZ b;
    private final int c;
    private final double d;
    private final double e;
    private final boolean f;
    
    public dD(final dB a, final gZ b, final int c, final double d, final double e, final boolean f) {
        super(a);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public dB a() {
        return this.a;
    }
    
    public gZ b() {
        return this.b;
    }
    
    public double c() {
        return this.d;
    }
    
    public double d() {
        return this.e;
    }
    
    public boolean e() {
        return this.f;
    }
}
