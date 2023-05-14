package me.scorchingflame.randoeffecto.Extra;

public class RanPotion {
    Effects potion;
    Integer keyNo;
    public RanPotion(Integer keyNo1, Effects potion1){
        this.potion = potion1;
        this.keyNo = keyNo1;
    }

    public Effects getPotion() {
        return potion;
    }
}
