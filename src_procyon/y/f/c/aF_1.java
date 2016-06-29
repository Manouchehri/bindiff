package y.f.c;

import java.util.*;
import y.f.*;

class aF implements Comparator
{
    boolean a;
    
    aF(final boolean a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        aG ag = null;
        aG ag2 = null;
        Label_0047: {
            if (this.a) {
                ag = ((S)o).f();
                ag2 = ((S)o2).f();
                if (!y.f.c.a.i) {
                    break Label_0047;
                }
            }
            ag2 = ((S)o).f();
            ag = ((S)o2).f();
        }
        final byte b = ag2.b();
        final byte b2 = ag.b();
        final byte a = ag2.a();
        final byte a2 = ag.a();
        if (a == a2) {
            if (b == b2) {
                return 0;
            }
            if (b == 16) {
                return -1;
            }
            if (b2 == 16) {
                return 1;
            }
            if (b == 32) {
                return -1;
            }
            if (b2 == 32) {
                return 1;
            }
            return 0;
        }
        else {
            if (a == 1) {
                return -1;
            }
            if (a == 2) {
                return 1;
            }
            if (a2 == 1) {
                return 1;
            }
            if (a2 == 2) {
                return -1;
            }
            return 0;
        }
    }
}
