package org.jfree.ui;

import javax.swing.*;
import java.awt.*;

public abstract class WizardPanel extends JPanel
{
    private WizardDialog owner;
    
    protected WizardPanel(final LayoutManager layoutManager) {
        super(layoutManager);
    }
    
    public WizardDialog getOwner() {
        return this.owner;
    }
    
    public void setOwner(final WizardDialog owner) {
        this.owner = owner;
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
