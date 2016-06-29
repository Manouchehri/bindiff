package com.google.security.zynamics.zylib.gui.JStackView;

public interface IStackModel
{
    void addListener(final IStackModelListener p0);
    
    String getElement(final long p0);
    
    int getNumberOfEntries();
    
    long getStackPointer();
    
    long getStartAddress();
    
    boolean hasData(final long p0, final long p1);
    
    boolean keepTrying();
}
