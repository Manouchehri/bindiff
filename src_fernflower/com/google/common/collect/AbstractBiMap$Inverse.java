package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$1;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

class AbstractBiMap$Inverse extends AbstractBiMap {
   @GwtIncompatible("Not needed in emulated source.")
   private static final long serialVersionUID = 0L;

   private AbstractBiMap$Inverse(Map var1, AbstractBiMap var2) {
      super(var1, var2, (AbstractBiMap$1)null);
   }

   Object checkKey(Object var1) {
      return this.inverse.checkValue(var1);
   }

   Object checkValue(Object var1) {
      return this.inverse.checkKey(var1);
   }

   @GwtIncompatible("java.io.ObjectOuputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.inverse());
   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.setInverse((AbstractBiMap)var1.readObject());
   }

   @GwtIncompatible("Not needed in the emulated source.")
   Object readResolve() {
      return this.inverse().inverse();
   }

   // $FF: synthetic method
   AbstractBiMap$Inverse(Map var1, AbstractBiMap var2, AbstractBiMap$1 var3) {
      this(var1, var2);
   }
}
