package Seminar05;

import java.util.ArrayList;

public class Editor3D implements UILayer{

    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccess;
    private Database database;

    private void checkProjectFile(){
        if (projectFile == null){
            throw new RuntimeException("The Project File is not defined.");
        }
    }

    @Override
    public void openProject(String fileName) {
        projectFile = new ProjectFile(fileName);
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabeseAccess(database);
        businessLogicalLayer = new EditorBusinessLogical(databaseAccess);
    }

    @Override
    public void showProjectSettings() {
        //TODO: Предусловие
        checkProjectFile();

        System.out.println("*** Project #001 ***");
        System.out.printf("File name: %s\n", projectFile.getFileName());
        System.out.printf("Setting01: %s\n", projectFile.getSetting01());
        System.out.printf("Setting02: %s\n", projectFile.getSetting02());
        System.out.printf("Setting03: %s\n", projectFile.getSetting03());

    }

    @Override
    public void saveProject() {

    }

    @Override
    public void printAllModels() {
        //TODO: Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("---%d---\n", i);
            System.out.println(models.get(i));
            for (Texture texture:models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }

    }

    @Override
    public void printAllTextures() {
        //TODO: Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>)businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("---%d---\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        //TODO: Предусловие
        checkProjectFile();

        System.out.println("Please wait..");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long finishTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Operation completed in %d ms.\n", finishTime);

    }

    @Override
    public void renderModel(int i) {
        //TODO: Предусловие
        checkProjectFile();

        //TODO: Предусловие
        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size()){
            throw new RuntimeException("Incorrect model number.");
        }

        System.out.println("Please wait..");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long finishTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Operation completed in %d ms.\n", finishTime);
    }
}
