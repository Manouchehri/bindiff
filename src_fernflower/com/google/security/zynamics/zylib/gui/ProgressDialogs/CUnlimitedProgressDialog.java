package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog$1;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog$InternalCommandThread;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog$InternalWindowListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IProgressDescription;
import com.google.security.zynamics.zylib.types.common.ICancelableCommand;
import com.google.security.zynamics.zylib.types.common.ICommand;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.util.concurrent.CountDownLatch;
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;

public class CUnlimitedProgressDialog extends JDialog implements IProgressDescription {
   private static final long serialVersionUID = 1009536934858788904L;
   private final ICommand m_command;
   private final CUnlimitedProgressDialog$InternalWindowListener m_windowListener;
   private final CProgressPanel m_progressPanel;
   private Exception m_exception;
   private final boolean m_isCancelable;

   private CUnlimitedProgressDialog(Window var1, String var2, String var3, ICommand var4, boolean var5) {
      super(var1, var2, ModalityType.DOCUMENT_MODAL);
      this.m_windowListener = new CUnlimitedProgressDialog$InternalWindowListener(this, (CUnlimitedProgressDialog$1)null);
      Preconditions.checkNotNull(var4, "Error: Comand can\'t be null.");
      this.m_isCancelable = var5;
      this.addWindowListener(this.m_windowListener);
      this.setDefaultCloseOperation(0);
      this.m_command = var4;
      this.m_progressPanel = createProgressPanel(var3, var5, this.m_windowListener);
      this.m_progressPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
      this.m_progressPanel.start();
      this.setSubDescription("Please wait...");
      this.add(this.m_progressPanel);
      this.setSize(400, this.getPreferredSize().height);
      this.setMinimumSize(new Dimension(400, this.getPreferredSize().height));
      this.setMaximumSize(new Dimension(Math.max(400, this.getPreferredSize().width), this.getPreferredSize().height));
      this.pack();
      this.setSubDescription("Please wait...");
      if(var1 != null) {
         GuiHelper.centerChildToParent(var1, this, true);
      } else {
         GuiHelper.centerOnScreen(this);
      }

   }

   public CUnlimitedProgressDialog(Window var1, String var2, String var3, ICancelableCommand var4) {
      this(var1, var2, var3, var4, true);
   }

   public CUnlimitedProgressDialog(Window var1, String var2, String var3, ICommand var4) {
      this(var1, var2, var3, var4, false);
   }

   private static CProgressPanel createProgressPanel(String var0, boolean var1, CUnlimitedProgressDialog$InternalWindowListener var2) {
      return var1?new CProgressPanel(var0, true, true, var2):new CProgressPanel(var0, true, true, true, false);
   }

   private void setException(Exception var1) {
      if(this.m_exception == null) {
         this.m_exception = var1;
      }

   }

   public Exception getException() {
      return this.m_exception;
   }

   public synchronized void setDescription(String var1) {
      this.m_progressPanel.setText(var1);
   }

   public synchronized void setSubDescription(String var1) {
      this.m_progressPanel.setSubText(var1);
   }

   public void setVisible(boolean var1) {
      if(var1 && !this.isVisible()) {
         this.m_exception = null;
         CountDownLatch var2 = new CountDownLatch(2);
         Thread var3 = new Thread(new CUnlimitedProgressDialog$InternalCommandThread(this, var2));
         var3.start();
         super.setVisible(var1);

         try {
            var2.await();
         } catch (InterruptedException var5) {
            throw new RuntimeException(var5);
         }
      } else if(!var1 && this.isVisible()) {
         super.setVisible(false);
      }

   }

   public boolean wasCanceled() {
      return this.m_isCancelable && ((ICancelableCommand)this.m_command).wasCanceled();
   }

   // $FF: synthetic method
   static ICommand access$100(CUnlimitedProgressDialog var0) {
      return var0.m_command;
   }

   // $FF: synthetic method
   static void access$200(CUnlimitedProgressDialog var0, Exception var1) {
      var0.setException(var1);
   }

   // $FF: synthetic method
   static void access$301(CUnlimitedProgressDialog var0) {
      var0.dispose();
   }

   // $FF: synthetic method
   static void access$401(CUnlimitedProgressDialog var0, boolean var1) {
      var0.setVisible(var1);
   }

   // $FF: synthetic method
   static boolean access$600(CUnlimitedProgressDialog var0) {
      return var0.m_isCancelable;
   }
}
