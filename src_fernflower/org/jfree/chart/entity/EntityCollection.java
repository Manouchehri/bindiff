package org.jfree.chart.entity;

import java.util.Collection;
import java.util.Iterator;
import org.jfree.chart.entity.ChartEntity;

public interface EntityCollection {
   void clear();

   void add(ChartEntity var1);

   void addAll(EntityCollection var1);

   ChartEntity getEntity(double var1, double var3);

   ChartEntity getEntity(int var1);

   int getEntityCount();

   Collection getEntities();

   Iterator iterator();
}
