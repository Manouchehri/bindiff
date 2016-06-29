package y.f;

import java.util.*;
import y.g.*;

class ag implements Comparator
{
    private final X a;
    private final boolean b;
    
    ag(final X a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final am a = this.a.a(o);
        final am a2 = this.a.a(o2);
        if (this.b) {
            return e.a(a.getY() + a.getHeight() * 0.5, a2.getY() + a2.getHeight() * 0.5);
        }
        return e.a(a.getX() + a.getWidth() * 0.5, a2.getX() + a2.getWidth() * 0.5);
    }
}
