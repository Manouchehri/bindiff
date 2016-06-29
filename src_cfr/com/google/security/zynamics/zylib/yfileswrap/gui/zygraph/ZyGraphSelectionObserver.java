/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import java.util.Iterator;
import y.c.i;
import y.c.l;
import y.h.bu;
import y.h.ce;
import y.h.gj;

public class ZyGraphSelectionObserver
extends gj {
    private final ListenerProvider m_selectionListeners = new ListenerProvider();
    private int sequenceCounter = 0;
    private boolean fireFlag = false;

    private void notifySelectionListeners() {
        Iterator iterator = this.m_selectionListeners.iterator();
        while (iterator.hasNext()) {
            IZyGraphSelectionListener iZyGraphSelectionListener = (IZyGraphSelectionListener)iterator.next();
            try {
                iZyGraphSelectionListener.selectionChanged();
            }
            catch (Exception var3_3) {
                var3_3.printStackTrace();
                continue;
            }
        }
    }

    @Override
    protected void updateSelectionState(bu bu2) {
        this.notifySelectionListeners();
    }

    public void addListener(IZyGraphSelectionListener iZyGraphSelectionListener) {
        this.m_selectionListeners.addListener(iZyGraphSelectionListener);
    }

    @Override
    public void onGraph2DSelectionEvent(ce ce2) {
        if (ce2.c()) return;
        if (ce2.b()) {
            return;
        }
        if (this.sequenceCounter != 0) return;
        if (!this.fireFlag) return;
        this.updateSelectionState(ce2.e());
        this.fireFlag = false;
    }

    @Override
    public void onGraphEvent(l l2) {
        if (l2.a() == 12) {
            ++this.sequenceCounter;
            return;
        }
        if (l2.a() != 13) return;
        --this.sequenceCounter;
        if (this.sequenceCounter != 0) return;
        this.updateSelectionState((bu)l2.c());
        this.fireFlag = true;
    }

    public void removeListener(IZyGraphSelectionListener iZyGraphSelectionListener) {
        this.m_selectionListeners.removeListener(iZyGraphSelectionListener);
    }
}

