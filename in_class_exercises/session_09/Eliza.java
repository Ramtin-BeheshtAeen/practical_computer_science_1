import java.util.Random;

/**
 * Texte entnommen aus dem Programm von Akshat Singhal, zu finden unter
 * http://simple-semantic-desktop.googlecode.com/svn-history/r4/trunk/Progs2/Eliza/eliza.java
 */
class Eliza
{
    private final String[] starters = {
        "What's on your mind?",
        "Let's talk.",
        "I'm listening."
    };

    private final String[][] replacements = {
        {"I", "you"}, {"me", "you"}, {"am", "are"}, {"my", "your"}
    };

    private final String[][][] topics = {
      {{"always"}, {"Can you think of a specific example?"}},
      {{"because"}, {"Is that the real reason?"}},
      {{"sorry"}, {"Please don't apologize."}},
      {{"maybe"}, {"You don't seem very certain."}},
      {{"think"}, {"Do you really think so?"}},
      {{"you", "your"}, {"We were discussing you, not me."}},
      {{"yes"}, {"Why do you think so?", "You seem quite positive."}},
      {{"no", "not"}, {"Why not?", "Are you sure?"}},
      {{"am"}, {"I am sorry to hear you are*.", "How long have you been*?",
                         "Do you believe it is normal to be*?"}},
      {{"feel"}, {"Tell me more about such feelings.", "Do you often feel*?",
                    "Do you enjoy feeling*?", "Why do you feel that way?"}},
      {{"family", "mother", "father", "mom", "dad", "sister", "brother", "husband", "wife"},
              {"Tell me more about your family.", "How do you get along with your family?",
               "Is your family important to you?"}},
      {{"dream", "nightmare"},
              {"What does that dream suggest to you?",
               "Do you dream often?",
               "What persons appear in your dreams?",
               "Are you disturbed by your dreams?"}},
      {{"???"}, {"What does that suggest to you?", "I see.",
                 "I'm not sure I understand you fully.", "Can you elaborate?",
                 "That is quite interesting."}}
    };
    
    private Random random = new Random();

    /**
     * Antworte auf einen Satz der Patientin.
     * @param sentence Der Satz, der untersucht wird.
     * @return Die passende Antwort.
     */
    String respondTo(final String sentence)
    {
        if (sentence.trim().length() == 0){
            System.out.println(starters.length);
            System.out.println(random.nextInt(starters.length));
            return starters[random.nextInt(starters.length)];
            
        }
        final String[] words = sentence.split(" ");
        return remainingSentence(words, 0);
    }


    /**
     * Fasse die Wörter ab einer bestimmten Stelle wieder zu einem Satz zusammen
     * und tausche ersten und zweiten Fall aus.
     * @param words Die Wörter des Satzes.
     * @param start Der Index des ersten Worts, ab dem der Satz wieder zusammengebaut wird.
     */
    private String remainingSentence(final String[] words, final int start ){
        String sentence = "";
        for (int i = start; i < words.length; i++){
            sentence += getReplacement(words[i]);
        }
        return sentence;
    }

    /**
     * Ersetze ein Wort durch ein anderes, wenn es einen Ersatz gibt.
     * @param word Das Wort, dass ersetzt werden soll.
     * @return Das Ersatzwort, wenn es gefunden wurde. Ansonsten das Ursprungswort.
     */
    private String getReplacement(final String word){
        for(final String[] replacement : replacements) {
            if(word.equals( replacments[0])){
            }
        }
        return word;
    }
}
