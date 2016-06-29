package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import java.util.*;
import javax.swing.tree.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import com.google.security.zynamics.zylib.gui.jtree.*;
import java.awt.*;
import javax.swing.*;

class JCriteriumTree$InternalMouseListener extends MouseAdapter
{
    final /* synthetic */ JCriteriumTree this$0;
    
    private JCriteriumTree$InternalMouseListener(final JCriteriumTree this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        this.this$0.currentCriteriumPath = this.this$0.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
        if (mouseEvent.isPopupTrigger()) {
            this.this$0.showPopupMenu(mouseEvent);
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        this.this$0.currentCriteriumPath = this.this$0.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
        if (mouseEvent.isPopupTrigger()) {
            this.this$0.showPopupMenu(mouseEvent);
        }
    }
}
