package com.google.security.zynamics.zylib.gui;

import javax.swing.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.io.*;
import java.awt.*;

public class CPathLabel extends JLabel
{
    protected String m_textEllipsis;
    protected JPopupMenu m_popup;
    
    public CPathLabel() {
        this("", null, 10);
    }
    
    public CPathLabel(final Icon icon) {
        this(null, icon, 0);
    }
    
    public CPathLabel(final Icon icon, final int n) {
        this(null, icon, n);
    }
    
    public CPathLabel(final String s) {
        this(s, null, 10);
    }
    
    public CPathLabel(final String s, final Icon icon, final int n) {
        super(s, icon, n);
        this.m_textEllipsis = null;
        this.m_popup = new JPopupMenu();
        final JMenuItem menuItem = new JMenuItem("Copy Path", 67);
        menuItem.addActionListener(new CPathLabel$1(this));
        this.m_popup.add(menuItem);
        this.addComponentListener(new CPathLabel$2(this));
        this.addMouseListener(new CPathLabel$3(this));
    }
    
    public CPathLabel(final String s, final int n) {
        this(s, null, n);
    }
    
    protected void updatePathEllipsis() {
        if (this.getGraphics() == null) {
            return;
        }
        final FontMetrics fontMetrics = this.getGraphics().getFontMetrics();
        this.m_textEllipsis = super.getText();
        int length = this.m_textEllipsis.length();
        String textEllipsis = this.m_textEllipsis;
        for (int width = this.getWidth(); length >= 12 && fontMetrics.stringWidth(textEllipsis) > width; textEllipsis = FileUtils.getPathEllipsis(this.m_textEllipsis, length), --length) {}
        this.m_textEllipsis = textEllipsis;
    }
    
    @Override
    public String getText() {
        return this.m_textEllipsis;
    }
    
    @Override
    public void repaint() {
        this.updatePathEllipsis();
        super.repaint();
    }
}
