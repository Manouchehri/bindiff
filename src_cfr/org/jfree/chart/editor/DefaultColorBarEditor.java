/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.editor;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.ColorBar;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.editor.DefaultNumberAxisEditor;
import org.jfree.chart.editor.PaletteChooserPanel;
import org.jfree.chart.editor.PaletteSample;
import org.jfree.chart.plot.ColorPalette;
import org.jfree.chart.plot.GreyPalette;
import org.jfree.chart.plot.RainbowPalette;
import org.jfree.layout.LCBLayout;

class DefaultColorBarEditor
extends DefaultNumberAxisEditor {
    private JCheckBox invertPaletteCheckBox;
    private boolean invertPalette = false;
    private JCheckBox stepPaletteCheckBox;
    private boolean stepPalette = false;
    private PaletteSample currentPalette;
    private PaletteSample[] availablePaletteSamples;
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");

    public DefaultColorBarEditor(ColorBar colorBar) {
        super((NumberAxis)colorBar.getAxis());
        this.invertPalette = colorBar.getColorPalette().isInverse();
        this.stepPalette = colorBar.getColorPalette().isStepped();
        this.currentPalette = new PaletteSample(colorBar.getColorPalette());
        this.availablePaletteSamples = new PaletteSample[2];
        this.availablePaletteSamples[0] = new PaletteSample(new RainbowPalette());
        this.availablePaletteSamples[1] = new PaletteSample(new GreyPalette());
        JTabbedPane jTabbedPane = this.getOtherTabs();
        JPanel jPanel = new JPanel(new LCBLayout(4));
        jPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jPanel.add(new JPanel());
        this.invertPaletteCheckBox = new JCheckBox(localizationResources.getString("Invert_Palette"), this.invertPalette);
        this.invertPaletteCheckBox.setActionCommand("invertPalette");
        this.invertPaletteCheckBox.addActionListener(this);
        jPanel.add(this.invertPaletteCheckBox);
        jPanel.add(new JPanel());
        jPanel.add(new JPanel());
        this.stepPaletteCheckBox = new JCheckBox(localizationResources.getString("Step_Palette"), this.stepPalette);
        this.stepPaletteCheckBox.setActionCommand("stepPalette");
        this.stepPaletteCheckBox.addActionListener(this);
        jPanel.add(this.stepPaletteCheckBox);
        jPanel.add(new JPanel());
        jPanel.add(new JLabel(localizationResources.getString("Palette")));
        JButton jButton = new JButton(localizationResources.getString("Set_palette..."));
        jButton.setActionCommand("PaletteChoice");
        jButton.addActionListener(this);
        jPanel.add(this.currentPalette);
        jPanel.add(jButton);
        jTabbedPane.add(localizationResources.getString("Palette"), jPanel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("PaletteChoice")) {
            this.attemptPaletteSelection();
            return;
        }
        if (string.equals("invertPalette")) {
            this.invertPalette = this.invertPaletteCheckBox.isSelected();
            return;
        }
        if (string.equals("stepPalette")) {
            this.stepPalette = this.stepPaletteCheckBox.isSelected();
            return;
        }
        super.actionPerformed(actionEvent);
    }

    private void attemptPaletteSelection() {
        PaletteChooserPanel paletteChooserPanel = new PaletteChooserPanel(null, this.availablePaletteSamples);
        int n2 = JOptionPane.showConfirmDialog(this, paletteChooserPanel, localizationResources.getString("Palette_Selection"), 2, -1);
        if (n2 != 0) return;
        double d2 = this.currentPalette.getPalette().getMinZ();
        double d3 = this.currentPalette.getPalette().getMaxZ();
        this.currentPalette.setPalette(paletteChooserPanel.getSelectedPalette());
        this.currentPalette.getPalette().setMinZ(d2);
        this.currentPalette.getPalette().setMaxZ(d3);
    }

    public void setAxisProperties(ColorBar colorBar) {
        super.setAxisProperties(colorBar.getAxis());
        colorBar.setColorPalette(this.currentPalette.getPalette());
        colorBar.getColorPalette().setInverse(this.invertPalette);
        colorBar.getColorPalette().setStepped(this.stepPalette);
    }

    public static DefaultColorBarEditor getInstance(ColorBar colorBar) {
        if (colorBar == null) return null;
        return new DefaultColorBarEditor(colorBar);
    }
}

