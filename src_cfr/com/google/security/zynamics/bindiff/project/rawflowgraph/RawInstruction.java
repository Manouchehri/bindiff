/*
 * Decompiled with CFR 0_115.
 */
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

    public RawInstruction(IAddress iAddress, String string, int n2, byte[] arrby, byte[] arrby2, long[] arrl, List list, int n3) {
        this.address = (IAddress)Preconditions.checkNotNull(iAddress);
        this.mnemonic = (String)Preconditions.checkNotNull(string);
        this.maxMnemonicLen = n2;
        this.instructionBytes = (byte[])Preconditions.checkNotNull(arrby);
        this.operands = (byte[])Preconditions.checkNotNull(arrby2);
        this.callTargetAddresses = (long[])Preconditions.checkNotNull(arrl);
        this.comments = list;
        this.prime = n3;
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
        int n2 = 0;
        byte[] arrby = this.operands;
        int n3 = arrby.length;
        int n4 = 0;
        while (n4 < n3) {
            byte by2 = arrby[n4];
            if (by2 > EInstructionHighlighting.ENUM_ENTRY_COUNT) {
                ++n2;
            }
            ++n4;
        }
        return n2;
    }

    public byte[] getOperands() {
        return this.operands;
    }

    public int getPrime() {
        return this.prime;
    }

    public boolean hasComments() {
        if (this.comments == null) return false;
        if (this.comments.size() <= 0) return false;
        return true;
    }

    public boolean isCall() {
        if (this.callTargetAddresses.length <= 0) return false;
        return true;
    }

    public void setComment(String string, ECommentPlacement eCommentPlacement) {
        RawInstructionComment rawInstructionComment;
        if (this.comments == null) {
            if ("".equals(string)) return;
            this.comments.clear();
            RawInstructionComment rawInstructionComment2 = new RawInstructionComment(string, eCommentPlacement);
            this.comments.add(rawInstructionComment2);
            return;
        }
        Iterator iterator = this.comments.iterator();
        do {
            if (!iterator.hasNext()) return;
        } while ((rawInstructionComment = (RawInstructionComment)iterator.next()).getPlacement() != eCommentPlacement);
        rawInstructionComment.setText(string);
        if (!"".equals(rawInstructionComment)) return;
        this.comments.remove(rawInstructionComment);
        if (this.comments.size() != 0) return;
        this.comments = null;
    }
}

