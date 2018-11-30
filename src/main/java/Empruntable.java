public class Empruntable {
    private boolean limitationPretAuxAgences;
    private boolean defectueux;

    public Empruntable()
    {
        limitationPretAuxAgences = false;
        defectueux = false;
    }
    public void declarerDefectueux()
    {
        defectueux = false;
    }
    public boolean isDefectueux()
    {
        return defectueux;
    }

    public boolean isLimitationPretAuxAgences() {
        return limitationPretAuxAgences;
    }
    public void setLimitationPretAuxAgences(boolean limitation)
    {
        limitationPretAuxAgences = limitation;
    }
}
