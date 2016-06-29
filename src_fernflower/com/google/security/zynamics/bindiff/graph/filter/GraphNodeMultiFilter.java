package com.google.security.zynamics.bindiff.graph.filter;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.filter.IGraphNodeMultiFilterListener;
import com.google.security.zynamics.bindiff.graph.filter.enums.EMatchStateFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESelectionFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESideFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EVisibilityFilter;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.MatchesGetter;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphNodeMultiFilter {
   private final ListenerProvider listeners = new ListenerProvider();
   private final Diff diff;
   private EMatchStateFilter matchStateFilter;
   private ESelectionFilter selectionFilter;
   private EVisibilityFilter visibilityFilter;
   private ESideFilter sideFilter;
   private IAddress startRangeAddr;
   private IAddress endRangeAddr;
   private ESideFilter addrRangeSide;
   private boolean notify = false;
   final RawFlowGraph priFlowgraph;
   final RawFlowGraph secFlowgraph;

   public GraphNodeMultiFilter(Diff var1, RawFlowGraph var2, RawFlowGraph var3, IAddress var4, IAddress var5, EMatchStateFilter var6, ESelectionFilter var7, EVisibilityFilter var8, ESideFilter var9) {
      this.diff = (Diff)Preconditions.checkNotNull(var1);
      this.startRangeAddr = (IAddress)Preconditions.checkNotNull(var4);
      this.endRangeAddr = (IAddress)Preconditions.checkNotNull(var5);
      this.matchStateFilter = (EMatchStateFilter)Preconditions.checkNotNull(var6);
      this.selectionFilter = (ESelectionFilter)Preconditions.checkNotNull(var7);
      this.visibilityFilter = (EVisibilityFilter)Preconditions.checkNotNull(var8);
      this.sideFilter = (ESideFilter)Preconditions.checkNotNull(var9);
      this.priFlowgraph = var2;
      this.secFlowgraph = var3;
   }

   private boolean filterAddressRange(CombinedViewNode var1) {
      IAddress var2 = var1.getAddress(ESide.PRIMARY);
      IAddress var3 = var1.getAddress(ESide.SECONDARY);
      boolean var4 = false;
      String var5 = this.startRangeAddr.toHexString();
      String var6 = this.endRangeAddr.toHexString();
      String var7;
      if(var2 != null) {
         var7 = var2.toHexString();
         var4 = var7.compareTo(var5) >= 0 && var7.compareTo(var6) <= 0;
      }

      if(var3 != null && !var4) {
         var7 = var3.toHexString();
         var4 = var7.compareTo(var5) >= 0 && var7.compareTo(var6) <= 0;
      }

      return var4;
   }

   private boolean filterAddressRange(SingleViewNode var1) {
      String var2 = var1.getAddress().toHexString();
      String var3 = this.startRangeAddr.toHexString();
      String var4 = this.endRangeAddr.toHexString();
      return var2.compareTo(var3) >= 0 && var2.compareTo(var4) <= 0;
   }

   private boolean filterMatchState(CombinedViewNode var1) {
      if(this.matchStateFilter == EMatchStateFilter.NONE) {
         return true;
      } else {
         if(var1.getMatchState() == EMatchState.MATCHED) {
            if(this.matchStateFilter == EMatchStateFilter.MATCHED) {
               return true;
            }

            if(var1 instanceof RawCombinedBasicBlock) {
               boolean var2 = false;
               RawBasicBlock var3 = ((RawCombinedBasicBlock)var1).getRawNode(ESide.PRIMARY);
               RawBasicBlock var4 = ((RawCombinedBasicBlock)var1).getRawNode(ESide.SECONDARY);
               var2 = MatchesGetter.isIdenticalBasicblock(this.diff, var3, var4);
               if(this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && var2) {
                  return true;
               }

               if(this.matchStateFilter == EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES && !var2) {
                  return true;
               }
            } else if(var1 instanceof RawCombinedFunction) {
               RawFunction var6 = ((RawCombinedFunction)var1).getRawNode(ESide.PRIMARY);
               boolean var7 = var6 != null && var6.isIdenticalMatch();
               boolean var8 = var6 != null && var6.isChangedInstructionsOnlyMatch();
               boolean var5 = var6 != null && var6.isChangedStructuralMatch();
               if(this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && var7) {
                  return true;
               }

               if(this.matchStateFilter == EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES && var8) {
                  return true;
               }

               if(this.matchStateFilter == EMatchStateFilter.MATCHED_STRUTURAL_CHANGES && var5) {
                  return true;
               }
            }
         } else if(var1.getMatchState() != EMatchState.MATCHED && this.matchStateFilter == EMatchStateFilter.UNMATCHED) {
            return true;
         }

         return false;
      }
   }

   private boolean filterMatchState(RawBasicBlock var1, RawFlowGraph var2, RawFlowGraph var3) {
      if(this.matchStateFilter == EMatchStateFilter.NONE) {
         return true;
      } else {
         if(var1.getMatchState() == EMatchState.MATCHED) {
            if(this.matchStateFilter == EMatchStateFilter.MATCHED) {
               return true;
            }

            boolean var4 = false;
            ESide var5 = var1.getSide();
            RawBasicBlock var6 = var1;
            RawBasicBlock var7 = var1;
            BasicBlockMatchData var8;
            if(var5 == ESide.PRIMARY) {
               var8 = MatchesGetter.getBasicblockMatch(this.diff, var1);
               var7 = var3.getBasicblock(var8.getIAddress(ESide.SECONDARY));
            } else {
               var8 = MatchesGetter.getBasicblockMatch(this.diff, var1);
               var6 = var2.getBasicblock(var8.getIAddress(ESide.PRIMARY));
            }

            var4 = MatchesGetter.isIdenticalBasicblock(this.diff, var6, var7);
            if(this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && var4) {
               return true;
            }

            if(this.matchStateFilter == EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES && !var4) {
               return true;
            }
         } else if(var1.getMatchState() != EMatchState.MATCHED && this.matchStateFilter == EMatchStateFilter.UNMATCHED) {
            return true;
         }

         return false;
      }
   }

   private boolean filterMatchState(RawFunction var1) {
      if(this.matchStateFilter == EMatchStateFilter.NONE) {
         return true;
      } else {
         if(var1.getMatchState() == EMatchState.MATCHED) {
            if(this.matchStateFilter == EMatchStateFilter.MATCHED) {
               return true;
            }

            boolean var2 = var1.isIdenticalMatch();
            boolean var3 = var1.isChangedInstructionsOnlyMatch();
            boolean var4 = var1.isChangedStructuralMatch();
            if(this.matchStateFilter == EMatchStateFilter.MATCHED_IDENTICAL && var2) {
               return true;
            }

            if(this.matchStateFilter == EMatchStateFilter.MATCHED_INSTRUCTION_CHANGES && var3) {
               return true;
            }

            if(this.matchStateFilter == EMatchStateFilter.MATCHED_STRUTURAL_CHANGES && var4) {
               return true;
            }
         } else if(var1.getMatchState() != EMatchState.MATCHED && this.matchStateFilter == EMatchStateFilter.UNMATCHED) {
            return true;
         }

         return false;
      }
   }

   private boolean filterSelection(CombinedViewNode var1) {
      return this.selectionFilter == ESelectionFilter.NONE?true:(var1.isSelected() && this.selectionFilter == ESelectionFilter.SELECTED?true:!var1.isSelected() && this.selectionFilter == ESelectionFilter.UNSELECTED);
   }

   private boolean filterSelection(SingleViewNode var1) {
      return this.selectionFilter == ESelectionFilter.NONE?true:(var1.isSelected() && this.selectionFilter == ESelectionFilter.SELECTED?true:!var1.isSelected() && this.selectionFilter == ESelectionFilter.UNSELECTED);
   }

   private boolean filterSide(CombinedViewNode var1) {
      IAddress var2 = var1.getAddress(ESide.PRIMARY);
      IAddress var3 = var1.getAddress(ESide.SECONDARY);
      return this.sideFilter == ESideFilter.NONE?true:(var2 != null && this.sideFilter == ESideFilter.PRIMARY?true:var3 != null && this.sideFilter == ESideFilter.SECONDARY);
   }

   private boolean filterSide(SingleViewNode var1) {
      return this.sideFilter == ESideFilter.NONE?true:(var1.getSide() == ESide.PRIMARY && this.sideFilter == ESideFilter.PRIMARY?true:var1.getSide() == ESide.SECONDARY && this.sideFilter == ESideFilter.SECONDARY);
   }

   private boolean filterVisibility(CombinedViewNode var1) {
      return this.visibilityFilter == EVisibilityFilter.NONE?true:(var1.isVisible() && this.visibilityFilter == EVisibilityFilter.VISIBLE?true:!var1.isVisible() && this.visibilityFilter == EVisibilityFilter.INVISIBLE);
   }

   private boolean filterVisibility(SingleViewNode var1) {
      return this.visibilityFilter == EVisibilityFilter.NONE?true:(var1.isVisible() && this.visibilityFilter == EVisibilityFilter.VISIBLE?true:!var1.isVisible() && this.visibilityFilter == EVisibilityFilter.INVISIBLE);
   }

   private void setAddressRangeFilter(IAddress var1, IAddress var2) {
      if(!this.startRangeAddr.equals(var1) || !this.endRangeAddr.equals(var2)) {
         this.startRangeAddr = var1;
         this.endRangeAddr = var2;
         this.notify = true;
      }

   }

   private void setMatchStateFilter(EMatchStateFilter var1) {
      if(this.matchStateFilter != var1) {
         this.matchStateFilter = var1;
         this.notify = true;
      }

   }

   private void setSelectionFilter(ESelectionFilter var1) {
      if(this.selectionFilter != var1) {
         this.selectionFilter = var1;
         this.notify = true;
      }

   }

   private void setSideFilter(ESideFilter var1) {
      if(var1 != this.sideFilter) {
         this.sideFilter = var1;
         this.notify = true;
      }

   }

   private void setVisibilityFilter(EVisibilityFilter var1) {
      if(this.visibilityFilter != var1) {
         this.visibilityFilter = var1;
         this.notify = true;
      }

   }

   public void addListener(IGraphNodeMultiFilterListener var1) {
      this.listeners.addListener(var1);
   }

   public void clearSettings(boolean var1) {
      this.matchStateFilter = EMatchStateFilter.NONE;
      this.selectionFilter = ESelectionFilter.NONE;
      this.visibilityFilter = EVisibilityFilter.NONE;
      this.sideFilter = ESideFilter.NONE;
      this.startRangeAddr = new CAddress(0L);
      this.endRangeAddr = new CAddress(-1L);
      if(var1) {
         this.notifyListeners();
      }

   }

   public boolean filterRawBasicblock(RawBasicBlock var1) {
      return var1 != null && this.filterAddressRange((SingleViewNode)var1) && this.filterMatchState(var1, this.priFlowgraph, this.secFlowgraph) && this.filterSelection((SingleViewNode)var1) && this.filterVisibility((SingleViewNode)var1) && this.filterSide((SingleViewNode)var1);
   }

   public boolean filterRawCombinedBasicblock(RawCombinedBasicBlock var1) {
      return var1 != null && this.filterAddressRange((CombinedViewNode)var1) && this.filterMatchState((CombinedViewNode)var1) && this.filterSelection((CombinedViewNode)var1) && this.filterVisibility((CombinedViewNode)var1) && this.filterSide((CombinedViewNode)var1);
   }

   public List filterRawCombinedBasicblocks(List var1) {
      Preconditions.checkNotNull(this.addrRangeSide);
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         RawCombinedBasicBlock var4 = (RawCombinedBasicBlock)var3.next();
         if(this.filterRawCombinedBasicblock(var4)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public boolean filterRawCombinedFunction(RawCombinedFunction var1) {
      return var1 != null && this.filterAddressRange((CombinedViewNode)var1) && this.filterMatchState((CombinedViewNode)var1) && this.filterSelection((CombinedViewNode)var1) && this.filterVisibility((CombinedViewNode)var1) && this.filterSide((CombinedViewNode)var1);
   }

   public List filterRawCombinedFunctions(List var1) {
      Preconditions.checkNotNull(this.addrRangeSide);
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         RawCombinedFunction var4 = (RawCombinedFunction)var3.next();
         if(this.filterRawCombinedFunction(var4)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public boolean filterRawFunction(RawFunction var1) {
      return var1 != null && this.filterAddressRange((SingleViewNode)var1) && this.filterMatchState(var1) && this.filterSelection((SingleViewNode)var1) && this.filterVisibility((SingleViewNode)var1) && this.filterSide((SingleViewNode)var1);
   }

   public List filterRawFunctions(List var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         RawFunction var4 = (RawFunction)var3.next();
         if(this.filterRawFunction(var4)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public ESelectionFilter getSelectionFilterValue() {
      return this.selectionFilter;
   }

   public EVisibilityFilter getVisibilityFilterValue() {
      return this.visibilityFilter;
   }

   public void notifyListeners() {
      if(this.notify) {
         Iterator var1 = this.listeners.iterator();

         while(var1.hasNext()) {
            IGraphNodeMultiFilterListener var2 = (IGraphNodeMultiFilterListener)var1.next();
            var2.filterChanged(this);
         }

         this.notify = false;
      }

   }

   public void removeListener(IGraphNodeMultiFilterListener var1) {
      this.listeners.removeListener(var1);
   }

   public void setFilter(IAddress var1, IAddress var2, EMatchStateFilter var3, ESelectionFilter var4, EVisibilityFilter var5, ESideFilter var6, boolean var7) {
      this.setAddressRangeFilter(var1, var2);
      this.setMatchStateFilter(var3);
      this.setSelectionFilter(var4);
      this.setVisibilityFilter(var5);
      this.setSideFilter(var6);
      if(var7) {
         this.notifyListeners();
      }

   }
}
