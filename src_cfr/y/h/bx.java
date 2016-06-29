/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import y.h.ca;
import y.h.cb;
import y.h.cc;

public abstract class bX
implements ca,
cc {
    String a = "";
    Font b = new Font("Dialog", 0, 24);
    Color c = Color.black;
    cb d;
    TextLayout e;
    Rectangle2D.Double f = new Rectangle2D.Double();

    @Override
    public void a(cb cb2) {
        this.d = cb2;
    }

    @Override
    public Rectangle getBounds() {
        this.a();
        return this.f.getBounds();
    }

    abstract void a();

    public void a(Font font) {
        this.b = font;
    }

    public void a(String string) {
        this.a = string;
    }

    public void a(Color color) {
        this.c = color;
    }
}

