package y.f.i;

import java.util.*;
import y.d.*;

class aD implements Comparator
{
    private t a;
    
    public aD(final t a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final int f = v.f;
        final ao ao = (ao)o;
        final ao ao2 = (ao)o2;
        if (ao == null && ao2 == null) {
            return 0;
        }
        if (ao == null) {
            return -1;
        }
        if (ao2 == null) {
            return 1;
        }
        double n = 0.0;
        Label_0086: {
            if (ao.x()) {
                n = Math.abs(ao.r() - this.a.a);
                if (f == 0) {
                    break Label_0086;
                }
            }
            n = Math.abs(ao.s() - this.a.b);
        }
        double n2 = 0.0;
        Label_0135: {
            if (ao2.x()) {
                n2 = Math.abs(ao2.r() - this.a.a);
                if (f == 0) {
                    break Label_0135;
                }
            }
            n2 = Math.abs(ao2.s() - this.a.b);
        }
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        return 0;
    }
}
