package org.jfree.chart.editor;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.jfree.chart.axis.ColorBar;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.editor.DefaultNumberAxisEditor;
import org.jfree.chart.editor.PaletteChooserPanel;
import org.jfree.chart.editor.PaletteSample;
import org.jfree.chart.plot.GreyPalette;
import org.jfree.chart.plot.RainbowPalette;
import org.jfree.layout.LCBLayout;

class DefaultColorBarEditor extends DefaultNumberAxisEditor {
   private JCheckBox invertPaletteCheckBox;
   private boolean invertPalette = false;
   private JCheckBox stepPaletteCheckBox;
   private boolean stepPalette = false;
   private PaletteSample currentPalette;
   private PaletteSample[] availablePaletteSamples;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.editor.LocalizationBundle");

   public DefaultColorBarEditor(ColorBar var1) {
      super((NumberAxis)var1.getAxis());
      this.invertPalette = var1.getColorPalette().isInverse();
      this.stepPalette = var1.getColorPalette().isStepped();
      this.currentPalette = new PaletteSample(var1.getColorPalette());
      this.availablePaletteSamples = new PaletteSample[2];
      this.availablePaletteSamples[0] = new PaletteSample(new RainbowPalette());
      this.availablePaletteSamples[1] = new PaletteSample(new GreyPalette());
      JTabbedPane var2 = this.getOtherTabs();
      JPanel var3 = new JPanel(new LCBLayout(4));
      var3.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      var3.add(new JPanel());
      this.invertPaletteCheckBox = new JCheckBox(localizationResources.getString("Invert_Palette"), this.invertPalette);
      this.invertPaletteCheckBox.setActionCommand("invertPalette");
      this.invertPaletteCheckBox.addActionListener(this);
      var3.add(this.invertPaletteCheckBox);
      var3.add(new JPanel());
      var3.add(new JPanel());
      this.stepPaletteCheckBox = new JCheckBox(localizationResources.getString("Step_Palette"), this.stepPalette);
      this.stepPaletteCheckBox.setActionCommand("stepPalette");
      this.stepPaletteCheckBox.addActionListener(this);
      var3.add(this.stepPaletteCheckBox);
      var3.add(new JPanel());
      var3.add(new JLabel(localizationResources.getString("Palette")));
      JButton var4 = new JButton(localizationResources.getString("Set_palette..."));
      var4.setActionCommand("PaletteChoice");
      var4.addActionListener(this);
      var3.add(this.currentPalette);
      var3.add(var4);
      var2.add(localizationResources.getString("Palette"), var3);
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if(var2.equals("PaletteChoice")) {
         this.attemptPaletteSelection();
      } else if(var2.equals("invertPalette")) {
         this.invertPalette = this.invertPaletteCheckBox.isSelected();
      } else if(var2.equals("stepPalette")) {
         this.stepPalette = this.stepPaletteCheckBox.isSelected();
      } else {
         super.actionPerformed(var1);
      }

   }

   private void attemptPaletteSelection() {
      PaletteChooserPanel var1 = new PaletteChooserPanel((PaletteSample)null, this.availablePaletteSamples);
      int var2 = JOptionPane.showConfirmDialog(this, var1, localizationResources.getString("Palette_Selection"), 2, -1);
      if(var2 == 0) {
         double var3 = this.currentPalette.getPalette().getMinZ();
         double var5 = this.currentPalette.getPalette().getMaxZ();
         this.currentPalette.setPalette(var1.getSelectedPalette());
         this.currentPalette.getPalette().setMinZ(var3);
         this.currentPalette.getPalette().setMaxZ(var5);
      }

   }

   public void setAxisProperties(ColorBar var1) {
      super.setAxisProperties(var1.getAxis());
      var1.setColorPalette(this.currentPalette.getPalette());
      var1.getColorPalette().setInverse(this.invertPalette);
      var1.getColorPalette().setStepped(this.stepPalette);
   }

   public static DefaultColorBarEditor getInstance(ColorBar var0) {
      return var0 != null?new DefaultColorBarEditor(var0):null;
   }
}
