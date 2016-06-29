/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

public class ZyLineContent$ObjectWrapper {
    private final int start;
    private final int length;
    private final Object object;

    public ZyLineContent$ObjectWrapper(int n2, int n3, Object object) {
        this.start = n2;
        this.length = n3;
        this.object = object;
    }

    public int getLength() {
        return this.length;
    }

    public Object getObject() {
        return this.object;
    }

    public int getStart() {
        return this.start;
    }
}

