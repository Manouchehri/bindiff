/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.RepeatedFieldBuilder$BuilderExternalList;
import com.google.protobuf.RepeatedFieldBuilder$MessageExternalList;
import com.google.protobuf.RepeatedFieldBuilder$MessageOrBuilderExternalList;
import com.google.protobuf.SingleFieldBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RepeatedFieldBuilder
implements GeneratedMessage$BuilderParent {
    private GeneratedMessage$BuilderParent parent;
    private List messages;
    private boolean isMessagesListMutable;
    private List builders;
    private boolean isClean;
    private RepeatedFieldBuilder$MessageExternalList externalMessageList;
    private RepeatedFieldBuilder$BuilderExternalList externalBuilderList;
    private RepeatedFieldBuilder$MessageOrBuilderExternalList externalMessageOrBuilderList;

    public RepeatedFieldBuilder(List list, boolean bl2, GeneratedMessage$BuilderParent generatedMessage$BuilderParent, boolean bl3) {
        this.messages = list;
        this.isMessagesListMutable = bl2;
        this.parent = generatedMessage$BuilderParent;
        this.isClean = bl3;
    }

    public void dispose() {
        this.parent = null;
    }

    private void ensureMutableMessageList() {
        if (this.isMessagesListMutable) return;
        this.messages = new ArrayList(this.messages);
        this.isMessagesListMutable = true;
    }

    private void ensureBuilders() {
        if (this.builders != null) return;
        this.builders = new ArrayList(this.messages.size());
        int n2 = 0;
        while (n2 < this.messages.size()) {
            this.builders.add(null);
            ++n2;
        }
    }

    public int getCount() {
        return this.messages.size();
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    public GeneratedMessage getMessage(int n2) {
        return this.getMessage(n2, false);
    }

    private GeneratedMessage getMessage(int n2, boolean bl2) {
        GeneratedMessage generatedMessage;
        if (this.builders == null) {
            return (GeneratedMessage)this.messages.get(n2);
        }
        SingleFieldBuilder singleFieldBuilder = (SingleFieldBuilder)this.builders.get(n2);
        if (singleFieldBuilder == null) {
            return (GeneratedMessage)this.messages.get(n2);
        }
        if (bl2) {
            generatedMessage = singleFieldBuilder.build();
            return generatedMessage;
        }
        generatedMessage = singleFieldBuilder.getMessage();
        return generatedMessage;
    }

    public GeneratedMessage$Builder getBuilder(int n2) {
        this.ensureBuilders();
        SingleFieldBuilder singleFieldBuilder = (SingleFieldBuilder)this.builders.get(n2);
        if (singleFieldBuilder != null) return singleFieldBuilder.getBuilder();
        GeneratedMessage generatedMessage = (GeneratedMessage)this.messages.get(n2);
        singleFieldBuilder = new SingleFieldBuilder(generatedMessage, this, this.isClean);
        this.builders.set(n2, singleFieldBuilder);
        return singleFieldBuilder.getBuilder();
    }

    public MessageOrBuilder getMessageOrBuilder(int n2) {
        if (this.builders == null) {
            return (MessageOrBuilder)this.messages.get(n2);
        }
        SingleFieldBuilder singleFieldBuilder = (SingleFieldBuilder)this.builders.get(n2);
        if (singleFieldBuilder != null) return singleFieldBuilder.getMessageOrBuilder();
        return (MessageOrBuilder)this.messages.get(n2);
    }

    public RepeatedFieldBuilder setMessage(int n2, GeneratedMessage generatedMessage) {
        SingleFieldBuilder singleFieldBuilder;
        if (generatedMessage == null) {
            throw new NullPointerException();
        }
        this.ensureMutableMessageList();
        this.messages.set(n2, generatedMessage);
        if (this.builders != null && (singleFieldBuilder = (SingleFieldBuilder)this.builders.set(n2, null)) != null) {
            singleFieldBuilder.dispose();
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder addMessage(GeneratedMessage generatedMessage) {
        if (generatedMessage == null) {
            throw new NullPointerException();
        }
        this.ensureMutableMessageList();
        this.messages.add(generatedMessage);
        if (this.builders != null) {
            this.builders.add(null);
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder addMessage(int n2, GeneratedMessage generatedMessage) {
        if (generatedMessage == null) {
            throw new NullPointerException();
        }
        this.ensureMutableMessageList();
        this.messages.add(n2, generatedMessage);
        if (this.builders != null) {
            this.builders.add(n2, null);
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder addAllMessages(Iterable iterable) {
        Object object2;
        for (Object object2 : iterable) {
            if (object2 != null) continue;
            throw new NullPointerException();
        }
        int n2 = -1;
        if (iterable instanceof Collection) {
            object2 = (Collection)iterable;
            if (object2.size() == 0) {
                return this;
            }
            n2 = object2.size();
        }
        this.ensureMutableMessageList();
        if (n2 >= 0 && this.messages instanceof ArrayList) {
            ((ArrayList)this.messages).ensureCapacity(this.messages.size() + n2);
        }
        object2 = iterable.iterator();
        do {
            if (!object2.hasNext()) {
                this.onChanged();
                this.incrementModCounts();
                return this;
            }
            GeneratedMessage generatedMessage = (GeneratedMessage)object2.next();
            this.addMessage(generatedMessage);
        } while (true);
    }

    public GeneratedMessage$Builder addBuilder(GeneratedMessage generatedMessage) {
        this.ensureMutableMessageList();
        this.ensureBuilders();
        SingleFieldBuilder singleFieldBuilder = new SingleFieldBuilder(generatedMessage, this, this.isClean);
        this.messages.add(null);
        this.builders.add(singleFieldBuilder);
        this.onChanged();
        this.incrementModCounts();
        return singleFieldBuilder.getBuilder();
    }

    public GeneratedMessage$Builder addBuilder(int n2, GeneratedMessage generatedMessage) {
        this.ensureMutableMessageList();
        this.ensureBuilders();
        SingleFieldBuilder singleFieldBuilder = new SingleFieldBuilder(generatedMessage, this, this.isClean);
        this.messages.add(n2, null);
        this.builders.add(n2, singleFieldBuilder);
        this.onChanged();
        this.incrementModCounts();
        return singleFieldBuilder.getBuilder();
    }

    public void remove(int n2) {
        SingleFieldBuilder singleFieldBuilder;
        this.ensureMutableMessageList();
        this.messages.remove(n2);
        if (this.builders != null && (singleFieldBuilder = (SingleFieldBuilder)this.builders.remove(n2)) != null) {
            singleFieldBuilder.dispose();
        }
        this.onChanged();
        this.incrementModCounts();
    }

    public void clear() {
        this.messages = Collections.emptyList();
        this.isMessagesListMutable = false;
        if (this.builders != null) {
            for (SingleFieldBuilder singleFieldBuilder : this.builders) {
                if (singleFieldBuilder == null) continue;
                singleFieldBuilder.dispose();
            }
            this.builders = null;
        }
        this.onChanged();
        this.incrementModCounts();
    }

    public List build() {
        int n2;
        this.isClean = true;
        if (!this.isMessagesListMutable && this.builders == null) {
            return this.messages;
        }
        boolean bl2 = true;
        if (!this.isMessagesListMutable) {
            for (n2 = 0; n2 < this.messages.size(); ++n2) {
                Message message = (Message)this.messages.get(n2);
                SingleFieldBuilder singleFieldBuilder = (SingleFieldBuilder)this.builders.get(n2);
                if (singleFieldBuilder == null || singleFieldBuilder.build() == message) continue;
                bl2 = false;
                break;
            }
            if (bl2) {
                return this.messages;
            }
        }
        this.ensureMutableMessageList();
        n2 = 0;
        do {
            if (n2 >= this.messages.size()) {
                this.messages = Collections.unmodifiableList(this.messages);
                this.isMessagesListMutable = false;
                return this.messages;
            }
            this.messages.set(n2, this.getMessage(n2, true));
            ++n2;
        } while (true);
    }

    public List getMessageList() {
        if (this.externalMessageList != null) return this.externalMessageList;
        this.externalMessageList = new RepeatedFieldBuilder$MessageExternalList(this);
        return this.externalMessageList;
    }

    public List getBuilderList() {
        if (this.externalBuilderList != null) return this.externalBuilderList;
        this.externalBuilderList = new RepeatedFieldBuilder$BuilderExternalList(this);
        return this.externalBuilderList;
    }

    public List getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList != null) return this.externalMessageOrBuilderList;
        this.externalMessageOrBuilderList = new RepeatedFieldBuilder$MessageOrBuilderExternalList(this);
        return this.externalMessageOrBuilderList;
    }

    private void onChanged() {
        if (!this.isClean) return;
        if (this.parent == null) return;
        this.parent.markDirty();
        this.isClean = false;
    }

    @Override
    public void markDirty() {
        this.onChanged();
    }

    private void incrementModCounts() {
        if (this.externalMessageList != null) {
            this.externalMessageList.incrementModCount();
        }
        if (this.externalBuilderList != null) {
            this.externalBuilderList.incrementModCount();
        }
        if (this.externalMessageOrBuilderList == null) return;
        this.externalMessageOrBuilderList.incrementModCount();
    }
}

