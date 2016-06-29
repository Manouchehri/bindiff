package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import java.awt.*;
import com.google.common.base.*;

public class CStyleRunData
{
    private final int m_start;
    private final int m_length;
    private final Color m_color;
    private final IZyEditableObject m_lineObject;
    private Object m_object;
    
    public CStyleRunData(final int n, final int n2, final Color color) {
        this(n, n2, color, null);
    }
    
    public CStyleRunData(final int start, final int length, final Color color, final IZyEditableObject lineObject) {
        Preconditions.checkArgument(length != 0, (Object)"Error: Invalid style run length");
        this.m_start = start;
        this.m_length = length;
        this.m_color = color;
        this.m_lineObject = lineObject;
    }
    
    public CStyleRunData(final int n, final int n2, final Color color, final Object object) {
        this(n, n2, color, null);
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
