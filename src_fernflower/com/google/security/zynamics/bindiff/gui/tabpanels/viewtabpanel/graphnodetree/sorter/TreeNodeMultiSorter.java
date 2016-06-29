package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter;

import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.BasicBlockTreeNodeMatchStateComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.CombinedTreeNodeAdressComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.CombinedTreeNodeSideComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.FunctionTreeNodeMatchStateComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.FunctionTreeNodeNameComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.FunctionTreeNodeTypeComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.SingleTreeNodeAdressComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.TreeNodeSelectionComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators.TreeNodeVisibilityComparator;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ITreeNodeSorterListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter$1;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TreeNodeMultiSorter implements Iterable {
   public static final int MAX_DEPTH = 5;
   private final ListenerProvider listeners = new ListenerProvider();
   private final List criteria = new ArrayList();

   public TreeNodeMultiSorter() {
      this.criteria.add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
      this.criteria.add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
      this.criteria.add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
      this.criteria.add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
      this.criteria.add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
      this.criteria.add(new Pair(ESortByCriterium.NONE, ESortOrder.ASCENDING));
   }

   public void addListener(ITreeNodeSorterListener var1) {
      this.listeners.addListener(var1);
   }

   public List getCombinedBasicblockTreeNodeComparatorList() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.criteria.iterator();

      while(var2.hasNext()) {
         Pair var3 = (Pair)var2.next();
         switch(TreeNodeMultiSorter$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ESortByCriterium[((ESortByCriterium)var3.first()).ordinal()]) {
         case 1:
            var1.add(new CombinedTreeNodeAdressComparator((ESortOrder)var3.second()));
            break;
         case 2:
            var1.add(new BasicBlockTreeNodeMatchStateComparator((ESortOrder)var3.second()));
            break;
         case 3:
            var1.add(new TreeNodeVisibilityComparator((ESortOrder)var3.second()));
            break;
         case 4:
            var1.add(new TreeNodeSelectionComparator((ESortOrder)var3.second()));
            break;
         case 5:
            var1.add(new CombinedTreeNodeSideComparator((ESortOrder)var3.second()));
         }
      }

      Collections.reverse(var1);
      return var1;
   }

   public List getCombinedFunctionTreeNodeComparatorList() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.criteria.iterator();

      while(var2.hasNext()) {
         Pair var3 = (Pair)var2.next();
         switch(TreeNodeMultiSorter$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ESortByCriterium[((ESortByCriterium)var3.first()).ordinal()]) {
         case 1:
            var1.add(new CombinedTreeNodeAdressComparator((ESortOrder)var3.second()));
            break;
         case 2:
            var1.add(new FunctionTreeNodeMatchStateComparator((ESortOrder)var3.second()));
            break;
         case 3:
            var1.add(new TreeNodeVisibilityComparator((ESortOrder)var3.second()));
            break;
         case 4:
            var1.add(new TreeNodeSelectionComparator((ESortOrder)var3.second()));
            break;
         case 5:
            var1.add(new CombinedTreeNodeSideComparator((ESortOrder)var3.second()));
            break;
         case 6:
            var1.add(new FunctionTreeNodeTypeComparator((ESortOrder)var3.second()));
         }
      }

      Collections.reverse(var1);
      return var1;
   }

   public List getSingleBasicblockTreeNodeComparatorList() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.criteria.iterator();

      while(var2.hasNext()) {
         Pair var3 = (Pair)var2.next();
         switch(TreeNodeMultiSorter$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ESortByCriterium[((ESortByCriterium)var3.first()).ordinal()]) {
         case 1:
            var1.add(new SingleTreeNodeAdressComparator((ESortOrder)var3.second()));
            break;
         case 2:
            var1.add(new BasicBlockTreeNodeMatchStateComparator((ESortOrder)var3.second()));
            break;
         case 3:
            var1.add(new TreeNodeVisibilityComparator((ESortOrder)var3.second()));
            break;
         case 4:
            var1.add(new TreeNodeSelectionComparator((ESortOrder)var3.second()));
         }
      }

      Collections.reverse(var1);
      return var1;
   }

   public List getSingleFunctionTreeNodeComparatorList() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.criteria.iterator();

      while(var2.hasNext()) {
         Pair var3 = (Pair)var2.next();
         switch(TreeNodeMultiSorter$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ESortByCriterium[((ESortByCriterium)var3.first()).ordinal()]) {
         case 1:
            var1.add(new CombinedTreeNodeAdressComparator((ESortOrder)var3.second()));
            break;
         case 2:
            var1.add(new FunctionTreeNodeMatchStateComparator((ESortOrder)var3.second()));
            break;
         case 3:
            var1.add(new TreeNodeVisibilityComparator((ESortOrder)var3.second()));
            break;
         case 4:
            var1.add(new TreeNodeSelectionComparator((ESortOrder)var3.second()));
         case 5:
         default:
            break;
         case 6:
            var1.add(new FunctionTreeNodeTypeComparator((ESortOrder)var3.second()));
            break;
         case 7:
            var1.add(new FunctionTreeNodeNameComparator((ESortOrder)var3.second()));
         }
      }

      Collections.reverse(var1);
      return var1;
   }

   public Iterator iterator() {
      return this.criteria.iterator();
   }

   public void notifyListeners() {
      Iterator var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         ITreeNodeSorterListener var2 = (ITreeNodeSorterListener)var1.next();
         var2.sortingChanged(this);
      }

   }

   public void removeListener(ITreeNodeSorterListener var1) {
      this.listeners.removeListener(var1);
   }

   public void setCriterium(ESortByCriterium var1, ESortOrder var2, int var3, boolean var4) {
      if(var3 >= 0 && var3 <= 5) {
         if(((Pair)this.criteria.get(var3)).first() != var1 || ((Pair)this.criteria.get(var3)).second() != var2) {
            this.criteria.remove(var3);
            this.criteria.add(var3, new Pair(var1, var2));
            if(var4) {
               this.notifyListeners();
            }
         }

      } else {
         Logger.logSevere("Severe: Criterium depth is out of range.", new Object[0]);
      }
   }
}
