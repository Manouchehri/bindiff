package com.google.common.base;

import com.google.common.base.Randoms$1;
import java.util.Random;

class Randoms$ReadOnlyRandom extends Random {
   private static final long serialVersionUID = 898001275432099254L;
   private boolean initializationComplete;

   private Randoms$ReadOnlyRandom() {
      this.initializationComplete = false;
      this.initializationComplete = true;
   }

   public void setSeed(long var1) {
      if(this.initializationComplete) {
         throw new UnsupportedOperationException("Setting the seed on the shared Random object is not permitted");
      } else {
         super.setSeed(var1);
      }
   }

   // $FF: synthetic method
   Randoms$ReadOnlyRandom(Randoms$1 var1) {
      this();
   }
}
