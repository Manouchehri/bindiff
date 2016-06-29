package y.f;

import java.util.*;

class aU extends BitSet
{
    public aU() {
    }
    
    public aU(final int n) {
        super(n);
    }
    
    public int nextSetBit(final int n) {
        final boolean j = X.j;
        final int size = this.size();
        int i = n;
        while (i < size) {
            final int value;
            final boolean b = (value = (this.get(i) ? 1 : 0)) != 0;
            if (j) {
                return value;
            }
            if (b) {
                return i;
            }
            ++i;
            if (j) {
                break;
            }
        }
        return -1;
    }
    
    public int cardinality() {
        final boolean j = X.j;
        final int size = this.size();
        int n = 0;
        int i = 0;
        while (i < size) {
            final int value;
            final boolean b = (value = (this.get(i) ? 1 : 0)) != 0;
            if (j) {
                return value;
            }
            if (b) {
                ++n;
            }
            ++i;
            if (j) {
                break;
            }
        }
        return n;
    }
    
    public void clear(final int n, final int n2) {
        final boolean j = X.j;
        int i = n;
        while (i < n2) {
            this.clear(i);
            ++i;
            if (j) {
                break;
            }
        }
    }
    
    public void set(final int n, final int n2) {
        final boolean j = X.j;
        int i = n;
        while (i < n2) {
            this.set(i);
            ++i;
            if (j) {
                break;
            }
        }
    }
}
