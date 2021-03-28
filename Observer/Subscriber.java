
public class Subscriber  implements Observer{
    private String name ;
    private ChannelOnYouTube channel;
    public Subscriber(String name){
        this.name = name;
    }
    @Override
    public void Update()
    {
        System.out.println("Hey "+name+" Vedio Uploaded..");
    }
    @Override
    public void subscribeChannel(ChannelOnYouTube channel)
    {
         this.channel = channel;
    }
}
