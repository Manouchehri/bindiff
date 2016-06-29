package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.DiscreteDomain$BigIntegerDomain;
import com.google.common.collect.DiscreteDomain$IntegerDomain;
import com.google.common.collect.DiscreteDomain$LongDomain;
import java.util.NoSuchElementException;

@GwtCompatible
@Beta
public abstract class DiscreteDomain {
   public static DiscreteDomain integers() {
      return DiscreteDomain$IntegerDomain.access$000();
   }

   public static DiscreteDomain longs() {
      return DiscreteDomain$LongDomain.access$100();
   }

   public static DiscreteDomain bigIntegers() {
      return DiscreteDomain$BigIntegerDomain.access$200();
   }

   public abstract Comparable next(Comparable var1);

   public abstract Comparable previous(Comparable var1);

   public abstract long distance(Comparable var1, Comparable var2);

   public Comparable minValue() {
      throw new NoSuchElementException();
   }

   public Comparable maxValue() {
      throw new NoSuchElementException();
   }
}
