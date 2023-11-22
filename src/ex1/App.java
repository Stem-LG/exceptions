package ex1;

class ParametreNullException extends Exception {
    public ParametreNullException(String message) {
        super(message);
    }
}

class NegatifException extends Exception {
    public NegatifException(String message) {
        super(message);
    }
}

public class App {
    public static void main(String[] args) {

        try {
            if (args.length < 2) {
                throw new ArrayIndexOutOfBoundsException(
                        "Vous devriez entrer deux nombres sur la ligne de commande pour que ça fonctionne");
            }
            double n = Double.parseDouble(args[0]);
            double x = Double.parseDouble(args[1]);

            if (n == 0) {
                throw new ParametreNullException("impossible de faire une division par zéro!");
            }

            if (x < 0) {
                throw new NegatifException(
                        x + " est négatif : on ne peut pas calculer une racine pour un réel négatif !!!!!!");
            }

            System.out.println(Mathematique.f(n, x));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Les arguments doivent être des nombres");
        } catch (ParametreNullException e) {
            System.out.println(e.getMessage());
        } catch (NegatifException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("bloc finally exécuté quel que soit le résultat d’exécution");
        }
    }
}
