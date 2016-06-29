package org.jfree.chart.editor;

import org.jfree.chart.plot.*;
import javax.swing.*;
import java.awt.*;

class PaletteChooserPanel extends JPanel
{
    private JComboBox selector;
    
    public PaletteChooserPanel(final PaletteSample selectedItem, final PaletteSample[] array) {
        this.setLayout(new BorderLayout());
        (this.selector = new JComboBox((E[])array)).setSelectedItem(selectedItem);
        this.selector.setRenderer(new PaletteSample(new RainbowPalette()));
        this.add(this.selector);
    }
    
    public ColorPalette getSelectedPalette() {
        return ((PaletteSample)this.selector.getSelectedItem()).getPalette();
    }
}
