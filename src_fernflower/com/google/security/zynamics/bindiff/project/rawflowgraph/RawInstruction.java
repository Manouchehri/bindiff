package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EInstructionHighlighting;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawInstructionComment;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import java.util.Iterator;
import java.util.List;

public class RawInstruction {
   private final IAddress address;
   private final String mnemonic;
   private final int maxMnemonicLen;
   private final byte[] instructionBytes;
   private final byte[] operands;
   private final long[] callTargetAddresses;
   private final int prime;
   private List comments = null;

   public RawInstruction(IAddress var1, String var2, int var3, byte[] var4, byte[] var5, long[] var6, List var7, int var8) {
      this.address = (IAddress)Preconditions.checkNotNull(var1);
      this.mnemonic = (String)Preconditions.checkNotNull(var2);
      this.maxMnemonicLen = var3;
      this.instructionBytes = (byte[])Preconditions.checkNotNull(var4);
      this.operands = (byte[])Preconditions.checkNotNull(var5);
      this.callTargetAddresses = (long[])Preconditions.checkNotNull(var6);
      this.comments = var7;
      this.prime = var8;
   }

   public IAddress getAddress() {
      return this.address;
   }

   public long[] getCallTargetAddresses() {
      return this.callTargetAddresses;
   }

   public List getComments() {
      return this.comments;
   }

   public byte[] getInstructionBytes() {
      return this.instructionBytes;
   }

   public String getMnemonic() {
      return this.mnemonic;
   }

   public int getMaxMnemonicLen() {
      return this.maxMnemonicLen;
   }

   public int getOperandLength() {
      int var1 = 0;
      byte[] var2 = this.operands;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         byte var5 = var2[var4];
         if(var5 > EInstructionHighlighting.ENUM_ENTRY_COUNT) {
            ++var1;
         }
      }

      return var1;
   }

   public byte[] getOperands() {
      return this.operands;
   }

   public int getPrime() {
      return this.prime;
   }

   public boolean hasComments() {
      return this.comments != null && this.comments.size() > 0;
   }

   public boolean isCall() {
      return this.callTargetAddresses.length > 0;
   }

   public void setComment(String var1, ECommentPlacement var2) {
      if(this.comments != null) {
         Iterator var3 = this.comments.iterator();

         while(var3.hasNext()) {
            RawInstructionComment var4 = (RawInstructionComment)var3.next();
            if(var4.getPlacement() == var2) {
               var4.setText(var1);
               if("".equals(var4)) {
                  this.comments.remove(var4);
                  if(this.comments.size() == 0) {
                     this.comments = null;
                  }
               }

               return;
            }
         }
      } else if(!"".equals(var1)) {
         this.comments.clear();
         RawInstructionComment var5 = new RawInstructionComment(var1, var2);
         this.comments.add(var5);
      }

   }
}
