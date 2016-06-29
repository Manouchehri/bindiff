package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import java.util.Iterator;
import y.c.l;
import y.h.bu;
import y.h.ce;
import y.h.gj;

public class ZyGraphSelectionObserver extends gj {
   private final ListenerProvider m_selectionListeners = new ListenerProvider();
   private int sequenceCounter = 0;
   private boolean fireFlag = false;

   private void notifySelectionListeners() {
      Iterator var1 = this.m_selectionListeners.iterator();

      while(var1.hasNext()) {
         IZyGraphSelectionListener var2 = (IZyGraphSelectionListener)var1.next();

         try {
            var2.selectionChanged();
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

   }

   protected void updateSelectionState(bu var1) {
      this.notifySelectionListeners();
   }

   public void addListener(IZyGraphSelectionListener var1) {
      this.m_selectionListeners.addListener(var1);
   }

   public void onGraph2DSelectionEvent(ce var1) {
      if(!var1.c() && !var1.b()) {
         if(this.sequenceCounter == 0 && this.fireFlag) {
            this.updateSelectionState(var1.e());
            this.fireFlag = false;
         }

      }
   }

   public void onGraphEvent(l var1) {
      if(var1.a() == 12) {
         ++this.sequenceCounter;
      } else if(var1.a() == 13) {
         --this.sequenceCounter;
         if(this.sequenceCounter == 0) {
            this.updateSelectionState((bu)var1.c());
            this.fireFlag = true;
         }
      }

   }

   public void removeListener(IZyGraphSelectionListener var1) {
      this.m_selectionListeners.removeListener(var1);
   }
}
