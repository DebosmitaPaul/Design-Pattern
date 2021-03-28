
public class Subscriber  implements Observer{
    private String name ;
    private ChannelOnYouTube channel;
    public Subscriber(String name){
        this.name = name;
    }
     @Override
    public void update(String title)
    {
        System.out.println("Hey "+name+" "+title+" Uploaded..");
    }
    
    @Override
    public void subscribeChannel(ChannelOnYouTube channel)
    {
         this.channel = channel;
    }
}
