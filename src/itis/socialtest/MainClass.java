package itis.socialtest;


import itis.socialtest.entities.Author;
import itis.socialtest.entities.Post;

import java.io.*;
import java.util.List;


/*
 * В папке resources находятся два .csv файла.
 * Один содержит данные о постах в соцсети в следующем формате: Id автора, число лайков, дата, текст
 * Второй содержит данные о пользователях  - id, никнейм и дату рождения
 *
 * Напишите код, который превратит содержимое файлов в обьекты в package "entities"
 * и осуществите над ними следующие опреации:
 *
 * 1. Выведите в консоль все посты в читабельном виде, с информацией об авторе.
 * 2. Выведите все посты за сегодняшнюю дату
 * 3. Выведите все посты автора с ником "varlamov"
 * 4. Проверьте, содержит ли текст хотя бы одного поста слово "Россия"
 * 5. Выведите никнейм самого популярного автора (определять по сумме лайков на всех постах)
 *
 * Для выполнения заданий 2-5 используйте методы класса AnalyticsServiceImpl (которые вам нужно реализовать).
 *
 * Требования к реализации: все методы в AnalyticsService должны быть реализованы с использованием StreamApi.
 * Использование обычных циклов и дополнительных переменных приведет к снижению баллов, но допустимо.
 * Парсинг файлов и реализация методов оцениваются ОТДЕЛЬНО
 *
 *
 * */

public class MainClass {

    private List<Post> allPosts;

    private AnalyticsService analyticsService = new AnalyticsServiceImpl();

    public static void main(String[] args) throws FileNotFoundException {
        new MainClass().run("PostDatabase.csv", "Authors.csv");
    }

    private void run(String postsSourcePath, String authorsSourcePath) throws FileNotFoundException {
        try(BufferedReader bw = new BufferedReader(new FileReader(authorsSourcePath)))
        {
            String s = bw.readLine();
            Author answer = null;
            Post ans = null;

            while (s!= null){
                answer.setId((long) s.charAt(0));
                int nick = -1;
                int endnick = -1;
                for (int i = 0; i< s.length();i++){
                    if(s.charAt(i) == ','){
                        nick = i + 1;
                        break;
                    }
                }
                for (int i = nick; i< s.length();i++){
                    if(s.charAt(i) == ','){
                        endnick =  i;
                        break;;
                    }
                }
                answer.setNickname(s.substring(nick,endnick));
                answer.setBirthdayDate(s.substring(endnick + 2, s.length() + 1));
                ans.setAuthor(answer);
                int bl = -1;
                int el = -1;
                for (int i = 0; i< s.length();i++){
                    if(s.charAt(i) == ','){
                        bl = i + 2;
                        break;;
                    }
                }
                for (int i = bl; i< s.length();i++){
                    if(s.charAt(i) == ','){
                        el =  i;
                        break;;
                    }
                }
                String string = s.substring(bl,el);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(BufferedReader bw = new BufferedReader(new FileReader(postsSourcePath)))
        {
            String s = bw.readLine();
            Post answer;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
