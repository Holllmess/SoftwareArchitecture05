package Seminar05;

import java.util.Collection;
import java.util.Random;

public class EditorBusinessLogical implements BusinessLogicalLayer{

    private final DatabaseAccess databaseAccess;

    public EditorBusinessLogical(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model:getAllModels()) {
            processRender(model);
        }
    }

    private Random random = new Random();
    private void processRender(Model3D model){
        try {
            Thread.sleep(2500 - random.nextInt(2001));
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
