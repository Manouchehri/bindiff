/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CPathLabel$1;
import com.google.security.zynamics.zylib.gui.CPathLabel$2;
import com.google.security.zynamics.zylib.gui.CPathLabel$3;
import com.google.security.zynamics.zylib.io.FileUtils;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class CPathLabel
extends JLabel {
    protected String m_textEllipsis = null;
    protected JPopupMenu m_popup = new JPopupMenu();

    public CPathLabel() {
        this("", null, 10);
    }

    public CPathLabel(Icon icon) {
        this(null, icon, 0);
    }

    public CPathLabel(Icon icon, int n2) {
        this(null, icon, n2);
    }

    public CPathLabel(String string) {
        this(string, null, 10);
    }

    public CPathLabel(String string, Icon icon, int n2) {
        super(string, icon, n2);
        JMenuItem jMenuItem = new JMenuItem("Copy Path", 67);
        jMenuItem.addActionListener(new CPathLabel$1(this));
        this.m_popup.add(jMenuItem);
        this.addComponentListener(new CPathLabel$2(this));
        this.addMouseListener(new CPathLabel$3(this));
    }

    public CPathLabel(String string, int n2) {
        this(string, null, n2);
    }

    protected void updatePathEllipsis() {
        if (this.getGraphics() == null) {
            return;
        }
        FontMetrics fontMetrics = this.getGraphics().getFontMetrics();
        this.m_textEllipsis = super.getText();
        String string = this.m_textEllipsis;
        int n2 = this.getWidth();
        for (int i2 = this.m_textEllipsis.length(); i2 >= 12 && fontMetrics.stringWidth(string) > n2; --i2) {
            string = FileUtils.getPathEllipsis(this.m_textEllipsis, i2);
        }
        this.m_textEllipsis = string;
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

    static /* synthetic */ String access$001(CPathLabel cPathLabel) {
        return cPathLabel.getText();
    }
}

