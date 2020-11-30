package thoughtworks;

import java.util.List;

public class Hotel implements CellArtifact, Upgradeable {

    private List<CellArtifactVariant> variants;
    private CellArtifactVariant selectedVariant;

    public Hotel(List<CellArtifactVariant> variants) {
        this.variants = variants;
    }

    @Override
    public String type() {
        return "hotel";
    }

    @Override
    public int value() {
        return selectedVariant.getVariantType().getValue();
    }

    public void setSelectedVariant(CellArtifactVariant selectedVariant) {
        this.selectedVariant = selectedVariant;
    }

    @Override
    public int upgrade() {
        if (selectedVariant.getVariantType().equals(CellArtifactVariant.Type.SILVER)) {
            this.selectedVariant = new CellArtifactVariant(CellArtifactVariant.Type.GOLD.name());
        }
        return selectedVariant.getVariantType().getValue();
    }
}
