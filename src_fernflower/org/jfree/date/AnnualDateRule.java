package org.jfree.date;

import org.jfree.date.SerialDate;

public abstract class AnnualDateRule implements Cloneable {
   public abstract SerialDate getDate(int var1);

   public Object clone() {
      return super.clone();
   }
}
