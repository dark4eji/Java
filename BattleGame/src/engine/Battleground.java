package engine;

public class Battleground {
    CharacterCreator creator;

    public Battleground(CharacterCreator creator){
        this.creator = creator;
    }

    public void Test(CharacterCreator creator){
        System.out.println(creator.getCharList());
        }
    }

