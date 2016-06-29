package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.Serializable;

final class GeneratedMessageLite$SerializedForm implements Serializable {
   private static final long serialVersionUID = 0L;
   private final String messageClassName;
   private final byte[] asBytes;

   GeneratedMessageLite$SerializedForm(MessageLite var1) {
      this.messageClassName = var1.getClass().getName();
      this.asBytes = var1.toByteArray();
   }

   protected Object readResolve() {
      try {
         Class var1 = Class.forName(this.messageClassName);
         Parser var2 = (Parser)var1.getField("PARSER").get((Object)null);
         return var2.parsePartialFrom(this.asBytes);
      } catch (ClassNotFoundException var3) {
         throw new RuntimeException("Unable to find proto buffer class", var3);
      } catch (NoSuchFieldException var4) {
         throw new RuntimeException("Unable to find PARSER", var4);
      } catch (SecurityException var5) {
         throw new RuntimeException("Unable to call PARSER", var5);
      } catch (IllegalAccessException var6) {
         throw new RuntimeException("Unable to call parseFrom method", var6);
      } catch (InvalidProtocolBufferException var7) {
         throw new RuntimeException("Unable to understand proto buffer", var7);
      }
   }
}
