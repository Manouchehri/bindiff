package org.jfree.ui.action;

import java.beans.*;
import org.jfree.util.*;
import javax.swing.*;

class ActionMenuItem$ActionEnablePropertyChangeHandler implements PropertyChangeListener
{
    private final ActionMenuItem this$0;
    
    public ActionMenuItem$ActionEnablePropertyChangeHandler(final ActionMenuItem this$0) {
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
                this.this$0.setAccelerator((KeyStroke)action.getValue("AcceleratorKey"));
            }
            else if (propertyChangeEvent.getPropertyName().equals("MnemonicKey")) {
                final Object value = action.getValue("MnemonicKey");
                if (value != null) {
                    if (value instanceof Character) {
                        this.this$0.setMnemonic((char)value);
                    }
                    else if (value instanceof Integer) {
                        this.this$0.setMnemonic((int)value);
                    }
                }
                else {
                    this.this$0.setMnemonic(0);
                }
            }
        }
        catch (Exception ex) {
            Log.warn("Error on PropertyChange in ActionButton: ", ex);
        }
    }
}
