package com.google.security.zynamics.zylib.gui.zygraph.realizers;

public class ZyLineContent$ObjectWrapper
{
    private final int start;
    private final int length;
    private final Object object;
    
    public ZyLineContent$ObjectWrapper(final int start, final int length, final Object object) {
        this.start = start;
        this.length = length;
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
