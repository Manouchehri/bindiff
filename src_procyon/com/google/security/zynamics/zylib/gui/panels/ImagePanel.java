package com.google.security.zynamics.zylib.gui.panels;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class ImagePanel extends JPanel
{
    private static final long serialVersionUID = -4190301726730485967L;
    private final Image m_image;
    
    public ImagePanel(final Image image) {
        this.m_image = image;
        this.setSize(image.getWidth(null), image.getHeight(null));
        this.setPreferredSize(this.getSize());
        this.setBackground(Color.RED);
    }
    
    @Override
    public void paint(final Graphics graphics) {
        graphics.drawImage(this.m_image, 0, 0, this);
    }
}
