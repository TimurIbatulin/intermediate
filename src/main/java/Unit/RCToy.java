package Unit;

public class RCToy extends Toy{


    public RCToy(String name, String type, int quantity, int id, int fortune) {
        super(name, type, quantity, id, fortune);

    }
    public RCToy(String name, int quantity, int id,  int fortune){
        super(name, "Радиоуправляемая игрушка", quantity, id, fortune);
    }

}
