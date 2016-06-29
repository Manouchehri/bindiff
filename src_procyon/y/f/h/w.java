package y.f.h;

import java.util.*;
import y.c.*;

public class w implements Comparator
{
    q a;
    int[] b;
    
    public void a(final q a) {
        this.a = a;
    }
    
    public void a(final int[] b) {
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final int n = this.b[this.a.d()];
        final int n2 = this.b[d.a(this.a).d()];
        final int n3 = this.b[d2.a(this.a).d()];
        if ((n2 > n && n3 > n) || (n2 < n && n3 < n)) {
            if (n2 > n3) {
                return 1;
            }
            if (n2 < n3) {
                return -1;
            }
            return 0;
        }
        else {
            if (n2 > n3) {
                return -1;
            }
            if (n2 < n3) {
                return 1;
            }
            return 0;
        }
    }
}
