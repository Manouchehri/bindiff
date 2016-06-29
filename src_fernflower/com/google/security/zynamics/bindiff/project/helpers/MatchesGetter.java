package com.google.security.zynamics.bindiff.project.helpers;

import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.sorters.AddressPairSorter;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.InstructionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class MatchesGetter {
   public static Map createMatchedInstructionsMap(Diff var0, RawFunction var1) {
      HashMap var2 = new HashMap();
      FunctionMatchData var3 = getFunctionMatch(var0, var1);
      Iterator var4 = var3.getBasicblockMatches().iterator();

      while(var4.hasNext()) {
         BasicBlockMatchData var5 = (BasicBlockMatchData)var4.next();
         InstructionMatchData[] var6 = var5.getInstructionMatches();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            InstructionMatchData var9 = var6[var8];
            if(var1.getSide() == ESide.PRIMARY) {
               var2.put(var9.getIAddress(ESide.PRIMARY), var9.getIAddress(ESide.SECONDARY));
            } else {
               var2.put(var9.getIAddress(ESide.SECONDARY), var9.getIAddress(ESide.PRIMARY));
            }
         }
      }

      return var2;
   }

   public static List getBasicblockAddressPairs(Diff var0, RawFlowGraph var1, RawFlowGraph var2) {
      ArrayList var3 = new ArrayList();
      MatchData var4 = var0.getMatches();
      Iterator var5;
      RawBasicBlock var6;
      Pair var7;
      if(var1 == null) {
         var5 = var2.iterator();

         while(var5.hasNext()) {
            var6 = (RawBasicBlock)var5.next();
            var7 = new Pair((Object)null, var6.getAddress());
            var3.add(var7);
         }
      } else if(var2 == null) {
         var5 = var1.iterator();

         while(var5.hasNext()) {
            var6 = (RawBasicBlock)var5.next();
            var7 = new Pair(var6.getAddress(), (Object)null);
            var3.add(var7);
         }
      } else {
         FunctionMatchData var10 = var4.getFunctionMatch(var1.getAddress(), ESide.PRIMARY);
         Iterator var11 = var1.iterator();

         IAddress var8;
         RawBasicBlock var12;
         while(var11.hasNext()) {
            var12 = (RawBasicBlock)var11.next();
            var8 = var12.getAddress();
            IAddress var9 = var10.getSecondaryBasicblockAddr(var8);
            var3.add(new Pair(var8, var9));
         }

         var11 = var2.iterator();

         while(var11.hasNext()) {
            var12 = (RawBasicBlock)var11.next();
            var8 = var12.getAddress();
            if(var10.getPrimaryBasicblockAddr(var8) == null) {
               var3.add(new Pair((Object)null, var8));
            }
         }
      }

      return AddressPairSorter.getSortedList(var3, ESide.PRIMARY);
   }

   public static BasicBlockMatchData getBasicblockMatch(Diff var0, RawBasicBlock var1) {
      ESide var2 = var1.getSide();
      RawFunction var3 = null;
      if(var2 == ESide.PRIMARY) {
         var3 = var0.getFunction(var1.getFunctionAddr(), ESide.PRIMARY);
      } else {
         var3 = var0.getFunction(var1.getFunctionAddr(), ESide.SECONDARY);
      }

      FunctionMatchData var4 = getFunctionMatch(var0, var3);
      return getBasicblockMatch(var4, var1);
   }

   public static BasicBlockMatchData getBasicblockMatch(Diff var0, IAddress var1, IAddress var2, ESide var3) {
      RawFunction var4 = null;
      var4 = var0.getFunction(var1, var3);
      FunctionMatchData var5 = getFunctionMatch(var0, var4);
      if(var5 == null) {
         return null;
      } else {
         IAddress var6 = null;
         Object var7 = null;
         if(var3 == ESide.PRIMARY) {
            var6 = var2;
            var5.getSecondaryBasicblockAddr(var2);
         } else {
            var6 = var5.getPrimaryBasicblockAddr(var2);
         }

         return var5.getBasicblockMatch(var6, ESide.PRIMARY);
      }
   }

   public static BasicBlockMatchData getBasicblockMatch(FunctionMatchData var0, RawBasicBlock var1) {
      if(var0 == null) {
         return null;
      } else {
         IAddress var2 = null;
         IAddress var3 = null;
         if(var1.getSide() == ESide.PRIMARY) {
            var2 = var1.getAddress();
            var0.getSecondaryBasicblockAddr(var2);
         } else {
            var3 = var1.getAddress();
            var2 = var0.getPrimaryBasicblockAddr(var3);
         }

         return var0.getBasicblockMatch(var2, ESide.PRIMARY);
      }
   }

   public static EMatchType getFlowgraphsMatchType(CombinedGraph var0, FunctionMatchData var1) {
      int var2 = var1.getBasicblockMatches().size();
      int var3 = var0.getPrimaryGraph().getPrimaryGraph().getNodes().size();
      int var4 = var0.getSecondaryGraph().getSecondaryGraph().getNodes().size();
      if(var3 == var2 && var4 == var2) {
         boolean var5 = true;
         Iterator var6 = var0.getEdges().iterator();

         label43: {
            SingleDiffEdge var8;
            SingleDiffEdge var9;
            do {
               if(!var6.hasNext()) {
                  break label43;
               }

               CombinedDiffEdge var7 = (CombinedDiffEdge)var6.next();
               var8 = var7.getPrimaryDiffEdge();
               var9 = var7.getSecondaryDiffEdge();
            } while(var8 != null && var9 != null);

            var5 = false;
         }

         if(var5) {
            boolean var15 = true;
            Iterator var16 = var0.getNodes().iterator();

            while(var16.hasNext()) {
               CombinedDiffNode var17 = (CombinedDiffNode)var16.next();
               RawBasicBlock var18 = (RawBasicBlock)var17.getPrimaryRawNode();
               RawBasicBlock var10 = (RawBasicBlock)var17.getSecondaryRawNode();
               BasicBlockMatchData var11 = var1.getBasicblockMatch(var18.getAddress(), ESide.PRIMARY);
               int var12 = var18.getSizeOfInstructions();
               int var13 = var10.getSizeOfInstructions();
               int var14 = var11.getSizeOfMatchedInstructions();
               if(var12 != var14 || var13 != var14) {
                  var15 = false;
                  break;
               }
            }

            if(var15) {
               return EMatchType.IDENTICAL;
            }

            return EMatchType.INSTRUCTIONS_CHANGED;
         }
      }

      return EMatchType.STRUCTURAL_CHANGED;
   }

   public static FunctionMatchData getFunctionMatch(Diff var0, RawFlowGraph var1) {
      ESide var2 = var1.getSide();
      IAddress var3 = var1.getAddress();
      RawFunction var4 = var0.getCallgraph(var2).getFunction(var3);
      return getFunctionMatch(var0, var4);
   }

   public static FunctionMatchData getFunctionMatch(Diff var0, RawFunction var1) {
      MatchData var2 = var0.getMatches();
      IAddress var3;
      if(var1.getSide() == ESide.PRIMARY) {
         var3 = var1.getAddress();
         IAddress var4 = var2.getSecondaryFunctionAddr(var1.getAddress());
         if(var4 != null) {
            return var2.getFunctionMatch(var3, ESide.PRIMARY);
         }
      } else {
         var3 = var2.getPrimaryFunctionAddr(var1.getAddress());
         if(var3 != null) {
            return var2.getFunctionMatch(var3, ESide.PRIMARY);
         }
      }

      return null;
   }

   public static List getInstructionAddressPairs(Diff var0, RawBasicBlock var1, RawBasicBlock var2) {
      ArrayList var3 = new ArrayList();
      MatchData var4 = var0.getMatches();
      Iterator var5;
      RawInstruction var6;
      Pair var7;
      if(var1 == null) {
         var5 = var2.iterator();

         while(var5.hasNext()) {
            var6 = (RawInstruction)var5.next();
            var7 = new Pair((Object)null, var6.getAddress());
            var3.add(var7);
         }
      } else if(var2 == null) {
         var5 = var1.iterator();

         while(var5.hasNext()) {
            var6 = (RawInstruction)var5.next();
            var7 = new Pair(var6.getAddress(), (Object)null);
            var3.add(var7);
         }
      } else {
         IAddress var13 = var1.getFunctionAddr();
         FunctionMatchData var14 = var4.getFunctionMatch(var13, ESide.PRIMARY);
         IAddress var15 = var1.getAddress();
         BasicBlockMatchData var8 = var14.getBasicblockMatch(var15, ESide.PRIMARY);
         Iterator var9 = var1.iterator();

         RawInstruction var10;
         IAddress var11;
         while(var9.hasNext()) {
            var10 = (RawInstruction)var9.next();
            var11 = var10.getAddress();
            IAddress var12 = var8.getSecondaryInstructionAddr(var11);
            var3.add(new Pair(var11, var12));
         }

         var9 = var2.iterator();

         while(var9.hasNext()) {
            var10 = (RawInstruction)var9.next();
            var11 = var10.getAddress();
            if(var8.getPrimaryInstructionAddr(var11) == null) {
               var3.add(new Pair((Object)null, var11));
            }
         }
      }

      return AddressPairSorter.getSortedList(var3, ESide.PRIMARY);
   }

   public static boolean isChangedBasicblock(Diff var0, RawBasicBlock var1, RawBasicBlock var2) {
      if(var1 != null && var2 != null) {
         BasicBlockMatchData var3 = getBasicblockMatch(var0, var1);
         if(var3 == null) {
            return false;
         } else {
            int var4 = var3.getSizeOfMatchedInstructions();
            int var5 = var1.getSizeOfInstructions();
            int var6 = var2.getSizeOfInstructions();
            return var4 != var5 || var4 != var6;
         }
      } else {
         return false;
      }
   }

   public static boolean isIdenticalBasicblock(Diff var0, RawBasicBlock var1, RawBasicBlock var2) {
      if(var1 != null && var2 != null) {
         BasicBlockMatchData var3 = getBasicblockMatch(var0, var1);
         if(var3 == null) {
            return false;
         } else {
            int var4 = var3.getSizeOfMatchedInstructions();
            int var5 = var1.getSizeOfInstructions();
            int var6 = var2.getSizeOfInstructions();
            return var4 == var5 && var4 == var6;
         }
      } else {
         return false;
      }
   }

   public static boolean isIdenticalFunctionPair(RawFunction var0, RawFunction var1) {
      if(var0.getMatchedFunction() != var1) {
         throw new IllegalArgumentException("Primary and secondary function must be matched to each other.");
      } else {
         return var0.isIdenticalMatch();
      }
   }

   public static boolean isInstructionsOnlyChangedFunctionPair(RawFunction var0, RawFunction var1) {
      if(var0.getMatchedFunction() != var1) {
         throw new IllegalArgumentException("Primary and secondary function must be matched to each other.");
      } else {
         int var2 = var0.getFunctionMatch().getSizeOfMatchedInstructions();
         return var0.getSizeOfUnmatchedBasicblocks() == 0 && var0.getSizeOfUnmatchedJumps() == 0 && var1.getSizeOfUnmatchedBasicblocks() == 0 && var1.getSizeOfUnmatchedJumps() == 0 && (var0.getSizeOfInstructions() != var2 || var1.getSizeOfInstructions() != var2);
      }
   }

   public static boolean isMatchedInstruction(Diff var0, RawBasicBlock var1, RawInstruction var2) {
      MatchData var3 = var0.getMatches();
      FunctionMatchData var4 = var3.getFunctionMatch(var1.getFunctionAddr(), var1.getSide());
      return isMatchedInstruction(var4, var1, var2);
   }

   public static boolean isMatchedInstruction(FunctionMatchData var0, RawBasicBlock var1, RawInstruction var2) {
      ESide var3 = var1.getSide();
      if(var0 != null) {
         IAddress var4 = var3 == ESide.PRIMARY?var1.getAddress():var0.getPrimaryBasicblockAddr(var1.getAddress());
         IAddress var5 = var3 == ESide.SECONDARY?var1.getAddress():var0.getSecondaryBasicblockAddr(var1.getAddress());
         if(var4 != null && var5 != null) {
            BasicBlockMatchData var6 = var0.getBasicblockMatch(var4, ESide.PRIMARY);
            if(var6 != null) {
               IAddress var7 = var2.getAddress();
               if(var3 == ESide.PRIMARY) {
                  return var6.getSecondaryInstructionAddr(var7) != null;
               }

               return var6.getPrimaryInstructionAddr(var7) != null;
            }
         }
      }

      return false;
   }

   public static boolean isStructuralChangedFunctionPair(RawFunction var0, RawFunction var1) {
      if(var0.getMatchedFunction() != var1) {
         throw new IllegalArgumentException("Primary and secondary function must be matched to each other.");
      } else {
         return var0.getSizeOfUnmatchedBasicblocks() != 0 || var0.getSizeOfUnmatchedJumps() != 0 || var1.getSizeOfUnmatchedBasicblocks() != 0 || var1.getSizeOfUnmatchedJumps() != 0;
      }
   }
}
