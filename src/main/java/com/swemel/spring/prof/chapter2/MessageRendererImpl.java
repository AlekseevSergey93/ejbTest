package com.swemel.spring.prof.chapter2;

public class MessageRendererImpl implements MessageRenderer{

    private MessageProvider messageProvider;

    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("You must set the "
                    + "property messageProvider of class:"
                    + MessageRendererImpl.class.getName());
        }
        System.out.println(messageProvider.getMessage () );
    }

    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
