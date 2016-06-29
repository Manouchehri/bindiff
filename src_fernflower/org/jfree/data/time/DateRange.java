package org.jfree.data.time;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import org.jfree.data.Range;

public class DateRange extends Range implements Serializable {
   private static final long serialVersionUID = -4705682568375418157L;
   private Date lowerDate;
   private Date upperDate;

   public DateRange() {
      this(new Date(0L), new Date(1L));
   }

   public DateRange(Date var1, Date var2) {
      super((double)var1.getTime(), (double)var2.getTime());
      this.lowerDate = var1;
      this.upperDate = var2;
   }

   public DateRange(double var1, double var3) {
      super(var1, var3);
      this.lowerDate = new Date((long)var1);
      this.upperDate = new Date((long)var3);
   }

   public DateRange(Range var1) {
      this(var1.getLowerBound(), var1.getUpperBound());
   }

   public Date getLowerDate() {
      return this.lowerDate;
   }

   public Date getUpperDate() {
      return this.upperDate;
   }

   public String toString() {
      DateFormat var1 = DateFormat.getDateTimeInstance();
      return "[" + var1.format(this.lowerDate) + " --> " + var1.format(this.upperDate) + "]";
   }
}
