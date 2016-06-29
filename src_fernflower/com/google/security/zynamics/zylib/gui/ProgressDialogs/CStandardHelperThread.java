package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardDescriptionUpdater;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressListener;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressModel;
import java.util.Iterator;

public abstract class CStandardHelperThread extends Thread implements IStandardDescriptionUpdater, IStandardProgressModel {
   private final ListenerProvider m_listeners = new ListenerProvider();
   private Exception m_exception;

   private void notifyListeners() {
      Iterator var1 = this.m_listeners.iterator();

      while(var1.hasNext()) {
         IStandardProgressListener var2 = (IStandardProgressListener)var1.next();
         var2.finished();
      }

   }

   protected void finish() {
      this.notifyListeners();
      this.stop();
   }

   protected abstract void runExpensiveCommand();

   public final void addProgressListener(IStandardProgressListener var1) {
      this.m_listeners.addListener(var1);
   }

   public void closeRequested() {
   }

   public Exception getException() {
      return this.m_exception;
   }

   public void next() {
      Iterator var1 = this.m_listeners.iterator();

      while(var1.hasNext()) {
         IStandardProgressListener var2 = (IStandardProgressListener)var1.next();
         var2.next();
      }

   }

   public final void removeProgressListener(IStandardProgressListener var1) {
      this.m_listeners.removeListener(var1);
   }

   public void reset() {
      Iterator var1 = this.m_listeners.iterator();

      while(var1.hasNext()) {
         IStandardProgressListener var2 = (IStandardProgressListener)var1.next();
         var2.reset();
      }

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
         IStandardProgressListener var3 = (IStandardProgressListener)var2.next();
         var3.changedDescription(var1);
      }

   }

   public void setMaximum(int var1) {
      Iterator var2 = this.m_listeners.iterator();

      while(var2.hasNext()) {
         IStandardProgressListener var3 = (IStandardProgressListener)var2.next();
         var3.changedMaximum(var1);
      }

   }
}
