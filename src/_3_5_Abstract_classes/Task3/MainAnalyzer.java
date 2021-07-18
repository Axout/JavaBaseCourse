package _3_5_Abstract_classes.Task3;

/*
Представим, вы делаете систему фильтрации комментариев на каком-то веб-портале, будь то новости или видео-хостинг.
Вы хотите фильтровать комментарии по разным критериям, уметь легко добавлять новые фильтры и модифицировать старые.
Допустим, мы будем фильтровать спам, комментарии с негативным содержанием и слишком длинные комментарии.
Спам будем фильтровать по наличию указанных ключевых слов в тексте.
Негативное содержание будем определять по наличию одного из трех смайликов – :( =( :|
Слишком длинные комментарии будем определять исходя из данного числа – максимальной длины комментария.

*Используйте, пожалуйста, модификатор доступа по-умолчанию для всех классов.
 */

public class MainAnalyzer {
    public static void main(String[] args) {
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        // для тестирования checkLabels() создается экземпляр класса, так как checkLabels() по заданию не-static
        MainAnalyzer testObject = new MainAnalyzer();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
    }

    /*
    Последний штрих – написать метод checkLabels, который будет возвращать метку для комментария по набору анализаторов текста.
    checkLabels должен возвращать первую не-OK метку в порядке данного набора анализаторов,
    и OK, если все анализаторы вернули OK.
    */
    public Label checkLabels(TextAnalyzer[] textAnalyzers, String str) {
        for (TextAnalyzer tA: textAnalyzers) {
            if (tA.processText(str) != Label.OK) return tA.processText(str);
        }
        return Label.OK;
    }
}

// Label – тип-перечисление, которые содержит метки, которыми будем помечать текст:
enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

// Вы решили абстрагировать фильтр в виде следующего интерфейса:
interface TextAnalyzer {
    Label processText(String str);
}

// если число символов превышает заданное (maxLength), то такой комментарий считается длинным
class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String str) {
        if (str.length() > maxLength) return Label.TOO_LONG;
        else return Label.OK;
    }
}

/*
SpamAnalyzer и NegativeTextAnalyzer во многом похожи – они оба проверяют текст на наличие каких-либо ключевых слов
(в случае спама мы получаем их из конструктора, в случае негативного текста мы заранее знаем набор грустных смайликов)
и в случае нахождения одного из ключевых слов возвращают  Label (SPAM и NEGATIVE_TEXT соответственно),
а если ничего не нашлось – возвращают OK.
Давайте эту логику абстрагируем в абстрактный класс KeywordAnalyzer следующим образом:
    1) Выделим два абстрактных метода getKeywords и getLabel, один из которых будет возвращать набор ключевых слов,
       а второй метку, которой необходимо пометить положительные срабатывания.
       Нам незачем показывать эти методы потребителям классов, поэтому оставим доступ к ним только для наследников.
    2) Реализуем processText таким образом, чтобы он зависел только от getKeywords и getLabel.
    3) Сделаем SpamAnalyzer и NegativeTextAnalyzer наследниками KeywordAnalyzer и реализуем абстрактные методы.

 */
abstract class KeywordAnalyzer implements TextAnalyzer{
    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    @Override
    public Label processText(String str) {
        for (String keyWord: getKeywords()) {
            if (str.contains(keyWord)) return getLabel();
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() { return Label.SPAM; }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords = {":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}