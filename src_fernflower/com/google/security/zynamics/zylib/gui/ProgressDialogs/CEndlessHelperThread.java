package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessDescriptionUpdater;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressModel;
import java.util.Iterator;

public abstract class CEndlessHelperThread extends Thread implements IEndlessDescriptionUpdater, IEndlessProgressModel {
   private final ListenerProvider m_listeners = new ListenerProvider();
   private Exception m_exception;

   private void notifyListeners() {
      Iterator var1 = this.m_listeners.iterator();

      while(var1.hasNext()) {
         IEndlessProgressListener var2 = (IEndlessProgressListener)var1.next();
         var2.finished();
      }

   }

   protected void finish() {
      this.notifyListeners();
      this.stop();
   }

   protected abstract void runExpensiveCommand();

   public final void addProgressListener(IEndlessProgressListener var1) {
      this.m_listeners.addListener(var1);
   }

   public void closeRequested() {
   }

   public Exception getException() {
      return this.m_exception;
   }

   public final void removeProgressListener(IEndlessProgressListener var1) {
      this.m_listeners.removeListener(var1);
   }

   public final void run() {
      try {
         this.runExpensiveCommand();
      } catch (Exception var5) {
         this.m_exception = var5;
      } finally {
         this.notifyListeners();
      }

   }

   public void setDescription(String var1) {
      Iterator var2 = this.m_listeners.iterator();

      while(var2.hasNext()) {
         IEndlessProgressListener var3 = (IEndlessProgressListener)var2.next();
         var3.changedDescription(var1);
      }

   }

   public void setGeneralDescription(String var1) {
      Iterator var2 = this.m_listeners.iterator();

      while(var2.hasNext()) {
         IEndlessProgressListener var3 = (IEndlessProgressListener)var2.next();
         var3.changedGeneralDescription(var1);
      }

   }
}
