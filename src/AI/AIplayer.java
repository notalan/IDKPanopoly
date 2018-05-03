/*
AI will call these three functions in order,
strategise will look at the AI's balance compared to others and manage mortgaging and card use
roll will move the AI and set up anything needed for the next method
act will look at the current tile and respond accordingly
 */
package AI;

public interface AIplayer {
    void strategize();
    void roll();
    void act();
}
