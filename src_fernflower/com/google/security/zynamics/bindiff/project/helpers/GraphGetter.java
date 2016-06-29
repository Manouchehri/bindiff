package com.google.security.zynamics.bindiff.project.helpers;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GraphGetter {
   public static RawCall getCall(RawCallGraph var0, IAddress var1, IAddress var2, IAddress var3) {
      RawFunction var4 = var0.getFunction(var1);
      if(var4 != null) {
         Iterator var5 = var4.getOutgoingEdges().iterator();

         while(var5.hasNext()) {
            SingleViewEdge var6 = (SingleViewEdge)var5.next();
            RawCall var7 = (RawCall)var6;
            if(var7.getSourceInstructionAddr().equals(var3) && ((RawFunction)var7.getTarget()).getAddress().equals(var2)) {
               return var7;
            }
         }
      }

      return null;
   }

   public static List getCallees(RawFunction var0) {
      ArrayList var1 = new ArrayList();
      var1.addAll(var0.getCallees());
      return var1;
   }

   public static List getCallers(RawFunction var0) {
      ArrayList var1 = new ArrayList();
      var1.addAll(var0.getCallers());
      return var1;
   }

   public static List getCallsAt(RawCallGraph var0, IAddress var1, IAddress var2) {
      ArrayList var3 = new ArrayList();
      RawFunction var4 = var0.getFunction(var1);
      Iterator var5 = var4.getOutgoingEdges().iterator();

      while(var5.hasNext()) {
         SingleViewEdge var6 = (SingleViewEdge)var5.next();
         RawCall var7 = (RawCall)var6;
         if(var7.getSourceInstructionAddr().equals(var2)) {
            var3.add(var7);
         }
      }

      return var3;
   }

   public static Set getChangedFunctionPairs(RawCallGraph var0, RawCallGraph var1) {
      Set var2 = getMatchedFunctionPairs(var0, var1);
      HashSet var3 = new HashSet();
      Iterator var4 = var2.iterator();

      while(true) {
         RawFunction var6;
         RawFunction var7;
         int var8;
         do {
            if(!var4.hasNext()) {
               return var3;
            }

            Pair var5 = (Pair)var4.next();
            var6 = (RawFunction)var5.first();
            var7 = (RawFunction)var5.second();
            var8 = var6.getFunctionMatch().getSizeOfMatchedInstructions();
         } while(var6.getSizeOfUnmatchedBasicblocks() == 0 && var6.getSizeOfUnmatchedJumps() == 0 && var7.getSizeOfUnmatchedBasicblocks() == 0 && var7.getSizeOfUnmatchedJumps() == 0 && var6.getSizeOfInstructions() == var8 && var7.getSizeOfInstructions() == var8);

         Pair var9 = new Pair(var6, var7);
         var3.add(var9);
      }
   }

   public static SingleDiffNode getDiffNode(GraphsContainer var0, RawBasicBlock var1) {
      return var1.getSide() == ESide.PRIMARY?(SingleDiffNode)var0.getPrimaryGraph().getNode(var1):(SingleDiffNode)var0.getSecondaryGraph().getNode(var1);
   }

   public static RawFunction getFunction(Diff var0, RawBasicBlock var1) {
      IAddress var2 = var1.getFunctionAddr();
      RawCallGraph var3 = var0.getCallgraph(var1.getSide());
      return var3.getFunction(var2);
   }

   public static RawFunction getFunction(Diff var0, RawFlowGraph var1) {
      if(var1 == null) {
         return null;
      } else {
         RawCallGraph var2 = var0.getCallgraph(var1.getSide());
         return var2.getFunction(var1.getAddress());
      }
   }

   public static Set getIdenticalFunctionPairs(RawCallGraph var0, RawCallGraph var1) {
      Set var2 = getMatchedFunctionPairs(var0, var1);
      HashSet var3 = new HashSet();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Pair var5 = (Pair)var4.next();
         RawFunction var6 = (RawFunction)var5.first();
         RawFunction var7 = (RawFunction)var5.second();
         if(MatchesGetter.isIdenticalFunctionPair(var6, var7)) {
            Pair var8 = new Pair(var6, var7);
            var3.add(var8);
         }
      }

      return var3;
   }

   public static Collection getIncomingJumps(RawBasicBlock var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.getIncomingEdges().iterator();

      while(var2.hasNext()) {
         SingleViewEdge var3 = (SingleViewEdge)var2.next();
         if(var3 instanceof RawJump) {
            var1.add((RawJump)var3);
         }
      }

      return var1;
   }

   public static Set getInstructionOnlyChangedFunctionPairs(RawCallGraph var0, RawCallGraph var1) {
      Set var2 = getMatchedFunctionPairs(var0, var1);
      HashSet var3 = new HashSet();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Pair var5 = (Pair)var4.next();
         RawFunction var6 = (RawFunction)var5.first();
         RawFunction var7 = (RawFunction)var5.second();
         if(MatchesGetter.isInstructionsOnlyChangedFunctionPair(var6, var7)) {
            Pair var8 = new Pair(var6, var7);
            var3.add(var8);
         }
      }

      return var3;
   }

   public static List getMatchedCallees(RawFunction var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.getCallees().iterator();

      while(var2.hasNext()) {
         RawFunction var3 = (RawFunction)var2.next();
         if(var3.getMatchState() == EMatchState.MATCHED) {
            var1.add(var3);
         }
      }

      ArrayList var4 = new ArrayList();
      var4.addAll(var1);
      return var4;
   }

   public static List getMatchedCallers(RawFunction var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.getCallers().iterator();

      while(var2.hasNext()) {
         RawFunction var3 = (RawFunction)var2.next();
         if(var3.getMatchState() == EMatchState.MATCHED) {
            var1.add(var3);
         }
      }

      ArrayList var4 = new ArrayList();
      var4.addAll(var1);
      return var4;
   }

   public static Set getMatchedFunctionPairs(RawCallGraph var0, RawCallGraph var1) {
      HashSet var2 = new HashSet();
      Iterator var3 = var0.getNodes().iterator();

      while(var3.hasNext()) {
         RawFunction var4 = (RawFunction)var3.next();
         if(var4.getMatchState() == EMatchState.MATCHED) {
            RawFunction var5 = var1.getFunction(var4.getMatchedFunctionAddress());
            Pair var6 = new Pair(var4, var5);
            var2.add(var6);
         }
      }

      return var2;
   }

   public static List getMatchedIncomingCalls(RawFunction var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.getIncomingEdges().iterator();

      while(true) {
         RawCall var4;
         do {
            if(!var2.hasNext()) {
               return var1;
            }

            SingleViewEdge var3 = (SingleViewEdge)var2.next();
            var4 = (RawCall)var3;
         } while(var4.getMatchState() != EMatchState.MATCHED && !var4.isChanged());

         var1.add(var4);
      }
   }

   public static Collection getMatchedIncomingJumps(Diff var0, RawFlowGraph var1, RawFlowGraph var2, RawBasicBlock var3) {
      ArrayList var4 = new ArrayList();
      BasicBlockMatchData var5 = MatchesGetter.getBasicblockMatch(var0, var3);
      if(var5 == null) {
         return var4;
      } else {
         RawFlowGraph var6 = var3.getSide() == ESide.PRIMARY?var2:var1;
         Collection var7 = getIncomingJumps(var3);
         Iterator var8 = var7.iterator();

         while(var8.hasNext()) {
            RawJump var9 = (RawJump)var8.next();
            RawBasicBlock var10 = var9.getTarget();
            BasicBlockMatchData var11 = MatchesGetter.getBasicblockMatch(var0, var10);
            if(var11 != null) {
               IAddress var12 = null;
               IAddress var13 = null;
               if(var3.getSide() == ESide.PRIMARY) {
                  var12 = var5.getIAddress(ESide.SECONDARY);
                  var13 = var11.getIAddress(ESide.SECONDARY);
               } else {
                  var12 = var5.getIAddress(ESide.PRIMARY);
                  var13 = var11.getIAddress(ESide.PRIMARY);
               }

               if(var6.getJump(var12, var13) != null) {
                  var4.add(var9);
               }
            }
         }

         return var4;
      }
   }

   public static List getMatchedOutgoingCalls(Diff var0, RawBasicBlock var1) {
      ArrayList var2 = new ArrayList();
      List var3 = getOutgoingCalls(var0, var1);
      Iterator var4 = var3.iterator();

      while(true) {
         RawCall var5;
         do {
            if(!var4.hasNext()) {
               return var2;
            }

            var5 = (RawCall)var4.next();
         } while(var5.getMatchState() != EMatchState.MATCHED && !var5.isChanged());

         var2.add(var5);
      }
   }

   public static List getMatchedOutgoingCalls(RawFunction var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.getOutgoingEdges().iterator();

      while(true) {
         RawCall var4;
         do {
            if(!var2.hasNext()) {
               return var1;
            }

            SingleViewEdge var3 = (SingleViewEdge)var2.next();
            var4 = (RawCall)var3;
         } while(var4.getMatchState() != EMatchState.MATCHED && !var4.isChanged());

         var1.add(var4);
      }
   }

   public static Collection getMatchedOutgoingJumps(Diff var0, RawFlowGraph var1, RawFlowGraph var2, RawBasicBlock var3) {
      ArrayList var4 = new ArrayList();
      BasicBlockMatchData var5 = MatchesGetter.getBasicblockMatch(var0, var3);
      if(var5 == null) {
         return var4;
      } else {
         RawFlowGraph var6 = var3.getSide() == ESide.PRIMARY?var2:var1;
         Collection var7 = getOutgoingJumps(var3);
         Iterator var8 = var7.iterator();

         while(var8.hasNext()) {
            RawJump var9 = (RawJump)var8.next();
            RawBasicBlock var10 = var9.getTarget();
            BasicBlockMatchData var11 = MatchesGetter.getBasicblockMatch(var0, var10);
            if(var11 != null) {
               IAddress var12 = null;
               IAddress var13 = null;
               if(var3.getSide() == ESide.PRIMARY) {
                  var12 = var5.getIAddress(ESide.SECONDARY);
                  var13 = var11.getIAddress(ESide.SECONDARY);
               } else {
                  var12 = var5.getIAddress(ESide.PRIMARY);
                  var13 = var11.getIAddress(ESide.PRIMARY);
               }

               if(var6.getJump(var12, var13) != null) {
                  var4.add(var9);
               }
            }
         }

         return var4;
      }
   }

   public static IAddress getMaxAddress(List var0) {
      if(var0 != null && var0.size() != 0) {
         Object var1 = new CAddress(0L);
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            RawBasicBlock var3 = (RawBasicBlock)var2.next();
            IAddress var4 = var3.getAddress();
            if(var4.compareTo(var1) > 0) {
               var1 = var4;
            }
         }

         return (IAddress)var1;
      } else {
         return null;
      }
   }

   public static IAddress getMinAddress(List var0) {
      if(var0 != null && var0.size() != 0) {
         Object var1 = new CAddress(-1L);
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            RawBasicBlock var3 = (RawBasicBlock)var2.next();
            IAddress var4 = var3.getAddress();
            if(var4.compareTo(var1) < 0) {
               var1 = var4;
            }
         }

         return (IAddress)var1;
      } else {
         return null;
      }
   }

   public static SingleGraph getOtherGraph(SingleGraph var0) {
      return var0.getSide() == ESide.PRIMARY?var0.getSecondaryGraph():var0.getPrimaryGraph();
   }

   public static List getOutgoingCalls(Diff var0, RawBasicBlock var1) {
      ArrayList var2 = new ArrayList();
      RawFunction var3 = getFunction(var0, var1);
      Iterator var4 = var3.getOutgoingEdges().iterator();

      while(var4.hasNext()) {
         SingleViewEdge var5 = (SingleViewEdge)var4.next();
         RawCall var6 = (RawCall)var5;
         if(var1.getInstruction(var6.getSourceInstructionAddr()) != null) {
            var2.add(var6);
         }
      }

      return var2;
   }

   public static Collection getOutgoingJumps(RawBasicBlock var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.getOutgoingEdges().iterator();

      while(var2.hasNext()) {
         SingleViewEdge var3 = (SingleViewEdge)var2.next();
         if(var3 instanceof RawJump) {
            var1.add((RawJump)var3);
         }
      }

      return var1;
   }

   public static SingleDiffNode getPrimaryDiffNode(SingleGraph var0, RawBasicBlock var1) {
      SingleDiffNode var2 = (SingleDiffNode)var0.getSecondaryGraph().getNode(var1);
      return var2.getOtherSideDiffNode();
   }

   public static RawBasicBlock getPrimaryRawBasicblock(GraphsContainer var0, RawBasicBlock var1) {
      SingleDiffNode var2 = getDiffNode(var0, var1);
      SingleDiffNode var3 = var2.getOtherSideDiffNode();
      return var3 != null?(RawBasicBlock)var3.getRawNode():null;
   }

   public static RawFunction getRawFunction(Diff var0, RawFlowGraph var1) {
      return var0.getCallgraph(var1.getSide()).getFunction(var1.getAddress());
   }

   public static SingleDiffNode getSecondaryDiffNode(SingleGraph var0, RawBasicBlock var1) {
      SingleDiffNode var2 = (SingleDiffNode)var0.getPrimaryGraph().getNode(var1);
      return var2.getOtherSideDiffNode();
   }

   public static RawBasicBlock getSecondaryRawBasicblock(GraphsContainer var0, RawBasicBlock var1) {
      SingleDiffNode var2 = getDiffNode(var0, var1);
      SingleDiffNode var3 = var2.getOtherSideDiffNode();
      return var3 != null?(RawBasicBlock)var3.getRawNode():null;
   }

   public static Set getStructuralChangedFunctionPairs(RawCallGraph var0, RawCallGraph var1) {
      Set var2 = getMatchedFunctionPairs(var0, var1);
      HashSet var3 = new HashSet();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Pair var5 = (Pair)var4.next();
         RawFunction var6 = (RawFunction)var5.first();
         RawFunction var7 = (RawFunction)var5.second();
         if(MatchesGetter.isStructuralChangedFunctionPair(var6, var7)) {
            Pair var8 = new Pair(var6, var7);
            var3.add(var8);
         }
      }

      return var3;
   }

   public static List getUnmatchedCallees(RawFunction var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.getCallees().iterator();

      while(var2.hasNext()) {
         RawFunction var3 = (RawFunction)var2.next();
         if(var3.getMatchState() != EMatchState.MATCHED) {
            var1.add(var3);
         }
      }

      ArrayList var4 = new ArrayList();
      var4.addAll(var1);
      return var4;
   }

   public static List getUnmatchedCallers(RawFunction var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.getCallees().iterator();

      while(var2.hasNext()) {
         RawFunction var3 = (RawFunction)var2.next();
         if(var3.getMatchState() != EMatchState.MATCHED) {
            var1.add(var3);
         }
      }

      ArrayList var4 = new ArrayList();
      var4.addAll(var1);
      return var4;
   }

   public static List getUnmatchedFunctions(RawCallGraph var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.getNodes().iterator();

      while(var2.hasNext()) {
         RawFunction var3 = (RawFunction)var2.next();
         if(var3.getMatchState() != EMatchState.MATCHED) {
            var1.add(var3);
         }
      }

      return var1;
   }

   public static List getUnmatchedIncomingCalls(RawFunction var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.getIncomingEdges().iterator();

      while(var2.hasNext()) {
         SingleViewEdge var3 = (SingleViewEdge)var2.next();
         RawCall var4 = (RawCall)var3;
         if(var4.getMatchState() != EMatchState.MATCHED && !var4.isChanged()) {
            var1.add(var4);
         }
      }

      return var1;
   }

   public static Collection getUnmatchedIncomingJumps(Diff var0, RawFlowGraph var1, RawFlowGraph var2, RawBasicBlock var3) {
      ArrayList var4 = new ArrayList();
      BasicBlockMatchData var5 = MatchesGetter.getBasicblockMatch(var0, var3);
      if(var5 == null) {
         return getIncomingJumps(var3);
      } else {
         RawFlowGraph var6 = var3.getSide() == ESide.PRIMARY?var2:var1;
         Collection var7 = getIncomingJumps(var3);
         Iterator var8 = var7.iterator();

         while(var8.hasNext()) {
            RawJump var9 = (RawJump)var8.next();
            RawBasicBlock var10 = var9.getSource();
            BasicBlockMatchData var11 = MatchesGetter.getBasicblockMatch(var0, var10);
            if(var11 != null) {
               IAddress var12 = null;
               IAddress var13 = null;
               if(var3.getSide() == ESide.PRIMARY) {
                  var13 = var5.getIAddress(ESide.SECONDARY);
                  var12 = var11.getIAddress(ESide.SECONDARY);
               } else {
                  var13 = var5.getIAddress(ESide.PRIMARY);
                  var12 = var11.getIAddress(ESide.PRIMARY);
               }

               if(var6.getJump(var12, var13) == null) {
                  var4.add(var9);
               }
            } else {
               var4.add(var9);
            }
         }

         return var4;
      }
   }

   public static List getUnmatchedOutgoingCalls(Diff var0, RawBasicBlock var1) {
      ArrayList var2 = new ArrayList();
      List var3 = getOutgoingCalls(var0, var1);
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         RawCall var5 = (RawCall)var4.next();
         if(var5.getMatchState() != EMatchState.MATCHED && !var5.isChanged()) {
            var2.add(var5);
         }
      }

      return var2;
   }

   public static List getUnmatchedOutgoingCalls(RawFunction var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.getOutgoingEdges().iterator();

      while(var2.hasNext()) {
         SingleViewEdge var3 = (SingleViewEdge)var2.next();
         RawCall var4 = (RawCall)var3;
         if(var4.getMatchState() != EMatchState.MATCHED && !var4.isChanged()) {
            var1.add(var4);
         }
      }

      return var1;
   }

   public static Collection getUnmatchedOutgoingJumps(Diff var0, RawFlowGraph var1, RawFlowGraph var2, RawBasicBlock var3) {
      ArrayList var4 = new ArrayList();
      BasicBlockMatchData var5 = MatchesGetter.getBasicblockMatch(var0, var3);
      if(var5 == null) {
         return getOutgoingJumps(var3);
      } else {
         RawFlowGraph var6 = var3.getSide() == ESide.PRIMARY?var2:var1;
         Collection var7 = getOutgoingJumps(var3);
         Iterator var8 = var7.iterator();

         while(var8.hasNext()) {
            RawJump var9 = (RawJump)var8.next();
            RawBasicBlock var10 = var9.getTarget();
            BasicBlockMatchData var11 = MatchesGetter.getBasicblockMatch(var0, var10);
            if(var11 != null) {
               IAddress var12 = null;
               IAddress var13 = null;
               if(var3.getSide() == ESide.PRIMARY) {
                  var12 = var5.getIAddress(ESide.SECONDARY);
                  var13 = var11.getIAddress(ESide.SECONDARY);
               } else {
                  var12 = var5.getIAddress(ESide.PRIMARY);
                  var13 = var11.getIAddress(ESide.PRIMARY);
               }

               if(var6.getJump(var12, var13) == null) {
                  var4.add(var9);
               }
            } else {
               var4.add(var9);
            }
         }

         return var4;
      }
   }
}
