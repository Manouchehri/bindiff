package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UninitializedMessageException extends RuntimeException {
   private static final long serialVersionUID = -7466929953374883507L;
   private final List missingFields;

   public UninitializedMessageException(MessageLite var1) {
      super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
      this.missingFields = null;
   }

   public UninitializedMessageException(List var1) {
      super(buildDescription(var1));
      this.missingFields = var1;
   }

   public List getMissingFields() {
      return Collections.unmodifiableList(this.missingFields);
   }

   public InvalidProtocolBufferException asInvalidProtocolBufferException() {
      return new InvalidProtocolBufferException(this.getMessage());
   }

   private static String buildDescription(List var0) {
      StringBuilder var1 = new StringBuilder("Message missing required fields: ");
      boolean var2 = true;

      String var4;
      for(Iterator var3 = var0.iterator(); var3.hasNext(); var1.append(var4)) {
         var4 = (String)var3.next();
         if(var2) {
            var2 = false;
         } else {
            var1.append(", ");
         }
      }

      return var1.toString();
   }
}
