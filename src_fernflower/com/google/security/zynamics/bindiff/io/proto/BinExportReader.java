package com.google.security.zynamics.bindiff.io.proto;

import com.google.protobuf.ByteString;
import com.google.protos.BinExport.BinExport$Callgraph;
import com.google.protos.BinExport.BinExport$Callgraph$Edge;
import com.google.protos.BinExport.BinExport$Callgraph$Vertex;
import com.google.protos.BinExport.BinExport$Flowgraph;
import com.google.protos.BinExport.BinExport$Flowgraph$Edge;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction;
import com.google.protos.BinExport.BinExport$Flowgraph$Vertex$Instruction$Comment;
import com.google.protos.BinExport.BinExport$Meta;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.EJumpType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.io.matches.FunctionDiffSocketXmlData;
import com.google.security.zynamics.bindiff.io.proto.LimitedInputStream;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstruction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstructionComment;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.bindiff.utils.FlagUtils;
import com.google.security.zynamics.bindiff.utils.IoReaderUtils;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class BinExportReader {
   private static final byte ANTERIOR_COMMENT_TYPE_BIT = 3;
   private final File file;
   private final ESide side;
   private final int metaOffset;
   private final int callgraphOffset;
   private final long[] flowgraphAddrs;
   private final int[] flowgraphFileOffsets;
   private int addressSpaceBits;
   private String architectureName;
   private int maxMnemonicLen;

   public BinExportReader(File var1, ESide var2) {
      // $FF: Couldn't be decompiled
   }

   private static BufferedInputStream openStream(File var0) {
      // $FF: Couldn't be decompiled
   }

   private long getFunctionAddress(int var1) {
      int var2 = 0;
      int[] var3 = this.flowgraphFileOffsets;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int var6 = var3[var5];
         if(var6 == var1) {
            return this.flowgraphAddrs[var2];
         }

         ++var2;
      }

      throw new IOException("Illegal flow graph offset. Couldn\'t find entry address.");
   }

   private List readBasicblocks(Diff var1, FunctionMatchData var2, BinExport$Flowgraph var3) {
      ArrayList var4 = new ArrayList();

      try {
         CAddress var5 = new CAddress(var3.getAddress());
         String var6 = var1.getCallgraph(this.side).getFunction(var5).getName();
         Iterator var7 = var3.getVerticesList().iterator();

         while(var7.hasNext()) {
            BinExport$Flowgraph$Vertex var8 = (BinExport$Flowgraph$Vertex)var7.next();
            EMatchState var9 = this.side == ESide.PRIMARY?EMatchState.PRIMARY_UNMATCHED:EMatchState.SECONDRAY_UNMATCHED;
            CAddress var10 = new CAddress(var8.getInstructions(0).getAddress());
            BasicBlockMatchData var11 = null;
            if(var2 != null) {
               var11 = var2.getBasicblockMatch(var10, this.side);
               if(var11 != null) {
                  var9 = EMatchState.MATCHED;
               }
            }

            SortedMap var12 = this.readInstructions(var8, this.maxMnemonicLen);
            long var13 = var8.getPrime();
            RawBasicBlock var15 = new RawBasicBlock(var5, var6, var10, var12, var13, this.side, var9);
            var4.add(var15);
         }

         return var4;
      } catch (Exception var16) {
         throw new IOException("Couldn\'t read exported basicblocks. Failed to read flowgraph.", var16);
      }
   }

   private void readFlowgraphOffsets(InputStream var1) {
      try {
         for(int var2 = 0; var2 < this.flowgraphAddrs.length; ++var2) {
            this.flowgraphAddrs[var2] = IoReaderUtils.readLongValue(var1, 8);
            this.flowgraphFileOffsets[var2] = IoReaderUtils.readIntegerValue(var1, 4);
         }

      } catch (Exception var3) {
         throw new IOException("Couldn\'t read exported file header. Failed to read flow graph offsets.");
      }
   }

   private SortedMap readInstructions(BinExport$Flowgraph$Vertex var1, int var2) {
      TreeMap var3 = new TreeMap();

      try {
         Iterator var4 = var1.getInstructionsList().iterator();

         while(var4.hasNext()) {
            BinExport$Flowgraph$Vertex$Instruction var5 = (BinExport$Flowgraph$Vertex$Instruction)var4.next();
            CAddress var6 = new CAddress(var5.getAddress());
            String var7 = var5.getMnemonic();
            byte[] var8 = var5.getRawBytes().toByteArray();
            byte[] var9 = ByteString.copyFromUtf8(var5.getOperands()).toByteArray();
            int var10 = 0;
            long[] var11 = new long[var5.getCallTargetsCount()];

            long var13;
            for(Iterator var12 = var5.getCallTargetsList().iterator(); var12.hasNext(); var11[var10++] = var13) {
               var13 = ((Long)var12.next()).longValue();
            }

            int var21 = var5.getCommentsCount();
            ArrayList var22 = var21 == 0?null:new ArrayList();
            Iterator var14 = var5.getCommentsList().iterator();

            while(var14.hasNext()) {
               BinExport$Flowgraph$Vertex$Instruction$Comment var15 = (BinExport$Flowgraph$Vertex$Instruction$Comment)var14.next();
               String var16 = var15.getComment();
               int var17 = var15.getFlags() >> 1 & 15;
               ECommentPlacement var18 = ECommentPlacement.BEHIND_LINE;
               if(FlagUtils.parseFlag((int)var17, (byte)3)) {
                  var18 = ECommentPlacement.ABOVE_LINE;
               }

               RawInstructionComment var19 = new RawInstructionComment(var16, var18);
               var22.add(var19);
            }

            int var23 = var5.getPrime();
            RawInstruction var24 = new RawInstruction(var6, var7, var2, var8, var9, var11, var22, var23);
            var3.put(var6, var24);
         }

         return var3;
      } catch (Exception var20) {
         throw new IOException("Couldn\'t read exported instructions. Failed to read flowgraph.", var20);
      }
   }

   private List readJumps(BinExport$Flowgraph var1, List var2) {
      ArrayList var3 = new ArrayList();

      try {
         HashMap var4 = new HashMap();
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            RawBasicBlock var6 = (RawBasicBlock)var5.next();
            var4.put(Long.valueOf(var6.getAddress().toLong()), var6);
         }

         var5 = var1.getEdgesList().iterator();

         while(var5.hasNext()) {
            BinExport$Flowgraph$Edge var11 = (BinExport$Flowgraph$Edge)var5.next();
            RawBasicBlock var7 = (RawBasicBlock)var4.get(Long.valueOf(var11.getSourceAddress()));
            RawBasicBlock var8 = (RawBasicBlock)var4.get(Long.valueOf(var11.getTargetAddress()));
            EJumpType var9 = this.translateJumpType(var11.getType().getNumber());
            var3.add(new RawJump(var7, var8, var9));
         }

         return var3;
      } catch (Exception var10) {
         throw new IOException("Couldn\'t read exported jumps. Failed to read flowgraph.", var10);
      }
   }

   private void setSizeOfFlowgraphElements(Diff var1, BinExport$Flowgraph var2) {
      CAddress var3 = new CAddress(var2.getAddress());
      RawFunction var4 = var1.getCallgraph(this.side).getFunction(var3);
      var4.setSizeOfBasicblocks(var2.getVerticesCount());
      var4.setSizeOfJumps(var2.getEdgesCount());
      int var5 = 0;

      BinExport$Flowgraph$Vertex var7;
      for(Iterator var6 = var2.getVerticesList().iterator(); var6.hasNext(); var5 += var7.getInstructionsCount()) {
         var7 = (BinExport$Flowgraph$Vertex)var6.next();
      }

      var4.setSizeOfInstructions(var5);
   }

   private EFunctionType translateFunctionType(int var1) {
      if(var1 == 2) {
         var1 = 3;
      } else if(var1 == 3) {
         var1 = 2;
      }

      return EFunctionType.getType(var1);
   }

   private EJumpType translateJumpType(int var1) {
      return EJumpType.getType(var1 - 1);
   }

   public RawCallGraph readCallgraph() {
      // $FF: Couldn't be decompiled
   }

   public RawFlowGraph readFlowgraph(Diff var1, IAddress var2) {
      // $FF: Couldn't be decompiled
   }

   public void readFlowgraphsStatistics(Diff var1) {
      // $FF: Couldn't be decompiled
   }

   public RawCallGraph readSingleFunctionDiffCallgraph(FunctionDiffSocketXmlData var1) {
      // $FF: Couldn't be decompiled
   }

   public int getAddressSpaceBits() {
      return this.addressSpaceBits;
   }

   public String getArchitectureName() {
      return this.architectureName;
   }

   public int getMaxMnemonicLen() {
      return this.maxMnemonicLen;
   }
}
