package _4_1_Exception.Task3;

//класc исключения отличный от RobotConnectionException при подключении к роботу
public class MyException extends RuntimeException implements Dublicated {
    public MyException() {
        super();
    }

    @Override
    public Dublicated dublic() {
        return new MyException();
    }
}
