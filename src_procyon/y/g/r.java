package y.g;

import y.c.*;
import java.util.*;

public class r
{
    private final i b;
    D a;
    
    public r(final i b) {
        this.b = b;
        this.a = new D();
    }
    
    public void a(final Object o, final c c) {
        this.a.add(new s(o, this.b.c(o)));
        this.b.a(o, c);
    }
    
    public void a() {
        final boolean c = p.c;
        for (final s s : this.a) {
            this.b.d_(s.a);
            if (s.b != null) {
                this.b.a(s.a, s.b);
                if (c) {
                    return;
                }
                if (c) {
                    break;
                }
                continue;
            }
        }
        this.a.clear();
    }
}
