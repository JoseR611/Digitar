public class Digitar
{
    /**
     * Allows the "a" and "c"  key to be used to play a sound of a certain note and pitch
     * @param None
     * @return Void
     */
    public static void keyboardLite(){
        //create two guitar strings, for concert A and C
        double CONCERT_A = 440.0;
        double CONCERT_C = CONCERT_A * Math.pow(1.05956, 3.0);
        InstrumentString stringA = new InstrumentString(CONCERT_A);
        InstrumentString stringC = new InstrumentString(CONCERT_C);
        while(true){//infinite loop: on purpose!
            //check if the user has typed a kay; if so process it
            if(StdDraw.hasNextKeyTyped()){
                char key = StdDraw.nextKeyTyped();
                if(key == 'a'){
                    stringA.pluck();
                }else if (key == 'c'){
                    stringC.pluck();
                }
            }
            //compute the superposition of samples
            double sample = stringA.sample() + stringC.sample();
            //play the sample on standard audio
            StdAudio.play(sample);
            //advance the simulation of each guitar string by one step
            stringA.tic();
            stringC.tic();
        }
    }
    /**
     * Allows a certain number of keys to be used a notes with different pitches
     * @param None
     * @return Void
     */
    public static void keyboard(){
        String keyKeyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        InstrumentString[] keyboard = new InstrumentString[keyKeyboard.length()];
        double sample = 0;
        boolean a = false;
        for(int j = 0; j < keyKeyboard.length(); j++){
            keyboard[j] = new InstrumentString(440 * Math.pow(1.05956, j - 24));
        }
        while(true){
            char key = '1';
            if(StdDraw.hasNextKeyTyped()){
                key = StdDraw.nextKeyTyped();
                for(int i = 0; i < keyKeyboard.length(); i++){
                    if(key == keyKeyboard.charAt(i)){
                        keyboard[i].pluck();
                        i = keyKeyboard.length();
                    }
                }
                a = true;
            }
            sample = 0.0;
            for(int k = 0; k < keyKeyboard.length(); k++){
                sample = sample + keyboard[k].sample();
                keyboard[k].tic();
            }
            
            StdAudio.play(sample);
            if(a){
            System.out.println(sample);
            a = false;
            }
        }
        
    }
    /**
     * Using an array of Strings as a parameter, notes are played based on what and how many characters are
     * in each element of the array
     * @param notes is a array of Strings, used to deteremine which notes will be played together
     * @return Void
     */
    public static void keyboardAuto(String[] notes){
        int count = 0;
        int pick = 0;
        String note = "";
        String keyKeyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        InstrumentString[] keyboard = new InstrumentString[keyKeyboard.length()];
        for(int j = 0; j < keyKeyboard.length(); j++){
            keyboard[j] = new InstrumentString(440 * Math.pow(1.05956, j - 24));
        }
        double sample = 0;
        while(true){
            if(count % 57000 == 0 && pick < notes.length){
                String key = notes[pick];
                for(int i = 0; i < key.length(); i++){
                    for(int l = 0; l < keyKeyboard.length(); l++){
                        if(key.charAt(i) == keyKeyboard.charAt(l)){
                            keyboard[l].pluck();
                            l = keyKeyboard.length();
                            
                        }
                    }
                }
                note = note + key;
                System.out.println(note);
                note = "";
                pick++;
                System.out.println(pick - 1);
            }
            sample = 0.0;
            for(int k = 0; k < keyKeyboard.length(); k++){
                sample = sample + keyboard[k].sample();
                keyboard[k].tic();
            }  
            StdAudio.play(sample);
            if(count % 40000 == 0){
                System.out.println(sample);
            }
            count++;
        }
    }
    /**
     * Reads a text file and based on the characters in it, creates a melody by calling keyboardAuto
     * @param None
     * @return Void
     */
    public static void keyboardIn(){
        In inFile = new In("song.txt");
        String[] in = inFile.readAllLines();
        for(int i = 0; i < in.length; i++){
            in[i] = in[i].toLowerCase();
        }
        keyboardAuto(in);
    }
}
