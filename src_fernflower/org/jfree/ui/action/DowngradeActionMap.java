package org.jfree.ui.action;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Action;

public class DowngradeActionMap {
   private final HashMap actionMap = new HashMap();
   private final ArrayList actionList = new ArrayList();
   private DowngradeActionMap parent;

   public void setParent(DowngradeActionMap var1) {
      this.parent = var1;
   }

   public DowngradeActionMap getParent() {
      return this.parent;
   }

   public void put(Object var1, Action var2) {
      if(var2 == null) {
         this.remove(var1);
      } else {
         if(this.actionMap.containsKey(var1)) {
            this.remove(var1);
         }

         this.actionMap.put(var1, var2);
         this.actionList.add(var1);
      }

   }

   public Action get(Object var1) {
      Action var2 = (Action)this.actionMap.get(var1);
      return var2 != null?var2:(this.parent != null?this.parent.get(var1):null);
   }

   public void remove(Object var1) {
      this.actionMap.remove(var1);
      this.actionList.remove(var1);
   }

   public void clear() {
      this.actionMap.clear();
      this.actionList.clear();
   }

   public Object[] keys() {
      return this.actionList.toArray();
   }

   public int size() {
      return this.actionMap.size();
   }

   public Object[] allKeys() {
      if(this.parent == null) {
         return this.keys();
      } else {
         Object[] var1 = this.parent.allKeys();
         Object[] var2 = this.keys();
         Object[] var3 = new Object[var1.length + var2.length];
         System.arraycopy(var2, 0, var3, 0, var2.length);
         System.arraycopy(var3, 0, var3, var2.length, var3.length);
         return var3;
      }
   }
}
