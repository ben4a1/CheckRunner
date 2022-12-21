
Используемый стек:

    PostgreSQL
    Lombok
    Spring Boot
    система сборки - gradle 7.5

Для запуска приложения:

    запустить main() метод в CheckApplication class с набором параметров вида "'x'-'y' 3-1 2-5 5-1 card-'W'", где 'x' - id продука, 'y' - количество товара 'x', 'W' - номер скидочной карты (от 1 до 4).

Для смены источника прайса (файл или база данных):

    в конструкторе OrderServiceImpl сменить параметр на filePriceReader или dbPriceReader соответственно.


Для смены вывода чека (консоль или файл):
    
    в конструкторе Processor сменить параметр на consolePriceReader или fiePriceReader соответственно.