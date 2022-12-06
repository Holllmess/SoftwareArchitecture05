package Seminar05;

public class ProjectFile {
    private String fileName;
    private int setting01;
    private String setting02;
    private boolean setting03;

    public String getFileName() {
        return fileName;
    }

    public int getSetting01() {
        return setting01;
    }

    public void setSetting01(int setting01) {
        this.setting01 = setting01;
    }

    public String getSetting02() {
        return setting02;
    }

    public void setSetting02(String setting02) {
        this.setting02 = setting02;
    }

    public boolean getSetting03() {
        return setting03;
    }

    public void setSetting03(boolean setting03) {
        this.setting03 = setting03;
    }

    public ProjectFile(String fileName) {
        this.fileName = fileName;
        init();
    }

    private void init(){
        setting01 = 1;
        setting02 = " ";
        setting03 = false;
    }
}
