package org.jfree.data.function;

public class LineFunction2D implements Function2D
{
    private double a;
    private double b;
    
    public LineFunction2D(final double a, final double b) {
        this.a = a;
        this.b = b;
    }
    
    public double getValue(final double n) {
        return this.a + this.b * n;
    }
}
