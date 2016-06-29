package com.google.protobuf;

import com.google.protobuf.TextFormat$1;
import com.google.protobuf.TextFormat$Parser;
import com.google.protobuf.TextFormat$Parser$SingularOverwritePolicy;

public class TextFormat$Parser$Builder {
   private boolean allowUnknownFields = false;
   private TextFormat$Parser$SingularOverwritePolicy singularOverwritePolicy;

   public TextFormat$Parser$Builder() {
      this.singularOverwritePolicy = TextFormat$Parser$SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
   }

   public TextFormat$Parser$Builder setSingularOverwritePolicy(TextFormat$Parser$SingularOverwritePolicy var1) {
      this.singularOverwritePolicy = var1;
      return this;
   }

   public TextFormat$Parser build() {
      return new TextFormat$Parser(this.allowUnknownFields, this.singularOverwritePolicy, (TextFormat$1)null);
   }
}
