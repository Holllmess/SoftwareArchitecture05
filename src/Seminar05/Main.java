package Seminar05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Editor3D editor3D = new Editor3D();
        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        while (f){
            System.out.println("*** My editor3D ***");
            System.out.println("1. Open the project.");
            System.out.println("2. Save the project.");
            System.out.println("3. Display project settings.");
            System.out.println("4. Display all project models.");
            System.out.println("5. Display all project texture.");
            System.out.println("6. Render all models.");
            System.out.println("7. Render the model.");
            System.out.println("0. Application shutdown.");
            System.out.println("Select menu item, please love: ");
            if (scanner.hasNextInt()){
                int nn = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (nn){
                        case 0:
                            System.out.println("Application shutdown.");
                            f = false;
                            break;
                        case 1:
                            System.out.println("Enter the project file name: ");
                            String fileName = scanner.nextLine();
                            editor3D.openProject(fileName);
                            System.out.println("The project is successfully opened.");
                            break;
                        case 3:
                            editor3D.showProjectSettings();
                            break;
                        case 4:
                            editor3D.printAllModels();
                            break;
                        case 5:
                            editor3D.printAllTextures();
                            break;
                        case 6:
                            editor3D.renderAll();
                        case 7:
                            System.out.println("Enter the model number: ");
                            if (scanner.hasNextInt()){
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.renderModel(modelNo);
                            } else {
                                System.out.println("Incorrect model number. ");
                            }
                        default:
                            System.out.println("Select correct menu item, please. ");
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Select correct menu item, please. ");
                scanner.nextLine();
            }
        }
    }
}
