import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {
// автотест - это тоже метод по сути
    // void означает, что ничего не возвращается и нам не нужно закрывать этот метод return'ом
    // скобки пусты так как метод не принимает никаких входных данных
    // внутри теста пишутся проверки - проверяются наши расчеты из Main (который ссылается на "формулу")
    // => забираем код из Main-класса и кладем в тест

    @Test
    void ShouldCalculateRegisteredUnderLim() {
        BonusService service = new BonusService();

        // подготавливаем данные, про которые мы точно знаем, что при таких данных expected будет такой
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

            // обращаемся к методу, который будет прогонять код с нашими значениями, а в скобках ссылаемся на подготовленные данные
            long actual = service.calculate(amount, registered);

            assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateRegisteredOverLim() {
        BonusService service = new BonusService();

        long amount = 1000_000;
        boolean registered = true;
        long expected = 500;


        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateUnRegisteredUnderLim() {
        BonusService service = new BonusService();


        long amount = 1000;
        boolean registered = false;
        long expected = 10;


        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateUnRegisteredOverLim() {
        BonusService service = new BonusService();


        long amount = 1000_000;
        boolean registered = false;
        long expected = 500;


        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateRegisteredTooSmall() {
        BonusService service = new BonusService();


        long amount = 10;
        boolean registered = true;
        long expected = 0;


        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateUnRegisteredTooSmall() {
        BonusService service = new BonusService();


        long amount = 10;
        boolean registered = false;
        long expected = 0;


        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test // где мы видим что при некруглых числах ждать округления 499.98 бесполезно, получишь 499
    void ShouldCalculateRegisteredStrangeAmount() {
        BonusService service = new BonusService();


        long amount = 16666;
        boolean registered = true;
        long expected = 499;


        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test // где мы видим, что по крайней мере тест падает, обрабатывая отрицательное число
    // и Мавен падает тоже, если запустить все тесты пачкой :D
    void ShouldCalculateUnRegisteredNegative() {
        BonusService service = new BonusService();

        long amount = -10_000;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

}