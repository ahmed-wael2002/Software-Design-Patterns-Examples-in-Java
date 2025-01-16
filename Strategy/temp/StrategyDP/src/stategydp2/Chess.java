/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stategydp2;

/**
 *
 * @author ayman
 */
public class Chess {
    public int BoardW;
    public int BpoadH;
    private IDifficulty MyDifficulty;
    
    public void setDifficulty(IDifficulty MyDifficulty)
    {
        this.MyDifficulty=MyDifficulty;
    }
    public Chess()
    {
        MyDifficulty=new StrategyEasy();
    }
    public void ExecuteNextStepBasebonStrategy()
    {
        MyDifficulty.ExecuteNexxtStep();
    }
    
    public void ShowPeices()
    {}
}
