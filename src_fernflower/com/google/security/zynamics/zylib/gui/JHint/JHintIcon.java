package com.google.security.zynamics.zylib.gui.JHint;

import com.google.security.zynamics.zylib.gui.JHint.JHintDialog;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JHintIcon extends JPanel {
   private static final long serialVersionUID = 6381830838383637854L;
   private static final ImageIcon HELP_ICON = new ImageIcon(Constants.class.getResource("help.png"));
   private final String m_message;
   private JHintDialog m_dialog;
   private static final boolean m_isCursorOverDialog = false;

   public JHintIcon(String var1) {
      super(new BorderLayout());
      this.m_message = var1;
      JLabel var2 = new JLabel(HELP_ICON);
      this.add(var2);
      this.setToolTipText(var1);
   }

   public JHintDialog getM_dialog() {
      return this.m_dialog;
   }

   public String getM_message() {
      return this.m_message;
   }

   public boolean isM_isCursorOverDialog() {
      return false;
   }

   public void setM_dialog(JHintDialog var1) {
      this.m_dialog = var1;
   }
}
