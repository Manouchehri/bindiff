/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.dndtree;

import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class DNDTree
extends JTree {
    private static final long serialVersionUID = -2933192344665054732L;
    Insets autoscrollInsets = new Insets(20, 20, 20, 20);

    public DNDTree() {
        this.setAutoscrolls(true);
        this.setRootVisible(false);
        this.setShowsRootHandles(false);
        this.getSelectionModel().setSelectionMode(1);
        this.setEditable(false);
    }

    public static DefaultMutableTreeNode makeDeepCopy(DefaultMutableTreeNode defaultMutableTreeNode) {
        DefaultMutableTreeNode defaultMutableTreeNode2 = new DefaultMutableTreeNode(defaultMutableTreeNode.getUserObject());
        Enumeration enumeration = defaultMutableTreeNode.children();
        while (enumeration.hasMoreElements()) {
            defaultMutableTreeNode2.add(DNDTree.makeDeepCopy((DefaultMutableTreeNode)enumeration.nextElement()));
        }
        return defaultMutableTreeNode2;
    }

    public void autoscroll(Point point) {
        Insets insets = this.getAutoscrollInsets();
        Rectangle rectangle = this.getVisibleRect();
        Rectangle rectangle2 = new Rectangle(rectangle.x + insets.left, rectangle.y + insets.top, rectangle.width - (insets.left + insets.right), rectangle.height - (insets.top + insets.bottom));
        if (rectangle2.contains(point)) return;
        Rectangle rectangle3 = new Rectangle(point.x - insets.left, point.y - insets.top, insets.left + insets.right, insets.top + insets.bottom);
        this.scrollRectToVisible(rectangle3);
    }

    public Insets getAutoscrollInsets() {
        return this.autoscrollInsets;
    }
}

