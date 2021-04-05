public class MementoDemo_Behavioral {
    public static void main(String[] args) {
        FileCareTaker careTaker = new FileCareTaker();
        FileWriterUtil fileWriterUtil = new FileWriterUtil("myNote.txt");
        
        fileWriterUtil.write("My name is Debosmita Paul..\n");
        fileWriterUtil.write("This is my first statement...\n");
        System.out.println(fileWriterUtil);
        careTaker.save(fileWriterUtil);

        fileWriterUtil.write("This is my second statement..\n");
        System.out.println(fileWriterUtil);

        careTaker.undo(fileWriterUtil);
        System.out.println(fileWriterUtil);
    }
}
class FileCareTaker{
    Object object;
    public void undo(FileWriterUtil fileWriterUtil){
        fileWriterUtil.undoText(object);
    }
    public void save(FileWriterUtil fileWriterUtil){
        this.object = fileWriterUtil.save();
    }
}
class FileWriterUtil{
    private String fileName;
    private StringBuilder content;
    FileWriterUtil(String file){
        this.fileName = file;
        this.content = new StringBuilder();
    }
    @Override
    public String toString(){
        return  this.content.toString();
    }
    public void write(String str){
        this.content.append(str);
    }
    public void undoText(Object obj){
        Memento memento = (Memento)obj;
        this.fileName= memento.fileName;
        this.content = memento.content;
    }
    public Memento save(){
        return  new Memento(this.fileName,this.content);
    }
    private class Memento{
        private String fileName;
        private StringBuilder content;
        Memento(String file, StringBuilder content){
            this.fileName = file;
            this.content = new StringBuilder(content);
        }
    }
}
