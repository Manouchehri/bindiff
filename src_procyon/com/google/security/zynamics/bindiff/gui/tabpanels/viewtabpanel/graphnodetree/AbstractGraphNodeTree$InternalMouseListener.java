package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import javax.swing.*;
import com.google.security.zynamics.zylib.gui.jtree.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import javax.swing.tree.*;

class AbstractGraphNodeTree$InternalMouseListener extends MouseAdapter
{
    final /* synthetic */ AbstractGraphNodeTree this$0;
    
    private AbstractGraphNodeTree$InternalMouseListener(final AbstractGraphNodeTree this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        this.this$0.handleMouseEvent(mouseEvent);
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        this.this$0.handleMouseEvent(mouseEvent);
    }
}
