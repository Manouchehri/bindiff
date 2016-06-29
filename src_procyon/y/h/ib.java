package y.h;

import java.awt.image.*;
import java.awt.*;

class ib
{
    public static final Color a;
    private double b;
    private Color c;
    private BufferedImage d;
    private final int e = 9;
    private final double f = 2.0;
    private AlphaComposite g;
    
    public ib() {
        this(3.0, ib.a);
    }
    
    public ib(final double n, final Color color) {
        this.b = 3.0;
        this.c = ib.a;
        this.g = AlphaComposite.getInstance(5, 1.0f);
        this.a(n);
        this.a(color);
    }
    
    public void a(final double b) {
        if (this.b != b) {
            this.b = b;
            this.a();
        }
    }
    
    public void a(final Color c) {
        if (this.c != c) {
            this.c = c;
            this.a();
        }
    }
    
    protected void a() {
        this.d = null;
    }
    
    static {
        a = new Color(0, 0, 0, 77);
    }
}
