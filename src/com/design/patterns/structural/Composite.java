package com.design.patterns.structural;

import java.util.ArrayList;
import java.util.List;

abstract class FileSystem {
    protected String fileSystemName;

    public FileSystem(String fileSystemName) {
        this.fileSystemName = fileSystemName;
    }

    abstract void show(String indentation);
}

class File extends FileSystem {
    public File(String fileName) {
        super(fileName);
    }

    @Override
    public void show(String indentation) {
        System.out.println(indentation + fileSystemName);
    }
}

class Folder extends FileSystem {

    private List<FileSystem> fileSystemList = new ArrayList<>();

    public Folder(String folderName) {
        super(folderName);
    }

    @Override
    void show(String indentation) {
        System.out.println(indentation + fileSystemName);

        for(FileSystem fileSystem : fileSystemList) {
            fileSystem.show(indentation + "-");
        }

    }

    void add(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }
}

public class Composite {
    public static void main(String[] args) {

        File file1 = new File("File 1");
        File file2 = new File("File 2");
        File file3 = new File("File 3");
        File file4 = new File("File 4");

        Folder folder1 = new Folder("Folder 1");
        Folder folder2 = new Folder("Folder 2");
        Folder folder3 = new Folder("Folder 3");

        folder3.add(file2);
        folder3.add(folder2);
        folder2.add(file3);
        folder2.add(file4);
        folder1.add(file1);

        folder1.add(folder3);
        folder1.add(new File("file x"));

        folder2.show("");

    }
}















