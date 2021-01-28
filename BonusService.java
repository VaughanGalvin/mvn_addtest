// это описание того, как (по какой формуле, грубо говоря) будет работать код.
// внутри класса БонусСервис лежит метод Калькулейт
// внутри метода описан сам код, выдающие в ретурне желаемый нами результат
// не выполняем этот код, это просто формула
// именно отсюда создаются тесты, тестящие заданные здесь методы
public class BonusService {
    public long calculate(long amount, boolean registered) {
        int percent = registered ? 3 : 1;
        long bonus = amount * percent / 100;
        long limit = 500;
        if (bonus > limit) {
            bonus = limit;
        }
        return bonus;
    }
}
