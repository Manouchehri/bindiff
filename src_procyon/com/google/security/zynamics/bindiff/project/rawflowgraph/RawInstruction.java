package com.google.security.zynamics.bindiff.project.rawflowgraph;

import com.google.security.zynamics.zylib.disassembly.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.util.*;

public class RawInstruction
{
    private final IAddress address;
    private final String mnemonic;
    private final int maxMnemonicLen;
    private final byte[] instructionBytes;
    private final byte[] operands;
    private final long[] callTargetAddresses;
    private final int prime;
    private List comments;
    
    public RawInstruction(final IAddress address, final String s, final int maxMnemonicLen, final byte[] array, final byte[] array2, final long[] array3, final List comments, final int prime) {
        this.comments = null;
        this.address = (IAddress)Preconditions.checkNotNull(address);
        this.mnemonic = (String)Preconditions.checkNotNull(s);
        this.maxMnemonicLen = maxMnemonicLen;
        this.instructionBytes = (byte[])Preconditions.checkNotNull(array);
        this.operands = (byte[])Preconditions.checkNotNull(array2);
        this.callTargetAddresses = (long[])Preconditions.checkNotNull(array3);
        this.comments = comments;
        this.prime = prime;
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
        int n = 0;
        final byte[] operands = this.operands;
        for (int length = operands.length, i = 0; i < length; ++i) {
            if (operands[i] > EInstructionHighlighting.ENUM_ENTRY_COUNT) {
                ++n;
            }
        }
        return n;
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
    
    public void setComment(final String text, final ECommentPlacement eCommentPlacement) {
        if (this.comments != null) {
            for (final RawInstructionComment rawInstructionComment : this.comments) {
                if (rawInstructionComment.getPlacement() == eCommentPlacement) {
                    rawInstructionComment.setText(text);
                    if ("".equals(rawInstructionComment)) {
                        this.comments.remove(rawInstructionComment);
                        if (this.comments.size() == 0) {
                            this.comments = null;
                        }
                    }
                }
            }
        }
        else if (!"".equals(text)) {
            this.comments.clear();
            this.comments.add(new RawInstructionComment(text, eCommentPlacement));
        }
    }
}
