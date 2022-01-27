public class MainMaster {

    public static void main(String[] args) {

        WordCounter tokenizer = new WordCounter();
        SplitCounter split = new SplitCounter();
        WordCounterUnbuffered tokenizerUnbuffered = new WordCounterUnbuffered();

        tokenizer.counterTokenizer();
        split.counterSplit();
        tokenizerUnbuffered.counterTokenizerUnbuffered();

    }

}