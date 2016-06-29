/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CImagePanel
extends JPanel {
    private static final long serialVersionUID = 8772470195013064027L;
    private final Image m_image;

    public CImagePanel(Image image) {
        this.m_image = image;
        Dimension dimension = new Dimension(image.getWidth(null), image.getHeight(null));
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
        this.setSize(dimension);
        this.setLayout(null);
    }

    public CImagePanel(String string) {
        this(new ImageIcon(string).getImage());
    }

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.drawImage(this.m_image, 0, 0, null);
    }
}

