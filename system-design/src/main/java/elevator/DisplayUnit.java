package elevator;

/**
 * A display unit, an embeddable component that must reside in a
 */
public interface DisplayUnit {
    void reset();
    void update(DisplayInformation information);
}
