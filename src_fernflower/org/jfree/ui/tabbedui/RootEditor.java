package org.jfree.ui.tabbedui;

import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import javax.swing.JMenu;

public interface RootEditor {
   void setActive(boolean var1);

   boolean isActive();

   String getEditorName();

   JMenu[] getMenus();

   JComponent getToolbar();

   JComponent getMainPanel();

   boolean isEnabled();

   void addPropertyChangeListener(String var1, PropertyChangeListener var2);

   void removePropertyChangeListener(String var1, PropertyChangeListener var2);

   void addPropertyChangeListener(PropertyChangeListener var1);

   void removePropertyChangeListener(PropertyChangeListener var1);
}
