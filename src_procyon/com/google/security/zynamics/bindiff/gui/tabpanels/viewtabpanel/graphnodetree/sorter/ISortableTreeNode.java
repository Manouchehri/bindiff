package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter;

import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;

public interface ISortableTreeNode
{
    IAddress getAddress();
    
    IAddress getAddress(final ESide p0);
    
    String getFunctionName();
    
    EFunctionType getFunctionType();
    
    EMatchState getMatchState();
    
    EMatchType getMatchType();
    
    boolean isSelected();
    
    boolean isVisible();
}
