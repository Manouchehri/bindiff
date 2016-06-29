package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.zylib.general.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.zylib.gui.comboboxes.memorybox.*;
import java.awt.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.graph.searchers.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.resources.*;

final class GraphSearchField$InternalMouseListener extends MouseAdapter
{
    private final JPopupMenu popupMenu;
    final /* synthetic */ GraphSearchField this$0;
    
    private GraphSearchField$InternalMouseListener(final GraphSearchField this$0) {
        this.this$0 = this$0;
        this.popupMenu = this.this$0.createPopup();
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        if (mouseEvent.getX() >= 0 && mouseEvent.getX() <= 38 && !this.popupMenu.isVisible()) {
            this.popupMenu.show(this.this$0, this.this$0.getX() - 1, this.this$0.getY() + this.this$0.getHeight() - 2);
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        if (this.popupMenu.isVisible() && mouseEvent.getX() > 38 && mouseEvent.getSource() instanceof JComponent && mouseEvent.getY() >= 0 && mouseEvent.getY() <= ((JComponent)mouseEvent.getSource()).getHeight()) {
            this.popupMenu.setVisible(false);
        }
    }
}
