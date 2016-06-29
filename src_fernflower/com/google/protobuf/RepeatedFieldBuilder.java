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

public class RepeatedFieldBuilder implements GeneratedMessage$BuilderParent {
   private GeneratedMessage$BuilderParent parent;
   private List messages;
   private boolean isMessagesListMutable;
   private List builders;
   private boolean isClean;
   private RepeatedFieldBuilder$MessageExternalList externalMessageList;
   private RepeatedFieldBuilder$BuilderExternalList externalBuilderList;
   private RepeatedFieldBuilder$MessageOrBuilderExternalList externalMessageOrBuilderList;

   public RepeatedFieldBuilder(List var1, boolean var2, GeneratedMessage$BuilderParent var3, boolean var4) {
      this.messages = var1;
      this.isMessagesListMutable = var2;
      this.parent = var3;
      this.isClean = var4;
   }

   public void dispose() {
      this.parent = null;
   }

   private void ensureMutableMessageList() {
      if(!this.isMessagesListMutable) {
         this.messages = new ArrayList(this.messages);
         this.isMessagesListMutable = true;
      }

   }

   private void ensureBuilders() {
      if(this.builders == null) {
         this.builders = new ArrayList(this.messages.size());

         for(int var1 = 0; var1 < this.messages.size(); ++var1) {
            this.builders.add((Object)null);
         }
      }

   }

   public int getCount() {
      return this.messages.size();
   }

   public boolean isEmpty() {
      return this.messages.isEmpty();
   }

   public GeneratedMessage getMessage(int var1) {
      return this.getMessage(var1, false);
   }

   private GeneratedMessage getMessage(int var1, boolean var2) {
      if(this.builders == null) {
         return (GeneratedMessage)this.messages.get(var1);
      } else {
         SingleFieldBuilder var3 = (SingleFieldBuilder)this.builders.get(var1);
         return var3 == null?(GeneratedMessage)this.messages.get(var1):(var2?var3.build():var3.getMessage());
      }
   }

   public GeneratedMessage$Builder getBuilder(int var1) {
      this.ensureBuilders();
      SingleFieldBuilder var2 = (SingleFieldBuilder)this.builders.get(var1);
      if(var2 == null) {
         GeneratedMessage var3 = (GeneratedMessage)this.messages.get(var1);
         var2 = new SingleFieldBuilder(var3, this, this.isClean);
         this.builders.set(var1, var2);
      }

      return var2.getBuilder();
   }

   public MessageOrBuilder getMessageOrBuilder(int var1) {
      if(this.builders == null) {
         return (MessageOrBuilder)this.messages.get(var1);
      } else {
         SingleFieldBuilder var2 = (SingleFieldBuilder)this.builders.get(var1);
         return var2 == null?(MessageOrBuilder)this.messages.get(var1):var2.getMessageOrBuilder();
      }
   }

   public RepeatedFieldBuilder setMessage(int var1, GeneratedMessage var2) {
      if(var2 == null) {
         throw new NullPointerException();
      } else {
         this.ensureMutableMessageList();
         this.messages.set(var1, var2);
         if(this.builders != null) {
            SingleFieldBuilder var3 = (SingleFieldBuilder)this.builders.set(var1, (Object)null);
            if(var3 != null) {
               var3.dispose();
            }
         }

         this.onChanged();
         this.incrementModCounts();
         return this;
      }
   }

