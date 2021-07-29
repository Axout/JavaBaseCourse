package _4_1_Exception.Task3;

//класc исключения RobotConnectionException при подключении к роботу
public class RobotConnectionException extends RuntimeException implements Dublicated {
    public RobotConnectionException() {
        super();
    }

    @Override
    public Dublicated dublic(){
        return new RobotConnectionException();
    }
}