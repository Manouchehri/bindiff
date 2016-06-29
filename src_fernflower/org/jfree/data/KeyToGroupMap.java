package org.jfree.data;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class KeyToGroupMap implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -2228169345475318082L;
   private Comparable defaultGroup;
   private List groups;
   private Map keyToGroupMap;

   public KeyToGroupMap() {
      this("Default Group");
   }

   public KeyToGroupMap(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'defaultGroup\' argument.");
      } else {
         this.defaultGroup = var1;
         this.groups = new ArrayList();
         this.keyToGroupMap = new HashMap();
      }
   }

   public int getGroupCount() {
      return this.groups.size() + 1;
   }

   public List getGroups() {
      ArrayList var1 = new ArrayList();
      var1.add(this.defaultGroup);
      Iterator var2 = this.groups.iterator();

      while(var2.hasNext()) {
         Comparable var3 = (Comparable)var2.next();
         if(!var1.contains(var3)) {
            var1.add(var3);
         }
      }

      return var1;
   }

   public int getGroupIndex(Comparable var1) {
      int var2 = this.groups.indexOf(var1);
      if(var2 < 0) {
         if(this.defaultGroup.equals(var1)) {
            var2 = 0;
         }
      } else {
         ++var2;
      }

      return var2;
   }

   public Comparable getGroup(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         Comparable var2 = this.defaultGroup;
         Comparable var3 = (Comparable)this.keyToGroupMap.get(var1);
         if(var3 != null) {
            var2 = var3;
         }

         return var2;
      }
   }

   public void mapKeyToGroup(Comparable var1, Comparable var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else {
         Comparable var3 = this.getGroup(var1);
         if(!var3.equals(this.defaultGroup) && !var3.equals(var2)) {
            int var4 = this.getKeyCount(var3);
            if(var4 == 1) {
               this.groups.remove(var3);
            }
         }

         if(var2 == null) {
            this.keyToGroupMap.remove(var1);
         } else {
            if(!this.groups.contains(var2) && !this.defaultGroup.equals(var2)) {
               this.groups.add(var2);
            }

            this.keyToGroupMap.put(var1, var2);
         }

      }
   }

   public int getKeyCount(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'group\' argument.");
      } else {
         int var2 = 0;
         Iterator var3 = this.keyToGroupMap.values().iterator();

         while(var3.hasNext()) {
            Comparable var4 = (Comparable)var3.next();
            if(var1.equals(var4)) {
               ++var2;
            }
         }

         return var2;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof KeyToGroupMap)) {
         return false;
      } else {
         KeyToGroupMap var2 = (KeyToGroupMap)var1;
         return !ObjectUtilities.equal(this.defaultGroup, var2.defaultGroup)?false:this.keyToGroupMap.equals(var2.keyToGroupMap);
      }
   }

   public Object clone() {
      KeyToGroupMap var1 = (KeyToGroupMap)super.clone();
      var1.defaultGroup = (Comparable)clone((Object)this.defaultGroup);
      var1.groups = (List)clone((Collection)this.groups);
      var1.keyToGroupMap = (Map)clone((Object)this.keyToGroupMap);
      return var1;
   }

   private static Object clone(Object var0) {
      if(var0 == null) {
         return null;
      } else {
         Class var1 = var0.getClass();
         Object var2 = null;

         try {
            Method var3 = var1.getMethod("clone", (Class[])null);
            if(Modifier.isPublic(var3.getModifiers())) {
               try {
                  var2 = var3.invoke(var0, (Object[])null);
               } catch (Exception var5) {
                  var5.printStackTrace();
               }
            }
         } catch (NoSuchMethodException var6) {
            var2 = var0;
         }

         return var2;
      }
   }

   private static Collection clone(Collection var0) {
      List var1 = null;
      if(var0 != null) {
         try {
            List var2 = (List)var0.getClass().newInstance();
            Iterator var3 = var0.iterator();

            while(var3.hasNext()) {
               var2.add(clone(var3.next()));
            }

            var1 = var2;
         } catch (Exception var4) {
            throw new CloneNotSupportedException("Exception.");
         }
      }

      return var1;
   }
}
