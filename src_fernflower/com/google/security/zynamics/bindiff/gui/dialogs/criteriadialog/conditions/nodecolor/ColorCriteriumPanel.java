package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor;

import com.google.security.zynamics.bindiff.graph.AbstractGraphsContainer;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumPanel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.nodecolor.ColorCriteriumPanel$InternalColorPanelListener;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ColorCriteriumPanel extends JPanel {
   private final ColorPanel selectedColorPanel;
   private final ColorCriterium colorCriterium;
   private final List colorPanels = new ArrayList();
   private final ColorCriteriumPanel$InternalColorPanelListener colorPanelListener = new ColorCriteriumPanel$InternalColorPanelListener(this, (ColorCriteriumPanel$1)null);

   public ColorCriteriumPanel(ColorCriterium var1) {
      super(new BorderLayout());
      this.colorCriterium = var1;
      this.selectedColorPanel = new ColorPanel((Color)null, false);
      this.selectedColorPanel.addListener(this.colorPanelListener);
      this.selectedColorPanel.addMouseListener(this.colorPanelListener);
   }

   private void createPanel(List var1) {
      this.removeAll();
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new TitledBorder("Edit Color Condition"));
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new EmptyBorder(0, 5, 3, 5));
      var3.add(var3);
      JPanel var4 = new JPanel(new GridLayout(1 + var1.size() / 4, 4));
      var4.setBorder(new TitledBorder(""));
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         Color var6 = (Color)var5.next();
         JPanel var7 = new JPanel(new BorderLayout());
         var7.setBorder(new EmptyBorder(3, 3, 3, 3));
         ColorPanel var8 = new ColorPanel(var6, false);
         var7.add(var8, "Center");
         this.colorPanels.add(var8);
         var8.addListener(this.colorPanelListener);
         var8.addMouseListener(this.colorPanelListener);
         var4.add(var7, "North");
      }

      this.selectedColorPanel.setColor(var1.size() > 0?(Color)var1.get(0):Color.WHITE);
      var2.add(var3, "North");
      JPanel var9 = new JPanel(new BorderLayout());
      var9.add(var4, "North");
      var9.setBorder(new EmptyBorder(3, 5, 0, 5));
      var2.add(var9, "Center");
      this.add(var2, "Center");
   }

   private void getColors(Set var1, AbstractZyGraph var2) {
      Iterator var3 = var2.getNodes().iterator();

      while(var3.hasNext()) {
         ZyGraphNode var4 = (ZyGraphNode)var3.next();
         var1.add(var4.getRealizer().getFillColor());
      }

   }

   public void delete() {
      this.selectedColorPanel.removeListener(this.colorPanelListener);
      this.selectedColorPanel.removeMouseListener(this.colorPanelListener);
      Iterator var1 = this.colorPanels.iterator();

      while(var1.hasNext()) {
         ColorPanel var2 = (ColorPanel)var1.next();
         var2.removeListener(this.colorPanelListener);
         var2.removeMouseListener(this.colorPanelListener);
      }

   }

   public Color getColor() {
      return this.selectedColorPanel.getColor();
   }

   public void updateColors(AbstractGraphsContainer var1) {
      HashSet var2 = new HashSet();
      this.getColors(var2, var1.getPrimaryGraph());
      this.getColors(var2, var1.getSecondaryGraph());
      this.getColors(var2, var1.getCombinedGraph());
      this.createPanel(new ArrayList(var2));
   }

   // $FF: synthetic method
   static ColorCriterium access$100(ColorCriteriumPanel var0) {
      return var0.colorCriterium;
   }

   // $FF: synthetic method
   static ColorPanel access$200(ColorCriteriumPanel var0) {
      return var0.selectedColorPanel;
   }
}
