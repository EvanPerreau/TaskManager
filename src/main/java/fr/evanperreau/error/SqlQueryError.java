package fr.evanperreau.error;

public class SqlQueryError extends Error {

    public SqlQueryError(String message){
        super(message);
    }

    public SqlQueryError(String message, Throwable cause){
        super(message, cause);
    }

    public SqlQueryError(Throwable cause){
        super(cause);
    }

    public SqlQueryError(){
        super();
    }
}
