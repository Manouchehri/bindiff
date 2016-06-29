package y.f.g;

import java.util.*;

class x extends BitSet
{
    public x() {
    }
    
    public x(final int n) {
        super(n);
    }
    
    public int nextSetBit(final int n) {
        final boolean d = y.f.g.d.d;
        final int size = this.size();
        int i = n;
        while (i < size) {
            final int value;
            final boolean b = (value = (this.get(i) ? 1 : 0)) != 0;
            if (d) {
                return value;
            }
            if (b) {
                return i;
            }
            ++i;
            if (d) {
                break;
            }
        }
        return -1;
    }
    
    public int cardinality() {
        final boolean d = y.f.g.d.d;
        final int size = this.size();
        int n = 0;
        int i = 0;
        while (i < size) {
            final int value;
            final boolean b = (value = (this.get(i) ? 1 : 0)) != 0;
            if (d) {
                return value;
            }
            if (b) {
                ++n;
            }
            ++i;
            if (d) {
                break;
            }
        }
        return n;
    }
    
    public void clear(final int n, final int n2) {
        final boolean d = y.f.g.d.d;
        int i = n;
        while (i < n2) {
            this.clear(i);
            ++i;
            if (d) {
                break;
            }
        }
    }
    
    public void set(final int n, final int n2) {
        final boolean d = y.f.g.d.d;
        int i = n;
        while (i < n2) {
            this.set(i);
            ++i;
            if (d) {
                break;
            }
        }
    }
}
