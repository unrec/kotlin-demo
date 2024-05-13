/*
The Interpreter pattern specifies how to evaluate sentences in a language.
The basic idea is to have a class for each symbol (terminal or non-terminal) in a specialized computer language.
The syntax tree of a sentence in the language is an instance of the Composite pattern and is used to evaluate (interpret) the sentence for a client.
 */

package com.unrec.demo.patterns.behavioral

fun main() {
    val sql = select("name, age") {
        from("users") {
            where("age > 25") {
                groupBy("age")
            }
        }
    }
    println(sql)
}

fun select(columns: String, from: SelectClause.() -> Unit): SelectClause {
    return SelectClause(columns).apply(from)
}

class SelectClause(private val columns: String) {

    private lateinit var from: FromClause

    fun from(
        table: String,
        where: FromClause.() -> Unit
    ): FromClause {
        this.from = FromClause(table)
        return this.from.apply(where)
    }

    override fun toString() = "SELECT $columns $from"
}

class FromClause(private val table: String) {

    private lateinit var where: WhereClause

    fun where(
        conditions: String,
        groupingBy: WhereClause.() -> Unit
    ): WhereClause {
        this.where = WhereClause(conditions)
        return this.where.apply(groupingBy)
    }

    override fun toString() = "\nFROM $table $where"
}

class WhereClause(private val conditions: String) {

    private var groupBy: GroupByClause? = null

    fun groupBy(grouping: String): GroupByClause {
        this.groupBy = GroupByClause(grouping)
        return this.groupBy!!
    }

    override fun toString(): String {
        return if (groupBy == null) {
            "\nWHERE $conditions"
        } else "\nWHERE $conditions $groupBy"
    }
}

class GroupByClause(private val grouping: String) {

    override fun toString() = "\nGROUP BY $grouping"
}
