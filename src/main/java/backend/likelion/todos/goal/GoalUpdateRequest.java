package backend.likelion.todos.goal;

public record GoalUpdateRequest(
        String name,
        String color
) {
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
