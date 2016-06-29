/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.UrlLabel;

import com.google.security.zynamics.zylib.gui.UrlLabel.UrlLabel$1;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class UrlLabel
extends JLabel {
    private static final long serialVersionUID = 1;
    private static MouseListener linker = new UrlLabel$1();
    private URL url;

    public UrlLabel(String string) {
        super(string);
        this.setForeground(Color.BLUE);
        this.addMouseListener(linker);
    }

    public UrlLabel(String string, String string2) {
        this(string);
        this.setToolTipText(string2);
    }

    public UrlLabel(String string, String string2, URL uRL) {
        this(string, uRL);
        this.setToolTipText(string2);
    }

    public UrlLabel(String string, URL uRL) {
        this(string);
        this.url = uRL;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Border border = this.getBorder();
        int n2 = 0;
        int n3 = this.getWidth();
        if (border != null) {
            Insets insets = border.getBorderInsets(this);
            n3 -= insets.right;
            n3 -= insets.left;
            n2 += insets.left;
        }
        graphics.drawLine(n2, this.getHeight() - 2, n3, this.getHeight() - 2);
    }

    public void setUrl(URL uRL) {
        this.url = uRL;
    }

    static /* synthetic */ URL access$000(UrlLabel urlLabel) {
        return urlLabel.url;
    }
}

