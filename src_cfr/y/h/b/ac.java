/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import y.h.b.a;
import y.h.b.ab;

class ac
extends ab {
    private double e;
    private boolean f;
    private Color g = new Color(0, 222, 0, 192);
    private Stroke h = new BasicStroke(2.0f);

    ac() {
    }

    @Override
    public void a(Graphics2D graphics2D) {
        graphics2D.setColor(this.g);
        graphics2D.setStroke(this.h);
        int n2 = (int)this.a;
        int n3 = (int)this.b;
        int n4 = (int)this.c;
        int n5 = (int)this.d;
        int n6 = (int)this.a();
        graphics2D.drawRect(n2, n3, n4, n5);
        if (this.b()) {
            graphics2D.drawLine(n2 + n6, n3, n2 + n6, n3 + n5);
            if (a.H == 0) return;
        }
        graphics2D.drawLine(n2, n3 + n6, n2 + n4, n3 + n6);
    }

    public double a() {
        return this.e;
    }

    public void a(double d2) {
        this.e = d2;
    }

    public boolean b() {
        return this.f;
    }

    public void a(boolean bl2) {
        this.f = bl2;
    }
}

