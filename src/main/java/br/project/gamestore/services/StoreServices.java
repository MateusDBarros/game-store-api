package br.project.gamestore.services;

import br.project.gamestore.Store;
import br.project.gamestore.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StoreServices {
    private final StoreRepository repository;

    @Autowired
    public StoreServices(StoreRepository repository) {
        this.repository = repository;
    }

    // Cria novos games
    public void addNewGame(Store store) {
        // Tratamento de exceções
        if (store.getName() == null || store.getName().isEmpty())
            throw new IllegalStateException("Pease, a name is required!");

        if (store.getYear() == null )
            throw new IllegalStateException("Pease, released date is required!");

        if (store.getCategory() == null)
            throw new IllegalStateException("Please, a valid category is required!");

        repository.save(store);
    }

    // Lista todos os games
    public List<Store> getGames() {
        return repository.findAll();
    }

    // Atualiza os games
    public void updateGames (Long gameID, String name, Store.CategoryType categoryType) {
    Store store = repository.findById(gameID)
            .orElseThrow(() -> new IllegalStateException("Game ID: " +gameID+ " does not exist."));

    if (name != null && !name.trim().isEmpty() && !Objects.equals(store.getName(), name))
        store.setName(name);

    if (categoryType != null && store.getCategory() != categoryType)
        store.setCategory(categoryType);

    repository.save(store);
    }

    // Deleta um game
    public void deleteGame(Long gameID) {
        boolean exist = repository.existsById(gameID);
        if(!exist)
            throw new IllegalStateException("Game ID: " +gameID+ "does not exist");

        repository.deleteById(gameID);
        System.out.println("Game ID: " +gameID+ " was deleted successufully");
    }
}
