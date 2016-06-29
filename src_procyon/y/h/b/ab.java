package y.h.b;

import y.h.*;
import java.awt.*;

abstract class ab implements az
{
    protected double a;
    protected double b;
    protected double c;
    protected double d;
    
    public void a(final double a, final double b, final double n, final double n2) {
        this.a = a;
        this.b = b;
        this.c = Math.ceil(n);
        this.d = Math.ceil(n2);
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int)this.a, (int)this.b, (int)this.c, (int)this.d);
    }
}
