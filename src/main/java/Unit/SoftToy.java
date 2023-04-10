package Unit;

public class SoftToy extends Toy{



    public SoftToy(String name, String type, int quantity, int id, int fortune) {
        super(name, type, quantity, id, fortune);

    }
    public SoftToy(String name, int quantity, int id, int fortune){
        super(name, "Мягкая игрушка", quantity, id, fortune);

    }
}
