package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.google.security.zynamics.bindiff.utils.*;

public class DefaultTreeNodeContextPanel extends AbstractTreeNodeContextPanel
{
    private static final Icon IMAGE;
    private final JLabel imageLabel;
    
    public DefaultTreeNodeContextPanel() {
        this.imageLabel = new JLabel(DefaultTreeNodeContextPanel.IMAGE);
        this.init();
    }
    
    private void init() {
        this.setMinimumSize(new Dimension(0, 0));
        this.setBackground(Color.WHITE);
        this.add(this.imageLabel);
    }
    
    @Override
    public List getTables() {
        return null;
    }
    
    static {
        IMAGE = ImageUtils.getImageIcon("data/appimages/bindiff-background-image.png");
    }
}
