package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel$2;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel$CancelAction;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel$InternalActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CProgressPanel extends JPanel {
   private static final long serialVersionUID = 8176524035621381995L;
   private final JLabel m_label;
   private final JProgressBar m_progressBar;
   private String m_description;
   private final ActionListener m_listener;
   private final ActionListener m_externalCancelButtonListener;
   private final Timer m_timer;
   private int m_seconds;
   private final boolean m_showSeconds;

   public CProgressPanel(String var1, boolean var2, boolean var3) {
      this(var1, var2, true, var3);
   }

   public CProgressPanel(String var1, boolean var2, boolean var3, ActionListener var4) {
      this.m_label = new JLabel();
      this.m_progressBar = new JProgressBar();
      this.m_listener = new CProgressPanel$InternalActionListener(this, (CProgressPanel$1)null);
      this.m_timer = new Timer(1000, this.m_listener);
      this.m_seconds = 0;
      this.m_externalCancelButtonListener = (ActionListener)Preconditions.checkNotNull(var4, "Error: Cancel button listener can\'t be null.");
      this.m_description = var1;
      this.m_showSeconds = var3;
      this.createPanel(var2, var3, true, true);
   }

   public CProgressPanel(String var1, boolean var2, boolean var3, boolean var4) {
      this.m_label = new JLabel();
      this.m_progressBar = new JProgressBar();
      this.m_listener = new CProgressPanel$InternalActionListener(this, (CProgressPanel$1)null);
      this.m_timer = new Timer(1000, this.m_listener);
      this.m_seconds = 0;
      this.m_description = var1;
      this.m_showSeconds = var3;
      this.m_externalCancelButtonListener = null;
      this.createPanel(var2, var3, var4, false);
   }

   public CProgressPanel(String var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      this.m_label = new JLabel();
      this.m_progressBar = new JProgressBar();
      this.m_listener = new CProgressPanel$InternalActionListener(this, (CProgressPanel$1)null);
      this.m_timer = new Timer(1000, this.m_listener);
      this.m_seconds = 0;
      this.m_description = var1;
      this.m_showSeconds = var3;
      this.m_externalCancelButtonListener = null;
      this.createPanel(var2, var3, var5, var4);
   }

   private static String convertTextToHtml(String var0) {
      String var1 = String.valueOf(var0.replaceAll("\n", "<br>"));
      return (new StringBuilder(13 + String.valueOf(var1).length())).append("<html>").append(var1).append("</html>").toString();
   }

   private void createPanel(boolean var1, boolean var2, boolean var3, boolean var4) {
      this.setLayout(new BorderLayout());
      JPanel var5 = new JPanel(new BorderLayout());
      var5.setBorder(new TitledBorder(""));
      if(this.m_description == null) {
         this.m_label.setVisible(false);
      } else {
         this.m_label.setText(convertTextToHtml(this.m_description));
      }

      var5.add(this.m_label, "North");
      this.m_progressBar.setIndeterminate(var1);
      this.m_progressBar.setStringPainted(true);
      JPanel var6 = new JPanel(new BorderLayout());
      if(var4) {
         var6.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.GRAY), new EmptyBorder(1, 1, 1, 1)));
      }

      if(var3) {
         JPanel var7 = new JPanel(new BorderLayout());
         JButton var8 = new JButton(new CProgressPanel$CancelAction(this));
         var8.setFocusable(false);
         JPanel var9 = new JPanel(new BorderLayout());
         var9.setBorder(new EmptyBorder(0, 1, 0, 0));
         var9.setMinimumSize(new Dimension(1, 0));
         var7.add(var9, "West");
         var7.add(var8, "East");
         var6.add(var7, "East");
      }

      var6.add(this.m_progressBar, "Center");
      var5.add(var6, "Center");
      if(var1 && var2) {
         this.updateSecondsText();
         this.m_timer.setRepeats(true);
      }

      this.add(var5, "North");
   }

   private void updateSecondsText() {
      this.m_progressBar.setString(String.format("%d seconds", new Object[]{Integer.valueOf(++this.m_seconds)}));
   }

   protected void closeRequested() {
   }

   public String fitTextToLabel(String var1) {
      FontMetrics var2 = this.m_label.getFontMetrics(this.m_label.getFont());
      double var3 = (double)(this.getWidth() - 50);
      boolean var5 = false;

      do {
         double var6 = (double)var2.stringWidth(var1);
         if(var3 > var6) {
            var5 = true;
         } else {
            if(var1.length() <= 4) {
               break;
            }

            var1 = String.valueOf(var1.substring(0, var1.length() - 4)).concat("...");
         }
      } while(!var5 && var1.length() > 4);

      return var1;
   }

   public void next() {
      this.m_progressBar.setValue(this.m_progressBar.getValue() + 1);
   }

   public void reset() {
      this.m_progressBar.setValue(0);
   }

   public void setMaximum(int var1) {
      this.m_progressBar.setMaximum(var1);
   }

   public void setProgressText(String var1) {
      this.m_progressBar.setString(var1);
   }

   public void setSubText(String var1) {
      // $FF: Couldn't be decompiled
   }

   public void setText(String var1) {
      this.m_description = var1;
      String var2 = convertTextToHtml(var1);
      var2 = this.fitTextToLabel(var2);
      this.m_label.setText(var2);
      (new CProgressPanel$2(this)).invokeLater();
   }

   public void setValue(int var1) {
      this.m_progressBar.setValue(var1);
   }

   public void start() {
      if(this.m_progressBar.isIndeterminate() && this.m_showSeconds) {
         this.m_seconds = 0;
         this.updateSecondsText();
         this.m_timer.start();
      }

   }

   public void stop() {
      if(this.m_progressBar.isIndeterminate() && this.m_showSeconds) {
         this.m_timer.stop();
      }

   }

   // $FF: synthetic method
   static JLabel access$100(CProgressPanel var0) {
      return var0.m_label;
   }

   // $FF: synthetic method
   static ActionListener access$200(CProgressPanel var0) {
      return var0.m_externalCancelButtonListener;
   }

   // $FF: synthetic method
   static void access$300(CProgressPanel var0) {
      var0.updateSecondsText();
   }
}
