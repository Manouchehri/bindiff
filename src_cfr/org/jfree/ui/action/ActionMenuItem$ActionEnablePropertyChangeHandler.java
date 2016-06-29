/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.action;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.KeyStroke;
import org.jfree.ui.action.ActionMenuItem;
import org.jfree.util.Log;

class ActionMenuItem$ActionEnablePropertyChangeHandler
implements PropertyChangeListener {
    private final ActionMenuItem this$0;

    public ActionMenuItem$ActionEnablePropertyChangeHandler(ActionMenuItem actionMenuItem) {
        this.this$0 = actionMenuItem;
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
                this.this$0.setAccelerator((KeyStroke)action.getValue("AcceleratorKey"));
                return;
            }
            if (!propertyChangeEvent.getPropertyName().equals("MnemonicKey")) return;
            Object object = action.getValue("MnemonicKey");
            if (object == null) {
                this.this$0.setMnemonic(0);
                return;
            }
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

