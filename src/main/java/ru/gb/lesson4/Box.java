package ru.gb.lesson4;

public class Box {
    private Integer ballsCount;

    public Box() {
       ballsCount = 0;
    }

    public Integer getBallsCount() {
        return ballsCount;
    }

    public void addBall(){
        ballsCount ++;
    }

    public void deleteBall() throws BoxIsEmptyException {
        if (ballsCount == 0) {
            System.out.println("Коробка уже пустая");
            throw new BoxIsEmptyException ();
        }
        ballsCount --;
    }

}
