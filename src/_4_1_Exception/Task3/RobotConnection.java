package _4_1_Exception.Task3;

//интерфейс для управления роботом
// Подключение к роботу представляется в программе интерфейсом RobotConnection:
interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close();
}
