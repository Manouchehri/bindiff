package com.google.protobuf;

import com.google.protobuf.ExtensionLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneratedMessageLite$GeneratedExtension extends ExtensionLite {
   final MessageLite containingTypeDefaultInstance;
   final Object defaultValue;
   final MessageLite messageDefaultInstance;
   final GeneratedMessageLite$ExtensionDescriptor descriptor;
   final Class singularType;
   final java.lang.reflect.Method enumValueOf;

   GeneratedMessageLite$GeneratedExtension(MessageLite var1, Object var2, MessageLite var3, GeneratedMessageLite$ExtensionDescriptor var4, Class var5) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null containingTypeDefaultInstance");
      } else if(var4.getLiteType() == WireFormat$FieldType.MESSAGE && var3 == null) {
         throw new IllegalArgumentException("Null messageDefaultInstance");
      } else {
         this.containingTypeDefaultInstance = var1;
         this.defaultValue = var2;
         this.messageDefaultInstance = var3;
         this.descriptor = var4;
         this.singularType = var5;
         if(Internal$EnumLite.class.isAssignableFrom(var5)) {
            this.enumValueOf = GeneratedMessageLite.getMethodOrDie(var5, "valueOf", new Class[]{Integer.TYPE});
         } else {
            this.enumValueOf = null;
         }

      }
   }

   public MessageLite getContainingTypeDefaultInstance() {
      return this.containingTypeDefaultInstance;
   }

   public int getNumber() {
      return this.descriptor.getNumber();
   }

   public MessageLite getMessageDefaultInstance() {
      return this.messageDefaultInstance;
   }

   Object fromFieldSetType(Object var1) {
      if(!this.descriptor.isRepeated()) {
         return this.singularFromFieldSetType(var1);
      } else if(this.descriptor.getLiteJavaType() != WireFormat$JavaType.ENUM) {
         return var1;
      } else {
         ArrayList var2 = new ArrayList();
         Iterator var3 = ((List)var1).iterator();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            var2.add(this.singularFromFieldSetType(var4));
         }

         return var2;
      }
   }

   Object singularFromFieldSetType(Object var1) {
      return this.descriptor.getLiteJavaType() == WireFormat$JavaType.ENUM?GeneratedMessageLite.invokeOrDie(this.enumValueOf, (Object)null, new Object[]{(Integer)var1}):var1;
   }

   Object toFieldSetType(Object var1) {
      if(!this.descriptor.isRepeated()) {
         return this.singularToFieldSetType(var1);
      } else if(this.descriptor.getLiteJavaType() != WireFormat$JavaType.ENUM) {
         return var1;
      } else {
         ArrayList var2 = new ArrayList();
         Iterator var3 = ((List)var1).iterator();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            var2.add(this.singularToFieldSetType(var4));
         }

         return var2;
      }
   }

   Object singularToFieldSetType(Object var1) {
      return this.descriptor.getLiteJavaType() == WireFormat$JavaType.ENUM?Integer.valueOf(((Internal$EnumLite)var1).getNumber()):var1;
   }

   public WireFormat$FieldType getLiteType() {
      return this.descriptor.getLiteType();
   }

   public boolean isRepeated() {
      return this.descriptor.isRepeated;
   }

   public Object getDefaultValue() {
      return this.defaultValue;
   }
}
