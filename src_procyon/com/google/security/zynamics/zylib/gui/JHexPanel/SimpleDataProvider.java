package com.google.security.zynamics.zylib.gui.JHexPanel;

import java.util.*;

public class SimpleDataProvider implements IDataProvider
{
    private final byte[] m_data;
    
    public SimpleDataProvider(final byte[] data) {
        this.m_data = data;
    }
    
    @Override
    public void addListener(final IDataChangedListener dataChangedListener) {
    }
    
    @Override
    public byte[] getData() {
        return this.getData(0L, this.getDataLength());
    }
    
    @Override
    public byte[] getData(final long n, final int n2) {
        return Arrays.copyOfRange(this.m_data, (int)n, (int)(n + n2));
    }
    
    @Override
    public int getDataLength() {
        return this.m_data.length;
    }
    
    public long getOffset() {
        return 0L;
    }
    
    @Override
    public boolean hasData(final long n, final int n2) {
        return true;
    }
    
    @Override
    public boolean isEditable() {
        return true;
    }
    
    @Override
    public boolean keepTrying() {
        return true;
    }
    
    @Override
    public void removeListener(final IDataChangedListener dataChangedListener) {
    }
    
    @Override
    public void setData(final long n, final byte[] array) {
        System.arraycopy(array, 0, this.m_data, (int)n, array.length);
    }
}
