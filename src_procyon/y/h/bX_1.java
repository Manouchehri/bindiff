package y.h;

import java.awt.font.*;
import java.awt.geom.*;
import java.awt.*;

public abstract class bX implements ca, cc
{
    String a;
    Font b;
    Color c;
    cb d;
    TextLayout e;
    Rectangle2D.Double f;
    
    public bX() {
        this.f = new Rectangle2D.Double();
        this.a = "";
        this.b = new Font("Dialog", 0, 24);
        this.c = Color.black;
    }
    
    public void a(final cb d) {
        this.d = d;
    }
    
    public Rectangle getBounds() {
        this.a();
        return this.f.getBounds();
    }
    
    abstract void a();
    
    public void a(final Font b) {
        this.b = b;
    }
    
    public void a(final String a) {
        this.a = a;
    }
    
    public void a(final Color c) {
        this.c = c;
    }
}
