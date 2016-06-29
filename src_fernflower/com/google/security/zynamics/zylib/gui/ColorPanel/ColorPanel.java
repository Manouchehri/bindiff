package com.google.security.zynamics.zylib.gui.ColorPanel;

import com.google.security.zynamics.zylib.general.Convert;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.CColorChooser;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel$1;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel$InternalListener;
import com.google.security.zynamics.zylib.gui.ColorPanel.IColorPanelListener;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ColorPanel extends JPanel {
   private final ListenerProvider m_listeners;
   private boolean m_editable;
   private final boolean m_showColorText;
   private final JLabel m_textLabel;
   private Set m_defaultColors;

   public ColorPanel(Color var1) {
      this(var1, false, false);
   }

   public ColorPanel(Color var1, boolean var2) {
      this(var1, var2, false);
   }

   public ColorPanel(Color var1, boolean var2, boolean var3) {
      super(new BorderLayout());
      this.m_listeners = new ListenerProvider();
      this.m_editable = true;
      this.m_textLabel = new JLabel("");
      this.m_defaultColors = null;
      this.m_editable = var2;
      this.m_showColorText = var3;
      this.setColor(var1);
      this.setBackground(var1);
      this.m_textLabel.setHorizontalAlignment(0);
      this.add(this.m_textLabel, "Center");
      this.setBorder(new LineBorder(Color.BLACK));
      this.setPreferredSize(new Dimension(100, 20));
      this.addMouseListener(new ColorPanel$InternalListener(this, (ColorPanel$1)null));
      this.updateUI();
   }

   public ColorPanel(Color var1, boolean var2, boolean var3, Set var4) {
      this(var1, var2, var3);
      this.m_defaultColors = var4;
      this.setColor(var1);
   }

   private void chooseColor() {
      Color var1 = CColorChooser.showDialog(this, Constants.COLOR_CHOOSER, this.getBackground(), this.m_defaultColors == null?null:(Color[])this.m_defaultColors.toArray(new Color[0]));
      if(var1 != null) {
         this.setColor(var1);
      }

   }

   private void setTextColor(Color var1) {
      if(this.m_showColorText) {
         float[] var2 = Color.RGBtoHSB(var1.getRed(), var1.getGreen(), var1.getBlue(), (float[])null);
         Color var3;
         if((double)var2[2] > 0.65D) {
            var3 = new Color(32, 32, 32);
            this.m_textLabel.setForeground(var3);
         } else {
            var3 = new Color(222, 222, 222);
            this.m_textLabel.setForeground(var3);
         }

         this.updateUI();
      }

   }

   public void addListener(IColorPanelListener var1) {
      this.m_listeners.addListener(var1);
   }

   public Color getColor() {
      return this.getBackground();
   }

   public void removeListener(IColorPanelListener var1) {
      this.m_listeners.removeListener(var1);
   }

   public void setColor(Color var1) {
      this.setBackground(var1);
      if(this.m_showColorText) {
         this.setTextColor(var1);
         this.m_textLabel.setText(String.format("#%s (%d, %d, %d)", new Object[]{Convert.colorToHexString(var1).toUpperCase(), Integer.valueOf(var1.getRed()), Integer.valueOf(var1.getGreen()), Integer.valueOf(var1.getBlue())}));
         this.m_textLabel.updateUI();
      }

      Iterator var2 = this.m_listeners.iterator();

      while(var2.hasNext()) {
         IColorPanelListener var3 = (IColorPanelListener)var2.next();
         var3.changedColor(this);
      }

   }

   public void setEditable(boolean var1) {
      this.m_editable = var1;
   }

   public void setText(String var1) {
      if(this.m_showColorText) {
         this.m_textLabel.setText(var1);
      }

   }

   // $FF: synthetic method
   static boolean access$100(ColorPanel var0) {
      return var0.m_editable;
   }

   // $FF: synthetic method
   static void access$200(ColorPanel var0) {
      var0.chooseColor();
   }
}
