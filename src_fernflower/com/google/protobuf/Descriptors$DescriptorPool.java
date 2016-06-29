package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool$DescriptorIntPair;
import com.google.protobuf.Descriptors$DescriptorPool$PackageDescriptor;
import com.google.protobuf.Descriptors$DescriptorPool$SearchFilter;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

final class Descriptors$DescriptorPool {
   private final Set dependencies = new HashSet();
   private boolean allowUnknownDependencies;
   private final Map descriptorsByName = new HashMap();
   private final Map fieldsByNumber = new HashMap();
   private final Map enumValuesByNumber = new HashMap();
   // $FF: synthetic field
   static final boolean $assertionsDisabled = !Descriptors.class.desiredAssertionStatus();

   Descriptors$DescriptorPool(Descriptors$FileDescriptor[] var1, boolean var2) {
      this.allowUnknownDependencies = var2;

      for(int var3 = 0; var3 < var1.length; ++var3) {
         this.dependencies.add(var1[var3]);
         this.importPublicDependencies(var1[var3]);
      }

      Iterator var7 = this.dependencies.iterator();

      while(var7.hasNext()) {
         Descriptors$FileDescriptor var4 = (Descriptors$FileDescriptor)var7.next();

         try {
            this.addPackage(var4.getPackage(), var4);
         } catch (Descriptors$DescriptorValidationException var6) {
            if(!$assertionsDisabled) {
               throw new AssertionError();
            }
         }
      }

   }

   private void importPublicDependencies(Descriptors$FileDescriptor var1) {
      Iterator var2 = var1.getPublicDependencies().iterator();

      while(var2.hasNext()) {
         Descriptors$FileDescriptor var3 = (Descriptors$FileDescriptor)var2.next();
         if(this.dependencies.add(var3)) {
            this.importPublicDependencies(var3);
         }
      }

   }

   Descriptors$GenericDescriptor findSymbol(String var1) {
      return this.findSymbol(var1, Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS);
   }

   Descriptors$GenericDescriptor findSymbol(String var1, Descriptors$DescriptorPool$SearchFilter var2) {
      Descriptors$GenericDescriptor var3 = (Descriptors$GenericDescriptor)this.descriptorsByName.get(var1);
      if(var3 == null || var2 != Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS && (var2 != Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY || !this.isType(var3)) && (var2 != Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY || !this.isAggregate(var3))) {
         Iterator var4 = this.dependencies.iterator();

         do {
            do {
               if(!var4.hasNext()) {
                  return null;
               }

               Descriptors$FileDescriptor var5 = (Descriptors$FileDescriptor)var4.next();
               var3 = (Descriptors$GenericDescriptor)Descriptors$FileDescriptor.access$1400(var5).descriptorsByName.get(var1);
            } while(var3 == null);
         } while(var2 != Descriptors$DescriptorPool$SearchFilter.ALL_SYMBOLS && (var2 != Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY || !this.isType(var3)) && (var2 != Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY || !this.isAggregate(var3)));

         return var3;
      } else {
         return var3;
      }
   }

   boolean isType(Descriptors$GenericDescriptor var1) {
      return var1 instanceof Descriptors$Descriptor || var1 instanceof Descriptors$EnumDescriptor;
   }

   boolean isAggregate(Descriptors$GenericDescriptor var1) {
      return var1 instanceof Descriptors$Descriptor || var1 instanceof Descriptors$EnumDescriptor || var1 instanceof Descriptors$DescriptorPool$PackageDescriptor || var1 instanceof Descriptors$ServiceDescriptor;
   }

   Descriptors$GenericDescriptor lookupSymbol(String var1, Descriptors$GenericDescriptor var2, Descriptors$DescriptorPool$SearchFilter var3) {
      Descriptors$GenericDescriptor var4;
      String var5;
      if(var1.startsWith(".")) {
         var5 = var1.substring(1);
         var4 = this.findSymbol(var5, var3);
      } else {
         int var6 = var1.indexOf(46);
         String var7;
         if(var6 == -1) {
            var7 = var1;
         } else {
            var7 = var1.substring(0, var6);
         }

         StringBuilder var8 = new StringBuilder(var2.getFullName());

         while(true) {
            int var9 = var8.lastIndexOf(".");
            if(var9 == -1) {
               var5 = var1;
               var4 = this.findSymbol(var1, var3);
               break;
            }

            var8.setLength(var9 + 1);
            var8.append(var7);
            var4 = this.findSymbol(var8.toString(), Descriptors$DescriptorPool$SearchFilter.AGGREGATES_ONLY);
            if(var4 != null) {
               if(var6 != -1) {
                  var8.setLength(var9 + 1);
                  var8.append(var1);
                  var4 = this.findSymbol(var8.toString(), var3);
               }

               var5 = var8.toString();
               break;
            }

            var8.setLength(var9);
         }
      }

      if(var4 == null) {
         String var11;
         if(this.allowUnknownDependencies && var3 == Descriptors$DescriptorPool$SearchFilter.TYPES_ONLY) {
            Logger var10000 = Descriptors.access$100();
            var11 = String.valueOf(String.valueOf(var1));
            var10000.warning((new StringBuilder(87 + var11.length())).append("The descriptor for message type \"").append(var11).append("\" can not be found and a placeholder is created for it").toString());
            Descriptors$Descriptor var10 = new Descriptors$Descriptor(var5);
            this.dependencies.add(var10.getFile());
            return var10;
         } else {
            var11 = String.valueOf(String.valueOf(var1));
            throw new Descriptors$DescriptorValidationException(var2, (new StringBuilder(18 + var11.length())).append("\"").append(var11).append("\" is not defined.").toString(), (Descriptors$1)null);
         }
      } else {
         return var4;
      }
   }

