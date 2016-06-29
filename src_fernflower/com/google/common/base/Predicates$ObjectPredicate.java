package com.google.common.base;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;

enum Predicates$ObjectPredicate implements Predicate {
   ALWAYS_TRUE,
   ALWAYS_FALSE,
   IS_NULL,
   NOT_NULL;

   private Predicates$ObjectPredicate() {
   }

   Predicate withNarrowedType() {
      return this;
   }

   // $FF: synthetic method
   Predicates$ObjectPredicate(Predicates$1 var3) {
      this();
   }
}
