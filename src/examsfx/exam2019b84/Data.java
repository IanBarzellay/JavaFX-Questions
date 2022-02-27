package examsfx.exam2019b84;

import java.io.Serializable;

public class Data implements Serializable{
    private int num;
    private String binResult;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBinResult() {
        return binResult;
    }

    public void setBinResult(String binResult) {
        this.binResult = binResult;
    }
}
