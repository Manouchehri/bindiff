package com.google.security.zynamics.bindiff.graph.builders;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.security.zynamics.bindiff.enums.EInstructionHighlighting;
import com.google.security.zynamics.bindiff.enums.EPlaceholderType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.builders.ViewCodeNodeBuilder$1;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.BasicBlockHeadLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.BasicBlockLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.CInstructionCommentLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.InstructionCommentDelimiterLineObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.InstructionObject;
import com.google.security.zynamics.bindiff.graph.labelcontent.editableline.PlaceholderObject;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.InstructionMatchData;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstructionComment;
import com.google.security.zynamics.bindiff.resources.Fonts;
import com.google.security.zynamics.bindiff.types.AddressPairComparator;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.CStyleRunData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.Tokenizer.CMultiCommentLineTokenizer;
import com.google.security.zynamics.zylib.strings.StringHelper;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class ViewCodeNodeBuilder {
   private static final String ABOVE_INSTRUCTION_COMMENT_ESCAPE_STRING = "// ";
   private static final String BEHIND_INSTRUCTION_COMMNET_ESCAPE_STRING = " // ";
   private static final String BASICBLOCK_COMMENT_HEADLINE_STRING = "// Basic Block Commment: ";
   private static final String BASICBLOCK_COMMENT_ESCAPE_STRING = "// ";
   public static final int MAX_MNEMONIC_SIZE = 12;
   private static final String PADDING_AFTER_ADDRESS = "   ";
   private static final String PADDING_AFTER_FUNCTION_ADDRESS = "   ";
   private static final PlaceholderObject PLACEHOLDER_MATCHED_ABOVE_INSTRUCTION_COMMENT;
   private static final PlaceholderObject PLACEHOLDER_MATCHED_BEHIND_INSTRUCTION_COMMENT;
   private static final PlaceholderObject PLACEHOLDER_UNMATCHED_ABOVE_INSTRUCTION_COMMENT;
   private static final PlaceholderObject PLACEHOLDER_UNMATCHED_INSTRUCTION;
   private static final PlaceholderObject PLACEHOLDER_UNMATCHED_BEHIND_INSTRUCTION_COMMENT;
   private static final PlaceholderObject PLACEHOLDER_BASICBLOCK_COMMENT;

   private static void buildAddress(RawInstruction var0, StringBuffer var1, List var2) {
      // $FF: Couldn't be decompiled
   }

   private static void buildBasicblockComments(RawBasicBlock var0, RawBasicBlock var1, ZyLabelContent var2, ESide var3) {
      int var4 = 0;
      if(var0 != null) {
         var4 = StringHelper.count(var0.getComment(), '\n');
      }

      if(var1 != null) {
         var4 = Math.max(var4, StringHelper.count(var1.getComment(), '\n'));
      }

      RawBasicBlock var5 = var3 == ESide.PRIMARY?var0:var1;
      Iterator var6 = buildBasicblockComment(var5, var4).iterator();

      while(var6.hasNext()) {
         ZyLineContent var7 = (ZyLineContent)var6.next();
         var2.addLineContent(var7);
      }

   }

   private static void buildMatchedCodeNodeContent(RawBasicBlock var0, RawBasicBlock var1, List var2, ZyLabelContent var3, ESide var4) {
      ArrayList var5 = new ArrayList();
      int var6;
      Iterator var7;
      Pair var8;
      RawInstruction var9;
      RawInstruction var10;
      int var11;
      int var12;
      if(var4 == ESide.PRIMARY) {
         var3.addLineContent(buildHeadline(var0));
         var6 = var0.getMaxOperandLength();
         var7 = var2.iterator();

         while(var7.hasNext()) {
            var8 = (Pair)var7.next();
            var9 = null;
            if(var0 != null && var8.first() != null) {
               var9 = var0.getInstruction((IAddress)var8.first());
            }

            var10 = null;
            if(var1 != null && var8.second() != null) {
               var10 = var1.getInstruction((IAddress)var8.second());
            }

            var11 = precalcMaxCommentLineCount(var9, var10, ECommentPlacement.ABOVE_LINE);
            var12 = precalcMaxCommentLineCount(var9, var10, ECommentPlacement.BEHIND_LINE);
            var5.addAll(buildInstruction(var9, var6, var8.second() == null, var4, var11, var12));
         }
      } else {
         var3.addLineContent(buildHeadline(var1));
         var6 = var1.getMaxOperandLength();
         var7 = var2.iterator();

         while(var7.hasNext()) {
            var8 = (Pair)var7.next();
            var9 = null;
            if(var0 != null && var8.first() != null) {
               var9 = var0.getInstruction((IAddress)var8.first());
            }

            var10 = null;
            if(var1 != null && var8.second() != null) {
               var10 = var1.getInstruction((IAddress)var8.second());
            }

            var11 = precalcMaxCommentLineCount(var9, var10, ECommentPlacement.ABOVE_LINE);
            var12 = precalcMaxCommentLineCount(var9, var10, ECommentPlacement.BEHIND_LINE);
            var5.addAll(buildInstruction(var10, var6, var8.first() == null, var4, var11, var12));
         }
      }

      Iterator var13 = var5.iterator();

      while(var13.hasNext()) {
         ZyLineContent var14 = (ZyLineContent)var13.next();
         var3.addLineContent(var14);
      }

      buildBasicblockComments(var0, var1, var3, var4);
   }

   private static void buildMnemonic(RawInstruction var0, StringBuffer var1, List var2) {
      if(var0.getMnemonic().length() != 0) {
         String var3 = var0.getMnemonic();
         if(var0.getOperands().length > 0) {
            var3 = Strings.padEnd(var0.getMnemonic(), var0.getMaxMnemonicLen(), ' ');
         }

         Color var4 = EInstructionHighlighting.getColor(EInstructionHighlighting.TYPE_MNEMONIC);
         var2.add(new CStyleRunData(var1.length(), var3.length(), var4));
         var1.append(var3);
      }
   }

   private static boolean appendStyleRunData(ByteArrayOutputStream var0, Color var1, StringBuffer var2, List var3) {
      if(var0 != null && var1 != null) {
         if(var0.size() != 0) {
            String var4 = var0.toString();
            var3.add(new CStyleRunData(var2.length(), var4.length(), var1));
            var2.append(var4);

            try {
               var0.close();
            } catch (IOException var6) {
               Logger.logWarning("Couldn\'t close ByteArrayOutputStream.", new Object[0]);
            }

            return true;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   private static void buildOperands(RawInstruction var0, StringBuffer var1, List var2) {
      byte[] var3 = var0.getOperands();
      ByteArrayOutputStream var4 = null;
      Color var5 = null;

      for(int var6 = 0; var6 < var3.length; ++var6) {
         if(var3[var6] < EInstructionHighlighting.getSize() && var3[var6] > 0) {
            if(appendStyleRunData(var4, var5, var1, var2)) {
               var4 = new ByteArrayOutputStream();
               byte var7 = var3[var6];
               var5 = EInstructionHighlighting.getColor(var7);
            }
         } else {
            var4.write(var3[var6]);
         }
      }

      appendStyleRunData(var4, var5, var1, var2);
   }

   private static List buildRightComment(RawInstruction var0, InstructionObject var1, RawInstructionComment var2, StringBuffer var3, List var4, int var5, boolean var6, ESide var7, int var8) {
      // $FF: Couldn't be decompiled
   }

   private static List buildTopComment(RawInstruction var0, InstructionObject var1, RawInstructionComment var2, int var3) {
      // $FF: Couldn't be decompiled
   }

   private static void buildUnmatchedCodeNodeContent(RawBasicBlock var0, ZyLabelContent var1) {
      var1.addLineContent(buildHeadline(var0));
      ArrayList var2 = new ArrayList();
      int var3 = var0.getMaxOperandLength();
      Iterator var4 = var0.iterator();

      while(var4.hasNext()) {
         RawInstruction var5 = (RawInstruction)var4.next();
         var2.addAll(buildInstruction(var5, var3, false, (ESide)null, 0, 0));
      }

      var4 = var2.iterator();

      while(var4.hasNext()) {
         ZyLineContent var6 = (ZyLineContent)var4.next();
         var1.addLineContent(var6);
      }

      buildBasicblockComments(var0.getSide() == ESide.PRIMARY?var0:null, var0.getSide() == ESide.SECONDARY?var0:null, var1, var0.getSide());
   }

   private static List getMatchedFunctionsBasicblockInstructionAddressPairs(FunctionMatchData var0, RawCombinedFlowGraph var1, IAddress var2, IAddress var3) {
      ArrayList var4 = new ArrayList();
      RawFlowGraph var5 = var1.getPrimaryFlowgraph();
      RawFlowGraph var6 = var1.getSecondaryFlowgraph();
      if(var2 != null && var3 != null) {
         BasicBlockMatchData var12 = var0.getBasicblockMatch(var2, ESide.PRIMARY);
         InstructionMatchData[] var13 = var12.getInstructionMatches();
         int var15 = var13.length;

         for(int var10 = 0; var10 < var15; ++var10) {
            InstructionMatchData var11 = var13[var10];
            var4.add(new Pair(var11.getIAddress(ESide.PRIMARY), var11.getIAddress(ESide.SECONDARY)));
         }

         RawBasicBlock var14 = var5.getBasicblock(var2);
         Iterator var16 = var14.getInstructions().entrySet().iterator();

         while(var16.hasNext()) {
            Entry var18 = (Entry)var16.next();
            if(var12.getInstructionMatch((IAddress)var18.getKey(), ESide.PRIMARY) == null) {
               var4.add(new Pair(var18.getKey(), (Object)null));
            }
         }

         RawBasicBlock var17 = var6.getBasicblock(var3);
         Iterator var19 = var17.getInstructions().entrySet().iterator();

         while(var19.hasNext()) {
            Entry var20 = (Entry)var19.next();
            if(var12.getInstructionMatch((IAddress)var20.getKey(), ESide.SECONDARY) == null) {
               var4.add(new Pair((Object)null, var20.getKey()));
            }
         }
      } else {
         RawBasicBlock var7;
         Iterator var8;
         Entry var9;
         if(var2 != null) {
            var7 = var5.getBasicblock(var2);
            var8 = var7.getInstructions().entrySet().iterator();

            while(var8.hasNext()) {
               var9 = (Entry)var8.next();
               var4.add(new Pair(var9.getKey(), (Object)null));
            }
         } else if(var3 != null) {
            var7 = var6.getBasicblock(var3);
            var8 = var7.getInstructions().entrySet().iterator();

            while(var8.hasNext()) {
               var9 = (Entry)var8.next();
               var4.add(new Pair((Object)null, var9.getKey()));
            }
         }
      }

      return var4;
   }

   private static List getMatchedFunctionsBasicblockInstructionAddressPairs(FunctionMatchData var0, RawCombinedFlowGraph var1, IAddress var2, IAddress var3, ESide var4) {
      ArrayList var5 = new ArrayList(getMatchedFunctionsBasicblockInstructionAddressPairs(var0, var1, var2, var3));
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();
      Iterator var8 = var5.iterator();

      while(var8.hasNext()) {
         Pair var9 = (Pair)var8.next();
         if(ESide.SECONDARY == var4) {
            var9 = new Pair(var9.second(), var9.first());
         }

         if(var9.first() != null) {
            var6.add(var9);
         }

         if(var9.second() != null) {
            var7.add(var9);
         }
      }

      Collections.sort(var6, new AddressPairComparator(ESide.PRIMARY));
      Collections.sort(var7, new AddressPairComparator(ESide.SECONDARY));
      var5.clear();
      if(var6.size() == 0) {
         var5 = var7;
      }

      if(var7.size() == 0) {
         var5 = var6;
      }

      Pair var12;
      if(var6.size() != 0 && var7.size() != 0) {
         int var13 = 0;
         Iterator var15 = var6.iterator();

         label83:
         while(true) {
            while(true) {
               if(!var15.hasNext()) {
                  break label83;
               }

               Pair var10 = (Pair)var15.next();
               if(var10.second() == null) {
                  var5.add(var10);
               } else if(var13 < var7.size()) {
                  boolean var11 = true;

                  while(var11) {
                     var12 = (Pair)var7.get(var13);
                     if(var12.first() == null) {
                        var5.add(var12);
                     } else {
                        var11 = false;
                     }

                     ++var13;
                     if(var13 >= var7.size()) {
                        var11 = false;
                     }
                  }

                  var5.add(var10);
               }
            }
         }
      }

      ArrayList var14 = new ArrayList();
      int var16 = var7.size();

      while(var16 > 0) {
         --var16;
         if(((Pair)var7.get(var16)).first() != null) {
            break;
         }

         var14.add(var7.get(var16));
      }

      Collections.sort(var14, new AddressPairComparator(ESide.SECONDARY));
      var5.addAll(var14);
      ArrayList var17 = var5;
      if(ESide.SECONDARY == var4) {
         var5.clear();
         Iterator var18 = var5.iterator();

         while(var18.hasNext()) {
            var12 = (Pair)var18.next();
            var17.add(new Pair(var12.second(), var12.first()));
         }
      }

      return var17;
   }

   public static List buildBasicblockComment(RawBasicBlock var0, int var1) {
      // $FF: Couldn't be decompiled
   }

   public static ZyLineContent buildHeadline(RawBasicBlock var0) {
      String var1 = String.format("%s%s%s", new Object[]{var0.getFunctionAddr().toHexString(), "   ", var0.getFunctionName()});
      BasicBlockHeadLineObject var2 = new BasicBlockHeadLineObject(var0);
      ZyLineContent var3 = new ZyLineContent(var1, Fonts.BOLD_FONT, Lists.newArrayList((Object[])(new CStyleRunData[]{new CStyleRunData(0, -1, Color.BLACK)})), var2);
      return var3;
   }

   public static List buildInstruction(RawInstruction var0, int var1, boolean var2, ESide var3, int var4, int var5) {
      ArrayList var6 = new ArrayList();
      StringBuffer var7 = new StringBuffer();
      ArrayList var8 = new ArrayList();
      if(var0 != null) {
         RawInstructionComment var9 = null;
         RawInstructionComment var10 = null;
         if(var0.hasComments()) {
            Iterator var11 = var0.getComments().iterator();

            while(var11.hasNext()) {
               RawInstructionComment var12 = (RawInstructionComment)var11.next();
               if(var12.getPlacement() == ECommentPlacement.ABOVE_LINE) {
                  var9 = var12;
               } else if(var12.getPlacement() == ECommentPlacement.BEHIND_LINE) {
                  var10 = var12;
               }
            }
         }

         buildAddress(var0, var7, var8);
         buildMnemonic(var0, var7, var8);
         buildOperands(var0, var7, var8);
         InstructionObject var13 = new InstructionObject(var0, 0, var7.length());
         var6.addAll(buildTopComment(var0, var13, var9, var4));
         var6.addAll(buildRightComment(var0, var13, var10, var7, var8, var1, var2, var3, var5));
      } else {
         var6.addAll(buildPlaceholderLines(var4, EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT));
         var6.addAll(buildPlaceholderLines(1, EPlaceholderType.UNMATCHED_INSTRUCTION));
         var6.addAll(buildPlaceholderLines(var5 - 1, EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT));
      }

      return var6;
   }

   public static List buildPlaceholderLines(int var0, EPlaceholderType var1) {
      ArrayList var2 = new ArrayList();
      PlaceholderObject var3 = null;
      switch(ViewCodeNodeBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EPlaceholderType[var1.ordinal()]) {
      case 1:
         var3 = PLACEHOLDER_MATCHED_ABOVE_INSTRUCTION_COMMENT;
         break;
      case 2:
         var3 = PLACEHOLDER_MATCHED_BEHIND_INSTRUCTION_COMMENT;
         break;
      case 3:
         var3 = PLACEHOLDER_UNMATCHED_ABOVE_INSTRUCTION_COMMENT;
         break;
      case 4:
         var3 = PLACEHOLDER_UNMATCHED_INSTRUCTION;
         break;
      case 5:
         var3 = PLACEHOLDER_UNMATCHED_BEHIND_INSTRUCTION_COMMENT;
         break;
      case 6:
         var3 = PLACEHOLDER_BASICBLOCK_COMMENT;
      }

      for(int var4 = 0; var4 < var0; ++var4) {
         ZyLineContent var5 = new ZyLineContent("\t", Fonts.NORMAL_FONT, var3);
         var2.add(var5);
      }

      return var2;
   }

   public static void buildSingleCodeNodeContent(FunctionMatchData var0, RawCombinedFlowGraph var1, RawCombinedBasicBlock var2, ZyLabelContent var3, ESide var4) {
      RawBasicBlock var5 = var2.getRawNode(ESide.PRIMARY);
      RawBasicBlock var6 = var2.getRawNode(ESide.SECONDARY);
      if(var4 == ESide.PRIMARY) {
         if(var6 == null) {
            buildUnmatchedCodeNodeContent(var5, var3);
            return;
         }
      } else if(var5 == null) {
         buildUnmatchedCodeNodeContent(var6, var3);
         return;
      }

      IAddress var8 = var2.getAddress(ESide.PRIMARY);
      IAddress var9 = var2.getAddress(ESide.SECONDARY);
      List var7 = getMatchedFunctionsBasicblockInstructionAddressPairs(var0, var1, var8, var9, ESide.PRIMARY);
      RawBasicBlock var10 = var1.getPrimaryFlowgraph().getBasicblock(var8);
      RawBasicBlock var11 = var1.getSecondaryFlowgraph().getBasicblock(var9);
      buildMatchedCodeNodeContent(var10, var11, var7, var3, var4);
   }

   public static int precalcMaxCommentLineCount(RawInstruction var0, RawInstruction var1, ECommentPlacement var2) {
      int var3 = var2 == ECommentPlacement.BEHIND_LINE?1:0;
      int var4 = var2 == ECommentPlacement.BEHIND_LINE?1:0;
      Iterator var5;
      RawInstructionComment var6;
      if(var0 != null && var0.hasComments()) {
         var5 = var0.getComments().iterator();

         while(var5.hasNext()) {
            var6 = (RawInstructionComment)var5.next();
            if(var6.getPlacement() == var2 && !var6.getText().isEmpty()) {
               var3 = StringHelper.count(var6.getText(), '\n') + 1;
            }
         }
      }

      if(var1 != null && var1.getComments() != null) {
         var5 = var1.getComments().iterator();

         while(var5.hasNext()) {
            var6 = (RawInstructionComment)var5.next();
            if(var6.getPlacement() == var2 && !var6.getText().isEmpty()) {
               var4 = StringHelper.count(var6.getText(), '\n') + 1;
            }
         }
      }

      return Math.max(var3, var4);
   }

   static {
      PLACEHOLDER_MATCHED_ABOVE_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.MATCHED_ABOVE_INSTRUCTION_COMMENT);
      PLACEHOLDER_MATCHED_BEHIND_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.MATCHED_BEHIND_INSTRUCTION_COMMENT);
      PLACEHOLDER_UNMATCHED_ABOVE_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.UNMATCHED_ABOVE_INSTRUCTION_COMMENT);
      PLACEHOLDER_UNMATCHED_INSTRUCTION = new PlaceholderObject(EPlaceholderType.UNMATCHED_INSTRUCTION);
      PLACEHOLDER_UNMATCHED_BEHIND_INSTRUCTION_COMMENT = new PlaceholderObject(EPlaceholderType.UNMATCHED_BEHIND_INSTRUCTION_COMMENT);
      PLACEHOLDER_BASICBLOCK_COMMENT = new PlaceholderObject(EPlaceholderType.BASICBLOCK_COMMENT);
   }
}
