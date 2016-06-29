/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.CharSource;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.Nullable;

class MultiReader
extends Reader {
    private final Iterator it;
    private Reader current;

    MultiReader(Iterator iterator) {
        this.it = iterator;
        this.advance();
    }

    private void advance() {
        this.close();
        if (!this.it.hasNext()) return;
        this.current = ((CharSource)this.it.next()).openStream();
    }

    @Override
    public int read(@Nullable char[] arrc, int n2, int n3) {
        if (this.current == null) {
            return -1;
        }
        int n4 = this.current.read(arrc, n2, n3);
        if (n4 != -1) return n4;
        this.advance();
        return this.read(arrc, n2, n3);
    }

    @Override
    public long skip(long l2) {
        Preconditions.checkArgument(l2 >= 0, "n is negative");
        if (l2 <= 0) return 0;
        while (this.current != null) {
            long l3 = this.current.skip(l2);
            if (l3 > 0) {
                return l3;
            }
            this.advance();
        }
        return 0;
    }

    @Override
    public boolean ready() {
        if (this.current == null) return false;
        if (!this.current.ready()) return false;
        return true;
    }

    @Override
    public void close() {
        if (this.current == null) return;
        try {
            this.current.close();
            return;
        }
        finally {
            this.current = null;
        }
    }
}

