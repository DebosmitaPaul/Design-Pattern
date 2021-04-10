public class Command_Behavioral {
    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();

        Light light = new Light();
        control.setCommand(new LightOnCommand(light));
        control.pressButton();
        control.setCommand(new LightOffCommand(light));
        control.pressButton();

        Vedio vedio = new Vedio();
        control.setCommand(new VedioForwardCommand(vedio));
        control.pressButton();
        control.setCommand(new VedioResumeCommand(vedio));
        control.pressButton();
    }
}
class RemoteControl{
    Command command;
    public void setCommand(Command command){
        this.command = command;
    }
    public void pressButton(){
        command.execute();
    }
}
interface Command{
    void execute();
}
class LightOnCommand implements Command{
    Light light;
    LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOn();
    }
}
class LightOffCommand implements Command{
    Light light;
    LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
     light.switchOff();
    }
}
class Light{
    boolean isOn;
    public void switchOn(){
        isOn= true;
        System.out.println("Light is on");
    }
    public void switchOff(){
        isOn = false;
        System.out.println("Light is off");
    }
}
class VedioForwardCommand implements Command{
    Vedio vedio;
    VedioForwardCommand(Vedio vedio){
        this.vedio = vedio;
    }
    @Override
    public void execute() {
        vedio.forward();
    }
}
class VedioBackrwardCommand implements Command{
    Vedio vedio;
    VedioBackrwardCommand(Vedio vedio){
        this.vedio = vedio;
    }
    @Override
    public void execute() {
        vedio.backward();
    }
}
class VedioResumeCommand implements Command{
    Vedio vedio;
    VedioResumeCommand(Vedio vedio){
        this.vedio = vedio;
    }
    @Override
    public void execute() {
        vedio.resume();
    }
}

class Vedio{
    int i;
    public void forward(){
        i =1;
        System.out.println("Vedio forwarded");
    }
    public void backward(){
        i=-1;
        System.out.println("Vedio backwarded");
    }
    public void resume(){
        i=0;
        System.out.println("vedio resumed");
    }
}