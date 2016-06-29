package com.google.security.zynamics.bindiff.graph.labelcontent;

import com.google.security.zynamics.bindiff.enums.EPlaceholderType;
import com.google.security.zynamics.bindiff.graph.labelcontent.DiffLabelContent$1;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.PlaceholderObject;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.util.List;

public class DiffLabelContent extends ZyLabelContent {
   public DiffLabelContent(IZyEditableObject var1, boolean var2, boolean var3) {
      super(var1, var2, false);
   }

   public int getFirstLineIndexOfModelAt(int var1) {
      ZyLineContent var2 = this.getLineContent(var1);
      if(var2 != null) {
         IZyEditableObject var3 = var2.getLineObject();
         int var4 = var1;
         if(!var3.isPlaceholder()) {
            while(true) {
               --var4;
               if(var4 < 0) {
                  break;
               }

               IZyEditableObject var9 = ((ZyLineContent)this.getContent().get(var4)).getLineObject();
               if(((ZyLineContent)this.getContent().get(var4)).getLineObject() != var3 && (!var9.isPlaceholder() || ((PlaceholderObject)var9).getPlaceholderType() != EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT)) {
                  ++var4;
                  return var4;
               }
            }
         } else {
            EPlaceholderType var5 = ((PlaceholderObject)var3).getPlaceholderType();
            IZyEditableObject var6;
            switch(DiffLabelContent$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EPlaceholderType[var5.ordinal()]) {
            case 1:
               do {
                  --var4;
                  if(var4 <= 0) {
                     break;
                  }

                  var6 = ((ZyLineContent)this.getContent().get(var4)).getLineObject();
               } while(var6.isPlaceholder() && ((PlaceholderObject)var6).getPlaceholderType() == EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT);

               return var4 + 1;
            case 2:
               do {
                  --var4;
                  if(var4 <= 0) {
                     break;
                  }

                  var6 = ((ZyLineContent)this.getContent().get(var4)).getLineObject();
               } while(var6.isPlaceholder());

               var4 = super.getFirstLineIndexOfModelAt(var4);

               do {
                  --var4;
                  if(var4 <= 0) {
                     break;
                  }

                  var6 = ((ZyLineContent)this.getContent().get(var4)).getLineObject();
               } while(var6.isPlaceholder() && ((PlaceholderObject)var6).getPlaceholderType() == EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT);

               ++var4;
               return var4;
            case 3:
            case 4:
            case 5:
               boolean var10 = var5 == EPlaceholderType.UNMATCHED_INSTRUCTION || var5 == EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT;

               while(true) {
                  --var4;
                  if(var4 <= 0) {
                     break;
                  }

                  IZyEditableObject var7 = ((ZyLineContent)this.getContent().get(var4)).getLineObject();
                  if(!var7.isPlaceholder()) {
                     break;
                  }

                  EPlaceholderType var8 = ((PlaceholderObject)var7).getPlaceholderType();
                  if(var10) {
                     if(var8 == EPlaceholderType.UNMATCHED_INSTRUCTION || var8 == EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT) {
                        break;
                     }
                  } else {
                     var10 = var8 == EPlaceholderType.UNMATCHED_INSTRUCTION || var8 == EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT;
                  }
               }

               ++var4;
               return var4;
            case 6:
               do {
                  --var4;
                  if(var4 <= 0) {
                     return var1;
                  }

                  var6 = ((ZyLineContent)this.getContent().get(var4)).getLineObject();
               } while(var6.isPlaceholder() && ((PlaceholderObject)var6).getPlaceholderType() == EPlaceholderType.BASICBLOCK_COMMENT);

               if(var6.getPersistentModel() instanceof RawBasicBlock) {
                  return super.getFirstLineIndexOfModelAt(var4);
               }

               ++var4;
               return var4;
            }
         }
      }

      return var1;
   }

   public int getLastLineIndexOfModelAt(int var1) {
      List var2 = this.getContent();
      int var3 = var2.size();
      ZyLineContent var4 = this.getLineContent(var1);
      if(var4 == null) {
         return var1;
      } else {
         IZyEditableObject var5 = var4.getLineObject();
         int var6 = var1;
         if(var5.isPlaceholder()) {
            EPlaceholderType var11 = ((PlaceholderObject)var5).getPlaceholderType();
            IZyEditableObject var12;
            switch(DiffLabelContent$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EPlaceholderType[var11.ordinal()]) {
            case 1:
               do {
                  ++var6;
                  if(var6 >= var3) {
                     break;
                  }

                  var12 = ((ZyLineContent)this.getContent().get(var6)).getLineObject();
               } while(var12.isPlaceholder());

               var6 = super.getLastLineIndexOfModelAt(var6);

               while(true) {
                  ++var6;
                  if(var6 >= var3) {
                     break;
                  }

                  var12 = ((ZyLineContent)this.getContent().get(var6)).getLineObject();
                  if(!var12.isPlaceholder() || ((PlaceholderObject)var12).getPlaceholderType() != EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT) {
                     --var6;
                     break;
                  }
               }

               if(var6 >= var3) {
                  var6 = var3 - 1;
               }

               return var6;
            case 2:
               do {
                  ++var6;
                  if(var6 >= var3) {
                     break;
                  }

                  var12 = ((ZyLineContent)this.getContent().get(var6)).getLineObject();
               } while(var12.isPlaceholder() && ((PlaceholderObject)var12).getPlaceholderType() == EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT);

               return var3 - 1;
            case 3:
            case 4:
            case 5:
               boolean var8 = var11 == EPlaceholderType.UNMATCHED_INSTRUCTION || var11 == EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT;

               while(true) {
                  ++var6;
                  if(var6 >= var3) {
                     break;
                  }

                  IZyEditableObject var9 = ((ZyLineContent)this.getContent().get(var6)).getLineObject();
                  if(!var9.isPlaceholder()) {
                     break;
                  }

                  EPlaceholderType var10 = ((PlaceholderObject)var9).getPlaceholderType();
                  if(var8) {
                     if(var10 == EPlaceholderType.UNMATCHED_INSTRUCTION || var10 == EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT) {
                        break;
                     }
                  } else {
                     var8 = var10 == EPlaceholderType.UNMATCHED_INSTRUCTION || var10 == EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT;
                  }
               }

               --var6;
               return var6;
            case 6:
               return var3 - 1;
            }
         } else {
            while(true) {
               ++var6;
               if(var6 >= var3) {
                  break;
               }

               if(((ZyLineContent)var2.get(var6)).getLineObject() != var5) {
                  IZyEditableObject var7 = ((ZyLineContent)this.getContent().get(var6)).getLineObject();
                  if(!var7.isPlaceholder() || ((PlaceholderObject)var7).getPlaceholderType() != EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT) {
                     --var6;
                     return var6;
                  }
               }
            }
         }

         return var3 - 1;
      }
   }
}
