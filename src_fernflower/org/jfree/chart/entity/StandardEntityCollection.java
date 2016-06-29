package org.jfree.chart.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class StandardEntityCollection implements Serializable, Cloneable, EntityCollection, PublicCloneable {
   private static final long serialVersionUID = 5384773031184897047L;
   private List entities = new ArrayList();

   public int getEntityCount() {
      return this.entities.size();
   }

   public ChartEntity getEntity(int var1) {
      return (ChartEntity)this.entities.get(var1);
   }

   public void clear() {
      this.entities.clear();
   }

   public void add(ChartEntity var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'entity\' argument.");
      } else {
         this.entities.add(var1);
      }
   }

   public void addAll(EntityCollection var1) {
      this.entities.addAll(var1.getEntities());
   }

   public ChartEntity getEntity(double var1, double var3) {
      int var5 = this.entities.size();

      for(int var6 = var5 - 1; var6 >= 0; --var6) {
         ChartEntity var7 = (ChartEntity)this.entities.get(var6);
         if(var7.getArea().contains(var1, var3)) {
            return var7;
         }
      }

      return null;
   }

   public Collection getEntities() {
      return Collections.unmodifiableCollection(this.entities);
   }

   public Iterator iterator() {
      return this.entities.iterator();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof StandardEntityCollection) {
         StandardEntityCollection var2 = (StandardEntityCollection)var1;
         return ObjectUtilities.equal(this.entities, var2.entities);
      } else {
         return false;
      }
   }

   public Object clone() {
      StandardEntityCollection var1 = (StandardEntityCollection)super.clone();
      var1.entities = new ArrayList(this.entities.size());

      for(int var2 = 0; var2 < this.entities.size(); ++var2) {
         ChartEntity var3 = (ChartEntity)this.entities.get(var2);
         var1.entities.add(var3.clone());
      }

      return var1;
   }
}
