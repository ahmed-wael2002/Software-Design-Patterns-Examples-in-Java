public static void main(String [] args){
    // Cannot instantiate an abstract class, cannot reserve memory for it
    // Cannot instantiate abstract class, interface, sealed class
    Weapon myweapon;
    myweapon = new Klashinkoff();
    println("Klashinkoff Power: " + x.ShowWeaponPower());
    // You can use myweapon pointer in all attachments
    
    // Adding attachments
    Scope scope = new Scope(Ak47);
    int z = scope.ShowWeaponPower();
    println("Klashinkoff Power: " + x);
    // Adding ammo
    Ammo ammo = new Am+mo(scope);
    println("Klashinkoff + Scope + Ammo: " + ammo.ShowWeaponPower());

    // Adding new upgrade - Arm upgrade 
    // Upgrades are made with no modifications to any other class 
    Arm arm = new Arm(ammo);
    println("Klashinkoff + Scope + Ammo + Arm: " + arm.ShowWeaponPower());

}