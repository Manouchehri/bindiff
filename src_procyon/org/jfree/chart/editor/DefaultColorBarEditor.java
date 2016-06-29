package org.jfree.chart.editor;

import java.util.*;
import org.jfree.chart.plot.*;
import org.jfree.layout.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.axis.*;

class DefaultColorBarEditor extends DefaultNumberAxisEditor
{
    private JCheckBox invertPaletteCheckBox;
    private boolean invertPalette;
    private JCheckBox stepPaletteCheckBox;
    private boolean stepPalette;
    private PaletteSample currentPalette;
    private PaletteSample[] availablePaletteSamples;
    protected static ResourceBundle localizationResources;
    
    public DefaultColorBarEditor(final ColorBar colorBar) {
        super((NumberAxis)colorBar.getAxis());
        this.invertPalette = false;
        this.stepPalette = false;
        this.invertPalette = colorBar.getColorPalette().isInverse();
        this.stepPalette = colorBar.getColorPalette().isStepped();
        this.currentPalette = new PaletteSample(colorBar.getColorPalette());
        (this.availablePaletteSamples = new PaletteSample[2])[0] = new PaletteSample(new RainbowPalette());
        this.availablePaletteSamples[1] = new PaletteSample(new GreyPalette());
        final JTabbedPane otherTabs = this.getOtherTabs();
        final JPanel panel = new JPanel(new LCBLayout(4));
        panel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        panel.add(new JPanel());
        (this.invertPaletteCheckBox = new JCheckBox(DefaultColorBarEditor.localizationResources.getString("Invert_Palette"), this.invertPalette)).setActionCommand("invertPalette");
        this.invertPaletteCheckBox.addActionListener(this);
        panel.add(this.invertPaletteCheckBox);
        panel.add(new JPanel());
        panel.add(new JPanel());
        (this.stepPaletteCheckBox = new JCheckBox(DefaultColorBarEditor.localizationResources.getString("Step_Palette"), this.stepPalette)).setActionCommand("stepPalette");
        this.stepPaletteCheckBox.addActionListener(this);
        panel.add(this.stepPaletteCheckBox);
        panel.add(new JPanel());
        panel.add(new JLabel(DefaultColorBarEditor.localizationResources.getString("Palette")));
        final JButton button = new JButton(DefaultColorBarEditor.localizationResources.getString("Set_palette..."));
        button.setActionCommand("PaletteChoice");
        button.addActionListener(this);
        panel.add(this.currentPalette);
        panel.add(button);
        otherTabs.add(DefaultColorBarEditor.localizationResources.getString("Palette"), panel);
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("PaletteChoice")) {
            this.attemptPaletteSelection();
        }
        else if (actionCommand.equals("invertPalette")) {
            this.invertPalette = this.invertPaletteCheckBox.isSelected();
        }
        else if (actionCommand.equals("stepPalette")) {
            this.stepPalette = this.stepPaletteCheckBox.isSelected();
        }
        else {
            super.actionPerformed(actionEvent);
        }
    }
    
    private void attemptPaletteSelection() {
        final PaletteChooserPanel paletteChooserPanel = new PaletteChooserPanel(null, this.availablePaletteSamples);
        if (JOptionPane.showConfirmDialog(this, paletteChooserPanel, DefaultColorBarEditor.localizationResources.getString("Palette_Selection"), 2, -1) == 0) {
            final double minZ = this.currentPalette.getPalette().getMinZ();
            final double maxZ = this.currentPalette.getPalette().getMaxZ();
            this.currentPalette.setPalette(paletteChooserPanel.getSelectedPalette());
            this.currentPalette.getPalette().setMinZ(minZ);
            this.currentPalette.getPalette().setMaxZ(maxZ);
        }
    }
    
    public void setAxisProperties(final ColorBar colorBar) {
        super.setAxisProperties(colorBar.getAxis());
        colorBar.setColorPalette(this.currentPalette.getPalette());
        colorBar.getColorPalette().setInverse(this.invertPalette);
        colorBar.getColorPalette().setStepped(this.stepPalette);
    }
    
    public static DefaultColorBarEditor getInstance(final ColorBar colorBar) {
        if (colorBar != null) {
            return new DefaultColorBarEditor(colorBar);
        }
        return null;
    }
    
    static {
        DefaultColorBarEditor.localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");
    }
}
