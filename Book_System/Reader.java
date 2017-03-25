package Assignment.Book_System;

/**
 * Created by dinhtungtp on 3/3/2017.
 */
public class Reader
{
    private String rcode, name;
    private int byear;
    Reader nextNode;

    public Reader(String rcode, String name, int byear){
        this.rcode = rcode;
        this.name = name;
        this.byear = byear;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setByear(int byear) {
        this.byear = byear;
    }

    public void setNextNode(Reader nextNode) {
        this.nextNode = nextNode;
    }

    public String getRcode() {
        return rcode;
    }

    public String getName() {
        return name;
    }

    public int getByear() {
        return byear;
    }

    public Reader getNextNode() {
        return nextNode;
    }

    @Override
    public String toString(){
        return this.getRcode()+ " | " + this.getName() + " | " + this.getByear();
    }
}
