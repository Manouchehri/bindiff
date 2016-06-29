package org.jfree.ui.action;

import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class ActionRadioButton extends JRadioButton
{
    private Action action;
    private ActionRadioButton$ActionEnablePropertyChangeHandler propertyChangeHandler;
    
    public ActionRadioButton() {
    }
    
    public ActionRadioButton(final String s) {
        super(s);
    }
    
    public ActionRadioButton(final String s, final Icon icon) {
        super(s, icon);
    }
    
    public ActionRadioButton(final Icon icon) {
        super(icon);
    }
    
    public ActionRadioButton(final Action action) {
        this.setAction(action);
    }
    
    public Action getAction() {
        return this.action;
    }
    
    private ActionRadioButton$ActionEnablePropertyChangeHandler getPropertyChangeHandler() {
        if (this.propertyChangeHandler == null) {
            this.propertyChangeHandler = new ActionRadioButton$ActionEnablePropertyChangeHandler(this, null);
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
            if (value instanceof KeyStroke && value != null) {
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
            if (value3 instanceof KeyStroke && value3 != null) {
                this.registerKeyboardAction(action, (KeyStroke)value3, 2);
            }
        }
    }
}
