package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;
import java.util.*;

public abstract class AbstractCriterium implements ICriterium
{
    private final ListenerProvider listeners;
    
    public AbstractCriterium() {
        this.listeners = new ListenerProvider();
    }
    
    protected void notifyListeners() {
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().criteriumChanged();
        }
    }
    
    @Override
    public void addListener(final ICriteriumListener criteriumListener) {
        this.listeners.addListener(criteriumListener);
    }
    
    @Override
    public Icon getIcon() {
        return null;
    }
    
    @Override
    public void removeAllListener() {
        final ArrayList<ICriteriumListener> list = new ArrayList<ICriteriumListener>();
        final Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        final Iterator<Object> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            this.removeListener(iterator2.next());
        }
    }
    
    @Override
    public void removeListener(final ICriteriumListener criteriumListener) {
        this.listeners.removeListener(criteriumListener);
    }
}
