import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test {
    @org.junit.Test
    public void test() {
        Mytest t = new Mytest(1,2,"hhh");
        System.out.println(t);
        t.setAnInt(12);
        t.setBnInt(15);
        System.out.println(t);
        Map m = new HashMap();
        BigDecimal
    }

}

final class Mytest{
    int anInt;
    int bnInt;
    String c;

    public Mytest(int anInt, int bnInt, String c) {
        this.anInt = anInt;
        this.bnInt = bnInt;
        this.c = c;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public int getBnInt() {
        return bnInt;
    }

    public void setBnInt(int bnInt) {
        this.bnInt = bnInt;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mytest mytest = (Mytest) o;
        return anInt == mytest.anInt &&
                bnInt == mytest.bnInt &&
                Objects.equals(c, mytest.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt, bnInt, c);
    }

    @Override
    public String toString() {
        return "Mytest{" +
                "anInt=" + anInt +
                ", bnInt=" + bnInt +
                ", c='" + c + '\'' +
                '}';
    }
}

