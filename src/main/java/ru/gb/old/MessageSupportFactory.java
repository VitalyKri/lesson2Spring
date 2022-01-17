package ru.gb.old;

import java.io.IOException;
import java.util.Properties;

// синглтон
// проперти создается для работы с рефлексии
public class MessageSupportFactory {

    private static MessageSupportFactory instance;

    private Properties properties;
    private MessageRender messageRender;
    private MessageProvider messageProvider;


    static {
        instance = new MessageSupportFactory();
    }

    private MessageSupportFactory() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/message-context.properties"));
            String renderClass = properties.getProperty("render.class");
            String providerClass = properties.getProperty("provider.class");

            messageRender = (MessageRender) Class.forName(renderClass).newInstance();
            messageProvider = (MessageProvider) Class.forName(providerClass).newInstance();
            messageRender.setMessageProvider(messageProvider);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRender getMessageRender() {
        return messageRender;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
