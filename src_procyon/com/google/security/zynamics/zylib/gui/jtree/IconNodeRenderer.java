package com.google.security.zynamics.zylib.gui.jtree;

import javax.swing.tree.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class IconNodeRenderer extends DefaultTreeCellRenderer
{
    @Override
    public Component getTreeCellRendererComponent(final JTree tree, final Object o, final boolean b, final boolean b2, final boolean b3, final int n, final boolean b4) {
        super.getTreeCellRendererComponent(tree, o, b, b2, b3, n, b4);
        if (!(o instanceof IconNode)) {
            return this;
        }
        final Icon icon = ((IconNode)o).getIcon();
        if (icon == null) {
            final Hashtable hashtable = (Hashtable)tree.getClientProperty("JTree.icons");
            final String iconName = ((IconNode)o).getIconName();
            if (hashtable != null && iconName != null) {
                final Icon icon2 = hashtable.get(iconName);
                if (icon2 != null) {
                    this.setIcon(icon2);
                }
            }
        }
        else {
            this.setIcon(icon);
        }
        return this;
    }
}
