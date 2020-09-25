package _3_3_Class_declaration;

/*
В начальный момент робот находится в некоторой позиции на поле.
Также известно, куда робот смотрит: вверх, вниз, направо или налево.
Ваша задача — привести робота в заданную точку игрового поля.
 */
public class TaskRobot {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.DOWN);
        int toX = -10;
        int toY = 20;
        moveRobot(robot, toX, toY);
        if (toX == robot.getX() && toY == robot.getY()) {
            System.out.println("The robot is on the base!");
        } else {
            System.out.println("We have a problem!");
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int difX = toX - robot.getX();
        if (difX > 0) {
            if (robot.getDirection() == Direction.UP) {
                robot.turnRight();
            }
            if (robot.getDirection() == Direction.LEFT) {
                robot.turnRight();
                robot.turnRight();
            }
            if (robot.getDirection() == Direction.DOWN) {
                robot.turnLeft();
            }
            for (int i = 0; i < difX; i++) {
                robot.stepForward();
            }
        }
        if (difX < 0) {
            if (robot.getDirection() == Direction.UP) {
                robot.turnLeft();
            }
            if (robot.getDirection() == Direction.RIGHT) {
                robot.turnLeft();
                robot.turnLeft();
            }
            if (robot.getDirection() == Direction.DOWN) {
                robot.turnRight();
            }
            difX *= -1;
            for (int i = 0; i < difX; i++) {
                robot.stepForward();
            }
        }

        int difY = toY - robot.getY();
        if (difY > 0) {
            if (robot.getDirection() == Direction.RIGHT) {
                robot.turnLeft();
            }
            if (robot.getDirection() == Direction.LEFT) {
                robot.turnRight();
            }
            if (robot.getDirection() == Direction.DOWN) {
                robot.turnLeft();
                robot.turnLeft();
            }
            for (int i = 0; i < difY; i++) {
                robot.stepForward();
            }
        }
        if (difY < 0) {
            if (robot.getDirection() == Direction.UP) {
                robot.turnLeft();
                robot.turnLeft();
            }
            if (robot.getDirection() == Direction.RIGHT) {
                robot.turnRight();
            }
            if (robot.getDirection() == Direction.LEFT) {
                robot.turnLeft();
            }
            difY *= -1;
            for (int i = 0; i < difY; i++) {
                robot.stepForward();
            }
        }
    }
}