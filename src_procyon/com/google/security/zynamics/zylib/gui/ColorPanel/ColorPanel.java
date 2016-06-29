package com.google.security.zynamics.zylib.gui.ColorPanel;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.resources.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;

public class ColorPanel extends JPanel
{
    private final ListenerProvider m_listeners;
    private boolean m_editable;
    private final boolean m_showColorText;
    private final JLabel m_textLabel;
    private Set m_defaultColors;
    
    public ColorPanel(final Color color) {
        this(color, false, false);
    }
    
    public ColorPanel(final Color color, final boolean b) {
        this(color, b, false);
    }
    
    public ColorPanel(final Color color, final boolean editable, final boolean showColorText) {
        super(new BorderLayout());
        this.m_listeners = new ListenerProvider();
        this.m_editable = true;
        this.m_textLabel = new JLabel("");
        this.m_defaultColors = null;
        this.m_editable = editable;
        this.m_showColorText = showColorText;
        this.setColor(color);
        this.setBackground(color);
        this.m_textLabel.setHorizontalAlignment(0);
        this.add(this.m_textLabel, "Center");
        this.setBorder(new LineBorder(Color.BLACK));
        this.setPreferredSize(new Dimension(100, 20));
        this.addMouseListener(new ColorPanel$InternalListener(this, null));
        this.updateUI();
    }
    
    public ColorPanel(final Color color, final boolean b, final boolean b2, final Set defaultColors) {
        this(color, b, b2);
        this.m_defaultColors = defaultColors;
        this.setColor(color);
    }
    
    private void chooseColor() {
        final Color showDialog = CColorChooser.showDialog(this, Constants.COLOR_CHOOSER, this.getBackground(), (Color[])((this.m_defaultColors == null) ? null : ((Color[])this.m_defaultColors.toArray(new Color[0]))));
        if (showDialog != null) {
            this.setColor(showDialog);
        }
    }
    
    private void setTextColor(final Color color) {
        if (this.m_showColorText) {
            if (Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null)[2] > 0.65) {
                this.m_textLabel.setForeground(new Color(32, 32, 32));
            }
            else {
                this.m_textLabel.setForeground(new Color(222, 222, 222));
            }
            this.updateUI();
        }
    }
    
    public void addListener(final IColorPanelListener colorPanelListener) {
        this.m_listeners.addListener(colorPanelListener);
    }
    
    public Color getColor() {
        return this.getBackground();
    }
    
    public void removeListener(final IColorPanelListener colorPanelListener) {
        this.m_listeners.removeListener(colorPanelListener);
    }
    
    public void setColor(final Color color) {
        this.setBackground(color);
        if (this.m_showColorText) {
            this.setTextColor(color);
            this.m_textLabel.setText(String.format("#%s (%d, %d, %d)", Convert.colorToHexString(color).toUpperCase(), color.getRed(), color.getGreen(), color.getBlue()));
            this.m_textLabel.updateUI();
        }
        final Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedColor(this);
        }
    }
    
    public void setEditable(final boolean editable) {
        this.m_editable = editable;
    }
    
    public void setText(final String text) {
        if (this.m_showColorText) {
            this.m_textLabel.setText(text);
        }
    }
}
