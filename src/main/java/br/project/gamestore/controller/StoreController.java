package br.project.gamestore.controller;

import br.project.gamestore.Store;
import br.project.gamestore.services.StoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/gamestore")
public class StoreController {

    private StoreServices services;

    @Autowired
    public StoreController(StoreServices services) {
        this.services = services;
    }

    // Create
    @PostMapping
    public void addNewGame(@RequestBody Store store) {
        services.addNewGame(store);
    }

    // Read
    @GetMapping
    public List<Store> getGames() {
        return services.getGames();
    }

    // Update
    @PutMapping(path = "{gameID}")
    public void updateGame(@PathVariable(required = false) String name,
                           @PathVariable("gameID") Long gameID,
                           @PathVariable(required = false)Store.CategoryType categoryType) {
        services.updateGames(gameID, name, categoryType);
    }

    // Delete
    @DeleteMapping(path = "{gameID}")
    public void deleteGame(@PathVariable("gameID") Long gameID) {
        services.deleteGame(gameID);
    }
}
