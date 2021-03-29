public class SMSHandler implements NotificationHandler {
    NotificationHandler handler;
    String sms;
    SMSHandler(String str,  NotificationHandler handler){
        sms = str;
        this.handler = handler;
    }
    @Override
    public boolean notifyHandler() {
        if(sms.equals("SMS")){
            System.out.println("Send sms notification");
            return true;
        }
        else{
            if(this.handler!=null){
                System.out.println("passing to email handler... ");
                return this.handler.notifyHandler();
            }
            else{
                return false;
            }
        }
    }
}
