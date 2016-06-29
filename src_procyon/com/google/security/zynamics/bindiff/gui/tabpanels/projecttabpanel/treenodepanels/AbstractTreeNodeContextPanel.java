package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public abstract class AbstractTreeNodeContextPanel extends JPanel
{
    public AbstractTreeNodeContextPanel() {
        super(new BorderLayout());
    }
    
    public abstract List getTables();
}
