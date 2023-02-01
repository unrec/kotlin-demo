package com.unrec.demo.koans.introduction

fun main() {
    val message = "Test Message"
    val sender = MessageSender()
    val personalInfo = PersonalInfo("abc@xyz.com")
    val client = Client(personalInfo)

    sendMessageToClient(client, message, sender)
}

fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    val email = client?.personalInfo?.email
    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }
}

class Client(val personalInfo: PersonalInfo?)

class PersonalInfo(val email: String?)

class MessageSender : Mailer {
    override fun sendMessage(email: String, message: String) {
        println("Message '$message' is send from $email")
    }
}

interface Mailer {
    fun sendMessage(email: String, message: String)
}

//Java code

//public void sendMessageToClient(
//@Nullable Client client,
//@Nullable String message,
//@NotNull Mailer mailer
//) {
//    if (client == null || message == null) return;
//
//    PersonalInfo personalInfo = client.getPersonalInfo();
//    if (personalInfo == null) return;
//
//    String email = personalInfo.getEmail();
//    if (email == null) return;
//
//    mailer.sendMessage(email, message);
//}
