public interface Subject {
    void register(Subscriber subscriber);

    void unRegister(Subscriber subscriber);

    void notifyChannel();

    void uploadVedio(String title);
}
