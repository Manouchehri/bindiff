/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.action;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;
import org.jfree.ui.action.ActionRadioButton$1;
import org.jfree.ui.action.ActionRadioButton$ActionEnablePropertyChangeHandler;

public class ActionRadioButton
extends JRadioButton {
    private Action action;
    private ActionRadioButton$ActionEnablePropertyChangeHandler propertyChangeHandler;

    public ActionRadioButton() {
    }

    public ActionRadioButton(String string) {
        super(string);
    }

    public ActionRadioButton(String string, Icon icon) {
        super(string, icon);
    }

    public ActionRadioButton(Icon icon) {
        super(icon);
    }

    public ActionRadioButton(Action action) {
        this.setAction(action);
    }

    @Override
    public Action getAction() {
        return this.action;
    }

    private ActionRadioButton$ActionEnablePropertyChangeHandler getPropertyChangeHandler() {
        if (this.propertyChangeHandler != null) return this.propertyChangeHandler;
        this.propertyChangeHandler = new ActionRadioButton$ActionEnablePropertyChangeHandler(this, null);
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
        Object object;
        Action action2 = this.getAction();
        if (action2 != null) {
            this.removeActionListener(action2);
            action2.removePropertyChangeListener(this.getPropertyChangeHandler());
            object = action2.getValue("AcceleratorKey");
            if (object instanceof KeyStroke && object != null) {
                KeyStroke keyStroke = (KeyStroke)object;
                this.unregisterKeyboardAction(keyStroke);
            }
        }
        this.action = action;
        if (this.action == null) return;
        this.addActionListener(action);
        action.addPropertyChangeListener(this.getPropertyChangeHandler());
        this.setText((String)action.getValue("Name"));
        this.setToolTipText((String)action.getValue("ShortDescription"));
        this.setIcon((Icon)action.getValue("SmallIcon"));
        this.setEnabled(this.action.isEnabled());
        object = action.getValue("MnemonicKey");
        if (object != null) {
            if (object instanceof Character) {
                Character c2 = (Character)object;
                this.setMnemonic(c2.charValue());
            } else if (object instanceof Integer) {
                Integer n2 = (Integer)object;
                this.setMnemonic(n2);
            }
        }
        if (!((object = action.getValue("AcceleratorKey")) instanceof KeyStroke)) return;
        if (object == null) return;
        KeyStroke keyStroke = (KeyStroke)object;
        this.registerKeyboardAction(action, keyStroke, 2);
    }
}

