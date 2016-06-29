/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import javax.swing.JMenu;

public interface RootEditor {
    public void setActive(boolean var1);

    public boolean isActive();

    public String getEditorName();

    public JMenu[] getMenus();

    public JComponent getToolbar();

    public JComponent getMainPanel();

    public boolean isEnabled();

    public void addPropertyChangeListener(String var1, PropertyChangeListener var2);

    public void removePropertyChangeListener(String var1, PropertyChangeListener var2);

    public void addPropertyChangeListener(PropertyChangeListener var1);

    public void removePropertyChangeListener(PropertyChangeListener var1);
}

