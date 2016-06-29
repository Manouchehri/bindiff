/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import java.awt.Color;

public class CStyleRunData {
    private final int m_start;
    private final int m_length;
    private final Color m_color;
    private final IZyEditableObject m_lineObject;
    private Object m_object;

    public CStyleRunData(int n2, int n3, Color color) {
        this(n2, n3, color, null);
    }

    public CStyleRunData(int n2, int n3, Color color, IZyEditableObject iZyEditableObject) {
        Preconditions.checkArgument(n3 != 0, "Error: Invalid style run length");
        this.m_start = n2;
        this.m_length = n3;
        this.m_color = color;
        this.m_lineObject = iZyEditableObject;
    }

    public CStyleRunData(int n2, int n3, Color color, Object object) {
        this(n2, n3, color, null);
        this.m_object = object;
    }

    public Color getColor() {
        return this.m_color;
    }

    public int getEnd() {
        return this.m_start + this.m_length;
    }

    public int getLength() {
        return this.m_length;
    }

    public IZyEditableObject getLineObject() {
        return this.m_lineObject;
    }

    public Object getObject() {
        return this.m_object;
    }

    public int getStart() {
        return this.m_start;
    }
}

