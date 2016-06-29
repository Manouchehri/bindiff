package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.StandardRowSortedTable;
import com.google.common.collect.TreeBasedTable$1;
import com.google.common.collect.TreeBasedTable$2;
import com.google.common.collect.TreeBasedTable$Factory;
import com.google.common.collect.TreeBasedTable$TreeRow;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

@GwtCompatible(
   serializable = true
)
@Beta
public class TreeBasedTable extends StandardRowSortedTable {
   private final Comparator columnComparator;
   private static final long serialVersionUID = 0L;

   public static TreeBasedTable create() {
      return new TreeBasedTable(Ordering.natural(), Ordering.natural());
   }

   public static TreeBasedTable create(Comparator var0, Comparator var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new TreeBasedTable(var0, var1);
   }

   public static TreeBasedTable create(TreeBasedTable var0) {
      TreeBasedTable var1 = new TreeBasedTable(var0.rowComparator(), var0.columnComparator());
      var1.putAll(var0);
      return var1;
   }

   TreeBasedTable(Comparator var1, Comparator var2) {
      super(new TreeMap(var1), new TreeBasedTable$Factory(var2));
      this.columnComparator = var2;
   }

   public Comparator rowComparator() {
      return this.rowKeySet().comparator();
   }

   public Comparator columnComparator() {
      return this.columnComparator;
   }

   public SortedMap row(Object var1) {
      return new TreeBasedTable$TreeRow(this, var1);
   }

   public SortedSet rowKeySet() {
      return super.rowKeySet();
   }

   public SortedMap rowMap() {
      return super.rowMap();
   }

   Iterator createColumnKeyIterator() {
      Comparator var1 = this.columnComparator();
      UnmodifiableIterator var2 = Iterators.mergeSorted(Iterables.transform(this.backingMap.values(), new TreeBasedTable$1(this)), var1);
      return new TreeBasedTable$2(this, var2, var1);
   }
}
