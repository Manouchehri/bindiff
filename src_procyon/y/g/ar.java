package y.g;

import java.util.*;

public class ar extends Random
{
    public ar() {
    }
    
    public ar(final long n) {
        super(n);
    }
    
    public int nextInt(final int n) {
        final boolean c = p.c;
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        int i = 0;
    Block_3:
        while (true) {
            final int n2 = this.next(31) % n;
            while (i >= 0) {
                i = n2;
                if (!c) {
                    break Block_3;
                }
            }
        }
        return i;
    }
    
    public double a(final double n, final double n2) {
        return this.nextDouble() * (n2 - n) + n;
    }
    
    public int a(final int n, final int n2) {
        return this.nextInt(n2 - n) + n;
    }
    
    public void a(final Object[] array) {
        final boolean c = p.c;
        int i = 0;
        while (true) {
            while (i < array.length) {
                final int nextInt = this.nextInt(array.length);
                final Object o = array[i];
                array[i] = array[nextInt];
                array[nextInt] = o;
                ++i;
                if (c) {
                    while (i >= 0) {
                        final int nextInt2 = this.nextInt(array.length);
                        final Object o2 = array[i];
                        array[i] = array[nextInt2];
                        array[nextInt2] = o2;
                        --i;
                        if (c) {
                            break;
                        }
                    }
                    return;
                }
                if (c) {
                    break;
                }
            }
            i = array.length - 1;
            continue;
        }
    }
}
