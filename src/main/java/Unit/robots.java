package Unit;

public class robots extends Toy{


    public robots(String name, String type, int quantity, int id, int fortune) {
        super(name, type, quantity, id, fortune);
    }
    public robots(String name, int quantity, int id, int fortune){
        super(name, "Робот", quantity, id, fortune);

    }
}
