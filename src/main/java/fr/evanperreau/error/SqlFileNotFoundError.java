package fr.evanperreau.error;

public class SqlFileNotFoundError extends Error {

    public SqlFileNotFoundError(String message){
        super(message);
    }

    public SqlFileNotFoundError(String message, Throwable cause){
        super(message, cause);
    }

    public SqlFileNotFoundError(Throwable cause){
        super(cause);
    }

    public SqlFileNotFoundError(){
        super();
    }
}
