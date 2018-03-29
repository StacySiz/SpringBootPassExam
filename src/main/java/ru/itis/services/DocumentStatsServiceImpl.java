package ru.itis.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class DocumentStatsServiceImpl implements DocumentStatsService {


//    private static String vocals[] = {"а", "у", "о", "ы", "и", "э", "я", " ю", "ё", " е"};
//    private static String consonant[] = {"б", "в", "г", "д", "ж", "з", "й", "к", "л", "м", "н",
//            "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ"};
    private static String Capconsonant[] = { "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P",
        "Q", "R", "S", "T", "V", "X", "Z","W" };
    private static String consonant[] = {"b", "c","d","f", "g","h", "j", "k", "l", "m", "n","p","q", "r",
            "s", "t" ,"v", "x" ,"z" ,"w"};
    private static String Capvocals[] = { "A", "E", "I", "O", "U", "Y"};
    private static String vocals[] = { "a", "e", "i", "o", "u", "y"};
    private static List<String> CapvocalList = Arrays.asList(Capvocals);
    private static List<String> vocalList = Arrays.asList(vocals);
    private static List<String> CapconsonantList = Arrays.asList(Capconsonant);
    private static List<String> consonantList = Arrays.asList(consonant);

    public String getResultStat() {
        return resultStat;
    }

    public void setResultStat(String resultStat) {
        this.resultStat = resultStat;
    }

    private String resultStat;

    public  String count(File file) {
        int countVocals = 0;
        int countConsonats = 0;


        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = null;
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int symbol;

            while ((symbol = bufferedReader.read()) != -1) {
                char c = (char) symbol;
                String cAsString = c + "";
                System.out.println(cAsString);
                if (CapvocalList.contains(cAsString)||vocalList.contains(cAsString)) {
                    countVocals++;
                }
                if (CapconsonantList.contains(cAsString)||consonantList.contains(cAsString)) {
                    countConsonats++;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        setResultStat( "Your document has " + countVocals + " vocals and " + countConsonats + " consonant");
        System.out.println(resultStat);
        return resultStat;
    }


}


