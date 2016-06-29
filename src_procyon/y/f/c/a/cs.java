package y.f.c.a;

import java.util.*;
import y.g.*;

class cs implements Comparator
{
    private final cr a;
    
    cs(final cr a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        if (o == o2) {
            return 0;
        }
        return e.a(((cy)o).d, ((cy)o2).d);
    }
}
