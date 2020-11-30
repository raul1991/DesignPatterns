package elevator;

public class SevenSegmentDisplayUnit implements DisplayUnit {

    @Override
    public void reset() {
        System.out.println("Resetting the display.");
    }

    @Override
    public void update(DisplayInformation information) {
        System.out.println("Display updated with " + information);
    }
}
