package itis.socialtest;


import itis.socialtest.entities.Post;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface AnalyticsService {

    List<Post> findPostsByDate(List<Post> posts, String date);

    Boolean checkPostsThatContainsSearchString(List<Post> posts, String searchString);

    List<Post> findAllPostsByAuthorNickname(List<Post> posts, String nick) throws IOException;

    String findMostPopularAuthorNickname(List<Post> posts) throws IOException;
}
