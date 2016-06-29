package com.google.security.zynamics.bindiff.gui.tabpanels;

import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

public abstract class TabPanel extends JPanel
{
    public TabPanel() {
        super(new BorderLayout());
        this.setBorder(new LineBorder(Color.GRAY));
    }
    
    public abstract Icon getIcon();
    
    public abstract JMenuBar getMenuBar();
    
    public abstract String getTitle();
}
