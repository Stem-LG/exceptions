package ex2;

import java.io.IOException;

public class TestAuthentification {

    public static void main(String[] args) {

        while (true) {
            try {
                Authentification a = new Authentification();
                break;
            } catch (WrongLoginException e) {
                System.out.println(e.getMessage());
            } catch (WrongPwdException e) {
                System.out.println(e.getMessage());
            } catch (WrongInputLengthException | IOException e) {
                System.out.println("attack detectée");
                System.exit(0);
            }
        }

    }
}
