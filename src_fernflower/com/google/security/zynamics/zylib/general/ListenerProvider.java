package com.google.security.zynamics.zylib.general;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ListenerProvider$ComparableReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class ListenerProvider implements Iterable {
   private volatile Collection m_listeners;

   public void addListener(Object var1) {
      Preconditions.checkNotNull(var1, "Internal Error: Listener cannot be null");
      if(this.m_listeners == null) {
         synchronized(this) {
            if(this.m_listeners == null) {
               this.m_listeners = new LinkedHashSet();
            }
         }
      }

      Collection var2 = this.m_listeners;
      synchronized(this.m_listeners) {
         if(!this.m_listeners.add(new ListenerProvider$ComparableReference(this, var1))) {
            ;
         }

      }
   }

   public Iterator iterator() {
      if(this.m_listeners == null) {
         return Collections.emptyIterator();
      } else {
         Collection var2 = this.m_listeners;
         ArrayList var1;
         synchronized(this.m_listeners) {
            var1 = new ArrayList(this.m_listeners);
         }

         ArrayList var7 = new ArrayList();
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            WeakReference var4 = (WeakReference)var3.next();
            Object var5 = var4.get();
            if(var5 != null) {
               var7.add(var5);
            }
         }

         return var7.iterator();
      }
   }

   public void removeListener(Object var1) {
      Preconditions.checkNotNull(var1, "Internal Error: Listener cannot be null");
      if(this.m_listeners != null) {
         Collection var2 = this.m_listeners;
         synchronized(this.m_listeners) {
            if(!this.m_listeners.remove(new ListenerProvider$ComparableReference(this, var1))) {
               ;
            }
         }
      }

   }
}
