public class YouTube {
    public static void main(String[] args) {
        ChannelOnYouTube channel = new ChannelOnYouTube();

        Subscriber s1 = new Subscriber("Debo");
        Subscriber s2 = new Subscriber("paul");
        Subscriber s3 = new Subscriber("Rahul");
        Subscriber s4 = new Subscriber("Nishant");

        channel.register(s1);
        channel.register(s2);
        channel.register(s3);
        channel.register(s4);
        
        channel.uploadVedio("Dance..");
        
        channel.unRegister(s3);

        channel.uploadVedio("Song..");

    }
}
