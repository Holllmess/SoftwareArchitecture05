package Seminar05;

import java.util.Collection;

public interface BusinessLogicalLayer {
    Collection<Texture> getAllTextures();
    Collection<Model3D> getAllModels();
    void renderModel(Model3D model);
    void renderAllModels();
}
