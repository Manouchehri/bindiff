/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.LayoutManager;
import javax.swing.JPanel;
import org.jfree.ui.WizardDialog;

public abstract class WizardPanel
extends JPanel {
    private WizardDialog owner;

    protected WizardPanel(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public WizardDialog getOwner() {
        return this.owner;
    }

    public void setOwner(WizardDialog wizardDialog) {
        this.owner = wizardDialog;
    }

    public Object getResult() {
        return null;
    }

    public abstract void returnFromLaterStep();

    public abstract boolean canRedisplayNextPanel();

    public abstract boolean hasNextPanel();

    public abstract boolean canFinish();

    public abstract WizardPanel getNextPanel();
}

