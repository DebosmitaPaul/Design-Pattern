public class VisitorDemo_Behavioral {
    public static void main(String[] args) {
        ItemElement[] items  = new ItemElement[]{
                new Book(12,500),new Book(5,100),
                new Fruit(10,500),new Fruit(7,200),
        };
        int totalPrice = CalculatePrice(items);
        System.out.println("Total Price : "+totalPrice);
    }

    private static int CalculatePrice(ItemElement[] items) {
        int sum =0;
        ShoppingCartVisitor cartVisitor = new ShoppingCartVisitorImpl();
        for (ItemElement item: items) {
            sum  = sum  + item.accept(cartVisitor);
        }
        return sum;
    }
}
interface ShoppingCartVisitor{
    int visit(Book book);
    int visit(Fruit fruit);
}
class ShoppingCartVisitorImpl implements ShoppingCartVisitor{

    @Override
    public int visit(Book book) {
        if(book.getCount()>10){
          return  book.getPrice() -30;
        }
        return book.getPrice();
    }

    @Override
    public int visit(Fruit fruit) {
        if(fruit.getPrice()>300){
            return  fruit.getPrice() -50;
        }
        return fruit.getPrice();
    }
}

interface ItemElement{
    int accept(ShoppingCartVisitor visitor);
}
class Book implements ItemElement{
    private int count;
    private int price;
    Book(int count, int price){
        this.count = count;
        this.price = price;
    }
    int getCount(){
        return  this.count;
    }
    int getPrice(){
        return this.price;
    }
    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
class Fruit implements ItemElement{
    private int weight;
    private int price;
    Fruit(int weight, int price){
      this.weight = weight;
      this.price = price;
    }
    int getWeight(){
        return  this.weight;
    }
    int getPrice(){
        return this.price;
    }
    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}