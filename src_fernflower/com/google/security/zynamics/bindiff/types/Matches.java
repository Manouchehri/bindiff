package com.google.security.zynamics.bindiff.types;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Matches {
   private final Table store = HashBasedTable.create();

   public Matches(List var1) {
      Iterator var2 = ((List)Preconditions.checkNotNull(var1)).iterator();

      while(var2.hasNext()) {
         IAddressPair var3 = (IAddressPair)var2.next();
         this.put(var3);
      }

   }

   public void put(IAddressPair var1) {
      if(this.store.put(Long.valueOf(var1.getAddress(ESide.PRIMARY)), Long.valueOf(var1.getAddress(ESide.SECONDARY)), var1) != null) {
         throw new IllegalArgumentException("Attempt to insert duplicate basic block match");
      }
   }

   public IAddressPair remove(IAddress var1, IAddress var2) {
      return (IAddressPair)this.store.remove(Long.valueOf(var1.toLong()), Long.valueOf(var2.toLong()));
   }

   public void clear() {
      this.store.clear();
   }

   public int size() {
      return this.store.size();
   }

   public IAddressPair get(IAddress var1, ESide var2) {
      long var3 = var1.toLong();
      Map var5 = ESide.PRIMARY.equals(var2)?this.store.row(Long.valueOf(var3)):this.store.column(Long.valueOf(var3));
      Collection var6 = var5.values();
      return !var6.isEmpty()?(IAddressPair)var6.iterator().next():null;
   }

   public Collection getMatches() {
      return Collections.unmodifiableCollection(this.store.values());
   }
}
