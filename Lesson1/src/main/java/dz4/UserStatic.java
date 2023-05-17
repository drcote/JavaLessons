package dz4;

public class UserStatic {
    private static String login;
    private static String password;

    static {
        login = "Ivan Static";
        password = "Qwerty";
    }
    public static class Query {
        public static void printToLog() {
            System.out.println("Пользователь с логином " + login + " и паролем " + password + " отправил запрос");
        }
    }

    public void createQuery() {
        Query.printToLog();
    }
}
