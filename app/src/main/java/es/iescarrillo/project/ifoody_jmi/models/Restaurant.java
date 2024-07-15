package es.iescarrillo.project.ifoody_jmi.models;

public class Restaurant {
    private int image;  // Image resource ID for the restaurant
    private String name;  // Name of the restaurant

    // Default constructor
    public Restaurant() {
    }

    // Parameterized constructor to initialize image and name
    public Restaurant(int image, String name) {
        this.image = image;
        this.name = name;
    }

    // Getter method for image
    public int getImage() {
        return image;
    }

    // Setter method for image
    public void setImage(int image) {
        this.image = image;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Override toString method to provide a string representation of the Restaurant object
    @Override
    public String toString() {
        return "Restaurant{" +
                "image=" + image +
                ", name='" + name + '\'' +
                '}';
    }
}
