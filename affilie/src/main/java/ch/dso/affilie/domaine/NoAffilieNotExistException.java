package ch.dso.affilie.domaine;

public class NoAffilieNotExistException extends RuntimeException {
    public NoAffilieNotExistException(String message) {
        super(message);
    }
}
