package engine;

import race.Human;

public class Linker {

    public void linkModules() {
        CharacterCreator characterCreator = new CharacterCreator();
        Battleground battleground = new Battleground(characterCreator);
        characterCreator.createChar();
        battleground.Test(characterCreator);
        for (int i = 0; i < characterCreator.getCharList().size(); i++){
            if (characterCreator.getCharList().get(i) instanceof Human){
                ((Human) characterCreator.getCharList().get(i)).getName();
            }
        }
    }
}