   public RepeatedFieldBuilder addMessage(GeneratedMessage var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.ensureMutableMessageList();
         this.messages.add(var1);
         if(this.builders != null) {
            this.builders.add((Object)null);
         }

         this.onChanged();
         this.incrementModCounts();
         return this;
      }
   }

   public RepeatedFieldBuilder addMessage(int var1, GeneratedMessage var2) {
      if(var2 == null) {
         throw new NullPointerException();
      } else {
         this.ensureMutableMessageList();
         this.messages.add(var1, var2);
         if(this.builders != null) {
            this.builders.add(var1, (Object)null);
         }

         this.onChanged();
         this.incrementModCounts();
         return this;
      }
   }

   public RepeatedFieldBuilder addAllMessages(Iterable var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         GeneratedMessage var3 = (GeneratedMessage)var2.next();
         if(var3 == null) {
            throw new NullPointerException();
         }
      }

      int var5 = -1;
      if(var1 instanceof Collection) {
         Collection var6 = (Collection)var1;
         if(var6.size() == 0) {
            return this;
         }

         var5 = var6.size();
      }

      this.ensureMutableMessageList();
      if(var5 >= 0 && this.messages instanceof ArrayList) {
         ((ArrayList)this.messages).ensureCapacity(this.messages.size() + var5);
      }

      Iterator var7 = var1.iterator();

      while(var7.hasNext()) {
         GeneratedMessage var4 = (GeneratedMessage)var7.next();
         this.addMessage(var4);
      }

      this.onChanged();
      this.incrementModCounts();
      return this;
   }

   public GeneratedMessage$Builder addBuilder(GeneratedMessage var1) {
      this.ensureMutableMessageList();
      this.ensureBuilders();
      SingleFieldBuilder var2 = new SingleFieldBuilder(var1, this, this.isClean);
      this.messages.add((Object)null);
      this.builders.add(var2);
      this.onChanged();
      this.incrementModCounts();
      return var2.getBuilder();
   }

   public GeneratedMessage$Builder addBuilder(int var1, GeneratedMessage var2) {
      this.ensureMutableMessageList();
      this.ensureBuilders();
      SingleFieldBuilder var3 = new SingleFieldBuilder(var2, this, this.isClean);
      this.messages.add(var1, (Object)null);
      this.builders.add(var1, var3);
      this.onChanged();
      this.incrementModCounts();
      return var3.getBuilder();
   }

   public void remove(int var1) {
      this.ensureMutableMessageList();
      this.messages.remove(var1);
      if(this.builders != null) {
         SingleFieldBuilder var2 = (SingleFieldBuilder)this.builders.remove(var1);
         if(var2 != null) {
            var2.dispose();
         }
      }

      this.onChanged();
      this.incrementModCounts();
   }

   public void clear() {
      this.messages = Collections.emptyList();
      this.isMessagesListMutable = false;
      if(this.builders != null) {
         Iterator var1 = this.builders.iterator();

         while(var1.hasNext()) {
            SingleFieldBuilder var2 = (SingleFieldBuilder)var1.next();
            if(var2 != null) {
               var2.dispose();
            }
         }

         this.builders = null;
      }

      this.onChanged();
      this.incrementModCounts();
   }

   public List build() {
      this.isClean = true;
      if(!this.isMessagesListMutable && this.builders == null) {
         return this.messages;
      } else {
         boolean var1 = true;
         int var2;
         if(!this.isMessagesListMutable) {
            for(var2 = 0; var2 < this.messages.size(); ++var2) {
               Message var3 = (Message)this.messages.get(var2);
               SingleFieldBuilder var4 = (SingleFieldBuilder)this.builders.get(var2);
               if(var4 != null && var4.build() != var3) {
                  var1 = false;
                  break;
               }
            }

            if(var1) {
               return this.messages;
            }
         }

         this.ensureMutableMessageList();

         for(var2 = 0; var2 < this.messages.size(); ++var2) {
            this.messages.set(var2, this.getMessage(var2, true));
         }

         this.messages = Collections.unmodifiableList(this.messages);
         this.isMessagesListMutable = false;
         return this.messages;
      }
   }

   public List getMessageList() {
      if(this.externalMessageList == null) {
         this.externalMessageList = new RepeatedFieldBuilder$MessageExternalList(this);
      }

      return this.externalMessageList;
   }

   public List getBuilderList() {
      if(this.externalBuilderList == null) {
         this.externalBuilderList = new RepeatedFieldBuilder$BuilderExternalList(this);
      }

      return this.externalBuilderList;
   }

   public List getMessageOrBuilderList() {
      if(this.externalMessageOrBuilderList == null) {
         this.externalMessageOrBuilderList = new RepeatedFieldBuilder$MessageOrBuilderExternalList(this);
      }

      return this.externalMessageOrBuilderList;
   }

   private void onChanged() {
      if(this.isClean && this.parent != null) {
         this.parent.markDirty();
         this.isClean = false;
      }

   }

   public void markDirty() {
      this.onChanged();
   }

   private void incrementModCounts() {
      if(this.externalMessageList != null) {
         this.externalMessageList.incrementModCount();
      }

      if(this.externalBuilderList != null) {
         this.externalBuilderList.incrementModCount();
      }

      if(this.externalMessageOrBuilderList != null) {
         this.externalMessageOrBuilderList.incrementModCount();
      }

   }
}
