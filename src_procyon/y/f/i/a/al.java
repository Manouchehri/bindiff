package y.f.i.a;

import java.util.*;
import y.c.*;

public final class al
{
    private List a;
    private byte b;
    private ai c;
    
    public al(final ai c) {
        (this.a = new D()).add(c);
        this.b = 0;
        this.c = c;
    }
    
    public void a(final ai c) {
        Label_0030: {
            if (this.c.h() == c.h()) {
                this.b = 1;
                if (ab.a == 0) {
                    break Label_0030;
                }
            }
            this.b = 2;
        }
        if (c.j() < this.c.j()) {
            this.c = c;
        }
        this.a.add(c);
    }
    
    static byte a(final al al) {
        return al.b;
    }
    
    static ai b(final al al) {
        return al.c;
    }
}
