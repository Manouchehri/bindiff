package org.jfree.chart.editor;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import org.jfree.chart.editor.PaletteSample;
import org.jfree.chart.plot.ColorPalette;
import org.jfree.chart.plot.RainbowPalette;

class PaletteChooserPanel extends JPanel {
   private JComboBox selector;

   public PaletteChooserPanel(PaletteSample var1, PaletteSample[] var2) {
      this.setLayout(new BorderLayout());
      this.selector = new JComboBox(var2);
      this.selector.setSelectedItem(var1);
      this.selector.setRenderer(new PaletteSample(new RainbowPalette()));
      this.add(this.selector);
   }

   public ColorPalette getSelectedPalette() {
      PaletteSample var1 = (PaletteSample)this.selector.getSelectedItem();
      return var1.getPalette();
   }
}
