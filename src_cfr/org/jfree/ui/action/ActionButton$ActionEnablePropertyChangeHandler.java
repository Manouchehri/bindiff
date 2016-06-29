/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.action;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.KeyStroke;
import org.jfree.ui.action.ActionButton;
import org.jfree.util.Log;

class ActionButton$ActionEnablePropertyChangeHandler
implements PropertyChangeListener {
    private final ActionButton this$0;

    public ActionButton$ActionEnablePropertyChangeHandler(ActionButton actionButton) {
        this.this$0 = actionButton;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        try {
            if (propertyChangeEvent.getPropertyName().equals("enabled")) {
                this.this$0.setEnabled(this.this$0.getAction().isEnabled());
            } else if (propertyChangeEvent.getPropertyName().equals("SmallIcon")) {
                this.this$0.setIcon((Icon)this.this$0.getAction().getValue("SmallIcon"));
            } else if (propertyChangeEvent.getPropertyName().equals("Name")) {
                this.this$0.setText((String)this.this$0.getAction().getValue("Name"));
            } else if (propertyChangeEvent.getPropertyName().equals("ShortDescription")) {
                this.this$0.setToolTipText((String)this.this$0.getAction().getValue("ShortDescription"));
            }
            Action action = this.this$0.getAction();
            if (propertyChangeEvent.getPropertyName().equals("AcceleratorKey")) {
                Object object;
                KeyStroke keyStroke = (KeyStroke)propertyChangeEvent.getOldValue();
                if (keyStroke != null) {
                    this.this$0.unregisterKeyboardAction(keyStroke);
                }
                if (!((object = action.getValue("AcceleratorKey")) instanceof KeyStroke)) return;
                KeyStroke keyStroke2 = (KeyStroke)object;
                this.this$0.registerKeyboardAction(action, keyStroke2, 2);
                return;
            }
            if (!propertyChangeEvent.getPropertyName().equals("MnemonicKey")) return;
            Object object = action.getValue("MnemonicKey");
            if (object == null) return;
            if (object instanceof Character) {
                Character c2 = (Character)object;
                this.this$0.setMnemonic(c2.charValue());
                return;
            }
            if (!(object instanceof Integer)) return;
            Integer n2 = (Integer)object;
            this.this$0.setMnemonic(n2);
            return;
        }
        catch (Exception var2_3) {
            Log.warn("Error on PropertyChange in ActionButton: ", var2_3);
        }
    }
}

