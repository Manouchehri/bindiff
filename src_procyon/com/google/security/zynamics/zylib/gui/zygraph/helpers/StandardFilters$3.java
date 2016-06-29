package com.google.security.zynamics.zylib.gui.zygraph.helpers;

final class StandardFilters$3 implements INodeFilter
{
    public boolean qualifies(final ISelectableNode selectableNode) {
        return selectableNode.isSelected();
    }
}
