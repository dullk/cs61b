package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    private static final int N = 37;
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static GuitarString[] guitarStrings = new GuitarString[N];
    private static double getConcert(int index) {
        return 440.0 * Math.pow(2, (index - 24) / 12.0);
    }
    private static void initializeGuitarStrings() {
        for (int i = 0; i < N; i += 1) {
            guitarStrings[i] = new GuitarString(getConcert(i));
        }
    }
    private static double getSample() {
        double sample = 0.0;
        for (int i = 0; i < N; i += 1) {
            sample += guitarStrings[i].sample();
        }
        return sample;
    }
    private static void stringTic() {
        for (int i = 0; i < N; i += 1) {
            guitarStrings[i].tic();
        }
    }
    private static void stringPluck(int index) {
        guitarStrings[index].pluck();
    }

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        initializeGuitarStrings();
        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);
                if (index == -1) {
                    continue;
                }
                stringPluck(index);
            }

            /* compute the superposition of samples */
            double sample = getSample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            stringTic();
        }
    }
}
