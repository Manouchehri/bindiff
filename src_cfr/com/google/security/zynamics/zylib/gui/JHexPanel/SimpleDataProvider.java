/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.IDataChangedListener;
import com.google.security.zynamics.zylib.gui.JHexPanel.IDataProvider;
import java.util.Arrays;

public class SimpleDataProvider
implements IDataProvider {
    private final byte[] m_data;

    public SimpleDataProvider(byte[] arrby) {
        this.m_data = arrby;
    }

    @Override
    public void addListener(IDataChangedListener iDataChangedListener) {
    }

    @Override
    public byte[] getData() {
        return this.getData(0, this.getDataLength());
    }

    @Override
    public byte[] getData(long l2, int n2) {
        return Arrays.copyOfRange(this.m_data, (int)l2, (int)(l2 + (long)n2));
    }

    @Override
    public int getDataLength() {
        return this.m_data.length;
    }

    public long getOffset() {
        return 0;
    }

    @Override
    public boolean hasData(long l2, int n2) {
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
    public void removeListener(IDataChangedListener iDataChangedListener) {
    }

    @Override
    public void setData(long l2, byte[] arrby) {
        System.arraycopy(arrby, 0, this.m_data, (int)l2, arrby.length);
    }
}

