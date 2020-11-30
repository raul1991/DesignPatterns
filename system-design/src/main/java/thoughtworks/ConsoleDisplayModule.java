package thoughtworks;

public class ConsoleDisplayModule implements DisplayModule<String> {

    @Override
    public void display(String info) {
        System.out.println(info);
    }

    @Override
    public void clear() {
        System.out.println("Trust me! you can't see this!");
    }

    @Override
    public void update(String info) {
        System.out.println("[Display update] " + info);
    }
}
