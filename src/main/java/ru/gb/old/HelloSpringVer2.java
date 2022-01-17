package ru.gb.old;

public class HelloSpringVer2 {
    public static void main(String[] args) {
        MessageRender messageRender = MessageSupportFactory.getInstance().getMessageRender();
        messageRender.render();


        // сингтон используется, что бы во всем коде была ссылка на 1 объект и его подвязка
        // сейчас вся реализация сделана на свойствах (настройках)
        // избавляемся от зависимостей в коде по максимуму, переносим их в настройки, и настроечном классе
        // зависимости создаются независимо от нас. Dependency Injection (внедрение зависимостей)
        // inversion of control (перекладываем контроль за управление по созданию объектов на кого-то другого (MessageSupportFactory) из контректа
        // bean (объект класса которые создаются называются бинами)
        // IoC паннерт создание бизнес-объекта.

    }
}
