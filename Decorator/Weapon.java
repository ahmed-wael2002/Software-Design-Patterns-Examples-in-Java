public abstract class Weapon{
    // Interfaces couldn't contain variables
    public int power;
    public abstract int ShowWeaponPower();
    public void buyWeapon(){
        System.out.println("Che Ching!");
    }
}