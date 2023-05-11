package me.scorchingflame.randoeffecto.Extra;

import org.bukkit.potion.PotionEffectType;

public class Effects {
    private final Integer id;
    private final PotionEffectType potionEffectType;
    private final boolean customEffect;
    private final Integer amplifier;
    private final Integer duration;
    // TODO: Make the storage as json with the help of GSON and use the variable like Map<Player, List<Effects>> and save it
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

    public Integer getId() {
        return id;
    }

    public PotionEffectType getPotionEffectType() {
        return potionEffectType;
    }

    public boolean isCustomEffect() {
        return customEffect;
    }

    public Integer getAmplifier() {
        return amplifier;
    }

    public Integer getDuration() {
        return duration;
    }
}
