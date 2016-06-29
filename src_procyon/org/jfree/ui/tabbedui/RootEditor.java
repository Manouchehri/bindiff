package org.jfree.ui.tabbedui;

import javax.swing.*;
import java.beans.*;

public interface RootEditor
{
    void setActive(final boolean p0);
    
    boolean isActive();
    
    String getEditorName();
    
    JMenu[] getMenus();
    
    JComponent getToolbar();
    
    JComponent getMainPanel();
    
    boolean isEnabled();
    
    void addPropertyChangeListener(final String p0, final PropertyChangeListener p1);
    
    void removePropertyChangeListener(final String p0, final PropertyChangeListener p1);
    
    void addPropertyChangeListener(final PropertyChangeListener p0);
    
    void removePropertyChangeListener(final PropertyChangeListener p0);
}
