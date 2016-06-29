/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import org.jfree.util.AbstractObjectList;

public class BooleanList
extends AbstractObjectList {
    private static final long serialVersionUID = -8543170333219422042L;

    public Boolean getBoolean(int n2) {
        return (Boolean)this.get(n2);
    }

    public void setBoolean(int n2, Boolean bl2) {
        this.set(n2, bl2);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BooleanList)) return false;
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

