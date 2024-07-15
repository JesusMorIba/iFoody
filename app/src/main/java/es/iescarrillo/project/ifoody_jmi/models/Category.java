package es.iescarrillo.project.ifoody_jmi.models;

public class Category {
    private int image;  // Image resource ID for the category
    private String name;  // Name of the category

    // Default constructor
    public Category() {
    }

    // Parameterized constructor to initialize image and name
    public Category(int image, String name) {
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

    // Override toString method to provide a string representation of the Category object
    @Override
    public String toString() {
        return "Category{" +
                "image=" + image +
                ", name='" + name + '\'' +
                '}';
    }
}
