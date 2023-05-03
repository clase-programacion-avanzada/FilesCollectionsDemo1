package com.company.utils;

import com.company.model.Song;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileHandler {

    //classic I/O methods for text



    //using bufferreader
    public static void readFileWithBuffer(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    //using bufferwriter
    public static void writeFileWithBuffer(String fileName, String text, boolean append) throws IOException {
        FileWriter fw = new FileWriter(fileName,append);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(text);
        }
    }


    //new I/O methods for text

    //using readAlllines

    public static void readFileWithReadAllLines(String fileName) throws IOException {
        File file = new File(fileName);
        List<String> lines = Files.readAllLines(file.toPath());
        for(String line : lines) {
            System.out.println(line);
        }
    }

    //using files.lines

    public static void readFileWithFilesLines(String fileName) throws IOException {
        File file = new File(fileName);
        try (Stream<String> lines = Files.lines(file.toPath())) {
            lines.forEach(line -> System.out.println(line));
        }
    }

    //using scanner

    public static void readFileWithScanner(String fileName) throws IOException {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }

    //New I/O reading bytes

    public static void readFileAllBytes(String fileName) throws IOException {
        File file = new File(fileName);

        byte [] fileBytes = Files.readAllBytes(file.toPath());
        char singleChar;
        for(byte b : fileBytes) {
            singleChar = (char) b;
            System.out.print(singleChar);
        }
    }



    //write Song objects to file

    public static void writeSongsToFile(String fileName,List<Song> songs) throws IOException {
        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for(Song song : songs) {
                oos.writeObject(song);
            }
        }

    }

    public static void writeObjectToFile(String fileName, Object obj) throws IOException {
        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(obj);
        }

    }

    //read object from file
    public static Object readObjectFromFile(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);

        try (FileInputStream fis = new FileInputStream(file);
                     ObjectInputStream ois = new ObjectInputStream(fis)) {

            return ois.readObject();
        }

    }



    public static List<Song> readSongsFromFile (String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        List<Song> songs = new ArrayList<Song>();

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while(true) {
                Song song = (Song) ois.readObject();
                songs.add(song);
                System.out.println(song);
            }
        }catch (EOFException e) {
            return songs;
        }



    }



    
}
