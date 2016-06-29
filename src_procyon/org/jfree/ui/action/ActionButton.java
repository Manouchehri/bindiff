package org.jfree.ui.action;

import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class ActionButton extends JButton
{
    private Action action;
    private ActionButton$ActionEnablePropertyChangeHandler propertyChangeHandler;
    
    public ActionButton() {
    }
    
    public ActionButton(final String s) {
        super(s);
    }
    
    public ActionButton(final String s, final Icon icon) {
        super(s, icon);
    }
    
    public ActionButton(final Icon icon) {
        super(icon);
    }
    
    public ActionButton(final Action action) {
        this.setAction(action);
    }
    
    public Action getAction() {
        return this.action;
    }
    
    private ActionButton$ActionEnablePropertyChangeHandler getPropertyChangeHandler() {
        if (this.propertyChangeHandler == null) {
            this.propertyChangeHandler = new ActionButton$ActionEnablePropertyChangeHandler(this);
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
            final Object value = action2.getValue("AcceleratorKey");
            if (value instanceof KeyStroke) {
                this.unregisterKeyboardAction((KeyStroke)value);
            }
        }
        this.action = action;
        if (this.action != null) {
            this.addActionListener(action);
            action.addPropertyChangeListener(this.getPropertyChangeHandler());
            this.setText((String)action.getValue("Name"));
            this.setToolTipText((String)action.getValue("ShortDescription"));
            this.setIcon((Icon)action.getValue("SmallIcon"));
            this.setEnabled(this.action.isEnabled());
            final Object value2 = action.getValue("MnemonicKey");
            if (value2 != null) {
                if (value2 instanceof Character) {
                    this.setMnemonic((char)value2);
                }
                else if (value2 instanceof Integer) {
                    this.setMnemonic((int)value2);
                }
            }
            final Object value3 = action.getValue("AcceleratorKey");
            if (value3 instanceof KeyStroke) {
                this.registerKeyboardAction(action, (KeyStroke)value3, 2);
            }
        }
    }
}
