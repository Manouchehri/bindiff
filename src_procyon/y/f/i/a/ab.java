package y.f.i.a;

import java.util.*;

public abstract class ab
{
    private Z b;
    private aa c;
    private int d;
    public static int a;
    
    protected Z a() {
        return this.b;
    }
    
    protected aa b() {
        return this.c;
    }
    
    protected void a(final Z b) {
        this.b = b;
    }
    
    protected void a(final aa c) {
        this.c = c;
    }
    
    protected void b(final aa aa) {
    }
    
    protected void a(final List list) {
    }
    
    protected double a(final f f) {
        return 0.0;
    }
    
    protected double a(final f f, final R r, final P p5, final v v, final double n) {
        return 0.0;
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        final int a = ab.a;
        final double[] array4 = new double[array.length];
        this.d = array.length;
        int i = 0;
        double[] array5 = null;
        while (i < array.length) {
            array5 = array4;
            if (a != 0) {
                return array5;
            }
            array5[i] = this.a(f, r, array[i], array2[i], array3[i]);
            ++i;
            --this.d;
            if (a != 0) {
                break;
            }
        }
        return array5;
    }
    
    protected double b(final f f) {
        return 0.0;
    }
    
    protected boolean c(final f f) {
        return true;
    }
    
    protected void a(final U u) {
    }
    
    protected void c(final aa aa) {
    }
    
    protected void d(final aa aa) {
    }
    
    protected void e(final aa aa) {
    }
    
    protected void a(final ac ac) {
    }
    
    protected void c() {
        this.b = null;
        this.c = null;
    }
    
    void a(final String s, final double n, final boolean b) {
    }
    
    void b(final String s, final double n, final boolean b) {
    }
}
