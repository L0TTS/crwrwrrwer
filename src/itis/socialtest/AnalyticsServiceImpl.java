package itis.socialtest;

import itis.socialtest.entities.Post;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AnalyticsServiceImpl implements AnalyticsService {
    @Override
    public List<Post> findPostsByDate(List<Post> posts, String date) {
        return posts.stream()
                .filter(post -> post.getDate().equals(date))
                .collect(Collectors.toList());

    }

    @Override
    public String findMostPopularAuthorNickname(List<Post> posts) throws IOException {
        FileInputStream input = new FileInputStream("Author.csv");
        int flag = 0;
        int maximum = -1;
        int answer = 0;
        while ((input.read()) != -1) {
            flag++;
        }
        int[] arr = new int[flag];
        for (Post post : posts) {
            arr[(int) (post.getAuthor().getId() - 1)] += post.getLikesCount();
        }
        for (int i = 0; i < flag; i++) {
            if (maximum < arr[i]) {
                maximum = arr[i];
                answer = i + 1;
            }
        }
        for (Post post : posts) {
            if (post.getAuthor().getId() == answer) {
                return post.getAuthor().getNickname();
            }
        }
        return null;
    }

    @Override
    public Boolean checkPostsThatContainsSearchString(List<Post> posts, String searchString) {
        return posts.stream()
                .anyMatch(post -> post.getContent().equals(searchString));
    }

    @Override
    public List<Post> findAllPostsByAuthorNickname(List<Post> posts, String nick) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Author.csv");
        return posts.stream()
                .filter(post -> post.getAuthor().getNickname().equals(nick))
                .collect(Collectors.toList());
    }
}
