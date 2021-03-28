import java.util.ArrayList;
import java.util.List;

public class ChannelOnYouTube implements Subject {
    List<Subscriber> subscribers = new ArrayList<Subscriber>();
    String title;

    @Override
    public void register(Subscriber subscriber){
         subscribers.add(subscriber);
    }
    @Override
    public void unRegister(Subscriber subscriber){
        subscribers.remove(subscriber);
    }
    @Override
    public void notifyChannel(){
        for (Subscriber sub : subscribers){
            sub.update(this.title);
        }
    }
    @Override
    public void uploadVedio(String title){
        this.title = title;
        notifyChannel();
    }
}
