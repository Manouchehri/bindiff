package org.jfree.ui.action;

import java.util.*;
import javax.swing.*;

public class ActionConcentrator
{
    private final ArrayList actions;
    
    public ActionConcentrator() {
        this.actions = new ArrayList();
    }
    
    public void addAction(final Action action) {
        if (action == null) {
            throw new NullPointerException();
        }
        this.actions.add(action);
    }
    
    public void removeAction(final Action action) {
        if (action == null) {
            throw new NullPointerException();
        }
        this.actions.remove(action);
    }
    
    public void setEnabled(final boolean enabled) {
        for (int i = 0; i < this.actions.size(); ++i) {
            ((Action)this.actions.get(i)).setEnabled(enabled);
        }
    }
    
    public boolean isEnabled() {
        for (int i = 0; i < this.actions.size(); ++i) {
            if (((Action)this.actions.get(i)).isEnabled()) {
                return true;
            }
        }
        return false;
    }
}
