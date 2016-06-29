/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.jtree;

import com.google.security.zynamics.zylib.gui.jtree.IconNode;
import java.awt.Component;
import java.util.Hashtable;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class IconNodeRenderer
extends DefaultTreeCellRenderer {
    @Override
    public Component getTreeCellRendererComponent(JTree jTree, Object object, boolean bl2, boolean bl3, boolean bl4, int n2, boolean bl5) {
        super.getTreeCellRendererComponent(jTree, object, bl2, bl3, bl4, n2, bl5);
        if (!(object instanceof IconNode)) {
            return this;
        }
        Icon icon = ((IconNode)object).getIcon();
        if (icon == null) {
            Hashtable hashtable = (Hashtable)jTree.getClientProperty("JTree.icons");
            String string = ((IconNode)object).getIconName();
            if (hashtable == null) return this;
            if (string == null) return this;
            icon = (Icon)hashtable.get(string);
            if (icon == null) return this;
            this.setIcon(icon);
            return this;
        }
        this.setIcon(icon);
        return this;
    }
}

