package com.google.protobuf;

import java.util.*;

public class RepeatedFieldBuilder implements GeneratedMessage$BuilderParent
{
    private GeneratedMessage$BuilderParent parent;
    private List messages;
    private boolean isMessagesListMutable;
    private List builders;
    private boolean isClean;
    private RepeatedFieldBuilder$MessageExternalList externalMessageList;
    private RepeatedFieldBuilder$BuilderExternalList externalBuilderList;
    private RepeatedFieldBuilder$MessageOrBuilderExternalList externalMessageOrBuilderList;
    
    public RepeatedFieldBuilder(final List messages, final boolean isMessagesListMutable, final GeneratedMessage$BuilderParent parent, final boolean isClean) {
        this.messages = messages;
        this.isMessagesListMutable = isMessagesListMutable;
        this.parent = parent;
        this.isClean = isClean;
    }
    
    public void dispose() {
        this.parent = null;
    }
    
    private void ensureMutableMessageList() {
        if (!this.isMessagesListMutable) {
            this.messages = new ArrayList(this.messages);
            this.isMessagesListMutable = true;
        }
    }
    
    private void ensureBuilders() {
        if (this.builders == null) {
            this.builders = new ArrayList(this.messages.size());
            for (int i = 0; i < this.messages.size(); ++i) {
                this.builders.add(null);
            }
        }
    }
    
    public int getCount() {
        return this.messages.size();
    }
    
    public boolean isEmpty() {
        return this.messages.isEmpty();
    }
    
    public GeneratedMessage getMessage(final int n) {
        return this.getMessage(n, false);
    }
    
    private GeneratedMessage getMessage(final int n, final boolean b) {
        if (this.builders == null) {
            return this.messages.get(n);
        }
        final SingleFieldBuilder singleFieldBuilder = this.builders.get(n);
        if (singleFieldBuilder == null) {
            return this.messages.get(n);
        }
        return b ? singleFieldBuilder.build() : singleFieldBuilder.getMessage();
    }
    
    public GeneratedMessage$Builder getBuilder(final int n) {
        this.ensureBuilders();
        SingleFieldBuilder singleFieldBuilder = this.builders.get(n);
        if (singleFieldBuilder == null) {
            singleFieldBuilder = new SingleFieldBuilder(this.messages.get(n), this, this.isClean);
            this.builders.set(n, singleFieldBuilder);
        }
        return singleFieldBuilder.getBuilder();
    }
    
    public MessageOrBuilder getMessageOrBuilder(final int n) {
        if (this.builders == null) {
            return this.messages.get(n);
        }
        final SingleFieldBuilder singleFieldBuilder = this.builders.get(n);
        if (singleFieldBuilder == null) {
            return this.messages.get(n);
        }
        return singleFieldBuilder.getMessageOrBuilder();
    }
    
    public RepeatedFieldBuilder setMessage(final int n, final GeneratedMessage generatedMessage) {
        if (generatedMessage == null) {
            throw new NullPointerException();
        }
        this.ensureMutableMessageList();
        this.messages.set(n, generatedMessage);
        if (this.builders != null) {
            final SingleFieldBuilder singleFieldBuilder = this.builders.set(n, null);
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
            }
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }
    
    public RepeatedFieldBuilder addMessage(final GeneratedMessage generatedMessage) {
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
    
    public RepeatedFieldBuilder addMessage(final int n, final GeneratedMessage generatedMessage) {
        if (generatedMessage == null) {
            throw new NullPointerException();
        }
        this.ensureMutableMessageList();
        this.messages.add(n, generatedMessage);
        if (this.builders != null) {
            this.builders.add(n, null);
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }
    
    public RepeatedFieldBuilder addAllMessages(final Iterable iterable) {
        final Iterator<GeneratedMessage> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                throw new NullPointerException();
            }
        }
        int size = -1;
        if (iterable instanceof Collection) {
            final Collection<GeneratedMessage> collection = (Collection<GeneratedMessage>)iterable;
            if (collection.size() == 0) {
                return this;
            }
            size = collection.size();
        }
        this.ensureMutableMessageList();
        if (size >= 0 && this.messages instanceof ArrayList) {
            ((ArrayList)this.messages).ensureCapacity(this.messages.size() + size);
        }
        final Iterator<GeneratedMessage> iterator2 = iterable.iterator();
        while (iterator2.hasNext()) {
            this.addMessage(iterator2.next());
        }
        this.onChanged();
        this.incrementModCounts();
        return this;
    }
    
