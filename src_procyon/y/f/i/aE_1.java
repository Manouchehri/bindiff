package y.f.i;

import java.util.*;
import y.c.*;

class aE implements Comparator
{
    private q a;
    private c b;
    
    public aE(final q a, final c b) {
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final q a = d.a(this.a);
        final q a2 = d2.a(this.a);
        final aM am = (aM)this.b.b(a);
        final aM am2 = (aM)this.b.b(a2);
        final double b = ((aP)am.a()).b;
        final double b2 = ((aP)am2.a()).b;
        if (b < b2) {
            return -1;
        }
        if (b > b2) {
            return 1;
        }
        return 0;
    }
}
