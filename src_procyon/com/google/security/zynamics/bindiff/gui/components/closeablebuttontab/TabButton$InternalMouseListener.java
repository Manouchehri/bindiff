package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class TabButton$InternalMouseListener extends MouseAdapter
{
    final /* synthetic */ TabButton this$0;
    
    private TabButton$InternalMouseListener(final TabButton this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void mouseEntered(final MouseEvent mouseEvent) {
        final Component component = mouseEvent.getComponent();
        if (component instanceof AbstractButton) {
            ((AbstractButton)component).setBorderPainted(false);
        }
    }
    
    @Override
    public void mouseExited(final MouseEvent mouseEvent) {
        final Component component = mouseEvent.getComponent();
        if (component instanceof AbstractButton) {
            ((AbstractButton)component).setBorderPainted(false);
        }
    }
}
