package pl.edu.pg.eti.kask.rpg.character.controller;

import pl.edu.pg.eti.kask.rpg.character.entity.Character;
import pl.edu.pg.eti.kask.rpg.character.service.CharacterService;
import pl.edu.pg.eti.kask.rpg.controller.SocketController;

/**
 * Controller for providing heroes data.
 */
public class CharacterSocketController implements SocketController {

    /**
     * Service for managing characters.
     */
    private final CharacterService service;

    /**
     * @param service service for managing characters
     */
    public CharacterSocketController(CharacterService service) {
        this.service = service;
    }

    @Override
    public String prepareResponse(String uri) {
        StringBuilder response = new StringBuilder();
        for (Character character : service.findAllCharacters()) {
            response.append(character.toString()).append("\n");
        }
        return response.toString();
    }

    @Override
    public boolean accepts(String uri) {
        return "/characters/".equals(uri);
    }

}
