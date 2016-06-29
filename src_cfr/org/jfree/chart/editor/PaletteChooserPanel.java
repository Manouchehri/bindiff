/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.editor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import org.jfree.chart.editor.PaletteSample;
import org.jfree.chart.plot.ColorPalette;
import org.jfree.chart.plot.RainbowPalette;

class PaletteChooserPanel
extends JPanel {
    private JComboBox selector;

    public PaletteChooserPanel(PaletteSample paletteSample, PaletteSample[] arrpaletteSample) {
        this.setLayout(new BorderLayout());
        this.selector = new JComboBox<PaletteSample>(arrpaletteSample);
        this.selector.setSelectedItem(paletteSample);
        this.selector.setRenderer(new PaletteSample(new RainbowPalette()));
        this.add(this.selector);
    }

    public ColorPalette getSelectedPalette() {
        PaletteSample paletteSample = (PaletteSample)this.selector.getSelectedItem();
        return paletteSample.getPalette();
    }
}

