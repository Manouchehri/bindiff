/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.action;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import org.jfree.ui.action.ActionMenuItem$ActionEnablePropertyChangeHandler;

public class ActionMenuItem
extends JMenuItem {
    private Action action;
    private ActionMenuItem$ActionEnablePropertyChangeHandler propertyChangeHandler;

    public ActionMenuItem() {
    }

    public ActionMenuItem(Icon icon) {
        super(icon);
    }

    public ActionMenuItem(String string) {
        super(string);
    }

    public ActionMenuItem(String string, Icon icon) {
        super(string, icon);
    }

    public ActionMenuItem(String string, int n2) {
        super(string, n2);
    }

    public ActionMenuItem(Action action) {
        this.setAction(action);
    }

    @Override
    public Action getAction() {
        return this.action;
    }

    private ActionMenuItem$ActionEnablePropertyChangeHandler getPropertyChangeHandler() {
        if (this.propertyChangeHandler != null) return this.propertyChangeHandler;
        this.propertyChangeHandler = new ActionMenuItem$ActionEnablePropertyChangeHandler(this);
        return this.propertyChangeHandler;
    }

    @Override
    public void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        if (this.getAction() == null) return;
        this.getAction().setEnabled(bl2);
    }

    @Override
    public void setAction(Action action) {
        Action action2 = this.getAction();
        if (action2 != null) {
            this.removeActionListener(action2);
            action2.removePropertyChangeListener(this.getPropertyChangeHandler());
            this.setAccelerator(null);
        }
        this.action = action;
        if (this.action == null) return;
        this.addActionListener(action);
        action.addPropertyChangeListener(this.getPropertyChangeHandler());
        this.setText((String)action.getValue("Name"));
        this.setToolTipText((String)action.getValue("ShortDescription"));
        this.setIcon((Icon)action.getValue("SmallIcon"));
        this.setEnabled(this.action.isEnabled());
        Object object = action.getValue("MnemonicKey");
        if (object != null) {
            if (object instanceof Character) {
                Character c2 = (Character)object;
                this.setMnemonic(c2.charValue());
            } else if (object instanceof Integer) {
                Integer n2 = (Integer)object;
                this.setMnemonic(n2);
            }
        } else {
            this.setMnemonic(0);
        }
        object = action.getValue("AcceleratorKey");
        if (!(object instanceof KeyStroke)) return;
        this.setAccelerator((KeyStroke)object);
    }
}

