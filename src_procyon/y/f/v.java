package y.f;

import java.awt.*;
import y.d.*;
import java.util.*;

public class v implements O
{
    Map a;
    Map b;
    Map c;
    
    public v() {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
    }
    
    public void a(final Object o, final am am) {
        this.a.put(o, am);
    }
    
    public void a(final Object o, final I i) {
        this.b.put(o, i);
    }
    
    public I b(final Object o) {
        return this.b.get(o);
    }
    
    public am a(final Object o) {
        return this.a.get(o);
    }
    
    public aj[] a_(final Object o) {
        return this.c.get(o);
    }
    
    public C[] d(final Object o) {
        return this.c.get(o);
    }
    
    public Rectangle a() {
        final boolean j = X.j;
        double n2;
        double n = n2 = Double.MAX_VALUE;
        double n4;
        double n3 = n4 = -1.7976931348623157E308;
        Object o = this.a.values().iterator();
        while (true) {
            while (((Iterator)o).hasNext()) {
                final am am = ((Iterator<am>)o).next();
                final double x = am.getX();
                final double y = am.getY();
                final double width = am.getWidth();
                final double height = am.getHeight();
                n2 = Math.min(x, n2);
                n = Math.min(y, n);
                n4 = Math.max(x + width, n4);
                n3 = Math.max(y + height, n3);
                if (!j) {
                    if (j) {
                        break;
                    }
                    continue;
                }
                else {
                Label_0267:
                    while (((Iterator)o).hasNext()) {
                        final I i = (I)((Iterator<am>)o).next();
                        int k = 0;
                        while (k < i.pointCount()) {
                            final t point = i.getPoint(k);
                            n2 = Math.min(point.a(), n2);
                            n = Math.min(point.b(), n);
                            n4 = Math.max(point.a(), n4);
                            n3 = Math.max(point.b(), n3);
                            ++k;
                            if (j) {
                                break Label_0267;
                            }
                            if (j) {
                                return new Rectangle((int)n2, (int)n, (int)(n4 - n2), (int)(n3 - n));
                            }
                            if (j) {
                                break Label_0267;
                            }
                        }
                    }
                    if (n2 == Double.MAX_VALUE && n == Double.MAX_VALUE) {
                        return new Rectangle(0, 0, -1, -1);
                    }
                    n2 = Math.floor(n2);
                    n = Math.floor(n);
                    n4 = Math.ceil(n4);
                    n3 = Math.ceil(n3);
                    return new Rectangle((int)n2, (int)n, (int)(n4 - n2), (int)(n3 - n));
                }
            }
            o = this.b.values().iterator();
            continue;
        }
    }
}
