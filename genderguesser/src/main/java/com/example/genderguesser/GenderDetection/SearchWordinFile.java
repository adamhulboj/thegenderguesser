package com.example.genderguesser.GenderDetection;

import java.io.*;


public class SearchWordinFile implements SearchWord {
    private String wordToSearch;
    private String filePath;

    private boolean searchInFile() throws IOException {

        File fileDescriptor = new File(filePath);
        String[] words = null;  //Intialize the word Array
        FileReader fileReader = new FileReader(fileDescriptor);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String lineFormFile;

        while((lineFormFile=bufferedReader.readLine())!=null)   //Reading Content from the file
        {
            words=lineFormFile.split(" ");  //Split the word using space
            for (String word : words)
            {
                if (word.equals(wordToSearch))   //Search for the given word
                {
                    fileReader.close();
                    return true;    //one instance of searched word exists
                }
            }
        }
        fileReader.close();
        return false;  //word does not exist
    }


    public SearchWordinFile(String wordToSearch, String filePath) {
        this.wordToSearch = wordToSearch;
        this.filePath = filePath;
    }

    @Override
    public boolean search() {
        try {
            return searchInFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}