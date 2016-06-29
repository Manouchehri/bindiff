/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Equivalence;
import com.google.common.base.Equivalence$1;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

public final class Equivalence$Wrapper
implements Serializable {
    private final Equivalence equivalence;
    @Nullable
    private final Object reference;
    private static final long serialVersionUID = 0;

    private Equivalence$Wrapper(Equivalence equivalence, @Nullable Object object) {
        this.equivalence = (Equivalence)Preconditions.checkNotNull(equivalence);
        this.reference = object;
    }

    @Nullable
    public Object get() {
        return this.reference;
    }

    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Equivalence$Wrapper)) return false;
        Equivalence$Wrapper equivalence$Wrapper = (Equivalence$Wrapper)object;
        if (!this.equivalence.equals(equivalence$Wrapper.equivalence)) return false;
        Equivalence equivalence = this.equivalence;
        return equivalence.equivalent(this.reference, equivalence$Wrapper.reference);
    }

    public int hashCode() {
        return this.equivalence.hash(this.reference);
    }

    public String toString() {
        String string = String.valueOf(this.equivalence);
        String string2 = String.valueOf(this.reference);
        return new StringBuilder(7 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(".wrap(").append(string2).append(")").toString();
    }

    /* synthetic */ Equivalence$Wrapper(Equivalence equivalence, Object object, Equivalence$1 equivalence$1) {
        this(equivalence, object);
    }
}

