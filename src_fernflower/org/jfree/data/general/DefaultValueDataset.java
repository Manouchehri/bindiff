package org.jfree.data.general;

import java.io.Serializable;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.ValueDataset;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class DefaultValueDataset extends AbstractDataset implements Serializable, Cloneable, ValueDataset, PublicCloneable {
   private static final long serialVersionUID = 8137521217249294891L;
   private Number value;

   public DefaultValueDataset() {
      this((Number)null);
   }

   public DefaultValueDataset(double var1) {
      this(new Double(var1));
   }

   public DefaultValueDataset(Number var1) {
      this.value = var1;
   }

   public Number getValue() {
      return this.value;
   }

   public void setValue(Number var1) {
      this.value = var1;
      this.notifyListeners(new DatasetChangeEvent(this, this));
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof ValueDataset) {
         ValueDataset var2 = (ValueDataset)var1;
         return ObjectUtilities.equal(this.value, var2.getValue());
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.value != null?this.value.hashCode():0;
   }
}
