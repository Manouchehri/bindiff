package com.google.security.zynamics.zylib.gui.jtree;

import javax.swing.tree.*;
import javax.swing.*;
import com.google.common.base.*;

public class IconNode extends DefaultMutableTreeNode
{
    private static final long serialVersionUID = -7079996631145030853L;
    protected Icon icon;
    protected String iconName;
    
    public IconNode() {
        this(null);
    }
    
    public IconNode(final Object o) {
        this(o, true, null);
    }
    
    public IconNode(final Object o, final boolean b, final Icon icon) {
        super(o, b);
        this.icon = null;
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
        final String string = this.userObject.toString();
        int lastIndex = string.lastIndexOf(".");
        if (lastIndex != -1) {
            return string.substring(++lastIndex);
        }
        return null;
    }
    
    public void setIcon(final Icon icon) {
        this.icon = (Icon)Preconditions.checkNotNull(icon, (Object)"Error: icon argument can not be null");
    }
    
    public void setIconName(final String s) {
        this.iconName = (String)Preconditions.checkNotNull(s, (Object)"Error: name argument can not be null");
    }
}
