package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import java.util.logging.Logger;

public final class Descriptors {
   private static final Logger logger = Logger.getLogger(Descriptors.class.getName());

   private static String computeFullName(Descriptors$FileDescriptor var0, Descriptors$Descriptor var1, String var2) {
      String var3;
      String var4;
      if(var1 != null) {
         var3 = String.valueOf(String.valueOf(var1.getFullName()));
         var4 = String.valueOf(String.valueOf(var2));
         return (new StringBuilder(1 + var3.length() + var4.length())).append(var3).append(".").append(var4).toString();
      } else if(var0.getPackage().length() > 0) {
         var3 = String.valueOf(String.valueOf(var0.getPackage()));
         var4 = String.valueOf(String.valueOf(var2));
         return (new StringBuilder(1 + var3.length() + var4.length())).append(var3).append(".").append(var4).toString();
      } else {
         return var2;
      }
   }

   // $FF: synthetic method
   static Logger access$100() {
      return logger;
   }

   // $FF: synthetic method
   static String access$1600(Descriptors$FileDescriptor var0, Descriptors$Descriptor var1, String var2) {
      return computeFullName(var0, var1, var2);
   }
}
