package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardHelperThread;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog$InternalListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CStandardProgressDialog$InternalWindowListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressModel;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;

public class CStandardProgressDialog extends JDialog {
   private static final long serialVersionUID = 7140381762236285546L;
   private boolean m_finished = false;
   private final IStandardProgressModel m_progressModel;
   private final CStandardProgressDialog$InternalListener m_internalListener = new CStandardProgressDialog$InternalListener(this, (CStandardProgressDialog$1)null);
   private final CProgressPanel m_progressPanel;

   public CStandardProgressDialog(Window var1, String var2, String var3, IStandardProgressModel var4) {
      super(var1, var2, ModalityType.DOCUMENT_MODAL);
      this.m_progressModel = var4;
      this.setDefaultCloseOperation(0);
      this.addWindowListener(new CStandardProgressDialog$InternalWindowListener(this, (CStandardProgressDialog$1)null));
      var4.addProgressListener(this.m_internalListener);
      this.m_progressPanel = new CProgressPanel(var3, false, false);
      this.m_progressPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
      this.add(this.m_progressPanel);
      this.pack();
      if(var1 != null) {
         GuiHelper.centerChildToParent(var1, this, true);
      } else {
         GuiHelper.centerOnScreen(this);
      }

   }

   public static void show(Window var0, String var1, String var2, CStandardHelperThread var3) {
      CStandardProgressDialog var4 = new CStandardProgressDialog(var0, var1, var2, var3);
      var3.start();
      var4.setVisible(true);
   }

   public void setDescription(String var1) {
      this.m_progressPanel.setText(var1);
   }

   public void setSubDescription(String var1) {
      this.m_progressPanel.setSubText(var1);
      if(this.getParent() != null) {
         GuiHelper.centerChildToParent(this.getParent(), this, true);
      } else {
         GuiHelper.centerOnScreen(this);
      }

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
   static CProgressPanel access$200(CStandardProgressDialog var0) {
      return var0.m_progressPanel;
   }

   // $FF: synthetic method
   static boolean access$302(CStandardProgressDialog var0, boolean var1) {
      return var0.m_finished = var1;
   }

   // $FF: synthetic method
   static IStandardProgressModel access$400(CStandardProgressDialog var0) {
      return var0.m_progressModel;
   }
}
