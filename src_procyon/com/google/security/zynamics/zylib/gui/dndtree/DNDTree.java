package com.google.security.zynamics.zylib.gui.dndtree;

import javax.swing.*;
import javax.swing.tree.*;
import java.util.*;
import java.awt.*;

public class DNDTree extends JTree
{
    private static final long serialVersionUID = -2933192344665054732L;
    Insets autoscrollInsets;
    
    public DNDTree() {
        this.autoscrollInsets = new Insets(20, 20, 20, 20);
        this.setAutoscrolls(true);
        this.setRootVisible(false);
        this.setShowsRootHandles(false);
        this.getSelectionModel().setSelectionMode(1);
        this.setEditable(false);
    }
    
    public static DefaultMutableTreeNode makeDeepCopy(final DefaultMutableTreeNode defaultMutableTreeNode) {
        final DefaultMutableTreeNode defaultMutableTreeNode2 = new DefaultMutableTreeNode(defaultMutableTreeNode.getUserObject());
        final Enumeration children = defaultMutableTreeNode.children();
        while (children.hasMoreElements()) {
            defaultMutableTreeNode2.add(makeDeepCopy(children.nextElement()));
        }
        return defaultMutableTreeNode2;
    }
    
    public void autoscroll(final Point point) {
        final Insets autoscrollInsets = this.getAutoscrollInsets();
        final Rectangle visibleRect = this.getVisibleRect();
        if (!new Rectangle(visibleRect.x + autoscrollInsets.left, visibleRect.y + autoscrollInsets.top, visibleRect.width - (autoscrollInsets.left + autoscrollInsets.right), visibleRect.height - (autoscrollInsets.top + autoscrollInsets.bottom)).contains(point)) {
            this.scrollRectToVisible(new Rectangle(point.x - autoscrollInsets.left, point.y - autoscrollInsets.top, autoscrollInsets.left + autoscrollInsets.right, autoscrollInsets.top + autoscrollInsets.bottom));
        }
    }
    
    public Insets getAutoscrollInsets() {
        return this.autoscrollInsets;
    }
}
