public class Arm extends UpgradedWeapon{
    // We have added a new upgrade without touching the 
    // Weapon class (Klashinkoff) 

    public Arm(Weapon ref){
        this.ref = ref;
    }

    @override
    public int ShowWeaponPower(){
        return 30 + ref.ShowWeaponPower();
    }
}