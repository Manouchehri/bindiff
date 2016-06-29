package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

public interface ISelectionHistoryListener
{
    void finishedRedo();
    
    void finishedUndo();
    
    void snapshotAdded(final SelectionSnapshot p0);
    
    void snapshotRemoved();
    
    void startedRedo();
    
    void startedUndo();
}
