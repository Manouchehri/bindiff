package com.google.security.zynamics.bindiff.project.userview;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import java.util.Date;

public abstract class ViewData {
   private final GraphsContainer graphs;
   private String viewName;
   private String viewComment;
   private Date creationDate;
   private Date modificationDate;
   private final EViewType viewType;

   public ViewData(GraphsContainer var1, String var2, EViewType var3) {
      this.graphs = (GraphsContainer)Preconditions.checkNotNull(var1);
      this.viewName = (String)Preconditions.checkNotNull(var2);
      this.viewType = var3;
      this.viewComment = "";
      this.creationDate = null;
      this.modificationDate = null;
   }

   public static String getViewName(GraphsContainer var0) {
      Diff var1 = var0.getDiff();
      if(var1.isFunctionDiff()) {
         return CFileUtils.forceFilenameEndsNotWithExtension(var1.getDiffName(), "BinDiff");
      } else {
         IAddress var2 = var0.getPrimaryGraph().getFunctionAddress();
         IAddress var3 = var0.getSecondaryGraph().getFunctionAddress();
         String var4 = var1.getMetaData().getImageName(ESide.PRIMARY);
         if(var2 != null) {
            RawFunction var5 = var1.getFunction(var2, ESide.PRIMARY);
            if(var5 != null) {
               var4 = var5.getName();
            }
         } else if(var3 != null) {
            var4 = null;
         }

         String var7 = var1.getMetaData().getImageName(ESide.SECONDARY);
         if(var3 != null) {
            RawFunction var6 = var1.getFunction(var3, ESide.SECONDARY);
            if(var6 != null) {
               var7 = var6.getName();
            }
         } else if(var2 != null) {
            var7 = null;
         }

         return var4 == null?var7:(var7 == null?var4:String.format("%s vs %s", new Object[]{var4, var7}));
      }
   }

   public abstract IAddress getAddress(ESide var1);

   public Date getCreationDate() {
      return this.creationDate;
   }

   public GraphsContainer getGraphs() {
      return this.graphs;
   }

   public EMatchState getMatchState() {
      return this.isCallgraphView()?null:(this.getAddress(ESide.PRIMARY) != null && this.getAddress(ESide.SECONDARY) != null?EMatchState.MATCHED:(this.getAddress(ESide.PRIMARY) != null && this.getAddress(ESide.SECONDARY) == null?EMatchState.PRIMARY_UNMATCHED:(this.getAddress(ESide.PRIMARY) == null && this.getAddress(ESide.SECONDARY) != null?EMatchState.SECONDRAY_UNMATCHED:null)));
   }

   public Date getModificationDate() {
      return this.modificationDate;
   }

   public abstract MutableDirectedGraph getRawGraph(ESide var1);

   public String getViewComment() {
      return this.viewComment;
   }

   public String getViewName() {
      return this.viewName;
   }

   public abstract boolean isCallgraphView();

   public abstract boolean isFlowgraphView();

   public boolean isSingleFunctionDiffView() {
      return this.viewType == EViewType.SINGLE_FUNCTION_DIFF_VIEW;
   }

   public void setCreationDate(Date var1) {
      this.creationDate = var1;
   }

   public void setModificationDate(Date var1) {
      this.modificationDate = var1;
   }

   public void setViewComment(String var1) {
      this.viewComment = var1;
   }

   public void setViewName(String var1) {
      this.viewName = var1;
   }
}
