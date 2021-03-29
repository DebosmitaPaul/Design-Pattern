public class EmailHandler implements NotificationHandler{
    NotificationHandler handler;
    String email;
    EmailHandler(String str, NotificationHandler handler) {
        email = str;
        this.handler= handler;
    }
    @Override
    public boolean notifyHandler() {
        if (email.equals("EMAIL")) {
            System.out.println("Send email notification");
            return true;
        }
        else {
            if (this.handler != null) {
                System.out.println("passing to sms handler... ");
                return this.handler.notifyHandler();
            } else {
                return false;
            }
        }
    }
}
