/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.jfree.ui.tabbedui.AbstractTabbedUI;

public class AbstractTabbedUI$ExitAction
extends AbstractAction {
    private final AbstractTabbedUI this$0;

    public AbstractTabbedUI$ExitAction(AbstractTabbedUI abstractTabbedUI) {
        this.this$0 = abstractTabbedUI;
        this.putValue("Name", "Exit");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.attempExit();
    }
}

