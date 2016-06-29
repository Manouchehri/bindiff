package y.f.d;

import java.util.*;

class B extends BitSet
{
    public B() {
    }
    
    public B(final int n) {
        super(n);
    }
    
    public int nextSetBit(final int n) {
        final int f = a.f;
        final int size = this.size();
        int i = n;
        while (i < size) {
            final int value;
            final boolean b = (value = (this.get(i) ? 1 : 0)) != 0;
            if (f != 0) {
                return value;
            }
            if (b) {
                return i;
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
        return -1;
    }
    
    public int cardinality() {
        final int f = a.f;
        final int size = this.size();
        int n = 0;
        int i = 0;
        while (i < size) {
            final int value;
            final boolean b = (value = (this.get(i) ? 1 : 0)) != 0;
            if (f != 0) {
                return value;
            }
            if (b) {
                ++n;
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
        return n;
    }
    
    public void clear(final int n, final int n2) {
        final int f = a.f;
        int i = n;
        while (i < n2) {
            this.clear(i);
            ++i;
            if (f != 0) {
                break;
            }
        }
    }
    
    public void set(final int n, final int n2) {
        final int f = a.f;
        int i = n;
        while (i < n2) {
            this.set(i);
            ++i;
            if (f != 0) {
                break;
            }
        }
    }
}
