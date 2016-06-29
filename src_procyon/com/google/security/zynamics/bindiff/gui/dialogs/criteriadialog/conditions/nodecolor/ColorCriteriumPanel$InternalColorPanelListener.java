package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import com.google.security.zynamics.zylib.gui.ColorPanel.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.util.*;

class ColorCriteriumPanel$InternalColorPanelListener extends MouseAdapter implements IColorPanelListener
{
    final /* synthetic */ ColorCriteriumPanel this$0;
    
    private ColorCriteriumPanel$InternalColorPanelListener(final ColorCriteriumPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void changedColor(final ColorPanel colorPanel) {
        this.this$0.colorCriterium.update();
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 1) {
            final Color color = ((ColorPanel)mouseEvent.getSource()).getColor();
            if (color != null) {
                this.this$0.selectedColorPanel.setColor(color);
            }
        }
    }
}
