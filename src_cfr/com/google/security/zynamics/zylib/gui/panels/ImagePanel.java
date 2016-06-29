/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

public class ImagePanel
extends JPanel {
    private static final long serialVersionUID = -4190301726730485967L;
    private final Image m_image;

    public ImagePanel(Image image) {
        this.m_image = image;
        this.setSize(image.getWidth(null), image.getHeight(null));
        this.setPreferredSize(this.getSize());
        this.setBackground(Color.RED);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(this.m_image, 0, 0, this);
    }
}

