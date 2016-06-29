/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ColorPanel;

import com.google.security.zynamics.zylib.general.Convert;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.CColorChooser;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel$1;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel$InternalListener;
import com.google.security.zynamics.zylib.gui.ColorPanel.IColorPanelListener;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ColorPanel
extends JPanel {
    private final ListenerProvider m_listeners = new ListenerProvider();
    private boolean m_editable = true;
    private final boolean m_showColorText;
    private final JLabel m_textLabel = new JLabel("");
    private Set m_defaultColors = null;

    public ColorPanel(Color color) {
        this(color, false, false);
    }

    public ColorPanel(Color color, boolean bl2) {
        this(color, bl2, false);
    }

    public ColorPanel(Color color, boolean bl2, boolean bl3) {
        super(new BorderLayout());
        this.m_editable = bl2;
        this.m_showColorText = bl3;
        this.setColor(color);
        this.setBackground(color);
        this.m_textLabel.setHorizontalAlignment(0);
        this.add((Component)this.m_textLabel, "Center");
        this.setBorder(new LineBorder(Color.BLACK));
        this.setPreferredSize(new Dimension(100, 20));
        this.addMouseListener(new ColorPanel$InternalListener(this, null));
        this.updateUI();
    }

    public ColorPanel(Color color, boolean bl2, boolean bl3, Set set) {
        this(color, bl2, bl3);
        this.m_defaultColors = set;
        this.setColor(color);
    }

    private void chooseColor() {
        Color color = CColorChooser.showDialog(this, Constants.COLOR_CHOOSER, this.getBackground(), this.m_defaultColors == null ? null : this.m_defaultColors.toArray(new Color[0]));
        if (color == null) return;
        this.setColor(color);
    }

    private void setTextColor(Color color) {
        if (!this.m_showColorText) return;
        float[] arrf = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        if ((double)arrf[2] > 0.65) {
            Color color2 = new Color(32, 32, 32);
            this.m_textLabel.setForeground(color2);
        } else {
            Color color3 = new Color(222, 222, 222);
            this.m_textLabel.setForeground(color3);
        }
        this.updateUI();
    }

    public void addListener(IColorPanelListener iColorPanelListener) {
        this.m_listeners.addListener(iColorPanelListener);
    }

    public Color getColor() {
        return this.getBackground();
    }

    public void removeListener(IColorPanelListener iColorPanelListener) {
        this.m_listeners.removeListener(iColorPanelListener);
    }

    public void setColor(Color color) {
        this.setBackground(color);
        if (this.m_showColorText) {
            this.setTextColor(color);
            this.m_textLabel.setText(String.format("#%s (%d, %d, %d)", Convert.colorToHexString(color).toUpperCase(), color.getRed(), color.getGreen(), color.getBlue()));
            this.m_textLabel.updateUI();
        }
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            IColorPanelListener iColorPanelListener = (IColorPanelListener)iterator.next();
            iColorPanelListener.changedColor(this);
        }
    }

    public void setEditable(boolean bl2) {
        this.m_editable = bl2;
    }

    public void setText(String string) {
        if (!this.m_showColorText) return;
        this.m_textLabel.setText(string);
    }

    static /* synthetic */ boolean access$100(ColorPanel colorPanel) {
        return colorPanel.m_editable;
    }

    static /* synthetic */ void access$200(ColorPanel colorPanel) {
        colorPanel.chooseColor();
    }
}

