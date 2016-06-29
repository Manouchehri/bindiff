package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

public class SelectionHistoryTreeNodeWrapper
{
    private final SelectionSnapshot operation;
    private final int count;
    
    public SelectionHistoryTreeNodeWrapper(final SelectionSnapshot operation, final int count) {
        this.operation = operation;
        this.count = count;
    }
    
    @Override
    public String toString() {
        return String.format("%d-%s (%d)", this.count, this.operation.getDescription(), this.operation.getSelection().size());
    }
}
