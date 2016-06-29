package org.jfree.chart.block;

import org.jfree.chart.block.EntityBlockResult;
import org.jfree.chart.entity.EntityCollection;

public class BlockResult implements EntityBlockResult {
   private EntityCollection entities = null;

   public EntityCollection getEntityCollection() {
      return this.entities;
   }

   public void setEntityCollection(EntityCollection var1) {
      this.entities = var1;
   }
}
