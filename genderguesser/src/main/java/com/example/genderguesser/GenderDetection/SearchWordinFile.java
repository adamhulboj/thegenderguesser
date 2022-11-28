package com.example.genderguesser.GenderDetection;

import java.io.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.*;


public class SearchWordinFile implements SearchWord {
    private String wordToSearch;
    private String filePath;

    private boolean searchInFile() throws IOException {

        File fileDescriptor = new File(filePath);
        String[] words = null;  //Intialize the word Array
        FileReader fileReader = null;
        fileReader = new FileReader(fileDescriptor);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String lineFormFile;

        while(true)   //Reading Content from the file
        {
            if (!((lineFormFile=bufferedReader.readLine())!=null)) break;
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

    private boolean searchInFileUsingStream()
    {
        List<String> foundTokenList = searchStream();
        return !foundTokenList.isEmpty();
    }
    public List<String> searchStream() {

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Stream<String> linesStream = bufferedReader.lines();
        return linesStream.filter(a -> a.equals(wordToSearch)).collect(Collectors.toList());

    }

    public SearchWordinFile(String wordToSearch, String filePath) {
        this.wordToSearch = wordToSearch.toUpperCase();
        this.filePath = filePath;
    }

    @Override
    public boolean search(int aVersion) {
        switch(aVersion) {
            case 1:
                return searchInFileUsingStream();
            case 2:
                try {
                    return searchInFile();
                            } catch (IOException e) {
                    throw new RuntimeException(e);
                }

        }
        return false;
    }
}