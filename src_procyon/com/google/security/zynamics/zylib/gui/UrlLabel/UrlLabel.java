package com.google.security.zynamics.zylib.gui.UrlLabel;

import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.border.*;
import java.awt.*;

public class UrlLabel extends JLabel
{
    private static final long serialVersionUID = 1L;
    private static MouseListener linker;
    private URL url;
    
    public UrlLabel(final String s) {
        super(s);
        this.setForeground(Color.BLUE);
        this.addMouseListener(UrlLabel.linker);
    }
    
    public UrlLabel(final String s, final String toolTipText) {
        this(s);
        this.setToolTipText(toolTipText);
    }
    
    public UrlLabel(final String s, final String toolTipText, final URL url) {
        this(s, url);
        this.setToolTipText(toolTipText);
    }
    
    public UrlLabel(final String s, final URL url) {
        this(s);
        this.url = url;
    }
    
    @Override
    public void paint(final Graphics graphics) {
        super.paint(graphics);
        final Border border = this.getBorder();
        int n = 0;
        int width = this.getWidth();
        if (border != null) {
            final Insets borderInsets = border.getBorderInsets(this);
            width = width - borderInsets.right - borderInsets.left;
            n += borderInsets.left;
        }
        graphics.drawLine(n, this.getHeight() - 2, width, this.getHeight() - 2);
    }
    
    public void setUrl(final URL url) {
        this.url = url;
    }
    
    static {
        UrlLabel.linker = new UrlLabel$1();
    }
}
