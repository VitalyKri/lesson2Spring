package ru.gb.old;

public class ConsoleMessageRender implements MessageRender {

    // он зависит messageProvider, т.е. messageProvider является зависимостью для ConsoleMessageRender;
    MessageProvider messageProvider;
    @Override
    public void render() {
        System.out.println(messageProvider.getMessage());
    }



    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
