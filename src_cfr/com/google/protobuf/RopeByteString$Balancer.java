/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.RopeByteString;
import com.google.protobuf.RopeByteString$1;
import java.util.Arrays;
import java.util.Stack;

class RopeByteString$Balancer {
    private final Stack prefixesStack = new Stack();

    private RopeByteString$Balancer() {
    }

    private ByteString balance(ByteString byteString, ByteString byteString2) {
        this.doBalance(byteString);
        this.doBalance(byteString2);
        ByteString byteString3 = (ByteString)this.prefixesStack.pop();
        while (!this.prefixesStack.isEmpty()) {
            ByteString byteString4 = (ByteString)this.prefixesStack.pop();
            byteString3 = new RopeByteString(byteString4, byteString3, null);
        }
        return byteString3;
    }

    private void doBalance(ByteString byteString) {
        if (byteString.isBalanced()) {
            this.insert(byteString);
            return;
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString)byteString;
            this.doBalance(RopeByteString.access$400(ropeByteString));
            this.doBalance(RopeByteString.access$500(ropeByteString));
            return;
        }
        String string = String.valueOf(String.valueOf(byteString.getClass()));
        throw new IllegalArgumentException(new StringBuilder(49 + string.length()).append("Has a new type of ByteString been created? Found ").append(string).toString());
    }

    private void insert(ByteString byteString) {
        ByteString byteString2;
        int n2 = this.getDepthBinForLength(byteString.size());
        int n3 = RopeByteString.access$600()[n2 + 1];
        if (this.prefixesStack.isEmpty() || ((ByteString)this.prefixesStack.peek()).size() >= n3) {
            this.prefixesStack.push(byteString);
            return;
        }
        int n4 = RopeByteString.access$600()[n2];
        ByteString byteString3 = (ByteString)this.prefixesStack.pop();
        while (!this.prefixesStack.isEmpty() && ((ByteString)this.prefixesStack.peek()).size() < n4) {
            byteString2 = (ByteString)this.prefixesStack.pop();
            byteString3 = new RopeByteString(byteString2, byteString3, null);
        }
        byteString3 = new RopeByteString(byteString3, byteString, null);
        while (!this.prefixesStack.isEmpty()) {
            n2 = this.getDepthBinForLength(byteString3.size());
            n3 = RopeByteString.access$600()[n2 + 1];
            if (((ByteString)this.prefixesStack.peek()).size() >= n3) break;
            byteString2 = (ByteString)this.prefixesStack.pop();
            byteString3 = new RopeByteString(byteString2, byteString3, null);
        }
        this.prefixesStack.push(byteString3);
    }

    private int getDepthBinForLength(int n2) {
        int n3 = Arrays.binarySearch(RopeByteString.access$600(), n2);
        if (n3 >= 0) return n3;
        int n4 = - n3 + 1;
        return n4 - 1;
    }

    /* synthetic */ RopeByteString$Balancer(RopeByteString$1 ropeByteString$1) {
        this();
    }

    static /* synthetic */ ByteString access$100(RopeByteString$Balancer ropeByteString$Balancer, ByteString byteString, ByteString byteString2) {
        return ropeByteString$Balancer.balance(byteString, byteString2);
    }
}

