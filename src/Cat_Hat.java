import net.beadsproject.beads.data.Sample;
import net.beadsproject.beads.data.SampleManager;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.Glide;
import net.beadsproject.beads.ugens.SamplePlayer;
import net.happybrackets.core.HBAction;
import net.happybrackets.core.HBReset;
import net.happybrackets.device.HB;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.invoke.MethodHandles;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Cat_Hat implements HBAction, HBReset {
    // Change to the number of audio Channels on your device
    final int NUMBER_AUDIO_CHANNELS = 1;

    // This variable will become true when the composition is reset
    boolean compositionReset = false;

    @Override
    public void action(HB hb) {
        /***** Type your HBAction code below this line ******/
        // remove this code if you do not want other compositions to run at the same time as this one
        hb.reset();
        hb.setStatus(this.getClass().getSimpleName() + " Loaded");

        //addKeyListener(this); // Trying to get this working.

        // Set volume
        Glide audioVolume = new Glide(1f);

        // Save location to audio files into variables
        final String FIRST_AUDIO_FILE = "data/audio/Cat/meow.wav";

        // Load audio files
        Sample firstSample = SampleManager.sample(FIRST_AUDIO_FILE);

        System.out.println("test test test");

        if (true) {
            // Create player for audio files
            SamplePlayer firstSamplePlayer = new SamplePlayer(firstSample);

            // Set the gain amplifier
            Gain gainAmplifier = new Gain(NUMBER_AUDIO_CHANNELS, audioVolume);
            gainAmplifier.addInput(firstSamplePlayer);
            hb.ac.out.addInput(gainAmplifier);

            System.out.println("Audio File Playing: " + FIRST_AUDIO_FILE);
            firstSamplePlayer.start();

        } else {
            hb.setStatus("Sample Failed");
        }

        System.out.println("Program is started:");


        new KeyListener() {

            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                int key = keyEvent.getKeyCode();

                switch (key) {

                }
                System.out.println("Status: Key pressed"); // Test
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                int key = keyEvent.getKeyCode();

                switch (key) {

                }
                System.out.println("Status: Key released"); // Test
            }
        };
        System.out.println("Program terminated.");

        /***** Type your HBAction code above this line ******/
    }

    private void firstSound() {

    }

    private void secondSound() {

    }

    private void thirdSound() {

    }

    private void fourthSound() {

    }

    private void fifthSound() {

    }


    /**
     * Add any code you need to have occur when a reset occurs
     */
    @Override
    public void doReset() {
        compositionReset = true;
        /***** Type your HBReset code below this line ******/

        /***** Type your HBReset code above this line ******/
    }

    //<editor-fold defaultstate="collapsed" desc="Debug Start">

    /**
     * This function is used when running sketch in IntelliJ IDE for debugging or testing
     *
     * @param args standard args required
     */
    public static void main(String[] args) {

        try {
            HB.runDebug(MethodHandles.lookup().lookupClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void keyTyped(KeyEvent e) {
//        System.out.println("Second Key Pressed!");
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        System.out.println("Second Key Released!");
//    }
    //</editor-fold>
}
