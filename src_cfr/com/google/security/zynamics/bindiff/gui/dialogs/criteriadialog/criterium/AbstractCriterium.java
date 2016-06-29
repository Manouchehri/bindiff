/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumListener;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Icon;

public abstract class AbstractCriterium
implements ICriterium {
    private final ListenerProvider listeners = new ListenerProvider();

    protected void notifyListeners() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ICriteriumListener iCriteriumListener = (ICriteriumListener)iterator.next();
            iCriteriumListener.criteriumChanged();
        }
    }

    @Override
    public void addListener(ICriteriumListener iCriteriumListener) {
        this.listeners.addListener(iCriteriumListener);
    }

    @Override
    public Icon getIcon() {
        return null;
    }

    @Override
    public void removeAllListener() {
        ArrayList<ICriteriumListener> arrayList = new ArrayList<ICriteriumListener>();
        for (ICriteriumListener iCriteriumListener2 : this.listeners) {
            arrayList.add(iCriteriumListener2);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ICriteriumListener iCriteriumListener2;
            iCriteriumListener2 = (ICriteriumListener)iterator.next();
            this.removeListener(iCriteriumListener2);
        }
    }

    @Override
    public void removeListener(ICriteriumListener iCriteriumListener) {
        this.listeners.removeListener(iCriteriumListener);
    }
}

