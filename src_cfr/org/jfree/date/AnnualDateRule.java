/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.date;

import org.jfree.date.SerialDate;

public abstract class AnnualDateRule
implements Cloneable {
    protected AnnualDateRule() {
    }

    public abstract SerialDate getDate(int var1);

    public Object clone() {
        return super.clone();
    }
}

