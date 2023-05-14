package me.scorchingflame.randoeffecto.Extra;


public class Effects {
    private Integer id;
    private String potionEffectType;
    private boolean customEffect;
    private Integer amplifier;
    private Integer duration;
    private Integer type = null;
    // TODO: Make the storage as json with the help of GSON and use the variable like Map<Player, List<Effects>> and save it
    public Effects(Integer id, String potionEffectType, Integer amplifier){
        this.id = id;

        this.potionEffectType = potionEffectType;
        this.amplifier = amplifier;
        this.duration = -1;
        this.customEffect = false;
        if (id <= 20){
            this.type = 1;
        }else {
            this.type = 2;
        }
    }

    public Effects(Integer id, String potionEffectType, Integer amplifier, Integer duration){
        this.id = id;
        this.potionEffectType = potionEffectType;
        this.amplifier = amplifier;
        this.duration = duration;
        this.customEffect = false;
        if (id <= 20){
            this.type = 1;
        }else {
            this.type = 2;
        }
    }

    public Effects(Integer id, Integer amplifier, Integer duration){
        this.id = id;
        this.potionEffectType = null;
        this.amplifier = amplifier;
        this.duration = duration;
        this.customEffect = true;
        if (id <= 20){
            this.type = 1;
        }else {
            this.type = 2;
        }
    }

    public Integer getType() {
        return type;
    }

    public Effects(Integer id, Integer amplifier){
        this.id = id;
        this.potionEffectType = null;
        this.amplifier = amplifier;
        this.duration = -1;
        this.customEffect = true;
        if (id <= 20){
            this.type = 1;
        }else {
            this.type = 2;
        }
    }

    public Integer getId() {
        return id;
    }

    public String getPotionEffectType() {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPotionEffectType(String potionEffectType) {
        this.potionEffectType = potionEffectType;
    }

    public void setCustomEffect(boolean customEffect) {
        this.customEffect = customEffect;
    }

    public void setAmplifier(Integer amplifier) {
        this.amplifier = amplifier;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
