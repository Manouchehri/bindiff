package y.f.f.e;

import java.util.*;
import y.c.*;
import y.g.*;
import y.d.*;

class d implements Comparator
{
    i a;
    int b;
    private final a c;
    
    d(final a c) {
        this.c = c;
    }
    
    public int compare(final Object o, final Object o2) {
        final int a = y.f.f.e.a.a;
        final t p2 = y.f.f.e.a.a(this.c).p((y.c.d)o);
        final t p3 = y.f.f.e.a.a(this.c).p((y.c.d)o2);
        int n = 0;
        Label_0129: {
            switch (this.b) {
                case 0: {
                    n = e.a(p2.a, p3.a);
                    if (a != 0) {
                        break Label_0129;
                    }
                    break;
                }
                case 3: {
                    n = e.a(p2.b, p3.b);
                    if (a != 0) {
                        break Label_0129;
                    }
                    break;
                }
                case 2: {
                    n = e.a(p3.a, p2.a);
                    if (a != 0) {
                        break Label_0129;
                    }
                    break;
                }
                case 1: {
                    n = e.a(p3.b, p2.b);
                    break;
                }
            }
        }
        return n;
    }
}
