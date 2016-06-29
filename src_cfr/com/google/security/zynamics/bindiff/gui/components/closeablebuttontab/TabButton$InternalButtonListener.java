/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.security.zynamics.bindiff.gui.components.MessageBox;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.ICloseTabButtonListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton$1;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent;
import com.google.security.zynamics.bindiff.log.Logger;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.SwingUtilities;

class TabButton$InternalButtonListener
implements ActionListener {
    final /* synthetic */ TabButton this$0;

    private TabButton$InternalButtonListener(TabButton tabButton) {
        this.this$0 = tabButton;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n2 = TabButton.access$300(this.this$0).indexOfTabComponent(TabButton.access$200(this.this$0));
        if (n2 == -1) {
            return;
        }
        Iterator iterator = TabButton.access$400(this.this$0).iterator();
        while (iterator.hasNext()) {
            ICloseTabButtonListener iCloseTabButtonListener = (ICloseTabButtonListener)iterator.next();
            try {
                if (iCloseTabButtonListener.closing(TabButton.access$200(this.this$0))) continue;
                return;
            }
            catch (Exception var5_5) {
                MessageBox.showError(SwingUtilities.getWindowAncestor(this.this$0), "An error occured while closing the tab.");
                Logger.logException(var5_5, "An error occured while closing the tab.");
                continue;
            }
        }
    }

    /* synthetic */ TabButton$InternalButtonListener(TabButton tabButton, TabButton$1 tabButton$1) {
        this(tabButton);
    }
}

