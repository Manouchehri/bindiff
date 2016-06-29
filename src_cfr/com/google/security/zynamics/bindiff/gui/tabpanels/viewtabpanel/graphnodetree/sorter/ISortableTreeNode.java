/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.zylib.disassembly.IAddress;

public interface ISortableTreeNode {
    public IAddress getAddress();

    public IAddress getAddress(ESide var1);

    public String getFunctionName();

    public EFunctionType getFunctionType();

    public EMatchState getMatchState();

    public EMatchType getMatchType();

    public boolean isSelected();

    public boolean isVisible();
}

