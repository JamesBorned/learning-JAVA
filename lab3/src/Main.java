/*The laboratory work №3
Мой знакомый - владелец сети кинотеатров.

Цель: разработать консольный вариант программы, моделирующей работу кинотеатров,
с полностью рабочим консольным интерфейсом.

1) В каждом кинотеатре - кинозалы разных типов.
2) У разных залов - разное расписание сеансов.
3) Возможности администратора (доступны после входа в систему администратора):
    1. добавлять название кинотеатра в список доступных;
    2. добавлять номер зала в кинотеатре в список доступных;
    3. задавать конфигурацию кресел;
    4. добавлять время и длительность сеанса определённого фильма в конкретном зале;
4) Покупка пользователем билета в кино зависит от факторов:
    1. Фильм есть в списке доступных (указана продолжительность).
    2. Есть билеты.
    3. Если сеансы фильма (на указанную дату (сегодняшняя, по умолчанию)) есть в разных кинотеатрах,
    то выдать список доступных кинотеатров, в которых остались билеты.
    4. Если пользователь выбрал кинотеатр, то выдать расписание сеансов фильма с указанием
    времени (по неубыванию), на которые остались билеты.
    5. Если пользователь выбрал сеанс, то выдать список залов, в которых будет проходить
    сеанс в указанное время и есть свободные места.
    6. Если пользователь выбрал зал, то отобразить план зала с указанием занятых и свободных мест.
    7. Если пользователя не устроил его выбор, то отобразить предыдущий вывод в консоль.

Задача: разработать консольный вариант MVP-программы (1 кинотеатр, 1 зал, покупка билета пользователем,
        нельзя занять занятое место, ничего не вылетает).
*/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Создадим сеть кинотеатров
        Cinema cinema1 = new Cinema("Каро", "г.Калининград, ул.Краснопресненская, д.57", 3);
        Cinema cinema2 = new Cinema("Каро", "г.Калининград, ул.Грозная, д.34", 4);
        Cinema cinema3 = new Cinema("Каро", "г.Зеленоградск, ул.Молочаевская, д.50", 2);
        List<Cinema> cinemas = Arrays.asList(cinema1, cinema2, cinema3);
        // В каждом кинотеатре создадим то количество кинозалов, что было заявлено ранее
        //System.out.print(cinema1.HallsOfCinema.length);
        Hall C1Hall1 = new Hall(1, 130, 13);
        Hall C1Hall2 = new Hall(2, 200, 10);
        Hall C1Hall3 = new Hall(3, 400, 15);
        cinema1.HallsOfCinema = new Hall[]{C1Hall1, C1Hall2, C1Hall3};
        for (int i = 0; i < cinema1.HallsOfCinema.length; ++i) {
            cinema1.HallsOfCinema[i].initHall(200);
        }

        //System.out.print(cinema2.HallsOfCinema.length);
        Hall C2Hall1 = new Hall(1, 130, 13);
        Hall C2Hall2 = new Hall(2, 200, 10);
        Hall C2Hall3 = new Hall(3, 400, 15);
        Hall C2Hall4 = new Hall(4, 200, 10);
        cinema2.HallsOfCinema = new Hall[]{C2Hall1, C2Hall2, C2Hall3, C2Hall4};
        for (int i = 0; i < cinema2.HallsOfCinema.length; ++i) {
            cinema2.HallsOfCinema[i].initHall(150);
        }

        //System.out.print(cinema3.HallsOfCinema.length);
        Hall C3Hall1 = new Hall(1, 130, 13);
        Hall C3Hall2 = new Hall(2, 200, 10);
        cinema3.HallsOfCinema = new Hall[]{C3Hall1, C3Hall2};
        for (int i = 0; i < cinema3.HallsOfCinema.length; ++i) {
            cinema3.HallsOfCinema[i].initHall(100);
        }

        Hall halls[][] = new Hall[cinemas.size()][];
        // Все залы сети кинотеатров
        for (int i = 0; i < cinemas.size(); ++i) {
            halls[i] = cinemas.get(i).HallsOfCinema;
            cinemas.get(i).setNumberOfCinema(i);
        }
        ArrayList<Hall> sessionHalls = new ArrayList<>();

        // Создадим список доступных к просмотру фильмов
        Movie movie1 = new Movie("Бойцовский клуб", "2ч.");
        Movie movie2 = new Movie("Пианистка", "1ч.30мин.");
        Movie movie3 = new Movie("Американский психопат", "2ч.30мин.");
        Movie movie4 = new Movie("Убить Билла 2", "1ч.30мин.");
        Movie movie5 = new Movie("Помни", "2ч.15мин.");
        List<Movie> movies = Arrays.asList(movie1, movie2, movie3, movie4, movie5);
        // Создадим расписание сеансов (в одно и то же время могут быть сеансы разных фильмов в разных кинозалах)
        Session session1 = new Session("02.11.2023", "14:00", 430);
        Session session2 = new Session("02.11.2023", "17:00", 530);
        Session session3 = new Session("02.11.2023", "19:00", 600);
        Session session4 = new Session("03.11.2023", "20:00", 130);
        // Создадим расписание сеансов определённых фильмов (сеансы одного и того же фильма могут идти
        // в одно и то же время в разных кинозалах)
        MovieSession movieSession1 = new MovieSession(movie1, session1);
        MovieSession movieSession2 = new MovieSession(movie1, session2);
        MovieSession movieSession3 = new MovieSession(movie2, session2);
        MovieSession movieSession4 = new MovieSession(movie3, session3);
        MovieSession movieSession5 = new MovieSession(movie4, session3);
        MovieSession movieSession6 = new MovieSession(movie5, session4);
        List<MovieSession> moviesSessions = Arrays.asList(movieSession1, movieSession2, movieSession3, movieSession4, movieSession5, movieSession6);
        // Инициализируем список вида фильм-сеанс
        for (int i = 0; i < movies.size(); ++i) {
            Movie movie = movies.get(i);
            for (int j = 0; j < moviesSessions.size(); ++j) {
                movie.initMovieSessions(moviesSessions.get(j));
            }
        }
        // Создадим расписание сеансов фильмов вида сеанс-зал
        MovieSessionHall movieSessionHall1 = new MovieSessionHall(movieSession1, C2Hall2);
        MovieSessionHall movieSessionHall2 = new MovieSessionHall(movieSession2, C1Hall2);
        MovieSessionHall movieSessionHall3 = new MovieSessionHall(movieSession3, C2Hall1);
        MovieSessionHall movieSessionHall4 = new MovieSessionHall(movieSession4, C2Hall1);
        MovieSessionHall movieSessionHall5 = new MovieSessionHall(movieSession5, C1Hall3);
        MovieSessionHall movieSessionHall6 = new MovieSessionHall(movieSession6, C3Hall1);
        List<MovieSessionHall> movieSessionHalls = Arrays.asList(movieSessionHall1, movieSessionHall2, movieSessionHall3, movieSessionHall4, movieSessionHall5, movieSessionHall6);

        // Покупка билетов в кассе
        System.out.println("Movies available in cinemas: ");
        // Выводим на экран список доступных в кино фильмов
        for (int i = 0; i < movies.size(); ++i) {
            System.out.println(movies.get(i).getNameOfMovie() + " " + movies.get(i).getDuration());
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Input a name of movie: ");
        String nameOfMovie = in.nextLine();

        Movie movie = new Movie("", "");
        // Проверяем, есть ли фильм в списке
        boolean isOnList = false;
        for (int i = 0; i < movies.size(); ++i) {
            if (nameOfMovie.equals(movies.get(i).getNameOfMovie())) {
                isOnList = true;
                movie = movies.get(i);
            }
        }
        if (!isOnList) {
            System.out.println("Sorry, this movie is not on the list.");
        }

        //System.out.println(movie.getMovieSessions().isEmpty());
        //System.out.println(nameOfMovie.equals(movie5.getNameOfMovie()));
        //System.out.println(movie.getSumNumberOfTickets());

        if (!movie.getNameOfMovie().isEmpty() && movie.getSumNumberOfTickets() != 0) {
            boolean flag = false;
            System.out.println("Input a date:");
            String date = in.nextLine();
            // Проверим, есть ли билеты на сеанс на конкретную дату
            int SumOfTicketsOfSessions = 0;
            for (int i = 0; i < movie.getMovieSessions().size(); ++i) {
                if (movie.getMovieSessions().get(i).getSession().getDate().equals(date)) {
                    flag = true;
                    SumOfTicketsOfSessions += movie.getMovieSessions().get(i).getSession().getNumberOfTickets();
                }
            }
            if (!flag) {
                System.out.println("Sorry, there are no sessions on this date.");
            }
//            for (int s = 0; s < movie.getMovieSessions().size(); ++s) {
//                if (movie.getMovieSessions().get(s).getSession().getDate().equals(date)) {
//                    flag2 = true;
//                    int SumOfTicketsOfSessions = 0;
//                    for (int j = 0; j < movie.getMovieSessions().size(); ++j) {
//                        if (movie.getMovieSessions().get(j).getSession().getDate().equals(date)) {
//                            SumOfTicketsOfSessions += movie.getMovieSessions().get(j).getSession().getNumberOfTickets();
//                        }
//                    }
            if (SumOfTicketsOfSessions == 0 && flag) {
                System.out.println("Sorry, there are no tickets for this date.");
            } else if (SumOfTicketsOfSessions != 0 && flag) {
                // Находим залы, в которых будут проходить сеансы этого фильма в конкретную дату
                for (int k = 0; k < movieSessionHalls.size(); ++k) {
                    if (movieSessionHalls.get(k).getMovieSession().getSession().getDate().equals(date)
                            && movieSessionHalls.get(k).getMovieSession().getMovie() == movie) {
                        sessionHalls.add(movieSessionHalls.get(k).getHall());
                    }
                }

                // Создадим множество уникальных элементов, чтобы залы не повторялись
                Set<Hall> set = new HashSet<>(sessionHalls);
                sessionHalls.clear();
                sessionHalls.addAll(set);
                // Создадим список кинотеатров, в которых проходят сеансы фильмов в определённую дату
                ArrayList<Cinema> ListOfCinemas = new ArrayList<>();
                for (int m = 0; m < halls.length; m++) {
                    for (int l = 0; l < halls[m].length; ++l) {
                        for (int hall = 0; hall < sessionHalls.size(); ++hall) {
                            if (halls[m][l] == sessionHalls.get(hall)) {
                                ListOfCinemas.add(cinemas.get(m));
                                //cinemas.get(m).setNumberOfCinema(m + 1);
                            }
                        }
                    }
                }
                Set<Cinema> set2 = new HashSet<>(ListOfCinemas);
                ListOfCinemas.clear();
                ListOfCinemas.addAll(set2);
                int Number = 1;
                for (int cinema = 0; cinema < ListOfCinemas.size(); cinema++) {
                    System.out.println((Number + cinema) + ". " + ListOfCinemas.get(cinema).getNameOfCinema() + " "
                            + ListOfCinemas.get(cinema).getAddress());
                    ListOfCinemas.get(cinema).setNumberOfPreferredCinema(Number + cinema);
                }

                System.out.println("Please, choose your preferred cinema. Enter its number. ");
                int numberOfCinema = in.nextInt();
                Cinema prefferedCinema = new Cinema("", "", 0);
                // Ищем выбранный кинотеатр в списке
                for (int j = 0; j < cinemas.size(); ++j) {
                    if (cinemas.get(j).getNumberOfPreferredCinema() == numberOfCinema) {
                        prefferedCinema = cinemas.get(j);
                    }
                }

//                for (int m = 0; m < halls.length; m++) {
//                    if (prefferedCinema.getNumberOfCinema() == m) {
//                        prefferedCinema.setNumberOfCinema(m);
//                    }
//                }
                System.out.println(prefferedCinema.getNumberOfCinema());

                // Ищем, есть ли сеансы, проходящие в залах этого кинотеатра?
                Hall CurrentHall;
                List<Hall> currentHalls = new ArrayList<>();
//                            for (int hall = 0; hall < sessionHalls.size(); hall++){
//                                sessionHalls.get(hall).initHall(100);
//                                sessionHalls.get(hall).getPlaces()[0][0].initFreePlaces();
//                            }
                for (int j = 0; j < halls[prefferedCinema.getNumberOfCinema()].length; ++j) {
                    for (int k = 0; k < sessionHalls.size(); ++k) {
                        if (halls[prefferedCinema.getNumberOfCinema()][j] == sessionHalls.get(k)) {
                            CurrentHall = sessionHalls.get(k);
                            currentHalls.add(CurrentHall);
                        }
                    }
                }
                Number = 1;
                System.out.println("Available sessions: ");
                for (int session = 0; session < movieSessionHalls.size(); ++session) {
                    for (int hall = 0; hall < currentHalls.size(); hall++) {
                        if (movieSessionHalls.get(session).getMovieSession().getMovie() == movie &&
                                movieSessionHalls.get(session).getMovieSession().getSession().getDate().equals(date) &&
                                movieSessionHalls.get(session).getMovieSession().getSession().getNumberOfTickets() != 0 &&
                                movieSessionHalls.get(session).getHall() == currentHalls.get(hall)) {
                            System.out.println((Number + hall) + ". " + movie.getNameOfMovie() + " " + date + " " + movieSessionHalls.get(session).getMovieSession().getSession().getTime());
                            movieSessionHalls.get(session).getMovieSession().setNumberOfMovieSession(Number + hall);
                        }
                    }
                }
                System.out.println("Enter a number of session.");
                int numberOfMovieSession = in.nextInt();
                Hall ChoosedHall = new Hall(0, 0, 1);
                Session ChoosedSession = new Session("", "", 0);
                System.out.println("Available halls:");
                for (int j = 0; j < movieSessionHalls.size(); j++) {
                    if (movieSessionHalls.get(j).getMovieSession().getNumberOfMovieSession() == numberOfMovieSession) {
                        System.out.println("Hall " + movieSessionHalls.get(j).getHall().getNumberOfHall());
                        ChoosedHall = movieSessionHalls.get(j).getHall();
                        ChoosedSession = movieSessionHalls.get(j).getMovieSession().getSession();
                    }
                }
                System.out.println("Choose a hall, enter its number:");
                int numberOfHall = in.nextInt();
                for (int j = 0; j < prefferedCinema.HallsOfCinema.length; j++) {
                    if (prefferedCinema.HallsOfCinema[j].getNumberOfHall() == numberOfHall) {
                        prefferedCinema.HallsOfCinema[j].printHallPlan();
                    }
                }
                int choose = 0;
                while (choose != 3){
                    System.out.println("Choose a free place. Enter its row: ");
                    int rowOfPlace = in.nextInt();
                    System.out.println("Enter its number: ");
                    int numberOfPlace = in.nextInt();
                    if (ChoosedHall.getPlaces()[ChoosedHall.getNumberOfRows() - rowOfPlace][ChoosedHall.getAmountOfPlaces() / ChoosedHall.getNumberOfRows() - numberOfPlace].isOccupied() == "     ") {
                        choose += 1;
                        ChoosedSession.setNumberOfTickets(ChoosedSession.getNumberOfTickets() - 1);
                        ChoosedHall.getPlaces()[ChoosedHall.getNumberOfRows() - rowOfPlace][ChoosedHall.getAmountOfPlaces() / ChoosedHall.getNumberOfRows() - numberOfPlace].setOccupancy("occupied");
                        System.out.println("\nYour ticket costs " + ChoosedHall.getPlaces()[ChoosedHall.getNumberOfRows() - rowOfPlace][ChoosedHall.getAmountOfPlaces() / ChoosedHall.getNumberOfRows() - numberOfPlace].getPrice() + "$.");
                        System.out.println("You have to pay the money.");
                    }
                    else {
                        System.out.println("Sorry, the seat you have chosen is occuped.");
                        ChoosedHall.getPlaces()[ChoosedHall.getNumberOfRows() - rowOfPlace][ChoosedHall.getAmountOfPlaces() / ChoosedHall.getNumberOfRows() - numberOfPlace].setOccupancy("occupied");
                        ChoosedHall.printHallPlan();
                    }
                }
            }
        }
    }
}
