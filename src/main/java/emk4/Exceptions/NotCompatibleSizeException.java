package emk4.Exceptions;

public class NotCompatibleSizeException extends Exception{
    public NotCompatibleSizeException() {
        super("[ERROR]: Matrix's sizes are not compatible");
    }
}
