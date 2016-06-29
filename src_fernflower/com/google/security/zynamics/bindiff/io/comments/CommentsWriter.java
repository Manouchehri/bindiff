package com.google.security.zynamics.bindiff.io.comments;

import com.google.security.zynamics.bindiff.database.CommentsDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstructionComment;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import java.sql.SQLException;
import java.util.Iterator;

public final class CommentsWriter {
   private static void writeBasicblockComment(CommentsDatabase var0, String var1, IAddress var2, IAddress var3, String var4) {
      if(var4 != null) {
         var0.writeBasicblockComment(var1, var2, var3, var4);
      }

   }

   private static Pair writeComments(CommentsDatabase var0, String var1, RawFlowGraph var2) {
      int var3 = 0;
      int var4 = 0;
      if(var2 != null) {
         Iterator var5 = var2.iterator();

         label53:
         while(var5.hasNext()) {
            RawBasicBlock var6 = (RawBasicBlock)var5.next();
            IAddress var7 = var6.getFunctionAddr();
            if(var6.isChangedComment()) {
               IAddress var8 = var6.getAddress();
               String var9 = var6.getComment();

               try {
                  ++var4;
                  writeBasicblockComment(var0, var1, var7, var8, var9);
               } catch (SQLException var15) {
                  ++var3;
               }
            }

            Iterator var16 = var6.iterator();

            while(true) {
               RawInstruction var17;
               do {
                  if(!var16.hasNext()) {
                     continue label53;
                  }

                  var17 = (RawInstruction)var16.next();
               } while(!var17.hasComments());

               Iterator var10 = var17.getComments().iterator();

               while(var10.hasNext()) {
                  RawInstructionComment var11 = (RawInstructionComment)var10.next();
                  if(var11.isChangedComment()) {
                     IAddress var12 = var17.getAddress();

                     try {
                        ++var4;
                        writeInstructionComment(var0, var1, var7, var12, var11);
                     } catch (SQLException var14) {
                        ++var3;
                     }
                  }
               }
            }
         }
      }

      return new Pair(Integer.valueOf(var3), Integer.valueOf(var4));
   }

   private static void writeInstructionComment(CommentsDatabase var0, String var1, IAddress var2, IAddress var3, RawInstructionComment var4) {
      if(var4.isChangedComment()) {
         String var5 = var4.getText();
         if(var4 != null) {
            ECommentPlacement var6 = var4.getPlacement();
            var0.writeInstructionComment(var1, var2, var3, var6, var5);
         }
      }

   }

   public static void writeComments(Workspace var0, String var1, String var2, ViewData var3) {
      CommentsDatabase var4 = new CommentsDatabase(var0, false);
      Throwable var5 = null;

      try {
         if(var3.isFlowgraphView()) {
            RawFlowGraph var6 = ((FlowGraphViewData)var3).getRawGraph(ESide.PRIMARY);
            Pair var7 = writeComments(var4, var1, var6);
            RawFlowGraph var8 = ((FlowGraphViewData)var3).getRawGraph(ESide.SECONDARY);
            Pair var9 = writeComments(var4, var2, var8);
            int var10 = ((Integer)var7.first()).intValue() + ((Integer)var9.first()).intValue();
            int var11 = ((Integer)var7.second()).intValue() + ((Integer)var9.second()).intValue();
            if(var10 > 0) {
               throw new SQLException(String.format("View \'s%\' failed to write %d of %d changed comments.", new Object[]{var3.getViewName(), Integer.valueOf(var10), Integer.valueOf(var11)}));
            }
         }
      } catch (Throwable var19) {
         var5 = var19;
         throw var19;
      } finally {
         if(var4 != null) {
            if(var5 != null) {
               try {
                  var4.close();
               } catch (Throwable var18) {
                  var5.addSuppressed(var18);
               }
            } else {
               var4.close();
            }
         }

      }

   }
}
