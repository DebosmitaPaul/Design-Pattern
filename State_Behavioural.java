public class State_Behavioural {
    public static void main(String[] args) {
        State start = new StartedState();
        State stop = new StoppedState();

        Context context = new Context(start);
        System.out.println(context.getState().toString());

        stop.doAction(context);
        System.out.println(context.getState().toString());

        start.doAction(context);
        System.out.println(context.getState().toString());
    }
}
class Context{
    State state;
    Context(State state)
    {
        this.state = state;
    }
    public  void  setState(State state){
        this.state = state;
    }
    public State getState(){
        return this.state;
    }
}
interface State{
    void doAction(Context context);
}
class StartedState implements State{

    @Override
    public void doAction(Context context) {
        context.setState(this);
        System.out.println("At Started State");
    }

    @Override
    public String toString() {
        return "Current state is Started.";
    }
}
class  StoppedState implements State{

    @Override
    public void doAction(Context context) {
        context.setState(this);
        System.out.println("At Stopped state.");
    }

    @Override
    public String toString() {
        return "Current state is Stopped.";
    }
}