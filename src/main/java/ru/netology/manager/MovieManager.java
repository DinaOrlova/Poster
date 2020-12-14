package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
  int length = 10;
  private Movie[] movies = new Movie[0];

  public MovieManager() {
  }

  public MovieManager(int length) {
    this.length = length;
  }

  public Movie[] addMovie(Movie movie) {
    int length = movies.length + 1;
    Movie[] tmp = new Movie[length];
    System.arraycopy(movies, 0, tmp, 0, movies.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex]=movie;
    movies = tmp;
    return movies;
  }

  public Movie[] getLastMovies() {
    Movie[] result = new Movie[length];
    Movie[] reverse = new Movie[movies.length];
    for (int i = 0; i < movies.length; i++) {
      int index = movies.length - i - 1;
      reverse[i] = movies[index];
    }
    if (reverse.length < length) {
      length = reverse.length;
      result = reverse;
    }
    else {
      System.arraycopy(reverse, 0, result, 0, result.length);
    }
    return result;
  }
}

