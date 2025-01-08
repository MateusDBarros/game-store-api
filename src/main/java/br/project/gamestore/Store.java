package br.project.gamestore;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "inventory")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameID;

    private String name;
    private LocalDate year;

    private CategoryType category;


    public Store () {}

    public Store (Long gameID, String name, LocalDate year) {
        this.gameID = gameID;
        this.name = name;
        this.year = year;
    }

    public Store ( String name, LocalDate year) {
        this.name = name;
        this.year = year;
    }

    // Getters e Setters
    public long getGameID() {
        return gameID;
    }

    public void setGameID(long gameID) {
        this.gameID = gameID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    // Criação do ENUM para armazenar as categorias
    public enum CategoryType {
        FPS(0, "FPS"),
        ACAO(1, "AÇÂO"),
        TERROR(2, "TERROR"),
        AVENTURA(3, "AVENTURA"),
        INFANTIL(4, "INFATIL");

        private final int category;
        private final String description;

        CategoryType(int category, String description) {
            this.category = category;
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public int getCategory() {
            return category;
        }

        // Metodo para obter a categoria pelo valor numerio
        public static CategoryType getByCategory(int category) {
            for (CategoryType categoryType : values()) {
                if (categoryType.getCategory() == category) {
                    return categoryType;
                }
            }
            return null; // Para caso não encontre nenhum valor
        }

        @Override
        public String toString() {
            return "CategoryType{" +
                    "description='" + description + '\'' +
                    '}';
        }
    }


}
