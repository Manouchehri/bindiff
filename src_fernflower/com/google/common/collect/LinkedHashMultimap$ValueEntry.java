package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;
import javax.annotation.Nullable;

@VisibleForTesting
final class LinkedHashMultimap$ValueEntry extends ImmutableEntry implements LinkedHashMultimap$ValueSetLink {
   final int smearedValueHash;
   @Nullable
   LinkedHashMultimap$ValueEntry nextInValueBucket;
   LinkedHashMultimap$ValueSetLink predecessorInValueSet;
   LinkedHashMultimap$ValueSetLink successorInValueSet;
   LinkedHashMultimap$ValueEntry predecessorInMultimap;
   LinkedHashMultimap$ValueEntry successorInMultimap;

   LinkedHashMultimap$ValueEntry(@Nullable Object var1, @Nullable Object var2, int var3, @Nullable LinkedHashMultimap$ValueEntry var4) {
      super(var1, var2);
      this.smearedValueHash = var3;
      this.nextInValueBucket = var4;
   }

   boolean matchesValue(@Nullable Object var1, int var2) {
      return this.smearedValueHash == var2 && Objects.equal(this.getValue(), var1);
   }

   public LinkedHashMultimap$ValueSetLink getPredecessorInValueSet() {
      return this.predecessorInValueSet;
   }

   public LinkedHashMultimap$ValueSetLink getSuccessorInValueSet() {
      return this.successorInValueSet;
   }

   public void setPredecessorInValueSet(LinkedHashMultimap$ValueSetLink var1) {
      this.predecessorInValueSet = var1;
   }

   public void setSuccessorInValueSet(LinkedHashMultimap$ValueSetLink var1) {
      this.successorInValueSet = var1;
   }

   public LinkedHashMultimap$ValueEntry getPredecessorInMultimap() {
      return this.predecessorInMultimap;
   }

   public LinkedHashMultimap$ValueEntry getSuccessorInMultimap() {
      return this.successorInMultimap;
   }

   public void setSuccessorInMultimap(LinkedHashMultimap$ValueEntry var1) {
      this.successorInMultimap = var1;
   }

   public void setPredecessorInMultimap(LinkedHashMultimap$ValueEntry var1) {
      this.predecessorInMultimap = var1;
   }
}
