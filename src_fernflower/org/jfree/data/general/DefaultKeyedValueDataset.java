package org.jfree.data.general;

import java.io.Serializable;
import org.jfree.data.DefaultKeyedValue;
import org.jfree.data.KeyedValue;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.KeyedValueDataset;
import org.jfree.util.ObjectUtilities;

public class DefaultKeyedValueDataset extends AbstractDataset implements Serializable, KeyedValueDataset {
   private static final long serialVersionUID = -8149484339560406750L;
   private KeyedValue data;

   public DefaultKeyedValueDataset() {
      this((KeyedValue)null);
   }

   public DefaultKeyedValueDataset(Comparable var1, Number var2) {
      this(new DefaultKeyedValue(var1, var2));
   }

   public DefaultKeyedValueDataset(KeyedValue var1) {
      this.data = var1;
   }

   public Comparable getKey() {
      Comparable var1 = null;
      if(this.data != null) {
         var1 = this.data.getKey();
      }

      return var1;
   }

   public Number getValue() {
      Number var1 = null;
      if(this.data != null) {
         var1 = this.data.getValue();
      }

      return var1;
   }

   public void updateValue(Number var1) {
      if(this.data == null) {
         throw new RuntimeException("updateValue: can\'t update null.");
      } else {
         this.setValue(this.data.getKey(), var1);
      }
   }

   public void setValue(Comparable var1, Number var2) {
      this.data = new DefaultKeyedValue(var1, var2);
      this.notifyListeners(new DatasetChangeEvent(this, this));
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof KeyedValueDataset)) {
         return false;
      } else {
         KeyedValueDataset var2 = (KeyedValueDataset)var1;
         return this.data == null?var2.getKey() == null && var2.getValue() == null:(!ObjectUtilities.equal(this.data.getKey(), var2.getKey())?false:ObjectUtilities.equal(this.data.getValue(), var2.getValue()));
      }
   }

   public int hashCode() {
      return this.data != null?this.data.hashCode():0;
   }

   public Object clone() {
      DefaultKeyedValueDataset var1 = (DefaultKeyedValueDataset)super.clone();
      return var1;
   }
}
