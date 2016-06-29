/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.jtree;

import com.google.common.base.Preconditions;
import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

public class IconNode
extends DefaultMutableTreeNode {
    private static final long serialVersionUID = -7079996631145030853L;
    protected Icon icon = null;
    protected String iconName;

    public IconNode() {
        this(null);
    }

    public IconNode(Object object) {
        this(object, true, null);
    }

    public IconNode(Object object, boolean bl2, Icon icon) {
        super(object, bl2);
        this.icon = icon;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public String getIconName() {
        if (this.iconName != null) {
            return this.iconName;
        }
        if (this.userObject == null) {
            return null;
        }
        String string = this.userObject.toString();
        int n2 = string.lastIndexOf(".");
        if (n2 == -1) return null;
        return string.substring(++n2);
    }

    public void setIcon(Icon icon) {
        this.icon = (Icon)Preconditions.checkNotNull(icon, "Error: icon argument can not be null");
    }

    public void setIconName(String string) {
        this.iconName = (String)Preconditions.checkNotNull(string, "Error: name argument can not be null");
    }
}

