/*
The Command pattern intends to encapsulate in an object all the data required for performing a given action (command),
including what method to call, the method's arguments, and the object to which the method belongs.
 */

package com.unrec.demo.patterns.behavioral

typealias Command = () -> Unit

fun main() {
    val editor = TextEditor()
    editor.addCommand(append(editor, "Hello, World!\n"))
    editor.addCommand(append(editor, "This is Jane Doe."))
    editor.addCommand(replace(editor, "Jane", "John"))
    editor.executeCommands()
    editor.display()
}

class TextEditor {
    private var content: String = ""

    private val commands = mutableListOf<Command>()

    fun addCommand(command: Command) = this.commands.add(command)

    fun executeCommands() {
        while (commands.isNotEmpty()) {
            val command = commands.removeFirst()
            command.invoke()
        }
    }

    // actual actions that can be performed

    fun display() = println(content)

    fun append(text: String) {
        content += text
    }

    fun replace(text: String, replacement: String) {
        content = content.replace(text, replacement)
    }
}


val append = fun(receiver: TextEditor, text: String): Command = fun() { receiver.append(text) }

val replace = fun(receiver: TextEditor, text: String, replacement: String): Command =
    fun() { receiver.replace(text, replacement) }
