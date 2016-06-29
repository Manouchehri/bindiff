package y.b;

import java.util.*;

abstract class p implements l
{
    List a;
    boolean b;
    boolean c;
    
    p() {
        this.a = new ArrayList(2);
        this.b = false;
        this.c = false;
    }
    
    public void a(final d d) {
        if (this.b) {
            throw new IllegalStateException();
        }
        if (null == d) {
            return;
        }
        this.a.add(d);
        this.c = true;
    }
}
