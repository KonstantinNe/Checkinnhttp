public class NegativeException extends Exception {

    /**
     * в целом структура проекта опять нарушена. где каталоги. сложи
     * все классы эксепшенов в отдельный каталог
     * если в проекте будет больше сотни классов
     * все в одной кучи очень не удобно
     * @param message
     */
    public NegativeException (String message) {
        super(message);
    }
}
