package y.h;

import java.util.*;
import y.c.*;

final class ap implements am
{
    private final ArrayList a;
    private int b;
    private final an c;
    
    ap(final an c, final ArrayList a) {
        this.c = c;
        this.a = a;
    }
    
    public boolean a() {
        final boolean z = fj.z;
        final int size = this.a.size();
        int empty = 0;
        while (this.b < size) {
            empty = (this.c.f.isEmpty() ? 1 : 0);
            if (z) {
                return empty > size - 1;
            }
            if (empty == 0) {
                break;
            }
            this.c.b(this.a.get(this.b));
            ++this.b;
            if (z) {
                break;
            }
        }
        final int b = this.b;
        return empty > size - 1;
    }
}
