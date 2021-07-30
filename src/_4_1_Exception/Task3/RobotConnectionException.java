package _4_1_Exception.Task3;

//класc исключения RobotConnectionException при подключении к роботу
class RobotConnectionException extends RuntimeException implements Dublicated {
    public RobotConnectionException(String message) {
        super(message);
    }

    @Override
    public Dublicated dublic(){
        return new RobotConnectionException("error");
    }
}