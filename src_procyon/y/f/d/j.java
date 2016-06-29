package y.f.d;

import y.f.*;
import y.d.*;

class j implements o
{
    private Q a;
    private Object b;
    private o c;
    private byte d;
    
    j(final Object b, final o c, final byte d) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.a = null;
    }
    
    j(final Object b, final Q a, final byte d) {
        this.b = b;
        this.a = a;
        this.c = a.h();
        this.d = d;
    }
    
    public Object a() {
        return this.b;
    }
    
    public o b() {
        return this.c;
    }
    
    public byte c() {
        return this.d;
    }
    
    public Q d() {
        return this.a;
    }
    
    public y h() {
        return this.c.h();
    }
}
