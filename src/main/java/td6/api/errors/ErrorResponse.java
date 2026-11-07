package td6.api.errors;

public class ErrorResponse {
    public String error;
    public String message;

    public ErrorResponse() {}

    public ErrorResponse(String error, String message){
        this.error = error;
        this.message = message;
    }
}
