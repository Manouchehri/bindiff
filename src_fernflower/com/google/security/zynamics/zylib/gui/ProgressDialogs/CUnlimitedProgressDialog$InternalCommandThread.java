package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CUnlimitedProgressDialog$InternalCommandThread$1;
import java.util.concurrent.CountDownLatch;
import javax.swing.SwingUtilities;

class CUnlimitedProgressDialog$InternalCommandThread implements Runnable {
   private final CountDownLatch m_countDownLatch;
   // $FF: synthetic field
   final CUnlimitedProgressDialog this$0;

   public CUnlimitedProgressDialog$InternalCommandThread(CUnlimitedProgressDialog var1, CountDownLatch var2) {
      this.this$0 = var1;
      this.m_countDownLatch = var2;
   }

   public void run() {
      try {
         CUnlimitedProgressDialog.access$100(this.this$0).execute();
      } catch (Exception var8) {
         CUnlimitedProgressDialog.access$200(this.this$0, var8);
      }

      try {
         SwingUtilities.invokeLater(new CUnlimitedProgressDialog$InternalCommandThread$1(this));
      } catch (Exception var6) {
         CUnlimitedProgressDialog.access$200(this.this$0, var6);
      } finally {
         this.m_countDownLatch.countDown();
      }

   }

   // $FF: synthetic method
   static CountDownLatch access$500(CUnlimitedProgressDialog$InternalCommandThread var0) {
      return var0.m_countDownLatch;
   }
}
