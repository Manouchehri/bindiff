/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JLabel;

public class DefaultTreeNodeContextPanel
extends AbstractTreeNodeContextPanel {
    private static final Icon IMAGE = ImageUtils.getImageIcon("data/appimages/bindiff-background-image.png");
    private final JLabel imageLabel = new JLabel(IMAGE);

    public DefaultTreeNodeContextPanel() {
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
}

