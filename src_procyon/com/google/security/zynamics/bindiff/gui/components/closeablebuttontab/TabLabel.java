package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import javax.swing.*;
import com.google.common.base.*;
import java.awt.*;

public class TabLabel extends JLabel
{
    private final JTabbedPane pane;
    private final TabButtonComponent buttonComponent;
    
    public TabLabel(final JTabbedPane pane, final TabButtonComponent buttonComponent) {
        Preconditions.checkNotNull(pane);
        Preconditions.checkNotNull(buttonComponent);
        this.pane = pane;
        this.buttonComponent = buttonComponent;
    }
    
    @Override
    public String getText() {
        if (this.buttonComponent != null) {
            final int indexOfTabComponent = this.pane.indexOfTabComponent(this.buttonComponent);
            if (indexOfTabComponent != -1) {
                return this.pane.getTitleAt(indexOfTabComponent);
            }
        }
        return null;
    }
    
    @Override
    public void setText(final String s) {
        if (this.buttonComponent != null) {
            final int indexOfTabComponent = this.pane.indexOfTabComponent(this.buttonComponent);
            if (indexOfTabComponent != -1) {
                this.pane.setTitleAt(indexOfTabComponent, s);
            }
        }
    }
}
