package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$MapFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$OneofAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor;

public final class GeneratedMessage$FieldAccessorTable {
   private final Descriptors$Descriptor descriptor;
   private final GeneratedMessage$FieldAccessorTable$FieldAccessor[] fields;
   private String[] camelCaseNames;
   private final GeneratedMessage$FieldAccessorTable$OneofAccessor[] oneofs;
   private volatile boolean initialized;

   public GeneratedMessage$FieldAccessorTable(Descriptors$Descriptor var1, String[] var2, Class var3, Class var4) {
      this(var1, var2);
      this.ensureFieldAccessorsInitialized(var3, var4);
   }

   public GeneratedMessage$FieldAccessorTable(Descriptors$Descriptor var1, String[] var2) {
      this.descriptor = var1;
      this.camelCaseNames = var2;
      this.fields = new GeneratedMessage$FieldAccessorTable$FieldAccessor[var1.getFields().size()];
      this.oneofs = new GeneratedMessage$FieldAccessorTable$OneofAccessor[var1.getOneofs().size()];
      this.initialized = false;
   }

   private boolean isMapFieldEnabled(Descriptors$FieldDescriptor var1) {
      boolean var2 = true;
      return var2;
   }

   public GeneratedMessage$FieldAccessorTable ensureFieldAccessorsInitialized(Class var1, Class var2) {
      if(this.initialized) {
         return this;
      } else {
         synchronized(this) {
            if(this.initialized) {
               return this;
            } else {
               int var4 = this.fields.length;

               int var5;
               for(var5 = 0; var5 < var4; ++var5) {
                  Descriptors$FieldDescriptor var6 = (Descriptors$FieldDescriptor)this.descriptor.getFields().get(var5);
                  String var7 = null;
                  if(var6.getContainingOneof() != null) {
                     var7 = this.camelCaseNames[var4 + var6.getContainingOneof().getIndex()];
                  }

                  if(var6.isRepeated()) {
                     if(var6.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                        if(var6.isMapField() && this.isMapFieldEnabled(var6)) {
                           this.fields[var5] = new GeneratedMessage$FieldAccessorTable$MapFieldAccessor(var6, this.camelCaseNames[var5], var1, var2);
                        } else {
                           this.fields[var5] = new GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor(var6, this.camelCaseNames[var5], var1, var2);
                        }
                     } else if(var6.getJavaType() == Descriptors$FieldDescriptor$JavaType.ENUM) {
                        this.fields[var5] = new GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor(var6, this.camelCaseNames[var5], var1, var2);
                     } else {
                        this.fields[var5] = new GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor(var6, this.camelCaseNames[var5], var1, var2);
                     }
                  } else if(var6.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                     this.fields[var5] = new GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor(var6, this.camelCaseNames[var5], var1, var2, var7);
                  } else if(var6.getJavaType() == Descriptors$FieldDescriptor$JavaType.ENUM) {
                     this.fields[var5] = new GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor(var6, this.camelCaseNames[var5], var1, var2, var7);
                  } else if(var6.getJavaType() == Descriptors$FieldDescriptor$JavaType.STRING) {
                     this.fields[var5] = new GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor(var6, this.camelCaseNames[var5], var1, var2, var7);
                  } else {
                     this.fields[var5] = new GeneratedMessage$FieldAccessorTable$SingularFieldAccessor(var6, this.camelCaseNames[var5], var1, var2, var7);
                  }
               }

               var5 = this.oneofs.length;

               for(int var10 = 0; var10 < var5; ++var10) {
                  this.oneofs[var10] = new GeneratedMessage$FieldAccessorTable$OneofAccessor(this.descriptor, this.camelCaseNames[var10 + var4], var1, var2);
               }

               this.initialized = true;
               this.camelCaseNames = null;
               return this;
            }
         }
      }
   }

   private GeneratedMessage$FieldAccessorTable$FieldAccessor getField(Descriptors$FieldDescriptor var1) {
      if(var1.getContainingType() != this.descriptor) {
         throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      } else if(var1.isExtension()) {
         throw new IllegalArgumentException("This type does not have extensions.");
      } else {
         return this.fields[var1.getIndex()];
      }
   }

   private GeneratedMessage$FieldAccessorTable$OneofAccessor getOneof(Descriptors$OneofDescriptor var1) {
      if(var1.getContainingType() != this.descriptor) {
         throw new IllegalArgumentException("OneofDescriptor does not match message type.");
      } else {
         return this.oneofs[var1.getIndex()];
      }
   }

   private static boolean supportFieldPresence(Descriptors$FileDescriptor var0) {
      return var0.getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO2;
   }

   // $FF: synthetic method
   static Descriptors$Descriptor access$000(GeneratedMessage$FieldAccessorTable var0) {
      return var0.descriptor;
   }

   // $FF: synthetic method
   static GeneratedMessage$FieldAccessorTable$OneofAccessor access$100(GeneratedMessage$FieldAccessorTable var0, Descriptors$OneofDescriptor var1) {
      return var0.getOneof(var1);
   }

   // $FF: synthetic method
   static GeneratedMessage$FieldAccessorTable$FieldAccessor access$200(GeneratedMessage$FieldAccessorTable var0, Descriptors$FieldDescriptor var1) {
      return var0.getField(var1);
   }

   // $FF: synthetic method
   static boolean access$1300(Descriptors$FileDescriptor var0) {
      return supportFieldPresence(var0);
   }
}
