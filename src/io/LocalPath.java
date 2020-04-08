package io;

public class LocalPath {
    public static void main(String[] args) {
        String pathWithRightSlash = System.getProperty("user.dir").replaceAll("\\\\", "/");
        String fullPathToFolder = "file:///" + pathWithRightSlash + "/src/uploads/";
        System.out.println(fullPathToFolder);

        LocalPath localPath = new LocalPath();
        String fullPathToProject = localPath.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(fullPathToProject);
    }
}