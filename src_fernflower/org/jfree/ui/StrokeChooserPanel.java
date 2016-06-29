package org.jfree.ui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Stroke;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import org.jfree.ui.StrokeChooserPanel$1;
import org.jfree.ui.StrokeSample;

public class StrokeChooserPanel extends JPanel {
   private JComboBox selector;

   public StrokeChooserPanel(StrokeSample var1, StrokeSample[] var2) {
      this.setLayout(new BorderLayout());
      this.selector = new JComboBox(var2);
      this.selector.setSelectedItem(var1);
      this.selector.setRenderer(new StrokeSample(new BasicStroke(1.0F)));
      this.add(this.selector);
      this.selector.addActionListener(new StrokeChooserPanel$1(this));
   }

   protected final JComboBox getSelector() {
      return this.selector;
   }

   public Stroke getSelectedStroke() {
      StrokeSample var1 = (StrokeSample)this.selector.getSelectedItem();
      return var1.getStroke();
   }
}
