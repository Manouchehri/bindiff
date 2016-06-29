package com.google.protobuf;

import com.google.protobuf.Extension$ExtensionType;

// $FF: synthetic class
class ExtensionRegistry$1 {
   // $FF: synthetic field
   static final int[] $SwitchMap$com$google$protobuf$Extension$ExtensionType = new int[Extension$ExtensionType.values().length];

   static {
      try {
         $SwitchMap$com$google$protobuf$Extension$ExtensionType[Extension$ExtensionType.IMMUTABLE.ordinal()] = 1;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         $SwitchMap$com$google$protobuf$Extension$ExtensionType[Extension$ExtensionType.MUTABLE.ordinal()] = 2;
      } catch (NoSuchFieldError var1) {
         ;
      }

   }
}
