package y.f.h;

import java.util.*;
import y.c.*;

class B implements Comparator
{
    private q a;
    private int[] b;
    
    public void a(final q a) {
        this.a = a;
    }
    
    public void a(final int[] b) {
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final int n = this.b[d.a(this.a).d()];
        final int n2 = this.b[d2.a(this.a).d()];
        if (n < n2) {
            return 1;
        }
        if (n > n2) {
            return -1;
        }
        return 0;
    }
}
