package me.scorchingflame.randoeffecto.Extra;

import org.bukkit.potion.PotionEffectType;

public class Effects {
    Integer id;
    PotionEffectType potionEffectType;
    boolean customEffect;
    Integer amplifier;
    Integer duration;

    public Effects(Integer id, PotionEffectType potionEffectType, Integer amplifier){
        this.id = id;
        this.potionEffectType = potionEffectType;
        this.amplifier = amplifier;
        this.duration = -1;
        this.customEffect = false;
    }

    public Effects(Integer id, PotionEffectType potionEffectType, Integer amplifier, Integer duration){
        this.id = id;
        this.potionEffectType = potionEffectType;
        this.amplifier = amplifier;
        this.duration = duration;
        this.customEffect = false;
    }

    public Effects(Integer id, Integer amplifier, Integer duration){
        this.id = id;
        this.potionEffectType = null;
        this.amplifier = amplifier;
        this.duration = duration;
        this.customEffect = true;
    }

    public Effects(Integer id, Integer amplifier){
        this.id = id;
        this.potionEffectType = null;
        this.amplifier = amplifier;
        this.duration = -1;
        this.customEffect = true;
    }
}
