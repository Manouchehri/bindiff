/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.IDataChangedListener;

public interface IDataProvider {
    public void addListener(IDataChangedListener var1);

    public byte[] getData();

    public byte[] getData(long var1, int var3);

    public int getDataLength();

    public boolean hasData(long var1, int var3);

    public boolean isEditable();

    public boolean keepTrying();

    public void removeListener(IDataChangedListener var1);

    public void setData(long var1, byte[] var3);
}

