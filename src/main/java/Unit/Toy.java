package Unit;
import java.util.ArrayList;
public abstract class Toy{
    public String name, type;
    public int quantity, id, fortune;


    public Toy(String name, String type, int quantity, int id, int fortune) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.id = id;
        this.fortune = fortune;
    }
    public String getType(){return type;}

    public int getFortune(){return fortune;}
    public String getPrint(){ return String.format("%14s Имя:%s Количество:%d ID:%d", type, name, quantity, id);}
}
