package com.google.security.zynamics.zylib.gui.JHexPanel;

public interface IDataProvider
{
    void addListener(final IDataChangedListener p0);
    
    byte[] getData();
    
    byte[] getData(final long p0, final int p1);
    
    int getDataLength();
    
    boolean hasData(final long p0, final int p1);
    
    boolean isEditable();
    
    boolean keepTrying();
    
    void removeListener(final IDataChangedListener p0);
    
    void setData(final long p0, final byte[] p1);
}
