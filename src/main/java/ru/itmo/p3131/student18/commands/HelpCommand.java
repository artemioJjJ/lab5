package ru.itmo.p3131.student18.commands;


public class HelpCommand implements Command {

    public void execute(String[] params) {
        System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_first : удалить первый элемент из коллекции\n" +
                "remove_last : удалить последний элемент из коллекции\n" +
                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "count_by_impact_speed impactSpeed : вывести количество элементов, значение поля impactSpeed которых равно заданному\n" +
                "filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки\n" +
                "filter_less_than_impact_speed impactSpeed : вывести элементы, значение поля impactSpeed которых меньше заданного");
    }

    public boolean isWithArgs() {
        return false;
    }

    public String getName() {
        return "help";
    }
}
