/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.security.zynamics.zylib.gui.JStackView.IStackModelListener;

public interface IStackModel {
    public void addListener(IStackModelListener var1);

    public String getElement(long var1);

    public int getNumberOfEntries();

    public long getStackPointer();

    public long getStartAddress();

    public boolean hasData(long var1, long var3);

    public boolean keepTrying();
}

