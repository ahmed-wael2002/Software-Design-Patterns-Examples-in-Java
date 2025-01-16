public class Scope extends UpgradedWeapon{
    // Weapon ref is inherited from UpgradeWeapon\
    public Scope(Weapon x){
        ref = x;
    }

    @override
    public int ShowWeaponPower(){
        return 10 + ref.ShowWeaponPower();
    }
}