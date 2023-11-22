package ex2;

import java.io.IOException;
import java.util.Scanner;

class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Login incorrect!");
    }
}

class WrongPwdException extends Exception {
    public WrongPwdException() {
        super("Mot de passe incorrect");
    }
}

class WrongInputLengthException extends Exception {
    public WrongInputLengthException(String message) {
        super(message);
    }
}

public class Authentification {
    private Scanner sc = new Scanner(System.in);

    private final String LoginCorrect = "scott", PwdCorrect = "tiger";
    private String login, pwd;

    Authentification() throws WrongLoginException, WrongPwdException, WrongInputLengthException, IOException {

        login = getUserLogin();
        pwd = getUserPwd();

        System.out.println("Authentification réussie pour l'utilisateur : " + login);

    }

    public String getUserLogin() throws WrongInputLengthException, WrongLoginException, IOException {
        System.out.print("login: ");
        String login = sc.nextLine();

        if (login.length() > 10) {
            throw new WrongInputLengthException("Longueur du login incorrecte !");
        }

        if (!login.equals(LoginCorrect)) {
            throw new WrongLoginException();
        }

        return login;
    }

    public String getUserPwd() throws WrongInputLengthException, WrongPwdException, IOException {
        System.out.print("mot de passe: ");
        String pwd = sc.nextLine();

        if (pwd.length() > 10) {
            throw new WrongInputLengthException("Longueur du mot de passe incorrecte !");
        }

        if (!pwd.equals(PwdCorrect)) {
            throw new WrongPwdException();
        }

        return pwd;
    }

}
