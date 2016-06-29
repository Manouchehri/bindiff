package org.ibex.nestedvm.util;

public class InodeCache
{
    private static final Object PLACEHOLDER;
    private static final short SHORT_PLACEHOLDER = -2;
    private static final short SHORT_NULL = -1;
    private static final int LOAD_FACTOR = 2;
    private final int maxSize;
    private final int totalSlots;
    private final int maxUsedSlots;
    private final Object[] keys;
    private final short[] next;
    private final short[] prev;
    private final short[] inodes;
    private final short[] reverse;
    private int size;
    private int usedSlots;
    private short mru;
    private short lru;
    
    public InodeCache() {
        this(1024);
    }
    
    public InodeCache(final int maxSize) {
        this.maxSize = maxSize;
        this.totalSlots = maxSize * 2 * 2 + 3;
        this.maxUsedSlots = this.totalSlots / 2;
        if (this.totalSlots > 32767) {
            throw new IllegalArgumentException("cache size too large");
        }
        this.keys = new Object[this.totalSlots];
        this.next = new short[this.totalSlots];
        this.prev = new short[this.totalSlots];
        this.inodes = new short[this.totalSlots];
        this.reverse = new short[this.totalSlots];
        this.clear();
    }
    
    private static void fill(final Object[] array, final Object o) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = o;
        }
    }
    
    private static void fill(final short[] array, final short n) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = n;
        }
    }
    
    public final void clear() {
        final boolean b = false;
        this.usedSlots = (b ? 1 : 0);
        this.size = (b ? 1 : 0);
        final short n = -1;
        this.lru = n;
        this.mru = n;
        fill(this.keys, null);
        fill(this.inodes, (short)(-1));
        fill(this.reverse, (short)(-1));
    }
    
    public final short get(final Object o) {
        final int n = o.hashCode() & Integer.MAX_VALUE;
        final int n2;
        int abs = n2 = n % this.totalSlots;
        int n3 = 1;
        boolean b = true;
        int n4 = -1;
        Object o2;
        while ((o2 = this.keys[abs]) != null) {
            if (o2 == InodeCache.PLACEHOLDER) {
                if (n4 == -1) {
                    n4 = abs;
                }
            }
            else if (o2.equals(o)) {
                final short n5 = this.inodes[abs];
                if (abs == this.mru) {
                    return n5;
                }
                if (this.lru == abs) {
                    this.lru = this.next[this.lru];
                }
                else {
                    final short n6 = this.prev[abs];
                    final short n7 = this.next[abs];
                    this.next[n6] = n7;
                    this.prev[n7] = n6;
                }
                this.prev[abs] = this.mru;
                this.next[this.mru] = (short)abs;
                this.mru = (short)abs;
                return n5;
            }
            abs = Math.abs((n2 + (b ? 1 : -1) * n3 * n3) % this.totalSlots);
            if (!b) {
                ++n3;
            }
            b = !b;
        }
        int n8;
        if (n4 == -1) {
            n8 = abs;
            if (this.usedSlots == this.maxUsedSlots) {
                this.clear();
                return this.get(o);
            }
            ++this.usedSlots;
        }
        else {
            n8 = n4;
        }
        if (this.size == this.maxSize) {
            this.keys[this.lru] = InodeCache.PLACEHOLDER;
            this.inodes[this.lru] = -2;
            this.lru = this.next[this.lru];
        }
        else {
            if (this.size == 0) {
                this.lru = (short)n8;
            }
            ++this.size;
        }
        int n9 = n & 0x7FFF;
        int abs2 = 0;
        int n12 = 0;
    Label_0354:
        while (true) {
            final int n10;
            abs2 = (n10 = n9 % this.totalSlots);
            int n11 = 1;
            boolean b2 = true;
            n12 = -1;
            short n13;
            while ((n13 = this.reverse[abs2]) != -1) {
                final short n14 = this.inodes[n13];
                if (n14 == -2) {
                    if (n12 == -1) {
                        n12 = abs2;
                    }
                }
                else if (n14 == n9) {
                    ++n9;
                    continue Label_0354;
                }
                abs2 = Math.abs((n10 + (b2 ? 1 : -1) * n11 * n11) % this.totalSlots);
                if (!b2) {
                    ++n11;
                }
                b2 = !b2;
            }
            break;
        }
        if (n12 != -1) {
            abs2 = n12;
        }
        this.keys[n8] = o;
        this.reverse[abs2] = (short)n8;
        this.inodes[n8] = (short)n9;
        if (this.mru != -1) {
            this.prev[n8] = this.mru;
            this.next[this.mru] = (short)n8;
        }
        this.mru = (short)n8;
        return (short)n9;
    }
    
    public Object reverse(final short n) {
        final int n2;
        int abs = n2 = n % this.totalSlots;
        int n3 = 1;
        boolean b = true;
        short n4;
        while ((n4 = this.reverse[abs]) != -1) {
            if (this.inodes[n4] == n) {
                return this.keys[n4];
            }
            abs = Math.abs((n2 + (b ? 1 : -1) * n3 * n3) % this.totalSlots);
            if (!b) {
                ++n3;
            }
            b = !b;
        }
        return null;
    }
    
    static {
        PLACEHOLDER = new Object();
    }
}
