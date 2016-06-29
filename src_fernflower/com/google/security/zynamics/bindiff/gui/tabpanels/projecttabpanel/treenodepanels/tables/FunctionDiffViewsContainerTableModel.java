package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractFunctionDiffViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.DateComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FunctionDiffViewsContainerTableModel extends AbstractFunctionDiffViewsTableModel {
   public static final int PRIMARY_IMAGE_NAME = 0;
   public static final int PRIMARY_IMAGE_HASH = 1;
   public static final int SECONDARY_IMAGE_NAME = 2;
   public static final int SECONDARY_IMAGE_HASH = 3;
   public static final int VIEW_NAME = 4;
   public static final int CREATION_DATE = 5;
   private static final String[] COLUMNS = new String[]{"Primary Image Name", "Primary Image Hash", "Secondary Image Name", "Secondary Image Hash", "View Name", "Creation Date"};
   private final List sorters = new ArrayList();

   public FunctionDiffViewsContainerTableModel(List var1) {
      super(var1);
   }

   public int getColumnCount() {
      return COLUMNS.length;
   }

   public String getColumnName(int var1) {
      return COLUMNS[var1];
   }

   public List getSorters() {
      this.sorters.add(new Pair(Integer.valueOf(0), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(1), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(2), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(3), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(4), new LexicalComparator()));
      this.sorters.add(new Pair(Integer.valueOf(5), new DateComparator()));
      return this.sorters;
   }

   public Object getValueAt(int var1, int var2) {
      Diff var3 = (Diff)this.functionDiffViewList.get(var1);
      DiffMetaData var4 = var3.getMetaData();
      String var5 = CFileUtils.forceFilenameEndsNotWithExtension(var3.getMatchesDatabase().getName(), "BinDiff");
      Date var6 = var4.getDate().getTime();
      switch(var2) {
      case 0:
         return var4.getImageName(ESide.PRIMARY);
      case 1:
         return var4.getImageHash(ESide.PRIMARY);
      case 2:
         return var4.getImageName(ESide.SECONDARY);
      case 3:
         return var4.getImageHash(ESide.SECONDARY);
      case 4:
         return var5;
      case 5:
         return var6;
      default:
         return null;
      }
   }
}
