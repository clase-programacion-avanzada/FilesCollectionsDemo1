package com.company;

import com.company.model.Song;
import com.company.utils.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Lists can not be created with the following syntax
        // as they are abstract classes

        //List number = new List();

        //But we can create an instance of a List
        // of a concrete class
        List<Song> songDb = new ArrayList<>();

        //We can add elements to the list
        songDb.add(new Song("Song 1", "Artist 1", "rock", 120, "album 1"));

        //We can get the size of the list
        System.out.println(songDb.size());

        //We can get the element at a specific index
        System.out.println(songDb.get(0));

        //We can remove an element from the list
        songDb.remove(0);

        //We can check if the list is empty
        System.out.println(songDb.isEmpty());



        songDb.add(new Song("Song 1", "Artist 1", "rock", 120, "album 1"));
        songDb.add(new Song("Song 2", "Artist 2", "rock", 120, "album 2"));
        songDb.add(new Song("Song 3", "Artist 3", "pop", 120, "album 3"));

        //Also we can loop through the list
        for(Song song : songDb){
            if (song.getGenre().equals("rock")) {
                System.out.println(song);
            }

        }

        //Alternate way to operate on the list using streams
        songDb.stream()
                .filter(song -> song.getGenre().equals("rock"))
                .forEach(song -> System.out.println(song));

        //Writing the songs to a file
        try {
            FileHandler.writeSongsToFile("DB_Songs.dat",songDb);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Reading the songs from the file
        try {
            List<Song> songsFromFile = FileHandler.readSongsFromFile("DB_Songs.dat");
            System.out.println(songsFromFile);
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        //Writing list directly to a file
        try {
            FileHandler.writeObjectToFile("DB_Songs.dat",songDb);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Reading list directly from a file
        try {
            List<Song> songsFromFile =
                    (ArrayList<Song>) FileHandler.readObjectFromFile("DB_Songs.dat");
        }  catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }



    }
}
