package org.jfree.ui.action;

import java.beans.*;
import java.awt.event.*;
import org.jfree.util.*;
import javax.swing.*;

class ActionRadioButton$ActionEnablePropertyChangeHandler implements PropertyChangeListener
{
    private final ActionRadioButton this$0;
    
    private ActionRadioButton$ActionEnablePropertyChangeHandler(final ActionRadioButton this$0) {
        this.this$0 = this$0;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        try {
            if (propertyChangeEvent.getPropertyName().equals("enabled")) {
                this.this$0.setEnabled(this.this$0.getAction().isEnabled());
            }
            else if (propertyChangeEvent.getPropertyName().equals("SmallIcon")) {
                this.this$0.setIcon((Icon)this.this$0.getAction().getValue("SmallIcon"));
            }
            else if (propertyChangeEvent.getPropertyName().equals("Name")) {
                this.this$0.setText((String)this.this$0.getAction().getValue("Name"));
            }
            else if (propertyChangeEvent.getPropertyName().equals("ShortDescription")) {
                this.this$0.setToolTipText((String)this.this$0.getAction().getValue("ShortDescription"));
            }
            final Action action = this.this$0.getAction();
            if (propertyChangeEvent.getPropertyName().equals("AcceleratorKey")) {
                final KeyStroke keyStroke = (KeyStroke)propertyChangeEvent.getOldValue();
                if (keyStroke != null) {
                    this.this$0.unregisterKeyboardAction(keyStroke);
                }
                final Object value = action.getValue("AcceleratorKey");
                if (value instanceof KeyStroke && value != null) {
                    this.this$0.registerKeyboardAction(action, (KeyStroke)value, 2);
                }
            }
            else if (propertyChangeEvent.getPropertyName().equals("MnemonicKey")) {
                final Object value2 = action.getValue("MnemonicKey");
                if (value2 != null) {
                    if (value2 instanceof Character) {
                        this.this$0.setMnemonic((char)value2);
                    }
                    else if (value2 instanceof Integer) {
                        this.this$0.setMnemonic((int)value2);
                    }
                }
            }
        }
        catch (Exception ex) {
            Log.warn("Error on PropertyChange in ActionButton: ", ex);
        }
    }
    
    ActionRadioButton$ActionEnablePropertyChangeHandler(final ActionRadioButton actionRadioButton, final ActionRadioButton$1 actionRadioButton$1) {
        this(actionRadioButton);
    }
}
