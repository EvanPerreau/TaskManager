package fr.evanperreau.error;

public class DatabaseNotFoundError extends Error {

    public DatabaseNotFoundError(String message){
        super(message);
    }

    public DatabaseNotFoundError(String message, Throwable cause){
        super(message, cause);
    }

    public DatabaseNotFoundError(Throwable cause){
        super(cause);
    }

    public DatabaseNotFoundError(){
        super();
    }
}
