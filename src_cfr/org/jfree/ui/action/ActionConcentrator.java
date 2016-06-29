/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.action;

import java.util.ArrayList;
import javax.swing.Action;

public class ActionConcentrator {
    private final ArrayList actions = new ArrayList();

    public void addAction(Action action) {
        if (action == null) {
            throw new NullPointerException();
        }
        this.actions.add(action);
    }

    public void removeAction(Action action) {
        if (action == null) {
            throw new NullPointerException();
        }
        this.actions.remove(action);
    }

    public void setEnabled(boolean bl2) {
        int n2 = 0;
        while (n2 < this.actions.size()) {
            Action action = (Action)this.actions.get(n2);
            action.setEnabled(bl2);
            ++n2;
        }
    }

    public boolean isEnabled() {
        int n2 = 0;
        while (n2 < this.actions.size()) {
            Action action = (Action)this.actions.get(n2);
            if (action.isEnabled()) {
                return true;
            }
            ++n2;
        }
        return false;
    }
}

