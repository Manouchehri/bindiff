package y.f.i.a;

import y.c.*;
import y.f.*;
import y.d.*;
import java.util.*;

public class ai extends a
{
    private List a;
    private double b;
    private boolean c;
    
    public ai(final d d, final int n, final y y, final M m, final M i, final M j, final List a) {
        super(d, n, y, m, i, j);
        this.a = a;
    }
    
    public ai(final d d, final int n, final m m) {
        super(d, n, m);
    }
    
    public int l() {
        return this.a.size();
    }
    
    public g b(final int n) {
        return this.a.get(n);
    }
    
    public void a(final ah ah) {
        final int a = ab.a;
        super.a(ah);
        if (this.a != null) {
            final Iterator<g> iterator = (Iterator<g>)this.a.iterator();
            while (iterator.hasNext()) {
                iterator.next().a(ah);
                if (a != 0) {
                    break;
                }
            }
        }
    }
    
    double m() {
        return this.b;
    }
    
    void b(final double b) {
        this.b = b;
    }
    
    public boolean n() {
        return this.c;
    }
    
    public void a(final boolean c) {
        this.c = c;
    }
}
