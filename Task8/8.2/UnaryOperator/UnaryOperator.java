package UnaryOperator;

import java.util.Random;

public class UnaryOperator {
    private double num;

    public UnaryOperator(double num) {
        this.num = num;
    }

    public UnaryOperator() {
        Random random=new Random();
        num=random.nextDouble();
    }

    public double increment(){
        return num++;
    }

    public double decrement(){
        return num--;
    }

    public double changeSign(){
        return -num;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "UnaryOperator{" +
                "num=" + num +
                '}';
    }
}
