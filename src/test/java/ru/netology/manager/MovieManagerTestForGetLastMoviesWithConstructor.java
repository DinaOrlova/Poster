package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovieManagerTestForGetLastMoviesWithConstructor {
    private MovieManager manager = new MovieManager(5);
    private Movie first = new Movie(1, "https://st.kp.yandex.net/im/poster/3/5/7/kinopoisk.ru-De-piraten-van-hiernaast-3572366.jpg", "Пираты по соседству", "семейный");
    private Movie second = new Movie(2, "https://st.kp.yandex.net/im/poster/3/5/8/kinopoisk.ru-Die-K_26_23228_3Bnguru-Chroniken-3584857.jpg", "Осторожно, Кенгуру!", "комедия");
    private Movie third = new Movie(3, "https://st.kp.yandex.net/im/poster/3/5/2/kinopoisk.ru-Dr_26_23248_3Bmmebyggerne-3520992.jpg", "Творцы снов", "семейный");
    private Movie fourth = new Movie(4, "https://st.kp.yandex.net/im/poster/3/5/7/kinopoisk.ru-The-Vigil-3570088.jpg", "Диббук", "ужасы");
    private Movie fifth = new Movie(5, "https://st.kp.yandex.net/im/poster/3/5/7/kinopoisk.ru-Superintelligence-3574408.jpg", "Искусственный интеллект", "фантастика");
    private Movie sixth = new Movie(6, "https://st.kp.yandex.net/im/poster/3/5/7/kinopoisk.ru-Neposredstvenno_2C-Kaha_21-3572353.jpg", "Непосредственно Каха!", "комедия");
    private Movie seventh = new Movie(7, "https://st.kp.yandex.net/im/poster/3/5/7/kinopoisk.ru-Kometa-Galleia-3576175.jpg", "Комета Галлея", "комедия");
    private Movie eighth = new Movie(8, "https://st.kp.yandex.net/im/poster/3/5/6/kinopoisk.ru-Polnoe-pogruzhenie-3566374.jpg", "Полное погружение", "мультфильм");
    private Movie ninth = new Movie(9, "https://st.kp.yandex.net/im/poster/3/5/7/kinopoisk.ru-Neadekvatnye-lyudi-2-3572346.jpg", "Неадекватные люди 2", "драма");
    private Movie tenth = new Movie(10, "https://st.kp.yandex.net/im/poster/3/5/7/kinopoisk.ru-Serebrianye-konki-3576064.jpg", "Серебряные коньки", "история");
    private Movie eleventh = new Movie(11, "https://st.kp.yandex.net/im/poster/3/5/6/kinopoisk.ru-Centigrade-3567842.jpg", "Ледяной капкан", "триллер");
    private Movie twelfth = new Movie(12, "https://st.kp.yandex.net/im/poster/3/5/7/kinopoisk.ru-Breaking-Surface-3574810.jpg", "Глубокое погружение", "триллер");

    @Test
    void shouldGetLastFiveMovies() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        manager.addMovie(eleventh);
        manager.addMovie(twelfth);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMoviesWhenOnlyFive() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMoviesLessFive() {
        manager.addMovie(first);
        manager.addMovie(second);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMoviesWhenOnlyOne() {
        manager.addMovie(first);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMoviesWhenEmpty() {

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMoviesAddedOutOfOrder() {
        manager.addMovie(fifth);
        manager.addMovie(eighth);
        manager.addMovie(twelfth);
        manager.addMovie(second);
        manager.addMovie(tenth);
        manager.addMovie(first);
        manager.addMovie(fourth);
        manager.addMovie(ninth);
        manager.addMovie(third);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eleventh);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{eleventh, seventh, sixth, third, ninth};

        assertArrayEquals(expected, actual);
    }
}