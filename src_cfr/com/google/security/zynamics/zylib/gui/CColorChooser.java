/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CColorChooser$RecentColorsColorChooserPanel;
import com.google.security.zynamics.zylib.gui.CColorChooser$SelectedColorActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.colorchooser.DefaultColorSelectionModel;

public class CColorChooser
extends JColorChooser {
    final Color[] m_recentColors;

    public CColorChooser() {
        this(new DefaultColorSelectionModel(Color.WHITE), null);
    }

    public CColorChooser(Color color) {
        this(new DefaultColorSelectionModel(color), null);
    }

    public CColorChooser(Color color, Color[] arrcolor) {
        this(new DefaultColorSelectionModel(color), arrcolor);
    }

    public CColorChooser(ColorSelectionModel colorSelectionModel) {
        this(colorSelectionModel, null);
    }

    public CColorChooser(ColorSelectionModel colorSelectionModel, Color[] arrcolor) {
        super(colorSelectionModel);
        AbstractColorChooserPanel[] arrabstractColorChooserPanel = this.getChooserPanels();
        if (arrabstractColorChooserPanel.length > 0) {
            this.removeChooserPanel(arrabstractColorChooserPanel[0]);
        }
        this.m_recentColors = arrcolor;
        if (this.m_recentColors == null) return;
        this.addChooserPanel(new CColorChooser$RecentColorsColorChooserPanel(this));
    }

    public static JDialog createDialog(Component component, String string, boolean bl2, CColorChooser cColorChooser, ActionListener actionListener, ActionListener actionListener2) {
        return JColorChooser.createDialog(component, string, bl2, cColorChooser, actionListener, actionListener2);
    }

    public static Color showDialog(Component component, String string, Color color) {
        return CColorChooser.showDialog(component, string, color, null);
    }

    public static Color showDialog(Component component, String string, Color color, Color[] arrcolor) {
        CColorChooser cColorChooser;
        CColorChooser cColorChooser2 = cColorChooser = new CColorChooser(color, arrcolor);
        cColorChooser2.getClass();
        CColorChooser$SelectedColorActionListener cColorChooser$SelectedColorActionListener = new CColorChooser$SelectedColorActionListener(cColorChooser2);
        JDialog jDialog = CColorChooser.createDialog(component, string, true, cColorChooser, cColorChooser$SelectedColorActionListener, null);
        jDialog.setVisible(true);
        jDialog.dispose();
        return cColorChooser$SelectedColorActionListener.getColor();
    }
}

