package y.f.b;

import y.c.*;
import java.util.*;

class n
{
    D a;
    D b;
    D c;
    D d;
    
    n() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }
    
    public D a() {
        final D d = new D();
        if (this.a != null) {
            d.addAll(this.a);
        }
        if (this.b != null) {
            d.addAll(this.b);
        }
        if (this.c != null) {
            d.addAll(this.c);
        }
        if (this.d != null) {
            d.addAll(this.d);
        }
        return d;
    }
}