    public GeneratedMessage$Builder addBuilder(final GeneratedMessage generatedMessage) {
        this.ensureMutableMessageList();
        this.ensureBuilders();
        final SingleFieldBuilder singleFieldBuilder = new SingleFieldBuilder(generatedMessage, this, this.isClean);
        this.messages.add(null);
        this.builders.add(singleFieldBuilder);
        this.onChanged();
        this.incrementModCounts();
        return singleFieldBuilder.getBuilder();
    }
    
    public GeneratedMessage$Builder addBuilder(final int n, final GeneratedMessage generatedMessage) {
        this.ensureMutableMessageList();
        this.ensureBuilders();
        final SingleFieldBuilder singleFieldBuilder = new SingleFieldBuilder(generatedMessage, this, this.isClean);
        this.messages.add(n, null);
        this.builders.add(n, singleFieldBuilder);
        this.onChanged();
        this.incrementModCounts();
        return singleFieldBuilder.getBuilder();
    }
    
    public void remove(final int n) {
        this.ensureMutableMessageList();
        this.messages.remove(n);
        if (this.builders != null) {
            final SingleFieldBuilder singleFieldBuilder = this.builders.remove(n);
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
            }
        }
        this.onChanged();
        this.incrementModCounts();
    }
    
    public void clear() {
        this.messages = Collections.emptyList();
        this.isMessagesListMutable = false;
        if (this.builders != null) {
            for (final SingleFieldBuilder singleFieldBuilder : this.builders) {
                if (singleFieldBuilder != null) {
                    singleFieldBuilder.dispose();
                }
            }
            this.builders = null;
        }
        this.onChanged();
        this.incrementModCounts();
    }
    
    public List build() {
        this.isClean = true;
        if (!this.isMessagesListMutable && this.builders == null) {
            return this.messages;
        }
        boolean b = true;
        if (!this.isMessagesListMutable) {
            for (int i = 0; i < this.messages.size(); ++i) {
                final Message message = this.messages.get(i);
                final SingleFieldBuilder singleFieldBuilder = this.builders.get(i);
                if (singleFieldBuilder != null && singleFieldBuilder.build() != message) {
                    b = false;
                    break;
                }
            }
            if (b) {
                return this.messages;
            }
        }
        this.ensureMutableMessageList();
        for (int j = 0; j < this.messages.size(); ++j) {
            this.messages.set(j, this.getMessage(j, true));
        }
        this.messages = Collections.unmodifiableList((List<?>)this.messages);
        this.isMessagesListMutable = false;
        return this.messages;
    }
    
    public List getMessageList() {
        if (this.externalMessageList == null) {
            this.externalMessageList = new RepeatedFieldBuilder$MessageExternalList(this);
        }
        return this.externalMessageList;
    }
    
    public List getBuilderList() {
        if (this.externalBuilderList == null) {
            this.externalBuilderList = new RepeatedFieldBuilder$BuilderExternalList(this);
        }
        return this.externalBuilderList;
    }
    
    public List getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList == null) {
            this.externalMessageOrBuilderList = new RepeatedFieldBuilder$MessageOrBuilderExternalList(this);
        }
        return this.externalMessageOrBuilderList;
    }
    
    private void onChanged() {
        if (this.isClean && this.parent != null) {
            this.parent.markDirty();
            this.isClean = false;
        }
    }
    
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
        if (this.externalMessageOrBuilderList != null) {
            this.externalMessageOrBuilderList.incrementModCount();
        }
    }
}
