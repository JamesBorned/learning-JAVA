# Мой знакомый - владелец сети кинотеатров.

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