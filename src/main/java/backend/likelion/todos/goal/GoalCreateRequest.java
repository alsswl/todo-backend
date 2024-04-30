package backend.likelion.todos.goal;

public record GoalCreateRequest(
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
