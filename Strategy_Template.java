import java.util.Date;

public class Strategy_Template {
    public static void main(String[] args) {
        int[] a = {3,5,1,4,2};
        SortingContext ct = new SortingContext();
        ct.setType(new Bubble(), a.clone());
        ct.execute();
        ct.setType(new Selection(), a.clone());
        ct.execute();
    }
}
