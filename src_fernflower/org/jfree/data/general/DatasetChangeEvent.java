package org.jfree.data.general;

import java.util.EventObject;
import org.jfree.data.general.Dataset;

public class DatasetChangeEvent extends EventObject {
   private Dataset dataset;

   public DatasetChangeEvent(Object var1, Dataset var2) {
      super(var1);
      this.dataset = var2;
   }

   public Dataset getDataset() {
      return this.dataset;
   }
}
