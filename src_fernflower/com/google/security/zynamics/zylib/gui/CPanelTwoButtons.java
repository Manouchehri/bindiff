package com.google.security.zynamics.zylib.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CPanelTwoButtons extends JPanel {
   private static final long serialVersionUID = -7197559018087702078L;
   private final String m_FirstButtonName;
   private final String m_SecondButtonName;
   private final JButton m_FirstButton;
   private final JButton m_SecondButton;
   private final ActionListener m_listener;

   public CPanelTwoButtons(ActionListener var1, String var2, String var3) {
      this.m_listener = var1;
      this.m_FirstButtonName = var2;
      this.m_SecondButtonName = var3;
      this.setLayout(new BorderLayout());
      this.m_FirstButton = new JButton(this.m_FirstButtonName);
      this.m_SecondButton = new JButton(this.m_SecondButtonName);
      this.m_FirstButton.addActionListener(var1);
      this.m_SecondButton.addActionListener(var1);
      if(this.m_FirstButton.getPreferredSize().width > this.m_SecondButton.getPreferredSize().width) {
         this.m_SecondButton.setPreferredSize(this.m_FirstButton.getPreferredSize());
      } else {
         this.m_FirstButton.setPreferredSize(this.m_SecondButton.getPreferredSize());
      }

      JPanel var4 = new JPanel(new GridLayout(1, 2));
      JPanel var5 = new JPanel();
      JPanel var6 = new JPanel();
      var5.setBorder(new EmptyBorder(5, 5, 5, 5));
      var6.setBorder(new EmptyBorder(5, 5, 5, 5));
      var5.add(this.m_FirstButton);
      var6.add(this.m_SecondButton);
      var4.add(var5);
      var4.add(var6);
      this.add(var4, "East");
   }

   public JButton getFirstButton() {
      return this.m_FirstButton;
   }

   public void removeListener() {
      this.m_FirstButton.removeActionListener(this.m_listener);
      this.m_SecondButton.removeActionListener(this.m_listener);
   }
}
