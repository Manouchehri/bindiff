/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

public class InodeCache {
    private static final Object PLACEHOLDER = new Object();
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

    public InodeCache(int n2) {
        this.maxSize = n2;
        this.totalSlots = n2 * 2 * 2 + 3;
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

    private static void fill(Object[] arrobject, Object object) {
        int n2 = 0;
        while (n2 < arrobject.length) {
            arrobject[n2] = object;
            ++n2;
        }
    }

    private static void fill(short[] arrs, short s2) {
        int n2 = 0;
        while (n2 < arrs.length) {
            arrs[n2] = s2;
            ++n2;
        }
    }

    public final void clear() {
        this.usedSlots = 0;
        this.size = 0;
        this.lru = -1;
        this.mru = -1;
        InodeCache.fill(this.keys, null);
        InodeCache.fill(this.inodes, -1);
        InodeCache.fill(this.reverse, -1);
    }

    public final short get(Object object) {
        Object object2;
        int n2;
        int n3 = object.hashCode() & Integer.MAX_VALUE;
        int n4 = n2 = n3 % this.totalSlots;
        int n5 = 1;
        boolean bl2 = true;
        int n6 = -1;
        while ((object2 = this.keys[n2]) != null) {
            if (object2 == PLACEHOLDER) {
                if (n6 == -1) {
                    n6 = n2;
                }
            } else if (object2.equals(object)) {
                short s2 = this.inodes[n2];
                if (n2 == this.mru) {
                    return s2;
                }
                if (this.lru == n2) {
                    this.lru = this.next[this.lru];
                } else {
                    short s3;
                    short s4 = this.prev[n2];
                    this.next[s4] = s3 = this.next[n2];
                    this.prev[s3] = s4;
                }
                this.prev[n2] = this.mru;
                this.next[this.mru] = (short)n2;
                this.mru = (short)n2;
                return s2;
            }
            n2 = Math.abs((n4 + (bl2 ? 1 : -1) * n5 * n5) % this.totalSlots);
            if (!bl2) {
                ++n5;
            }
            bl2 = !bl2;
        }
        int n7 = n2;
        if (this.usedSlots == this.maxUsedSlots) {
            this.clear();
            return this.get(object);
        }
        ++this.usedSlots;
        if (this.size == this.maxSize) {
            this.keys[this.lru] = PLACEHOLDER;
            this.inodes[this.lru] = -2;
            this.lru = this.next[this.lru];
        } else {
            if (this.size == 0) {
                this.lru = (short)n7;
            }
            ++this.size;
        }
        int n8 = n3 & 32767;
        block1 : do {
            n4 = n2 = n8 % this.totalSlots;
            n5 = 1;
            bl2 = true;
            n6 = -1;
            short s5;
            while ((s5 = this.reverse[n2]) != -1) {
                short s6 = this.inodes[s5];
                if (s6 == -2) {
                    if (n6 == -1) {
                        n6 = n2;
                    }
                } else if (s6 == n8) {
                    ++n8;
                    continue block1;
                }
                n2 = Math.abs((n4 + (bl2 ? 1 : -1) * n5 * n5) % this.totalSlots);
                if (!bl2) {
                    ++n5;
                }
                bl2 = !bl2;
            }
            break block1;
            break;
        } while (true);
        this.keys[n7] = object;
        this.reverse[n2] = (short)n7;
        this.inodes[n7] = (short)n8;
        if (this.mru != -1) {
            this.prev[n7] = this.mru;
            this.next[this.mru] = (short)n7;
        }
        this.mru = (short)n7;
        return (short)n8;
    }

    public Object reverse(short s2) {
        short s3;
        int n2;
        int n3 = n2 = s2 % this.totalSlots;
        int n4 = 1;
        boolean bl2 = true;
        while ((s3 = this.reverse[n2]) != -1) {
            if (this.inodes[s3] == s2) {
                return this.keys[s3];
            }
            n2 = Math.abs((n3 + (bl2 ? 1 : -1) * n4 * n4) % this.totalSlots);
            if (!bl2) {
                ++n4;
            }
            bl2 = !bl2;
        }
        return null;
    }
}

