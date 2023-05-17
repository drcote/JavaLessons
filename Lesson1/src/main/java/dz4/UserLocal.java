package dz4;

public class UserLocal {
    private String login;
    private String password;

    public UserLocal(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private class Query {
        public void printToLog() {
            System.out.println("Пользователь с логином " + login + " и паролем " + password + " отправил запрос");
        }
    }

    public void createQuery() {
        UserLocal.Query query = new Query();
        query.printToLog();
    }
}
