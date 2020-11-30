package thoughtworks;

/**
 * A class representing a board
 */
public class BoardCell {
//    private final Type type;

    enum Type {
        E("E"),
        L("L"),
        J("J"),
        H("H");

        private final String display;

        Type(String display) {
            this.display = display;
        }

        public static Type fromText(String value) {
            return Type.valueOf(value);
        }
    }

    private CellArtifact artifact;

//    public BoardCell(Type type) {
//        this.type = type;
//    }

    public BoardCell(CellArtifact artifact) {
        this.artifact = artifact;
    }

    public CellArtifact getArtifact() {
        return this.artifact;
    }

//    public Type getType() {
//        return type;
//    }

//    @Override
//    public String toString() {
//        return type.display;
//    }
}
