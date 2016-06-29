package com.google.security.zynamics.zylib.gui;

import javax.swing.colorchooser.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CColorChooser extends JColorChooser
{
    final Color[] m_recentColors;
    
    public CColorChooser() {
        this(new DefaultColorSelectionModel(Color.WHITE), null);
    }
    
    public CColorChooser(final Color color) {
        this(new DefaultColorSelectionModel(color), null);
    }
    
    public CColorChooser(final Color color, final Color[] array) {
        this(new DefaultColorSelectionModel(color), array);
    }
    
    public CColorChooser(final ColorSelectionModel colorSelectionModel) {
        this(colorSelectionModel, null);
    }
    
    public CColorChooser(final ColorSelectionModel colorSelectionModel, final Color[] recentColors) {
        super(colorSelectionModel);
        final AbstractColorChooserPanel[] chooserPanels = this.getChooserPanels();
        if (chooserPanels.length > 0) {
            this.removeChooserPanel(chooserPanels[0]);
        }
        this.m_recentColors = recentColors;
        if (this.m_recentColors != null) {
            this.addChooserPanel(new CColorChooser$RecentColorsColorChooserPanel(this));
        }
    }
    
    public static JDialog createDialog(final Component component, final String s, final boolean b, final CColorChooser cColorChooser, final ActionListener actionListener, final ActionListener actionListener2) {
        return JColorChooser.createDialog(component, s, b, cColorChooser, actionListener, actionListener2);
    }
    
    public static Color showDialog(final Component component, final String s, final Color color) {
        return showDialog(component, s, color, null);
    }
    
    public static Color showDialog(final Component component, final String s, final Color color, final Color[] array) {
        final CColorChooser cColorChooser2;
        final CColorChooser cColorChooser = cColorChooser2 = new CColorChooser(color, array);
        cColorChooser2.getClass();
        final CColorChooser$SelectedColorActionListener cColorChooser$SelectedColorActionListener = new CColorChooser$SelectedColorActionListener(cColorChooser2);
        final JDialog dialog = createDialog(component, s, true, cColorChooser, cColorChooser$SelectedColorActionListener, null);
        dialog.setVisible(true);
        dialog.dispose();
        return cColorChooser$SelectedColorActionListener.getColor();
    }
}
