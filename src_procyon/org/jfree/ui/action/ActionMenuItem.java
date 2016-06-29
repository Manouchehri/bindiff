package org.jfree.ui.action;

import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class ActionMenuItem extends JMenuItem
{
    private Action action;
    private ActionMenuItem$ActionEnablePropertyChangeHandler propertyChangeHandler;
    
    public ActionMenuItem() {
    }
    
    public ActionMenuItem(final Icon icon) {
        super(icon);
    }
    
    public ActionMenuItem(final String s) {
        super(s);
    }
    
    public ActionMenuItem(final String s, final Icon icon) {
        super(s, icon);
    }
    
    public ActionMenuItem(final String s, final int n) {
        super(s, n);
    }
    
    public ActionMenuItem(final Action action) {
        this.setAction(action);
    }
    
    public Action getAction() {
        return this.action;
    }
    
    private ActionMenuItem$ActionEnablePropertyChangeHandler getPropertyChangeHandler() {
        if (this.propertyChangeHandler == null) {
            this.propertyChangeHandler = new ActionMenuItem$ActionEnablePropertyChangeHandler(this);
        }
        return this.propertyChangeHandler;
    }
    
    public void setEnabled(final boolean b) {
        super.setEnabled(b);
        if (this.getAction() != null) {
            this.getAction().setEnabled(b);
        }
    }
    
    public void setAction(final Action action) {
        final Action action2 = this.getAction();
        if (action2 != null) {
            this.removeActionListener(action2);
            action2.removePropertyChangeListener(this.getPropertyChangeHandler());
            this.setAccelerator(null);
        }
        this.action = action;
        if (this.action != null) {
            this.addActionListener(action);
            action.addPropertyChangeListener(this.getPropertyChangeHandler());
            this.setText((String)action.getValue("Name"));
            this.setToolTipText((String)action.getValue("ShortDescription"));
            this.setIcon((Icon)action.getValue("SmallIcon"));
            this.setEnabled(this.action.isEnabled());
            final Object value = action.getValue("MnemonicKey");
            if (value != null) {
                if (value instanceof Character) {
                    this.setMnemonic((char)value);
                }
                else if (value instanceof Integer) {
                    this.setMnemonic((int)value);
                }
            }
            else {
                this.setMnemonic(0);
            }
            final Object value2 = action.getValue("AcceleratorKey");
            if (value2 instanceof KeyStroke) {
                this.setAccelerator((KeyStroke)value2);
            }
        }
    }
}