   void addSymbol(Descriptors$GenericDescriptor var1) {
      validateSymbolName(var1);
      String var2 = var1.getFullName();
      int var3 = var2.lastIndexOf(46);
      Descriptors$GenericDescriptor var4 = (Descriptors$GenericDescriptor)this.descriptorsByName.put(var2, var1);
      if(var4 != null) {
         this.descriptorsByName.put(var2, var4);
         String var5;
         String var6;
         if(var1.getFile() == var4.getFile()) {
            if(var3 == -1) {
               var5 = String.valueOf(String.valueOf(var2));
               throw new Descriptors$DescriptorValidationException(var1, (new StringBuilder(22 + var5.length())).append("\"").append(var5).append("\" is already defined.").toString(), (Descriptors$1)null);
            } else {
               var5 = String.valueOf(String.valueOf(var2.substring(var3 + 1)));
               var6 = String.valueOf(String.valueOf(var2.substring(0, var3)));
               throw new Descriptors$DescriptorValidationException(var1, (new StringBuilder(28 + var5.length() + var6.length())).append("\"").append(var5).append("\" is already defined in \"").append(var6).append("\".").toString(), (Descriptors$1)null);
            }
         } else {
            var5 = String.valueOf(String.valueOf(var2));
            var6 = String.valueOf(String.valueOf(var4.getFile().getName()));
            throw new Descriptors$DescriptorValidationException(var1, (new StringBuilder(33 + var5.length() + var6.length())).append("\"").append(var5).append("\" is already defined in file \"").append(var6).append("\".").toString(), (Descriptors$1)null);
         }
      }
   }

   void addPackage(String var1, Descriptors$FileDescriptor var2) {
      int var3 = var1.lastIndexOf(46);
      String var4;
      if(var3 == -1) {
         var4 = var1;
      } else {
         this.addPackage(var1.substring(0, var3), var2);
         var4 = var1.substring(var3 + 1);
      }

      Descriptors$GenericDescriptor var5 = (Descriptors$GenericDescriptor)this.descriptorsByName.put(var1, new Descriptors$DescriptorPool$PackageDescriptor(var4, var1, var2));
      if(var5 != null) {
         this.descriptorsByName.put(var1, var5);
         if(!(var5 instanceof Descriptors$DescriptorPool$PackageDescriptor)) {
            String var6 = String.valueOf(String.valueOf(var4));
            String var7 = String.valueOf(String.valueOf(var5.getFile().getName()));
            throw new Descriptors$DescriptorValidationException(var2, (new StringBuilder(69 + var6.length() + var7.length())).append("\"").append(var6).append("\" is already defined (as something other than a ").append("package) in file \"").append(var7).append("\".").toString(), (Descriptors$1)null);
         }
      }

   }

   void addFieldByNumber(Descriptors$FieldDescriptor var1) {
      Descriptors$DescriptorPool$DescriptorIntPair var2 = new Descriptors$DescriptorPool$DescriptorIntPair(var1.getContainingType(), var1.getNumber());
      Descriptors$FieldDescriptor var3 = (Descriptors$FieldDescriptor)this.fieldsByNumber.put(var2, var1);
      if(var3 != null) {
         this.fieldsByNumber.put(var2, var3);
         int var4 = var1.getNumber();
         String var5 = String.valueOf(String.valueOf(var1.getContainingType().getFullName()));
         String var6 = String.valueOf(String.valueOf(var3.getName()));
         throw new Descriptors$DescriptorValidationException(var1, (new StringBuilder(65 + var5.length() + var6.length())).append("Field number ").append(var4).append(" has already been used in \"").append(var5).append("\" by field \"").append(var6).append("\".").toString(), (Descriptors$1)null);
      }
   }

   void addEnumValueByNumber(Descriptors$EnumValueDescriptor var1) {
      Descriptors$DescriptorPool$DescriptorIntPair var2 = new Descriptors$DescriptorPool$DescriptorIntPair(var1.getType(), var1.getNumber());
      Descriptors$EnumValueDescriptor var3 = (Descriptors$EnumValueDescriptor)this.enumValuesByNumber.put(var2, var1);
      if(var3 != null) {
         this.enumValuesByNumber.put(var2, var3);
      }

   }

   static void validateSymbolName(Descriptors$GenericDescriptor var0) {
      String var1 = var0.getName();
      if(var1.length() == 0) {
         throw new Descriptors$DescriptorValidationException(var0, "Missing name.", (Descriptors$1)null);
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < var1.length(); ++var3) {
            char var4 = var1.charAt(var3);
            if(var4 >= 128) {
               var2 = false;
            }

            if(!Character.isLetter(var4) && var4 != 95 && (!Character.isDigit(var4) || var3 <= 0)) {
               var2 = false;
            }
         }

         if(!var2) {
            String var5 = String.valueOf(String.valueOf(var1));
            throw new Descriptors$DescriptorValidationException(var0, (new StringBuilder(29 + var5.length())).append("\"").append(var5).append("\" is not a valid identifier.").toString(), (Descriptors$1)null);
         }
      }
   }

   // $FF: synthetic method
   static Map access$1500(Descriptors$DescriptorPool var0) {
      return var0.fieldsByNumber;
   }

   // $FF: synthetic method
   static Map access$2300(Descriptors$DescriptorPool var0) {
      return var0.enumValuesByNumber;
   }
}
