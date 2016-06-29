package com.google.protobuf;

import java.nio.*;
import java.nio.charset.*;
import java.io.*;
import java.util.*;

class RopeByteString$Balancer
{
    private final Stack prefixesStack;
    
    private RopeByteString$Balancer() {
        this.prefixesStack = new Stack();
    }
    
    private ByteString balance(final ByteString byteString, final ByteString byteString2) {
        this.doBalance(byteString);
        this.doBalance(byteString2);
        ByteString byteString3 = this.prefixesStack.pop();
        while (!this.prefixesStack.isEmpty()) {
            byteString3 = new RopeByteString(this.prefixesStack.pop(), byteString3, null);
        }
        return byteString3;
    }
    
    private void doBalance(final ByteString byteString) {
        if (byteString.isBalanced()) {
            this.insert(byteString);
        }
        else {
            if (!(byteString instanceof RopeByteString)) {
                final String value = String.valueOf(String.valueOf(byteString.getClass()));
                throw new IllegalArgumentException(new StringBuilder(49 + value.length()).append("Has a new type of ByteString been created? Found ").append(value).toString());
            }
            final RopeByteString ropeByteString = (RopeByteString)byteString;
            this.doBalance(ropeByteString.left);
            this.doBalance(ropeByteString.right);
        }
    }
    
    private void insert(final ByteString byteString) {
        final int depthBinForLength = this.getDepthBinForLength(byteString.size());
        final int n = RopeByteString.minLengthByDepth[depthBinForLength + 1];
        if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= n) {
            this.prefixesStack.push(byteString);
        }
        else {
            final int n2 = RopeByteString.minLengthByDepth[depthBinForLength];
            ByteString byteString2 = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty() && this.prefixesStack.peek().size() < n2) {
                byteString2 = new RopeByteString(this.prefixesStack.pop(), byteString2, null);
            }
            RopeByteString ropeByteString;
            for (ropeByteString = new RopeByteString(byteString2, byteString, null); !this.prefixesStack.isEmpty() && this.prefixesStack.peek().size() < RopeByteString.minLengthByDepth[this.getDepthBinForLength(ropeByteString.size()) + 1]; ropeByteString = new RopeByteString(this.prefixesStack.pop(), ropeByteString, null)) {}
            this.prefixesStack.push(ropeByteString);
        }
    }
    
    private int getDepthBinForLength(final int n) {
        int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, n);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 1) - 1;
        }
        return binarySearch;
    }
}
