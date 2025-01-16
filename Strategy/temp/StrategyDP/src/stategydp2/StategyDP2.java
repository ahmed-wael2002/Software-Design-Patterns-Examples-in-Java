/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stategydp2;

/**
 *
 * @author ayman
 */
public class StategyDP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Chess mychess=new Chess();
       // mychess.ExecuteNextStepBasebonStrategy();
        mychess.setDifficulty(new StrategyHard());
        mychess.ExecuteNextStepBasebonStrategy();
        mychess.setDifficulty(new StrategySuperHero());
        mychess.ExecuteNextStepBasebonStrategy();
    }
    
}
