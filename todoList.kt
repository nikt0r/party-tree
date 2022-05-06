package pl.polciuta.tescik.patterns

interface TodoItem {
    fun getTodo(): String
}

class SingleTodo(private val todoText: String) : TodoItem {

    override fun getTodo(): String {
        return "- $todoText\n"
    }

}

class TodoCollection(private val title: String, private val todos: List<TodoItem>) : TodoItem {

    override fun getTodo(): String {

        var returnString = "*** $title ***\n"

        todos.forEach {
            returnString += "- ${it.getTodo()}"
        }

        return "- $returnString"

    }
}

fun main() {

    val todoList: List<TodoItem> = listOf(

        SingleTodo("item 1"),
        SingleTodo("item 2"),
        SingleTodo("item 3"),
        TodoCollection(
            "Collection 1", listOf(
                SingleTodo("coll1 item 1"),
                SingleTodo("coll1 item 2"),
                TodoCollection(
                    "Collection inside", listOf(
                        SingleTodo("item A"),
                        SingleTodo("item B"),
                        SingleTodo("item C")
                    )
                ),
                SingleTodo("coll1 item 3")
            )
        ),
        SingleTodo("item 4"),
        SingleTodo("item 5"),
        TodoCollection(
            "Collection 2", listOf(
                SingleTodo("coll2 item 1"),
                SingleTodo("coll2 item 2"),
                SingleTodo("coll2 item 3")
            )
        ),
        SingleTodo("item 6")
    )

    todoList.forEach {
        print(it.getTodo())
    }

}