public class Ammo extends UpgradedWeapon{
    public Ammo(Weapon x){
        ref = x;
    }
    @override
    public int ShowWeaponPower(){
        return 50 + ref.ShowWeaponPower();
    }
}