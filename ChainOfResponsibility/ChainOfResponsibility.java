public class ChainOfResponsibility {
    public static void main(String[] args) {
        NotificationContext con = new NotificationContext("EMAIL");
        con.execute();
    }
}

class NotificationContext{
    String name ;
    NotificationContext(String str){
        name = str;
    }
    void execute(){
        NotificationHandler handler = new SMSHandler(name,
                                            new EmailHandler(name,null));
        handler.notifyHandler();
    }
}
