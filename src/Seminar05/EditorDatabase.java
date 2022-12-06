package Seminar05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class EditorDatabase implements Database{

    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }

    Random random02 = new Random();
    @Override
    public Collection<Entity> getAll() {
        if (entities == null){
            entities = new ArrayList<>();
            int modelsCount = 10 - random02.nextInt(6);
            for (int i = 0; i < modelsCount; i++) {
                generateModelsAndTextures();
            }
        }
        return entities;
    }

    private Random random = new Random();
    private void generateModelsAndTextures(){
        Model3D model = new Model3D();
        int textureCount = random.nextInt(3);
        for (int i = 0; i < textureCount; i++) {
            Texture texture = new Texture();
            model.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model);
    }
}
