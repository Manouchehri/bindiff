/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class AbstractGraphNodeTree$InternalMouseListener
extends MouseAdapter {
    final /* synthetic */ AbstractGraphNodeTree this$0;

    private AbstractGraphNodeTree$InternalMouseListener(AbstractGraphNodeTree abstractGraphNodeTree) {
        this.this$0 = abstractGraphNodeTree;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        AbstractGraphNodeTree.access$300(this.this$0, mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        AbstractGraphNodeTree.access$300(this.this$0, mouseEvent);
    }

    /* synthetic */ AbstractGraphNodeTree$InternalMouseListener(AbstractGraphNodeTree abstractGraphNodeTree, AbstractGraphNodeTree$1 abstractGraphNodeTree$1) {
        this(abstractGraphNodeTree);
    }
}

