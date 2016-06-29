package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import com.google.common.primitives.*;
import java.io.*;
import java.util.*;

final class TreeMultiset$AvlNode extends Multisets$AbstractEntry
{
    @Nullable
    private final Object elem;
    private int elemCount;
    private int distinctElements;
    private long totalCount;
    private int height;
    private TreeMultiset$AvlNode left;
    private TreeMultiset$AvlNode right;
    private TreeMultiset$AvlNode pred;
    private TreeMultiset$AvlNode succ;
    
    TreeMultiset$AvlNode(@Nullable final Object elem, final int elemCount) {
        Preconditions.checkArgument(elemCount > 0);
        this.elem = elem;
        this.elemCount = elemCount;
        this.totalCount = elemCount;
        this.distinctElements = 1;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
    
    public int count(final Comparator comparator, final Object o) {
        final int compare = comparator.compare(o, this.elem);
        if (compare < 0) {
            return (this.left == null) ? 0 : this.left.count(comparator, o);
        }
        if (compare > 0) {
            return (this.right == null) ? 0 : this.right.count(comparator, o);
        }
        return this.elemCount;
    }
    
    private TreeMultiset$AvlNode addRightChild(final Object o, final int n) {
        successor(this, this.right = new TreeMultiset$AvlNode(o, n), this.succ);
        this.height = Math.max(2, this.height);
        ++this.distinctElements;
        this.totalCount += n;
        return this;
    }
    
    private TreeMultiset$AvlNode addLeftChild(final Object o, final int n) {
        this.left = new TreeMultiset$AvlNode(o, n);
        successor(this.pred, this.left, this);
        this.height = Math.max(2, this.height);
        ++this.distinctElements;
        this.totalCount += n;
        return this;
    }
    
    TreeMultiset$AvlNode add(final Comparator comparator, @Nullable final Object o, final int n, final int[] array) {
        final int compare = comparator.compare(o, this.elem);
        if (compare < 0) {
            final TreeMultiset$AvlNode left = this.left;
            if (left == null) {
                array[0] = 0;
                return this.addLeftChild(o, n);
            }
            final int height = left.height;
            this.left = left.add(comparator, o, n, array);
            if (array[0] == 0) {
                ++this.distinctElements;
            }
            this.totalCount += n;
            return (this.left.height == height) ? this : this.rebalance();
        }
        else {
            if (compare <= 0) {
                array[0] = this.elemCount;
                Preconditions.checkArgument(this.elemCount + n <= 2147483647L);
                this.elemCount += n;
                this.totalCount += n;
                return this;
            }
            final TreeMultiset$AvlNode right = this.right;
            if (right == null) {
                array[0] = 0;
                return this.addRightChild(o, n);
            }
            final int height2 = right.height;
            this.right = right.add(comparator, o, n, array);
            if (array[0] == 0) {
                ++this.distinctElements;
            }
            this.totalCount += n;
            return (this.right.height == height2) ? this : this.rebalance();
        }
    }
    
    TreeMultiset$AvlNode remove(final Comparator comparator, @Nullable final Object o, final int n, final int[] array) {
        final int compare = comparator.compare(o, this.elem);
        if (compare < 0) {
            final TreeMultiset$AvlNode left = this.left;
            if (left == null) {
                array[0] = 0;
                return this;
            }
            this.left = left.remove(comparator, o, n, array);
            if (array[0] > 0) {
                if (n >= array[0]) {
                    --this.distinctElements;
                    this.totalCount -= array[0];
                }
                else {
                    this.totalCount -= n;
                }
            }
            return (array[0] == 0) ? this : this.rebalance();
        }
        else if (compare > 0) {
            final TreeMultiset$AvlNode right = this.right;
            if (right == null) {
                array[0] = 0;
                return this;
            }
            this.right = right.remove(comparator, o, n, array);
            if (array[0] > 0) {
                if (n >= array[0]) {
                    --this.distinctElements;
                    this.totalCount -= array[0];
                }
                else {
                    this.totalCount -= n;
                }
            }
            return this.rebalance();
        }
        else {
            array[0] = this.elemCount;
            if (n >= this.elemCount) {
                return this.deleteMe();
            }
            this.elemCount -= n;
            this.totalCount -= n;
            return this;
        }
    }
    
    TreeMultiset$AvlNode setCount(final Comparator comparator, @Nullable final Object o, final int elemCount, final int[] array) {
        final int compare = comparator.compare(o, this.elem);
        if (compare < 0) {
            final TreeMultiset$AvlNode left = this.left;
            if (left == null) {
                array[0] = 0;
                return (elemCount > 0) ? this.addLeftChild(o, elemCount) : this;
            }
            this.left = left.setCount(comparator, o, elemCount, array);
            if (elemCount == 0 && array[0] != 0) {
                --this.distinctElements;
            }
            else if (elemCount > 0 && array[0] == 0) {
                ++this.distinctElements;
            }
            this.totalCount += elemCount - array[0];
            return this.rebalance();
        }
        else if (compare > 0) {
            final TreeMultiset$AvlNode right = this.right;
            if (right == null) {
                array[0] = 0;
                return (elemCount > 0) ? this.addRightChild(o, elemCount) : this;
            }
            this.right = right.setCount(comparator, o, elemCount, array);
            if (elemCount == 0 && array[0] != 0) {
                --this.distinctElements;
            }
            else if (elemCount > 0 && array[0] == 0) {
                ++this.distinctElements;
            }
            this.totalCount += elemCount - array[0];
            return this.rebalance();
        }
        else {
            array[0] = this.elemCount;
            if (elemCount == 0) {
                return this.deleteMe();
            }
            this.totalCount += elemCount - this.elemCount;
            this.elemCount = elemCount;
            return this;
        }
    }
    
    TreeMultiset$AvlNode setCount(final Comparator comparator, @Nullable final Object o, final int n, final int elemCount, final int[] array) {
        final int compare = comparator.compare(o, this.elem);
        if (compare < 0) {
            final TreeMultiset$AvlNode left = this.left;
            if (left != null) {
                this.left = left.setCount(comparator, o, n, elemCount, array);
                if (array[0] == n) {
                    if (elemCount == 0 && array[0] != 0) {
                        --this.distinctElements;
                    }
                    else if (elemCount > 0 && array[0] == 0) {
                        ++this.distinctElements;
                    }
                    this.totalCount += elemCount - array[0];
                }
                return this.rebalance();
            }
            array[0] = 0;
            if (n == 0 && elemCount > 0) {
                return this.addLeftChild(o, elemCount);
            }
            return this;
        }
        else {
            if (compare <= 0) {
                array[0] = this.elemCount;
                if (n == this.elemCount) {
                    if (elemCount == 0) {
                        return this.deleteMe();
                    }
                    this.totalCount += elemCount - this.elemCount;
                    this.elemCount = elemCount;
                }
                return this;
            }
            final TreeMultiset$AvlNode right = this.right;
            if (right != null) {
                this.right = right.setCount(comparator, o, n, elemCount, array);
                if (array[0] == n) {
                    if (elemCount == 0 && array[0] != 0) {
                        --this.distinctElements;
                    }
                    else if (elemCount > 0 && array[0] == 0) {
                        ++this.distinctElements;
                    }
                    this.totalCount += elemCount - array[0];
                }
                return this.rebalance();
            }
            array[0] = 0;
            if (n == 0 && elemCount > 0) {
                return this.addRightChild(o, elemCount);
            }
            return this;
        }
    }
    
    private TreeMultiset$AvlNode deleteMe() {
        final int elemCount = this.elemCount;
        this.elemCount = 0;
        successor(this.pred, this.succ);
        if (this.left == null) {
            return this.right;
        }
        if (this.right == null) {
            return this.left;
        }
        if (this.left.height >= this.right.height) {
            final TreeMultiset$AvlNode pred = this.pred;
            pred.left = this.left.removeMax(pred);
            pred.right = this.right;
            pred.distinctElements = this.distinctElements - 1;
            pred.totalCount = this.totalCount - elemCount;
            return pred.rebalance();
        }
        final TreeMultiset$AvlNode succ = this.succ;
        succ.right = this.right.removeMin(succ);
        succ.left = this.left;
        succ.distinctElements = this.distinctElements - 1;
        succ.totalCount = this.totalCount - elemCount;
        return succ.rebalance();
    }
    
    private TreeMultiset$AvlNode removeMin(final TreeMultiset$AvlNode treeMultiset$AvlNode) {
        if (this.left == null) {
            return this.right;
        }
        this.left = this.left.removeMin(treeMultiset$AvlNode);
        --this.distinctElements;
        this.totalCount -= treeMultiset$AvlNode.elemCount;
        return this.rebalance();
    }
    
    private TreeMultiset$AvlNode removeMax(final TreeMultiset$AvlNode treeMultiset$AvlNode) {
        if (this.right == null) {
            return this.left;
        }
        this.right = this.right.removeMax(treeMultiset$AvlNode);
        --this.distinctElements;
        this.totalCount -= treeMultiset$AvlNode.elemCount;
        return this.rebalance();
    }
    
    private void recomputeMultiset() {
        this.distinctElements = 1 + TreeMultiset.distinctElements(this.left) + TreeMultiset.distinctElements(this.right);
        this.totalCount = this.elemCount + totalCount(this.left) + totalCount(this.right);
    }
    
    private void recomputeHeight() {
        this.height = 1 + Math.max(height(this.left), height(this.right));
    }
    
    private void recompute() {
        this.recomputeMultiset();
        this.recomputeHeight();
    }
    
    private TreeMultiset$AvlNode rebalance() {
        switch (this.balanceFactor()) {
            case -2: {
                if (this.right.balanceFactor() > 0) {
                    this.right = this.right.rotateRight();
                }
                return this.rotateLeft();
            }
            case 2: {
                if (this.left.balanceFactor() < 0) {
                    this.left = this.left.rotateLeft();
                }
                return this.rotateRight();
            }
            default: {
                this.recomputeHeight();
                return this;
            }
        }
    }
    
    private int balanceFactor() {
        return height(this.left) - height(this.right);
    }
    
    private TreeMultiset$AvlNode rotateLeft() {
        Preconditions.checkState(this.right != null);
        final TreeMultiset$AvlNode right = this.right;
        this.right = right.left;
        right.left = this;
        right.totalCount = this.totalCount;
        right.distinctElements = this.distinctElements;
        this.recompute();
        right.recomputeHeight();
        return right;
    }
    
    private TreeMultiset$AvlNode rotateRight() {
        Preconditions.checkState(this.left != null);
        final TreeMultiset$AvlNode left = this.left;
        this.left = left.right;
        left.right = this;
        left.totalCount = this.totalCount;
        left.distinctElements = this.distinctElements;
        this.recompute();
        left.recomputeHeight();
        return left;
    }
    
    private static long totalCount(@Nullable final TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return (treeMultiset$AvlNode == null) ? 0L : treeMultiset$AvlNode.totalCount;
    }
    
    private static int height(@Nullable final TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return (treeMultiset$AvlNode == null) ? 0 : treeMultiset$AvlNode.height;
    }
    
    @Nullable
    private TreeMultiset$AvlNode ceiling(final Comparator comparator, final Object o) {
        final int compare = comparator.compare(o, this.elem);
        if (compare < 0) {
            return (TreeMultiset$AvlNode)((this.left == null) ? this : MoreObjects.firstNonNull(this.left.ceiling(comparator, o), this));
        }
        if (compare == 0) {
            return this;
        }
        return (this.right == null) ? null : this.right.ceiling(comparator, o);
    }
    
    @Nullable
    private TreeMultiset$AvlNode floor(final Comparator comparator, final Object o) {
        final int compare = comparator.compare(o, this.elem);
        if (compare > 0) {
            return (TreeMultiset$AvlNode)((this.right == null) ? this : MoreObjects.firstNonNull(this.right.floor(comparator, o), this));
        }
        if (compare == 0) {
            return this;
        }
        return (this.left == null) ? null : this.left.floor(comparator, o);
    }
    
    @Override
    public Object getElement() {
        return this.elem;
    }
    
    @Override
    public int getCount() {
        return this.elemCount;
    }
    
    @Override
    public String toString() {
        return Multisets.immutableEntry(this.getElement(), this.getCount()).toString();
    }
}
