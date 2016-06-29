package y.f.c.a;

import java.util.*;
import y.c.*;
import y.g.*;

final class w implements Comparator
{
    final float[] a;
    
    w(final float[] a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return e.a(this.a[((q)o).d()], this.a[((q)o2).d()]);
    }
}
