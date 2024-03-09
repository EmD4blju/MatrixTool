package emk4;

public class NotCompatibleSizeException extends Exception{
    public NotCompatibleSizeException() {
        super("[ERROR]: Matrix's sizes are not compatible");
    }
}
