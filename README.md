
Используемый стек:

    PostgreSQL
    Lombok
    Spring Boot
    junit
    Mockito
    система сборки - gradle 7.5

Для запуска приложения:

    - использовать систему для автоматизации сборки приложений gradle (task: build). 
    - в командной строке ввести 'java -jar build/libs/check-runnerV2-1.0-SNAPSHOT.jar x-y ... x-y card-w' с набором параметров вида "'x'-'y' ... 'x'-'y' card-'w'", где 'x' - id продука, 'y' - количество товара 'x', 'w' - номер скидочной карты (от 1 до 4).

Для смены источника прайса (файл или база данных):

    в конструкторе OrderServiceImpl сменить параметр на filePriceReader или dbPriceReader соответственно.


Для смены вывода чека (консоль или файл):
    
    в конструкторе Processor сменить параметр на consolePriceReader или fiePriceReader соответственно.