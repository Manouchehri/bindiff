package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.security.zynamics.bindiff.database.CommentsDatabase;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.io.matches.FunctionDiffSocketXmlData;
import com.google.security.zynamics.bindiff.io.proto.BinExportReader;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader$1;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader$2;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.matches.AddressTriple;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionDiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstructionComment;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.IProgressDescription;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.types.common.ICommand;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;
import javax.swing.SwingUtilities;

public class DiffLoader implements ICommand {
   private IProgressDescription descriptionTarget = null;
   private final LinkedHashSet diffs;

   public DiffLoader() {
      this.diffs = null;
   }

   public DiffLoader(LinkedHashSet var1) {
      this.diffs = (LinkedHashSet)Preconditions.checkNotNull(var1);
   }

   private static void setBasicblockComments(RawFlowGraph var0, Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         RawBasicBlock var4 = var0.getBasicblock((IAddress)var3.getKey());
         var4.setComment((String)var3.getValue());
      }

   }

   private static void setInstructionComment(RawFlowGraph var0, Map var1) {
      Iterator var2 = var0.getNodes().iterator();

      label49:
      while(var2.hasNext()) {
         RawBasicBlock var3 = (RawBasicBlock)var2.next();
         Iterator var4 = var3.getInstructions().entrySet().iterator();

         while(true) {
            while(true) {
               if(!var4.hasNext()) {
                  continue label49;
               }

               Entry var5 = (Entry)var4.next();
               IAddress var6 = (IAddress)var5.getKey();
               String var10;
               if(((RawInstruction)var5.getValue()).getComments() != null) {
                  Iterator var13 = ((RawInstruction)var5.getValue()).getComments().iterator();

                  while(var13.hasNext()) {
                     RawInstructionComment var14 = (RawInstructionComment)var13.next();
                     Pair var15 = Pair.make(var6, var14.getPlacement());
                     var10 = (String)var1.get(var15);
                     if(var10 != null) {
                        String var11 = var14.getText();
                        if(!var10.equals(var11) && var10.indexOf(var11) != 0) {
                           String var12 = String.valueOf(var11);
                           (new StringBuilder(4 + String.valueOf(var12).length() + String.valueOf(var10).length())).append(var12).append(" // ").append(var10).toString();
                        }

                        var14.setText(var10);
                     }
                  }
               } else {
                  Pair var7 = Pair.make(var6, ECommentPlacement.ABOVE_LINE);
                  Pair var8 = Pair.make(var6, ECommentPlacement.BEHIND_LINE);
                  String var9 = (String)var1.get(var7);
                  var10 = (String)var1.get(var8);
                  if(var9 != null) {
                     ((RawInstruction)var5.getValue()).setComment(var9, ECommentPlacement.ABOVE_LINE);
                  }

                  if(var10 != null) {
                     ((RawInstruction)var5.getValue()).setComment(var10, ECommentPlacement.BEHIND_LINE);
                  }
               }
            }
         }
      }

   }

   public static RawFlowGraph loadRawFlowgraph(CommentsDatabase var0, Diff var1, IAddress var2, ESide var3) {
      BinExportReader var4 = new BinExportReader(var1.getExportFile(ESide.PRIMARY), ESide.PRIMARY);
      BinExportReader var5 = new BinExportReader(var1.getExportFile(ESide.SECONDARY), ESide.SECONDARY);
      RawFunction var6 = var1.getCallgraph(var3).getFunction(var2);
      if(var6 == null) {
         return null;
      } else if(var6.getFunctionType() == EFunctionType.IMPORTED) {
         return new RawFlowGraph(var2, var6.getName(), var6.getFunctionType(), new ArrayList(), new ArrayList(), var3);
      } else {
         RawFlowGraph var7 = var3 == ESide.PRIMARY?var4.readFlowgraph(var1, var2):var5.readFlowgraph(var1, var2);
         String var8 = var1.getDiffMetaData().getImageHash(var3);
         if(var0 != null) {
            Map var9 = var0.readInstructionComments(var8, var2);
            Map var10 = var0.readBasicblockComments(var8, var2);
            setBasicblockComments(var7, var10);
            setInstructionComment(var7, var9);
         }

         return var7;
      }
   }

   public static DiffMetaData preloadDiffMatches(File var0) {
      MatchesDatabase var1 = new MatchesDatabase(var0);
      Throwable var2 = null;

      DiffMetaData var3;
      try {
         var3 = var1.loadDiffMetaData(var0);
      } catch (Throwable var12) {
         var2 = var12;
         throw var12;
      } finally {
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var11) {
                  var2.addSuppressed(var11);
               }
            } else {
               var1.close();
            }
         }

      }

      return var3;
   }

   private void loadDiff(Diff var1) {
      if(var1.isLoaded()) {
         Logger.logInfo("Diff is already loaded!", new Object[0]);
      } else {
         this.descriptionTarget.setDescription(String.format("Loading Diff \'%s\'", new Object[]{var1.getDiffName()}));
         Logger.logInfo("Loading Diff \'%s\'", new Object[]{var1.getDiffName()});
         this.validateInputFiles(var1);

         try {
            this.setSubDescription("Loading function matches...");
            this.loadDiffMatches(var1);
            this.loadRawCallgraphs(var1);
            this.setSubDescription("Setting function matches...");
            this.setFunctionMatches(var1);
            this.setSubDescription("Loading call matches...");
            this.setCallMatches(var1);
            this.setChangedFunctionsCount(var1);
            var1.setLoaded(true);
         } catch (SQLException var3) {
            Logger.logException(var3);
            throw var3;
         }

         this.setSubDescription("Preparing UI...");
         SwingUtilities.invokeLater(new DiffLoader$1(this, var1));
      }
   }

   private void loadDiffMatches(Diff var1) {
      File var2 = var1.getMatchesDatabase();
      if(!var2.exists()) {
         throw new IOException(String.format("Couldn\'t find \'%s%s%s\'.", new Object[]{var2.getPath(), File.separator, var2.getName()}));
      } else {
         String var3 = String.valueOf(var2.getPath());
         Logger.logInfo((new StringBuilder(18 + String.valueOf(var3).length())).append(" - Loading Diff \'").append(var3).append("\'").toString(), new Object[0]);
         MatchesDatabase var15 = new MatchesDatabase(var2);
         Throwable var4 = null;

         try {
            var1.setMatches(var15.loadFunctionMatches(var1));
         } catch (Throwable var13) {
            var4 = var13;
            throw var13;
         } finally {
            if(var15 != null) {
               if(var4 != null) {
                  try {
                     var15.close();
                  } catch (Throwable var12) {
                     var4.addSuppressed(var12);
                  }
               } else {
                  var15.close();
               }
            }

         }

      }
   }

   private void loadRawCallgraphs(Diff var1) {
      BinExportReader var2 = new BinExportReader(var1.getExportFile(ESide.PRIMARY), ESide.PRIMARY);
      BinExportReader var3 = new BinExportReader(var1.getExportFile(ESide.SECONDARY), ESide.SECONDARY);
      RawCallGraph var4;
      RawCallGraph var5;
      if(!var1.isFunctionDiff()) {
         this.setSubDescription("Read raw primary callgraph...");
         var4 = var2.readCallgraph();
         this.setSubDescription("Read raw secondary callgraph...");
         var5 = var3.readCallgraph();
      } else {
         FunctionDiffMetaData var6 = (FunctionDiffMetaData)var1.getMetaData();
         String var7 = var6.getFunctionName(ESide.PRIMARY);
         EFunctionType var8 = var6.getFunctionType(ESide.PRIMARY);
         IAddress var9 = var1.getMatches().getFunctionMatches()[0].getIAddress(ESide.PRIMARY);
         RawFunction var10 = new RawFunction(var9, var7, var8, ESide.PRIMARY);
         ArrayList var11 = new ArrayList();
         var11.add(var10);
         var4 = new RawCallGraph(var11, new ArrayList(), ESide.PRIMARY);
         String var12 = var6.getFunctionName(ESide.SECONDARY);
         EFunctionType var13 = var6.getFunctionType(ESide.SECONDARY);
         IAddress var14 = var1.getMatches().getFunctionMatches()[0].getIAddress(ESide.SECONDARY);
         RawFunction var15 = new RawFunction(var14, var12, var13, ESide.SECONDARY);
         ArrayList var16 = new ArrayList();
         var16.add(var15);
         var5 = new RawCallGraph(var16, new ArrayList(), ESide.SECONDARY);
         MatchesDatabase var17 = new MatchesDatabase(var1.getMatchesDatabase());
         Throwable var18 = null;

         try {
            var17.setFunctionDiffCounts(var10, var15);
         } catch (Throwable var27) {
            var18 = var27;
            throw var27;
         } finally {
            if(var17 != null) {
               if(var18 != null) {
                  try {
                     var17.close();
                  } catch (Throwable var26) {
                     var18.addSuppressed(var26);
                  }
               } else {
                  var17.close();
               }
            }

         }
      }

      var1.setCallgraph(var4, ESide.PRIMARY);
      var1.setCallgraph(var5, ESide.SECONDARY);
      if(!var1.isFunctionDiff()) {
         this.setSubDescription("Preprocessing raw primary flowgraphs...");
         var2.readFlowgraphsStatistics(var1);
         this.setSubDescription("Preprocessing raw secondary flowgraphs...");
         var3.readFlowgraphsStatistics(var1);
      }

   }

   private void loadSingleFunctionDiffRawCallgraphs(Diff var1, FunctionDiffSocketXmlData var2) {
      BinExportReader var3 = new BinExportReader(var1.getExportFile(ESide.PRIMARY), ESide.PRIMARY);
      BinExportReader var4 = new BinExportReader(var1.getExportFile(ESide.SECONDARY), ESide.SECONDARY);
      this.setSubDescription("Read raw primary callgraph...");
      RawCallGraph var5 = var3.readSingleFunctionDiffCallgraph(var2);
      var1.setCallgraph(var5, ESide.PRIMARY);
      this.setSubDescription("Read raw secondary callgraph...");
      RawCallGraph var6 = var4.readSingleFunctionDiffCallgraph(var2);
      var1.setCallgraph(var6, ESide.SECONDARY);
   }

   private void setCallMatches(Diff var1) {
      File var2 = var1.getMatchesDatabase();
      if(!var2.exists()) {
         throw new IOException(String.format("Couldn\'t find \'%s%s%s\'.", new Object[]{var2.getPath(), File.separator, var2.getName()}));
      } else {
         MatchesDatabase var3 = new MatchesDatabase(var2);
         Throwable var4 = null;

         try {
            int var5 = 0;
            Map var6 = var3.loadMatchedCallAddresses(var1);
            ImmutableMap var7 = Maps.uniqueIndex((Iterable)var1.getCallgraph(ESide.SECONDARY).getEdges(), new DiffLoader$2(this));
            Iterator var8 = var1.getCallgraph(ESide.PRIMARY).getEdges().iterator();

            long var12;
            long var14;
            while(var8.hasNext()) {
               RawCall var9 = (RawCall)var8.next();
               RawFunction var10 = (RawFunction)var9.getSource();
               RawFunction var11 = (RawFunction)var9.getTarget();
               var12 = var10.getAddress().toLong();
               var14 = var9.getSourceInstructionAddr().toLong();
               if(var10.getMatchedFunction() != null && var11.getMatchedFunction() != null) {
                  long var16 = var10.getMatchedFunction().getAddress().toLong();
                  long var18 = var11.getMatchedFunction().getAddress().toLong();
                  AddressPair var20 = new AddressPair(var12, var14);
                  AddressPair var21 = (AddressPair)var6.get(var20);
                  if(var21 != null) {
                     long var22 = var21.getAddress(ESide.SECONDARY);
                     AddressTriple var24 = new AddressTriple(var16, var18, var22);
                     RawCall var25 = (RawCall)var7.get(var24);
                     if(var25 != null) {
                        var9.setMatchState(true, var25);
                        var25.setMatchState(true, var9);
                        ++var5;
                     }
                  }
               }
            }

            HashMap var35 = new HashMap();
            Iterator var36 = var1.getCallgraph(ESide.SECONDARY).getEdges().iterator();

            while(var36.hasNext()) {
               RawCall var38 = (RawCall)var36.next();
               if(var38.getMatchedCall() == null) {
                  long var40 = ((RawFunction)var38.getSource()).getAddress().toLong();
                  long var13 = var38.getSourceInstructionAddr().toLong();
                  AddressPair var15 = new AddressPair(var40, var13);
                  Stack var42 = (Stack)var35.get(var15);
                  if(var42 == null) {
                     var42 = new Stack();
                     var35.put(var15, var42);
                  }

                  var42.push(var38);
               }
            }

            int var37 = 0;
            Iterator var39 = var1.getCallgraph(ESide.PRIMARY).getEdges().iterator();

            while(var39.hasNext()) {
               RawCall var41 = (RawCall)var39.next();
               if(var41.getMatchedCall() == null) {
                  var12 = ((RawFunction)var41.getSource()).getAddress().toLong();
                  var14 = var41.getSourceInstructionAddr().toLong();
                  if(((RawFunction)var41.getSource()).getMatchedFunction() != null) {
                     AddressPair var43 = new AddressPair(var12, var14);
                     AddressPair var17 = (AddressPair)var6.get(var43);
                     if(var17 != null) {
                        Stack var44 = (Stack)var35.get(var17);
                        if(var44 != null && var44.size() > 0) {
                           RawCall var19 = (RawCall)var44.pop();
                           var41.setMatchState(false, var19);
                           var19.setMatchState(false, var41);
                           ++var37;
                        }
                     }
                  }
               }
            }

            var1.getMatches().setSizeOfMatchedCalls(var5 + var37);
            var1.getMatches().setSizeOfChangedCalls(var37);
         } catch (Throwable var33) {
            var4 = var33;
            throw var33;
         } finally {
            if(var3 != null) {
               if(var4 != null) {
                  try {
                     var3.close();
                  } catch (Throwable var32) {
                     var4.addSuppressed(var32);
                  }
               } else {
                  var3.close();
               }
            }

         }

      }
   }

   private void setChangedFunctionsCount(Diff var1) {
      int var2 = 0;
      Iterator var3 = var1.getCallgraph(ESide.PRIMARY).getNodes().iterator();

      while(var3.hasNext()) {
         RawFunction var4 = (RawFunction)var3.next();
         if(var4.isChanged()) {
            ++var2;
         }
      }

      var1.getMatches().setSizeOfChangedFunctions(var2);
   }

   private void setFunctionMatches(Diff var1) {
      RawCallGraph var2 = var1.getCallgraph(ESide.PRIMARY);
      RawCallGraph var3 = var1.getCallgraph(ESide.SECONDARY);
      FunctionMatchData[] var4 = var1.getMatches().getFunctionMatches();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         FunctionMatchData var7 = var4[var6];
         RawFunction var8 = var2.getFunction(var7.getIAddress(ESide.PRIMARY));
         RawFunction var9 = var3.getFunction(var7.getIAddress(ESide.SECONDARY));
         if(var8 != null && var9 != null) {
            var8.setMatch(var9, var7);
            var9.setMatch(var8, var7);
         }
      }

   }

   private void setSubDescription(String var1) {
      if(this.descriptionTarget != null) {
         this.descriptionTarget.setSubDescription(var1);
      }

   }

   private void validateInputFiles(Diff var1) {
      if(!var1.getMatchesDatabase().exists()) {
         throw new IOException("Load Diff graphs failed. Matches dababase file can not be found.");
      } else if(!var1.getExportFile(ESide.PRIMARY).exists()) {
         throw new IOException("Load Diff graphs failed. Primary exported file can not be found.");
      } else if(!var1.getExportFile(ESide.SECONDARY).exists()) {
         throw new IOException("Load Diff graphs failed. Secondary exported file can not be found.");
      } else if(!var1.getExportFile(ESide.PRIMARY).canRead()) {
         throw new IOException("Load Diff graphs failed. Couldn\'t read primary exported call graph file.");
      } else if(!var1.getExportFile(ESide.SECONDARY).canRead()) {
         throw new IOException("Load Diff graphs failed. Couldn\'t read secondary exported call graph file.");
      }
   }

   public void execute() {
      Iterator var1 = this.diffs.iterator();

      while(var1.hasNext()) {
         Diff var2 = (Diff)var1.next();
         this.loadDiff(var2);
      }

   }

   public void loadDiff(Diff var1, FunctionDiffSocketXmlData var2) {
      // $FF: Couldn't be decompiled
   }

   public void setProgressDescriptionTarget(IProgressDescription var1) {
      this.descriptionTarget = var1;
   }
}
