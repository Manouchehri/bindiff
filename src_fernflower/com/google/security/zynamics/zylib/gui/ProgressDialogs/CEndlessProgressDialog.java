package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog$InternalListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessProgressDialog$InternalWindowListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressModel;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;

public class CEndlessProgressDialog extends JDialog {
   private boolean m_finished = false;
   private final IEndlessProgressModel m_progressModel;
   private final CEndlessProgressDialog$InternalListener m_internalListener = new CEndlessProgressDialog$InternalListener(this, (CEndlessProgressDialog$1)null);
   private final CProgressPanel m_progressPanel;

   public CEndlessProgressDialog(Window var1, String var2, String var3, IEndlessProgressModel var4) {
      super(var1, var2, ModalityType.DOCUMENT_MODAL);
      this.m_progressModel = var4;
      this.setDefaultCloseOperation(0);
      this.addWindowListener(new CEndlessProgressDialog$InternalWindowListener(this, (CEndlessProgressDialog$1)null));
      var4.addProgressListener(this.m_internalListener);
      this.m_progressPanel = new CProgressPanel(var3, true, false);
      this.m_progressPanel.start();
      this.m_progressPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
      this.setSubDescription("Please wait...");
      this.getContentPane().add(this.m_progressPanel);
      this.pack();
      this.setSubDescription("Please wait...");
      if(var1 != null) {
         GuiHelper.centerChildToParent(var1, this, true);
      } else {
         GuiHelper.centerOnScreen(this);
      }

   }

   public static CEndlessProgressDialog show(Window var0, String var1, String var2, CEndlessHelperThread var3) {
      CEndlessProgressDialog var4 = new CEndlessProgressDialog(var0, var1, var2, var3);
      var3.start();
      var4.setVisible(true);
      return var4;
   }

   public void setDescription(String var1) {
      this.m_progressPanel.setText(var1);
   }

   public void setSubDescription(String var1) {
      this.m_progressPanel.setSubText(var1);
   }

   public void setVisible(boolean var1) {
      if(!this.m_finished) {
         try {
            super.setVisible(var1);
         } catch (Exception var3) {
            ;
         }
      }

   }

   // $FF: synthetic method
   static boolean access$202(CEndlessProgressDialog var0, boolean var1) {
      return var0.m_finished = var1;
   }

   // $FF: synthetic method
   static IEndlessProgressModel access$300(CEndlessProgressDialog var0) {
      return var0.m_progressModel;
   }

   // $FF: synthetic method
   static CProgressPanel access$400(CEndlessProgressDialog var0) {
      return var0.m_progressPanel;
   }
}
