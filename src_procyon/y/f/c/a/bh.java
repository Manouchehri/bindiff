package y.f.c.a;

import java.util.*;

public class bh
{
    private ArrayList a;
    private final boolean b;
    
    bh(final bt bt, final l l) {
        (this.a = new ArrayList()).add(new bj(bt, l, null));
        this.b = false;
    }
    
    bh(final Collection collection, final Collection collection2) {
        final boolean x = N.x;
        this.a = new ArrayList();
    Label_0112:
        for (final l l : collection2) {
            final Iterator<bt> iterator2 = collection.iterator();
            while (iterator2.hasNext()) {
                this.a.add(new bj(iterator2.next(), l, null));
                if (x || x) {
                    return;
                }
                if (x) {
                    break Label_0112;
                }
            }
        }
        Collections.sort((List<Comparable>)this.a);
        this.b = true;
    }
    
    public Collection a() {
        return Collections.unmodifiableCollection((Collection<?>)this.a);
    }
    
    public boolean b() {
        return this.b;
    }
    
    public bt c() {
        return this.a.get(0).a;
    }
    
    public l d() {
        return this.a.get(0).b;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final bh bh = (bh)o;
        if (this.b != bh.b) {
            return false;
        }
        if (this.a != null) {
            if (this.a.equals(bh.a)) {
                return true;
            }
        }
        else if (bh.a == null) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        return 31 * ((this.a != null) ? this.a.hashCode() : 0) + (this.b ? 1 : 0);
    }
}
