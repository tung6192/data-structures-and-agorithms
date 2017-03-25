package Assignment.Book_System;

/**
 * Created by dinhtungtp on 3/3/2017.
 */
public class Lending
{
    private String bcode, rcode;
    private int state;
    Lending nextNode;

    public Lending(String bcode, String rcode, int state){
        this.bcode = bcode;
        this.rcode = rcode;
        this.state = state;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setNextNode(Lending nextNode) {
        this.nextNode = nextNode;
    }

    public String getBcode() {
        return bcode;
    }

    public String getRcode() {
        return rcode;
    }

    public int getState() {
        return state;
    }

    public Lending getNextNode() {
        return nextNode;
    }

    @Override
    public String toString(){
        return this.getBcode()+ " | " + this.getRcode() + " | " + this.getState();
    }
}
