package ru.itis.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class DocumentStatsServiceImpl implements DocumentStatsService {

    public String vocals[] = {"а", "у", "о", "ы", "и", "э", "я", " ю", "ё", " е"};
    public String consonant[] = {"б", "в", "г", "д", "ж", "з", "й", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ"};
    List<String> vocalList = Arrays.asList(vocals);
    List<String> consonantList = Arrays.asList(consonant);

    public String resultStat = "HELLO BLYAT";


    @Override
    public String count(Path path) {
//        int countVocals = 0;
//        int countConsonats = 0;
//        try {
//            InputStream inputStream = file.getInputStream();
//            BufferedReader bufferedReader = null;
//            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            int symbol = 0;
//
////            symbol = bufferedReader.read();
//            while ((symbol = bufferedReader.read()) != -1) {
//                 char c = (char) symbol;
////                symbol = bufferedReader.read(); // Читаем символ
//                if (vocalList.contains(c)) {
//                    countVocals++;
//                }
//                if (consonantList.contains(c)) {
//                    countConsonats++;
//                }
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        resultStat = "В документе всего " + countVocals + "гласных и " + countConsonats + " согласных";
        resultStat = "ITSME HEYY";
        return resultStat;
    }

}
//        int symbol = 0;
//        try {
//            symbol = bufferedReader.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        while (symbol != -1) {  // Когда дойдём до конца файла, получим '-1'
//            // Что-то делаем с прочитанным символом
//            // Преобразовать в char:
//            // char c = (char) symbol;
//            try {
//                symbol = bufferedReader.read(); // Читаем символ
//                if (vocalList.contains(symbol)){
//                    countVocals++;
//                }
//                if (consonantList.contains(symbol)){
//                    countConsonats++;
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            resultStat = "В документе всего " + countVocals + "гласных и " + countConsonats + " согласных";
//        }
//        return resultStat;
//    }


