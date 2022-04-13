package pl.edu.pg.eti.kask.rpg.character.view;

import pl.edu.pg.eti.kask.rpg.character.entity.Character;
import pl.edu.pg.eti.kask.rpg.character.entity.Profession;
import pl.edu.pg.eti.kask.rpg.character.service.CharacterService;
import pl.edu.pg.eti.kask.rpg.character.service.ProfessionService;
import pl.edu.pg.eti.kask.rpg.view.View;

import java.util.Scanner;

/**
 * View for adding new characters. Stats fields are omitted because of being lazy.
 */
public class CharacterAdd implements View {

    /**
     * Characters managing service.
     */
    private final CharacterService characterService;

    /**
     * Professions managing service.
     */
    private final ProfessionService professionService;

    /**
     * @param characterService  characters managing service
     * @param professionService professions managing service
     */
    public CharacterAdd(CharacterService characterService, ProfessionService professionService) {
        this.characterService = characterService;
        this.professionService = professionService;
    }

    @Override
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("background: ");
        String background = scanner.nextLine();
        System.out.print("profession: ");
        String profession = scanner.nextLine();

        Profession professionEntity = professionService.find(profession);
        if (professionEntity == null) {
            System.out.println("Wrong profession");
        } else {
            characterService.create(Character.builder()
                    .name(name)
                    .background(background)
                    .profession(professionEntity)
                    .build());
        }
    }

}
