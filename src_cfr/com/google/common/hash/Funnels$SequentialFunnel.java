/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

class Funnels$SequentialFunnel
implements Funnel,
Serializable {
    private final Funnel elementFunnel;

    Funnels$SequentialFunnel(Funnel funnel) {
        this.elementFunnel = (Funnel)Preconditions.checkNotNull(funnel);
    }

    public void funnel(Iterable iterable, PrimitiveSink primitiveSink) {
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            this.elementFunnel.funnel(t2, primitiveSink);
        }
    }

    public String toString() {
        String string = String.valueOf(this.elementFunnel);
        return new StringBuilder(26 + String.valueOf(string).length()).append("Funnels.sequentialFunnel(").append(string).append(")").toString();
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Funnels$SequentialFunnel)) return false;
        Funnels$SequentialFunnel funnels$SequentialFunnel = (Funnels$SequentialFunnel)object;
        return this.elementFunnel.equals(funnels$SequentialFunnel.elementFunnel);
    }

    public int hashCode() {
        return Funnels$SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
    }
}

