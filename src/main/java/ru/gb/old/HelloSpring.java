package ru.gb.old;

public class HelloSpring {
    public static void main(String[] args) {
        // представляем, что это бизнес-логика, не будет меняться. будем менять реализацию кода.
        // мы ушли от харкода, можем менять имплементации.
        MessageProvider messageProvider = new HelloSpringMessageProvider();
        MessageRender messageRender = new ConsoleMessageRender();
        messageRender.setMessageProvider(messageProvider);
        messageRender.render();

        // мы ушли от харкода, можем менять имплементации.
        messageProvider = new LikeMessageProvider();
        messageRender = new ConsoleMessageRender();
        messageRender.setMessageProvider(messageProvider);
        messageRender.render();
    }
}
