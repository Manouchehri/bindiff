package org.jfree.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jfree.util.HashNMap$1;
import org.jfree.util.HashNMap$EmptyIterator;
import org.jfree.util.ObjectUtilities;

public class HashNMap implements Serializable, Cloneable {
   private static final long serialVersionUID = -670924844536074826L;
   private static final Iterator EMPTY_ITERATOR = new HashNMap$EmptyIterator((HashNMap$1)null);
   private HashMap table = new HashMap();
   private static final Object[] EMPTY_ARRAY = new Object[0];

   protected List createList() {
      return new ArrayList();
   }

   public boolean put(Object var1, Object var2) {
      List var3 = (List)this.table.get(var1);
      if(var3 == null) {
         List var4 = this.createList();
         var4.add(var2);
         this.table.put(var1, var4);
         return true;
      } else {
         var3.clear();
         return var3.add(var2);
      }
   }

   public boolean add(Object var1, Object var2) {
      List var3 = (List)this.table.get(var1);
      if(var3 == null) {
         this.put(var1, var2);
         return true;
      } else {
         return var3.add(var2);
      }
   }

   public Object getFirst(Object var1) {
      return this.get(var1, 0);
   }

   public Object get(Object var1, int var2) {
      List var3 = (List)this.table.get(var1);
      return var3 == null?null:var3.get(var2);
   }

   public Iterator getAll(Object var1) {
      List var2 = (List)this.table.get(var1);
      return var2 == null?EMPTY_ITERATOR:var2.iterator();
   }

   public Iterator keys() {
      return this.table.keySet().iterator();
   }

   public Set keySet() {
      return this.table.keySet();
   }

   public boolean remove(Object var1, Object var2) {
      List var3 = (List)this.table.get(var1);
      if(var3 == null) {
         return false;
      } else if(!var3.remove(var2)) {
         return false;
      } else {
         if(var3.size() == 0) {
            this.table.remove(var1);
         }

         return true;
      }
   }

   public void removeAll(Object var1) {
      this.table.remove(var1);
   }

   public void clear() {
      this.table.clear();
   }

   public boolean containsKey(Object var1) {
      return this.table.containsKey(var1);
   }

   public boolean containsValue(Object var1) {
      Iterator var2 = this.table.values().iterator();

      boolean var3;
      List var4;
      for(var3 = false; var2.hasNext() && !var3; var3 = var4.contains(var1)) {
         var4 = (List)var2.next();
      }

      return var3;
   }

   public boolean containsValue(Object var1, Object var2) {
      List var3 = (List)this.table.get(var1);
      return var3 == null?false:var3.contains(var2);
   }

   public boolean contains(Object var1) {
      return this.containsKey(var1)?true:this.containsValue(var1);
   }

   public Object clone() {
      HashNMap var1 = (HashNMap)super.clone();
      var1.table = new HashMap();
      Iterator var2 = this.keys();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         List var4 = (List)var1.table.get(var3);
         if(var4 != null) {
            var1.table.put(var3, ObjectUtilities.clone(var4));
         }
      }

      return var1;
   }

   public Object[] toArray(Object var1, Object[] var2) {
      if(var1 == null) {
         throw new NullPointerException("Key must not be null.");
      } else {
         List var3 = (List)this.table.get(var1);
         if(var3 != null) {
            return var3.toArray(var2);
         } else {
            if(var2.length > 0) {
               var2[0] = null;
            }

            return var2;
         }
      }
   }

   public Object[] toArray(Object var1) {
      if(var1 == null) {
         throw new NullPointerException("Key must not be null.");
      } else {
         List var2 = (List)this.table.get(var1);
         return var2 != null?var2.toArray():EMPTY_ARRAY;
      }
   }

   public int getValueCount(Object var1) {
      if(var1 == null) {
         throw new NullPointerException("Key must not be null.");
      } else {
         List var2 = (List)this.table.get(var1);
         return var2 != null?var2.size():0;
      }
   }
}
