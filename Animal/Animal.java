public class Animal {
    private String name;
    private int energy;
    private int age;
    private Habitat habitat;

    public Animal(String name, int energy) {
        this.name = name;
        this.energy = energy;
        this.age = 0;
        this.habitat = null;
    }

    // Getters
    public String getName() { return name; }
    public int getEnergy() { return energy; }
    public int getAge() { return age; }
    public Habitat getHabitat() { return habitat; }
    
    // Setters
    public void setName(String name) { this.name = name; }
    public void setEnergy(int energy) { this.energy = energy; }
    public void setAge(int age) { this.age = age; }
    public void setHabitat(Habitat habitat) { this.habitat = habitat; }

    // Actions
    public void eat(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        energy += amount;
    }
    
    public void growOld() {
        age++;
        if (energy >= 5) {
            energy -= 5;
        } else {
            energy = 0;
        }
    }

    // Habitat methods
    public void moveTo(Habitat newHabitat) {
        if (energy >= 10) {
            this.habitat = newHabitat;
            energy -= 10;
        }
    }
    
    public void leaveHabitat() {
        this.habitat = null;
    }
    
    public boolean hasHabitat() {
        return habitat != null;
    }
    
    public String describe() {
        if (hasHabitat()) {
            return name + " (" + energy + " energy) lives in " + habitat.getType();
        } else {
            return name + " (" + energy + " energy) is homeless";
        }
    }
    
    public int calculateDailyNeeds() {
        if (habitat == null) {
            return 20; // Basic needs
        }
        
        String type = habitat.getType();
        if (type.equals("Desert")) {
            return 40;
        } else if (type.equals("Forest")) {
            return 25;
        } else if (type.equals("Savanna")) {
            return 30;
        } else {
            return 20;
        }
    }
    
    public boolean canSurvive() {
        return energy >= calculateDailyNeeds();
    }
}