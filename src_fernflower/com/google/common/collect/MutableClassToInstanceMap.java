package com.google.common.collect;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedMap;
import com.google.common.collect.MutableClassToInstanceMap$1;
import com.google.common.primitives.Primitives;
import java.util.HashMap;
import java.util.Map;

public final class MutableClassToInstanceMap extends MapConstraints$ConstrainedMap implements ClassToInstanceMap {
   private static final MapConstraint VALUE_CAN_BE_CAST_TO_KEY = new MutableClassToInstanceMap$1();
   private static final long serialVersionUID = 0L;

   public static MutableClassToInstanceMap create() {
      return new MutableClassToInstanceMap(new HashMap());
   }

   public static MutableClassToInstanceMap create(Map var0) {
      return new MutableClassToInstanceMap(var0);
   }

   private MutableClassToInstanceMap(Map var1) {
      super(var1, VALUE_CAN_BE_CAST_TO_KEY);
   }

   public Object putInstance(Class var1, Object var2) {
      return cast(var1, this.put(var1, var2));
   }

   public Object getInstance(Class var1) {
      return cast(var1, this.get(var1));
   }

   private static Object cast(Class var0, Object var1) {
      return Primitives.wrap(var0).cast(var1);
   }

   // $FF: synthetic method
   static Object access$000(Class var0, Object var1) {
      return cast(var0, var1);
   }
}
