package y.h;

import java.util.*;
import y.c.*;

final class aw implements am
{
    private final ArrayList a;
    private int b;
    private final as c;
    
    aw(final as c, final ArrayList a) {
        this.c = c;
        this.a = a;
    }
    
    public boolean a() {
        final boolean z = fj.z;
        boolean b = false;
        final int size = this.a.size();
        int empty = 0;
        while (this.b < size) {
            empty = (this.c.f.isEmpty() ? 1 : 0);
            if (z) {
                return empty > size - 1 && !b;
            }
            if (empty == 0) {
                break;
            }
            final q q = this.a.get(this.b);
            final at at = new at(this.c, q);
            this.c.c.add(at);
            b = true;
            final ax ax = new ax(this.c, q);
            final int size2 = this.c.c.size();
            this.c.c.add(ax);
            if (ax.a()) {
                this.c.c.remove(size2);
                if (this.c.f.isEmpty() && at.a()) {
                    this.c.c.remove(this.c.c.size() - 1);
                    b = false;
                }
            }
            ++this.b;
            if (z) {
                break;
            }
        }
        final int b2 = this.b;
        return empty > size - 1 && !b;
    }
}
