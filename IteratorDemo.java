import java.util.ArrayList;
import java.util.List;
/* Iterator flow,
   basic interface,
   static - non static why when how
   JavaIterator implementation -> arraylist   (listIterator , Iterator)
   why inner class() => unnecessary passing names not required only used within that repository
 */
public class IteratorDemo{
    public static void main(String[] args) {
        String[] name={"Debo", "Debo1", "Debo2", "Debo3"};
        //Example :  List<String> list = new ArrayList<>();
        NameRepository repo = new NameRepository(name);

        Iterator iter = repo.getIterator();
        if(iter.hasNext()) {
            System.out.println(iter.next());
        }
        Iterator iter1 = repo.getIterator();

        while (iter1.hasNext()){
            System.out.println(iter1.next());
        }

        //or, Iterator iter = repo.new NameIterator();

        //new NameRepository.NameIterator(name);
        // new NameRepository().new NameIterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }
    }
}
class NameRepository implements Container {

    String names[];
    NameRepository(String names[]){
        this.names = names;
    }
      @Override
      public Iterator getIterator() {
          return new NameIterator();
      }

    class NameIterator implements Iterator {
        int index =0;
        @Override
        public boolean hasNext() {
            return  (index<names.length)? true : false;
        }

        @Override
        public String next() {
            return this.hasNext() ?  names[index++] : null;
        }
    }
}
interface Container{
    Iterator getIterator();
}

interface Iterator {
    boolean hasNext();
    String next();
}
