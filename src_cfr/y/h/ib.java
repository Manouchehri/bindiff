/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.image.BufferedImage;

class ib {
    public static final Color a = new Color(0, 0, 0, 77);
    private double b = 3.0;
    private Color c = a;
    private BufferedImage d;
    private final int e = 9;
    private final double f = 2.0;
    private AlphaComposite g = AlphaComposite.getInstance(5, 1.0f);

    public ib() {
        this(3.0, a);
    }

    public ib(double d2, Color color) {
        this.a(d2);
        this.a(color);
    }

    public void a(double d2) {
        if (this.b == d2) return;
        this.b = d2;
        this.a();
    }

    public void a(Color color) {
        if (this.c == color) return;
        this.c = color;
        this.a();
    }

    protected void a() {
        this.d = null;
    }
}

