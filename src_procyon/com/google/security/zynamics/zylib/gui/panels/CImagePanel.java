package com.google.security.zynamics.zylib.gui.panels;

import java.awt.image.*;
import javax.swing.*;
import java.awt.*;

public class CImagePanel extends JPanel
{
    private static final long serialVersionUID = 8772470195013064027L;
    private final Image m_image;
    
    public CImagePanel(final Image image) {
        this.m_image = image;
        final Dimension dimension = new Dimension(image.getWidth(null), image.getHeight(null));
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
        this.setSize(dimension);
        this.setLayout(null);
    }
    
    public CImagePanel(final String s) {
        this(new ImageIcon(s).getImage());
    }
    
    public void paintComponent(final Graphics graphics) {
        graphics.drawImage(this.m_image, 0, 0, null);
    }
}
