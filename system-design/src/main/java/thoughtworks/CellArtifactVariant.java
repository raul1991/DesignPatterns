package thoughtworks;

public class CellArtifactVariant {
    private final Type variantType;

    public Type getVariantType() {
        return variantType;
    }

    enum Type {
        SILVER("silver", 100),
        GOLD("gold", 200);

        Type(String type, int value) {
            this.type = type;
            this.value = value;
        }

        private String type;
        private final int value;

        public int getValue() {
            return value;
        }
    }

    public CellArtifactVariant(String type) {
        this.variantType = Type.valueOf(type);
    }
}
